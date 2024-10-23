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
public class TC11_BNR002_RegisterABusinessNameForACorporation extends PartnerPortalSetUp {

//    /*
//    11. Register a Business Name for a Corporation: "BNR002 - Register a Business Name for a Corporation"
//     */
    @Parameters({"browser"})
    @Test
    public void TC11_BNR002_RegisterABusinessNameForACorporation(String browser) throws IOException, InterruptedException {
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
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.CompletedOCNwriteToCSV("TC11_BNR002_RegisterABusinessNameForACorporation");
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.ontarioBusinessCorporationIsRegistered());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
        EmailUtils.emailTransactionNumberIsDisplayed(Config.EMAIL, Config.EMAIL_PASSWORD, "Transaction Number:", "Dear Client");
    }
}