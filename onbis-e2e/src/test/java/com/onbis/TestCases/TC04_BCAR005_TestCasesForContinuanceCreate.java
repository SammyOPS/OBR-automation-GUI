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
public class TC04_BCAR005_TestCasesForContinuanceCreate extends SOAccountSetUp {

    /*
    4.Continue in as an Ontario Business Corporation: "BCAR005 - test cases for Continuance (Create)"
     */
    @Test
    public void TC04_BCAR005_TestCasesForContinuanceCreate() throws IOException, InterruptedException {
        osbAccountCatalogPage.selectRegistrationTypeAsContinueAsOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeJurisdictionForContinuanceUnderBusinessCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveContinue();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave(); //   completeSharesProvisionsNoiFrameAndSave // completeSharesProvisionsAndSave
        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsAndSave();
        //soIncorporateOntarioBusinessCorporationPage.completeJurisdictionAndNavigateToReview();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completepayByVisaCard();
//        soIncorporateOntarioBusinessCorporationPage.payByVisaCard();

//        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        Thread.sleep(2000);
        soIncorporateOntarioBusinessCorporationPage.confirmSentForReview();
//        Thread.sleep(45000);
        soIncorporateOntarioBusinessCorporationPage.SOAccountHomepageOCNwriteToCSV("TC04_BCAR005_TestCasesForContinuanceCreate");
        Assert.assertTrue(paymentConfirmationPage.continuanceUnderBusinessCorporationStatusElementsAreDisplayed());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

}