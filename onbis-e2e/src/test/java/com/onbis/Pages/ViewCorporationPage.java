package com.onbis.Pages;

import com.onbis.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ViewCorporationPage extends PageObject {
    public ViewCorporationPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "//div[contains(@class,'brViewLocalCompany-companyMenusBox-item3 appGroupMenu')]")
    @FindBy(xpath = "//span[text()='Make Changes']") //    //div[contains(@class,'brViewLocalCompany-companyMenusBox-item')]
    WebElement makeChangesMenuOption;
    @FindBy(xpath = "//span[text()='Make Changes']/following-sibling::span")
    WebElement makeChangesMenuOption1;



    @FindBy(xpath = "//span[contains(text(),'File Restated Articles of Incorporation')]")
    WebElement fileRestartedArticleIncorporationOption;
    @FindBy(xpath = "//span[text()='File Articles of Reorganization']")
    WebElement fileArticleOfReorganizationOption;
    @FindBy(xpath = "//span[contains(text(),'File Articles of Amalgamation')]")
    WebElement fileArticleOfAmalgamationOption;
    @FindBy(xpath = "//span[text()='Filings']")
    WebElement filingsOption;
    @FindBy(xpath = "//div[contains(text(),'Inactive - Amalgamated')]")
    WebElement statusValue;
    @FindBy(xpath = "//div[contains(@class, 'appAttrText brViewLocalCompany-tabsBox-detailsTab-details-localNameBox-currentEntityNames-currentEntityName-numberNameBox-useNumberNameBox-viewNumberName-Name appAttribute Name Attribute-Name appDc-uppercase appNonBlankAttribute appProposedName appReadOnly appIndex0')]")
    WebElement corporationNameAndValue;
    @FindBy(xpath = "//h2[text()='Filings']")
    WebElement filingsHeading;
    @FindBy(xpath = "//span[contains(text(),'BCA - Restated Articles of Incorporation')]")
    WebElement businessIncorporationRestartedLink;
    @FindBy(xpath = "//span[contains(text(),'BCA - Articles of Amendment')]")
    WebElement businessIncorporationArticlesOfAmendmentLink;
    @FindBy(xpath = "//span[contains(text(),'BCA - Articles of Incorporation')]")
    WebElement businessIncorporationArticlesOfDissolutionLink;

    @FindBy(xpath = "//span[contains(text(),'BCA - Articles of Incorporation')]")
    WebElement businessIncorporationOutOfBusinessLink;



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

    @FindBy(xpath = "//span[text()='File Articles of Amendment']")
    WebElement fileArticlesOfAmendmentIncorporationOption;
    @FindBy(xpath = "//span[text()='File Articles of Arrangement']")
    WebElement fileArticlesOfArrangementIncorporationOption;



    @FindBy(xpath = "//span[text()='File Articles of Dissolution']")
    WebElement fileArticlesOfDissolveOfIncorporationOption;


    @FindBy(xpath = "//span[text()='File Application for Authorization to Continue Out of the Business Corporations Act']")
    WebElement fileArticlesOfAuthorizationContinueOutOfBusinessOption;
    @FindBy(xpath = "//span[text()='File Application for Authorization to Continue Out of the Not-for-Profit Corporations Act'] ")
    WebElement fileArticlesOfAuthorizationContinueOutOfBusinessOption1;


    @FindBy(xpath = "//span[text()='File Draft Plan of Arrangement']")
    WebElement FileArticlesOfFileDraftPlanForArrangementOption;

    @FindBy(xpath = "//*[contains(text(),'Draft Plan of Arrangement')]")
    WebElement FileArticlesOfFileDraftPlanForArrangement;

    @FindBy(xpath = "//*[@id=\"breadcrumbs_section\"]/li[2]/a")
    WebElement FileArticlesOfFileDraftPlanForArrangement_CorpName;

    @FindBy(xpath = "//label[text()='Activity name:']/following-sibling::span")
    WebElement FileArticlesOfFileDraftPlanForArrangement_ActivityName;

    @FindBy(xpath = "//label[text()='Transaction number:']/following-sibling::span")
    WebElement FileArticlesOfFileDraftPlanForArrangement_TransactionNumber;

    @FindBy(xpath = "//span[text()='Dissolution Order']")
    WebElement dissolutionOrderOption;

    public void FileArticlesOfFileDraftPlanForArrangement() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(FileArticlesOfFileDraftPlanForArrangementOption, driver);
        HelperMethods.staleElementClick(FileArticlesOfFileDraftPlanForArrangementOption, driver);
    }
    public void fileArticlesOfArrangement() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfArrangementIncorporationOption, driver);
        HelperMethods.staleElementClick(fileArticlesOfArrangementIncorporationOption, driver);
    }
    public void fileArticlesOfAmendmentOfIncorporation() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfAmendmentIncorporationOption, driver);
        HelperMethods.staleElementClick(fileArticlesOfAmendmentIncorporationOption, driver);
    }
    public void fileArticlesOfAmendmentOfIncorporation1() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption1, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption1, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfAmendmentIncorporationOption, driver);
        HelperMethods.staleElementClick(fileArticlesOfAmendmentIncorporationOption, driver);
    }

    public void fileArticlesOfAuthorizationContinueOutOfBusiness1() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption1, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption1, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfAuthorizationContinueOutOfBusinessOption1, driver);
        HelperMethods.staleElementClick(fileArticlesOfAuthorizationContinueOutOfBusinessOption1, driver);
    }

    public void fileArticlesOfDissolveOfIncorporation() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfDissolveOfIncorporationOption, driver);
        HelperMethods.staleElementClick(fileArticlesOfDissolveOfIncorporationOption, driver);
    }
    public void courtOrderedWindingUpDissolutionOrder() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(dissolutionOrderOption, driver);
        HelperMethods.staleElementClick(dissolutionOrderOption, driver);
    }

    public void fileArticlesOfAuthorizationContinueOutOfBusiness() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticlesOfAuthorizationContinueOutOfBusinessOption, driver);
        HelperMethods.staleElementClick(fileArticlesOfAuthorizationContinueOutOfBusinessOption, driver);
    }


    public void selectRestartedArticleOfIncorporation() throws InterruptedException {
      //  Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileRestartedArticleIncorporationOption, driver);
        HelperMethods.staleElementClick(fileRestartedArticleIncorporationOption, driver);
    }

    public void selectFileArticleOfReorganization() throws InterruptedException {
     //   Thread.sleep(2000);
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticleOfReorganizationOption, driver);
        HelperMethods.staleElementClick(fileArticleOfReorganizationOption, driver);
    }

    public void selectFileArticleOfAmalgamation() {
        HelperMethods.fluentWaitAndCheckVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(makeChangesMenuOption, driver);
        HelperMethods.fluentWaitAndCheckVisible(fileArticleOfAmalgamationOption, driver);
        HelperMethods.staleElementClick(fileArticleOfAmalgamationOption, driver);
    }

    public boolean businessCorporationArticleOfIncorporationIsRestarted() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(businessIncorporationRestartedLink, driver);
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

    public boolean businessCorporationFileArticlesOfAmendment() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementVisible(makeChangesMenuOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(businessIncorporationArticlesOfAmendmentLink, driver);
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
    public boolean nFPCA_FileArticleOfAmendment () throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(filingsOption, driver);
        HelperMethods.staleElementClick(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(filingsHeading, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(driver.findElement(By.xpath("//span[text()='NFPCA - Articles of Incorporation']")), driver);
//        logger.warn("Corporation Name and Number is :" + pageTitle.getText());
//        Reporter.log("Corporation Name and Number is :" + pageTitle.getText());
        HelperMethods.staleElementClick(driver.findElement(By.xpath("//span[text()='NFPCA - Articles of Incorporation']")), driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        logger.warn("Transaction Number is :" + transactionNumberValue.getText());                         // Added Nov 12, 2021
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
    }
    public boolean DraftPlanForArrangement() throws InterruptedException {
        boolean isCorrect = HelperMethods.fluentWaitAndCheckVisible(FileArticlesOfFileDraftPlanForArrangement, driver);
        HelperMethods.staleElementClick(FileArticlesOfFileDraftPlanForArrangement, driver);

        logger.warn("Corporation Name is :" + FileArticlesOfFileDraftPlanForArrangement_CorpName.getText());                         // Added Nov 12, 2021
        Reporter.log("Corporation Name is :" + FileArticlesOfFileDraftPlanForArrangement_CorpName.getText());

        logger.warn("Activity name is :" + FileArticlesOfFileDraftPlanForArrangement_ActivityName.getText());                         // Added Nov 12, 2021
        Reporter.log("Activity name is :" + FileArticlesOfFileDraftPlanForArrangement_ActivityName.getText());

        logger.warn("Transaction Number is :" + FileArticlesOfFileDraftPlanForArrangement_TransactionNumber.getText());                         // Added Nov 12, 2021
        Reporter.log("Transaction Number is :" + FileArticlesOfFileDraftPlanForArrangement_TransactionNumber.getText());

        Thread.sleep(2900);
        return isCorrect;
    }

    public boolean businessCorporationFileArticlesOfDissolution() throws InterruptedException {

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
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(businessIncorporationArticlesOfDissolutionLink, driver);
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

    public boolean businessCorporationCourtOrderedWindingUpDissolutionOrder() throws InterruptedException {

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
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(businessIncorporationArticlesOfDissolutionLink, driver);
//        logger.warn("Corporation Name and Number is :" + pageTitle.getText());
//        Reporter.log("Corporation Name and Number is :" + pageTitle.getText());
        HelperMethods.staleElementClick(businessIncorporationArticlesOfDissolutionLink, driver);
        Thread.sleep(2000);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(transactionNumberValue, driver);
        HelperMethods.highLighterMethod(driver, transactionNumberValue);
        logger.warn("Transaction Number is :" + transactionNumberValue.getText());                         // Added Nov 12, 2021
        Reporter.log("Transaction Number is :" + transactionNumberValue.getText());
//        isCorrect = isCorrect && HelperMethods.compareText(transactionNumberValue, GenericUtilsPage.validateEmailReceived(), logger);
        Thread.sleep(2900);
        return isCorrect;
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
    public boolean corporationFileStatusUpdatedToAmalgamated() throws InterruptedException {
        Boolean isCorrect = HelperMethods.fluentLongWaitAndCheckVisible(filingsOption, driver);
        isCorrect = isCorrect && HelperMethods.fluentWaitAndCheckVisible(statusValue, driver);
        logger.warn("corporation Name is: " + corporationNameAndValue.getText());
        Reporter.log("corporation Name is: " + corporationNameAndValue.getText());
                return isCorrect;
    }
}
