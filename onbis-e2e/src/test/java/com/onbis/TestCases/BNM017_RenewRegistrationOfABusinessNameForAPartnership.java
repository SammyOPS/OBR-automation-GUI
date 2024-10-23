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
public class BNM017_RenewRegistrationOfABusinessNameForAPartnership extends PartnerPortalSetUp {

/*
        1	Select the ‘Renew a Registration of a Business Name for a General Partnership’ from the menu
        2	Accept Terms and Conditions
        3	Ensure contact info pre-populated correctly
        4	Click on "Next Step" button
        5	Select checkbox for "Renewal Confirmation"
        6	Select "Person Acting under Power of Attorney" for "Person authorizing renewal"
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
    public void BNM017_RenewRegistrationOfABusinessNameForAPartnership() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        File resourcesDirectory = new File("src/main/resources");
        String BNM017ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/BNM017ReturnABusinessNumber.txt");
        System.out.println(BNM017ReturnABusinessNumber);

        portalLandingPage.selectSearchRegistry();
        PartnerSoleProprietorshipRegistrationPage soleProprietorshipSearchForABusinessName = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(BNM017ReturnABusinessNumber);
        portalLandingPage.selectSearchResult();
        portalLandingPage.selectRenewBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.selectCancelConfirmationCheckBox();
        partnerSoleProprietorshipRegistrationPage.selectFromPartners();
        Thread.sleep(2000);
        partnerSoleProprietorshipRegistrationPage.completeConsent();
        Thread.sleep(2000);
//        partnerSoleProprietorshipRegistrationPage.messageCancellationConfirmationMustBeAccepted();
        partnerSoleProprietorshipRegistrationPage.selectSubmitButton();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.RenewRegistrationOfABusinessNameForAPartnershipIsUpdated());

 //       Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.generalPartnershipNameIsCancelled());

        HelperMethods.deleteFile(resourcesDirectory +"/BNM017ReturnABusinessNumber.txt");
        HelperMethods.writeToCSV("BNM017_RenewRegistrationOfABusinessNameForAPartnership", BNM017ReturnABusinessNumber);
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
}
