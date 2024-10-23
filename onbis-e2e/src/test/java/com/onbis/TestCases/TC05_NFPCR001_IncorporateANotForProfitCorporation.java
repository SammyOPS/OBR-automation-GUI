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
public class TC05_NFPCR001_IncorporateANotForProfitCorporation extends SOAccountSetUp {

    /*
    5.Incorporate a Not-for-Profit Corporation: "NFPCR001 - Incorporate a Not-for-Profit Corporation"
     */
    @Test
    public void TC05_NFPCR001_IncorporateANotForProfitCorporation() throws IOException, InterruptedException {
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
        soIncorporateOntarioBusinessCorporationPage.SOAccountHomepageOCNwriteToCSV("TC05_NFPCR001_IncorporateANotForProfitCorporation");
        Assert.assertTrue(paymentConfirmationPage.incorporateNonProfitCorporationStatusElementsAreDisplayed());
    }


}