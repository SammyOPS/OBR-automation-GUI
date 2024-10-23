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
public class REG_NFPCM006_NFPCA_AuthorizationToContinueOut extends SOAdminSetup {

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
            NFPCM006-Authorization to Continue Out
            1)	Login into ONBIS Partner Portal
            2)	Register Not-For-Profit Corporation
            3)	Open Not-For-Profit Corporation
            4)	Click Make Changes and select File Application for Authorization to Continue Out of the Not-for-Profit Corporations Act
            5)	On Contact Information screen add First Name (mandatory), Middle Name (Optional) with value, Last Name (mandatory), Email address (mandatory),
                Upload NFPCA-An Authorization to Continue in Another Jurisdiction, click Submit
            6)	Select Another Canadian Jurisdiction
            7)	Select the Jurisdiction where the corporation is applying to continue
            8)	Select the check boxes for ‘Please indicate that the corporation confirm the following’
            9)	Generate PDF
            10)	Select check box for transaction authorization
            11)	Submit
            12)	On Fee Payment form select CASH, click Continue
            13)	Finalize Transaction
            14)	Get to Work Queue page, search for the entity
            15)	Application required approval. Click Do It Now.
            16)	Click Approve Form
            17)	After form approval the transaction completed.

      */
    @Parameters({"browser"})
    @Test //(invocationCount = 3)
    public void REG_NFPCM006_NFPCA_AuthorizationToContinueOut() throws InterruptedException, AWTException {

        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: REG_NFPCM006_NFPCA_AuthorizationToContinueOut-> ");

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
        HelperMethods.writeToCSV("REG_NFPCM006_NFPCA_AuthorizationToContinueOut", oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation(oCN);
        viewCorporationPage.fileArticlesOfAuthorizationContinueOutOfBusiness1();
//        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturn();
        soIncorporateOntarioBusinessCorporationPage.completeApplicationForAuthorizationToContinueOutOfNFPCA();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        Assert.assertTrue(viewCorporationPage.nFPCA_FileArticleOfAmendment());


    }
}
