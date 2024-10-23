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
public class REG_CIA006_NoticeOfChangeForEPForeignCorpWithShare extends SOAdminSetup {

    /*
        precondition Ref:
            Description
            CiA006-PRE- 01
            The user must be logged in to ONBIS. Users include: • External User with Authority (e.g. Joe Public, Lawyer) • Admin User (e.g. ServiceOntario Registry staff)
            CIA006-PRE- 02
            The selected Extra-Provincial Foreign Corporation with Share (K) has Status "Active"
            CIA006-PRE- 03
            The selected Extra-Provincial Foreign Corporation with Share (K) has already filed an Initial Return (see 0.4004 Initial Return for Extra-Provincial Foreign Corporation with Share).
            CIA006-PRE- 04
            The user has authority to maintain the corporation. Authority is resolved as follows: External User with Authority has authority over the corporation Admin User has the appropriate permission to maintain the corporation
            3.3 Service Information
            Entity Name, Identifier and Entity Type will be shown on top of the screen.

        Initial Return for an Extra-Provincial Corp
        Steps to reproduce:
            Notice of Change for EP ForeignCorp with Share

            1)	Login into ONBIS Admin Portal
            2)	Create Extra-Provincial Foreign Corporation
            3)	File Initial Return for Extra-Provincial Foreign Corporation
            4)	Click Make Changes and select File Notice of Change
            5)	On Contact Information screen add First Name (mandatory), Middle Name (Optional)  with value, Last Name (mandatory), Email address (mandatory),
            Upload CIA- Notice of Changes, Click Continue
            6)	On General Details screen add Ceased Activity in Ontario Date, click Save and Continue
            7)	On Address screen Change Principal Place of Business, click Save and Continue
            8)	Chief Officer or Manager form click Save and Continue
            9)	On Agent for Service form click Save and Continue
            10)	On Certification form add the Name of Director and select certification checkbox, click Save and Continue
            11)	On Review form review all information Select Authorization Box
            12)	Generate PDF
            13)	Click Submit button

     */
    @Parameters({"browser"})
    @Test // (invocationCount = 3)
    public void REG_CIA006_NoticeOfChangeForEPForeignCorpWithShare(String browser) throws IOException, InterruptedException, AWTException {
        Reporter.log("-------: REG_CIA006_NoticeOfChangeForEPForeignCorpWithShare -> ");
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

//        soIncorporateOntarioBusinessCorporationPage.writeOCNToCSV("REG_CIA006_NoticeOfChangeForEPForeignCorpWithShare");
        partnerPortalLandingPage.selectSearchRegistry();
        soIncorporateOntarioBusinessCorporationPage.searchCorporationAndSelectResult();
        soIncorporateOntarioBusinessCorporationPage.writeOCNToCSVFromGeneralDetails("REG_CIA006_NoticeOfChangeForEPForeignCorpWithShare");

        partnerPortalLandingPage.selectFileInitialReturn();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.selectGeneralDetails();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();
        soIncorporateOntarioBusinessCorporationPage.completeCertificationInitialReturnAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completegeneratePDFReviewAndAuthorizeAndSubmitCorporation();

//
        partnerPortalLandingPage.fileNoticeOfChangeFromMenu();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationFileArticlesOfContinuanceSave();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
        partnerSoleProprietorshipRegistrationPage.updateEmail();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();
        Thread.sleep(2000);
        soIncorporateOntarioBusinessCorporationPage.completeCertificationInitialReturnAndSubmitExtraProvincial();
        partnerPortalLandingPage.selectFilingsSubMenuOption();

        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.noticeOChangeIsCreated());

    }
}
