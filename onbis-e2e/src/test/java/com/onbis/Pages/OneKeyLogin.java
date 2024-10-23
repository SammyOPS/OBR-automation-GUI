package com.onbis.Pages;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OneKeyLogin extends PageObject {
//    @FindBy(name = "identifier")
//        @FindBy(id = "input28")
    @FindBy (xpath = "//input[@type='text']")
    WebElement userNameField1;
//    @FindBy(name = "credentials.passcode")
    //@FindBy(id = "okta-signin-password")
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField1;
    //@FindBy(id = "okta-signin-submit")
    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton1;

    @FindBy(id = "ldap_user")
    WebElement userNameField;
    @FindBy(id = "ldap_password")
    WebElement passwordField;
    @FindBy(id = "Login")
    WebElement loginButton;
    @FindBy(id = "myIFrame")
    WebElement loginIframe;

    @FindBy(xpath = "//*[@id=\"SignUpBold\"]/a")
    WebElement signupNowOneKeyLink;
    @FindBy(css = "input#oneKeyId")
    WebElement oneKeyId;
    @FindBy(css = "input#password1")
    WebElement password1;
    @FindBy(css = "input#password2")
    WebElement password2;
    @FindBy(css = "input#termAndCondition")
    WebElement termAndCondition;
    @FindBy(css = "select#securityQuestion1")
    WebElement securityQuestion1;
    @FindBy(css = "input#securityAnswer1")
    WebElement securityAnswer1;
    @FindBy(css = "select#securityQuestion2")
    WebElement securityQuestion2;
    @FindBy(css = "input#securityAnswer2")
    WebElement securityAnswer2;
    @FindBy(css = "select#securityQuestion3")
    WebElement securityQuestion3;
    @FindBy(css = "input#securityAnswer3")
    WebElement securityAnswer3;
    @FindBy(css = "input#recoveryEmail")
    WebElement recoveryEmail;
    @FindBy(css = "input#submitForm")
    WebElement submitForm;
    @FindBy(xpath = "//*[@id=\"Continue\"]")
    WebElement loginConfirmationContinue;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement loginConfirmationemail;
    @FindBy(xpath = "//*[@id=\"emailConfirm\"]")
    WebElement loginConfirmationemailConfirm;
    @FindBy(xpath = "//*[@id=\"chk_agree_tac\"]")
    WebElement loginConfirmationChkAgree;
    @FindBy(xpath = "//*[@id=\"tac_continue\"]")
    WebElement loginConfirmationTacContinue;

    @FindBy(xpath = "//*[@id=\"accountCreationSuccessMsg\"]/p[2]/a")
    WebElement SetupYourServiceOntarioAccountContinue;
    //div[@id='accountCreationSuccessMsg']//a[1]

    @FindBy(xpath = "//div[@class='appRestricted appRestrictedSelect']//select[1]")
    WebElement Title;

    @FindBy(xpath = "//span[text()='First Name']/following::input")
    WebElement FirstName;

    @FindBy(xpath = "//span[text()='Last Name']/following::input")
    WebElement LastName;
    @FindBy(xpath = "//span[text()='Email Address']/following::input")
    WebElement EmailAddress;
//    @FindBy(xpath = "//span[text()='Confirm Email Address']/following::input")
    @FindBy(xpath = "(//input[@placeholder='someone@example.com'])[2]")
    WebElement ConfirmEmailAddress;


    @FindBy(xpath = "//input[@placeholder='Find the address using a postal code...']")
    WebElement postalcode;
    @FindBy(xpath = "//span[text()='Find Address']")
    WebElement FindAddress;
    @FindBy(xpath = "//span[text()='Create']")
    WebElement Create;
    @FindBy(xpath = "//span[text()='Accept']")
    WebElement Accept;

// ++++++
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

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement continuetButton;

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
    // ++++++++

    public OneKeyLogin(WebDriver driver) {
        super(driver);
    }

    public void loginUsingOneKeyCredentials() throws IOException, InterruptedException {
//        driver.get(System.getenv("OneKeyUrl"));
//        HelperMethods.fluentWaitAndCheckVisible(loginIframe, driver);
//        driver.switchTo().frame(loginIframe);
//        HelperMethods.waitAndSendKeys(userNameField, System.getenv("oneKeyUserName"), driver);
//        HelperMethods.waitAndSendKeys(passwordField, System.getenv("oneKeyPassword"), driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        HelperMethods.fluentWaitAndClick(loginButton, driver);

        Thread.sleep(500);
//        driver.manage().deleteAllCookies();
//            HelperMethods.waitAndSendKeys(userNameField, System.getenv("partnerPortalUserName"), driver);
//            HelperMethods.waitAndSendKeys(passwordField, System.getenv("partnerPortalPassword"), driver);
//            HelperMethods.staleElementClick(loginButton, driver);




        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//button[@class='btn primary']")), driver);
        HelperMethods.fluentWaitAndClick((driver.findElement(By.xpath("//button[@class='btn primary']"))), driver);
        HelperMethods.
                waitAndSendKeys(userNameField1, System.getenv("partnerPortalUserName"), driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(passwordField1, System.getenv("soabPortalPassword"), driver);
        HelperMethods.staleElementClick(loginButton1, driver);

    }

    public void createONekeyID() throws IOException, InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(loginIframe, driver);
        driver.switchTo().frame(loginIframe);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        HelperMethods.highLighterMethod(driver, signupNowOneKeyLink);
        HelperMethods.fluentLongWaitAndCheckVisible(signupNowOneKeyLink, driver);
        HelperMethods.waitAndClick(signupNowOneKeyLink, driver);
        String makeOneKeyId = "soabAuto"  + System.getenv("ENV") +HelperMethods.generateRandomNumber(9999,1111);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory +"/makeOneKeyId.txt",makeOneKeyId);
        HelperMethods.waitAndSendKeys(oneKeyId, makeOneKeyId, driver);
        HelperMethods.waitAndSendKeys(password1, "TestAuto123!", driver);
        HelperMethods.waitAndSendKeys(password2, "TestAuto123!", driver);
        HelperMethods.waitAndClick(termAndCondition, driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, securityQuestion1, driver);
        HelperMethods.waitAndSendKeys(securityAnswer1, "Same as before 1", driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, securityQuestion2, driver);
        HelperMethods.waitAndSendKeys(securityAnswer2, "Same as before 2", driver);
        HelperMethods.selectOptionFromDropdownselectByIndex(1, securityQuestion3, driver);
        HelperMethods.waitAndSendKeys(securityAnswer3, "Same as before 3", driver);
        HelperMethods.waitAndSendKeys(recoveryEmail, "onbistestautomation@gmail.com", driver);
        HelperMethods.waitAndClick(submitForm, driver);
        HelperMethods.waitAndClick(loginConfirmationContinue, driver);

        HelperMethods.waitAndSendKeys(loginConfirmationemail,Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(loginConfirmationemailConfirm, Config.CONTACT_EMAIL_VALUE,driver);
        HelperMethods.waitAndClick(loginConfirmationChkAgree, driver);
        HelperMethods.waitAndClick(loginConfirmationTacContinue, driver);

        HelperMethods.waitAndClick(SetupYourServiceOntarioAccountContinue, driver);

        HelperMethods.selectOptionFromDropdownselectByIndex(1, Title, driver);
        HelperMethods.waitAndSendKeys(FirstName, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(LastName, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(EmailAddress, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(ConfirmEmailAddress, Config.CONTACT_EMAIL_VALUE, driver);


        HelperMethods.waitAndSendKeys(postalcode, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.waitAndClick(FindAddress, driver);
        HelperMethods.waitAndClick(Create, driver);
        HelperMethods.fluentWaitAndCheckVisible(Accept, driver);
        HelperMethods.waitAndClick(Accept, driver);

//        HelperMethods.fluentWaitAndCheckVisible(titleList, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf("Mr", titleList, driver);
        HelperMethods.waitAndSendKeys(firstName, Config.SO_ACCOUNT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastName, Config.SO_ACCOUNT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailValue, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailValue, Config.CONTACT_EMAIL_VALUE, driver);
//        HelperMethods.waitAndSendKeys(findAddressValue, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.staleElementClick(findAddressButton, driver);
        HelperMethods.staleElementClick(continuetButton, driver);
//        HelperMethods.staleElementClick(acceptButton, driver);
Thread.sleep(500);


    }

    public void registerNewUserSOAB() throws IOException, InterruptedException {
//        HelperMethods.fluentWaitAndCheckVisible(loginIframe, driver);
//        driver.switchTo().frame(loginIframe);
//        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//        HelperMethods.highLighterMethod(driver, signupNowOneKeyLink);
//        HelperMethods.fluentLongWaitAndCheckVisible(signupNowOneKeyLink, driver);
//        HelperMethods.waitAndClick(signupNowOneKeyLink, driver);
//        String makeOneKeyId = "soabAuto"  + System.getenv("ENV") +HelperMethods.generateRandomNumber(9999,1111);
//        File resourcesDirectory = new File("src/main/resources");
//        HelperMethods.writeToTextFile(resourcesDirectory +"/makeOneKeyId.txt",makeOneKeyId);
//        HelperMethods.waitAndSendKeys(oneKeyId, makeOneKeyId, driver);
//        HelperMethods.waitAndSendKeys(password1, "TestAuto123!", driver);
//        HelperMethods.waitAndSendKeys(password2, "TestAuto123!", driver);
//        HelperMethods.waitAndClick(termAndCondition, driver);
//        HelperMethods.selectOptionFromDropdownselectByIndex(1, securityQuestion1, driver);
//        HelperMethods.waitAndSendKeys(securityAnswer1, "Same as before 1", driver);
//        HelperMethods.selectOptionFromDropdownselectByIndex(1, securityQuestion2, driver);
//        HelperMethods.waitAndSendKeys(securityAnswer2, "Same as before 2", driver);
//        HelperMethods.selectOptionFromDropdownselectByIndex(1, securityQuestion3, driver);
//        HelperMethods.waitAndSendKeys(securityAnswer3, "Same as before 3", driver);
//        HelperMethods.waitAndSendKeys(recoveryEmail, "onbistestautomation@gmail.com", driver);
//        HelperMethods.waitAndClick(submitForm, driver);
//        HelperMethods.waitAndClick(loginConfirmationContinue, driver);

//        HelperMethods.waitAndSendKeys(loginConfirmationemail,Config.CONTACT_EMAIL_VALUE, driver);
//        HelperMethods.waitAndSendKeys(loginConfirmationemailConfirm, Config.CONTACT_EMAIL_VALUE,driver);
//        HelperMethods.waitAndClick(loginConfirmationChkAgree, driver);
//        HelperMethods.waitAndClick(loginConfirmationTacContinue, driver);
//
//        HelperMethods.waitAndClick(SetupYourServiceOntarioAccountContinue, driver);

        HelperMethods.selectOptionFromDropdownselectByIndex(1, Title, driver);
        HelperMethods.waitAndSendKeys(FirstName, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(LastName, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(EmailAddress, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(ConfirmEmailAddress, Config.CONTACT_EMAIL_VALUE, driver);
//        HelperMethods.staleElementClick(continuetButton, driver);

        HelperMethods.waitAndSendKeys(postalcode, Config.POSTAL_CODE_VALUE, driver);
        HelperMethods.waitAndClick(FindAddress, driver);
        HelperMethods.waitAndClick(Create, driver);
        HelperMethods.fluentWaitAndCheckVisible(Accept, driver);
        HelperMethods.waitAndClick(Accept, driver);

//        HelperMethods.fluentWaitAndCheckVisible(titleList, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf("Mr", titleList, driver);
        HelperMethods.waitAndSendKeys(firstName, Config.SO_ACCOUNT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastName, Config.SO_ACCOUNT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailValue, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailValue, Config.CONTACT_EMAIL_VALUE, driver);
//        HelperMethods.waitAndSendKeys(findAddressValue, Config.POSTAL_CODE_VALUE, driver);
//        HelperMethods.staleElementClick(findAddressButton, driver);
        HelperMethods.staleElementClick(continuetButton, driver);
//        HelperMethods.staleElementClick(acceptButton, driver);
        Thread.sleep(500);


    }
}


