package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(ListenersTestNG.class)
public class CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC1 extends SOAdminSetup {

    /*
    1	Condo Corp In-corporation	"Incorporate a condo corp entity. Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
        Negative testing
        "	Admin	Enitity does not exist and will be registered	Enter valid data for various fields like entity name, address, director name. Enter at least one international address,  (Make up the data)	"- Services > Register Services > Corporations > Assign an OCN
        - Select ""Person with paper form""
        - Enter the contact name person
        - Don't enter mandatory information.
        - For every mandatory information not entered system should display an error message and prevent from submitting the transaction
        "

     */
    @Test
    public void CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC1() throws InterruptedException, AWTException {
        // TC 1
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC1 -> ");
        Reporter.log("-------: This is a Negative testing for 'Condo Corp In-corporation'\n" + " :-------");



        soAdminOntarioBusinessRegistryDashboardPage.selectServiceAsAssignOCN();
        soIncorporateOntarioBusinessCorporationPage.inCompleteContactInformationAndSaveOCN();
        String businesssName =soIncorporateOntarioBusinessCorporationPage.inCompleteAssignAnOntarioCorporationNumberCR();
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.OCNIsCompleted());

//        // TC 3
//        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_CorporationsAssignAnOCN_TC3 -> ");
//        partnerPortalLandingPage.selectSearchRegistry();
//        System.out.println(businesssName);
//        soIncorporateOntarioBusinessCorporationPage.searchCorporationByName(businesssName);
//        Reporter.log("-------: searchCorporationByName: ''" + businesssName +"'");
//        partnerPortalLandingPage.selectRegisterABusinessName();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
//        String getBusinesssName =soIncorporateOntarioBusinessCorporationPage.completeRegisterABusinessName();
//        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
//
//        // TC 4
//        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_CorporationsAssignAnOCN_TC4 -> ");
//        partnerPortalLandingPage.selectSearchRegistry();
//        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.CorporationsAssignAnOCNIsRegistered(getBusinesssName));
//
//        // TC 5
//
//        partnerSoleProprietorshipRegistrationPage.requestProfileReport();
//        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
//        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_CorporationsAssignAnOCN_TC5 -> ");
//        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.requestProfileReportEmail());

    }
}
