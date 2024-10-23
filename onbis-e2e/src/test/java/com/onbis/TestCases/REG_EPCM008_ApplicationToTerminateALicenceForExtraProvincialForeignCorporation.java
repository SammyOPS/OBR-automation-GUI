package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.SOIncorporateOntarioBusinessCorporationPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class REG_EPCM008_ApplicationToTerminateALicenceForExtraProvincialForeignCorporation extends SOAdminSetup {

    /*
        precondition Ref:
        Precondition Description Ref
            EPCM008-PRE- The user must be logged in to ONBIS. Users include:
            01
            • External User with Authority (e.g. Joe Public, Lawyer) • Admin User (e.g. ServiceOntario Registry staff)
            EPCM008-PRE-02
            The selected Extra-Provincial Foreign Corporation with Share (K) has Status = "Active"
            EPCM008-PRE- The user has authority to maintain the corporation. Authority is resolved as follows:
            03
            External User with Authority has authority over the corporation Admin User has the appropriate permission to maintain the corporation
            3.3 Service Information Entity Name, Identifier and Entity Type will be shown on top of the screen.
        Application to Terminate a Licence for a Foreign Corp
        Steps to reproduce:

            1)	Login into ONBIS Admin Portal
            2)	Register Extra-Provincial Foreign Corporation
            3)	File Initial Return for Extra-Provincial Foreign Corporation
            4)	Click Make Changes and select "File Application for Termination of Extra-Provincial Licence"
            5)	On Contact Information screen add First Name (mandatory), Middle Name (Optional)  with value, Last Name (mandatory), Email address (mandatory),
            Upload EPCA- Termination of Extra-Provincial Foreign Licence, Click Continue
            6)	On Termination Confirmation screen select check box for confirmation
            7)	Generate PDF
            8)	Click Submit button

     */
    @Parameters({"browser"})
    @Test // (invocationCount = 3)
    public void REG_EPCM008_ApplicationToTerminateALicenceForExtraProvincialForeignCorporation(String browser) throws IOException, InterruptedException, AWTException {
        Reporter.log("-------: REG_EPCM008_ApplicationToTerminateALicenceForExtraProvincialForeignCorporation -> ");
        mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectRegistryAsApplicationForExtraProvincialLicenceForForeignCorp();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveOCN();
        Thread.sleep(2000);
        soIncorporateOntarioBusinessCorporationPage.completeJurisdictionForExtraProvincialLicenceForeignCorp();
        soIncorporateOntarioBusinessCorporationPage.setExtraProvincialCorporation(soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveExtraProvincialCorporation(browser));
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSaveForeignCorpAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeChiefOfficerAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeAgentForServiceAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsAndSaveForeignCorp();

        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        soIncorporateOntarioBusinessCorporationPage.reviewAndApproveFromWorkQueue();

        partnerPortalLandingPage.selectSearchRegistry();
        soIncorporateOntarioBusinessCorporationPage.searchCorporationAndSelectResult();
        soIncorporateOntarioBusinessCorporationPage.writeOCNToCSVFromGeneralDetails("REG_EPCM008_ApplicationToTerminateALicenceForExtraProvincialForeignCorporation");
        partnerPortalLandingPage.selectFileInitialReturn();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.selectGeneralDetails();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();
        soIncorporateOntarioBusinessCorporationPage.completeCertificationInitialReturnAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completegeneratePDFReviewAndAuthorizeAndSubmitCorporation();

        soIncorporateOntarioBusinessCorporationPage.fileApplicationForTerminationOfExtraProvincialLicenceOption();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
//        contactInformationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.terminationConfirmationAndSubmit();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.terminationOfExtraProvincialLicenceIsVerified());

    }
}
