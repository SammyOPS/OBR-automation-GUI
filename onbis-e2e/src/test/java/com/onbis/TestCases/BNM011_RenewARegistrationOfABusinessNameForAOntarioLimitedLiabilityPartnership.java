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
public class BNM011_RenewARegistrationOfABusinessNameForAOntarioLimitedLiabilityPartnership extends PartnerPortalSetUp {

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
        HelperMethods.writeToCSV("BNM011_RenewARegistrationOfABusinessNameForAOntarioLimitedLiabilityPartnership", BNM011ReturnABusinessNumber);
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }
}
