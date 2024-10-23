package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class TC09_10_CIA001_CIA003_InitialReturnForONCorp_NoticeOfChangeForAnOntarioCorporation extends SOAdminSetup {

    /*
    9. Initial Return for ON Corp: "CIA001-Initial Return for ON Corp"
    10. Notice of Change for ON Corp: "CIA003-Notice of Change for an Ontario Corporation"
     */
    @Test
    public void TC09_10_CIA001_CIA003_InitialReturnForONCorp_NoticeOfChangeForAnOntarioCorporation() throws InterruptedException {
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectRegistryAsIncorporateOntarioBusinessCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveIncorporate();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAsNumberAndSaveIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        partnerPortalLandingPage.setOntarioCorporation(partnerPortalLandingPage.selectCompletedMenuOptionAndGetCorporationName());
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("TC09_10_CIA001_CIA003_InitialReturnForONCorp_NoticeOfChangeForAnOntarioCorporation");
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResult();

        partnerPortalLandingPage.selectFileInitialReturn();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturn();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();

        soIncorporateOntarioBusinessCorporationPage.completeCertification();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitCorporation();

        partnerPortalLandingPage.selectFileNoticeOfChange();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturn();
        partnerSoleProprietorshipRegistrationPage.updateEmail();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();
        Thread.sleep(2000);
        soIncorporateOntarioBusinessCorporationPage.completeCertificationNoticeOfChangeAndSubmit();
        partnerPortalLandingPage.selectFilingsSubMenuOption();

        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.initialAndNoticeOChangeReturnIsCreated());
    }
}
