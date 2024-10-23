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
public class TC20_PSM001_FileADeclarationOfChangeOfAnOntarioLimitedPartnership extends PartnerPortalSetUp {

   /*
//    20. File a Declaration of an Ontario Limited Partnership: "PSM001 - File a Declaration of Change of an Ontario Limited Partnership"
     */
    @Test
    public void TC20_PSM001_FileADeclarationOfChangeOfAnOntarioLimitedPartnership() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectFileDecelerationOfOntarioLimitedPartnershipService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();

        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressFileADeceleration();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.CompletedOCNwriteToCSV("TC20_PSM001_FileADeclarationOfChangeOfAnOntarioLimitedPartnership");
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.ontarioLimitedPartnershipIsRegistered());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        EmailUtils.emailTransactionNumberIsDisplayed(Config.EMAIL, Config.EMAIL_PASSWORD, "Transaction Number:", "Dear Client");
    }
}