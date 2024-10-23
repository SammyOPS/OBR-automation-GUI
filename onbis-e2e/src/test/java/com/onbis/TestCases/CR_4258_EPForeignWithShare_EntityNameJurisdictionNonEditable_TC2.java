package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class CR_4258_EPForeignWithShare_EntityNameJurisdictionNonEditable_TC2 extends SOAdminSetup {

    /*
        o. https://ontariogov.sharepoint.com/sites/GSIC/onbismod/Project Workstreams/Business Services Unit/UAT/04. November 2022 Release/UAT Test Docs/
        E:\QA\Automation\Sanity Testing Scripts\Documents\CR -Test Case\v. ONBAT 4258-Read only Entity Name N Jurisdiction for Mainteance service-Retest_Updated.xlsx

    TC-2

        2	BCAM005	"-Unable to edit entity name and jurisdiction for Ontario Corp. Maintenance service
        -The past jurisdiction is populated correctly on the outputs"	Admin	Please see eSMT Tkt numbers below	EP Foreign with Share	"1. Navigation: Services > Search the Registry
            2. Click on Advanced
            3. Select Corporations Register, Business Type mentioned in column F, and Active Status
            4. Click on Search
            5. Select one of the corporations
            6. Take a screenshot of the General Details page and highlight Current and former jurisdictions. Save.
            7. In the General tab page, select make Changes > File Articles of Continuance under BCA
            8. Select ""Person with a paper"" form.
            9. Enter all mandatory information
            10.  Enter your work email address to receive outputs via email
            11. Click on Continue
            12. The entity name and jurisdiction information should be read only and not editable
            13. Ensure the former jurisdiction is correctly populated and is the ""current"" jurisdiction noted in step 6
            15. Take a screenshot, highlight current jurisdiction and save it in the word template
            16. Enter all mandatory information
            17. Submit the transaction, pay, and confirm
            18. Review the output
            19. Ensure current jurisdiction is ""ONTARIO"" and past jurisdiction is correct"	5024565	"- The entity name and jurisdiction information should be read only and not editable
            - The past jurisdiction is correct i.e. past jurisdiction = current jurisdiction before the continuance transaction started"



     */
    @Parameters({"browser"})
    @Test
    public void CR_4258_EPForeignWithShare_EntityNameJurisdictionNonEditable_TC2 (String browser) throws IOException, InterruptedException, AWTException {
// Note: "nuansAddReportNumber" script must be executed prior to this script to get "Nuans Number" if it's being executed in IE browser.
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        Reporter.log("-------: CR_4258_EPForeignWithShare_EntityNameJurisdictionNonEditable_TC2 -> ");
        mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectRegistryAsApplicationForExtraProvincialLicenceForForeignCorp();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveOCN();
        Thread.sleep(2000);
        soIncorporateOntarioBusinessCorporationPage.completeJurisdictionForExtraProvincialLicenceForeignCorpInternational();
//        soIncorporateOntarioBusinessCorporationPage.setExtraProvincialCorporation(soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveExtraProvincialCorporation(browser));


        String bName = soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAndSaveExtraProvincialCorporation(browser);
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressUSAAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSaveForeignCorpAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeChiefOfficerAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeAgentForServiceAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsAndSaveForeignCorp();

        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        partnerPortalLandingPage.searchByEntity(soIncorporateOntarioBusinessCorporationPage.reviewCompanyNameAndApproveFromWorkQueue(bName));
    //    String bName ="BQ4JTUHV0D test inc.";
//        String results = partnerPortalLandingPage.advanceSearchByEntityRegisterSubTypeStatus(bName, "Corporations","Extra-Provincial Foreign Corporation with Share","Active");
//        System.out.println(results);
//        if (results.contains("No results"))
//        {
//            System.out.println(partnerPortalLandingPage.advanceSearchByEntityRegisterSubTypeStatus("", "Corporations", "Extra-Provincial Foreign Corporation with Share", "Active"));
//        }
        partnerSoleProprietorshipRegistrationPage.selectFileArticlesOfContinuanceUnderBCAFromMakeChangesMenu();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterExtraProvincialLimitedLiabilityCompanyAndSave();


        soIncorporateOntarioBusinessCorporationPage.completeContactInformationFileArticlesOfContinuanceSave();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveOCN();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegistrarSave();

        soIncorporateOntarioBusinessCorporationPage.completeInformatioOnFileJurisdictionNonEditableSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameSave();
        soIncorporateOntarioBusinessCorporationPage.saveOnlyAddress();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsOnlyAndSave();
        soIncorporateOntarioBusinessCorporationPage.sharesProvisionsSave();
        soIncorporateOntarioBusinessCorporationPage.saveRequiredStatements();
        soIncorporateOntarioBusinessCorporationPage.reviewAndAuthorization();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();

        partnerPortalLandingPage.selectFilingsSubMenuOption();

        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.verificationPFCWithShare_EntityNameJurisdictionNonEditable());
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
    }
}
