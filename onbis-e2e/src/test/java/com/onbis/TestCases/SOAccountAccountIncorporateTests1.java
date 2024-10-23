package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class SOAccountAccountIncorporateTests1 extends SOAccountSetUp {

    /*
     * 1.Incorporate an Ontario Business Corporation- Number
     * */
//    @Test
//    @DisplayName("1.Incorporate an Ontario Business Corporation- Number")
//    public void whenUserCompletesIncorporateOntarioBusinessCorporationNumber_UserSeesCorporationWithNumberCreated() throws InterruptedException, IOException {
//        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
//        oneKeyLogin.loginUsingOneKeyCredentials();
//        soAccountLandingPage.selectAddProfile();
//        soAccountLandingPage.completeProfileDetailsAndSave();
//
//        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();
//
//        Assert.assertTrue(paymentConfirmationPage.paymentConfirmationElementsAreDisplayed());
//        Assert.assertTrue(paymentConfirmationPage.emailReceivedAndValidationConfirmation());
//    }

    /*
     * 2.Incorporate an Ontario Business Corporation- Name
     * */
//    @Parameters({"browser"})
//    @Test
//    public void whenUserCompletesIncorporateOntarioBusinessCorporationName_UserSeesCorporationWithNameCreated(String browser) throws IOException, InterruptedException, XPathExpressionException, SAXException, ParserConfigurationException {
//        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
//        oneKeyLogin.loginUsingOneKeyCredentials();
//        soAccountLandingPage.selectAddProfile();
//        soAccountLandingPage.completeProfileDetailsAndSave();
//
//        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNameAndSave(browser);
//
//        Assert.assertTrue(paymentConfirmationPage.paymentConfirmationElementsAreDisplayed());
//        Assert.assertTrue(paymentConfirmationPage.emailReceivedAndValidationConfirmation());
//    }

    /*
    4.Continue in as an Ontario Business Corporation
     */
//    @Test
//    public void whenUserContinuesAsOntarioBusinessCorporationName_UserSeesCorporationWithNameCreated() throws IOException, InterruptedException {
//        osbAccountCatalogPage.selectRegistrationTypeAsContinueAsOntarioBusinessCorporation();
//        oneKeyLogin.loginUsingOneKeyCredentials();
//        soAccountLandingPage.selectAddProfile();
//        soAccountLandingPage.completeProfileDetailsAndSave();
//
//        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeJurisdictionForContinuanceUnderBusinessCorporation();
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveContinue();
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeJurisdictionAndNavigateToReview();
//        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
////        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
//        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
//        soIncorporateOntarioBusinessCorporationPage.confirmSentForReview();
//
//        Assert.assertTrue(paymentConfirmationPage.continuanceUnderBusinessCorporationStatusElementsAreDisplayed());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
//    }


    /*
    5.Incorporate a Not-for-Profit Corporation
     */
    @Test
    public void whenUserIncorporateANotForProfitCorporationName_UserSeesNotForProfitCorporationWithNameCreated() throws IOException, InterruptedException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateANotForProfitCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveIncorporateNotForProfitCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSaveNotForProfitCorporation();
        soIncorporateOntarioBusinessCorporationPage.completePurposesAndProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();

        Assert.assertTrue(paymentConfirmationPage.incorporateNonProfitCorporationStatusElementsAreDisplayed());
    }


    /*
    6.Application for Extra-Provincial Licence for a Foreign Corporation
     */
//    @Parameters({"browser"})
//    @Test
//    public void whenUserCompletesExtraProvincialLicenceForForeignCorp_UserSeesCorporationCreated(String browser) throws IOException, InterruptedException {
//        osbAccountCatalogPage.selectRegistrationTypeAsApplicationForLicenceForForeignCorp();
//
//        oneKeyLogin.loginUsingOneKeyCredentials();
//        soAccountLandingPage.selectAddProfile();
//        soAccountLandingPage.completeProfileDetailsAndSave();
//
//        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeJurisdictionForExtraProvincialLicenceForeignCorp();
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveIncorporateExtraProvincialLicence(browser);
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSaveForeignCorpAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeChiefOfficerAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeAgentForServiceAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsAndSaveForeignCorp();
//
//        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
//        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
//        soIncorporateOntarioBusinessCorporationPage.confirmSentForReview();
//
//        Assert.assertTrue(paymentConfirmationPage.extraProvincialLicenceForForeignCorporationStatusElementsAreDisplayed());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
//    }

    /*
    26. Restated Articles of Incorporation
     */
//    @Test
//    public void whenUserRestartsIncorporationNumber_UserSeesIncorporationRestarted() throws
//            InterruptedException, IOException {
//        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
//        oneKeyLogin.loginUsingOneKeyCredentials();
//        soAccountLandingPage.selectAddProfile();
//        soAccountLandingPage.completeProfileDetailsAndSave();
//
//        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();
//
//        paymentConfirmationPage.paymentConfirmationElementsAreDisplayed();
////        soAccountLandingPage.selectServiceOntarioBusinessRegistry();
//
//        viewCorporationPage.selectRestartedArticleOfIncorporation();
//        partnerTermsAndConditionsPage.acceptTermsAndConditions();
//        contactInformationPage.completeContactInformationAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSaveOntarioBusinessCorp();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
//
//        Assert.assertTrue(viewCorporationPage.businessCorporationArticleOfIncorporationIsRestarted());
//    }

    /*
    27. Articles of Reorganization
     */
    @Test
    public void whenUserFilesArticleOfReorganizationForIncorporationNumber_UserSeesArticleOfReorganization() throws
            InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();

        paymentConfirmationPage.paymentConfirmationElementsAreDisplayed();
//        soAccountLandingPage.selectServiceOntarioBusinessRegistry();

        viewCorporationPage.selectFileArticleOfReorganization();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCourtOrderBusinessCorp();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        soIncorporateOntarioBusinessCorporationPage.confirmSentForReview();

        Assert.assertTrue(paymentConfirmationPage.fileArticleOfReorganizationElementsAreDisplayed());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

    /*
    28. Articles of Amalgamation
     */
    @Test
    public void whenUserFilesArticleOfAmalgamationForIncorporationNumber_UserSeesArticleOfAmalgamation() throws
            InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();

        paymentConfirmationPage.paymentConfirmationElementsAreDisplayed();
//        soAccountLandingPage.selectServiceOntarioBusinessRegistry();

        viewCorporationPage.selectFileArticleOfAmalgamation();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        fileArticlesOfAmalgamationPage.completeAmalgamatingCorporationsAndSave();
        fileArticlesOfAmalgamationPage.completeMethodOfAmalgamationAndSave();
        fileArticlesOfAmalgamationPage.updateMethodOfAmalgamationAndSave();
        fileArticlesOfAmalgamationPage.completeCorporationNameAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAddressFileADeceleration();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());

        Assert.assertTrue(viewCorporationPage.corporationFileStatusUpdatedToAmalgamated());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

}