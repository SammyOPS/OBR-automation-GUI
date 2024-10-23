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
public class REG_EPCM007_ApplicationForAmendmentToLicenceForAForeignCorporation extends SOAdminSetup {

    /*
        Precondition Description Ref
        EPCM007-PRE-01
        The user must be logged in to ONBIS. Users include: • External User with Authority (e.g. Joe Public, Lawyer) • Admin User (e.g. ServiceOntario Registry staff)

        EPCM007-PRE-02
        The selected Extra-Provincial Foreign Corporation with Share (K) has Status = "Active"

        EPCM007-PRE-02
        The user has authority to maintain the corporation. Authority is resolved as follows: • External User with Authority has authority over the corporation • Admin User has the appropriate permission to maintain the corporation
        3.3 Service Information Entity Name. identifier and Entity Type will be shown on top of the screen.
        •VADMI 1,141.11.....1.^ AIM VS • I./ wean. Aniwalxon Ice ineterthed Pronnusel Lusa nprrat...ent.amenttaus •Auanama

        Application for Amendment to Licence for a Foreign Corporation
        Steps to reproduce:


            1)	Login into ONBIS Admin Portal
            2)	Register Extra-Provincial Foreign Corporation
            3)	File Initial Return for Extra-Provincial Foreign Corporation
            4)	Click Make Changes and select File Application for Amendment to Licence for Extra-Provincial Foreign Corporation
            5)	On Contact Information screen add First Name (mandatory), Middle Name (Optional)  with value, Last Name (mandatory), Email address (mandatory),
            Upload EPCA- Amended Extra-Provincial Foreign Licence, Click Continue
            6)	On Name & Governing Jurisdiction form change State to XXXXXX, select Authorization box
            7)	Generate PDF
            8)	Click Submit button
            9)	On Fee Payment screen select CASH, click Continue
            10)	Finalize Transaction

     */
    @Parameters({"browser"})
    @Test // (invocationCount = 3)
    public void REG_EPCM007_ApplicationForAmendmentToLicenceForAForeignCorporation(String browser) throws IOException, InterruptedException, AWTException {
        Reporter.log("-------: REG_EPCM007_ApplicationForAmendmentToLicenceForAForeignCorporation -> ");
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
        soIncorporateOntarioBusinessCorporationPage.writeOCNToCSVFromGeneralDetails("REG_EPCM007_ApplicationForAmendmentToLicenceForAForeignCorporation");
        partnerPortalLandingPage.selectFileInitialReturn();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.selectGeneralDetails();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();
        soIncorporateOntarioBusinessCorporationPage.completeCertificationInitialReturnAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completegeneratePDFReviewAndAuthorizeAndSubmitCorporation();

        soIncorporateOntarioBusinessCorporationPage.fileApplicationForAmendedExtraProvincialLicenceOption();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationfileApplicationForAmendedExtraProvincialLicenceAndSave();
        soIncorporateOntarioBusinessCorporationPage.nameGoverningJurisdictionAmendedExtraProvincialLicence();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.fileApplicationForAmendedExtraProvincialLicenceVerification());

    }
}
