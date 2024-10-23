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
public class TC14_BNR004_RegisterABusinessNameForALimitedPartnership extends PartnerPortalSetUp {

//    /*
//    14. Register Business Name for Limited Partnership: "BNR004 - Register a Business Name for a Limited Partnership"
//     */
    @Test
    public void TC14_BNR004_RegisterABusinessNameForALimitedPartnership() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectEPLLPRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completePowerOfAttorneyAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.CompletedOCNwriteToCSV("TC14_BNR004_RegisterABusinessNameForALimitedPartnership");
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedPartnershipIsRegistered());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
        EmailUtils.emailTransactionNumberIsDisplayed(Config.EMAIL, Config.EMAIL_PASSWORD, "Transaction Number:", "Dear Client");
    }
}