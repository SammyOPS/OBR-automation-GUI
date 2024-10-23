package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4295_GeneralPartnership_BusinessNames_BusinessLink_TC6 extends SOAdminSetup {

/*

        As per QA Meeting on Jan 09, 2023 (10:00 AM): 4448, -Angela - - ONBAT 4574 Ministry Name Change - Past dated reports

        ONBBAT-4280 Test Scenarios	- CR - DR100- PSV003 - Request Certificate of Status for a corporation with sub status of 'Court ordered winding up' - TC01-Label/Item validation - Ontario Business Corporation (A)

        TC-1

            Admin	Entity exists	General Partnership	"- Navigation: Services > Search the Registry
            -Click on Advanced.
            -Enter OCN # provided in column H
            -Check the box Exact Match
            -Click on Search
            - Check all the tabs to see if all business names for this entity are listed and a link is provided to the business name
            -Take a screenshot of the page and save in the word template
            "		All business names for the entity should be displayed with a link provided to business name record

    Reference:
        https://ontariogov.sharepoint.com/:x:/r/sites/GSIC/onbismod/Project%20Workstreams/Business%20Services%20Unit/UAT/04.%20November%202022%20Release/UAT%20Test%20Docs/Angela/Retest/RETEST%20-%20a.%20ONBBAT%204280-Release%202.0.7.1%20Test%20Cases_FINAL%20Consolidation-Retest__.xlsx?d=wb032228cc1dc4b40bd95f28a6b8e5cb2&csf=1&web=1&e=eQOoFP

        Folder Name: "Victor"
  */
    @Test
    public void CR_4295_GeneralPartnership_BusinessNames_BusinessLink_TC6() throws IOException, InterruptedException, AWTException {

        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: CR_4295_GeneralPartnership_BusinessNames_BusinessLink_TC6-> ");
        soAdminOntarioBusinessRegistryDashboardPage.selectGeneralPartnerShipRegistrationService();

        soIncorporateOntarioBusinessCorporationPage.completeContactInformationGeneralPartnershipAndSave();
        String businessName =soIncorporateOntarioBusinessCorporationPage.completeGeneralPartnershipFirmName();
        System.out.println("General Partnership Business Names is: " + businessName);
        Reporter.log("General Partnership Business Names is: " + businessName);
        partnerSoleProprietorshipRegistrationPage.completeCRAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeThreePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeGeneralPartnershipPowerOfAttorneyAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());

        String oCN = partnerPortalLandingPage.getOntarioCorporationCompletedNumber();
        System.out.println("Ontario Corporation Number (OCN) number is: " + oCN);
        Reporter.log("Ontario Corporation Number (OCN) number is: " + oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation(oCN);

        partnerPortalLandingPage.selectRegisterABusinessName();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
        String getBusinesssName =soIncorporateOntarioBusinessCorporationPage.completeRegisterBusinessNameForGeneralPartnership();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());


        partnerPortalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.businessNameGeneralPartnershipIsRegistered(getBusinesssName));



    }

}