package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class PSM007_AmendARegistrationOfAFirmNameForAGeneralPartnership extends PartnerPortalSetUp {

    /*
        1	Select the "Cancel an Ontario Limited Partnership Declaration" from the menu
        2	Accept Terms and Conditions
        3	Ensure contact info pre-populated correctly
        4	Click on "Next Step" button
        5	Select checkbox for "Cancel confirmation"
        6	Click on "Generate PDF" button
        7	Select checkbox for "Authorization"
        8	Click on "Submit" button
    */
    @Parameters({"browser"})
    @Test
    public void PSM007_AmendARegistrationOfAFirmNameForAGeneralPartnership(String browser) throws IOException, InterruptedException {
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
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("PSM007_AmendARegistrationOfAFirmNameForAGeneralPartnership");
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
//        partnerPortalLandingPage.GeneralDetailsOCNwriteToCSV("PSM007_AmendARegistrationOfAFirmNameForAGeneralPartnership");
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered();
        portalLandingPage.selectSearchResult();
// ++++++++
        portalLandingPage.selectAmendOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.changePrincipalPlaceOfBusinessAndSave();
        partnerSoleProprietorshipRegistrationPage.selectPartners();
        partnerSoleProprietorshipRegistrationPage.completeConsent();
        partnerSoleProprietorshipRegistrationPage.selectSubmitButton();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.AmendARegistrationOfAFirmNameForAGeneralPartnership());
  }
}