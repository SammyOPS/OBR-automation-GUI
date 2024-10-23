package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class TC06_07_08_CIA004_CIA005_InitialReturnForForeignCor_AnnualReturnForeignCorpWithShare extends SOAdminSetup {

    /*
    7	File an Initial Return for an Extra-Provincial Corporation: "CIA004-Initial Return for Foreign Corp with Share"
    8	File an Annual Return for an Extra-Provincial Corporation: "CIA005-Annual Return Foreign Corp with Share"
     */
    @Parameters({"browser"})
    @Test
    public void TC06_07_08_CIA004_CIA005_InitialReturnForForeignCor_AnnualReturnForeignCorpWithShare(String browser) throws IOException, InterruptedException, AWTException {
// Note: "nuansAddReportNumber" script must be executed prior to this script to get "Nuans Number" if it's being executed in IE browser.
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
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
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("TC06_07_08_CIA004_CIA005_InitialReturnForForeignCor_AnnualReturnForeignCorpWithShare");
        partnerPortalLandingPage.selectSearchRegistry();
        soIncorporateOntarioBusinessCorporationPage.searchCorporationAndSelectResult();
        partnerPortalLandingPage.selectFileInitialReturn();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.generalDetailActivityInOntarioDate();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();
        soIncorporateOntarioBusinessCorporationPage.completeCertificationInitialReturnAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitCorporation();

        partnerPortalLandingPage.selectFileAnnualReturn();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.selectAnnualReturnYear();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();
        soIncorporateOntarioBusinessCorporationPage.completeCertificationInitialReturnAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitCorporation();
        partnerPortalLandingPage.selectFilingsSubMenuOption();

        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.initialAndAnnualReturnIsCreated());
    }
}
