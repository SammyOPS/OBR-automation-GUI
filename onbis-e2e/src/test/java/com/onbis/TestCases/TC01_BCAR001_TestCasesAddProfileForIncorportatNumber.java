package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.SOIncorporateOntarioBusinessCorporationPage;
import com.onbis.Pages.SOPaymentConfirmationPage;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class TC01_BCAR001_TestCasesAddProfileForIncorportatNumber extends SOAccountSetUp {

    /*
     * 1. creates ONekeyID and Incorporate an Ontario Business Corporation- Number: "BCAR001 - test cases for Incorportate"
     * */
    @Test (invocationCount = 1)
    @DisplayName("1.Incorporate an Ontario Business Corporation- Number")
    public void TC01_BCAR001_TestCasesAddProfileForIncorportatNumber() throws InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
//        oneKeyLogin.createONekeyID(); // Need to continue working...
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();
        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
//        oneKeyLogin.registerNewUserSOAB();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();
        soIncorporateOntarioBusinessCorporationPage.SOAccountHomepageOCNwriteToCSV("TC01_BCAR001_TestCasesAddProfileForIncorportatNumber");
        Assert.assertTrue(paymentConfirmationPage.paymentConfirmationElementsAreDisplayed());
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);

    }


}