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
public class TC02_BCAR001_TestCasesForIncorportateName extends SOAccountSetUp {

    /*
     * 2.Incorporate an Ontario Business Corporation- Name: "BCAR001 - test cases for Incorportate"
     * */
    @Parameters({"browser"})
    @Test
    public void TC02_BCAR001_TestCasesForIncorportateName(String browser) throws IOException, InterruptedException, XPathExpressionException, SAXException, ParserConfigurationException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        Thread.sleep(3500);
        soAccountLandingPage.selectAddProfile();
        Thread.sleep(1500);
        soAccountLandingPage.completeProfileDetailsAndSave();
        Thread.sleep(1500);
        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNameAndSave(browser);
        soIncorporateOntarioBusinessCorporationPage.SOAccountHomepageOCNwriteToCSV("TC02_BCAR001_TestCasesForIncorportateName");
        Assert.assertTrue(paymentConfirmationPage.paymentConfirmationElementsAreDisplayed());
//        Assert.assertTrue(paymentConfirmationPage.emailReceivedAndValidationConfirmation());
    }

}