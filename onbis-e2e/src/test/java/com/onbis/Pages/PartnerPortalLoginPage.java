package com.onbis.Pages;

import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.awt.*;
import java.io.IOException;

public class PartnerPortalLoginPage extends PageObject {
    public PartnerPortalLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "identifier")
    WebElement userNameField1;
    @FindBy(name = "credentials.passcode")
    WebElement passwordField1;
    @FindBy(xpath = "//input[@value='Sign in']")
    WebElement loginButton1;

    @FindBy(id = "username")
    WebElement userNameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "signin")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='appBannerContainerInner']/following-sibling::span[1]")
    WebElement getBuildNumberPartnerPortal;
    @FindBy(xpath = "//*[contains(text(),'Launch 2 Partner Portal')]")
//    @FindBy(xpath = "/html/body/div[2]/div[1]/p[2]/a")
    WebElement PartnerPortallaunch2;
    @FindBy(xpath = "//a[@href='/onbis/partner/launcher']")
    WebElement PartnerPortallaunch;


    public void loginUsingPartnerPortalCredentials() throws IOException, InterruptedException {
        if (System.getenv("ENV").equals("BAT")) {
            driver.get(System.getenv("BAT_Url"));
            Thread.sleep(1000);
            HelperMethods.switchWindow(driver);
            try {
                HelperMethods.robotTypeString("ONBISBAT");
            } catch (AWTException e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
            try {
                HelperMethods.robotSendTAB();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
            try {
                HelperMethods.robotTypeString("January62020");
            } catch (AWTException e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
            try {
                HelperMethods.robotSendENTER();
            } catch (AWTException e) {
                e.printStackTrace();
            }
                HelperMethods.selectOptionFromDropdownselectByValue("ONBIS_PARTNER", driver.findElement(By.xpath("//*[@id=\"apps-dropdown\"]")), driver);
//                HelperMethods.selectOptionFromDropdownWithValueOf("Internal", driver.findElement(By.id("apps-dropdown")), driver);
//                HelperMethods.selectOptionFromDropdownselectByIndex(1, driver.findElement(By.id("apps-dropdown")), driver);
            HelperMethods.waitAndSendKeys(driver.findElement(By.id("externalToken")), "sysAdmin1", driver);
                HelperMethods.selectOptionFromDropdownselectByValue("0", driver.findElement(By.id("svcs-dropdown")), driver);
            HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//input[@type='submit']")), driver);
        }
        else {
            driver.get(System.getenv("PartnerPortalUrl"));
            System.out.println("-------: '" + System.getenv("PartnerPortalUrl") + "' :-------");
            // deletes all cookies
//        driver.manage().deleteAllCookies();
            Thread.sleep(500);
//            driver.findElement(By.linkText("Login via My Ontario Account")).click();
            driver.findElement(By.partialLinkText("Login via")).click();
//        driver.manage().deleteAllCookies();
//            HelperMethods.waitAndSendKeys(userNameField, System.getenv("partnerPortalUserName"), driver);
//            HelperMethods.waitAndSendKeys(passwordField, System.getenv("partnerPortalPassword"), driver);
//            HelperMethods.staleElementClick(loginButton, driver);

            HelperMethods.waitAndSendKeys(userNameField1, System.getenv("partnerPortalUserName"), driver);
            HelperMethods.waitAndSendKeys(passwordField1, System.getenv("partnerPortalPassword"), driver);
            HelperMethods.staleElementClick(loginButton1, driver);
        }
        if (System.getenv("ENV").contains("2")) {
//            System.out.println ( "-------: '"+PartnerPortallaunch2.getText() + "' :-------");
//            HelperMethods.linkClick(PartnerPortallaunch2, "Partner Portal launch2");
//            HelperMethods.fluentWaitAndClick(PartnerPortallaunch2, driver);
            Thread.sleep(5000);
            System.out.println(PartnerPortallaunch2.getAttribute("href"));
            driver.get(PartnerPortallaunch2.getAttribute("href"));
//            HelperMethods.waitAndClick(PartnerPortallaunch2, driver);

        }
        else {

            if (!System.getenv("ENV").equals("BAT")) {
//            System.out.println ( "-------: '"+PartnerPortallaunch.getText() + "' :-------");
//            HelperMethods.linkClick(PartnerPortallaunch, "Partner Portal launch");
                HelperMethods.fluentWaitAndClick(PartnerPortallaunch, driver);
            }

        }
// DO Not need to read the URL. Rather read the ENV value like DEV, DEV2, UAT, UAT2, etc...
//        if (driver.getCurrentUrl().contains("dev")) {
//            driver.navigate().to(System.getenv("devPartnerPortalDashboard"));
//            System.out.println ( "-------: '"+System.getenv("devPartnerPortalDashboard") + "' :-------");
//        }
//        else {
//            driver.navigate().to(System.getenv("PartnerPortalDashboard"));
//            System.out.println ( "-------: '"+System.getenv("PartnerPortalDashboard") + "' :-------");
//        }
        buildNumberPartnerPortal();
    }

    public String buildNumberPartnerPortal() throws IOException, InterruptedException {
        // getBuildNumberPartnerPortal
        if (HelperMethods.isElementDisplayedNoWait(getBuildNumberPartnerPortal,driver))
        {
            HelperMethods.highLighterMethod(driver, getBuildNumberPartnerPortal);
            System.out.println ( "-------:PartnerPortal build number is: '"+ getBuildNumberPartnerPortal.getText() + "' :-------");
            Reporter.log("PartnerPortal build number is: " + getBuildNumberPartnerPortal.getText());
        }
        return getBuildNumberPartnerPortal.getText();
    }
}
