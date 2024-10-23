package com.onbis.Helper;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class ThreadLocalDriverFactory {
    BrowserOptionsManager browserOptionsManager = new BrowserOptionsManager();
    private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public synchronized void setTLDriver(String browser) {
        if (browser.equals("firefox")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(browserOptionsManager.getFirefoxOption()));
        } else if (browser.equals("chrome")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new ChromeDriver(browserOptionsManager.getChromeOptions()));
//            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        } else if (browser.equals("internetExplorer")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new InternetExplorerDriver(browserOptionsManager.getIEOption()));
        } else if (browser.equals("mobile")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new ChromeDriver(browserOptionsManager.getChromeMobileOptions()));
        } else if (browser.equals("edge")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new EdgeDriver(browserOptionsManager.getEdgeOption()));
            System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
        } else if (browser.equals("opera")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new OperaDriver((Capabilities) browserOptionsManager.getOperaOption()));
         //   System.setProperty("webdriver.opera.driver", "C:\\drivers\\operadriver.exe");
//            System.setProperty("webdriver.opera.driver", "C:\\drivers\\operadriver.exe");
            WebDriver driver = new OperaDriver();
        }
    }

    public synchronized ThreadLocal<WebDriver> getTLDriver() {
        return threadLocalDriver;
    }

}
