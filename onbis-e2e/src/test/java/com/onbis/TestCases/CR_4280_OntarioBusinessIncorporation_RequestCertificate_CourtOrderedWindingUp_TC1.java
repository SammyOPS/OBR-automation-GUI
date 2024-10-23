package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4280_OntarioBusinessIncorporation_RequestCertificate_CourtOrderedWindingUp_TC1 extends SOAdminSetup {

    /*
        o. https://ontariogov.sharepoint.com/sites/GSIC/onbismod/Project Workstreams/Business Services Unit/UAT/04. November 2022 Release/UAT Test Docs/Olin/ONBAT 4260 N 4279 N 4277 N 4574 N 4592 N 4628-Min Name N Leading 0 N Intl Address N Upper Case-a-S.xlsx

            Steps for pre-condition data:
            1)	Launch Portal (Note If Admin – you can pick any data | If Partner Portal – you should be authorised user on data to change the entity status)
            2)	Search Registry>> Find any Ontario Business Incorporation where Status = Inactive
            3)	Open the test data in view mode
            4)	Admin >> Change Entity Status >> Update Sub status = Court Order winding up >> Submit
            5)	Now you have the desire data ready to perform CR-4280 activity.


            Steps to reproduce:
            1)	Login into test environment >> Admin portal
            2)	Search Registry >>  Ontario Business Corporation (A)' with sub status - Court ordered winding up must exist and must be inactive.
            3)	Open the Test data in View mode
            Sceario#1
            4)	On top left corner find Request Search Product >>Click >>Validate  Request Certificate of Status is available
            5)	Select the option Request Certificate of Status

     */
    @Parameters({"browser"})
    @Test
    public void CR_4280_OntarioBusinessIncorporation_RequestCertificate_CourtOrderedWindingUp_TC1(String browser) throws IOException, InterruptedException, AWTException {

//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        Reporter.log("-------: CR_4280_OntarioBusinessIncorporation_RequestCertificate_CourtOrderedWindingUp_TC1 -> ");
        mgcsAdminLandingPage.launchAdminPortal();
        partnerSoleProprietorshipRegistrationPage.selectRegistryAsIncorporateOntarioBusinessCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAsNumberAndSaveIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();

        partnerPortalLandingPage.searchByEntity(partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal());

        partnerSoleProprietorshipRegistrationPage.ontarioBusinessIncorporationUpdateSubStatusCourtOrderwindingUp();
        partnerSoleProprietorshipRegistrationPage.requestCertificateOfStatus();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.requestCertificateOfStatusEmail());

    }
}
