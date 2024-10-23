package com.onbis.TestCases;
import com.onbis.Helper.HelperMethods;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.onbis.Helper.HelperMethods.getCurrentDate;
import static com.onbis.Helper.HelperMethods.getCurrentDateTime;

@Listeners(ListenersTestNG.class)
public class TC_ALL_RenewARegistrationOfABusiness extends PartnerPortalSetUp {
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
public void BNM002_RenewARegistrationOfABusinessNameForASoleProprietorship() throws IOException, InterruptedException {
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
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
}
    /*
         NOTE: There is no option to reset Expiry Date of this functionality; needs to clarify with the Functional testing team
      */
    @Test
    public void BNM011_RenewARegistrationOfABusinessNameForAOntarioLimitedLiabilityPartnership() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        File resourcesDirectory = new File("src/main/resources");
        String BNM011ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/BNM011ReturnABusinessNumber.txt");
        System.out.println(BNM011ReturnABusinessNumber);

        portalLandingPage.selectSearchRegistry();
        PartnerSoleProprietorshipRegistrationPage soleProprietorshipSearchForABusinessName = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(BNM011ReturnABusinessNumber);
        portalLandingPage.selectSearchResult();
        portalLandingPage.selectRenewBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.renewConfirmationSubmitOntarioLimitedLiabilityPartnership();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.RenewRegistrationOfABusinessNameForOntarioLimitedLiabilityPartnershipIsUpdated());
        HelperMethods.deleteFile(resourcesDirectory +"/BNM011ReturnABusinessNumber.txt");
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
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
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }

/*       LLCM002- Renew a Registration of a Limited Liability Company Name
       ********** "LLCM002_RenewARegistrationOfALimitedLiabilityCompanyNameExpiry" must to executed successfully prior to "LLCM002_RenewARegistrationOfALimitedLiabilityCompanyName"
        1	Select the ‘Renew a Business Name Registration for a Corporation’ from the menu
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
    public void LLCM002_RenewARegistrationOfABusinessNameForALimitedLiabilityCompanyName() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        File resourcesDirectory = new File("src/main/resources");
        String LLCM002ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/LLCM002ReturnABusinessNumber.txt");
        System.out.println(LLCM002ReturnABusinessNumber);

        portalLandingPage.selectSearchRegistry();
        PartnerSoleProprietorshipRegistrationPage soleProprietorshipSearchForABusinessName = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(LLCM002ReturnABusinessNumber);
        portalLandingPage.selectSearchResult();
        portalLandingPage.selectRenewBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSavePopUp();

        partnerSoleProprietorshipRegistrationPage.renewalConfirmationExtraProvincial();
//        partnerSoleProprietorshipRegistrationPage.selectCancelConfirmationCheckBox();

        Thread.sleep(2000);
//        partnerSoleProprietorshipRegistrationPage.messageCancellationConfirmationMustBeAccepted();

        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.RenewRegistrationOfABusinessNameForAExtraProvincialIsUpdated());

        //       Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.generalPartnershipNameIsCancelled());

        HelperMethods.deleteFile(resourcesDirectory +"/LLCM002ReturnABusinessNumber.txt");
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
}
