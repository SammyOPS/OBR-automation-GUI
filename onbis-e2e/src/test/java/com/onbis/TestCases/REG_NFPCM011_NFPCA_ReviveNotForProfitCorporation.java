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
public class REG_NFPCM011_NFPCA_ReviveNotForProfitCorporation extends SOAdminSetup {

    /*

        Precondition Description:
            NFPCMO11-PRE-0L
            The user must be logged in to ONBIS. Users include:
            External User with Authority (e.g Joe Public, Lawyer)
            © Admin User (e.g. ServiceOntario Registry staff]

            NFPCMO11-PRE02

            ‘The selected Not-for-profit Corporation N) has Status = “inactive”
            NFPCMO11-PRE03
            NFPCMO11-PRE-04
            The selected Not-for-Profit Corporation (N) has Sub-Status = “Cancelled by C5."
            “Inactive Date’ must not be more than 20 years ago
            NFPCMO11-PRE05
            “The user has authority to maintain the corporation. Authority is resolved as follows:
            External User with Authority has authority over the corporation
            Admin User has the appropriate permission to maintain the corporation
            3.3 Service Information
            Entity Nome, (dentifier and Entity Type wil be shown on top of the screen.


         Steps to reproduce:
         NFPCM011-Revive a Not-for-Profit Corporation
            1)	Login into ONBIS Partner Portal
            2)	Register Not-For-Profit Corporation
            3)	Open Not-For-Profit Corporation
            4)	Click Make Changes and select NFPCA - Articles of Revival
            5)	On Contact Information screen add First Name (mandatory), Middle Name (Optional) with value, Last Name (mandatory), Email address (mandatory),
            Upload NFPCA-Notice Voluntary Winding Up Notice of Special Resolution, click Continue
            6)	On Corporation Name form click Save and Continue
            7)	On Required Statements form put check mark and click Save and Continue
            8)	On Applicant form add Applicant Name, Applicant’s interest in the corporation, Address. Click Save and Continue
            9)	On Review and Authorization form select a check box for Authorization.
            10)	Generate PDF
            11)	Click Submit
            12)	On Payment screen select Payment Method and click Continue
            13)	Get to Work Queue page, search for the entity
            14)	Application required approval.
            15)	The application Due for approval in 3 days. In 3 days click Do It Now.
            16)	Click Approve Form
            17)	After form approval the transaction completed





      */
    @Parameters({"browser"})
    @Test //(invocationCount = 3)
    public void REG_NFPCM011_NFPCA_ReviveNotForProfitCorporation() throws InterruptedException, AWTException {

        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: REG_NFPCM011_NFPCA_ReviveNotForProfitCorporation-> ");

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
        HelperMethods.writeToCSV("REG_NFPCM011_NFPCA_ReviveNotForProfitCorporation", oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation(oCN);
        partnerSoleProprietorshipRegistrationPage.ontarioBusinessIncorporationUpdateSubStatusCancelledByCB();
        partnerSoleProprietorshipRegistrationPage.articlesOfRevivalMakeChanges();

        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
        soIncorporateOntarioBusinessCorporationPage.revivalNameRequiredStatements();
//        soIncorporateOntarioBusinessCorporationPage.completeAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsFileArticlesOfRevival();
        soIncorporateOntarioBusinessCorporationPage.completeApplicantAndSave();
        partnerSoleProprietorshipRegistrationPage.reviewAuthorizationAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();

        soIncorporateOntarioBusinessCorporationPage.reviewDashboardAndApproveFromWorkQueueEP(oCN);
//        soIncorporateOntarioBusinessCorporationPage.reviewDashboardAndApproveFromWorkQueueEP(oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        Thread.sleep(2000);
        partnerPortalLandingPage.searchByEntity(oCN);
//        HelperMethods.writeToCSV("REG_NFPCM011_NFPCA_ReviveNotForProfitCorporation", oCN);
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.reviveAnOntarioBusinessCorporationVerification());

    }
}
