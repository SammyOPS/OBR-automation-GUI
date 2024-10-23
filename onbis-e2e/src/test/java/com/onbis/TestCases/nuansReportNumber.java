package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.*;

@Listeners(ListenersTestNG.class)
public class nuansReportNumber extends BaseTestNoPage {
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
    @FindBy(css = "//div[@role='listbox']//div")
    WebElement listbox;
// +++++++


    /*
    nuansAddReportNumber
     */
    @Test
    public void nuansAddReportNumber() throws InterruptedException, IOException, AWTException {

//        driver.get("https://login.yahoo.com/");
//        HelperMethods.waitAndSendKeys(driver.findElement(By.id("login-username")), "onbistestautomation@yahoo.com", driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("login-signin")),  driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.id("login-passwd")), "TestAuto123!", driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("login-signin")),  driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Mail']")),  driver);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//input[contains(@class,'select-input react-typeahead-input')]")), "43040282", driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.cssSelector("div#mail-search>div>button>span")),  driver);

//
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(genericUtilsPage.oCNIsDisplayedEmail("43040282"));
//
//        String oCNNumber = "43040282";
//        driver.get("https://outlook.live.com/owa/?nlp=1");
//        HelperMethods.waitAndSendKeys(driver.findElement(By.id("i0116")), Config.EMAIL, driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("idSIButton9")),  driver);
//        Thread.sleep(3500);
//        HelperMethods.waitAndSendKeys(driver.findElement(By.id("i0118")), Config.EMAIL_PASSWORD, driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("idSIButton9")),  driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("idBtn_Back")),  driver);
//        Thread.sleep(500);
//
//        HelperMethods.isAlertPresent(driver);
//
//        HelperMethods.waitAndSendKeys(driver.findElement(By.xpath("//*[@id=\"topSearchInput\"]")), oCNNumber, driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//*[@id=\"searchBoxColumnContainerId\"]/div[1]/button/span/i")),  driver);
//
//        Thread.sleep(3000);
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//div[@role='listbox']//div")));
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@role='listbox']//div")));
//        HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//div[@role='checkbox']")));
//
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[3]/div/div[3]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/div[1]/div")),  driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='" + oCNNumber+ "']")),  driver);
//        System.out.println("Transaction Number: " + driver.findElement(By.xpath("//span[text()='" + oCNNumber+ "']")).getText());
//        String ontarioCorporationName = driver.findElement(By.xpath("//div[@id='ReadingPaneContainerId']")).getText();
//
//        boolean isFound = ontarioCorporationName.contains(oCNNumber); // true
//        System.out.println("OCN found in email: " + isFound);
//        Reporter.log("OCN " +oCNNumber +  "verified in email: " + isFound);
//        Assert.assertTrue(true);
//
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//div[@class='nvEhuDKzSmREBsqaIaOhu']//img[1]")),  driver);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.id("mectrl_body_signOut")), driver);
//        Thread.sleep(3500);





// Note: This functionality works ONLY in "Chrome" and "Edge"
      String randomCorporationName = HelperMethods.randomString() + HelperMethods.generateRandomNumber(9999,1111)+ " test inc.";
        driver.get("https://onbissupporttest@ontario.ca:6pNEAwyd9F+a@www-pre.nuans.com/app/scr/corp/nuans/xml/orderReport.xml?reportType=17&name=" + randomCorporationName + "&naicsCode=54,11&alternativeTerm=&referenceNumber=&niceCode1=&niceCode2=&niceCode3=&niceCode4=&nxt=Next");
        Thread.sleep(3500);
        driver.get("https://www-pre.nuans.com/app/scr/corp/nuans/xml/activeReports.xml");
        Thread.sleep(10500);
        String nuansReportTitle = HelperMethods.getNumberFromString("<report_title>", "</report_title>",driver);
        String nuansReportNumber = HelperMethods.getNumberFromString("nuans_report_item report_number=\"", "\">",driver);
        File resourcesDirectory = new File("src/main/resources");
     //   System.out.println(resourcesDirectory);
        HelperMethods.getLatestWindowFocused(driver);
        HelperMethods.writeToTextFile(resourcesDirectory +"/nuansReportTitle.txt",nuansReportTitle);
        HelperMethods.writeToTextFile(resourcesDirectory +"/nuansReportNumber.txt",nuansReportNumber);
        Assert.assertTrue(!nuansReportNumber.equals(null));
        Reporter.log("nuansReportNumber is: " + nuansReportNumber);
        Reporter.log("nuansReportTitle is: " + nuansReportTitle);
//        HelperMethods.writeToTextFile(resourcesDirectory +"/nuansReportTitle.txt",HelperMethods.getBoundaryValue("<report_title>", "</report_title>",driver));
//        HelperMethods.writeToTextFile(resourcesDirectory +"/nuansReportNumber.txt",HelperMethods.getBoundaryValue("nuans_report_item report_number=\"", "\">",driver));
//        HelperMethods.writeToTextFile("C:\\workspace\\onbis-e2e\\src\\main\\resources\\nuansReportTitle.txt",HelperMethods.getBoundaryValue("<report_title>", "</report_title>",driver));
//        HelperMethods.writeToTextFile("C:\\workspace\\onbis-e2e\\src\\main\\resources\\nuansReportNumber.txt",HelperMethods.getBoundaryValue("nuans_report_item report_number=\"", "\">",driver));


        System.out.println("randomCorporationName is ...> " +randomCorporationName);
//        System.out.println(HelperMethods.readFromTextFile(resourcesDirectory +"/nuansReportTitle.txt"));
//        System.out.println(HelperMethods.deleteFile(resourcesDirectory +"/nuansReportTitle.txt"));
//        System.out.println(HelperMethods.readFromTextFile(resourcesDirectory +"/nuansReportNumber.txt"));
//        System.out.println(HelperMethods.deleteFile(resourcesDirectory +"/nuansReportNumber.txt"));

//        HelperMethods.takeScreenshot(driver);
//        Assert.assertTrue(genericUtilsPage.oCNIsDisplayedEmail("43040282"));
    }
}
