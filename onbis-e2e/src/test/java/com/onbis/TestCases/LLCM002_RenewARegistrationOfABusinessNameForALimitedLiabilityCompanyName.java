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
public class LLCM002_RenewARegistrationOfABusinessNameForALimitedLiabilityCompanyName extends PartnerPortalSetUp {

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
            HelperMethods.writeToCSV("LLCM002_RenewARegistrationOfABusinessNameForALimitedLiabilityCompanyName", LLCM002ReturnABusinessNumber);
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
}
