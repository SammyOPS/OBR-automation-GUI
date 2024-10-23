package com.onbis.Helper;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.Thread;
import com.google.api.services.gmail.model.*;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.testng.Reporter;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils {
    private static final String APPLICATION_NAME = "onbisAutomation";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String USER_ID = "me";
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
    private static final String CREDENTIALS_FILE_PATH =
            System.getProperty("user.dir") +
                    File.separator + "src" +
                    File.separator + "main" +
                    File.separator + "resources" +
                    File.separator + "credentials" +
                    File.separator + "credentials.json";

    private static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.dir") +
            File.separator + "src" +
            File.separator + "main" +
            File.separator + "resources" +
            File.separator + "credentials";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = new FileInputStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(9999).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public static Gmail getService() throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        return service;
    }

    public static List<Message> listMessagesMatchingQuery(Gmail service, String userId,
                                                          String query) throws IOException {
        ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();
        List<Message> messages = new ArrayList<Message>();
        while (response.getMessages() != null) {
            messages.addAll(response.getMessages());
            if (response.getNextPageToken() != null) {
                String pageToken = response.getNextPageToken();
                response = service.users().messages().list(userId).setQ(query)
                        .setPageToken(pageToken).execute();
            } else {
                break;
            }
        }
        return messages;
    }

    public static Message getMessage(Gmail service, String userId, List<Message> messages, int index)
            throws IOException {
        Message message = service.users().messages().get(userId, messages.get(index).getId()).execute();
        return message;
    }

    public static List<Gmail.Users.Messages.Attachments> getAttachments(Gmail service, String userId, List<Message> messages, int index)
            throws IOException {
        List<Gmail.Users.Messages.Attachments> attachments = new ArrayList<>();

        Message message = service.users().messages().get(userId, messages.get(index).getId()).execute();

        List<MessagePart> parts = message.getPayload().getParts();

        if (message.getPayload().getBody().size() > 0 & parts != null) {
//            if (parts != null) {
            for (MessagePart part : parts) {

                if (part.getFilename() != null && part.getFilename().length() > 0) {
                    String attId = part.getBody().getAttachmentId();
                    MessagePartBody attachPart = service.users().messages().attachments().
                            get(userId, messages.get(index).getId(), attId).execute();

                    JsonPath jp = new JsonPath(attachPart.toString().replace(' ', '+').replace('_', '/').replace('-', '+'));
                    System.out.println("Encrypted message attachment is: " + attachPart);

                    String attachmentDetails = new String(Base64.getUrlDecoder().decode(jp.getString("data")));
                    System.out.println("Decrypted Message attachment is: " + attachmentDetails);

//                        byte[] fileByteArray = Base64.getMimeDecoder().decode(attachPart.getData());
//                        Attachment attachment = new Attachment(part, attachPart, fileByteArray);
//                        attachments.add(attachmentDetails);
//                        System.out.println("Decrypted attachment is: " + fileByteArray);
                }
            }
        }
        return attachments;
    }


    public static HashMap<String, String> getGmailData(String query) {
        try {
            Gmail service = getService();
            List<Message> messages = listMessagesMatchingQuery(service, USER_ID, query);
            Message message = getMessage(service, USER_ID, messages, 0);
            JsonPath jp = new JsonPath(message.toString());
//            System.out.println("decoded message is: " + message);
            String subject = jp.getString("payload.headers.find { it.name == 'subject' }.value");
            String body = new String(Base64.getMimeDecoder().decode(jp.getString("payload.parts[0].parts[0].parts[0].body.data")));

            String transactionNumber = null;
            String arr[] = body.split("\n");
            for (String s : arr) {
                s = s.trim();
                if (s.startsWith("Transaction Number: ")) {
                    transactionNumber = s.trim().replace("Transaction Number: ", "");
                }
            }

            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("subject", subject);
            hm.put("transaction", transactionNumber);
            hm.put("body", body);
            return hm;
        } catch (Exception e) {
            System.out.println("email not found....");
            throw new RuntimeException(e);
        }
    }

//    public static HashMap<String, String> getGmailDataTest(String query) {
//        try {
//            Gmail service = getService();
//            List<Message> messages = listMessagesMatchingQuery(service, USER_ID, query);
//            Message message = getMessage(service, USER_ID, messages, 0);
//            JsonPath jp = new JsonPath(message.toString());
////            System.out.println("encoded message is: " + message);
//            String subject = jp.getString("payload.headers.find { it.name == 'subject' }.value");
//            String body = new String(Base64.getUrlDecoder().decode(jp.getString("payload.parts[0].parts[0].parts[0].body.data")));
//
//            List<Gmail.Users.Messages.Attachments> attachments = getAttachments(service, USER_ID, messages, 0);
//
//            System.out.println("Attachment details are : " + attachments);
//
//
//            String transactionNumber = null;
//            String arr[] = body.split("\n");
//            for (String s : arr) {
//                s = s.trim();
//                if (s.startsWith("Transaction Number: ")) {
//                    transactionNumber = s.trim().replace("Transaction Number: ", "");
//                }
//            }
//
//            HashMap<String, String> hm = new HashMap<String, String>();
//            hm.put("subject", subject);
//            hm.put("transaction", transactionNumber);
//            hm.put("body", body);
//            return hm;
//        } catch (Exception e) {
//            System.out.println("email not found....");
//            throw new RuntimeException(e);
//        }
//    }


    public static int getTotalCountOfMails() {
        int size;
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            List<Thread> threads = service.
                    users().
                    threads().
                    list("me").
                    execute().
                    getThreads();
            size = threads.size();
        } catch (Exception e) {
            System.out.println("Exception log " + e);
            size = -1;
        }
        return size;
    }

    public static boolean isMailSubjectExist(String messageTitle) {
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            ListMessagesResponse response = service.
                    users().
                    messages().
                    list("me").
                    setQ("subject:" + messageTitle).
                    execute();
            List<Message> messages = getMessages(response);
            return messages.size() != 0;
        } catch (Exception e) {
            System.out.println("Exception log" + e);
            return false;
        }
    }

    public static boolean isMailAttachmentExist(String attachmentName) {
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            ListMessagesResponse response = service.
                    users().
                    messages().
                    list("me").
                    setQ("filename:" + attachmentName).
                    execute();
            List<Message> messages = getMessages(response);
            return messages.size() != 0;
        } catch (Exception e) {
            System.out.println("Exception log" + e);
            return false;
        }
    }
// +++++++++++++++++++++++
public static void check(String host, String storeType, String user,
                         String password, String subject) {

    try {

        //create properties field
        Properties properties = new Properties();

//        properties.put("mail.store.protocol", "imap");
//        properties.put("mail.imap.host", "outlook.office365.com");
//        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.imap.starttls.enable", "true");
        properties.put("mail.imap.auth", "true");
        properties.put("mail.imap.auth.mechanisms", "XOAUTH2");
//        properties.put("mail.imap.user", user);
//        properties.put("mail.debug", "true");
        properties.put("mail.debug.auth", "true");



        //      props.setProperty("mail.imaps.host", "imap.gmail.com");
        //       props.setProperty("mail.imaps.user", gmailUsername);
        //      props.setProperty("mail.imaps.password", password);


        properties.setProperty("mail.imaps.port", "993");
        properties.setProperty("mail.imaps.auth", "true");
        properties.setProperty("mail.debug", "true");


        properties.put("mail.imaps.host", host);
        properties.put("mail.imaps.port", "993");
        properties.put("mail.imaps.starttls.enable", "true");
        properties.put("mail.imaps.ssl.trust", "*");
        properties.setProperty("mail.store.protocol", "imaps");
        properties.setProperty("mail.debug", "true");
        Session emailSession = Session.getDefaultInstance(properties);
        Store store = emailSession.getStore();

        store.connect(host, 993, user, password);

        //create the folder object and open it
        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);

        // retrieve the messages from the folder in an array and print it
        javax.mail.Message[] messages = emailFolder.getMessages();
        System.out.println("messages.length---" + messages.length);

        for (int n = messages.length, i = n - 1; i > n - 2; i--) {
            javax.mail.Message message = messages[i];
//            if(message.getSubject().contains("My Ontario Account")) {   // verification code
            if (message.getSubject().contains(subject)) {   // "Payment Receipt"; verification code
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("ReceivedDate: " + message.getReceivedDate());
                System.out.println("ContentType: " + message.getContentType());
                //System.out.println("LineCount is: " + message.getLineCount());
                if (message.isMimeType("multipart/mixed")) {
                    MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
                    System.out.println("Message.getContent is: " + mimeMultipart);

                }

                printPlainTextContent(message);
                // ******
                String contentType = message.getContentType();
                String messageContent = "";

                if (contentType.contains("multipart")) { // If ContentType is "multipart/alternative", it will work; BUT NOT for ContentType: multipart/mixed;
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        messageContent = part.getContent().toString();
                    }
                    System.out.println("multipart/alternative Message: " + messageContent);
                    System.out.println("Transaction Number:-->" + HelperMethods.getTextBetween(messageContent, "(OCN: ", ")"));
//                    System.out.println("End Transaction Number:-->");
//                    System.out.println(" Transition num: " + HelperMethods.getTextBetween("Transaction Number: APP-A10226036724\n" +
//                            "\n" +
//                            "Dear Client,", "Transaction Number: ", "Dear Client"));
//                    txt = HelperMethods.getTextBetween(messageContent, "Transaction Number: ", "Dear Client");
//                    if (txt != null)
//                    {
//                        break;
//                    }
                    HelperMethods.getTextBetween(messageContent, "Transaction Number is: ", "Dear Client");
                }
                // ******
            }

        }

        //close the store and folder objects
        emailFolder.close(false);
        store.close();

    } catch (NoSuchProviderException e) {
        e.printStackTrace();
    } catch (MessagingException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

}

    private static void printPlainTextContent(javax.mail.Message message) throws Exception {
        Object content = message.getContent();

        if (content instanceof String) {
            String mimeType = message.getContentType();
            if (mimeType.startsWith("text/plain")) {
                System.out.println(content);
            } else if (mimeType.startsWith("TEXT/HTML")) {
                String plainText = htmlToPlainText((String) content);
                System.out.println("EmailBody: \n" + plainText);
            }
        } else if (content instanceof Multipart) {
            Multipart multipart = (Multipart) content;
            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/plain")) {
                    System.out.println(bodyPart.getContent());
                } else if (bodyPart.isMimeType("TEXT/HTML")) {
                    String plainText = htmlToPlainText((String) bodyPart.getContent());
                    System.out.println("EmailBody: \n" + plainText);
                }
            }
        }
    }


    private static String htmlToPlainText(String htmlContent) {
        return Jsoup.parse(htmlContent).text();
    }

// ++++++++++++
private String getTextFromMimeMultipart(
        MimeMultipart mimeMultipart) throws IOException, MessagingException {

    int count = mimeMultipart.getCount();
    if (count == 0)
        throw new MessagingException("Multipart with no body parts not supported.");
    boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
    if (multipartAlt)
        // alternatives appear in an order of increasing
        // faithfulness to the original content. Customize as req'd.
        return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
    String result = "";
    for (int i = 0; i < count; i++) {
        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
        result += getTextFromBodyPart(bodyPart);
    }
    return result;
}

    private String getTextFromBodyPart(
            BodyPart bodyPart) throws IOException, MessagingException {

        String result = "";
        if (bodyPart.isMimeType("text/plain")) {
            result = (String) bodyPart.getContent();
        } else if (bodyPart.isMimeType("text/html")) {
            String html = (String) bodyPart.getContent();
            result = org.jsoup.Jsoup.parse(html).text();
        } else if (bodyPart.getContent() instanceof MimeMultipart){
            result = getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
        }
        return result;
    }
private String getText(Part p) throws
        MessagingException, IOException {
//    if (p.isMimeType("text/*")) {
//        String s = (String)p.getContent();
//        textIsHtml = p.isMimeType("text/html");
//        return s;
//    }

    if (p.isMimeType("multipart/mixed")) {
        // prefer html text over plain text
        Multipart mp = (Multipart)p.getContent();
        String text = null;
        for (int i = 0; i < mp.getCount(); i++) {
            Part bp = mp.getBodyPart(i);
            if (bp.isMimeType("text/plain")) {
                if (text == null)
                    text = getText(bp);
                continue;
            } else if (bp.isMimeType("text/html")) {
                String s = getText(bp);
                if (s != null)
                    return s;
            } else {
                return getText(bp);
            }
        }
        return text;
    } else if (p.isMimeType("multipart/*")) {
        Multipart mp = (Multipart)p.getContent();
        for (int i = 0; i < mp.getCount(); i++) {
            String s = getText(mp.getBodyPart(i));
            if (s != null)
                return s;
        }
    }

    return null;
}
// =======================================================
    private static List<Message> getMessages(ListMessagesResponse response) {
        List<Message> messages = new ArrayList<Message>();
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            while (response.getMessages() != null) {
                messages.addAll(response.getMessages());
                if (response.getNextPageToken() != null) {
                    String pageToken = response.getNextPageToken();
                    response = service.users().messages().list(USER_ID)
                            .setPageToken(pageToken).execute();
                } else {
                    break;
                }
            }
            return messages;
        } catch (Exception e) {
            System.out.println("Exception log " + e);
            return messages;
        }
    }


// +++++++++++++++++++++++++++++++++++++  MAILINATOR ++++++++++++++++++
public static String getMailinatorPublicInbox(String apikey, String emailAddress) {

    String myLastMessage = getLastMailinatorMessage(apikey,emailAddress);
//    System.out.println("Your Last Email Message is as follows:--> ");
//    System.out.println(myLastMessage);
    System.out.println("Transaction Number on email is:--> " + HelperMethods.getTextBetween(myLastMessage, "(Transaction Number:", "Dear Client"));
//    String emailUrl = String.format(MAILINATOR_INBOX_TEMPLATE_URL, apikey, emailAddress);  // MAILINATOR_INBOX_TEMPLATE_URL
//    String emailUrl = String.format(Config.MAILINATOR_INBOX_TEMPLATE_URL, apikey, emailAddress);  // MAILINATOR_INBOX_TEMPLATE_URL
    System.out.println("Your Last Email Message is as follows:--> ");
    return getStringResponse(myLastMessage);
//    return getStringResponse(HelperMethods.getTextBetween(myLastMessage, "(Transaction Number:", "Dear Client"));

}

//    public static boolean emailransactionNumberTIsDisplayed(String apikey, String emailAddress) {
//        String myLastMessage = getLastMailinatorMessage(apikey,emailAddress);
//        String transactionNumber = null;
//        boolean mailransactionNumberExist = false;
//        if (getStringResponse(HelperMethods.getTextBetween(myLastMessage, "(Transaction Number:", "Dear Client")) != "")
//        {
//            transactionNumber = HelperMethods.getTextBetween(myLastMessage, "(Transaction Number:", "Dear Client");
//            System.out.println("Transaction Number on email is:--> " + transactionNumber);
//        //    System.out.println("Your Last Email Message is as follows:--> ");
//            mailransactionNumberExist = true; }
//        else
//        {mailransactionNumberExist = false;}
//        //    System.out.println(myLastMessage);
////        System.out.println("Transaction Number on email is:--> " + HelperMethods.getTextBetween(myLastMessage, "(Transaction Number:", "Dear Client"));
//        Reporter.log("Email was successfully verified! Transaction Number on email is:--> : " + transactionNumber);
//
//        return mailransactionNumberExist;
//    }
    public static boolean emailransactionNumberTIsDisplayed(String apikey, String emailAddress) {
        if (Config.MAILINATOR_OFF_ON.equals("ON")) {
            String myLastMessage = getLastMailinatorMessage(apikey, emailAddress);
            String transactionNumber = null;
            boolean mailTransactionNumberExist = false;

            if (!getStringResponse(HelperMethods.getTextBetween(myLastMessage, "(Transaction Number:", "Dear Client")).equals("")) {
                transactionNumber = HelperMethods.getTextBetween(myLastMessage, "(Transaction Number:", "Dear Client");
                System.out.println("Transaction Number on email is:--> " + transactionNumber);
                mailTransactionNumberExist = true;
            } else {
                mailTransactionNumberExist = false;
            }

            Reporter.log("Email was successfully verified! Transaction Number on email is:--> : " + transactionNumber);

            return mailTransactionNumberExist;
        } else {
            // Handle the case when Config.MAILINATOR_API_KEY is "OFF"
            System.out.println("Mailinator API is turned off. Skipping email verification.");
            return false;
        }
    }

private static String getJSONInbox(String apikey, String emailAddress) {
//    String emailUrl = String.format(MAILINATOR_INBOX_TEMPLATE_URL, apikey, emailAddress);  // MAILINATOR_INBOX_TEMPLATE_URL
    String emailUrl = String.format(Config.MAILINATOR_INBOX_TEMPLATE_URL, apikey, emailAddress);  // MAILINATOR_INBOX_TEMPLATE_URL
    return getStringResponse(emailUrl);

}

    private static String getJSONEmail(String apikey, String emailId){
        String emailUrl = String.format(Config.MAILINATOR_EMAIL_TEMPLATE_URL, apikey, emailId);  // MAILINATOR_EMAIL_TEMPLATE_URL
        return getStringResponse(emailUrl);

    }


    private static String getStringResponse(String url) {
        System.out.println("URL " + url);
        String read="error";
        try{
            URL urlValue = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlValue.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            if(code == 200){
                InputStream response = connection.getInputStream();
                InputStreamReader is = new InputStreamReader(response);
                BufferedReader br = new BufferedReader(is);
                read = br.readLine();
            }
        }
        catch(MalformedURLException e){
            System.out.println("Check the URL and try one more time "+e.toString());
        }
        catch(IOException e){
            System.out.println("Error "+e.toString());
        }
        return read;
    }
    private static String getLastMailinatorMessage(String apikey, String emailAddress){
        Map<Long, String> map = new TreeMap<Long, String>();
        String jsonContent ="";
        Object obj = new JSONParser();
        JSONObject jsonObj = null;
        JSONArray jArray = new JSONArray();

        jsonContent =getJSONInbox(apikey,emailAddress);
        if(!jsonContent.equals("error")){
            try{
                obj = ((JSONParser)obj).parse(jsonContent);
            }
            catch(Exception e){
                System.out.println("Error in parsing the JSON Content "+e);
            }
            jsonObj = (JSONObject)obj;
            jArray = (JSONArray)jsonObj.get("messages");
        }

        String sec_ago ="";
        Long sec_long =0L;
        String id="";

        for(int i =0; i< jArray.size();i++){
            jsonObj= (JSONObject)jArray.get(i);
            sec_ago = jsonObj.get("seconds_ago").toString();
            sec_long = Long.parseLong(sec_ago);
            id = jsonObj.get("id").toString();
            map.put(sec_long, id);
        }

        Map.Entry<Long,String> entry = (map.size() == 0)? null: map.entrySet().iterator().next();

        String emailId= Boolean.valueOf(entry == null)? "" :entry.getValue();
        String output ="";

        if(!emailId.equals("")){
            jsonContent = getJSONEmail(apikey, emailId);
            jsonObj = (JSONObject) JSONValue.parse(jsonContent);
            jsonObj = (JSONObject)(jsonObj).get("data");
            jArray= (JSONArray)jsonObj.get("parts");
            jsonObj = (JSONObject) jArray.get(0);
            output = jsonObj.get("body").toString();
        }

        return output;
    }
    private static String fetchMessageBody(String messageId) throws IOException {
        // Create the API URL for fetching message body
        String apiUrl = String.format("https://api.mailinator.com/v3/domains/mailinator.com/messages/%s/body", messageId);

        // Send GET request to the API
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Get the API response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Close the connection
        connection.disconnect();

        return response.toString();
    }
// ++++++++++++++++++++++++++++++++++===  MAILINATOR +++++++++++++++++++++++++++++++++

    // OUTLOOK +++++++++++++++++++++++++++++++

    // A function that reads the most recent email from Outlook and returns the text between two strings
    public static boolean emailTransactionNumberIsDisplayed(String username, String password, String start, String end) {
        // Set up mail properties
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imaps.host", "outlook.office365.com");
        properties.put("mail.imaps.port", "993");
        if (Config.EMAIL_VERIFY.equals("ON")) {
            try {
                // Create a session and connect to the email server
                Session session = Session.getDefaultInstance(properties, null);
                Store store = session.getStore("imaps");
                store.connect(username, password);

                // Open the inbox folder and get the most recent email
                Folder inbox = store.getFolder("inbox");
                inbox.open(Folder.READ_ONLY);
                javax.mail.Message latestEmail = inbox.getMessages()[inbox.getMessageCount() - 1];

                // Extract the email content and the text between two strings
                String emailContent = extractAndPrintContent(latestEmail);
                String textBetweenStrings = extractTextBetweenStrings(emailContent, start, end);

                // Close the connections
                inbox.close(false);
                store.close();

                // Check if the text between two strings is not empty and assign it to the transaction number
                boolean mailTransactionNumberExist = !textBetweenStrings.equals("");
                String transactionNumber = mailTransactionNumberExist ? textBetweenStrings : null;

                // Log the result and return the boolean value
                Reporter.log("-------: 'Email was successfully verified! Transaction Number on email is:--> : " + transactionNumber+"' :-------");
                return mailTransactionNumberExist;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false; //  return statement
    }




    // A function that reads the most recent email from Outlook and returns the text between two strings
    public static String emailTransactionNumberTIsDisplayed(String username, String password, String start, String end) {
        // Set up mail properties
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imaps.host", "outlook.office365.com");
        properties.put("mail.imaps.port", "993");

        try {
            // Create a session with the properties
            Session session = Session.getDefaultInstance(properties, null);

            // Connect to the email server
            Store store = session.getStore("imaps");
            store.connect(username, password);

            // Open the inbox folder
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            // Get the most recent email
            javax.mail.Message[] messages = inbox.getMessages();
            javax.mail.Message latestEmail = messages[messages.length - 1];

            // Extract and print content
            String emailContent = extractAndPrintContent(latestEmail);

            // Extract text between two strings
            String textBetweenStrings = extractTextBetweenStrings(emailContent, start, end);

            // Close the connections
            inbox.close(false);
            store.close();

            // Return the text between two strings
            return textBetweenStrings;

        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred";
        }
    }

    private static String extractAndPrintContent(Part part) throws Exception {
        Object content = part.getContent();
        String emailContent = "";

        if (part.isMimeType("text/plain")) {
            emailContent = (String) content;
            System.out.println("Text Content:\n" + emailContent);
        } else if (part.isMimeType("text/html")) {
            emailContent = (String) content;
            System.out.println("HTML Content:\n" + emailContent);
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) content;

            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                emailContent += extractAndPrintContent(bodyPart);
            }
        } else {
            // Handle other content types if needed
            System.out.println("Other Content Type: " + part.getContentType());
        }

        return emailContent;
    }

    private static String extractTextBetweenStrings(String text, String start, String end) {
        String pattern = Pattern.quote(start) + "(.*?)" + Pattern.quote(end);
        Pattern regexPattern = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher matcher = regexPattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(1).trim();
        } else {
            return "Not Found";
        }
    }
// OUTLOOK +++++++++++++++++++++++++++++++++

}