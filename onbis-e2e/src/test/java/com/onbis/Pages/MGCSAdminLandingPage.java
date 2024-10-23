package com.onbis.Pages;

import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.io.IOException;
import java.nio.file.WatchEvent;

public class MGCSAdminLandingPage extends PageObject {
    @FindBy(xpath = "//a[@href='/onbis/admin/launcher']")
//    @FindBy(xpath = "//a[@href='/onbis_onprem/admin/launcher?env=obr2']") // It's a temp soultion, remove this (May 17, 20224)
    WebElement launchAdminPortal;
    @FindBy(xpath = "//a[@href='/onbis/admin/launcher?env=obr2']")
    WebElement launch2AdminPortal;
    @FindBy(xpath = "//a[@title='MGCS Administration Portal']")
    WebElement pageTitle;
    @FindBy(xpath = "//img[@alt='Ontario logo']")
    WebElement ontarioLogo;
    @FindBy(xpath = "//a[contains(text(), 'Registry')]")
    WebElement registryTab;
    @FindBy(xpath = "//a[contains(text(), 'Registry Main Launch2  ')]")
    WebElement RegistryMainLaunch2;
    String RegistryMainLaunch2URL = "https://intradev.services.ebc.gov.on.ca/wps85/myportal/soadmin/adminhome/welcome/!ut/p/z1/04_Sj9CPykssy0xPLMnMz0vMAfIjo8zizfzdDTyd3A383INCjA0cw4yd_JzDfI3cPc30wwkpiAJKG-AAjgZA_VFgJThMsPAwgirAY0ZBboRBpqOiIgC4wNgx/dz/d5/L2dBISEvZ0FBIS9nQSEh/?uri=nm:oid:Z6_6OG0IBG0NO4890QRC3M30T0044";
    @FindBy(xpath = "//a[contains(text(), 'Ontario Business Registry Dashboard link')]")
    WebElement ontarioBusinessRegistryDashboardLink;

    @FindBy(xpath = "//div[@class='appBannerContainerInner']/following-sibling::span[1]")
    WebElement getBuildNumberPartnerPortal;


    public MGCSAdminLandingPage(WebDriver driver) {
        super(driver);
    }

    public boolean LandingPageIsDisplayed() {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(pageTitle, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        return isCorrect;
    }

    public void launchAdminPortal() {
        // Entrust login using AutoIT
//        try {
//            System.out.println ( System.getProperty("user.dir")+ "\\Entrust.exe");
////            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Entrust.exe");
//            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Ent.vbs");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (System.getenv("ENV").contains("2")) {
            System.out.println ( "-------:Admin Portal URL is: '"+ System.getenv("SOAdminPortal") + "' :-------");
            HelperMethods.fluentWaitAndCheckVisible(launch2AdminPortal, driver);
            HelperMethods.waitAndClick(launch2AdminPortal, driver);
            if (HelperMethods.isElementDisplayedNoWait(getBuildNumberPartnerPortal,driver))
            {
                HelperMethods.highLighterMethod(driver, getBuildNumberPartnerPortal);
                System.out.println ( "-------:Admin Portal build number is: '"+ getBuildNumberPartnerPortal.getText() + "' :-------");
                Reporter.log("Admin Portal build number is: " + getBuildNumberPartnerPortal.getText());
            }
        }
        else {
            if (!System.getenv("ENV").equals("BAT")) {
                HelperMethods.fluentWaitAndCheckVisible(launchAdminPortal, driver);
                HelperMethods.waitAndClick(launchAdminPortal, driver);
                if (HelperMethods.isElementDisplayedNoWait(getBuildNumberPartnerPortal,driver))
                {
                    HelperMethods.highLighterMethod(driver, getBuildNumberPartnerPortal);
                    System.out.println ( "-------:Admin Portal build number is: '"+ getBuildNumberPartnerPortal.getText() + "' :-------");
                    Reporter.log("Admin Portal build number is: " + getBuildNumberPartnerPortal.getText());
                }
            }
        }
    }
    public void selectRegistryAsAssignOCN() throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        System.out.println(System.getenv("ENV").toLowerCase());
        if (System.getenv("ENV").contains("2")){
            driver.navigate().to(System.getenv("RegistryMainLaunch2URL"));
            Thread.sleep(10000);
        }
        else {
        HelperMethods.waitAndClick(registryTab, driver);
        HelperMethods.waitAndClick(registryTab, driver);
        }
        Thread.sleep(200);
//        HelperMethods.waitAndClick(ontarioBusinessRegistryDashboardLink, driver);
//        driver.navigate().to(RegistryMainLaunch2URL);
//        Thread.sleep(10000);
//        ontarioBusinessRegistryDashboardLink.click();
//        ontarioBusinessRegistryDashboardLink.submit();
        HelperMethods.linkSubmit(ontarioBusinessRegistryDashboardLink, "ontarioBusinessRegistryDashboardLink");
//        HelperMethods.linkClick(ontarioBusinessRegistryDashboardLink, "ontarioBusinessRegistryDashboardLink");

        Thread.sleep(2000);
        try {
            buildNumberAdminPortal();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String buildNumberAdminPortal() throws IOException, InterruptedException {
        // getBuildNumberPartnerPortal
        if (HelperMethods.isElementDisplayedNoWait(getBuildNumberPartnerPortal,driver))
        {
            HelperMethods.highLighterMethod(driver, getBuildNumberPartnerPortal);
            System.out.println ( "-------:Admin Portal build number is: '"+ getBuildNumberPartnerPortal.getText() + "' :-------");
            Reporter.log("Admin Portal build number is: " + getBuildNumberPartnerPortal.getText());
        }
        return getBuildNumberPartnerPortal.getText();
    }
}
