package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.GenericUtilsPage;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4260_4279_4277_4574_4592_4628_SoleProp_TC1_3 extends SOAdminSetup {
    /*
        1	Sole Prop.  Registration	"Register sole prop.  entity. Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
        Negative testing
        "	Admin	Enitity does not exist and will be registered	Enter valid data for various fields like entity name, address, director name. Enter at least one international address,  (Make up the data)	"Services > Register Services > Sole Prop. > Register a business name for a sole prop.
        - Select ""Person with paper form""
        - Enter the contact name person
        - Don't enter mandatory information.
        - For every mandatory information not entered system should display an error message and prevent from submitting the transaction"

     */
    @Test
    public void CR_4260_4279_4277_4574_4592_4628_SoleProp_TC1() throws InterruptedException, IOException, AWTException {
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();

        // TC 1
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_SoleProp_TC1 -> ");
        Reporter.log("-------: This is a Negative testing for 'Sole Prop.  Registration'\n" + " :-------");
        mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectRegistryAsSolePropRegisterBusinessNameSoleProp();
        soIncorporateOntarioBusinessCorporationPage.incompleteContactInformationAndSaveSoleProp();
        partnerSoleProprietorshipRegistrationPage.incompleteBusinessNameRegistrationNotSave();
    }


    /*
        2	Register a sole Prop	"Register a sole properietorship business. Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
        "	Admin	Entity does not exists	Enter valid data for various fields like entity name, address, sole prop name . Enter at least one international address,  (Make up the data)	"- Services > Register Services > Sole Prop. > Register a business name for a sole prop.
        - Select ""Person with paper form""
        - Enter the contact name person
        - Enter your work email address in the email address field to get all emails and outputs to your work email
        - Enter all other mandatory information. Enter at least one international address if allowed
        - Please check the objectives of OBR system page enrty related to leading zero in addresses like RHO address, Individual addresses (directors, incorporators etc.), international address, Region field requirements, and all individual's (director, incorporator etc.)  names in upper case requirements mentioned in cell G1 are met
        Take screenshots highlighting Address1, Region field in international address, individuals names and save it in the word template"

        ===
        3	Entity Profile Report	"Request a profile report.  Ensure all OBR pages, emails and outputs meet the conditions mentioned in cell G1 above
        "	Admin	Entity exists	Sole Prop	"- Navigation: Services > Search the Registry
        -Select the above sole prop
        -Click on Request Search Products > Profile Report > Current
        - Enter your work email address in the email address field to get all emails and outputs to your work email
        - Submit, pay the fees, Finalize the transaction
        - Review outputs received in your work email"		"
        All output and email related objectives mentioned in cell G1 are met"
     */
    @Test
    public void CR_4260_4279_4277_4574_4592_4628_SoleProp_TC2_TC3() throws InterruptedException, IOException, AWTException {
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
//        GenericUtilsPage.validateEmailReceived();
        // TC 2
        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_SoleProp_TC2 -> ");
        soAdminOntarioBusinessRegistryDashboardPage.selectRegistryAsSolePropRegisterBusinessNameSoleProp();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveSoleProp(); //completeContactInformationAndSaveIncorporate();

        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeSolePropAddressAndSave(); //completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeInternationalAddressOwnerAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSave();
        String returnABusinessNumber = new PartnerSoleProprietorshipRegistrationPage(driver).returnBusinessNumber();
        System.out.println("Sole Prop Business number is: " + returnABusinessNumber);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory +"/CR_4260_4279_4277_4574_4592_4628_SoleProp.txt",returnABusinessNumber);
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();


        partnerPortalLandingPage.setOntarioCorporation(partnerPortalLandingPage.selectCompletedMenuOptionAndGetCorporationName());
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResult();

        partnerPortalLandingPage.selectFilingsSubMenuOption();

        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.verificationRegisterBusinessNameForSoleProp());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='appFilingDetailObject']//div[1]")).getText().contains(returnABusinessNumber));
        Reporter.log("Business Name Registration '" + returnABusinessNumber +"' for a Sole Proprietorship is verified.");
        HelperMethods.fluentWaitAndClick(driver.findElement(By.xpath("//span[contains(text(), 'Ok')]")), driver);
        // TC 3

        partnerSoleProprietorshipRegistrationPage.requestProfileReport();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        Reporter.log("-------: CR_4260_4279_4277_4574_4592_4628_SoleProp_TC3 -> ");
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.requestProfileReportEmail());
    }
}
