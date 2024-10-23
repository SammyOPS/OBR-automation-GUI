package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class BNM002_RenewARegistrationOfABusinessNameForASoleProprietorship extends PartnerPortalSetUp {
//
//    /*
//     Register and Amend a Sole Proprietorship: "BNM003 – Cancel a Registration of a Business Name for a Sole Proprietorship"
//        1	Select the ‘Cancel a Registration of a Business Name for a Sole Proprietorship’ from the menu
//        2	Accept Terms and Conditions
//        3	Ensure contact info pre-populated correctly
//        4	Click on "Next Step" button
//        5	Select checkbox for "Cancellation confirmation"
//        6	Select "Person Acting under Power of Attorney" for "Person authorizing cancellation"
//        7	Select "Other" for "Type"
//        8	Enter "Full Legal Name"
//        9	Enter "First Name"
//        10	Enter "Middle Name"
//        11	Enter "Last Name"
//        12	Enter "Position"
//        13	Select "Generate PDF" button
//        14	Select checkbox for "Authorization"
//        15	Click on "Submit" button
//
//         ********** "BNM002_DataCreationRegistrationOfABusinessNameChangeExpiry" must to executed successfully prior to "BNM002_RenewARegistrationOfABusinessNameForASoleProprietorship"
//     */

@Test
public void BNM002_RenewARegistrationOfABusinessNameForASoleProprietorship() throws IOException, InterruptedException, AWTException {
    partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
    File resourcesDirectory = new File("src/main/resources");
    String BNM002ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/BNM002ReturnABusinessNumber.txt");
    System.out.println(BNM002ReturnABusinessNumber);

    portalLandingPage.selectSearchRegistry();
    PartnerSoleProprietorshipRegistrationPage soleProprietorshipSearchForABusinessName = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(BNM002ReturnABusinessNumber);
    portalLandingPage.selectSearchResult();
    portalLandingPage.selectRenewBusinessName();
    partnerTermsAndConditionsPage.acceptTermsAndConditions();
    contactInformationPage.completeContactInformationAndSave();
    partnerSoleProprietorshipRegistrationPage.renewConfirmationSubmit();
    soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
    Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsUpdated());
    HelperMethods.deleteFile(resourcesDirectory +"/BNM002ReturnABusinessNumber.txt");
    HelperMethods.writeToCSV("BNM002_RenewARegistrationOfABusinessNameForASoleProprietorship", BNM002ReturnABusinessNumber);
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
}
}
