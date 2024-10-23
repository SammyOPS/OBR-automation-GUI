package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class PSM005_CancelAnOntarioLimitedPartnershipDeclaration extends PartnerPortalSetUp {

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
    public void PSM005_CancelAnOntarioLimitedPartnershipDeclaration(String browser) throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectFileDecelerationOfOntarioLimitedPartnershipService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeOnlyAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("PSM005_CancelAnOntarioLimitedPartnershipDeclaration");
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
//        partnerPortalLandingPage.GeneralDetailsOCNwriteToCSV("PSM005_CancelAnOntarioLimitedPartnershipDeclaration");
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectCancelBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.selectCancelConfirmationCheckBox();
        partnerSoleProprietorshipRegistrationPage.setSelectFromPartnersOption(); // selectFromPartners
        Thread.sleep(2000);
        partnerSoleProprietorshipRegistrationPage.completeConsent();
        partnerSoleProprietorshipRegistrationPage.selectCancelBusinessSubmitButton();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.generalPartnershipNameIsCancelled());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
}