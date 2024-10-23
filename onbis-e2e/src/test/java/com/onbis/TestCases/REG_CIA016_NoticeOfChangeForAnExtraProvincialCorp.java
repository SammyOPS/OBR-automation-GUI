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
public class REG_CIA016_NoticeOfChangeForAnExtraProvincialCorp extends SOAdminSetup {

    /*
        precondition Ref:

        CIAOIE-PRE-01	 in to ON31S Users include: Serviceontario Acccunt Portal user (Joe Public)
        Partner Ports' user (Lawyer)
        Admin Portel User (Serviceonterio Registry staff)
        CIA01E-PRE-02	The user has selected the 	corporation that is one of the following entity types
            Extra-Provinciäl Domestic Corpor:tion 	Sure (Y)
        Extra-provincial Domestic Corporetion Non-Share (X)
        Extra-provincial Federal Corporetion with Shere (R)
        Extra-provincial Federal Corporation Nan Shere (S) Extra-provincial For:ign Corporetion Non-Shere (V)
            The user has authority ta meintain the corporstion. Authority is resolved es follol"s
        Serviceontario Account Portel users end Partner Portal users have euthority over the corporation,
        Admin Portal User has the appropriate permission to maintain co rporaticns

    Notice of Change for an Extra-Provincial Corp
        Steps to reproduce:

            1)	Login into ONBIS Admin Portal
            2)	File Application for Extra-Provincial Licence for a Foreign Corporation
            3)	File an Initial Return for an Extra-Provincial Corporation
            4)	Select Make Changes, File Notice of Change
            5)	Enter Contact Information, click Continue
            6)	On General Details page verify info, click Save and Continue
            7)	On Address form Change Principal Place of Business, click Save and Continue
            8)	On Chief Officer or Manager form chose No for Has the corporation appointed a chief officer or manager in Ontario?,
            click Save and Continue
            9)	Navigate through Agent and Service form, Save and Continue
            10)	Add the Name of the Director, select Authorization box, Save and Continue
            11)	<Review and Authorization> form populated with Generate PDF, and Authorization check box
            12)	Review the screen, click on "Generate PDF" button to download a file
            13)	Select the checkbox for "Authorization", Click Submit


     */
    @Parameters({"browser"})
    @Test // (invocationCount = 3)
    public void REG_CIA016_NoticeOfChangeForAnExtraProvincialCorp(String browser) throws IOException, InterruptedException, AWTException {
        Reporter.log("-------: REG_CIA016_NoticeOfChangeForAnExtraProvincialCorp -> ");
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
        soIncorporateOntarioBusinessCorporationPage.writeOCNToCSVFromGeneralDetails("REG_CIA016_NoticeOfChangeForAnExtraProvincialCorp");
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
//
//        partnerPortalLandingPage.selectFilingsSubMenuOption();
//
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.initialReturnIsCreated());
    }
}
