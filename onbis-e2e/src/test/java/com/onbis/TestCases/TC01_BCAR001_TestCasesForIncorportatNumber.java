package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.EmailUtils;
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
public class TC01_BCAR001_TestCasesForIncorportatNumber extends SOAccountSetUp {

    /*
     * 1.Incorporate an Ontario Business Corporation- Number: "BCAR001 - test cases for Incorportate"
     * */
    @Test
    @DisplayName("1.Incorporate an Ontario Business Corporation- Number")
    public void TC01_BCAR001_TestCasesForIncorportatNumber() throws InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
// +++++++++++++++
//        oneKeyLogin.createONekeyID(); // Need to continue working...
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();



//        oneKeyLogin.loginUsingOneKeyCredentials();
//        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
//        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();
// +++++++++++++++++++++
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();
        soIncorporateOntarioBusinessCorporationPage.SOAccountHomepageOCNwriteToCSV("TC01_BCAR001_TestCasesForIncorportatNumber");
        Assert.assertTrue(paymentConfirmationPage.paymentConfirmationElementsAreDisplayed());
//        Assert.assertTrue(paymentConfirmationPage.emailReceivedAndValidationConfirmation());
        EmailUtils.emailTransactionNumberIsDisplayed(Config.EMAIL, Config.EMAIL_PASSWORD, "Transaction Number:", "Dear Client");
    }


}