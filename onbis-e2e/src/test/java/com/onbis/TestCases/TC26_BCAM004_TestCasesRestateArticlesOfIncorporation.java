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
public class TC26_BCAM004_TestCasesRestateArticlesOfIncorporation extends SOAccountSetUp {

    /*
    26. Restated Articles of Incorporation: "BCAM004 - test cases Restate Articles of Incorporation"
     */
    @Test
    public void TC26_BCAM004_TestCasesRestateArticlesOfIncorporation() throws
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

        viewCorporationPage.selectRestartedArticleOfIncorporation();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSaveOntarioBusinessCorp();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        soIncorporateOntarioBusinessCorporationPage.GeneralDetailsOCNwriteToCSV ("TC26_BCAM004_TestCasesRestateArticlesOfIncorporation");
        Assert.assertTrue(viewCorporationPage.businessCorporationArticleOfIncorporationIsRestarted());
    }

}