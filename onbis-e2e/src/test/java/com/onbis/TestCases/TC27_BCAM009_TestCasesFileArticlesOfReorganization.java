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
import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class TC27_BCAM009_TestCasesFileArticlesOfReorganization extends SOAccountSetUp {

    /*
    27. Articles of Reorganization: "BCAM009 - test cases File Articles of Reorganization"
     */
    @Test
    public void TC27_BCAM009_TestCasesFileArticlesOfReorganization() throws
            InterruptedException, IOException, AWTException {
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
//        soIncorporateOntarioBusinessCorporationPage.completeCourtOrderBusinessCorp();
        soIncorporateOntarioBusinessCorporationPage.fileArticlesOfReorganizationCourtOrderBusinessCorp();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        soIncorporateOntarioBusinessCorporationPage.confirmSentForReview();
        soIncorporateOntarioBusinessCorporationPage.SOAccountHomepageOCNwriteToCSV("TC27_BCAM009_TestCasesFileArticlesOfReorganization");
        Assert.assertTrue(paymentConfirmationPage.fileArticleOfReorganizationElementsAreDisplayed());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

}