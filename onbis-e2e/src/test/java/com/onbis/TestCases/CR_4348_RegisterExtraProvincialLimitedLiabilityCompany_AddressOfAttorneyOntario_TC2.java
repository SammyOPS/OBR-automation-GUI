package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfAttorneyOntario_TC2 extends SOAdminSetup {

    /*
        o. https://ontariogov.sharepoint.com/sites/GSIC/onbismod/Project Workstreams/Business Services Unit/UAT/04. November 2022 Release/UAT Test Docs/Camilo N Scott/s. ONBAT 4348-LLC Chief Officer Address.xlsx

        2	LLCR001	Register an Extra-Provincial Limited Liability Company Name to ensure the address of Power of Attorney is Ontario address	Admin	Enitity does not exist and will be registered	Enter valid data for various fields like entity name, RHO address, (Make up the data)	"- Services > Register Services > Business Name > Register an EPLLC
            - Select ""Person with paper form""
            - Enter the contact name person
            - Enter your work email address in the email address field to get all emails and outputs to your work email
            - Enter all other mandatory information
            - On Authorization page, select ""Person Acting Under Power of Attorney""
            - In address ensure only option available for address is Ontario address
            -Take a screenshot of this page, highlight ability to enter ONLY Ontario address address and save it in the word template
            -Enter rest of the mandatory fields, review and submit, pay and finalize the transaction
            Review outputs for GM/Rep address"		person acting under power of attorney adress should only be ONTARIO	Ontario address equired for POA





     */
    @Parameters({"browser"})
    @Test
    public void CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfAttorneyOntario_TC2(String browser) throws IOException, InterruptedException, AWTException {
// Note: "nuansAddReportNumber" script must be executed prior to this script to get "Nuans Number" if it's being executed in IE browser.
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        Reporter.log("-------: CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfAttorneyOntario_TC2 -> ");
        mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectRegisterExtraProvincialLimitedLiabilityCompany();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterExtraProvincialLimitedLiabilityCompanyAndSave();

        String businessName = partnerSoleProprietorshipRegistrationPage.completeExtraProvincialLimitedLiabilityCompanyBusinessNameRegistrationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeCRAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeAuthorizationExtraProvincialLimitedLiabilityCompanyActingUnderPowerofAttorney();
        soIncorporateOntarioBusinessCorporationPage.reviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        partnerPortalLandingPage.selectSearchRegistry();
        soIncorporateOntarioBusinessCorporationPage.searchCorporationByName(businessName);
//        partnerPortalLandingPage.selectFilingsSubMenuOption();
        partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedLiabilityCompanyIsUpdated();
//        partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedLiabilityCompanyIsRegistered(businessName);
//        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.requestProfileReportEmail());
//


    }
}
