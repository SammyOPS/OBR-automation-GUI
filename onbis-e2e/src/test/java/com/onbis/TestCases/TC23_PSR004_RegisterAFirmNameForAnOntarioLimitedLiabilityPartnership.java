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
public class TC23_PSR004_RegisterAFirmNameForAnOntarioLimitedLiabilityPartnership extends PartnerPortalSetUp {

//    /*
//    23. Register a Firm Name for an Ontario Limited Liability Partnership: "PSR004 - Register a Firm Name for an Ontario Limited Liability Partnership"
//     */
    @Test
    public void TC23_PSR004_RegisterAFirmNameForAnOntarioLimitedLiabilityPartnership() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectRegisterFirmNameForOntarioLimitedLiabilityService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();

        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSaveLLP());
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.selectPartnersMultiple();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.CompletedOCNwriteToCSV("TC23_PSR004_RegisterAFirmNameForAnOntarioLimitedLiabilityPartnership");
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.ontarioLimitedLiabilityPartnershipIsRegistered());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
        EmailUtils.emailTransactionNumberIsDisplayed(Config.EMAIL, Config.EMAIL_PASSWORD, "Transaction Number:", "Dear Client");
    }
}