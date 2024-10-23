import org.apache.commons.io.FileUtils;
import org.testng.reporters.EmailableReporter2;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.net.InetAddress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CustomReporter  extends EmailableReporter2 {

    @Override
    protected void writeBody() {
        copyReport();
        writer.print("<body>");
        writeOnbisHeader();
        writer.print("<div id='header'> Reporting Date & Time           : " + getCurrentDateTime() +"</span></div>");
//        writer.print("<div id='header'> Reporting Host   Name:     " + getHostName()+"</span></div>");
        writer.print("<div id='header'> Test Execution Host Name &  IP  : " + getHostIP()+"</span></div>");

        writer.print("<div id='header'> Test Execution OS Name & Version: " + System.getProperty("os.name")+"</span></div>");
//        writer.print("<div id='header'> Test Execution     OS Version:    " + System.getProperty("os.version")+"</span></div>");
        writer.print("<div id='header'> Test Execution Java Version     : " + System.getProperty("java.version")+"</span></div>");
        writer.print("<div id='header'> Test Execution User Name        : " + System.getProperty("user.name")+"</span></div>");

        writeSuiteSummary();
        writeScenarioSummary();
        writeScenarioDetails();
        writer.print("</body>");
//        copyReport();
    }

    private void writeOnbisHeader() {
        try {
            FileUtils.copyFile(new File("src/main/resources/logo.png"), new File("test-output/images/logo.png"));
        } catch (IOException ignored) {}
        writer.print("<div id='header'><img src='images/logo.png' width='128px'><span id='logo'>ONBIS e2e Test Results</span></div>");
    }
    private void copyReport() {
        try {
            FileUtils.copyFile(new File("test-output/emailable-report.html"), new File("test-output/emailable-report-backup.html"));
        } catch (IOException ignored) {}
    }

    @Override
    protected void writeStylesheet() {
        String styles = "";
        try {
            styles = FileUtils.readFileToString(new File("src/main/resources/style.css"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.print("<style type=\"text/css\">");
        writer.print(styles);
        writer.print("</style>");
    }
    public static String getCurrentDateTime() {
        //return LocalTime.now();
        LocalDateTime datetime1 = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:a");
        String formatDateTime = datetime1.format(format);
        return formatDateTime;

    }
    public static String getHostName() {
        InetAddress ip;
        String hostname = null;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
//            System.out.println("Your current IP address : " + ip);
//            System.out.println("Your current Hostname : " + hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostname;
    }
    public static InetAddress getHostIP() {
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }
    public static void copyFile(String sourceFile, String destFile) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        finally {
            in.close();
            out.close();
        }
    }

    public static void copyFile(File from, File to)
            throws IOException {
        FileUtils.copyFile(from, to);
    }


// +++++++++++++++++
//    @Override
//    protected void writeScenarioDetails() {
//        int scenarioIndex = 0;
//        for (SuiteResult suiteResult : suiteResults) {
//            for (TestResult testResult : suiteResult.getTestResults()) {
//                writer.print("<h2>");
//                writer.print(Utils.escapeHtml(testResult.getTestName()));
//                writer.print("</h2>");
//
//                scenarioIndex += writeScenarioDetails(
//                        testResult.getFailedConfigurationResults(),
//                        scenarioIndex);
//                scenarioIndex += writeScenarioDetails(
//                        testResult.getFailedTestResults(), scenarioIndex);
//                scenarioIndex += writeScenarioDetails(
//                        testResult.getSkippedConfigurationResults(),
//                        scenarioIndex);
//                scenarioIndex += writeScenarioDetails(
//                        testResult.getSkippedTestResults(), scenarioIndex);
//                scenarioIndex += writeScenarioDetails(
//                        testResult.getPassedTestResults(), scenarioIndex);
//            }
//        }
//    }
//
//    private int writeScenarioDetails(List<ClassResult> classResults,
//                                     int startingScenarioIndex) {
//        int scenarioIndex = startingScenarioIndex;
//        for (ClassResult classResult : classResults) {
//            String className = classResult.getClassName();
//            for (MethodResult methodResult : classResult.getMethodResults()) {
//                List<ITestResult> results = methodResult.getResults();
//                assert !results.isEmpty();
//
//                String label = Utils
//                        .escapeHtml(className
//                                + "#"
//                                + results.iterator().next().getMethod()
//                                .getMethodName());
//                for (ITestResult result : results) {
//                    writeScenario(scenarioIndex, label, result);
//                    scenarioIndex++;
//                }
//            }
//        }
//
//        return scenarioIndex - startingScenarioIndex;
//    }
//
//    private void writeScenario(int scenarioIndex, String label,
//                               ITestResult result) {
//        writer.print("<h3 id=\"m");
//        writer.print(scenarioIndex);
//        writer.print("\">");
//        writer.print(label);
//        writer.print("</h3>");
//
//        writer.print("<table class=\"result\">");
//
//
//        // Write system console messages
//        List<String> consoleOutputs = Reporter.getOutput(______);
//        for (int i = 1; i <= consoleOutputs.size(); i++) {
//            writer.print("<th>output #");
//            writer.print(i);
//            writer.print("</th>");
//        }
//        writer.print("<p>Hello!</p>");
//
//
//
//        // Write test parameters (if any)
//        Object[] parameters = result.getParameters();
//        int parameterCount = (parameters == null ? 0 : parameters.length);
//        if (parameterCount > 0) {
//            writer.print("<tr class=\"param\">");
//            for (int i = 1; i <= parameterCount; i++) {
//                writer.print("<th>Parameter #");
//                writer.print(i);
//                writer.print("</th>");
//            }
//            writer.print("</tr><tr class=\"param stripe\">");
//            for (Object parameter : parameters) {
//                writer.print("<td>");
//                writer.print(Utils.escapeHtml(Utils.toString(parameter)));
//                writer.print("</td>");
//            }
//            writer.print("</tr>");
//        }
//
//        // Write reporter messages (if any)
//        List<String> reporterMessages = Reporter.getOutput(result);
//        if (!reporterMessages.isEmpty()) {
//            writer.print("<tr><th");
//            if (parameterCount > 1) {
//                writer.print(" colspan=\"");
//                writer.print(parameterCount);
//                writer.print("\"");
//            }
//            writer.print(">Messages</th></tr>");
//
//            writer.print("<tr><td");
//            if (parameterCount > 1) {
//                writer.print(" colspan=\"");
//                writer.print(parameterCount);
//                writer.print("\"");
//            }
//            writer.print(">");
//            writeReporterMessages(reporterMessages);
//            writer.print("</td></tr>");
//        }
//
//        // Write exception (if any)
//        Throwable throwable = result.getThrowable();
//        if (throwable != null) {
//            writer.print("<tr><th");
//            if (parameterCount > 1) {
//                writer.print(" colspan=\"");
//                writer.print(parameterCount);
//                writer.print("\"");
//            }
//            writer.print(">");
//            writer.print((result.getStatus() == ITestResult.SUCCESS ? "Expected Exception"
//                    : "Exception"));
//            writer.print("</th></tr>");
//
//            writer.print("<tr><td");
//            if (parameterCount > 1) {
//                writer.print(" colspan=\"");
//                writer.print(parameterCount);
//                writer.print("\"");
//            }
//            writer.print(">");
//            writeStackTrace(throwable);
//            writer.print("</td></tr>");
//        }
//
//        writer.print("</table>");
//        writer.print("<p class=\"totop\"><a href=\"#summary\">back to summary</a></p>");
//    }
}
