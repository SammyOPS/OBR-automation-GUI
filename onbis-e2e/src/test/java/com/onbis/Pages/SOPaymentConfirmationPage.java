package com.onbis.Pages;

import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class SOPaymentConfirmationPage extends PageObject {
    public SOPaymentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Payment Confirmation')]")
    WebElement paymentConfirmationHeading;
    @FindBy(xpath = "//h2[@id='OneSourceTitle']")
    WebElement accountHomepageTitle;
    @FindBy(xpath = "//span[contains(@id,'onbis-corporations')]")
    WebElement pageTitle;
    @FindBy(xpath = "//td[text()[normalize-space()='Completed']]")
    WebElement statusCompletedLabel;
    @FindBy(xpath = "//td[text()[normalize-space()='Review']]")
    WebElement statusReviewLabel;
    @FindBy(xpath = "//a[contains(text(),'File Articles of Reorganization')]")
    WebElement reorganizationServiceActivityLink;
    @FindBy(xpath = "//a[contains(text(),'Application')]")
    WebElement activityServiceLink;
    @FindBy(xpath = "//a[contains(text(),'File')]")
    WebElement activityServiceLinkContinues;
    @FindBy(xpath = "//a[contains(text(),'Incorporate a Not-for-Profit Corporation')]")
    WebElement notForProfitServiceLinkContinues;
    @FindBy(xpath = "//a[contains(text(),'Extra-Provincial')]")
    WebElement activityServiceLinkExtraProvincial;
    @FindBy(xpath = "//a[contains(text(),'Incorporate a Not-for-Profit Corporation -')]")
    WebElement activityServiceLinkNonProfit;
    @FindBy(xpath = "//tbody[@id='service-table-body']//a[1]")
    WebElement serviceNameLink;
    @FindBy(xpath = "//span[text()='Filings']")
    WebElement filingsOption;
    @FindBy(xpath = "//h2[text()='Filings']")
    WebElement filingsHeading;
    @FindBy(xpath = "(//a[@class='appFilingOpen']//span)[1]")
    WebElement fileADeclarationFiling;
//    @FindBy(xpath = "//div[text()='Transaction Number']/following-sibling::div")
    @FindBy(xpath = "//div[@class='appFilingDetailObject']//div[1]")
    WebElement transactionNumberValue;
    @FindBy(xpath = "//*[@id=\"myTransactionModel\"]/table/tbody/tr/td[2]/a")
    WebElement serviceCompletedLink;

    @FindBy(xpath = "//div[@class='appBannerContainerInner']/following-sibling::span[1]")
    WebElement onbisCodeVersion;
    @FindBy(xpath = "(//div[@class='appAttrValue'])[3]")
    WebElement onbisOCN;




    public void SOAccountHomepageOCNwriteToCSV(String scriptName) throws InterruptedException {
        Thread.sleep(1000);
        HelperMethods.highLighterMethod(driver,driver.findElement(By.xpath("//tbody[@id='service-table-body']//a[1]")));
        String oCN = driver.findElement(By.xpath("//tbody[@id='service-table-body']//a[1]")).getText();
        System.out.println("\tOntario business registry - Ontario Corporation Number (OCN) number is: " + oCN);
        HelperMethods.writeToCSV(scriptName, oCN);
    }

    public boolean paymentConfirmationElementsAreDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        boolean isCorrect = HelperMethods.fluentLongWaitAndCheckVisible(accountHomepageTitle, driver);
        isCorrect = isCorrect && HelperMethods.fluentLongWaitAndCheckVisible(statusCompletedLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(serviceNameLink, driver);
//        logger.warn("corporation name and number is: "+ serviceCompletedLink.getText());
        HelperMethods.staleElementClick(serviceNameLink, driver);
        Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(pageTitle, driver);

        logger.warn("ONBIS Code Version is: " + onbisCodeVersion.getText());
        Reporter.log("ONBIS Code Version is: " + onbisCodeVersion.getText());

        logger.warn("Corporation name and number is: " + pageTitle.getText());
        Reporter.log("Corporation name and number is: " + pageTitle.getText());
        return isCorrect;
    }


    public boolean emailReceivedAndValidationConfirmation() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentLongWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("ONBIS Code Version is: " + onbisCodeVersion.getText());
        Reporter.log("ONBIS Code Version is: " + onbisCodeVersion.getText());
        Reporter.log("Transaction number is: " + transactionNumberValue.getText());
        logger.warn("Transaction number is: " + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='Ok']")), driver);

        return isCorrect;
    }

    public boolean fileArticleOfReorganizationElementsAreDisplayed() {
        boolean isCorrect = HelperMethods.fluentLongWaitAndCheckVisible(accountHomepageTitle, driver);
        isCorrect = isCorrect && HelperMethods.fluentLongWaitAndCheckVisible(statusReviewLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(reorganizationServiceActivityLink, driver);

//        logger.warn("ONBIS Code Version is: " + onbisCodeVersion.getText());
//        Reporter.log("ONBIS Code Version is: " + onbisCodeVersion.getText());

        logger.warn("corporation name and number is: " + serviceCompletedLink.getText());
        Reporter.log("corporation name and number is: " + serviceCompletedLink.getText());
        return isCorrect;
    }

    public boolean continuanceUnderBusinessCorporationStatusElementsAreDisplayed() throws InterruptedException {
        Thread.sleep(1000);
//        HelperMethods.explicitWait(accountHomepageTitle, driver);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        Thread.sleep(5000);
        boolean isCorrect = HelperMethods.fluentLongWaitAndCheckVisible(accountHomepageTitle, driver);
        HelperMethods.highLighterMethod( driver, accountHomepageTitle);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(statusReviewLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(activityServiceLinkContinues, driver);

//        logger.warn("ONBIS Code Version is: " + onbisCodeVersion.getText());
//        Reporter.log("ONBIS Code Version is: " + onbisCodeVersion.getText());

        logger.warn("corporation name and number is: " + serviceCompletedLink.getText());
        Reporter.log("corporation name and number is: " + serviceCompletedLink.getText());
        return isCorrect;
    }

    public boolean notForProfitStatusElementsAreDisplayed() {
        boolean isCorrect = HelperMethods.fluentLongWaitAndCheckVisible(accountHomepageTitle, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(statusCompletedLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(notForProfitServiceLinkContinues, driver);

        logger.warn("ONBIS Code Version is: " + onbisCodeVersion.getText());
        Reporter.log("ONBIS Code Version is: " + onbisCodeVersion.getText());

        logger.warn("corporation name and number is: " + serviceCompletedLink.getText());
        Reporter.log("corporation name and number is: " + serviceCompletedLink.getText());
        return isCorrect;
    }

    public boolean extraProvincialLicenceForForeignCorporationStatusElementsAreDisplayed() {
        boolean isCorrect = HelperMethods.fluentLongWaitAndCheckVisible(accountHomepageTitle, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(statusReviewLabel, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(activityServiceLinkExtraProvincial, driver);

//        logger.warn("ONBIS Code Version is: " + onbisCodeVersion.getText());
//        Reporter.log("ONBIS Code Version is: " + onbisCodeVersion.getText());

        logger.warn("corporation name and number is: " + serviceCompletedLink.getText());
        Reporter.log("corporation name and number is: " + serviceCompletedLink.getText());
        return isCorrect;
    }

    public boolean incorporateNonProfitCorporationStatusElementsAreDisplayed() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentLongWaitAndCheckVisible(accountHomepageTitle, driver);
        isCorrect = isCorrect && HelperMethods.fluentLongWaitAndCheckVisible(statusCompletedLabel, driver);
//        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(activityServiceLinkNonProfit, driver);
//        logger.warn("corporation name and number is: " + serviceCompletedLink.getText());
        HelperMethods.staleElementClick(serviceNameLink, driver);
        HelperMethods.fluentWaitAndCheckVisible(pageTitle, driver);

        logger.warn("ONBIS Code Version is: " + onbisCodeVersion.getText());
        Reporter.log("ONBIS Code Version is: " + onbisCodeVersion.getText());

        logger.warn("Corporation name and number is: " + pageTitle.getText());
        Reporter.log("Corporation name and number is: " + pageTitle.getText());
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        HelperMethods.staleElementClick(fileADeclarationFiling, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        Reporter.log("Transaction number is: " + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }
}