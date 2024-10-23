package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ThreadLocalDriverFactory;
import com.onbis.Pages.GenericUtilsPage;
import com.onbis.Pages.SOAccountLandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static com.google.common.base.Ascii.toUpperCase;

public class BaseTestPartnerPortal {

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
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        System.setProperty("webdriver.edge.driver", "/usr/local/bin/MicrosoftWebDriver");
        System.setProperty("webdriver.internetExplorer.driver", "C:\\drivers\\IEDriverServer.exe");
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    void setUp(final String browser) {
        try {
            threadLocalDriverFactory.setTLDriver(browser);
            driver = getDriver();
            driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

            soAccountLandingPage = new SOAccountLandingPage(driver);
            genericUtilsPage = new GenericUtilsPage(driver);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error during setup: " + e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    void tearDown(ITestResult result) {
        try {
            if (ITestResult.FAILURE == result.getStatus()) {
                genericUtilsPage.captureScreenshot(driver, result.getName());
            }
            if (driver != null) {
                driver.close();
                driver.quit();
                threadLocalDriverFactory.getTLDriver().remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
