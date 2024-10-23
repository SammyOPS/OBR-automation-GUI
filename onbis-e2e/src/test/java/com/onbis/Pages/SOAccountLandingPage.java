package com.onbis.Pages;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.Config;
import com.sun.webkit.dom.DOMWindowImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SOAccountLandingPage extends PageObject {
    public SOAccountLandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"breadcrumbs_section\"]/li/a")
    WebElement pageHeading;
    @FindBy(xpath = "//a[@id='link_addService']")
    WebElement addServiceLink;
    @FindBy(id = "myIFrame")
    WebElement iFrameProfile;
    @FindBy(xpath = "//h3[text()='Account homepage']")
    WebElement accountHomePage;
    @FindBy(xpath = "//a[@id='link_addNewProfile']")
    WebElement createANewProfileLink;
    @FindBy(xpath = "//h2[@id='OneSourceTitle']")
    WebElement selectAProfileHeading;
    @FindBy(id = "link_addNewProfile")
    WebElement addProfileLink;
    @FindBy(xpath = "(//h3[@class='side-menu'])[2]")
    WebElement recommendedHeading;
    @FindBy(xpath = "//title[contains(text(), 'Government of Ontario - ServiceOntario Account')]")
    WebElement pageTitle;
    @FindBy(xpath = "//h1[@id='content']")
    WebElement pageTitleGeneric;
    @FindBy(xpath = "//select[contains(@id,'-Title')]")
    WebElement titleList;
    @FindBy(xpath = "//div[@class='appAttrLabelBox']/following-sibling::input")
    WebElement firstName;
    @FindBy(xpath = "(//div[@class='appAttrLabelBox']/following-sibling::input)[3]")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='busniess_Name']")
    WebElement profileNameValue;
    @FindBy(id = "email")
    WebElement profileEmailValue;
    @FindBy(xpath = "//input[contains(@id,'-Email')]")
    WebElement emailValue;
    @FindBy(xpath = "//input[contains(@id,'-ConfirmEmail')]")
    WebElement confirmEmailValue;
    @FindBy(xpath = "//input[contains(@id,'-addressLookup')]")
    WebElement findAddressValue;
    @FindBy(xpath = "//a[contains(@class,'appButton registerExternalUser-userDetailsPanel-contactDetails-item1-maintainUserAddress-userAddresses-physicalAddress-newAddress-canadianAddressBox-addressLookupBox-addressLookupButton')]")
    WebElement findAddressButton;
    @FindBy(xpath = "//button[contains(@class,'appButton registerExternalUser-buttonPad-createUserButtonGroup-createUserBox-createUserButton')]")
    WebElement createButton;
    @FindBy(xpath = "//button[contains(@class,'appButton registerExtraProvincialLicenceForForeignCorporationWithShare-commonEditIncludesBox-commonEditIncludesNonInternalBox-termsAndConditionsBox-termsAndConditionsDialogBox-buttonsBox-acceptTerms')]")
    WebElement acceptButton;
    @FindBy(id = "emailConfirm")
    WebElement profileConfirmEmailValue;
    @FindBy(id = "chk_agree_tac")
    WebElement iAgreeCheckBox;
    @FindBy(xpath = "//*[@id=\"businessProfileModel\"]/div[6]/div[2]/button")
    WebElement saveProfileButton;
    @FindBy(xpath = "//a[contains(text(),'Delete profile')]")
    WebElement deleteProfileLink;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;
    @FindBy(xpath = "//a[@class='btn primary']")
    WebElement setUpCompleteContinueButton;
    @FindBy(css = "div#delete_profile_overlay>a")
    WebElement profileDeletedConfirmationButton;
    @FindBy(xpath = "//tbody[@id='service-table-body']//a[1]")
    WebElement serviceNameLink;
    @FindBy(xpath = "//*[@id=\"delete_profile_overlay\"]/a/span")
    WebElement deleteProfile;


    public static void loginEntrustSecurityStore(String entrustPassword) throws InterruptedException, AWTException {
        HelperMethods.excCommand("C://Program Files (x86)//Common Files//Entrust//ESP//eesystry.exe");
        Thread.sleep(500);
        // HelperMethods.robotSendValue("Ps1sCatalyst");
        HelperMethods.robotSendValue(entrustPassword);
        Thread.sleep(200);
        HelperMethods.robotSendTAB();
        Thread.sleep(200);
        HelperMethods.robotSendENTER();
        Thread.sleep(200);
    }
    public boolean pageElementsDisplayed() {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(pageHeading, driver);
        isCorrect = isCorrect && HelperMethods.compareText(pageHeading, Config.ACCOUNT_HOMEPAGE, logger);
        isCorrect = isCorrect && HelperMethods.compareCustomAttribute(pageTitle, "text", Config.SO_HOMEPAGE_TITLE, logger);
        isCorrect = isCorrect && HelperMethods.checkVisible(addServiceLink, logger);

        return isCorrect;
    }

    public void selectAddService() {
        HelperMethods.fluentWaitAndCheckVisible(addServiceLink, driver);
        HelperMethods.scrollIntoViewForClick(addServiceLink, driver);
        HelperMethods.waitAndClick(addServiceLink, driver);
    }


//    public void selectAddProfile() {
////        if (selectAProfileHeading.getText().equals(Config.SET_UP_YOUR_SERVICE_ONTARIO_ACCOUNT_HEADING)) {
////            HelperMethods.fluentWaitAndCheckVisible(profileConfirmEmailValue, driver);
////            profileEmailValue.sendKeys(Config.PROFILE_EMAIL_VALUE);
////            profileConfirmEmailValue.sendKeys(Config.PROFILE_EMAIL_VALUE);
////            HelperMethods.staleElementClick(iAgreeCheckBox, driver);
////            HelperMethods.staleElementClick(continueButton, driver);
////            HelperMethods.staleElementClick(setUpCompleteContinueButton, driver);
////            if (pageTitleGeneric.getText().equals(Config.REGISTER_NEW_USER_HEADING)) {
////                HelperMethods.fluentWaitAndCheckVisible(titleList, driver);
////                HelperMethods.selectOptionFromDropdownWithValueOf("Mr", titleList, driver);
////                HelperMethods.waitAndSendKeys(firstName, Config.SO_ACCOUNT_FIRST_NAME_VALUE, driver);
////                HelperMethods.waitAndSendKeys(lastName, Config.SO_ACCOUNT_LAST_NAME_VALUE, driver);
////                HelperMethods.waitAndSendKeys(emailValue, Config.CONTACT_EMAIL_VALUE, driver);
////                HelperMethods.waitAndSendKeys(confirmEmailValue, Config.CONTACT_EMAIL_VALUE, driver);
////                HelperMethods.waitAndSendKeys(findAddressValue, Config.POSTAL_CODE_VALUE, driver);
////                HelperMethods.staleElementClick(findAddressButton, driver);
////                HelperMethods.staleElementClick(createButton, driver);
////                HelperMethods.staleElementClick(acceptButton, driver);
////            }
////        } else {
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            HelperMethods.fluentWaitAndCheckVisible(selectAProfileHeading, driver);
//            HelperMethods.scrollIntoViewForClick(createANewProfileLink, driver);
////        HelperMethods.fluentWaitAndCheckVisible(recommendedHeading, driver);
//            HelperMethods.fluentWaitAndCheckVisible(addProfileLink, driver);
//            HelperMethods.waitAndClick(addProfileLink, driver);
//
//    }

    public void selectAddProfile() {
        if (selectAProfileHeading.getText().equals(Config.SET_UP_YOUR_SERVICE_ONTARIO_ACCOUNT_HEADING)) {
            HelperMethods.fluentWaitAndCheckVisible(profileConfirmEmailValue, driver);
            profileEmailValue.sendKeys(Config.PROFILE_EMAIL_VALUE);
            profileConfirmEmailValue.sendKeys(Config.PROFILE_EMAIL_VALUE);
            HelperMethods.staleElementClick(iAgreeCheckBox, driver);
            HelperMethods.staleElementClick(continueButton, driver);
            HelperMethods.staleElementClick(setUpCompleteContinueButton, driver);
            if (pageTitleGeneric.getText().equals(Config.REGISTER_NEW_USER_HEADING)) {
                HelperMethods.fluentWaitAndCheckVisible(titleList, driver);
                HelperMethods.selectOptionFromDropdownWithValueOf("Mr", titleList, driver);
                HelperMethods.waitAndSendKeys(firstName, Config.SO_ACCOUNT_FIRST_NAME_VALUE, driver);
                HelperMethods.waitAndSendKeys(lastName, Config.SO_ACCOUNT_LAST_NAME_VALUE, driver);
                HelperMethods.waitAndSendKeys(emailValue, Config.CONTACT_EMAIL_VALUE, driver);
                HelperMethods.waitAndSendKeys(confirmEmailValue, Config.CONTACT_EMAIL_VALUE, driver);
                HelperMethods.waitAndSendKeys(findAddressValue, Config.POSTAL_CODE_VALUE, driver);
                HelperMethods.staleElementClick(findAddressButton, driver);
                HelperMethods.staleElementClick(createButton, driver);
                HelperMethods.staleElementClick(acceptButton, driver);
            }
        } else {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            if (HelperMethods.fluentWaitAndCheckVisible(selectAProfileHeading, driver)) {
                HelperMethods.fluentWaitAndCheckVisible(selectAProfileHeading, driver);
                HelperMethods.scrollIntoViewForClick(createANewProfileLink, driver);
//        HelperMethods.fluentWaitAndCheckVisible(recommendedHeading, driver);
                HelperMethods.fluentWaitAndCheckVisible(addProfileLink, driver);
                HelperMethods.waitAndClick(addProfileLink, driver);
            }
        }
    }
    public void deleteProfiles() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.linkText("Account homepage")).click();
        Reporter.log("Following profiles have been deleted: --------->");
        List<WebElement> allText = driver.findElements(By.xpath("//li[@class='dashmenu']"));
        System.out.println("\nNumber of Profiles listed:" + allText.size() );
        if (allText.size() > 6)  {
            for (int i = 2; i <  (allText.size() - 5); i++) {
            //            for (int i = 1; i < allText.size() - 5; i++) {
                System.out.println("Clicking at profile in the list: " + i);
                String profileName = driver.findElement(By.xpath("//li[@class='dashmenu'][2]")).getText();
                HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//li[@class='dashmenu'][2]")));
                System.out.println(profileName);
                HelperMethods.waitAndClick(driver.findElement(By.xpath("//li[@class='dashmenu'][2]")), driver);
//                HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//li[@class='dashmenu'][" + i + "]")));
//                System.out.println(driver.findElement(By.xpath("//li[@class='dashmenu'][" + i + "]")).getText());
//                HelperMethods.waitAndClick(driver.findElement(By.xpath("//li[@class='dashmenu'][" + i + "]")), driver);
                Thread.sleep(3);
                HelperMethods.highLighterMethod(driver, driver.findElement(By.linkText("Delete profile")));
                HelperMethods.waitAndClick(driver.findElement(By.linkText("Delete profile")), driver);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                //Scroll down till the bottom of the page
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
                HelperMethods.waitAndClick(driver.findElement(By.xpath("//button[contains(@class,'btn primary')]")), driver);
                HelperMethods.highLighterMethod(driver, deleteProfile);
                driver.findElement(By.cssSelector("div#delete_profile_overlay>a>span")).click();
                Reporter.log(profileName);
            }
        }
     }
    public boolean  deleteAProfile() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Account homepage")).click();
        List<WebElement> allText = driver.findElements(By.xpath("//li[@class='dashmenu']"));
        System.out.println("\nNumber of Profiles listed:" + allText.size());
        boolean isCorrect = false;
        if (allText.size() > 6) {
            HelperMethods.highLighterMethod(driver, driver.findElement(By.xpath("//li[@class='dashmenu'][2]")));
            String profileName = driver.findElement(By.xpath("//li[@class='dashmenu'][2]")).getText();
            System.out.println(profileName);
            HelperMethods.waitAndClick(driver.findElement(By.xpath("//li[@class='dashmenu'][2]")), driver);
            Thread.sleep(3);
            HelperMethods.highLighterMethod(driver, driver.findElement(By.linkText("Delete profile")));
            HelperMethods.waitAndClick(driver.findElement(By.linkText("Delete profile")), driver);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //Scroll down till the bottom of the page
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            HelperMethods.waitAndClick(driver.findElement(By.xpath("//button[contains(@class,'btn primary')]")), driver);
            HelperMethods.highLighterMethod(driver, deleteProfile);
            driver.findElement(By.cssSelector("div#delete_profile_overlay>a>span")).click();
            Thread.sleep(3);
            isCorrect = HelperMethods.verifyElementTextNotPresent(profileName, driver);
            Reporter.log("The profile name : '" + profileName + "' has been deleted out of " + allText.size() + " profiles");
        }

        return isCorrect;
    }


//    public void completeProfileDetailsAndSave() {
//        String randomString = HelperMethods.randomString();
//        HelperMethods.fluentWaitAndCheckVisible(profileNameValue, driver);
//        HelperMethods.waitAndSendKeys(profileNameValue, Config.PROFILE_NAME_VALUE + randomString, driver);
//        logger.warn("Profile name value is: " + Config.PROFILE_NAME_VALUE + randomString);
//        HelperMethods.waitAndSendKeys(profileEmailValue, Config.PROFILE_EMAIL_VALUE, driver);
//        HelperMethods.waitAndSendKeys(profileConfirmEmailValue, Config.PROFILE_EMAIL_VALUE, driver);
//        HelperMethods.fluentWaitAndClick(saveProfileButton, driver);
//    }

    public void completeProfileDetailsAndSave() {
        String randomString = HelperMethods.randomString();
        if(HelperMethods.fluentWaitAndCheckVisible(profileNameValue, driver)) {
            HelperMethods.fluentWaitAndCheckVisible(profileNameValue, driver);
            HelperMethods.waitAndSendKeys(profileNameValue, Config.PROFILE_NAME_VALUE + randomString, driver);
            logger.warn("Profile name value is: " + Config.PROFILE_NAME_VALUE + randomString);
            HelperMethods.waitAndSendKeys(profileEmailValue, Config.PROFILE_EMAIL_VALUE, driver);
            HelperMethods.waitAndSendKeys(profileConfirmEmailValue, Config.PROFILE_EMAIL_VALUE, driver);
            HelperMethods.fluentWaitAndClick(saveProfileButton, driver);
        }
    }

    public void deleteProfile() {
        HelperMethods.fluentWaitAndCheckVisible(deleteProfileLink, driver);
        HelperMethods.waitAndClick(deleteProfileLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(continueButton, driver);
        HelperMethods.waitAndClick(continueButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(profileDeletedConfirmationButton, driver);
        HelperMethods.waitAndClick(profileDeletedConfirmationButton, driver);

    }

    public void selectServiceOntarioBusinessRegistry() {
        HelperMethods.fluentWaitAndCheckVisible(serviceNameLink, driver);
        HelperMethods.staleElementClick(serviceNameLink, driver);
    }
}