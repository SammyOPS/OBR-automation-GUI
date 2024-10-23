package com.onbis.Helper;

import org.apache.commons.lang.StringUtils;
//import org.mortbay.log.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class HelperMethods {

    private static LocalDate endDate;

    public static boolean compareText(WebElement element, String string, Logger logger) {
        if (!element.getText().equals(string)) {
            logger.warn("Text doesn't match. Expected: " + string + ", but saw: " + element.getText());
            return false;
        }
        return true;
    }

    public static boolean checkVisible(WebElement element, Logger logger) {
        if (!element.isDisplayed()) {
            logger.warn(element + " is not displayed when it should be.");
            return false;
        }
        return true;
    }
    public static boolean checkObjectVisible(WebElement element) {
        boolean visible = false; // assume it is invisible
        try {
            System.out.println("Element's visibility is: " + visible);
            Assert.assertTrue(visible);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element's visibility is: " + visible);
//            visible = false;
            return false;
        }

    }
    public static boolean fluentWaitAndCheckVisible(WebElement webElement, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(90));
        wait.pollingEvery(Duration.ofMillis(200));
        wait.ignoring(StaleElementReferenceException.class, NoSuchElementException.class).until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }

    public static boolean fluentLongWaitAndCheckVisible(WebElement webElement, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(120)); // 120
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }
    public static boolean LongWaitAndCheckVisible(WebElement webElement, WebDriver driver) {
        // +++++++++
        //To wait for element visible
//
//        WebDriverWait wait = new WebDriverWait(driver, 120);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
        new WebDriverWait(driver, 120).until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated((By) webElement)));

 //       System.out.print("Text box text3 is now visible");
        return webElement.isDisplayed();
    }

    public static boolean  explicitWait(WebElement webElement, WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver,120);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable((By) webElement));
        return webElement.isDisplayed();
    }

    public static boolean fluentLongerWaitAndCheckVisible(WebElement webElement, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(90)); // wait.withTimeout(Duration.ofSeconds(2000));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }

    public static boolean checkExactElementSize(List<WebElement> list, Integer expectedSize, Logger logger) {
        if (list.size() != expectedSize) {
            logger.warn(list + " is not displayed " + expectedSize + " times.");
            return false;
        }
        return true;
    }

    public static boolean checkRegexPattern(WebElement element, String regex, Logger logger) {
        if (!element.getText().matches(regex)) {
            logger.warn("Regex pattern doesn't match. Pattern expected to be: " + regex + ", but saw text as: " + element.getText());
            return false;
        }
        return true;
    }

    public static boolean compareCustomAttribute(WebElement element, String valueType, String valueExpected, Logger logger) {
        if (!element.getAttribute(valueType).equals(valueExpected)) {
            logger.warn("Value type " + valueType + " didn't match. Expected a value of: " + valueExpected + ", but saw: " + element.getAttribute(valueType + "."));
            return false;
        }
        return true;
    }

    public static boolean compareCustomCss(WebElement element, String valueType, String valueExpected, Logger logger) {
        if (!element.getCssValue(valueType).equals(valueExpected)) {
            logger.warn("Value type " + valueType + " didn't match. Expected a value of: " + valueExpected + ", but saw: " + element.getCssValue(valueType) + ".");
            return false;
        }
        return true;
    }

    public static boolean checkDisabled(WebElement element, Logger logger) {
        if (element.isEnabled()) {
            logger.warn("Element " + element + " is enabled. Expecting it to be in the disabled state at this point of the test.");
            return false;
        }
        return true;
    }
    public static boolean verifyElementGrey(WebElement element) {
        String color = element.getCssValue("color");
       // System.out.println(color);
        if (color.equals("rgba(94, 94, 94, 1)")){
            Reporter.log("-------: '" + element.getText() + "' is disabled and greyed out - color is '" + element.getCssValue("color")+"' :-------");
            System.out.println("-------: '" + element.getText() + "' is disabled and greyed out - color is '" + element.getCssValue("color")+"' :-------");
            return true;
        }
        return false;
    }

    public static boolean verifyElementText(WebElement element, String elementName, String expectedText) {
        if (element.getText().equals(expectedText)){
            Reporter.log("-------: '" + elementName +"' field -> message displayed as '" + element.getText() + "' :-------");
            System.out.println("-------: '" + elementName +"' field -> message displayed as '" + element.getText() + "' :-------");
            return true;
        }
        return false;
    }

    public static boolean verifyElementTextNotPresent (String profileName, WebDriver driver) {
         List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'" + profileName + "')]"));
        System.out.println(" Element size" + elements.size());
        if (elements.size() == 0) {
            System.out.println("Verify Text: " + profileName + " is not present withing the application as expected. ");
            return true;

        } else {
            System.out.println("Verify Text: " + profileName + " is still present withing the application as NOT expected.");
            return false;
        }

    }


    public static boolean checkDisabledByAttribute(WebElement element, Logger logger) {
        if (!element.getAttribute("class").contains("disabled")) {
            logger.warn("Element " + element + " is enabled. Expecting it to be in the disabled state at this point of the test.");
            return false;
        }
        return true;
    }

    public static boolean radioButtonSelected(WebElement element, Logger logger) {
        if (element.isSelected()) {
            logger.warn("Radio button " + element + " is not selected. Expecting it to be selected at this point of the test.");
            return false;
        }
        return true;
    }

    public static boolean checkEnabled(WebElement element, Logger logger) {
        if (!element.isEnabled()) {
            logger.warn("Element " + element + " is disabled. Expecting it to be in the enabled state at this point of the test.");
            return false;
        }
        return true;
    }
    public static boolean checkElementEnabled(WebElement element, Logger logger) {
        if (!element.isEnabled()) {
            logger.warn("Element " + element + " is disabled. Expecting it to be in the enabled state at this point of the test.");
            return false;
        }
        return true;
    }

    public static boolean verifyElementEnabled(WebElement element, WebDriver driver) {
        if (element.isEnabled()){
            HelperMethods.highLighterMethod(driver, element);
            Reporter.log("-------: '" + element.getText() +"' -  is enabled to click. ' :-------");
            System.out.println("-------: '" + element.getText() +"' -  is enabled to click. ' :-------");
            return true;
        }
        return false;
    }

    public static boolean compareTextWithReplaceAll(WebElement element, String remove, String replace, String string, Logger logger) {
        if (!element.getText().replaceAll(remove, replace).contains(string)) {
            logger.warn("Text doesn't match. Expected: " + string + ", but saw: " + element.getText());
            return false;
        }
        return true;
    }

    public static boolean checkInvisible(boolean element, Logger logger) {
        if (!element) {
            logger.warn(element + " is displayed when it is not expected to be.");
            return false;
        }
        return true;
    }

    public static boolean checkSelectedOption(WebElement element, String option, Logger logger) {
        if (!new Select(element).getFirstSelectedOption().getText().equals(option)) {
            logger.warn("Dropdown is absent and is set to " + new Select(element).getFirstSelectedOption().getText());
            return false;
        }
        return true;
    }

    public static boolean CustomListMod(List<WebElement> elementList, int mod, Logger logger) {
        if ((elementList.size() % mod) != 0) {
            logger.warn("List size not divisible " + mod + ", List size is: " + elementList.size());
            return false;
        }
        return true;
    }

    public static void setAttribute(JavascriptExecutor js, String script) {
        try {
            js.executeScript(script);
        } catch (Exception e) {
        }
    }

    public static void sendBackspaceMultipleTimes(WebElement element) {
        System.out.println(element);
        int numberOfBackspaces = element.getAttribute("value").length();
        for (int i = 0; i < numberOfBackspaces; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public static String randomString() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomChar = new StringBuilder();
        Random rnd = new Random();
        while (randomChar.length() < 17) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            randomChar.append(CHARS.charAt(index));
        }
        String randomCharStr = randomChar.toString();
        return randomCharStr;
    }

    public static String formatDateWithPattern(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatTimeWithPattern(LocalTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public static void waitAndClick(WebElement webElement, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        HelperMethods.highLighterMethod(driver, webElement);
      // Reporter.log("WebElement '" + webElement.getText() + "'" + " was clicked", true);
        System.out.println("-------: " + "'" + webElement.getText() + "'" + " was clicked :-------");
//        String getText = webElement.getText();
        webElement.click();
//        System.out.println("-------: " + "'" + getText + "'" + " was clicked :-------");
    }

    public static void waitAndClickAction(WebElement webElement, WebDriver driver) {
        Actions hoverAction = new Actions(driver);
        webElement = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(webElement));
        HelperMethods.highLighterMethod(driver,webElement);
        hoverAction.moveToElement(webElement).moveToElement(webElement).clickAndHold().build().perform();
    }

    public static void fluentWaitAndClick(WebElement webElement, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(60)); // 80
        wait.pollingEvery(Duration.ofMillis(200));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.or(ExpectedConditions.visibilityOf(webElement), ExpectedConditions.elementToBeClickable(webElement)));
        HelperMethods.highLighterMethod(driver,webElement); // Nov 04, 2021 - Added highLighterMethod to highlight the object before click
//        Reporter.log("'" + webElement + "' was clicked  in ''" + webElement.getText() + "'" , true);
        System.out.println("-------: '"+ webElement + "' was clicked  in ''" + webElement.getText() + "' :-------");
//        String getText = webElement.getText();
        webElement.click();
//        System.out.println("-------: '"+ webElement + "' was clicked  in ''" + getText + "' :-------");
    }

    public static void staleElementClick(WebElement webElement, WebDriver driver) {
        boolean staleElement = true;
        while (staleElement) {
            try {
                webElement = new WebDriverWait(driver, 39).until(ExpectedConditions.elementToBeClickable(webElement));
                HelperMethods.highLighterMethod(driver,webElement); // Nov 04, 2021 - Added highLighterMethod to highlight the object before click
//                Reporter.log("'" + webElement + "' was clicked  in ''" + webElement.getText() + "'" , true);
                System.out.println("-------: '" + webElement + "' was clicked  in ''" + webElement.getText() + "' :-------");
//                String getText = webElement.getText();
                webElement.click();
//                System.out.println("-------: '" + webElement + "' was clicked  in ''" + getText + "' :-------");
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }
    public static void staleElementSubmit(WebElement webElement, WebDriver driver) {
        boolean staleElement = true;
        while (staleElement) {
            try {
                webElement = new WebDriverWait(driver, 39).until(ExpectedConditions.elementToBeClickable(webElement));
                HelperMethods.highLighterMethod(driver,webElement); // Nov 04, 2021 - Added highLighterMethod to highlight the object before click
//                Reporter.log("'" + webElement + "' was clicked  in ''" + webElement.getText() + "'" , true);
                System.out.println("-------: '" + webElement + "' was clicked  in ''" + webElement.getText() + "' :-------");
//                String getText = webElement.getText();
                webElement.submit();
//                System.out.println("-------: '" + webElement + "' was clicked  in ''" + getText + "' :-------");
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }
    public static void staleElementKeysEnter(WebElement webElement, WebDriver driver) {
        boolean staleElement = true;
        while (staleElement) {
            try {
                webElement = new WebDriverWait(driver, 39).until(ExpectedConditions.elementToBeClickable(webElement));
                HelperMethods.highLighterMethod(driver,webElement); // Nov 04, 2021 - Added highLighterMethod to highlight the object before click
//                Reporter.log("'" + webElement + "' was clicked  in ''" + webElement.getText() + "'" , true);
                System.out.println("-------: '" + webElement + "' was clicked  in ''" + webElement.getText() + "' :-------" );
//                String getText = webElement.getText();
                // webElement.click();
                webElement.sendKeys(Keys.ENTER);
//                System.out.println("-------: '" + webElement + "' was clicked  in ''" + getText + "' :-------" );
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }
    public static void staleElementVisible(WebElement webElement, WebDriver driver) {
        boolean staleElement = true;
        while (staleElement) {
            try {
                webElement = new WebDriverWait(driver, 33).until(ExpectedConditions.visibilityOf(webElement));
                webElement.isDisplayed();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }

    public static void fluentLongWaitAndClick(WebElement webElement, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(90));  // 1500
        wait.pollingEvery(Duration.ofMillis(600));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void fluentLongerWaitAndClick(WebElement webElement, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(60)); // 2000
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
//        Reporter.log("'" + webElement + "' was clicked  in ''" + webElement.getText() + "'" , true);
        System.out.println("-------: '" + webElement + "' was clicked  in ''" + webElement.getText() + "' :-------" );
//        String getText = webElement.getText();
        webElement.click();
//        System.out.println("-------: '" + webElement + "' was clicked  in ''" + getText + "' :-------" );
    }

    public static void fluentWaitAndSendKeys(WebElement webElement, String string, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(90)); // 250
        wait.pollingEvery(Duration.ofMillis(400));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        System.out.println("-------: '" + string + "' was typed  in ''" + webElement.getAttribute("xpath") + "' :-------" );
        webElement.sendKeys(string);
    }

    public static void waitAndSendKeys(WebElement webElement, String string, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webElement));
//        Reporter.log("'" + string + "' was typed  in ''" + webElement.getText() + "'" , true);
        System.out.println("-------: '" + string + "' was typed  in ''" + webElement.getAttribute("xpath") + "' :-------" );
//        String getText = webElement.getAttribute("xpath");
        webElement.clear();
// +++++++
//        // sending Ctrl+a by Keys.Chord()
//        String s = Keys.chord(Keys.CONTROL, "a");
//        webElement.sendKeys(s);
//        // sending DELETE key
//        webElement.sendKeys(Keys.DELETE);
// ++++
        webElement.sendKeys(string);

//        System.out.println("-------: '" + string + "' was typed  in ''" + getText + "' :-------" );

    }
    /**
     * Usage: clear(element(by.model('my.model')));
     */

    public static void waitAndTypeKeys(WebElement webElement, String string, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webElement));
//        Reporter.log("'" + string + "' was typed  in ''" + webElement.getText() + "'" , true);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='" + string +"';", webElement);
        System.out.println("-------: '" + string + "' was typed  in ''" + webElement.getAttribute("xpath") + "' :-------" );
        webElement.sendKeys(string);
    }
    public static void waitForFrame(String frame, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(60)); // 250
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    public static void selectOptionFromDropdownWithValueOf(String option, WebElement dropdown, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(60));  // 300
        wait.pollingEvery(Duration.ofMillis(400));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(dropdown));

        waitAndClick(dropdown, driver);
        Select selectDropDown = new Select(dropdown);
//        Reporter.log("'" + option + "' was selected from Dropdown '" + dropdown.getText() + "'" , true);
//        Reporter.log("'" + option + "' was selected from Dropdown '", true);
        System.out.println("-------: '" + option + "' was selected from Dropdown' :-------" );
        selectDropDown.selectByVisibleText(option);
//        System.out.println("-------: '" + option + "' was selected from Dropdown' :-------" );
    }
    public static void selectOptionFromDropdownselectByIndex(Integer option, WebElement dropdown, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(60));  // 300
        wait.pollingEvery(Duration.ofMillis(400));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(dropdown));

        waitAndClick(dropdown, driver);
        Select selectDropDown = new Select(dropdown);
//        Reporter.log("'" + option + "' was selected from Dropdown '" + dropdown.getText() + "'" , true);
//        Reporter.log("'" + option + "' was selected from Dropdown '", true);
        System.out.println("-------: '" + option + "' was selected from Dropdown' :-------" );
        selectDropDown.selectByIndex(option);

//        System.out.println("-------: '" + option + "' was selected from Dropdown' :-------" );
    }
    public static void selectOptionFromDropdownselectByValue(String option, WebElement dropdown, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(60));  // 300
        wait.pollingEvery(Duration.ofMillis(400));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(dropdown));

        waitAndClick(dropdown, driver);
        Select selectDropDown = new Select(dropdown);
//        Reporter.log("'" + option + "' was selected from Dropdown '" + dropdown.getText() + "'" , true);
//        Reporter.log("'" + option + "' was selected from Dropdown '", true);
        System.out.println("-------: '" + option + "' was selected from Dropdown' :-------" );
        selectDropDown.selectByValue(option);

//        System.out.println("-------: '" + option + "' was selected from Dropdown' :-------" );
    }

    public static void linkSubmit(WebElement link, String objectName) {
        link.submit();
        System.out.println("-------: '" + objectName + "' is clicked' :-------" );
    }
    public static void linkClick(WebElement link, String objectName) {
        link.click();
        System.out.println("-------: '" + objectName + "' is clicked' :-------" );
    }
    public static void selectOptionTextFromDropdownWithValueOf(WebElement dropdown, String[] options, WebDriver driver, Logger logger) {
        waitAndClick(dropdown, driver);
        Select selectDropDown = new Select(dropdown);
        List<WebElement> dropDownOptions = selectDropDown.getOptions();
//        List<WebElement> options = driver.findElements(option));

//     for (WebElement dropdown : options) {
//         if (option.getText().contains("DOLLAR")) {
//             option.click();
//             break;
//         }
        for (int i = 0; i < dropDownOptions.size() - 1; i++) {
            if (!compareText(dropDownOptions.get(i), options[i], logger)) {
                dropDownOptions.get(i).click();
                break;
            }
        }
    }

    public static Boolean allOptionsAvailableInDropdownFrom(WebElement dropdown, String[] options, WebDriver driver, Logger logger) {
        waitAndClick(dropdown, driver);
        Select selectDropDown = new Select(dropdown);
        List<WebElement> dropDownOptions = selectDropDown.getOptions();
        for (int i = 0; i < dropDownOptions.size() - 1; i++) {
            if (!compareText(dropDownOptions.get(i), options[i], logger)) {
                return false;
            }
        }
        return true;
    }
//
//    public static String getUrlConfiguredWithAccessToken(String url) {
//        url = url + "#access_token=";
//        if (url.contains("employer")) {
//            return url + Config.EMPLOYER_ACCESS_TOKEN;
//        } else {
//            return url + Config.ESO_ACCESS_TOKEN;
//        }
//    }
//
//    public static String getUrlConfiguredWithAccessTokenInspection(String url) {
//        url = url + "#access_token=";
//        if (url.contains("employer")) {
//            return url + Config.EMPLOYER_ACCESS_TOKEN;
//        } else {
//            return url + Config.ESO_ACCESS_TOKEN_INSPECTION;
//        }
//    }
//
//    public static String getUrlConfiguredWithAccessTokenManager(String url) {
//        url = url + "#access_token=";
//        if (url.contains("employer")) {
//            return url + Config.EMPLOYER_ACCESS_TOKEN;
//        } else {
//            return url + Config.ESO_MANAGER_TOKEN;
//        }
//    }
//
//    public static String getUrlConfiguredWithAccessTokenAdmin(String url) {
//        url = url + "#access_token=";
//        if (url.contains("employer")) {
//            return url + Config.EMPLOYER_ACCESS_TOKEN;
//        } else {
//            return url + Config.ESO_ADMIN_TOKEN;
//        }
//    }
//
//    public static String getUrlConfiguredWithAccessTokenBusinessAdmin(String url) {
//        url = url + "#access_token=";
//        if (url.contains("employer")) {
//            return url + Config.EMPLOYER_ACCESS_TOKEN;
//        } else {
//            return url + Config.ESO_BUSINESS_ADMIN_TOKEN;
//        }
//    }
//
//    public static String getUrlConfiguredWithAccessTokenSecurityAdmin(String url) {
//        url = url + "#access_token=";
//        if (url.contains("employer")) {
//            return url + Config.EMPLOYER_ACCESS_TOKEN;
//        } else {
//            return url + Config.ESO_SECURITY_ADMIN_TOKEN;
//        }
//    }

    public static boolean isElementDisplayed(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException
                | org.openqa.selenium.StaleElementReferenceException
                | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    public static boolean isElementDisplayedWait(WebElement element, WebDriver driver, int waitMillis) {
        try {
            Duration duration = Duration.ofMillis(waitMillis);
            WebDriverWait wait = new WebDriverWait(driver, duration.toMillis());
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException
                | org.openqa.selenium.StaleElementReferenceException
                | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    public static boolean isElementDisplayedNoWait(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.visibilityOf(element));
            HelperMethods.highLighterMethod(driver,element);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException
                | org.openqa.selenium.StaleElementReferenceException
                | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    public static boolean isElementDisplayedLongWait(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 95);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException
                | org.openqa.selenium.StaleElementReferenceException
                | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public static boolean isElementDisplayedLowWait(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 23);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException
                | org.openqa.selenium.StaleElementReferenceException
                | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public static void waitForElementToBeGone(WebElement element, int timeout, WebDriver driver) {
        if (isElementDisplayed(element, driver)) {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(element));
        }
    }

    public static String waitForElementInvisible(int timeOutInSeconds, WebDriver driver, WebElement element) {
        if ((driver == null) || (element == null) || element.getSize().equals(null)) {
//            return "Wrong usage of WaitforElementNotVisible()";
        }
        try {
            (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOf((element)));
            return null;
        } catch (NoSuchElementException e) {
            return "Loading spinner still visible";
        }
    }

    public static boolean isElementDisplayedFluentWait(WebElement element, WebDriver driver) {
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofSeconds(60));  // 350
            wait.pollingEvery(Duration.ofMillis(400));
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException
                | org.openqa.selenium.StaleElementReferenceException
                | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element, WebDriver driver) {
        try {
            element.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    // Added Nov 4, 2021
    public static boolean isElementVisible(WebElement element, Logger logger) {
//        logger.warn(element + " is not displayed when it should be.");
//        return element.isDisplayed();
        try {
            if (element.isDisplayed()) {
                logger.warn(element + " is  displayed.");
                return true;
            };
        } catch (NoSuchElementException e) {
            return Boolean.parseBoolean("Object is visible");
        }
        return false;
    }

    public static void waitForElementToBeGoneFluentWait(WebElement element, int timeout, WebDriver driver) {
        if (isElementDisplayedFluentWait(element, driver)) {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
        }
    }

    public static void switchTab(WebDriver driver) {
        String currentHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(currentHandle)) driver.switchTo().window(handle);
        }
    }

    public static void switchWindow(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.focus();");
    }

    public static void scrollIntoViewForClick(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
        //        JavascriptExecutor js =(JavascriptExecutor)driver;
        //        WebElement element =(WebElement)js.executeScript("document.querySelector('continueAsOntarioBusinessCorporationLink').focus()");
    }

    public static void createNewTabAndStayFocused(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.focus();");

        for (String newWindows : driver.getWindowHandles()) {
            driver.switchTo().window(newWindows);
        }
    }
// ++++
public static void createIENewTabAndStayFocused(WebDriver driver, String url) {

    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"n");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    for (String winHandle : driver.getWindowHandles())
    {
        driver.switchTo().window(winHandle);
    }
    driver.get(url);
}
// +++++
    public static void getLatestWindowFocused(WebDriver driver) {
        String mostRecentWindowHandle = null;
        for (String winHandle : driver.getWindowHandles()) {
            mostRecentWindowHandle = winHandle;
        }
        driver.switchTo().window(mostRecentWindowHandle);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.focus();");
        js = null;
    }
    // +++++ remove this ++++++
    public static final String ICON_CONFIG = "<i class='fa fa-cog' style='font-size:18px;color:blue' ></i>";
// ++++++++++++
    public static String takeScreenshot(WebDriver driver) throws IOException {
     //   File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        byte[] btDataFile = new sun.misc.BASE64Decoder().decodeBuffer(screenshotBase64);
        File of = new File("yourFile2022.png");
        FileOutputStream osf = new FileOutputStream(of);
        osf.write(btDataFile);
        osf.flush();

        return String.valueOf(btDataFile); //((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
    public static String getCurrentDateTime() {
        //return LocalTime.now();
        LocalDateTime datetime1 = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:a");
        String formatDateTime = datetime1.format(format);
        return formatDateTime;

    }
    public static String getFutureDate(int furtureDays) {
        LocalDate dateObj = LocalDate.now();
        LocalDate nextday = dateObj.plusDays(furtureDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String expieryDay= formatter.format(nextday);
        System.out.println(expieryDay);
        return expieryDay;

    }
    public static String getPreviousDate(int lastDays) {
        LocalDate dateObj = LocalDate.now();
        LocalDate nextday = dateObj.minusDays(lastDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String expieryDay= formatter.format(nextday);
        System.out.println(expieryDay);
        return expieryDay;

    }
    public static String getFutureDateFormat(int furtureDays, String dateFormate) {
        LocalDate dateObj = LocalDate.now();
        LocalDate nextday = dateObj.plusDays(furtureDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormate);
        String expieryDay= formatter.format(nextday);
        System.out.println(expieryDay);
        return expieryDay;

    }
//========
public static void robotTypeString(String keys) throws AWTException {
    String text = keys; //"onbissupporttest@ontario.ca";
    StringSelection stringSelection = new StringSelection(text);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, stringSelection);
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    System.out.println ("-------: Typed '" + keys + "' in selenium unsupported filed :-------" );
}
    public static void robotSendValue(String text) throws AWTException {
        Robot robot = new Robot();
        for(char ch:text.toCharArray()){
            if(Character.isUpperCase(ch)){
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress((int)ch);
                robot.keyRelease((int)ch);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            //    System.out.println ("-------: Typed '" + ch + "' in selenium unsupported filed :-------" );
            }else{
                char upCh = Character.toUpperCase(ch);
                robot.keyPress((int)upCh);
                robot.keyRelease((int)upCh);
              //  System.out.println ("-------: Typed '" + ch + "' in selenium unsupported filed :-------" );
            }
        }
        System.out.println ("-------: Typed '" + text + "' in selenium unsupported filed :-------" );
    }

    public static void robotSendENTER() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(100);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(100);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println ("-------: Pressed 'ENTER' in selenium unsupported filed :-------" );
    }
    public static void robotSendTAB() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        System.out.println ("-------: Pressed 'TAB' in selenium unsupported filed :-------" );
        robot.keyRelease(KeyEvent.VK_TAB);
    }
    public static void robotSendTABMultipleTimes(int num) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        for (int i = 0; i < num; i++){
            robot.keyPress(KeyEvent.VK_TAB);
            System.out.println("-------: Pressed 'TAB':-------");
            Thread.sleep(300);
        }
        robot.keyRelease(KeyEvent.VK_TAB);
    }
    public static void robotSendShiftTAB() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_TAB);
        System.out.println ("-------: Pressed 'TAB':-------" );
    }
    public static void robotSendPaste() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println ("-------: Pressed 'Paste':-------" );
    }
//=========

//    public static void highLighterMethod(WebDriver driver, WebElement element, int blinks) throws Exception{
//        for (int i = 0; i < blinks; i++) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", element);
//            Thread.sleep(100);
//            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; blue: 2px solid green;');", element);
//        }
//    }
//Creating a custom function
public static void highLighterMethod(WebDriver driver, WebElement element){
    new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
    //UnhighlightElement(driver,element);

    js.executeScript("arguments[0].setAttribute('style', 'background: lime; border: 3px solid red;');", element); // aqua, springgreen, mediumspringgreen
    //js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
//    try {
//        TimeUnit.MILLISECONDS.sleep(200);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
  //  UnhighlightElement(driver,element);
}
    public static WebDriver UnhighlightElement(WebDriver driver, WebElement element){
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border=''", element);
        }
        return driver;
    }
    /* Convert long type milliseconds to format hh:mm:ss */
    public String milisecondsToHours(int miliseconds) {
        int seconds = ( miliseconds / 1000 ) % 60;
        int minutes  = ( miliseconds / 60000 ) % 60;     // 60000   = 60 * 1000
        int  hours    = miliseconds / 3600000;            // 3600000 = 60 * 60 * 1000
        return String.format( "%02d:%02d:%02d", hours, minutes,seconds );
    }
    // +++++++
    // +++++++
    public static String writeToTextFile(String fileToWrite, String textToWrite) throws IOException {
//        File filename = new File(fileToWrite);
//        FileWriter fw = new FileWriter(filename);
//        fw.write(textToWrite);
//        fw.write(System.lineSeparator());
//        fw.close();
//        return textToWrite;
        File filename = new File(fileToWrite);
        if(!filename.exists()){
            FileWriter fw = new FileWriter(filename);
            fw.write(textToWrite);
            fw.close();
        }
        if(filename.exists()) {
            String readText = readFile(fileToWrite);
            FileWriter fw = new FileWriter(filename);
            fw.write(textToWrite + System.lineSeparator());
            fw.write(readText);
            fw.close();
        }

        return textToWrite;
    }
    public static String readFromTextFile(String fileToWrite) throws IOException {
        File filename = new File(fileToWrite);
        BufferedReader br = new BufferedReader(new FileReader(fileToWrite));
        String  st;
        while ((st = br.readLine()) !=null){
            System.out.println("-------: Value '" + st +"' read from text file :-------");
            br.close();
            return st;
        }
        br.close();
        return st;
    }
    // ++++++
    public static boolean deleteFile(String fileToDelete) {
        {
            try
            {
                File file = new File(fileToDelete);             //creates a file instance
                Thread.sleep(1000);
                file.delete();                                   //deletes the file
                //file.deleteOnExit();                           //deletes the file
                System.out.println("-------: File '" + fileToDelete + "' has been deleted. :-------");
                //  Thread.sleep(1000);
                return true;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("-------: File '" + fileToDelete + "' has been NOT been deleted. :-------");
                return false;
            }
        }
    }
// ++++++++

    // +++++++++
    public static String readFile(String fileToRead) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(fileToRead));
        return new String(encoded, StandardCharsets.UTF_8);
    }
    // ++++++
    public static String getTextBetween(final String wholeString, final String str1, String str2) {
        String s = null;
        try {
            s = wholeString.substring(wholeString.indexOf(str1) + str1.length());
            s = s.substring(0, s.indexOf(str2));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String index out of bounds. String length: " + s.length());
        }
        return s;
    }
    public static String boundaryValue(String leftB, String rightB, WebDriver driver) {
        String s = null;
        HelperMethods.getLatestWindowFocused(driver);
        System.out.println("-------: Page URL:" + driver.getCurrentUrl() +" :-------");
        List<WebElement> elements = driver.findElements(By.xpath(".//*"));
        //  System.out.println("-------: Number of elements: " + elements.size()+" :-------");
        for (int i = 0; i < elements.size(); i++) {
            if (i == 0) {
                s = elements.get(0).getText();
                s = StringUtils.substringBetween(s, leftB, rightB);
                System.out.println("-------: Value '"+ s +"' between Left Boundary'" + leftB + "' and Right Boundary '" + rightB+" :-------");
                //  System.out.println("Nuas number is -:" + s);
            }
        }
        return s;
    }

//
public static String getNumberFromString(String strContent, String strPattern) {
    String getValue = null;
    Pattern pattern = Pattern.compile(strPattern);
    Matcher matcher = pattern.matcher(strContent);

    while( matcher.find() ) {
//        System.out.println("match is: " + matcher.group() );
        getValue = matcher.group();
    }
    return getValue;
}
//
    public static void waitForPopoUp(WebDriver driver, int waitTime) {
        final int currentWindows = driver.getWindowHandles().size();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(waitTime))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (d.getWindowHandles().size() != currentWindows);
            }
        });
    }
    public static boolean isAlertPresent(WebDriver driver){
        boolean foundAlert = false;
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
//            Assert.assertTrue(alert.getText().contains("Block"));
            alert.accept();
            foundAlert = true;

        }catch (Exception e)
        {
            System.out.println(" No Alert");
            foundAlert = false;
        }
        return foundAlert;
//        boolean foundAlert = false;
//        WebDriverWait wait = new WebDriverWait(driver, 0 /*timeout in seconds*/);
//        try {
//            wait.until(ExpectedConditions.alertIsPresent());
//            foundAlert = true;
//        } catch (TimeoutException eTO) {
//            foundAlert = false;
//        }
//        return foundAlert;
    }
    public static String getNumberFromString(String leftB, String rightB, WebDriver driver) {
        HelperMethods.getLatestWindowFocused(driver);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//*")));
        String getString = null;
        System.out.println("-------: Page URL:" + driver.getCurrentUrl() +" :-------");
        String str = driver.findElement(By.xpath("//*")).getText();
        // System.out.println(str);
        getString= StringUtils.substringBetween(str, leftB, rightB);
        System.out.println("-------: Value '"+ getString+"' between Left Boundary'" + leftB + "' and Right Boundary '" + rightB+" :-------");
        return getString;
    }
    public static void excCommand(String command){
        try
        {
            Process process = Runtime.getRuntime().exec(command);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // ++++++++
    public static String uniqueDateString() {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        return dateName;
    }
    // ++++++++
    public static String getClipBoard(){
        try {
            return (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedFlavorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
    public static Integer generateRandomNumber(int max, int min){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

//
//private static final String csvFileName = "OCN_Number_OBR_Automation.csv";
//static String csvFileName = Config.CSV_FILE_NAME ;
public static void writeToCSV(String scriptName, String value) {
    // Timestamp
    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

    // Directory path
    String outputPath = System.getProperty("user.dir") + "/test-output/";

    // Ensure directory exists, if not create it
    File outputDirectory = new File(outputPath);
    if (!outputDirectory.exists()) {
        outputDirectory.mkdirs();
    }

    // CSV file path
    String csvFile = outputPath + Config.CSV_FILE_NAME;

    try {
        FileWriter writer = new FileWriter(csvFile, true);

        // Check if file exists, if not create it and add header
        if (!fileExists(csvFile)) {
            writer.append("Timestamp,Script Name,Transaction Number Value\n");
        }

        // Append data
        writer.append(String.format("%s,%s,%s\n", timeStamp, scriptName, value));

        // Close the writer
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }
    // HelperMethods.isObjectPresentByXpath(driver, lastPageXpath);
    public static int isObjectPresentByXpath(WebDriver driver, String element)
    {
        // identify element
        List<WebElement> l= driver.findElements(By.xpath(element));
        //  List<WebElement> l=driver.findElements(By.xpath("//*[@id=\"lastPage\"]"));
        if(l.size()== 0){
            // empty list if no matching element
            System.out.println("Element not present, appearing "+l.size()+ " time");
            return l.size();
        } else {
            System.out.println("Element present, appearing "+l.size()+ " time");
            return l.size();
        }
    }

    // Function to handle file upload
    public static void uploadFileAutoIT(WebElement uploadButton, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait for the upload button to be clickable and click it
        HelperMethods.highLighterMethod(driver,uploadButton);
        wait.until(ExpectedConditions.elementToBeClickable(uploadButton)).click();

        // Call the AutoIt executable to handle the file upload dialog
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Upload.exe");
//            Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir")+ "\\Upload.vbs");
//            System.out.println("'wscript " + System.getProperty("user.dir")+ "\\Upload.vbs' - is executed to upload file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to handle file upload
    public static void uploadFile(WebElement uploadButton, WebDriver driver, String filePath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait for the upload button to be clickable and click it
//        wait.until(ExpectedConditions.elementToBeClickable(uploadButton)).click();

        // Find the file input element
//        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//input[@type='file']")));
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

        // Upload the file using the file input element
        fileInput.sendKeys(filePath);
        System.out.println("-------: 'File uploaded :-------");
    }
}
