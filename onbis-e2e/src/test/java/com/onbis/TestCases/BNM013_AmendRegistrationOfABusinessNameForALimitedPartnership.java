package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class BNM013_AmendRegistrationOfABusinessNameForALimitedPartnership extends PartnerPortalSetUp {

    /*
    BNM013_AmendRegistrationOfABusinessNameForALimitedPartnership: "BNM013 – Amend a Registration of a Business Name for a Limited Partnership"
            1	Select the ‘Amend a Registration of a Business Name for a Limited Partnership’ from the menu
            2	Accept Terms and Conditions
            3	Ensure contact info pre-populated correctly
            4	Click on "Next Step" button
            5	Click on the link "Change principal place of Business"
            6	Select "Yes" for "Does the partnership have a Principal Place of Business in Ontario? "
            7	Select "Use a different address" for "New Principal Place of Business"
            8	Enter a valid postal code and click on "Find address" button
            9	Select "Person Acting under Power of Attorney" for "Person authorizing amendment"
            10	Select "Other" for "Type"
            11	Enter "Full Legal Name"
            12	Enter "First Name"
            13	Enter "Middle Name"
            14	Enter "Last Name"
            15	Enter "Position"
            16	Select "Generate PDF" button
            17	Select checkbox for "Authorization"
            18	Click on "Submit" button

     */
    @Test
    public void BNM013_AmendRegistrationOfABusinessNameForALimitedPartnership() throws IOException, InterruptedException {
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
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("BNM013_AmendRegistrationOfABusinessNameForALimitedPartnership");
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.ontarioLimitedLiabilityPartnershipIsRegistered());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        portalLandingPage.selectSearchResult();

//        portalLandingPage.selectRegisterBusinessName();
        portalLandingPage.selectAmendOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();

        // ++++++++++++++++
        partnerSoleProprietorshipRegistrationPage.amendChangePartners();
        Thread.sleep(2000);
        partnerSoleProprietorshipRegistrationPage.amendAuthorizationAndSubmit();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.AmendRegistrationOfABusinessNameForALimitedPartnership());

    }
}