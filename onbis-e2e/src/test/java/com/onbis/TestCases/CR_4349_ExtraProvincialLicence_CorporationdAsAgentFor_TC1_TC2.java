package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4349_ExtraProvincialLicence_CorporationdAsAgentFor_TC1_TC2 extends SOAdminSetup {

    /*
        o. https://ontariogov.sharepoint.com/sites/GSIC/onbismod/Project Workstreams/Business Services Unit/UAT/04. November 2022 Release/UAT Test Docs/Olin/ONBAT 4260 N 4279 N 4277 N 4574 N 4592 N 4628-Min Name N Leading 0 N Intl Address N Upper Case-a-S.xlsx

         2	EP Foreign with Share registration	"Incorporate a EP Foreign with Share. Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
        "	Admin	Enitity does not exist and will be registered	Enter valid data for various fields like entity name, address, director name. Enter at least one international address,  (Make up the data)	"- Services > Register Services > Corporations > File an EP License
        - Select ""Person with paper form""
        - Enter the contact name person
        - Enter all other mandatory information. Enter at least one international address
        - Please check the objectives of OBR system page enrty related to leading zero in addresses like PPOB address, Individual addresses (sole prop etc.), international address, Region field requirements, and all individual's (director, incorporator etc.)  names in upper case requirements mentioned in cell G1 are met
        Take screenshots highlighting Address1, Region field in international address, individuals names and save it in the word template
        - Submit, pay the fees, Finalize the transaction
        - Review all outputs like Certificate, Registraion information, WSIB and other correspondence, profile report etc. received in your work email"
            Business name registration	Register business name for the above EPCA corporation			Enter valid data for various fields like entity name, address, director name. Enter at least one international address,  (Make up the data)	"- Services > Search the Registry
        - Register a business name for the above corporation. Use international address if allowed by the system
        - Submit, pay the fees and finalize the transaction
        - Request profile report. Submit, pay the fees and finalize the transaction.
        - Request list of document copies. Submit, pay the fees and finalize the transaction.
        - Review all outputscorrespondence, profile report etc. received in your work email"
        3	Check Registrat and  Business Name link	"Review entity records to ensure business name link is displayed.
        Review business name records to ensure Registrat link is displayed"	Admin	Enitity exists	"Entity registered above

        Business name registered above"	"- Navigation: Services > Search the Registry
        -Select the above corporation
        -Check business name page to ensure business name is displayed
        Take screenshots highlighting business name and save it in the word template

        '- Navigation: Services > Search the Registry
        -Select the above business name
        -Check Registrat page to ensure RRegistrant name is displayed
        Take screenshots highlighting Registrant name and save it in the word template"
        4	Entity Profile Report	"Request a profile report.  Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
        "	Admin	Entity exists	"Entity registered above

        Business name registered above"	#NAME?



     */
    @Parameters({"browser"})
    @Test
    public void CR_4349_ExtraProvincialLicence_CorporationdAsAgentFor_TC1_TC2(String browser) throws IOException, InterruptedException, AWTException {

// Note: "CR_4302_OntarioBusinessCorporation_HeaderDisplayedFrameNumber_TC2" script must be executed prior to this script to get existing "Ontario Business Incorporation Number" from "UAT2_CR_4302_OntarioBusinessIncorporation.txt" file.
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        Reporter.log("-------: CR_4349_ExtraProvincialLicence_CorporationdAsAgentFor_TC1_TC2 -> ");
        mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectRegistryAsApplicationForExtraProvincialLicenceForForeignCorp();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveOCN();
        Thread.sleep(2000);
        soIncorporateOntarioBusinessCorporationPage.completeJurisdictionForExtraProvincialLicenceForeignCorpInternational();
//        soIncorporateOntarioBusinessCorporationPage.setExtraProvincialCorporation(soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveExtraProvincialCorporation(browser));
        String bName = soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveExtraProvincialCorporation(browser);
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressUSAAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeChiefOfficerAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationdAsAgentAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsAndSaveForeignCorp();

        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        soIncorporateOntarioBusinessCorporationPage.reviewAndApproveFromWorkQueueEP(bName);
        String results = partnerPortalLandingPage.advanceSearchByEntityRegisterSubTypeStatus(bName, "Corporations","Extra-Provincial Foreign Corporation with Share","Active");
        System.out.println(results);
        if (results.contains("No results"))
        {
            System.out.println(partnerPortalLandingPage.advanceSearchByEntityRegisterSubTypeStatus("", "Corporations", "Extra-Provincial Foreign Corporation with Share", "Active"));
        }

        partnerPortalLandingPage.selectFilingsSubMenuOption();
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.verificationExtraProvincialForeignLicence());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText().contains(results));
        Reporter.log("Business Name Registration '" + results +"' for a EPCA - Extra-Provincial Foreign Licence is verified.");
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Ok')]")), driver);


    }
}
