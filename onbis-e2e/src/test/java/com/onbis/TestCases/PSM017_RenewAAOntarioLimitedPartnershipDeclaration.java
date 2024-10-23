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
public class PSM017_RenewAAOntarioLimitedPartnershipDeclaration extends PartnerPortalSetUp {

/*
    1	Select the "Renew an Extra-Provincial Limited Partnership Declaration" from the menu
    2	Accept Terms and Conditions
    3	Ensure contact info pre-populated correctly
    4	Click on "Next Step" button
    5	Select checkbox for "Renewal confirmation"
    6	Click on "Generate PDF" button
    7	Select checkbox for "Authorization"
    8	Click on "Submit" button

 */

    @Test
    public void PSM017_RenewAAOntarioLimitedPartnershipDeclaration() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        File resourcesDirectory = new File("src/main/resources");
        String PSM017ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/PSM017ReturnABusinessNumber.txt");
        System.out.println(PSM017ReturnABusinessNumber);

        portalLandingPage.selectSearchRegistry();
        PartnerSoleProprietorshipRegistrationPage soleProprietorshipSearchForABusinessName = new PartnerSoleProprietorshipRegistrationPage(driver).searchForABusinessName(PSM017ReturnABusinessNumber);
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
        partnerSoleProprietorshipRegistrationPage.selectSubmitButton();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.renewalofAnOntarioLimitedPartnershipDeclarationIsUpdated());
        HelperMethods.deleteFile(resourcesDirectory +"/PSM017ReturnABusinessNumber.txt");
        HelperMethods.writeToCSV("PSM017_RenewAAOntarioLimitedPartnershipDeclaration", PSM017ReturnABusinessNumber);
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
}
