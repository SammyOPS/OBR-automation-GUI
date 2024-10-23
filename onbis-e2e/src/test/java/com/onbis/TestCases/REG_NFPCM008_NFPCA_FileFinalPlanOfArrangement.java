package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(ListenersTestNG.class)
public class REG_NFPCM008_NFPCA_FileFinalPlanOfArrangement extends SOAdminSetup {

    /*

        Precondition Description:
            NFPCMO11-PRE-0L
            The user must be logged in to ONBIS. Users include:
            External User with Authority (e.g Joe Public, Lawyer)
            Admin User (e.g. ServiceOntario Registry staff]
         Steps to reproduce:
           NFPCM008-File Final Plan of Arrangement
                1)	Login into ONBIS Partner Portal
                2)	Register Not-For-Profit Corporation
                3)	Open Not-For-Profit Corporation
                4) Click Make Changes and select File Articles of Arrangement
                5)	On Contact Information screen add First Name (mandatory), Middle Name (Optional) with value, Last Name (mandatory), Email address (mandatory),
                Upload NFPCA-Article of Arrangement Draft Filing, click Submit
                6)	Click OK on the Warning message
                7)	Add Summary of Changes, Requested Date for Arrangement
                8)	Generate PDF
                9)	Upload Plan of Arrangement, and Court Order
                10)	Select check box for Authorization
                11)	Submit
                12)	On Fee Payment form select CASH, click Continue
                13)	Finalize Transaction
                14)	Get to Work Queue page, search for the entity
                15)	Application required approval. Click Do It Now.
                16)	Click Approve Form
                17)	After form approval the transaction completed

      */
    @Parameters({"browser"})
    @Test //(invocationCount = 3)
    public void REG_NFPCM008_NFPCA_FileFinalPlanOfArrangement() throws InterruptedException, AWTException {

        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: REG_NFPCM008_NFPCA_FileFinalPlanOfArrangement-> ");
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
        HelperMethods.writeToCSV("REG_NFPCM008_NFPCA_FileFinalPlanOfArrangement", oCN);
        partnerPortalLandingPage.searchByEntity(partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal());
        soIncorporateOntarioBusinessCorporationPage.fileArticlesOfArrangement();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationFinalPlanOfArrangementAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeFinalPlanOfArrangementNotforProfitCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        soIncorporateOntarioBusinessCorporationPage.reviewDashboardAndApproveFromWorkQueueEP(oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        Thread.sleep(2000);
        partnerPortalLandingPage.searchByEntity(oCN);
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.reviveAnNFPCA_ARTICLES_OF_ARRANGEMENT());

    }
}
