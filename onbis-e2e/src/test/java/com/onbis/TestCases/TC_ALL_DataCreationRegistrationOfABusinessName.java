package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Configuration.browser;
import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class TC_ALL_DataCreationRegistrationOfABusinessName extends PartnerPortalSetUp {

    /*
     Registration of a Business Name for a Sole Proprietorship - for BNM002_RenewARegistrationOfABusinessNameForASoleProprietorship"
     ********** "BNM002_DataCreationRegistrationOfABusinessName" must to executed successfully prior to "BNM002_DataCreationRegistrationOfABusinessNameChangeExpiry"
     */
    @Test
    public void BNM002_DataCreationRegistrationOfABusinessNameForASoleProprietorshipBusinessName() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectSoleProprietorshipOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeOwnerAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSave();
        String returnABusinessNumber = new PartnerSoleProprietorshipRegistrationPage(driver).returnBusinessNumber();
        System.out.println("Business number is: " + returnABusinessNumber);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory +"/BNM002ReturnABusinessNumber.txt",returnABusinessNumber);
//        HelperMethods.writeToCSV("BNM002_DataCreationRegistrationOfABusinessNameForASoleProprietorshipBusinessName", returnABusinessNumber);
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.CompletedOCNwriteToCSV("BNM002_DataCreationRegistrationOfABusinessNameForASoleProprietorshipBusinessName");
        portalLandingPage.selectSearchRegistry();
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
    }

    /*
    DOES NOT WORK!!!!!!
 Registration of a Business Name for a Sole Corporation - for "BNM011-Renew a Business Name Registration for a Corporation"
 */
    @Parameters({"browser"})
    @Test
    public void BNM011_DataCreationRegistrationOfAOntarioLimitedLiabilityPartnershipBusinessName() throws IOException, InterruptedException {
//        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
//        portalLandingPage.selectOntarioBusinessCorporationRegistrationService();
//        partnerTermsAndConditionsPage.acceptTermsAndConditions();
//        contactInformationPage.completeContactInformationAndSave();
//        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeCorporationNameAndSave(browser));
//        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();

        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectRegisterFirmNameForOntarioLimitedLiabilityService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();

        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSaveLLP());
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.selectPartnersMultiple();
        String returnABusinessNumber = new PartnerSoleProprietorshipRegistrationPage(driver).returnBusinessNumber();
        System.out.println("Business number is: " + returnABusinessNumber);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory +"/BNM011ReturnABusinessNumber.txt",returnABusinessNumber);
//        HelperMethods.writeToCSV("BNM011_DataCreationRegistrationOfAOntarioLimitedLiabilityPartnershipBusinessName", returnABusinessNumber);
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.CompletedOCNwriteToCSV("BNM011_DataCreationRegistrationOfAOntarioLimitedLiabilityPartnershipBusinessName");
        portalLandingPage.selectSearchRegistry();
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
//
//        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();

//        String returnABusinessNumber = new PartnerSoleProprietorshipRegistrationPage(driver).returnBusinessNumber();
//        System.out.println("Business number is: " + returnABusinessNumber);
//        File resourcesDirectory = new File("src/main/resources");
//        HelperMethods.writeToTextFile(resourcesDirectory +"/BNM012ReturnABusinessNumber.txt",returnABusinessNumber);
//        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
    }

    /*
     Registration of a Business Name for a Partnership - for "BNM017-Renew Registration of a Business Name for a Partnership""
     */
    @Test
    public void BNM017_DataCreationRegistrationOfAPartnershipBusinessName() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectGeneralPartnerShipRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        String returnABusinessNumber = new PartnerSoleProprietorshipRegistrationPage(driver).returnBusinessNumber();
        System.out.println("Business number is: " + returnABusinessNumber);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory +"/BNM017ReturnABusinessNumber.txt",returnABusinessNumber);
//        HelperMethods.writeToCSV("BNM017_DataCreationRegistrationOfAPartnershipBusinessName", returnABusinessNumber);
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.CompletedOCNwriteToCSV("BNM017_DataCreationRegistrationOfAPartnershipBusinessName");
        portalLandingPage.selectSearchRegistry();
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
        //==============
    }

    /*
 Registration of a Limited Liability Company Name - for "LLCM002_RenewARegistrationOfALimitedLiabilityCompanyName""
 */
    @Test
    public void LLCM002_DataCreationRegistrationOfALimitedLiabilityCompanyName() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectEPLLService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSaveExtraProvincial();
        String returnABusinessNumber = new PartnerSoleProprietorshipRegistrationPage(driver).returnBusinessNumber();
        System.out.println("Business number is: " + returnABusinessNumber);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory +"/LLCM002ReturnABusinessNumber.txt",returnABusinessNumber);
//        HelperMethods.writeToCSV("LLCM002_DataCreationRegistrationOfALimitedLiabilityCompanyName", returnABusinessNumber);
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.CompletedOCNwriteToCSV("LLCM002_DataCreationRegistrationOfALimitedLiabilityCompanyName");
        portalLandingPage.selectSearchRegistry();
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
        //==============
    }

    /*
Registration of A OntarioLimited Partnership Declaration - for "PSM017_DataCreationRegistrationOfAOntarioLimitedPartnershipDeclaration""
*/
    @Test
    public void PSM017_DataCreationRegistrationOfAOntarioLimitedPartnershipDeclaration() throws IOException, InterruptedException {

        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectFileDecelerationOfOntarioLimitedPartnershipService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
       String returnABusinessNumber = partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAddressFileADeceleration();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        System.out.println("Registration Of A OntarioLimited Partnership Declaration Name is: " + returnABusinessNumber);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory + "/PSM017ReturnABusinessNumber.txt", returnABusinessNumber);
//        HelperMethods.writeToCSV("PSM017_DataCreationRegistrationOfAOntarioLimitedPartnershipDeclaration", returnABusinessNumber);
        portalLandingPage.CompletedOCNwriteToCSV("PSM017_DataCreationRegistrationOfAOntarioLimitedPartnershipDeclaration");
        portalLandingPage.selectSearchRegistry();
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
        //==============
    }

    /*
Registration Of A Firm Name For A General Partnership - for "PSM018_RenewARegistration_OfAFirmNameForAGeneralPartnership""
*/
    @Test
    public void PSM018_DataCreationRegistration_OfAFirmNameForAGeneralPartnership() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectGeneralPartnerShipRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        String returnABusinessNumber = partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave();
//        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
//        portalLandingPage.selectSearchRegistry();
//        portalLandingPage.selectSearchRegistry();
//        partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered();
//        portalLandingPage.selectSearchResult();
//
//
//        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
//        portalLandingPage.selectFileDecelerationOfOntarioLimitedPartnershipService();
//        partnerTermsAndConditionsPage.acceptTermsAndConditions();
//        contactInformationPage.completeContactInformationAndSave();
//        String returnABusinessNumber = partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeAddressFileADeceleration();
//        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        System.out.println("Registration Of A FirmName For A General Partnership Name is: " + returnABusinessNumber);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory + "/PSM018ReturnABusinessNumber.txt", returnABusinessNumber);
//        HelperMethods.writeToCSV("PSM018_DataCreationRegistration_OfAFirmNameForAGeneralPartnership", returnABusinessNumber);
        Thread.sleep(200);
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("PSM018_DataCreationRegistration_OfAFirmNameForAGeneralPartnership");
//        portalLandingPage.CompletedOCNwriteToCSV("PSM018_DataCreationRegistration_OfAFirmNameForAGeneralPartnership");
        portalLandingPage.selectSearchRegistry();
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
        //==============
    }

}
