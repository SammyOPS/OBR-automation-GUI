package com.onbis.Pages;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class ContactInformationPage extends PageObject {
    public ContactInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id*='-FirstName']")
    WebElement firstNameField;
    @FindBy(xpath = "(//span[text()='First Name'])[2]/following::input")
    WebElement firstNameValue;
    @FindBy(xpath = "(//span[text()='Last Name'])[2]/following::input")
    WebElement lastNameValue;
    @FindBy(css = "input[id*='-LastName']")
    WebElement lastNameField;
    //    @FindBy(css = "input[id*='-Email']")
    @FindBy(xpath = "//h1[text()='Contact Information']/following::input[@placeholder='someone@example.com']")
    WebElement emailField;
    //    @FindBy(css = "input[id*='-ConfirmEmail']")
    @FindBy(xpath = "//h1[text()='Contact Information']/following::span[text()='Confirm Email Address']/following::input")
    WebElement confirmEmailField;
    @FindBy(xpath = "//h1[text()='Contact Information']/following::button")
    WebElement contactInformationContinueButton;

    @FindBy(xpath = "//span[text()='Check Name']")
    WebElement checkNameButton;

    @FindBy(xpath = "//div[@class='appFieldHelp']/following-sibling::input[1]")
    WebElement proposedBusinessName;
    @FindBy(xpath = "//div[contains(@class,'appAttributeLookup appAutoComplete')]//input[1]")
    WebElement primaryActivityType;
    @FindBy(linkText = "Truck transportation [NAICS 484]")
    private WebElement primaryActivityTypeTransportation;
    @FindBy(xpath = "//span[contains(text(),'Save and Continue')]")
    WebElement saveAndContinue;
    public void completeContactInformationAndSave() {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmEmailField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        HelperMethods.fluentWaitAndClick(contactInformationContinueButton, driver);
    }
    public void incompleteContactInformationAndSave() {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, " ", driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Last Name must be entered.']")),"Last Name","Last Name must be entered.");
        Reporter.log("-------: Last Name was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Last Name must be entered.']")).getText() + " :-------");
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, " ", driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, " ", driver);
        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Email Address must be entered.']")),"Email Address","Last Name must be entered.");
        Reporter.log("-------: Email Address was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Email Address must be entered.']")).getText() + " :-------");
        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Confirm Email Address must be entered.']")),"Confirm Email Address","Last Name must be entered.");
        Reporter.log("-------: Confirm Email Address was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Confirm Email Address must be entered.']")).getText() + " :-------");

        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmEmailField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        HelperMethods.fluentWaitAndClick(contactInformationContinueButton, driver);
    }
//    public void incompleteContactInformationAndSave() throws InterruptedException {
//        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
//        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
//        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
////        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Last Name must be entered.']")),"Last Name","Last Name must be entered.");
////        Reporter.log("-------: Last Name was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Last Name must be entered.']")).getText() + " :-------");
////        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
////        HelperMethods.waitAndClick(contactInformationContinueButton, driver);
////        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Email Address must be entered.']")),"Email Address","Last Name must be entered.");
////        Reporter.log("-------: Email Address was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Email Address must be entered.']")).getText() + " :-------");
////        HelperMethods.verifyElementText(driver.findElement(By.xpath("//div[text()='Confirm Email Address must be entered.']")),"Confirm Email Address","Last Name must be entered.");
////        Reporter.log("-------: Confirm Email Address was not entered - error message displayed as '" + driver.findElement(By.xpath("//div[text()='Confirm Email Address must be entered.']")).getText() + " :-------");
////
////        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
////        HelperMethods.fluentWaitAndCheckVisible(confirmEmailField, driver);
////        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
////        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
////        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
////        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
////
////        HelperMethods.fluentWaitAndClick(contactInformationContinueButton, driver);
//
//        String randomCorporationName = HelperMethods.randomString() + " test";
//        HelperMethods.fluentWaitAndCheckVisible(checkNameButton, driver);
//
//        HelperMethods.waitAndSendKeys(proposedBusinessName, randomCorporationName, driver);
//        logger.warn("Corporation Name is: " + randomCorporationName);
//        HelperMethods.staleElementVisible(checkNameButton, driver);
//        HelperMethods.waitAndClick(checkNameButton, driver);
//
//        HelperMethods.fluentWaitAndCheckVisible(primaryActivityType, driver);
//        HelperMethods.staleElementClick(primaryActivityType, driver);
//        HelperMethods.waitAndSendKeys(primaryActivityType, "Truck transportation", driver);
//        Thread.sleep(500);
//        HelperMethods.fluentWaitAndCheckVisible(primaryActivityTypeTransportation, driver);
//        HelperMethods.waitAndClick(primaryActivityTypeTransportation, driver);
//        HelperMethods.fluentWaitAndClick(saveAndContinue, driver);
//
//    }
    public void completeContactInformationAndSavePopUp() {
        HelperMethods.getLatestWindowFocused(driver);
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameValue, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmEmailField, driver);
        HelperMethods.waitAndSendKeys(firstNameValue, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameValue, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndClick(contactInformationContinueButton, driver);
    }

}
