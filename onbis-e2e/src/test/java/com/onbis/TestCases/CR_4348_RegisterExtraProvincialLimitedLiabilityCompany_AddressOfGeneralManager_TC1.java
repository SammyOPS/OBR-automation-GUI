package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import com.onbis.Pages.SOIncorporateOntarioBusinessCorporationPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfGeneralManager_TC1 extends SOAdminSetup {

    /*
        o. https://ontariogov.sharepoint.com/sites/GSIC/onbismod/Project Workstreams/Business Services Unit/UAT/04. November 2022 Release/UAT Test Docs/Camilo N Scott/s. ONBAT 4348-LLC Chief Officer Address.xlsx

        1

        LLCR001	Register an Extra-Provincial Limited Liability Company Name to ensure the address of General Manager/Representative can be any address i.e. US or international	Admin
        Enitity does not exist and will be registered
        Enter valid data for various fields like entity name, RHO address, (Make up the data)

        "- Services > Register Services > Business Name > Register an EPLLC
        - Select ""Person with paper form""
        - Enter the contact name person
        - Enter your work email address in the email address field to get all emails and outputs to your work email
        - Enter all other mandatory information
        - On Authorization page, select ""General Manager/Rep""
        - In address for service select either US or international address
        -Take a screenshot of this page, highlight US/international address and save it in the word template
        -Enter rest of the mandatory fields, review and submit, pay and finalize the transaction
        Review outputs for GM/Rep address"		"-A US or International address can be entered for GM/Rep
        - The US/International address entered is displayed on the output"	US OR International addresses can be entered successfully. Address of GM/REP displayed on output correctly.    	"PASS-  US/international address acceptable and shown on output documents
        "




     */
    @Parameters({"browser"})
    @Test
    public void CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfGeneralManager_TC1(String browser) throws IOException, InterruptedException, AWTException {
// Note: "nuansAddReportNumber" script must be executed prior to this script to get "Nuans Number" if it's being executed in IE browser.
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        Reporter.log("-------: CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfGeneralManager_TC1 -> ");
        mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectRegisterExtraProvincialLimitedLiabilityCompany();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterExtraProvincialLimitedLiabilityCompanyAndSave();

        String businessName = partnerSoleProprietorshipRegistrationPage.completeExtraProvincialLimitedLiabilityCompanyBusinessNameRegistrationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeCRAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeAuthorizationExtraProvincialLimitedLiabilityCompany();
        soIncorporateOntarioBusinessCorporationPage.reviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        partnerPortalLandingPage.selectSearchRegistry();
        soIncorporateOntarioBusinessCorporationPage.searchCorporationByName(businessName);
//        partnerPortalLandingPage.selectFilingsSubMenuOption();
        partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedLiabilityCompanyIsUpdated();
//        partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedLiabilityCompanyIsRegistered(businessName);
//        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.requestProfileReportEmail());
//
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);

    }
}
