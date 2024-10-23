package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import com.onbis.Pages.SOIncorporateOntarioBusinessCorporationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4260_4279_4277_4574_4592_4628_GeneralPartnershipInternationalAddress_TC3_TC4_TC5 extends PartnerPortalSetUp {

    /* Principle Place of Business - international address

    3	Business name registration	Register business name for the above GP	Partner			"- Services > Search the Registry > Register a business name for the above GP. Use international address if allowed by the system
                - Submit, pay the fees and finalize the transaction
                - Request profile report. Submit, pay the fees and finalize the transaction.
                - Request list of document copies. Submit, pay the fees and finalize the transaction.
                - Review all outputscorrespondence, profile report etc. received in your work email"

    4	Check Registrat and  Business Name link	"Review entity records to ensure business name link is displayed.
                Review business name records to ensure Registrat link is displayed"	Partner	Enitity exists	"Entity registered above

                Business name registered above"	"- Navigation: Services > Search the Registry
                -Select the above corporation
                -Check business name page to ensure business name is displayed
                Take screenshots highlighting business name and save it in the word template

                '- Navigation: Services > Search the Registry
                -Select the above business name
                -Check Registrat page to ensure RRegistrant name is displayed
                Take screenshots highlighting Registrant name and save it in the word template"

        5	Entity Profile Report	"Request a profile report.  Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
            "	Partner	Entity exists	Sole Prop	"- Navigation: Services > Search the Registry
            -Select the above sole prop
            -Click on Request Search Products > Profile Report > Current
            - Enter your work email address in the email address field to get all emails and outputs to your work email
            - Submit, pay the fees, Finalize the transaction
            - Review outputs received in your work email"



  */
    @Test
    public void CR_4260_4279_4277_4574_4592_4628_GeneralPartnershipInternationalAddress_TC3_TC4_TC5() throws IOException, InterruptedException, AWTException {
    // TC 3
      //  Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_GeneralPartnershipInternationalAddress_TC3-> ");
        portalLandingPage.selectGeneralPartnerShipRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationGeneralPartnershipAndSave());
        partnerSoleProprietorshipRegistrationPage.completeInternationalBusinessAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeThreePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeGeneralPartnershipPowerOfAttorneyAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();

        // TC 4
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());

        portalLandingPage.selectSearchRegistry();
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_GeneralPartnershipInternationalAddress_TC4 -> ");
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraGeneralPartnershippIsRegistered());

        // TC 5

        partnerSoleProprietorshipRegistrationPage.requestProfileReport();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_GeneralPartnershipInternationalAddress_TC5 -> ");
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.requestProfileReportEmail());

//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

}