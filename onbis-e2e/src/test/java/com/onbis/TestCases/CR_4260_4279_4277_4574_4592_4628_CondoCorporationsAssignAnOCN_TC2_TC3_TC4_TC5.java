package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC2_TC3_TC4_TC5 extends SOAdminSetup {

    /*

    2	Condo Corp In-corporation	"Incorporate a condo corp. Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
        "	Admin	Enitity does not exist and will be registered	Enter valid data for various fields like entity name, address, director name. Enter at least one international address,  (Make up the data)	"- Services > Register Services > Corporations > Assign an OCN- Select ""Person with paper form""
        - Enter the contact name person
        - Enter all other mandatory information. Enter at least one international address
        - Please check the objectives of OBR system page enrty related to leading zero in addresses like PPOB address, Individual addresses (sole prop etc.), international address, Region field requirements, and all individual's (director, incorporator etc.)  names in upper case requirements mentioned in cell G1 are met
        Take screenshots highlighting Address1, Region field in international address, individuals names and save it in the word template
        - Submit,
        - Review all outputs like Certificate, Registraion information, WSIB and other correspondence, profile report etc. received in your work email"

    3	Business name registration, 	Register business name, request profile report and documents for the above corporation				"- Services > Search the Registry
        - Register a business name for the above corporation. Use international address if allowed by the system
        - Submit, pay the fees and finalize the transaction
        - Review all outputscorrespondence, profile report etc. received in your work email"

    4	Check Registrat and  Business Name link	"Review entity records to ensure business name link is displayed.
        Review business name records to ensure Registrat link is displayed"	Admin	Enitity exists	"Entity registered above

        Business name registered above"	"- Navigation: Services > Search the Registry
        -Select the above corporation
        -Check business name page to ensure business name is displayed
        Take screenshots highlighting business name and save it in the word template

        '- Navigation: Services > Search the Registry
        -Select the above business name
        -Check Registrat page to ensure RRegistrant name is displayed
        Take screenshots highlighting Registrant name and save it in the word template"

    5	Request list of documents	"Request list of all documents.  Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
        "	Admin	Entity exists	"Entity registered above

        Business name registered above"	"- Navigation: Services > Search the Registry
        -Select the above corporation
        -Click on Request Search Products > Profile report > Current
        - Enter your work email address in the email address field to get all emails and outputs to your work email
        - Submit, pay the fees, Finalize the transaction
        - Review outputs received in your work email

        -Click on Request Search Products > List of documens. Select all documents
        - Enter your work email address in the email address field to get all emails and outputs to your work email
        - Submit, pay the fees, Finalize the transaction
        - Review outputs received in your work email"

     */
    @Test
    public void CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC2_TC3_TC4_TC5() throws InterruptedException, AWTException {
        // TC 2
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC2_TC3_TC4_TC5-> ");
        soAdminOntarioBusinessRegistryDashboardPage.selectServiceAsAssignOCN();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveOCN();
        String businesssName =soIncorporateOntarioBusinessCorporationPage.completeAssignAnOntarioCorporationNumberCR();
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.OCNIsCompleted());

        // TC 3
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_CorporationsAssignAnOCN_TC3 -> ");
        partnerPortalLandingPage.selectSearchRegistry();
        System.out.println(businesssName);
        soIncorporateOntarioBusinessCorporationPage.searchCorporationByName(businesssName);
        Reporter.log("-------: searchCorporationByName: ''" + businesssName +"'");
        partnerPortalLandingPage.selectRegisterABusinessName();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
        String getBusinesssName =soIncorporateOntarioBusinessCorporationPage.completeRegisterABusinessName();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());

        // TC 4
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_CorporationsAssignAnOCN_TC4 -> ");
        partnerPortalLandingPage.selectSearchRegistry();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.CorporationsAssignAnOCNIsRegistered(getBusinesssName));

        // TC 5

        partnerSoleProprietorshipRegistrationPage.requestProfileReport();
//        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        String transactionNumber = soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_CorporationsAssignAnOCN_TC5 -> ");
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.requestProfileReportEmail());
//        Assert.assertTrue(genericUtilsPage.emailPaymentReceiptVerified(transactionNumber));
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
    }
}
