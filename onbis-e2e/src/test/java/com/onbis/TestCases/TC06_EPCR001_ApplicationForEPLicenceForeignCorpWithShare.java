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
public class TC06_EPCR001_ApplicationForEPLicenceForeignCorpWithShare extends SOAccountSetUp {

    /*
    6.Application for Extra-Provincial Licence for a Foreign Corporation: "EPCR001 - Application for EP Licence Foreign Corp with Share"
     */
    @Parameters({"browser"})
    @Test
    public void TC06_EPCR001_ApplicationForEPLicenceForeignCorpWithShare(String browser) throws IOException, InterruptedException {
        osbAccountCatalogPage.selectRegistrationTypeAsApplicationForLicenceForForeignCorp();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeJurisdictionForExtraProvincialLicenceForeignCorp();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveIncorporateExtraProvincialLicence(browser);
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSaveForeignCorpAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeChiefOfficerAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeAgentForServiceAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsAndSaveForeignCorp();

        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        soIncorporateOntarioBusinessCorporationPage.confirmSentForReview();
        soIncorporateOntarioBusinessCorporationPage.SOAccountHomepageOCNwriteToCSV("TC06_EPCR001_ApplicationForEPLicenceForeignCorpWithShare");
        Assert.assertTrue(paymentConfirmationPage.extraProvincialLicenceForForeignCorporationStatusElementsAreDisplayed());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

}