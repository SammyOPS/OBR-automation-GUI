package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.ViewCorporationPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class REG_BCAM008_FileFinalPlanForArrangement extends SOAdminSetup {

    /*
        \\cihs.ad.gov.on.ca\MPBSD\Groups\LEGACY\gsdptovspifs002\MGS-Shared$\SO-PMO\Active PROJECTS\Business Development\BST\BST 2016-17\BST Projects By Portfolio\Registry Projects\ONBIS\NEW ONBIS\QA\WIP-2023\Automation\Presentation_Automation Scripts
            Steps for pre-condition data:
                Precondition Condition:

                The user must be logged in to ONBIS. Users include:
                • Service Ontario Account Portal user (Joe Public),
                • Partner Portal User (Lawyer),
                • Admin Portal User (Service Ontario Registry staff).

                The user has selected the active corporation that is one of the following entity types:
                Ontario Business Corporation
                BCAM008-PRE- The user has authority to maintain the corporation. Authority is resolved as follows:
                Service Ontario Account Portal users and Partner Portal Users have authority over the corporation, Admin Portal User has the appropriate permission to maintain corporations.

            Steps to reproduce:
                File Final Plan for Arrangement
                1)	Login into ONBIS Partner Portal
                2)	Select Services Tab
                3)	Click Search the Registry
                4)	Search for active corporation by entering corporation name or OCN and click search button
                5)	Select Corporation from search results
                6)	Click Make Changes and select File Draft Plan of Arrangement
                7)	Accept Terms and Conditions
                8)	Add Contact Information
                9)	Click Continue
                10)	On Article of Arrangement screen select NO for Draft of this Plan of Arrangement submitted for review?
                11)	Click OK on Warning
                12)	Add Summary of Changes, Requested Date of Arrangement, Plan of Arrangement, Court Order
                13)	Select Authorization Box
                14)	Click Submit button
                15)	On Payment screen select Method of Payment <Cash>
                16)	Click Continue
                17)	Finalize Transaction.

     */
    @Parameters({"browser"})
    @Test // (invocationCount = 3)
    public void REG_BCAM008_FileFinalPlanForArrangement(String browser) throws IOException, InterruptedException, AWTException {


        Reporter.log("-------: REG_BCAM008_FileFinalPlanForArrangement -> ");
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
        partnerSoleProprietorshipRegistrationPage.fileArticlesOfFileArrangementOfIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationFileArticlesOfContinuanceSave();
        partnerSoleProprietorshipRegistrationPage.articlesOfArrangementAuthorizationAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        soIncorporateOntarioBusinessCorporationPage.GeneralDetailsOCNwriteToCSV( ("REG_BCAM008_FileFinalPlanForArrangement"));
//        partnerPortalLandingPage.selectFilingsSubMenuOption();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.fileFinalPlanForArrangementVerification());

    }
}
