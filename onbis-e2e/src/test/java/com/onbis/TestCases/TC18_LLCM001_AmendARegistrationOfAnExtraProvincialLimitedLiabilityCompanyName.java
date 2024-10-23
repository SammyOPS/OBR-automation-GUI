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
public class TC18_LLCM001_AmendARegistrationOfAnExtraProvincialLimitedLiabilityCompanyName extends PartnerPortalSetUp {

//    /*
//    18. Amend an Extra-Provincial Limited Liability Company Name: "LLCM001 - Amend a Registration of an Extra-Provincial Limited Liability Company Name"
//     */
    @Parameters({"browser"})
    @Test
    public void TC18_LLCM001_AmendARegistrationOfAnExtraProvincialLimitedLiabilityCompanyName(String browser) throws IOException, InterruptedException, MessagingException, GeneralSecurityException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectEPLLService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSaveExtraProvincial();

        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.CompletedOCNwriteToCSV("TC18_LLCM001_AmendARegistrationOfAnExtraProvincialLimitedLiabilityCompanyName");
        portalLandingPage.selectSearchRegistry();

        partnerSoleProprietorshipRegistrationPage.extraProvincialIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectAmendOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSavePopUp();
        partnerSoleProprietorshipRegistrationPage.changePrincipalPlaceOfBusinessAndSave();
        partnerSoleProprietorshipRegistrationPage.completeConsent();
        partnerSoleProprietorshipRegistrationPage.contactName();
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSubmit();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedLiabilityIsUpdated());
    //    Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        EmailUtils.emailTransactionNumberIsDisplayed(Config.EMAIL, Config.EMAIL_PASSWORD, "Transaction Number:", "Dear Client");
    }
}