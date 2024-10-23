package com.onbis.Pages;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileArticlesOfAmalgamationPage extends PageObject {
    public FileArticlesOfAmalgamationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='webuiValidateDate hasDatepicker']/following-sibling::button[1]")
    WebElement requiredStatementDateIcon;
    @FindBy(xpath = "//a[contains(@class,'ui-state-default ui-state-highlight')]")
    WebElement jurisdictionTodaysDate;
    @FindBy(xpath = "//button[contains(@class,'appWizardButton')]")
    WebElement saveAndContinueButton;
    @FindBy(xpath = "//label[contains(@for,'-UseNumberNameYnY')]")
    WebElement corporationNumberOption;
    @FindBy(xpath = "//input[@type='radio']/following-sibling::label")
    WebElement amalgamatingcorporationsRadioButtonOption;
    @FindBy(xpath = "//div[@class='appAttrLabelBox']/following-sibling::select[1]")
    WebElement amalgamatingcorporationsNameOption;
    @FindBy(xpath = "//div[@class='appRestricted appRestrictedSelect']//select[1]")
    WebElement amalgamatingcorporationsLegalElementForNumberOption;


    @FindBy(xpath = "//h2[contains(text(),'Corporation Name')]")
    WebElement corporationNameHeading;
    @FindBy(xpath = "//select[contains(@id,'-LegalExtensionCode')]")
    WebElement legalElementForNumberName;
    @FindBy(xpath = "//span[contains(text(),'Method of Amalgamation')]")
    WebElement methodAmalgamationLink;
    @FindBy(xpath = "//span[contains(text(),'Add a Corporation')]")
    WebElement addACorporationButton;
    @FindBy(xpath = "//input[contains(@class,'ui-autocomplete-input')]")
    WebElement searchCorporationTextArea;
    @FindBy(xpath = "//body/ul[contains(@id,'ui-id-')]/li[1]")
    WebElement corporationSearchResult;
    @FindBy(xpath = "//label[contains(@for,'-EntityCreationReasonshortform')]")
    WebElement shortFormOption;
    @FindBy(xpath = "(//button[@role='button'])[2]")
    WebElement uploadButtonFirst;
    @FindBy(xpath = "(//button[@role='button'])[3]")
    WebElement uploadButtonSecond;
    @FindBy(xpath = "//button[contains(@id,'_upload_button')]")
    WebElement uploadButton;

    public void completeAmalgamatingCorporationsAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(requiredStatementDateIcon, driver);
        HelperMethods.staleElementClick(requiredStatementDateIcon, driver);
        HelperMethods.staleElementClick(jurisdictionTodaysDate, driver);

        HelperMethods.fluentWaitAndCheckVisible(addACorporationButton, driver);
        HelperMethods.waitAndClick(addACorporationButton, driver);
        HelperMethods.fluentLongWaitAndCheckVisible(searchCorporationTextArea, driver);
        HelperMethods.waitAndSendKeys(searchCorporationTextArea, Config.ONTARIO_CORPORATION_LABEL, driver);
        HelperMethods.staleElementVisible(corporationSearchResult, driver);
        HelperMethods.staleElementClick(corporationSearchResult, driver);
        Thread.sleep(1000);
        HelperMethods.staleElementVisible(saveAndContinueButton, driver);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }

    public void completeMethodOfAmalgamationAndSave() throws InterruptedException {
        HelperMethods.fluentWaitAndCheckVisible(shortFormOption, driver);
        HelperMethods.fluentWaitAndClick(shortFormOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(uploadButtonFirst, driver);

        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
// trigger the upload
        HelperMethods.staleElementClick(uploadButtonFirst, driver);

// assign the file to the `<input>`
        driver.findElement(By.xpath("(//input[@type='file'])[2]"))
                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
        Thread.sleep(1000);

        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }

    public void completeFileArticlesOfAmalgamationCorporationNameAndSave() throws InterruptedException {
        Thread.sleep(1300);
        HelperMethods.fluentWaitAndCheckVisible(amalgamatingcorporationsRadioButtonOption, driver);
        HelperMethods.staleElementClick(amalgamatingcorporationsRadioButtonOption, driver);
        if(HelperMethods.isElementDisplayed(amalgamatingcorporationsNameOption, driver)) {
            Thread.sleep(5000);
            HelperMethods.selectOptionFromDropdownselectByIndex(1, amalgamatingcorporationsNameOption, driver);
        }
        if(HelperMethods.isElementDisplayed(amalgamatingcorporationsLegalElementForNumberOption, driver)) {
            Thread.sleep(5000);
            HelperMethods.selectOptionFromDropdownselectByIndex(1, amalgamatingcorporationsLegalElementForNumberOption, driver);
        }
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
        Thread.sleep(500);
        HelperMethods.fluentWaitAndClick(saveAndContinueButton, driver);
    }

    public void completeCorporationNameAndSave() throws InterruptedException {
        Thread.sleep(1300);
        HelperMethods.fluentWaitAndCheckVisible(corporationNumberOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(corporationNameHeading, driver);
        HelperMethods.staleElementClick(corporationNumberOption, driver);
        HelperMethods.staleElementVisible(legalElementForNumberName, driver);
        HelperMethods.selectOptionFromDropdownWithValueOf("CORP.", legalElementForNumberName, driver);
        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
        HelperMethods.fluentWaitAndClick(saveAndContinueButton, driver);
    }


    public void updateMethodOfAmalgamationAndSave() throws InterruptedException {
        Thread.sleep(1500);
        HelperMethods.fluentWaitAndCheckVisible(methodAmalgamationLink, driver);
        HelperMethods.staleElementClick(methodAmalgamationLink, driver);


        HelperMethods.fluentWaitAndCheckVisible(uploadButton, driver);
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        HelperMethods.staleElementClick(uploadButton, driver);
        driver.findElement(By.cssSelector("input[type=file]"))
                .sendKeys("C:/workspace/onbis-e2e/src/main/resources/123_pdf-file.pdf");
        Thread.sleep(1000);

        HelperMethods.fluentWaitAndCheckVisible(saveAndContinueButton, driver);
        HelperMethods.staleElementClick(saveAndContinueButton, driver);
    }
}
