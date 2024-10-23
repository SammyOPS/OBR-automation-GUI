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
public class TC19_BNM001_AmendARegistrationOfABusinessNameForASoleProprietorship extends PartnerPortalSetUp {

    /*
    19. Register and Amend a Sole Proprietorship: "BNM001 – Amend a Registration of a Business Name for a Sole Proprietorship"
     */
    @Test
    public void TC19_BNM001_AmendARegistrationOfABusinessNameForASoleProprietorship() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectSoleProprietorshipOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        Thread.sleep(2000);
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeOwnerAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.CompletedOCNwriteToCSV("TC19_BNM001_AmendARegistrationOfABusinessNameForASoleProprietorship");
        portalLandingPage.selectSearchRegistry();

        partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectAmendOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.updateEmail();
        partnerSoleProprietorshipRegistrationPage.selectAuthorizationAndSubmit();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsUpdated());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        EmailUtils.emailTransactionNumberIsDisplayed(Config.EMAIL, Config.EMAIL_PASSWORD, "Transaction Number:", "Dear Client");
    }
}