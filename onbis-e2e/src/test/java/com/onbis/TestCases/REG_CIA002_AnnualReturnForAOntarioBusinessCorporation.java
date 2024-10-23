package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class REG_CIA002_AnnualReturnForAOntarioBusinessCorporation extends SOAdminSetup {

    /*
        \\cihs.ad.gov.on.ca\MPBSD\Groups\LEGACY\gsdptovspifs002\MGS-Shared$\SO-PMO\Active PROJECTS\Business Development\BST\BST 2016-17\BST Projects By Portfolio\Registry Projects\ONBIS\NEW ONBIS\QA\WIP-2023\Automation\Presentation_Automation Scripts
            Steps for pre-condition data:
                Precondition Condition:
	Precondition	Description
        n Ref
        CIA002-PRE-
        The user must be logged in to ONEIS. Users include
        ServiceOntario Account Portal user (Joe Public).
        Partner Portal User (Lawyer).
        Admin Portel User (ServiceOntario Registry staff)
        CIA002-PRE-	The user has selected the active corporation that is one of the follo wing entity types
        Ontario Business Corporation (A)
        Not-for-profit Business Corporation (N)
        Social Club with Share (F)
        CIA002-PRE-
            For the following corporation registered in OCROOI - Assign an OCN, where is the corporation exempt from filing under the Corporations Information Act? Is 'No '

        Else. do not allowthese Special Act corporations to access the service
        CIA002-PRE-	The user has authority to maintain the corporatiom Authority is resolved as follo
        ServiceOntario Account Portal users and Partner Portel Users have authority over the corporation.
        Admin Portel User hes the appropriate permission to maintain corporations.



            Steps to reproduce:
                File Final Plan for Arrangement
                1)	Login into ONBIS Admin Portal
                2)	Create Ontario Corporation
                3)	Open Corporation
                4)	Select Make Changes, File Annual Return

                5)	Enter Contact Information, click Continue

                6)	On "Annual Return for Extra-Provincial Foreign Corporation" screen Select the <Annual Return Year>option that applies, Save and Continue
                7)	Select the <Address> , Save and Continue

                8)	Select if the corporation appointed a chief officer or manager in Ontario, Save and Continue

                9)	Select <Agent for service in Ontario>, Save and Continue

                10)	 Select Director or Officer for <Certification>, Save and Continue

                11). <Review and Authorization> screen populated with Generate PDF, and Authorization check box
                12) Review the screen, click on "Generate PDF" button to download a file
                13) Select the checkbox for "Authorization"
                14) Click Submit




     */
    @Parameters({"browser"})
    @Test // (invocationCount = 3)
    public void REG_CIA002_AnnualReturnForAOntarioBusinessCorporation(String browser) throws IOException, InterruptedException, AWTException {

        Reporter.log("-------: REG_CIA002_AnnualReturnForAOntarioBusinessCorporation -> ");
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

        partnerPortalLandingPage.searchByEntity(partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal());
        soIncorporateOntarioBusinessCorporationPage.GeneralDetailsOCNwriteToCSV( ("REG_CIA002_AnnualReturnForAOntarioBusinessCorporation"));
        partnerPortalLandingPage.selectFileAnnualReturn();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturn();
        soIncorporateOntarioBusinessCorporationPage.selectAnnualReturnYear();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();
        soIncorporateOntarioBusinessCorporationPage.completeCertification();
        soIncorporateOntarioBusinessCorporationPage.onlyReviewAndAuthorization();
        partnerPortalLandingPage.selectFilingsSubMenuOption();

        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.annualReturnIsCreated());



    }
}
