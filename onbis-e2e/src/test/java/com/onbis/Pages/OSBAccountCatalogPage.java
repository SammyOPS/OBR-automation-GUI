package com.onbis.Pages;

import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

public class OSBAccountCatalogPage extends PageObject {
    public OSBAccountCatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[text()='Registration']/following::h4")
    WebElement incorporateAnOntarioBusinessCorporationLink;
//    @FindBy(xpath = "(//h2[text()='ONBIS Transactions']/following::h4)[2]")
    @FindBy(xpath = "(//div[@class='os_list os_2cols']//h2)[2]/following::h4[text()='Continue as an Ontario Business Corporation']")
    WebElement continueAsOntarioBusinessCorporationLink;
//    @FindBy(xpath = "//h4[text()='Incorporate an Ontario Not-for-Profit Corporation']")
    @FindBy(xpath = "//h3[text()='Registration']/following::h4[text()='Incorporate an Ontario Not-for-Profit Corporation']")
    WebElement incorporateNotForProfitCorporationLink;
    @FindBy(xpath = "//h3[text()='Registration']/following::h4[text()='Application for Licence for a Foreign Corporation']")
    WebElement applicationForLicenceForForeignCorpLink;
    @FindBy(xpath = "//h3[text()='Registration']/following::h4[text()='Register a Firm Name for a General Partnership']")
    WebElement firmNameForGeneralPartnershipLink;
    @FindBy(xpath = "//h2[contains(text(),'OBR Transactions')]")
    WebElement onbisTransactionsHeading;
    @FindBy(xpath = "//h3[contains(text(),'OSB Account')]")
    WebElement osbAccountHeading;

    public void selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation() {
        driver.get(System.getenv("osbServiceCatalog"));
        System.out.println("-------: '" + System.getenv("osbServiceCatalog") + "' was clicked  in :-------" );
        HelperMethods.fluentLongWaitAndCheckVisible(osbAccountHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(onbisTransactionsHeading, driver);
        HelperMethods.scrollIntoViewForClick(onbisTransactionsHeading, driver);
        HelperMethods.waitAndClick(incorporateAnOntarioBusinessCorporationLink, driver);
    }

    public void selectRegistrationTypeAsContinueAsOntarioBusinessCorporation() {
        driver.get(System.getenv("osbServiceCatalog"));
        System.out.println("-------: '" + System.getenv("osbServiceCatalog") + "' was clicked  in :-------" );
        HelperMethods.fluentLongWaitAndCheckVisible(osbAccountHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(onbisTransactionsHeading, driver);
        HelperMethods.scrollIntoViewForClick(onbisTransactionsHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(continueAsOntarioBusinessCorporationLink, driver);
        HelperMethods.waitAndClick(continueAsOntarioBusinessCorporationLink, driver);
    }
    public void selectRegistrationTypeAsIncorporateANotForProfitCorporation() {
        driver.get(System.getenv("osbServiceCatalog"));
        System.out.println("-------: '" + System.getenv("osbServiceCatalog") + "' was clicked  in :-------" );
        HelperMethods.fluentLongWaitAndCheckVisible(osbAccountHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(onbisTransactionsHeading, driver);
        HelperMethods.scrollIntoViewForClick(onbisTransactionsHeading, driver);
        HelperMethods.waitAndClick(incorporateNotForProfitCorporationLink, driver);
    }

    public void selectRegistrationTypeAsApplicationForLicenceForForeignCorp() {
        driver.get(System.getenv("osbServiceCatalog"));
        System.out.println("-------: '" + System.getenv("osbServiceCatalog") + "' was clicked  in :-------" );
        HelperMethods.fluentLongWaitAndCheckVisible(osbAccountHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(onbisTransactionsHeading, driver);
        HelperMethods.scrollIntoViewForClick(onbisTransactionsHeading, driver);
        HelperMethods.waitAndClick(applicationForLicenceForForeignCorpLink, driver);
    }

    public void selectRegistrationTypeAsRegisterFirmNameForGeneralPartnership() {
        driver.get(System.getenv("osbServiceCatalog"));
        System.out.println("-------: '" + System.getenv("osbServiceCatalog") + "' was clicked  in :-------" );
        HelperMethods.fluentLongWaitAndCheckVisible(osbAccountHeading, driver);
        HelperMethods.fluentWaitAndCheckVisible(onbisTransactionsHeading, driver);
        HelperMethods.scrollIntoViewForClick(onbisTransactionsHeading, driver);
        HelperMethods.waitAndClick(firmNameForGeneralPartnershipLink, driver);
    }
}