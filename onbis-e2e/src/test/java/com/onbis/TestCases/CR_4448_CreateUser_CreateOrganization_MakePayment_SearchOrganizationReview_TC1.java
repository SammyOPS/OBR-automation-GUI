package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4448_CreateUser_CreateOrganization_MakePayment_SearchOrganizationReview_TC1 extends SOAdminSetup {

    /*
        ONBBAT-4448: Partner Portal Access

        7
        "The additional user will create some transactions in the partner portal.

        The additiona user (Amber) creted the following transactions using her partner portal access
            - Register a GP, register biz name and search products
            - Register Condo corp, register biz name and search products"
            The user can create transactions using partner portal

         Reference:
        https://ontariogov.sharepoint.com/sites/GSIC/onbismod/Project Workstreams/Business Services Unit/UAT/04. November 2022 Release/UAT Test Docs/Lesley/a. ONBAT 4448-Partner Poratl Acces.xlsx
         Folder Name: "Lesley"

      */
    @Test (invocationCount = 1)
    @DisplayName("1.Incorporate an Ontario Business Corporation- Number")
    public void CR_4448_CreateUser_CreateOrganization_MakePayment_SearchOrganizationReview_TC1() throws InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
//        oneKeyLogin.createONekeyID();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();
        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();

        Assert.assertTrue(paymentConfirmationPage.paymentConfirmationElementsAreDisplayed());


        String oCN = partnerPortalLandingPage.getOntarioCorporationQueueNumber();
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation(oCN);
         Assert.assertTrue(paymentConfirmationPage.emailReceivedAndValidationConfirmation());

//        String oCN = partnerPortalLandingPage.getOntarioCorporationNumber();
        System.out.println("Ontario Corporation Number (OCN) number is: " + oCN);
        Reporter.log("Ontario Corporation Number (OCN) number is: " + oCN);

        partnerPortalLandingPage.selectRegisterForABusinessName();
        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationNameEmailAndSave();
        String getBusinesssName =soIncorporateOntarioBusinessCorporationPage.completeRegisterABusinessNameShort();
//        String getBusinesssName =soIncorporateOntarioBusinessCorporationPage.completeRegisterBusinessNameForGeneralPartnership();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());


        partnerPortalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.businessNameCorporationIsRegistered(getBusinesssName));
    }


}