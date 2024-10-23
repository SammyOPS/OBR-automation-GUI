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
public class REG_NFPCM010_NFPCA_FileArticlesOfDissolution extends SOAdminSetup {

    /*

        Precondition Description:
            NFPCM006- PRE-01
            The user must be logged in to ONBIS. Users include:
            •	Service Ontario Account Portal user (Joe Public)
            •	Partner Portal user (Lawyer)
            •	Admin Portal user (Service Ontario Registry staff).
            NFPCM006- PRE-02
            •	The user has selected the corporation that is one of the following entity types: Active Not-For-Profit Corporation (N)
            NFPCM006- PRE-03
            •	The user has authority to maintain the corporation. Authority is resolved as follows:
            •	Service Ontario Account Portal users and Partner Portal Users have authority over the corporation.
            •	Admin Portal User has the appropriate permission to maintain corporations.

         Amend Articles
         Steps to reproduce:

            NFPCM010-Dissolve a Not-For-Profit Corporation
            1)	Login into ONBIS Partner Portal
            2)	Register Not-For-Profit Corporation
            3)	Open Not-For-Profit Corporation
            4)	Click Make Changes and select File Articles of Dissolution
            5)	On Contact Information screen add First Name (mandatory), Middle Name (Optional) with value, Last Name (mandatory), Email address (mandatory),
            Upload NFPCA-Article of Dissolution, click Continue
            6)	Select all options as on the snapshot below
            7)	Select Effective Day
            8)	Generate PDF
            9)	Select the check box for Authorization
            10)	  Submit




      */
    @Parameters({"browser"})
    @Test //(invocationCount = 3)
    public void REG_NFPCM010_NFPCA_FileArticlesOfDissolution() throws InterruptedException, AWTException {

        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: REG_NFPCM010_NFPCA_FileArticlesOfDissolution-> ");

        soAdminOntarioBusinessRegistryDashboardPage.selectIncorporateNotForProfitCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameIncorporateNotForProfitCorporationSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeThreeDirectorsSave();
        soIncorporateOntarioBusinessCorporationPage.completePurposesAndProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.reviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();

        String oCN = partnerPortalLandingPage.getCompletedOntarioCorporationNumber();
        System.out.println("Incorporate an Ontario Not-for-Profit Corporationn Number (OCN) number is: " + oCN);
        Reporter.log("Incorporate an Ontario Not-for-Profit Corporation Corporation Number (OCN) number is: " + oCN);
        HelperMethods.writeToCSV("REG_NFPCM010_NFPCA_FileArticlesOfDissolution", oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation(oCN);

        soIncorporateOntarioBusinessCorporationPage.fileArticlesOfDissolutionOption();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
        soIncorporateOntarioBusinessCorporationPage.fileArticlesOfDissolution_VoluntaryDissolution();
        soIncorporateOntarioBusinessCorporationPage.reviewDashboardAndApproveFromWorkQueueEP(oCN);
        soIncorporateOntarioBusinessCorporationPage.reviewDashboardAndApproveFromWorkQueueEP(oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchByEntity(oCN);
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.verifyFileArticlesOfDissolution());

    }
}
