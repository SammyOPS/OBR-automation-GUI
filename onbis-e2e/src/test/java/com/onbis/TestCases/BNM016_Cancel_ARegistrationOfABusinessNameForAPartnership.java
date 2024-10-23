package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class BNM016_Cancel_ARegistrationOfABusinessNameForAPartnership extends PartnerPortalSetUp {

    /*
     "BNM016-Cancel a Registration of a Business Name for a Partnership"

        1	Select the ‘cancel a Registration of a Business Name for a General Partnership’ from the menu
        2	Accept Terms and Conditions
        3	Ensure contact info pre-populated correctly
        4	Click on "Next Step" button
        5	Select checkbox for "Cancellation Confirmation"
        6	Select "Person Acting under Power of Attorney" for "Person authorizing cancellation"
        7	Select "Other" for "Type"
        8	Enter "Full Legal Name"
        9	Enter "First Name"
        10	Enter "Middle Name"
        11	Enter "Last Name"
        12	Enter "Position"
        13	Select "Generate PDF" button
        14	Select checkbox for "Authorization"
        15	Click on "Submit" button

     */
    @Parameters({"browser"})
    @Test
    public void BNM016_Cancel_ARegistrationOfABusinessNameForAPartnership(String browser) throws IOException, InterruptedException {
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
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("BNM016_Cancel_ARegistrationOfABusinessNameForAPartnership");
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
//        partnerSoleProprietorshipRegistrationPage.updateEmail();
        partnerSoleProprietorshipRegistrationPage.CancellationConfirmationPartnersOptionSubmit();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.generalPartnershipNameIsUpdated());
    }
}