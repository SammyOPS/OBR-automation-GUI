package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ThreadLocalDriverFactory;
import com.onbis.Pages.GenericUtilsPage;
import com.onbis.Pages.SOAccountLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Ascii.toUpperCase;

public class BaseTestSOAdmin {
    WebDriver driver;
    private ThreadLocalDriverFactory threadLocalDriverFactory = new ThreadLocalDriverFactory();

    SOAccountLandingPage soAccountLandingPage;
    GenericUtilsPage genericUtilsPage;

    private WebDriver getDriver() {
        return threadLocalDriverFactory.getTLDriver().get();
    }

    @BeforeSuite
    private void setBrowserDrivers() {
        HelperMethods.excCommand("taskkill /F /IM chromedriver.exe /T");
    //    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        System.setProperty("webdriver.internetExplorer.driver", "C:\\drivers\\IEDriverServer.exe");
        System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    void setUp(final String browser) throws InterruptedException, AWTException {
        threadLocalDriverFactory.setTLDriver(browser);
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        if (browser.equals("chrome")) {

            // Entrust login using AutoIT
        try {
            System.out.println ( System.getProperty("user.dir")+ "\\Entrust.exe");
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Entrust.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Ent.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Ent.vbs' - is executed to Entrust login Window");
        } catch (IOException e) {
            e.printStackTrace();
        }
            if (System.getenv("ENV").equals("BAT")) {
                driver.get(System.getenv("BAT_Url"));
                Thread.sleep(1000);
                HelperMethods.switchWindow(driver);
                HelperMethods.robotTypeString("ONBISBAT");
                Thread.sleep(2000);
                HelperMethods.robotSendTAB();
                Thread.sleep(2000);
                HelperMethods.robotTypeString("January62020");
                Thread.sleep(2000);
                HelperMethods.robotSendENTER();
                HelperMethods.selectOptionFromDropdownselectByValue("ONBIS_ADMIN", driver.findElement(By.id("apps-dropdown")), driver);
//                HelperMethods.selectOptionFromDropdownWithValueOf("Internal", driver.findElement(By.id("apps-dropdown")), driver);
//                HelperMethods.selectOptionFromDropdownselectByIndex(1, driver.findElement(By.id("apps-dropdown")), driver);
                HelperMethods.waitAndSendKeys(driver.findElement(By.id("externalToken")), "sysAdmin1", driver);
                HelperMethods.selectOptionFromDropdownselectByValue("0", driver.findElement(By.id("svcs-dropdown")), driver);
                HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//input[@type='submit']")), driver);
            }
            else {
                driver.get(System.getenv("SOAdminPortal"));
                //driver.get("https://intradev.gssso.sus.ebc.gov.on.ca/onbis/admin"); // driver.get(System.getenv("SOAdminPortal"));
                Thread.sleep(2000);
            }
        }
        else {
                  driver.get(System.getenv("epfUrl"));
        }
        soAccountLandingPage = new SOAccountLandingPage(driver);
        genericUtilsPage = new GenericUtilsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
//    void tearDown(ITestResult result) {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            genericUtilsPage.captureScreenshot(driver, result.getName());
//        }
//        if (driver != null) {
//            driver.close();
//            driver.quit();
//            threadLocalDriverFactory.getTLDriver().remove();
//        }
//    }
    void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            genericUtilsPage.captureScreenshot(driver, result.getName());
        }
        if (driver != null) {
            driver.close();
            driver.quit();
            threadLocalDriverFactory.getTLDriver().remove();
        }
    }
}
