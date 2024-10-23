package com.onbis.Pages;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PartnerPortalLandingPage extends PageObject {
    public PartnerPortalLandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[@class='menu-toggle']//span)[2]")
    WebElement servicesLink;
    @FindBy(xpath = "(//a[@class='appSubMenuLink menu-registerItemSearch']//span)[2]")
    WebElement searchTheRegistryLink;
    @FindBy(xpath = "//button[contains(@class,'appButton registerItemSearch-tabs-criteriaAndButtons-buttonPad-search')]")
    WebElement searchButton;
    @FindBy(id = "QueryString")
    WebElement searchField;
    @FindBy(xpath = "//h2[text()='Owner']")
    WebElement ownerTitle;
    @FindBy(xpath = "(//a[contains(@class,'registerItemSearch-results-page-line-ItemBox-resultLeft-viewMenu')]//span)[2]")
    WebElement searchResultsCorporation;
    @FindBy(xpath = "//div[contains(@class,'appRepeaterRowContent appRowOdd')]")
    WebElement searchResults;
    @FindBy(xpath = "(//a[@class='appSubMenuName menu-registers']//span)[2]")
    WebElement registerServicesLink;
    @FindBy(xpath = "(//a[@class='appSubMenuName menu-companies']//span)[2]")
    WebElement corporationsLink;
    @FindBy(xpath = "//li[contains(@class,'menu-brRegisterLocalCompany appDoItNowReg')]//a[1]")
    WebElement ontarioBusinessCorporationLink;
    @FindBy(xpath = "//span[text()='File Application for Extra-Provincial Licence for a Foreign Corporation']")
    WebElement fileApplicationForEPLForeignCorpLink;
    @FindBy(xpath = "(//a[@class='appSubMenuName menu-partnerships']//span)[2]")
    WebElement partnershipLink;
    @FindBy(xpath = "//span[text()='Register a Firm Name for a General Partnership']")
    WebElement aFirmNameForAGeneralPartnershipLink;

    @FindBy(xpath = "//span[text()='File a Declaration of an Ontario Limited Partnership']")
    WebElement ontarioLimitedPartnershipLink;
    @FindBy(xpath = "//span[contains(text(),'Register a Firm Name for an Ontario Limited Liabil')]")
    WebElement registerFirmNameOntarioLimitedLink;
    @FindBy(xpath = "//span[text()='File a Declaration of an Extra-Provincial Limited Partnership']")
    WebElement declarationExtraProvincialLink;
    @FindBy(xpath = "//span[text()='Register a Firm Name for an Extra-Provincial Limited Liability Partnership']")
    WebElement registerFirmNameForExtraProvincialLimitedLink;
    @FindBy(xpath = "//span[contains(text(),'Completed')]")
    WebElement completedSubMenuOption;
    @FindBy(xpath = "(//a[@class='appSubMenuLink menu-registerExtraProvincialLimitedPartnership']//span)[2]")
    WebElement fileDeclarationOfEPLLPLink;
    @FindBy(xpath = "(//a[@class='appSubMenuLink menu-registerOntarioLimitedLiabilityPartnership']//span)[2]")
    WebElement registerOntarioLimitedLiabilityPartnership;

    @FindBy(xpath = "(//a[@class='appSubMenuLink menu-registerGeneralPartnership']//span)[2]")
    WebElement generalPartnershipLink;
    @FindBy(xpath = "//div[contains(@class, 'dashboardInternal-contentInternal-contentTabs-myFb-mySubmittedList-ServiceInstances-PrimaryName')]")
    WebElement incorporationNameValue;
    @FindBy(xpath = "//div[contains(@class,'appAttrText dashboardExternal-contentExternal-tabs-myFbBox-myFb-mySubmittedList-ServiceInstances-description-Description')]//div")
    WebElement incorporationNameNumber;
    @FindBy(xpath = "//div[contains(@class,'appAttrText dashboardInternal-contentInternal-contentTabs-myFb-mySubmittedList-ServiceInstances-description-Description')]//div")
    WebElement incorporationNameNumberAdminPortal;


    @FindBy(xpath = "(//a[contains(@class,'registerItemSearch-results-page-line-ItemBox-resultLeft-viewMenu appMenu')]//span)[2]")
    WebElement businessNamesSearchResultLink;

    @FindBy(xpath = "(//a[contains(@class,'registerItemSearch-results-page-line-ItemBox-resultLeft-viewMenu appMenu')]//span)[2]")
    WebElement businessNamesSearchLink;
    @FindBy(xpath = "//span[text()='Correct the Register']")
    WebElement CorrectTheRegisterClick;

    @FindBy(xpath = "(//button[@class='appMenu appSubMenuName'])[2]")
    WebElement makeChangesMenu;
//    @FindBy(xpath = "(//a[contains(@class,'viewBusinessNameSoleProp-businessNameMenusBox-item2-renewBusinessNameSoleProp appMenu')]//span)[2]")
@FindBy(xpath = "//span[@class='appReceiveFocus' and text()='Renew']/parent::a")
    WebElement renewBusinessName;
    @FindBy(xpath = "//span[text()='File Application for Authorization to Continue Out of the Business Corporations Act']")
    WebElement fileArticlesOfAuthorizationContinueOutOfBusinessOption;
    @FindBy(xpath = "//span[text()='Instrument of Continuance']")
    WebElement instrumentOfContinuance;
    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']")
    WebElement reregistrationDate;
    @FindBy(xpath = "//div[@class='appRestricted appRestrictedSelect']//select[1]")
    WebElement selectCorporationType;
    @FindBy(xpath = "//span[text()='-- Please Select --']")
    WebElement selectGoverningJurisdiction;

    @FindBy(xpath = "select2-results__option select2-results__option--highlighted")
    WebElement partnerTextArea;
    @FindBy(xpath = "//span[@role='textbox']")
    WebElement selectFromPartnersDropdown;
    @FindBy(xpath = "//li[contains(@id,'CA')]")
    WebElement selectCanada;
    @FindBy(xpath = "(//span[@role='textbox'])[2]")
    WebElement selectFromProvinceDropdown;
    @FindBy(xpath = "//li[contains(@id,'Alberta')]")
    WebElement selectProvince;

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
    @FindBy(xpath = "//*[@id=\"sentForReviewDialogOkButton\"]/span")
    WebElement sentForReviewDialogOkButton;
    @FindBy(xpath = "//tbody[@id='service-table-body']//a[1]")
    WebElement serviceNameLink;
    @FindBy(xpath = "//h1[@id='content']")
    WebElement pageTitle;
    @FindBy(xpath = "(//a[@class='appFilingOpen']//span)[1]")
    WebElement fileADeclarationFiling;
    @FindBy(xpath = "//div[text()='Transaction Number']/following-sibling::div")
    WebElement transactionNumberValue;
    @FindBy(xpath = "//div[contains(@class,'appFilingDetailObjectName')]")
    WebElement particularsValue;



    @FindBy(xpath = "//span[text()='Filings']")
    WebElement filingsOption;
    @FindBy(xpath = "//div[contains(@class,'brViewLocalCompany-companyMenusBox-item')]")
    WebElement makeChangesMenuOption;
    @FindBy(xpath = "//h2[text()='Filings']")
    WebElement filingsHeading;
    @FindBy(xpath = "//span[contains(text(),'BCA - Articles of Incorporation')]")
    WebElement businessIncorporationOutOfBusinessLink;

    @FindBy(xpath = "//a[@class='appFilingOpen']//span")
    WebElement windingUpNotForProfitCorporationLink;



//    @FindBy(xpath = "//a[contains(@class,'brViewLocalCompany-companyMenusBox-item3-maintainNoticeOfChangeCIA')]")
    @FindBy(xpath = "//span[text()='File Notice of Change']")
    WebElement fileNoticeOfChangeSubMenuOption;


    @FindBy(xpath = "//span[text()='File Notice of Change']")
    WebElement FileNoticeOfChangeMenu;

    @FindBy(xpath = "//span[contains(text(), 'File Initial Return')]")
    WebElement fileInitialReturnSubMenu;
    @FindBy(xpath = "//span[contains(text(), 'File Annual Return')]")
    WebElement fileAnnualReturnSubMenu;
    @FindBy(xpath = "//a[contains(@id, '_filings')]")
    WebElement filingsSubMenuOption;
    @FindBy(xpath = "//span[text()='Cancel']")
    WebElement cancelBusinessName;
    @FindBy(xpath = "//span[contains(text(),'Amend')]")
    WebElement amendOption;
    @FindBy(xpath = "(//span[text()='Business Names'])[2]")
    WebElement businessNamesMenu;
    @FindBy(xpath = "(//span[text()='Business Names'])[3]")
    WebElement businessANamesMenu;

    @FindBy(xpath = "//span[text()='Register a Business Name']")
    WebElement registerBusinessNameOption;
    @FindBy(xpath = "(//a[@class='appSubMenuName menu-businessnames']//span)[2]")
    WebElement businessNamesLink;
    @FindBy(xpath = "(//a[@class='appSubMenuLink menu-registerExtraProvincialLLCName']//span)[2]")
    WebElement extraProvincialLimitedLiabilityLink;
    @FindBy(xpath = "//a[@class='appSubMenuName menu-soleProp']")
    WebElement soleProprietorshipLink;
    @FindBy(xpath = "(//a[@class='appSubMenuLink menu-registerBusinessNameSoleProp']//span)[2]")
    WebElement registerSoleProprietorshipLink;
    @FindBy(xpath = "//a[@title='Onbis']")
    WebElement ontarioLogo;

    @FindBy(xpath = "(//div[@class='appAttrValue'])[3]")
    WebElement onbisOCN;
    @FindBy(xpath = "(//div[@class='appAttrValue'])[2]")
    WebElement onbisOCN1;
    //div[contains(@class,'appAttrText dashboardInternal-contentInternal-contentTabs-myFb-mySubmittedList-ServiceInstances-description-Description')]//div

    public void selectSoleProprietorshipOption() {
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(soleProprietorshipLink, driver);
        HelperMethods.fluentWaitAndClick(soleProprietorshipLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerSoleProprietorshipLink, driver);
        HelperMethods.fluentWaitAndClick(registerSoleProprietorshipLink, driver);
    }
    public void CompletedOCNwriteToCSV(String scriptName) throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(@class, 'appSpaces1') and contains(@class, 'appLines1') and contains(text(), 'Completed')]")), driver);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("(//div[contains(@class, 'appAttrValue')])[2]")));
        String oCN = driver.findElement(By.xpath("(//div[contains(@class, 'appAttrValue')])[2]")).getText();
        System.out.println("Ontario Corporation Number (OCN) number is: " + oCN);
        HelperMethods.writeToCSV(scriptName, oCN);
    }

    public void selectSearchRegistry() throws InterruptedException {
        Thread.sleep(1000);
//        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        Thread.sleep(5000);
        HelperMethods.staleElementClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchTheRegistryLink, driver);
        HelperMethods.fluentWaitAndClick(searchTheRegistryLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchButton, driver);
    }
    public void GeneralDetailsOCNwriteToCSV(String scriptName) throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(@class, 'appSpaces1')][contains(@class, 'appLines1')][text()='General Details']")), driver);
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("(//div[@class='appAttrValue'])[3]")));
        String oCN = driver.findElement(By.xpath("(//div[@class='appAttrValue'])[3]")).getText();
        System.out.println("Ontario Corporation Number (OCN) number is: " + oCN);
        HelperMethods.writeToCSV(scriptName, oCN);
    }
    public String advanceSearchByEntityRegisterSubTypeStatus(String entityName, String register,String entitySubType,String status) throws InterruptedException {
        Thread.sleep(1000);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        Thread.sleep(5000);
        HelperMethods.staleElementClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchTheRegistryLink, driver);
        HelperMethods.fluentWaitAndClick(searchTheRegistryLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchButton, driver);

        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//a[@class='appRestrictedExpand appRestrictedExpandCollapsed']//span)[2]")), driver);
        Thread.sleep(1000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.cssSelector("input#QueryString")), entityName, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf(register, driver.findElement(By.cssSelector("select#SourceAppCode")), driver);
        Thread.sleep(1000);
        HelperMethods.selectOptionFromDropdownWithValueOf(entitySubType, driver.findElement(By.cssSelector("select#EntitySubTypeCode")), driver);


        Thread.sleep(1000);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//label[text()='Exact Match']")), driver);
        //label[text()='Exact Match']
        Thread.sleep(2000);
        HelperMethods.selectOptionFromDropdownWithValueOf(status, driver.findElement(By.xpath("(//div[contains(@class,'appSearchCriteriaRestrictedSelect appRestricted')]//select)[3]")), driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(searchButton, driver);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        Thread.sleep(3000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//div[text()='Search Results']/following-sibling::div")), driver);
        String results = driver.findElement(By.xpath("//div[text()='Search Results']/following-sibling::div")).getText();
        if (results.contains("'No results found.")){
            Reporter.log("Search Result for: " + entityName + driver.findElement(By.cssSelector("div#appSearchNoResults")).getText() );
            return driver.findElement(By.cssSelector("div#appSearchNoResults")).getText();
        }
        Thread.sleep(3000);
        if (results.contains("10")){
            results = searchResultsCorporation.getText();
            Reporter.log("Search Result for: " + entityName + searchResultsCorporation.getText() );
            System.out.println("Search Result for: " + entityName + searchResultsCorporation.getText() );
            HelperMethods.fluentWaitAndCheckVisible(searchResultsCorporation, driver);
            HelperMethods.staleElementClick(searchResultsCorporation, driver);
          //  results = entityName;
        }
        return results;
    }

    public String searchByEntity(String entityName) throws InterruptedException {
        Thread.sleep(1000);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        Thread.sleep(5000);
        HelperMethods.staleElementClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchTheRegistryLink, driver);
        HelperMethods.fluentWaitAndClick(searchTheRegistryLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchButton, driver);

        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("(//a[@class='appRestrictedExpand appRestrictedExpandCollapsed']//span)[2]")), driver);
        Thread.sleep(4000);
        HelperMethods.waitAndSendKeys(driver.findElement(By.cssSelector("input#QueryString")), entityName, driver);
//        HelperMethods.selectOptionFromDropdownWithValueOf(register, driver.findElement(By.cssSelector("select#SourceAppCode")), driver);
//        Thread.sleep(1000);
//        HelperMethods.selectOptionFromDropdownWithValueOf(entitySubType, driver.findElement(By.cssSelector("select#EntitySubTypeCode")), driver);
//
//
//        Thread.sleep(1000);
//        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//label[text()='Exact Match']")), driver);
//        //label[text()='Exact Match']
//        Thread.sleep(2000);
//        HelperMethods.selectOptionFromDropdownWithValueOf(status, driver.findElement(By.xpath("(//div[contains(@class,'appSearchCriteriaRestrictedSelect appRestricted')]//select)[3]")), driver);
        Thread.sleep(5000);
        HelperMethods.fluentWaitAndCheckVisible(searchButton, driver);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        Thread.sleep(3000);
//        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//div[text()='Search Results']/following-sibling::div")), driver);
        String results = driver.findElement(By.xpath("//div[text()='Search Results']/following-sibling::div")).getText();
        if (results.contains("'No results found.")){
            Reporter.log("Search Result for: " + entityName + driver.findElement(By.cssSelector("div#appSearchNoResults")).getText() );
            return driver.findElement(By.cssSelector("div#appSearchNoResults")).getText();
        }
        Thread.sleep(3000);
        if (results.contains("10")){
            results = searchResultsCorporation.getText();
            Reporter.log("Search Result for: " + entityName + searchResultsCorporation.getText() );
            System.out.println("Search Result for: " + entityName + searchResultsCorporation.getText() );
            HelperMethods.fluentWaitAndCheckVisible(searchResultsCorporation, driver);
            HelperMethods.staleElementClick(searchResultsCorporation, driver);
            //  results = entityName;
        }
        return results;
    }
    public String getCompletedOntarioCorporationNumber() throws InterruptedException {
        Thread.sleep(10000);
        String ontarioCorporationNumber = null;
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Completed ']")), driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Completed ']")),driver);
//        boolean yesOrNo = HelperMethods.isElementDisplayedWait(driver.findElement(By.xpath("//span[text()='Completed ']")),driver,1);
//        System.out.println(yesOrNo);
//        if (yesOrNo) {
//            HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Completed ']")), driver);
//        }
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Completed ']")), driver);
        Thread.sleep(3000);
        HelperMethods.highLighterMethod(driver, onbisOCN1);
//        HelperMethods.fluentWaitAndCheckVisible(pageTitle, driver);
        String ontarioCorporationName = onbisOCN1.getText();
        ontarioCorporationNumber = HelperMethods.getNumberFromString(ontarioCorporationName,"\\d+") ;
        logger.warn("Ontario Corporation Number (OCN) number is: " + ontarioCorporationNumber);
        Reporter.log("Ontario Corporation Number (OCN) number is: " + ontarioCorporationNumber);
        return ontarioCorporationNumber;
    }

    public String getOntarioCorporationQueueNumber() throws InterruptedException {
        Thread.sleep(3000);
        String ontarioCorporationNumber = null;
//        boolean yesOrNo = HelperMethods.isElementDisplayedWait(driver.findElement(By.xpath("//span[text()='Completed ']")),driver,1);
//        System.out.println(yesOrNo);
//        if (yesOrNo) {
//            HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Completed ']")), driver);
//        }
//        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Completed ']")), driver);
        Thread.sleep(3000);
        HelperMethods.highLighterMethod(driver, onbisOCN1);
//        HelperMethods.fluentWaitAndCheckVisible(pageTitle, driver);
        String ontarioCorporationName = onbisOCN1.getText();
        ontarioCorporationNumber = HelperMethods.getNumberFromString(ontarioCorporationName,"\\d+") ;
        logger.warn("Ontario Corporation Number (OCN) number is: " + ontarioCorporationNumber);
        Reporter.log("Ontario Corporation Number (OCN) number is: " + ontarioCorporationNumber);
        return ontarioCorporationNumber;
    }

    public String getOntarioCorporationCompletedNumber() throws InterruptedException {
        Thread.sleep(3000);
        String ontarioCorporationNumber = null;
        boolean yesOrNo = HelperMethods.isElementDisplayedWait(driver.findElement(By.xpath("//span[text()='Completed ']")),driver,1);
        System.out.println(yesOrNo);
        if (yesOrNo) {
            HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Completed ']")), driver);
        }
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Completed ']")), driver);
        Thread.sleep(3000);
        HelperMethods.highLighterMethod(driver, onbisOCN1);
//        HelperMethods.fluentWaitAndCheckVisible(pageTitle, driver);
        String ontarioCorporationName = onbisOCN1.getText();
        ontarioCorporationNumber = HelperMethods.getNumberFromString(ontarioCorporationName,"\\d+") ;
        logger.warn("Ontario Corporation Number (OCN) number is: " + ontarioCorporationNumber);
        Reporter.log("Ontario Corporation Number (OCN) number is: " + ontarioCorporationNumber);
        return ontarioCorporationNumber;
    }
    public void selectEPLLService() {
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(businessNamesLink, driver);
        HelperMethods.fluentWaitAndClick(businessNamesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(extraProvincialLimitedLiabilityLink, driver);
        HelperMethods.fluentWaitAndClick(extraProvincialLimitedLiabilityLink, driver);
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

    public void selectEPLLPRegistrationService() {
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(partnershipLink, driver);
        HelperMethods.fluentWaitAndClick(partnershipLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileDeclarationOfEPLLPLink, driver);
        HelperMethods.fluentWaitAndClick(fileDeclarationOfEPLLPLink, driver);
    }

    public void selectOntarioLimitedLiabilityPartnershipRegistrationService() {
//        Register a Firm Name for an Ontario Limited Liability Partnership
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(partnershipLink, driver);
        HelperMethods.fluentWaitAndClick(partnershipLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerOntarioLimitedLiabilityPartnership, driver);
        HelperMethods.fluentWaitAndClick(registerOntarioLimitedLiabilityPartnership, driver);
    }

    public void selectOntarioBusinessCorporationRegistrationService() throws InterruptedException {
        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationsLink, driver);
        HelperMethods.fluentWaitAndClick(corporationsLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(ontarioBusinessCorporationLink, driver);
        HelperMethods.fluentWaitAndClick(ontarioBusinessCorporationLink, driver);
    }

    public void selectFileApplicationForExtraProvincialLicenceForeignCorpService() {
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationsLink, driver);
        HelperMethods.fluentWaitAndClick(corporationsLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileApplicationForEPLForeignCorpLink, driver);
        HelperMethods.fluentWaitAndClick(fileApplicationForEPLForeignCorpLink, driver);
    }

    public void selectSearchResult() {
        HelperMethods.fluentWaitAndCheckVisible(businessNamesSearchResultLink, driver);
        HelperMethods.highLighterMethod(driver, businessNamesSearchResultLink);
        HelperMethods.waitAndClick(businessNamesSearchResultLink, driver);
    }
    public void businessNameClickSearchResult() {
        HelperMethods.fluentWaitAndCheckVisible(businessNamesSearchLink, driver);
        HelperMethods.highLighterMethod(driver, businessNamesSearchLink);
        HelperMethods.waitAndClick(businessNamesSearchLink, driver);
    }
    public void CorrectTheRegisterClick() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Correct the Register']")), driver);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//span[text()='Correct the Register']")));
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//span[text()='Correct the Register']")), driver);
    }
    // //span[text()='Correct the Register']

    public void selectAmendOption() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.waitAndClick(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(amendOption, driver);
        HelperMethods.waitAndClick(amendOption, driver);
    }

    public void fileArticlesOfAuthorizationContinueOutOfBusiness() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.staleElementClick(makeChangesMenu, driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfAuthorizationContinueOutOfBusinessOption, driver);
        HelperMethods.staleElementClick(fileArticlesOfAuthorizationContinueOutOfBusinessOption, driver);
    }
    public void instrumentOfContinuance() throws InterruptedException {
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.staleElementClick(makeChangesMenu, driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(instrumentOfContinuance, driver);
        HelperMethods.staleElementClick(instrumentOfContinuance, driver);
    }
    public void instrumentOfContinuanceAuthorization() throws InterruptedException, AWTException {

        Thread.sleep(3000);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("//button[contains(@class,'appDocumentUploadLink appButton')]")), driver);
        Thread.sleep(3000);
        HelperMethods.robotTypeString(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        HelperMethods.robotSendENTER();
        Thread.sleep(1200);

        HelperMethods.highLighterMethod(driver,reregistrationDate);
        Thread.sleep(2000);
        HelperMethods.waitAndSendKeys(reregistrationDate, HelperMethods.getFutureDate(0), driver);
        Thread.sleep(2000);

        HelperMethods.selectOptionFromDropdownWithValueOf("Business Corporation", selectCorporationType, driver);
        Thread.sleep(2000);
//        HelperMethods.selectOptionFromDropdownWithValueOf("Canada", selectGoverningJurisdiction, driver);
//        HelperMethods.selectOptionFromDropdownselectByIndex(1, selectGoverningJurisdiction, driver);

        Thread.sleep(3000);
//        HelperMethods.fluentWaitAndCheckVisible(selectFromPartnersDropdown, driver);
//        HelperMethods.staleElementClick(selectFromPartnersDropdown, driver);
//        HelperMethods.waitAndSendKeys(partnerTextArea, "Canada", driver);
//        Thread.sleep(3000);

        HelperMethods.fluentWaitAndCheckVisible(selectFromPartnersDropdown, driver);
        HelperMethods.staleElementClick(selectFromPartnersDropdown, driver);
        Thread.sleep(1000);
//        HelperMethods.waitAndSendKeys(partnerTextArea, "Canada", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectCanada, driver);
        HelperMethods.waitAndClick(selectCanada, driver);


        HelperMethods.fluentWaitAndCheckVisible(selectFromProvinceDropdown, driver);
        HelperMethods.staleElementClick(selectFromProvinceDropdown, driver);
        Thread.sleep(1000);
//        HelperMethods.waitAndSendKeys(partnerTextArea, "Canada", driver);
        HelperMethods.fluentWaitAndCheckVisible(selectProvince, driver);
        HelperMethods.waitAndClick(selectProvince, driver);


//        driver.findElement(By.xpath("//button[@type='button']")).sendKeys(System.getProperty("user.dir")+ "\\src\\main\\resources\\123_pdf-file.pdf");
        Thread.sleep(1200);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//div[@class='appRestricted appRestrictedYesNo']//label[1]")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//div[@class='appRestricted appRestrictedYesNo']//label[1]")), driver);
        Thread.sleep(3000);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Submit']")), driver);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Submit']")), driver);

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
    public boolean businessCorporationFileArticlesOfContinueOutOfBusiness() throws InterruptedException {

        //    HelperMethods.isObjectPresentByXpath(driver, "//span[text()='Ok']");
        if(HelperMethods.isObjectPresentByXpath(driver, "//*[@id=\"sentForReviewDialogOkButton\"]/span") >0) {
            HelperMethods.staleElementVisible(sentForReviewDialogOkButton, driver);
            HelperMethods.fluentLongWaitAndClick(sentForReviewDialogOkButton, driver);
        }
        HelperMethods.staleElementClick(serviceNameLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(pageTitle, driver);

        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);

        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(businessIncorporationOutOfBusinessLink, driver);
//        logger.warn("Corporation Name and Number is :" + pageTitle.getText());
//        Reporter.log("Corporation Name and Number is :" + pageTitle.getText());
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Transaction Number is :" + transactionNumberValue.getText());                         // Added Nov 12, 2021
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean verifyWindingUpNotForProfitCorporation() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);

        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(windingUpNotForProfitCorporationLink, driver);
//        logger.warn("Corporation Name and Number is :" + pageTitle.getText());
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        Reporter.log("Winding Up of a Not For Profit Corporation Name and Number is :" + particularsValue.getText());
        logger.warn("Transaction Number is :" + transactionNumberValue.getText());                         // Added Nov 12, 2021
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }

    public void selectRegisterBusinessName() {
        HelperMethods.fluentWaitAndCheckVisible(businessNamesMenu, driver);
        HelperMethods.waitAndClick(businessNamesMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerBusinessNameOption, driver);
        HelperMethods.waitAndClick(registerBusinessNameOption, driver);
    }
    public void selectRegisterABusinessName() {
        HelperMethods.fluentWaitAndCheckVisible(businessANamesMenu, driver);
        HelperMethods.waitAndClick(businessANamesMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerBusinessNameOption, driver);
        HelperMethods.waitAndClick(registerBusinessNameOption, driver);
    }
    public void selectRegisterForABusinessName() {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("(//span[text()='Business Names'])")), driver);
        HelperMethods.waitAndClick(driver.findElement(By.xpath("(//span[text()='Business Names'])")), driver);
        HelperMethods.fluentWaitAndCheckVisible(registerBusinessNameOption, driver);
        HelperMethods.waitAndClick(registerBusinessNameOption, driver);
    }
    public void selectCancelBusinessName() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndClick(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(cancelBusinessName, driver);
        HelperMethods.fluentWaitAndClick(cancelBusinessName, driver);
    }
    public void selectRenewBusinessName() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndClick(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(renewBusinessName, driver);
        HelperMethods.fluentWaitAndClick(renewBusinessName, driver);
    }
    public void selectFileDraftPlanOfArrangement() {
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='Make Changes']")), driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='Make Changes']")), driver);
        HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='File Draft Plan of Arrangement']")), driver);
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[text()='File Draft Plan of Arrangement']")), driver);
    }

    public void selectFileDecelerationOfOntarioLimitedPartnershipService() throws InterruptedException {
        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(partnershipLink, driver);
        HelperMethods.fluentWaitAndClick(partnershipLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(ontarioLimitedPartnershipLink, driver);
        HelperMethods.fluentWaitAndClick(ontarioLimitedPartnershipLink, driver);
    }
    public void selectaFirmNameForAGeneralPartnershipLink() throws InterruptedException {
        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(partnershipLink, driver);
        HelperMethods.fluentWaitAndClick(partnershipLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(aFirmNameForAGeneralPartnershipLink, driver);
        HelperMethods.fluentWaitAndClick(aFirmNameForAGeneralPartnershipLink, driver);
    }
    public void selectRegisterFirmNameForOntarioLimitedLiabilityService() {
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(partnershipLink, driver);
        HelperMethods.fluentWaitAndClick(partnershipLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerFirmNameOntarioLimitedLink, driver);
        HelperMethods.fluentWaitAndClick(registerFirmNameOntarioLimitedLink, driver);
    }

    public void selectFileDecelerationOfExtraProvincialLimitedPartnershipService() throws InterruptedException {
        Thread.sleep(500);
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(partnershipLink, driver);
        HelperMethods.fluentWaitAndClick(partnershipLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(declarationExtraProvincialLink, driver);
        HelperMethods.fluentWaitAndClick(declarationExtraProvincialLink, driver);
    }

    public void selectRegisterFirmNameForExtraProvincialLimitedLiabilityService() {
        HelperMethods.fluentWaitAndCheckVisible(ontarioLogo, driver);
        HelperMethods.fluentWaitAndCheckVisible(servicesLink, driver);
        HelperMethods.fluentWaitAndClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerServicesLink, driver);
        HelperMethods.fluentWaitAndClick(registerServicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(partnershipLink, driver);
        HelperMethods.fluentWaitAndClick(partnershipLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(registerFirmNameForExtraProvincialLimitedLink, driver);
        HelperMethods.fluentWaitAndClick(registerFirmNameForExtraProvincialLimitedLink, driver);
    }

    public String selectCompletedMenuOptionAndGetCorporationName() {
        String ontarioCorporationName;
        HelperMethods.fluentWaitAndCheckVisible(completedSubMenuOption, driver);
        HelperMethods.staleElementClick(completedSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(incorporationNameValue, driver);
        ontarioCorporationName = incorporationNameValue.getText().replace(" ONTARIO CORP.", "");
        logger.warn("Ontario Corporation Name is: " + ontarioCorporationName);

        return ontarioCorporationName;
    }
    public String getCompletedCorporationNumber() {
        String ontarioCorporationNumber = null;
        String ontarioCorporationName;
        HelperMethods.fluentWaitAndCheckVisible(completedSubMenuOption, driver);
        HelperMethods.staleElementClick(completedSubMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(incorporationNameNumber, driver);
        HelperMethods.highLighterMethod(driver, incorporationNameNumber);
        ontarioCorporationName = incorporationNameNumber.getText();
        logger.warn("Ontario Corporation Name is: " + ontarioCorporationName);
        System.out.println("Ontario Corporation Name is: " + ontarioCorporationName);
        ontarioCorporationNumber = HelperMethods.getNumberFromString(ontarioCorporationName,"\\d+") ;
        return ontarioCorporationNumber;
    }

    public String getCompletedCorporationNumberAdminPortal() throws InterruptedException {
        String ontarioCorporationNumber = null;
        String ontarioCorporationName;
        HelperMethods.fluentWaitAndCheckVisible(completedSubMenuOption, driver);
        HelperMethods.staleElementClick(completedSubMenuOption, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(incorporationNameNumberAdminPortal, driver);
       // HelperMethods.checkObjectVisible(incorporationNameNumberAdminPortal);
        HelperMethods.highLighterMethod(driver, incorporationNameNumberAdminPortal);
        ontarioCorporationName = incorporationNameNumberAdminPortal.getText();
        Reporter.log("Ontario Corporation Name is: " + ontarioCorporationName);
        logger.warn("Ontario Corporation Name is: " + ontarioCorporationName);
        System.out.println("Ontario Corporation Name is: " + incorporationNameNumberAdminPortal);
        ontarioCorporationNumber = HelperMethods.getNumberFromString(ontarioCorporationName,"\\d+") ;
        return ontarioCorporationNumber;
    }
    public String getCompletedCorporationNumberGeneric() throws InterruptedException {
        String ontarioCorporationNumber = null;
        String ontarioCorporationName;
        HelperMethods.fluentWaitAndCheckVisible(completedSubMenuOption, driver);
        HelperMethods.staleElementClick(completedSubMenuOption, driver);
        Thread.sleep(1000);
        HelperMethods.fluentWaitAndCheckVisible(incorporationNameNumberAdminPortal, driver);
        HelperMethods.highLighterMethod(driver, incorporationNameNumberAdminPortal);
        ontarioCorporationName = incorporationNameNumberAdminPortal.getText();
        logger.warn(" Corporation Name is: " + ontarioCorporationName);
        System.out.println("Corporation Name is: " + incorporationNameNumberAdminPortal);
        ontarioCorporationNumber = HelperMethods.getNumberFromString(ontarioCorporationName,"\\d+") ;
        return ontarioCorporationNumber;
    }
    public String ontarioCorporation;

    public String getOntarioCorporation() {
        return ontarioCorporation;
    }

    public void setOntarioCorporation(String ontarioCorporation) {
        this.ontarioCorporation = ontarioCorporation;
    }

    public void searchCorporationAndSelectResult() {
        HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getOntarioCorporation());
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchResultsCorporation, driver);

        HelperMethods.staleElementClick(searchResultsCorporation, driver);
    }

    public void searchCorporationAndSelectResultByOntarioCorporation(String getOntarioCorporation) throws InterruptedException {
        Thread.sleep(1000);
//        HelperMethods.staleElementClick(servicesLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchField, driver);
        driver.findElement(By.id("QueryString")).sendKeys(getOntarioCorporation);
        HelperMethods.fluentWaitAndClick(searchButton, driver);
        HelperMethods.fluentWaitAndCheckVisible(searchResultsCorporation, driver);
        HelperMethods.staleElementClick(searchResultsCorporation, driver);
    }
    public void selectFileInitialReturn() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.staleElementClick(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileInitialReturnSubMenu, driver);
        HelperMethods.staleElementClick(fileInitialReturnSubMenu, driver);
    }

    public void selectFilingsSubMenuOption() {
        HelperMethods.fluentWaitAndCheckVisible(filingsSubMenuOption, driver);
        HelperMethods.fluentWaitAndClick(filingsSubMenuOption, driver);
    }

    public void selectFileNoticeOfChange() {
        HelperMethods.staleElementVisible(makeChangesMenu, driver);
        HelperMethods.staleElementClick(makeChangesMenu, driver);
        HelperMethods.staleElementVisible(fileNoticeOfChangeSubMenuOption, driver);
        HelperMethods.staleElementClick(fileNoticeOfChangeSubMenuOption, driver);
    }
    public void fileNoticeOfChangeFromMenu() {
        HelperMethods.staleElementVisible(makeChangesMenu, driver);
        HelperMethods.staleElementClick(makeChangesMenu, driver);
        HelperMethods.staleElementVisible(FileNoticeOfChangeMenu, driver);
        HelperMethods.staleElementClick(FileNoticeOfChangeMenu, driver);
    }
    public void selectFileAnnualReturn() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenu, driver);
        HelperMethods.staleElementClick(makeChangesMenu, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileAnnualReturnSubMenu, driver);
        HelperMethods.staleElementClick(fileAnnualReturnSubMenu, driver);
    }
}
