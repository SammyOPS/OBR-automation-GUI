package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(ListenersTestNG.class)
public class REG_NFPCM007_NFPCA_FileDraftPlanOfArrangement extends SOAdminSetup {

    /*

        Precondition Description:
            NFPCMO11-PRE-0L
            The user must be logged in to ONBIS. Users include:
            External User with Authority (e.g Joe Public, Lawyer)
            © Admin User (e.g. ServiceOntario Registry staff]

            NFPCMO11-PRE02

            Precondition
            Ref
            Description
            NFPCR007-PRE- The user must be logged in to ONBIS. Users include:

            Service Ontario Account Portal user (Joe Public)
            ·
            Partner Portal user (Lawyer)
            Admin Portal user (Service Ontario Registry staff).
            NFPCR007-PRE- The user has selected the corporation that is one of the following entity types: Active Not-For-Profit Corporation (N)


            ·
            NFPCR007-PRE- The user has authority to maintain the corporation. Authority is resolved as follows: Service Ontario Account Portal users and Partner Portal Users have authority over the corporation.
            Admin Portal User has the appropriate permission to maintain corporations.
            Service Information
            The Form Heading is always displayed at the top of the form.
            1000000004 ONTARIO NOT-FOR-PROFIT (1000000004) (Not-for-Profit Corporation)


         Steps to reproduce:
            NFPCM007-File Draft Plan of Arrangement
            1)	Login into ONBIS Admin Portal
            2)	Register Not-For-Profit Corporation
            3)	Open Not-For-Profit Corporation
            4) Click Make Changes and select File Draft Plan of Arrangement
            4)	On Contact Information screen add First Name (mandatory), Middle Name (Optional) with value, Last Name (mandatory), Email address (mandatory),
            Upload NFPCA-Article of Arrangement Draft Filing, click Submit
            5)	Add Summary of Changes
            6)	Generate PDF
            7)	Select check box for Authorization
            8)	Submit
            9)	Get to Work Queue page, search for the entity
            10)	 Application required approval. Click Do It Now.
            11)	Click Approve Form
            12)	After form approval the transaction completed

      */
    @Parameters({"browser"})
    @Test //(invocationCount = 3)
    public void REG_NFPCM007_NFPCA_FileDraftPlanOfArrangement() throws InterruptedException, AWTException {

        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: REG_NFPCM007_NFPCA_FileDraftPlanOfArrangement-> ");
        soAdminOntarioBusinessRegistryDashboardPage.selectIncorporateNotForProfitCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameIncorporateNotForProfitCorporationSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeThreeDirectorsSave();
        soIncorporateOntarioBusinessCorporationPage.completePurposesAndProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.reviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        Thread.sleep(3000);
        String oCN = partnerPortalLandingPage.getCompletedOntarioCorporationNumber();
        System.out.println("Incorporate an Ontario Not-for-Profit Corporationn Number (OCN) number is: " + oCN);
        Reporter.log("Incorporate an Ontario Not-for-Profit Corporation Corporation Number (OCN) number is: " + oCN);
        HelperMethods.writeToCSV("REG_NFPCM007_NFPCA_FileDraftPlanOfArrangement", oCN);
        partnerPortalLandingPage.searchByEntity(partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal());
        soIncorporateOntarioBusinessCorporationPage.selectFileDraftPlanOfArrangement();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationNFPCA_FileDraftPlanOfArrangementAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDraftPlanOfArrangementNotforProfitCorporation();
        soIncorporateOntarioBusinessCorporationPage.reviewDashboardAndApproveFromWorkQueueEP(oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        Thread.sleep(2000);
        partnerPortalLandingPage.searchByEntity(oCN);
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.reviveAnNFPCA_FileDraftPlanOfArrangement());

    }
}
