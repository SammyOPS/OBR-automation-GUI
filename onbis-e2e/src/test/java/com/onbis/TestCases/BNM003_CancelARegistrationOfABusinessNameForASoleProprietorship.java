package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class BNM003_CancelARegistrationOfABusinessNameForASoleProprietorship extends PartnerPortalSetUp {

    /*
     Register and Amend a Sole Proprietorship: "BNM003 – Cancel a Registration of a Business Name for a Sole Proprietorship"
        1	Select the ‘Cancel a Registration of a Business Name for a Sole Proprietorship’ from the menu
        2	Accept Terms and Conditions
        3	Ensure contact info pre-populated correctly
        4	Click on "Next Step" button
        5	Select checkbox for "Cancellation confirmation"
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
    @Test
    public void BNM003_CancelARegistrationOfABusinessNameForASoleProprietorship() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectSoleProprietorshipOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeOwnerAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("BNM003_CancelARegistrationOfABusinessNameForASoleProprietorship");
        portalLandingPage.selectSearchRegistry();

        partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectCancelBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
//        partnerSoleProprietorshipRegistrationPage.updateEmail();
        partnerSoleProprietorshipRegistrationPage.CancellationConfirmationSubmit();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsUpdated());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
}