package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.EmailUtils;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Listeners(ListenersTestNG.class)
public class TC17_BNM012_CancelABusinessNameRegistrationForACorporation extends PartnerPortalSetUp {

    /*
//    17. Cancel Business Name Registration for Corporation: "BNM012 - Cancel a Business Name Registration for a Corporation"
     */
    @Parameters({"browser"})
    @Test
    public void TC17_BNM012_CancelABusinessNameRegistrationForACorporation(String browser) throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectOntarioBusinessCorporationRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeCorporationNameAndSave(browser));
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.CompletedOCNwriteToCSV("TC17_BNM012_CancelABusinessNameRegistrationForACorporation");
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.ontarioBusinessCorporationIsRegistered();

        portalLandingPage.selectSearchResult();
        portalLandingPage.selectRegisterBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.updateBusinessName(browser));
        partnerSoleProprietorshipRegistrationPage.selectPrimaryActivity();
        partnerSoleProprietorshipRegistrationPage.selectSaveAndContinue();
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();

        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.ontarioBusinessCorporationIsRegistered();
        portalLandingPage.selectSearchResult();
        portalLandingPage.selectCancelBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.cancelAuthorizationAndSubmit();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.businessNameRegistrationIsCancelled());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());   // As per "Huang, Isabelle (MGCS)"- There is a restriction in test Envs- Dev, Stage & UAT, only the emails with ontario.ca domain wil send out. No email in GMail; therefor, email validation is taken off.
        EmailUtils.emailTransactionNumberIsDisplayed(Config.EMAIL, Config.EMAIL_PASSWORD, "Transaction Number:", "Dear Client");
    }
}