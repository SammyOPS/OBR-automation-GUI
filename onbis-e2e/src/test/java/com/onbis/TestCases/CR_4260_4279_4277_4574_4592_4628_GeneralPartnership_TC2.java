package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerPortalLandingPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4260_4279_4277_4574_4592_4628_GeneralPartnership_TC2 extends PartnerPortalSetUp {

/*
    2	General partnership Registration	"Register a GP  business. Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
                "	Partner	Entity does not exists	Enter valid data for various fields like entity name, address, sole prop name . Enter at least one international address,  (Make up the data)	"Services > Register Services > Partnership > Register a Firm Name for GP- Select ""Person with paper form""
                - Enter the contact name person
                - Enter your work email address in the email address field to get all emails and outputs to your work email
                - Enter all other mandatory information. Enter at least one international address if allowed
                - Please check the objectives of OBR system page enrty related to leading zero in addresses like RHO address, Individual addresses (directors, incorporators etc.), international address, Region field requirements, and all individual's (director, incorporator etc.)  names in upper case requirements mentioned in cell G1 are met
                    Take screenshots highlighting Address1, Region field in international address, individuals names and save it in the word template"


  */
    @Test
    public void CR_4260_4279_4277_4574_4592_4628_GeneralPartnership_TC2() throws IOException, InterruptedException, AWTException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_GeneralPartnership_TC2-> ");

        portalLandingPage.selectGeneralPartnerShipRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationGeneralPartnershipAndSave());
        partnerSoleProprietorshipRegistrationPage.completeCRAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeThreePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeGeneralPartnershipPowerOfAttorneyAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraGeneralPartnershippIsRegistered());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }
//
//    /* Principle Place of Business - international address
//
//    3	Business name registration	Register business name for the above GP	Partner			"- Services > Search the Registry > Register a business name for the above GP. Use international address if allowed by the system
//                - Submit, pay the fees and finalize the transaction
//                - Request profile report. Submit, pay the fees and finalize the transaction.
//                - Request list of document copies. Submit, pay the fees and finalize the transaction.
//                - Review all outputscorrespondence, profile report etc. received in your work email"
//
//    4	Check Registrat and  Business Name link	"Review entity records to ensure business name link is displayed.
//                Review business name records to ensure Registrat link is displayed"	Partner	Enitity exists	"Entity registered above
//
//                Business name registered above"	"- Navigation: Services > Search the Registry
//                -Select the above corporation
//                -Check business name page to ensure business name is displayed
//                Take screenshots highlighting business name and save it in the word template
//
//                '- Navigation: Services > Search the Registry
//                -Select the above business name
//                -Check Registrat page to ensure RRegistrant name is displayed
//                Take screenshots highlighting Registrant name and save it in the word template"
//
//
//  */
//    @Test
//    public void CR_4260_4279_4277_4574_4592_4628_GeneralPartnershipInternationalAddress_TC3_TC4_TC5() throws IOException, InterruptedException, AWTException {
//        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
//
//        portalLandingPage.selectGeneralPartnerShipRegistrationService();
//        partnerTermsAndConditionsPage.acceptTermsAndConditions();
//        contactInformationPage.completeContactInformationAndSave();
//        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationGeneralPartnershipAndSave());
//        partnerSoleProprietorshipRegistrationPage.completeInternationalBusinessAddressAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeThreePartnersAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeGeneralPartnershipPowerOfAttorneyAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
//        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
//        portalLandingPage.selectSearchRegistry();
//
//        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraGeneralPartnershippIsRegistered());
////        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
////        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
//    }

}