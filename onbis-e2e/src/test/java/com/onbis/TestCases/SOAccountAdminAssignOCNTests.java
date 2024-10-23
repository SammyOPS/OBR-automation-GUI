package com.onbis.TestCases;

import com.onbis.Helper.EmailUtils;
import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class SOAccountAdminAssignOCNTests extends SOAdminSetup {

    /*
    3. Assign an OCN: "OCR001-Assign an OCN"
     */
    @Test
    public void whenUserCompletesOntarioCorporationNumber_OCNIsCompletedAndAssigned() throws InterruptedException {
        pkiProfileSingnInPage.loginUsingEPFCredentials();
        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        soAdminOntarioBusinessRegistryDashboardPage.selectServiceAsAssignOCN();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveOCN();
        soIncorporateOntarioBusinessCorporationPage.completeAssignAnOntarioCorporationNumber();
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.OCNIsCompleted());
    }

    /*
    9. Initial Return for ON Corp: "CIA001-Initial Return for ON Corp"
    10. Notice of Change for ON Corp: "CIA003-Notice of Change for an Ontario Corporation"
     */
    @Test
    public void whenUserCompletesInitialReturnForOntarioCorporation_UserSeesInitialReturnAndNoticeOfChangeSuccessfully() throws InterruptedException {
        pkiProfileSingnInPage.loginUsingEPFCredentials();
        mgcsAdminLandingPage.selectRegistryAsAssignOCN();

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
        soIncorporateOntarioBusinessCorporationPage.completeCertificationNoticeOfChangeAndSubmit();
        partnerPortalLandingPage.selectFilingsSubMenuOption();

        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.initialAndNoticeOChangeReturnIsCreated());
    }

    /*
    7	File an Initial Return for an Extra-Provincial Corporation: "CIA004-Initial Return for Foreign Corp with Share"
    8	File an Annual Return for an Extra-Provincial Corporation: "CIA005-Annual Return Foreign Corp with Share"
     */
    @Parameters({"browser"})
    @Test
    public void whenUserCompletesExtraProvincialLicenceForForeignCorp_UserSeesCorporationCreated(String browser) throws IOException, InterruptedException, AWTException {
// Note: "nuansAddReportNumber" script must be executed prior to this script to get "Nuans Number" if it's being executed in IE browser.
        pkiProfileSingnInPage.loginUsingEPFCredentials();
        mgcsAdminLandingPage.selectRegistryAsAssignOCN();

        soAdminOntarioBusinessRegistryDashboardPage.selectRegistryAsApplicationForExtraProvincialLicenceForForeignCorp();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveOCN();
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
        partnerPortalLandingPage.selectFileInitialReturn();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
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
