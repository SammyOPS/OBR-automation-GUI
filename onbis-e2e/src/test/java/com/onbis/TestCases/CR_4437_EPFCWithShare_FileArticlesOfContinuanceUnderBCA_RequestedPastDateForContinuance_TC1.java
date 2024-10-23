package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.FileArticlesOfAmalgamationPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4437_EPFCWithShare_FileArticlesOfContinuanceUnderBCA_RequestedPastDateForContinuance_TC1 extends SOAdminSetup {

    /*
    TC1
    	BCA amagamation	"Ability to process a backdated BCA amalgamation request received through Document Receipting.  There should be an added field called Receipt Date which could be in the past
            "	Admin	Entities should exist in OBR	Enter valid data for various fields (Make up the data if required)	"-Document receipt the request for Articles of Amalgamation (Form 5262)
            - Ensure that ""Receipt Date"" field is displayed but is NOT mandatory
            - Find the amalgamation request in the dashboard and select to complete the transaction selecting ""Assign to me"" if required and ""Do it Now"" link
            -Ensure that a past date can be entered in the amalgamation date field
            -Take a screenshot of the page where past date is accepted as amalgamation date with a green checkbox against the progress bar in right hand side of the screen
            - Complete the transaction by entering all oher mandatory data
            - Review, submit, pay and finalize the transaction"		Amalgamation request can be completed

     */
    @Parameters({"browser"})
    @Test
    public void CR_4437_EPFCWithShare_FileArticlesOfContinuanceUnderBCA_RequestedPastDateForContinuance_TC1(String browser) throws IOException, InterruptedException, AWTException {
// Note: "nuansAddReportNumber" script must be executed prior to this script to get "Nuans Number" if it's being executed in IE browser.
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        Reporter.log("-------: CR_4437_EPFCWithShare_FileArticlesOfContinuanceUnderBCA_RequestedPastDateForContinuance_TC1 -> ");
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
//        soIncorporateOntarioBusinessCorporationPage.reviewAndApproveFromWorkQueue();
        partnerPortalLandingPage.searchByEntity(soIncorporateOntarioBusinessCorporationPage.reviewAndApproveFromWorkQueue());
  //      String businessName = "HBL6USFPX3 test inc.";
//        partnerPortalLandingPage.selectSearchRegistry();
//        soIncorporateOntarioBusinessCorporationPage.searchCorporationByName(businessName);
//        soIncorporateOntarioBusinessCorporationPage.searchCorporationAndSelectResult();
        partnerSoleProprietorshipRegistrationPage.selectFileArticlesOfContinuanceUnderBCAFromMakeChangesMenu();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterExtraProvincialLimitedLiabilityCompanyAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegistrarSave(); // Receipt Date
        soIncorporateOntarioBusinessCorporationPage.completeInformatioOnFileSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameSave(); // Requested Date
        soIncorporateOntarioBusinessCorporationPage.saveOnlyAddress();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsOnlyAndSave();
        soIncorporateOntarioBusinessCorporationPage.sharesProvisionsSave();
        soIncorporateOntarioBusinessCorporationPage.saveRequiredStatements(); // Authorization Date
        soIncorporateOntarioBusinessCorporationPage.reviewAndAuthorization();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();

//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterExtraProvincialLimitedLiabilityCompanyAndSave();
////        partnerPortalLandingPage.selectSearchRegistry();
////        soIncorporateOntarioBusinessCorporationPage.searchCorporationAndSelectResult();
//
//
//        partnerPortalLandingPage.selectFileInitialReturn();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
//        soIncorporateOntarioBusinessCorporationPage.selectCertification();
//        soIncorporateOntarioBusinessCorporationPage.completeCertificationInitialReturnAndSubmit();
//        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitCorporation();
//
//        partnerPortalLandingPage.selectFileAnnualReturn();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
//        soIncorporateOntarioBusinessCorporationPage.selectAnnualReturnYear();
//        soIncorporateOntarioBusinessCorporationPage.selectCertification();
//        soIncorporateOntarioBusinessCorporationPage.completeCertificationInitialReturnAndSubmit();
//        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitCorporation();
        partnerPortalLandingPage.selectFilingsSubMenuOption();

        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.verificationPFCWithShare_FileArticlesOfContinuance());
    }
}
