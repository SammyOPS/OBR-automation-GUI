package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class BNM010_AmendABusinessNameRegistrationForACorporation extends PartnerPortalSetUp {

    /*
     Test that user (Public Portal) is able to amend a Business Name for a Corporation:
     "BNM010_AmendABusinessNameRegistrationForACorporation"
        1	Select the ‘Amend a Business Name Registration for a Corporation’ from the menu
        2	Accept Terms and Conditions
        3	Ensure contact info pre-populated correctly
        4	Click on "Next Step" button
        5	Click on the link "Change principal place of Business"
        6	Select "Yes" for "Does the business have a Principal Place of Business in Ontario? "
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
    @Parameters({"browser"})
    @Test
    public void BNM010_AmendABusinessNameRegistrationForACorporation(String browser) throws IOException, InterruptedException, AWTException {
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
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("BNM010_AmendABusinessNameRegistrationForACorporation");
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.ontarioBusinessCorporationIsRegistered();

        portalLandingPage.selectSearchResult();
        portalLandingPage.selectRegisterBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.updateBusinessName(browser));
        partnerSoleProprietorshipRegistrationPage.selectPrimaryActivity();
        partnerSoleProprietorshipRegistrationPage.selectSaveAndContinue();
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
            partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();

        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.ontarioBusinessCorporationIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectAmendOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeConsent();
        partnerSoleProprietorshipRegistrationPage.selectDirectorsOrOfficers();
        partnerSoleProprietorshipRegistrationPage.updatePrincipalPlaceOfBusiness();
//        partnerSoleProprietorshipRegistrationPage.selectPartners();
//        partnerSoleProprietorshipRegistrationPage.changePrincipalPlaceOfBusinessAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSave();
        partnerSoleProprietorshipRegistrationPage.selectAmendBusinessSubmitButton();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.amendmentBusinessNameRegistrationCorporationIsUpdated());

//        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
//        portalLandingPage.selectSoleProprietorshipOption();
//        partnerTermsAndConditionsPage.acceptTermsAndConditions();
//        contactInformationPage.completeContactInformationAndSave();
//        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
//        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeOwnerAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
//        portalLandingPage.selectSearchRegistry();
//
//        partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsRegistered();
//        portalLandingPage.selectSearchResult();
//
//        portalLandingPage.selectCancelBusinessName();
//        partnerTermsAndConditionsPage.acceptTermsAndConditions();
//        contactInformationPage.completeContactInformationAndSave();
////        partnerSoleProprietorshipRegistrationPage.updateEmail();
//        partnerSoleProprietorshipRegistrationPage.CancellationConfirmationSubmit();
//
//        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsUpdated());
////        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
}