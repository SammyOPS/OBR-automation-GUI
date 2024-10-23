package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.EmailUtils;
import com.onbis.Helper.ListenersTestNG;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;
import static com.onbis.Helper.EmailUtils.getMailinatorPublicInbox;

@Listeners(ListenersTestNG.class)
public class checkMailinarorEmail extends BaseTestNoPage {
    @FindBy(css ="div#folder0>div:nth-of-type(2)>div:nth-of-type(6)>span:nth-of-type(2)")
    WebElement nuans_report_number;
    @FindBy(css = "div#folder0>div>span:nth-of-type(2)")
    WebElement nuansReportNumber;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/a/span[3]")
    WebElement nuansReportNumberIE;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]")
    WebElement nuansReportNumberFirefox;

    @FindBy(css = "div#folder1 > div:nth-of-type(2) > div:nth-of-type(1) > span:nth-of-type(2)")
    WebElement nuansReportTitle;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/report_title")
    WebElement nuansReportTitleIE;
    @FindBy(xpath = "/nuans_report_list/nuans_report_item[1]/report_title")
    WebElement nuansReportTitleFirefox;
// +++++++


    /*
    nuansAddReportNumber
     */
    @Test
    public void checkMailinarorEmail() throws InterruptedException, IOException {
//        driver.get("https://accounts.google.com/");
//
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//span[text()='Use your Google Account']/following::input")), Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Next']")), driver);
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());

//        String host = "imap-mail.outlook.com"; //   imap.gmail.com
//        String mailStoreType = "imap";
//        String username = "onbistestautomation@outlook.com";
//        String password = "TestAuto123!";
//        String emailSubject = "Initial Return";
//        genericUtilsPage.emailSubjectAndContentIsDisplayed();
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
      // check(host, mailStoreType, username, password, emailSubject);
//        getMailinatorPublicInbox(Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
//        emailransactionNumberTIsDisplayed(Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
//        System.out.println(getMailinatorPublicInbox(Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS));

// Note: This functionality works ONLY in "Chrome" and "Edge"
//      String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";
//        driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
//        Thread.sleep(3500);
//        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
//        Thread.sleep(10500);
//        String nuansReportTitle = HelperMethods.getNumberFromString("<report_title>", "</report_title>",driver);
//        String nuansReportNumber = HelperMethods.getNumberFromString("nuans_report_item report_number=\"", "\">",driver);
//        File resourcesDirectory = new File("src/main/resources");
//     //   System.out.println(resourcesDirectory);
//        HelperMethods.getLatestWindowFocused(driver);
//        HelperMethods.writeToTextFile(resourcesDirectory +"/nuansReportTitle.txt",nuansReportTitle);
//        HelperMethods.writeToTextFile(resourcesDirectory +"/nuansReportNumber.txt",nuansReportNumber);
//        Assert.assertTrue(!nuansReportNumber.equals(null));
//        Reporter.log("nuansReportNumber is: " + nuansReportNumber);
//        Reporter.log("nuansReportTitle is: " + nuansReportTitle);
////        HelperMethods.writeToTextFile(resourcesDirectory +"/nuansReportTitle.txt",HelperMethods.getBoundaryValue("<report_title>", "</report_title>",driver));
////        HelperMethods.writeToTextFile(resourcesDirectory +"/nuansReportNumber.txt",HelperMethods.getBoundaryValue("nuans_report_item report_number=\"", "\">",driver));
////        HelperMethods.writeToTextFile("C:\\workspace\\onbis-e2e\\src\\main\\resources\\nuansReportTitle.txt",HelperMethods.getBoundaryValue("<report_title>", "</report_title>",driver));
////        HelperMethods.writeToTextFile("C:\\workspace\\onbis-e2e\\src\\main\\resources\\nuansReportNumber.txt",HelperMethods.getBoundaryValue("nuans_report_item report_number=\"", "\">",driver));
//
//
//        System.out.println("randomCorporationName is ...> " +randomCorporationName);
//        System.out.println(HelperMethods.readFromTextFile(resourcesDirectory +"/nuansReportTitle.txt"));
//        System.out.println(HelperMethods.deleteFile(resourcesDirectory +"/nuansReportTitle.txt"));
//        System.out.println(HelperMethods.readFromTextFile(resourcesDirectory +"/nuansReportNumber.txt"));
//        System.out.println(HelperMethods.deleteFile(resourcesDirectory +"/nuansReportNumber.txt"));

//        HelperMethods.takeScreenshot(driver);

    }
}
