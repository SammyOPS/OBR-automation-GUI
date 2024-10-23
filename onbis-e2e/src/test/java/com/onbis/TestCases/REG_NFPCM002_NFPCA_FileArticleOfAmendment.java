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
public class REG_NFPCM002_NFPCA_FileArticleOfAmendment extends SOAdminSetup {

    /*

        Precondition Description:
            NFPCM002- PRE-01
                The user must be logged in to ONBIS. Users include:
                • ServiceOntario Account Portal user (Joe Public).
                • Partner Portal user (La wye r).
                • Admin Portal user (ServiceOntario Registry staff).
            NFPCM002- PRE-02
                The user has selected the corporation that is one of the following entity types:
                • Active Not-For-Profit Corporation (N)
            NFPCM002- PRE-03
                The user has authority to maintain the corporation.
                     Authority is resolved as follows: ServiceOntario Account Portal users and Partner Portal Users have authority over the corporation.
                     Admin Portal User has the appropriate permission to maintain corporations.
                     Admin Portal User must have the permission ROLE_ARRANGEMENTS to complete a submission of a Final Plan of Arrangement.

         Amend Articles
         Steps to reproduce:
            1)	Login into ONBIS Partner Portal
            2)	Register Not-For-Profit Corporation
            3)	Open Not-For-Profit Corporation
            4)	Click Make Changes and select File Article of Amendment
            5)	On Contact Information screen add First Name (mandatory), Middle Name (Optional) with value, Last Name (mandatory), Email address (mandatory),
            Upload NFPCA-Articles of Amendment, click Submit
            6)	Select Will this corporation have a number name? = Yes
            7)	Number of Directors select ‘Fixed Number’
            8)	Select Is the corporation a charity = No
            9)	Add Description of changes
            10)	Add Member Authorization and Effective Day
            11)	Generate PDF
            12)	Select check box for Authorization
            13)	Submit
            14)	On Fee Payment form select CASH, click Continue
            15)	Finalize Transaction

      */
    @Parameters({"browser"})
    @Test //(invocationCount = 3)
    public void REG_NFPCM002_NFPCA_FileArticleOfAmendment() throws InterruptedException, AWTException {

        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: REG_NFPCM002_NFPCA_FileArticleOfAmendment-> ");

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
        HelperMethods.writeToCSV("REG_NFPCM002_NFPCA_FileArticleOfAmendment", oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation(oCN);
        viewCorporationPage.fileArticlesOfAmendmentOfIncorporation1();
//        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturn();
//        contactInformationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.fileArticlesOfAmendmentCorporationName();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();

        Assert.assertTrue(viewCorporationPage.nFPCA_FileArticleOfAmendment());


    }
}
