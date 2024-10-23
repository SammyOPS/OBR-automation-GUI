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
public class TC25_PSM009_CancelARegistrationOfAFirmNameForAGeneralPartnership extends PartnerPortalSetUp {

//    /*
//    25. Cancel a Registration of a Firm Name for a General Partnership: "PSM009 - Cancel a Registration of a Firm Name for a General Partnership"
//     */
    @Parameters({"browser"})
    @Test
    public void TC25_PSM009_CancelARegistrationOfAFirmNameForAGeneralPartnership(String browser) throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectGeneralPartnerShipRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.CompletedOCNwriteToCSV("TC25_PSM009_CancelARegistrationOfAFirmNameForAGeneralPartnership");
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectRegisterBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.updateCorporationNameAndSave(browser));
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();

        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectCancelBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.selectCancelConfirmationCheckBox();
        partnerSoleProprietorshipRegistrationPage.selectPartnersMultiple();
        Thread.sleep(2000);
        partnerSoleProprietorshipRegistrationPage.completeConsent();
//        partnerSoleProprietorshipRegistrationPage.messageCancellationConfirmationMustBeAccepted();
        partnerSoleProprietorshipRegistrationPage.selectCancelBusinessSubmitButton();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.generalPartnershipNameIsCancelled());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        EmailUtils.emailTransactionNumberIsDisplayed(Config.EMAIL, Config.EMAIL_PASSWORD, "Transaction Number:", "Dear Client");
    }
}