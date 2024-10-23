package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class PSM018_RenewARegistration_OfAFirmNameForAGeneralPartnership extends PartnerPortalSetUp {

/*
        1	Select the "Renew a Registration of a Firm Name for a General Partnership" from the menu
        2	Accept Terms and Conditions
        3	Ensure contact info pre-populated correctly
        4	Click on "Next Step" button
        5	Select checkbox for "Renewal confirmation"
        6	Select an Individual from the Partner dropdown list
        7	Click on "Generate PDF" button
        8	Select checkbox for "Authorization"
        9	Click on "Submit" button


 */

    @Test
    public void PSM018_RenewARegistration_OfAFirmNameForAGeneralPartnership() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        File resourcesDirectory = new File("src/main/resources");
        String PSM018ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/PSM018ReturnABusinessNumber.txt");
        System.out.println(PSM018ReturnABusinessNumber);

        portalLandingPage.selectSearchRegistry();
        PartnerSoleProprietorshipRegistrationPage soleProprietorshipSearchForABusinessName = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(PSM018ReturnABusinessNumber);
        portalLandingPage.selectSearchResult();
        portalLandingPage.selectRenewBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.selectCancelConfirmationCheckBox();
        //   partnerSoleProprietorshipRegistrationPage.selectFromPartners();
        Thread.sleep(2000);
        partnerSoleProprietorshipRegistrationPage.completeConsent();
        Thread.sleep(2000);
//        partnerSoleProprietorshipRegistrationPage.messageCancellationConfirmationMustBeAccepted();
        partnerSoleProprietorshipRegistrationPage.selectFromPartners();
        partnerSoleProprietorshipRegistrationPage.selectSubmitButton();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.renewalofRenewARegistration_OfAFirmNameForAGeneralPartnershipIsUpdated());
        HelperMethods.deleteFile(resourcesDirectory +"/PSM018ReturnABusinessNumber.txt");
        HelperMethods.writeToCSV("PSM018_RenewARegistration_OfAFirmNameForAGeneralPartnership", PSM018ReturnABusinessNumber);
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
}
