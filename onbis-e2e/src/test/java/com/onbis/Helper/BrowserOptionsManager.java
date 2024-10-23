package com.onbis.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class BrowserOptionsManager {
    DesiredCapabilities handleSSLError = new DesiredCapabilities();

    public ChromeOptions getChromeOptions() {
//        String addProxy = "204.40.130.129:3128";
//        String addProxy = "204.40.194.129:3128";
//
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy(addProxy);
//        proxy.setSslProxy(addProxy);


        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        //For Chrome Browser
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        chromeOptions.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
        handleSSLError = new DesiredCapabilities();
        handleSSLError.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        handleSSLError.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        handleSSLError.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        handleSSLError.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
//        handleSSLError.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, false);
        chromeOptions.merge(handleSSLError);
// ++++++++++++
        chromeOptions.addArguments("--disable-notifications");
        Map<String, Object> chromePrefs = new Hashtable<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.prompt_for_download", true);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("disable-infobars");
        // Add extension (Ruto XPath) to Chrome options
        chromeOptions.addExtensions(new java.io.File(System.getProperty("user.dir")+ "\\src\\main\\resources\\RutoXPathExtension.crx")); // Replace with your path
//
//        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--aggressive-cache-discard");
        chromeOptions.addArguments("--disable-cache");
        chromeOptions.addArguments("--disable-application-cache");
        chromeOptions.addArguments("--disable-offline-load-stale-cache");
        chromeOptions.addArguments("--disk-cache-size=0");
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--dns-prefetch-disable");
//        chromeOptions.setCapability("proxy", proxy);
//        chromeOptions.addArguments("--no-proxy-server");
//        chromeOptions.addArguments("--proxy-server=http://204.40.130.129:3128");
//         chromeOptions.addArguments("--proxy-server=http://204.40.194.129:3128");
//        chromeOptions.addArguments("--proxy-server=https://204.40.130.129:3128");
//        chromeOptions.addArguments("--proxy-bypass-list=http://204.40.130.129:3128");
//        chromeOptions.addArguments("--proxy-bypass-list=http://204.40.194.129:3128");
// Disable password manager and save password prompt
        chromeOptions.addArguments("--disable-save-password-bubble");
// Disable save card prompt
        chromeOptions.addArguments("--disable-save-card-in-browser");
        // Disable "Save Card?" popup
        chromeOptions.addArguments("--disable-save-card-in-browser");
        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--disable-browser-side-navigation");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.setProxy(null);
// ++++
//        chromeOptions.addArguments("--incognito");
        boolean enableIncognitoMode = true;
        if (enableIncognitoMode) {
            chromeOptions.addArguments("--incognito");
        }
        final HashMap<String, Object> prefs = new HashMap();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("auxiliary_profiles_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
// +++++++++++
//		String downloadFilepath = "C:\\workspace\\onbis-e2e\\src\\main\\resources";
//		String downloadFilepath = "//downloads";
//		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//		prefs.put("profile.default_content_settings.popups", 0);
//		prefs.put("download.prompt_for_download", false);
//		prefs.put("download.default_directory", downloadFilepath);
        // Use File.separator as it will work on any OS
        prefs.put("download.default_directory", Config.DOWNLOAD_PATH);
        //System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
// +++++++++++

        chromeOptions.setExperimentalOption("prefs", prefs);
// +++++++++
//        chromeOptions.addArguments("--headless", "--no-sandbox", "--window-size=1920,1080", "--disable-popup-blocking");
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//        chromeOptions.setExperimentalOption("useAutomationExtension", false);

//        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");
        return chromeOptions;
    }

    public FirefoxOptions getFirefoxOption() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("--headless", "--no-sandbox", "--window-size=1920,1080");
        firefoxOptions.addArguments("--start-maximized");
        return firefoxOptions;
    }

    public InternetExplorerOptions getIEOption() {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.requireWindowFocus();
        ieOptions.ignoreZoomSettings();
        ieOptions.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
        ieOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
        ieOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        ieOptions.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 3000);
        ieOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

//        ieOptions.setCapability("acceptInsecureCerts", true);
   //     ieOptions.setCapability("acceptSslCerts",true);
//        ieOptions.setCapability("setAcceptInsecureCerts",true);
    //    ieOptions.setCapability("acceptInsecureCerts", true);
        ieOptions.setCapability("setJavascriptEnabled", true);
        ieOptions.setCapability("nativeEvents", false);
        ieOptions.setCapability("unexpectedAlertBehaviour", "accept");
        ieOptions.setCapability("ignoreProtectedModeSettings", true);
        ieOptions.setCapability("disable-popup-blocking", true);
        return ieOptions;
    }

    public EdgeOptions getEdgeOption() {
        WebDriver driver;
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("resolution","1024x1000");
//        edgeOptions.setCapability("resolution","1024x768");
        edgeOptions.setCapability("ignore-certificate-errors" , true);
        edgeOptions.setCapability( "-remote-debugging-port", false);
        edgeOptions.setCapability("setJavascriptEnabled", true);
        edgeOptions.setCapability("ignoreProtectedModeSettings", true);
        edgeOptions.setCapability("nativeEvents", true);
        edgeOptions.getPlatform();
        return edgeOptions;
    }
    public OperaDriver getOperaOption() {
        WebDriver driver;
        OperaDriver operaOptions = new OperaDriver();
//        edgeOptions.setCapability("resolution","1024x768");
//        edgeOptions.setCapability("ignore-certificate-errors" , true);
//        edgeOptions.getPlatform();
        return operaOptions;
    }
    public ChromeOptions getChromeMobileOptions() {
        Map<String, Object> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName", "iPhone 6 Plus");
//        mobileEmulation.put("deviceName", "Nexus 7");
        mobileEmulation.put("deviceName", "iPad");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--no-sandbox", "--disable-popup-blocking");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return chromeOptions;
    }
}
