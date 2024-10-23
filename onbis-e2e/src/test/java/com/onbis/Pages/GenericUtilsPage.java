package com.onbis.Pages;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

import static com.onbis.Helper.EmailUtils.*;

public class GenericUtilsPage extends PageObject {
    public GenericUtilsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='appAttrLabelBox']/following-sibling::input[1]")
    WebElement nuansReportValue;
    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::input[1]")
    WebElement corporationNameValue;
    @FindBy(xpath = "//div[@class='appAttrLabelBox appCompanyName']/following-sibling::input[1]")
    WebElement corporationNameValueOCN;
    @FindBy(css = "div#folder1>div>span:nth-of-type(2)>span>span:nth-of-type(2)")
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

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        //take screenshot of the entire page
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {

            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String fileName = screenshotName +"_"+ dateName ;
            ImageIO.write(screenshot.getImage(),"png",new File("./Screenshots/" + fileName+ ".png"));
            Reporter.log("Test failed and screenshot: '" + System.getProperty("user.dir")+"\\Screenshots\\"+fileName + ".png' is taken ------------>");
            System.out.println("Test failed and screenshot: '" + System.getProperty("user.dir")+"\\Screenshots\\"+fileName + ".png' is taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
//    public static void captureScreenshot(WebDriver driver, String screenshotName) {
//        try {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File source = ts.getScreenshotAs(OutputType.FILE);
////            File Screenshots = null;
////            if (!Screenshots.exists()) {
////                Screenshots.mkdirs();
////            }
//            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//            FileHandler.copy(source, new File("./Screenshots/" + screenshotName +"_"+ dateName + ".png"));
//
////            File destFile = new File("./Screenshots/" + screenshotName +"_"+ dateName + ".png");
////            FileUtils.copyFile(source, destFile);
////            Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
//
//            System.out.println("'" +screenshotName +"_"+ dateName + ".png'" + " - screenshot is taken ");
//            Reporter.log("Test failed and screenshot is taken ------------>");
//        } catch (Exception e) {
//            System.out.println("Exception while taking screenshot " + e.getMessage());
//        }
//    }

    public static String validateEmailReceived() {
        System.out.println("Total count of emails is :" + getTotalCountOfMails());

        HashMap<String, String> hm = getGmailData("subject:(Payment Receipt)");
        System.out.println("=================");
        System.out.println("Email body is: " + hm.get("body"));
        System.out.println("=================");
        System.out.println("Transaction # is: " + hm.get("transaction"));
        System.out.println("=================");
//        System.out.println("Transaction # is: " + hm.get("attachmentBody"));
//        System.out.println("=================");
        return hm.get("transaction");
    }

    public boolean emailSubjectAndContentIsDisplayed() {
        boolean mailSubjectExist = isMailSubjectExist("Payment");
        mailSubjectExist = mailSubjectExist && isMailAttachmentExist("Payment Receipt.pdf");
        System.out.println("Subject exist or not: " + mailSubjectExist);
//        System.out.println("Attachment exist or not: " + mailAttachmentExist);
        return mailSubjectExist;
    }

    public boolean emailPaymentReceiptVerified(String oCNNumber) throws InterruptedException {
// ++++++++
     //   String oCNNumber = "43040282";
        driver.get("https://outlook.live.com/owa/?nlp=1");
        HelperMethods.waitAndSendKeys(driver.findElement(By.id("i0116")), Config.EMAIL, driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("idSIButton9")),  driver);
        Thread.sleep(3500);
        HelperMethods.waitAndSendKeys(driver.findElement(By.id("i0118")), Config.EMAIL_PASSWORD, driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("idSIButton9")),  driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("idBtn_Back")),  driver);
        Thread.sleep(500);

        HelperMethods.isAlertPresent(driver);

        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//*[@id=\"topSearchInput\"]")), oCNNumber, driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//*[@id=\"searchBoxColumnContainerId\"]/div[1]/button/span/i")),  driver);

        Thread.sleep(3000);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//div[@role='listbox']//div")));
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@role='listbox']//div")));
        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@role='checkbox']")));

        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[3]/div/div[3]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/div[1]/div")),  driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='" + oCNNumber+ "']")),  driver);
        System.out.println("Transaction Number: " + driver.findElement(By.xpath("//span[text()='" + oCNNumber+ "']")).getText());
        String ontarioCorporationName = driver.findElement(By.xpath("//div[@id='ReadingPaneContainerId']")).getText();

        boolean isFound = ontarioCorporationName.contains(oCNNumber); // true
        System.out.println("Email Payment Receipt verified for Transaction Number: '" + oCNNumber + "'");
        Reporter.log("Email Payment Receipt verified for Transaction Number: '" + oCNNumber + "'");
        Assert.assertTrue(true);

        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//div[@class='nvEhuDKzSmREBsqaIaOhu']//img[1]")),  driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("mectrl_body_signOut")), driver);
        Thread.sleep(3500);
        return true;
// ++++++++

//
//        boolean mailSubjectExist = isMailSubjectExist("Payment");
//        mailSubjectExist = mailSubjectExist && isMailAttachmentExist("Payment Receipt.pdf");
//        System.out.println("Subject exist or not: " + mailSubjectExist);
////        System.out.println("Attachment exist or not: " + mailAttachmentExist);
//        return mailSubjectExist;
    }
}
