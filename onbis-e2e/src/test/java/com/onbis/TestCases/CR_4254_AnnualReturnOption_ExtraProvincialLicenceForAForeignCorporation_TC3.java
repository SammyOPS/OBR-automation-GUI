package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4254_AnnualReturnOption_ExtraProvincialLicenceForAForeignCorporation_TC3 extends SOAdminSetup {

    /*
        o. https://ontariogov.sharepoint.com/sites/GSIC/onbismod/Project Workstreams/Business Services Unit/UAT/04. November 2022 Release/UAT Test Docs/Olin/
        E:\QA\Automation\Sanity Testing Scripts\Documents\CR -Test Case\a. ONBAT 4254-Annual Return For Various ON Corp_Updated.xlsx

    TC-3

             CIA002	Able to file Annual return for EP Foreign with Share 	Admin	Entity exists	EP Foreign with Share	"- Navigation: Services > Search the Registry
            -Click on Advanced.
            -Select Corporations Register, select Business Type stated in column F, and Active Status
            -Click on Search
            -Select one of the corporations
            -In the General tab page, select make Changes
            -Drop-down menu should display ""Annual Return"" as one of the options
            -Take a screenshot, highlight Annual return and save it in the word template"		The "Annual Return" option is displayed in drop-down menu




     */
    @Parameters({"browser"})
    @Test
    public void CR_4254_AnnualReturnOption_ExtraProvincialLicenceForAForeignCorporation_TC3(String browser) throws IOException, InterruptedException, AWTException {
// Note: "nuansAddReportNumber" script must be executed prior to this script to get "Nuans Number" if it's being executed in IE browser.
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        Reporter.log("-------: CR_4254_AnnualReturnOption_ExtraProvincialLicenceForAForeignCorporation_TC3 -> ");
        mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectRegistryAsApplicationForExtraProvincialLicenceForForeignCorp();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveOCN();
        Thread.sleep(2000);
        soIncorporateOntarioBusinessCorporationPage.completeJurisdictionForExtraProvincialLicenceForeignCorpInternational();
//        soIncorporateOntarioBusinessCorporationPage.setExtraProvincialCorporation(soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveExtraProvincialCorporation(browser));
        String bName = soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveExtraProvincialCorporation(browser);
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressUSAAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeChiefOfficerAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeAgentForServiceAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsAndSaveForeignCorp();

        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
//        String bName ="BQ4JTUHV0D test inc.";
        String results = partnerPortalLandingPage.advanceSearchByEntityRegisterSubTypeStatus(bName, "Corporations","Extra-Provincial Foreign Corporation with Share","Active");
        System.out.println(results);
        if (results.contains("No results"))
        {
            System.out.println(partnerPortalLandingPage.advanceSearchByEntityRegisterSubTypeStatus("", "Corporations", "Extra-Provincial Foreign Corporation with Share", "Active"));
        }
//        partnerPortalLandingPage.selectSearchRegistry();
//        soIncorporateOntarioBusinessCorporationPage.searchCorporationAndSelectResult();

// ++++++++++++++++
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.verifyMakeChangesMenu("File Annual Return"));

    }
}
