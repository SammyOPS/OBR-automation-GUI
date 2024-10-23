package com.onbis.Pages;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SOAdminOntarioBusinessRegistryDashboardPage extends PageObject {
    public SOAdminOntarioBusinessRegistryDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[(text() = 'Services' or . = 'Services')]")
    WebElement servicesTab;
    @FindBy(xpath = "//span[text() = 'Register Services']")
    WebElement registerServicesMenuOption;
    @FindBy(xpath = "//a[@class = 'appSubMenuName menu-companies' and @href = '#']")
    WebElement corporationsSubMenuOption;
    @FindBy(xpath = "//span[text()='Sole Proprietorship']")
    WebElement SoleProprietorshipSubMenuOption;
    @FindBy(xpath = "//span[text()='Register a Business Name for a Sole Proprietorship']")
    WebElement registerBusinessNameSoleProprietorshiSubMenuOption;


    @FindBy(xpath = "//a[@title='Onbis']")
    WebElement ontarioLogo;
    @FindBy(xpath = "(//a[@class='menu-toggle']//span)[2]")
    WebElement servicesLink;
    @FindBy(xpath = "(//a[@class='appSubMenuName menu-registers']//span)[2]")
    WebElement registerServicesLink;
    @FindBy(xpath = "(//a[@class='appSubMenuName menu-partnerships']//span)[2]")
    WebElement partnershipLink;
    @FindBy(xpath = "(//a[@class='appSubMenuLink menu-registerGeneralPartnership']//span)[2]")
    WebElement generalPartnershipLink;

    @FindBy(xpath = "//button[contains(@class,'termsAndConditionsBox-termsAndConditionsDialogBox-buttonsBox-acceptTerms')]")
    WebElement acceptButton;

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


    @FindBy(xpath = "//span[text() = 'Assign an OCN']")
    WebElement assignAnOCNSubMenuOption;
    @FindBy(xpath = "//span[text()='Incorporate a Not-for-Profit Corporation']")
    WebElement incorporateNotForProfitCorporation;
    @FindBy(xpath = "//span[text()='File Articles of Continuance under the Not-for-Profit Corporations Act, 2010']")
    WebElement fileArticlesOfContinuanceUnderTheNotForProfitCorporationsAct;
    @FindBy(xpath = "//div[contains(@class,'appAttrText appSearchCriteria')]//input[1]")
    WebElement corporationName;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement corporationNameSearch;
    @FindBy(xpath = "//label[text()='I confirm that the corporation has never been assigned an Ontario Corporation Number.']")
    WebElement iConfirm;
    @FindBy(xpath = "//span[text()='Proceed']")
    WebElement proceedButton;


    @FindBy(xpath = "//span[text() = 'Incorporate an Ontario Business Corporation']")
    WebElement incorporateOntarioBusinessCorporationSubMenuOption;
    @FindBy(xpath = "//span[text() = 'File Application for Extra-Provincial Licence for a Foreign Corporation']")
    WebElement extraProvincialLicenceForForeignCorpSubMenuOption;


    @FindBy(xpath = "(//span[text()='Business Names'])[2]")
    WebElement businessNamesSubMenuOption;
    @FindBy(xpath = "//span[text()='Register an Extra-Provincial Limited Liability Company Name']")
    WebElement registerExtraProvincialLimitedLiabilityCompanyName;


//    @FindBy(xpath = "(//span[text()='Business Names'])[3]")
//    WebElement businessNames;
//    @FindBy(xpath = "//span[text()='Register a Business Name']\n")
//    WebElement registerABusinessNames;

//    public void launchAdminPortal() {
//        HelperMethods.fluentWaitAndCheckVisible(launchAdminPortal, driver);
//        HelperMethods.waitAndClick(launchAdminPortal, driver);
//        HelperMethods.waitAndClick(launch2AdminPortal, driver);
//        HelperMethods.fluentWaitAndCheckVisible(launch2AdminPortal, driver);
//    }
    public void selectServiceAsAssignOCN() {
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        HelperMethods.waitAndClick(servicesTab, driver);
        HelperMethods.waitAndClick(registerServicesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationsSubMenuOption, driver);
        HelperMethods.waitAndClick(corporationsSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(assignAnOCNSubMenuOption, driver);
        HelperMethods.waitAndClick(assignAnOCNSubMenuOption, driver);
    }
    public void selectIncorporateNotForProfitCorporation() {
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        HelperMethods.waitAndClick(servicesTab, driver);
        HelperMethods.waitAndClick(registerServicesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationsSubMenuOption, driver);
        HelperMethods.waitAndClick(corporationsSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(incorporateNotForProfitCorporation, driver);
        HelperMethods.waitAndClick(incorporateNotForProfitCorporation, driver);
    }
    public void selectFileArticlesOfContinuanceUnderTheNotForProfitCorporationsAct() throws IOException, InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        HelperMethods.waitAndClick(servicesTab, driver);
        HelperMethods.waitAndClick(registerServicesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationsSubMenuOption, driver);
        HelperMethods.waitAndClick(corporationsSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfContinuanceUnderTheNotForProfitCorporationsAct, driver);
        HelperMethods.waitAndClick(fileArticlesOfContinuanceUnderTheNotForProfitCorporationsAct, driver);
        String randomBusinessName = HelperMethods.randomString() + " Inc.";
        logger.warn("NotForProfitCorporationsAct Business name is: " + randomBusinessName);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory +"/NFPCABusinessNumber.txt",randomBusinessName);
        HelperMethods.fluentWaitAndCheckVisible(corporationName, driver);
        HelperMethods.waitAndSendKeys(corporationName, randomBusinessName, driver);
        HelperMethods.waitAndClick(corporationNameSearch, driver);
        HelperMethods.waitAndClick(iConfirm, driver);
        Thread.sleep(2000);
        HelperMethods.waitAndClick(proceedButton, driver);

    }
    public void proceedButton() throws IOException, InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        Thread.sleep(2000);
        HelperMethods.waitAndClick(proceedButton, driver);

    }
    public void selectRegistryAsIncorporateOntarioBusinessCorporation() {
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        HelperMethods.waitAndClick(servicesTab, driver);
        HelperMethods.waitAndClick(registerServicesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationsSubMenuOption, driver);
        HelperMethods.waitAndClick(corporationsSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(incorporateOntarioBusinessCorporationSubMenuOption, driver);
        HelperMethods.waitAndClick(incorporateOntarioBusinessCorporationSubMenuOption, driver);
    }

    public void selectRegistryAsApplicationForExtraProvincialLicenceForForeignCorp() {
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        HelperMethods.waitAndClick(servicesTab, driver);
        HelperMethods.waitAndClick(registerServicesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationsSubMenuOption, driver);
        HelperMethods.waitAndClick(corporationsSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(extraProvincialLicenceForForeignCorpSubMenuOption, driver);
        HelperMethods.waitAndClick(extraProvincialLicenceForForeignCorpSubMenuOption, driver);
    }
    public void selectRegisterExtraProvincialLimitedLiabilityCompany() {
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        HelperMethods.waitAndClick(servicesTab, driver);
        HelperMethods.waitAndClick(registerServicesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(businessNamesSubMenuOption, driver);
        HelperMethods.waitAndClick(businessNamesSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerExtraProvincialLimitedLiabilityCompanyName, driver);
        HelperMethods.waitAndClick(registerExtraProvincialLimitedLiabilityCompanyName, driver);
    }
    public void selectRegistryAsSolePropRegisterBusinessNameSoleProp() {
        HelperMethods.fluentWaitAndCheckVisible(servicesTab, driver);
        HelperMethods.waitAndClick(servicesTab, driver);
        HelperMethods.waitAndClick(registerServicesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(SoleProprietorshipSubMenuOption, driver);
        HelperMethods.waitAndClick(SoleProprietorshipSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerBusinessNameSoleProprietorshiSubMenuOption, driver);
        HelperMethods.waitAndClick(registerBusinessNameSoleProprietorshiSubMenuOption, driver);
    }
    public void selectGeneralPartnerShipRegistrationService() {
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(partnershipLink, driver);
        HelperMethods.fluentWaitAndClick(partnershipLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(generalPartnershipLink, driver);
        HelperMethods.fluentWaitAndClick(generalPartnershipLink, driver);
    }

    public void acceptTermsAndConditions() {
        driver.getWindowHandle();
        HelperMethods.fluentWaitAndCheckVisible(acceptButton, driver);
        HelperMethods.fluentWaitAndClick(acceptButton, driver);
    }

    public void completeContactInformationAndSave() {
        HelperMethods.fluentLongerWaitAndCheckVisible(firstNameField, driver);
        HelperMethods.fluentWaitAndCheckVisible(confirmEmailField, driver);
        HelperMethods.waitAndSendKeys(firstNameField, Config.CONTACT_FIRST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(lastNameField, Config.CONTACT_LAST_NAME_VALUE, driver);
        HelperMethods.waitAndSendKeys(emailField, Config.CONTACT_EMAIL_VALUE, driver);
        HelperMethods.waitAndSendKeys(confirmEmailField, Config.CONTACT_CONFIRM_EMAIL_VALUE, driver);

        HelperMethods.fluentWaitAndClick(contactInformationContinueButton, driver);
    }

//    public void registerABusinessName() throws InterruptedException {
//        Thread.sleep(1000);
//        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//        HelperMethods.fluentWaitAndCheckVisible(businessNames, driver);
//        Thread.sleep(5000);
//        HelperMethods.staleElementClick(businessNames, driver);
//        HelperMethods.fluentWaitAndCheckVisible(registerABusinessNames, driver);
//        HelperMethods.fluentWaitAndClick(registerABusinessNames, driver);
//    }
}
