package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class TC_ALL_DataCreationRegistrationOfABusinessNameChangeExpiry extends SOAdminSetup {

    /*
        Reset Expiry Date of the "BNM002" test case functionality
     ********** "BNM002_DataCreationRegistrationOfABusinessNameChangeExpiry" must to executed successfully prior to "BNM002_RenewARegistrationOfABusinessNameForASoleProprietorship"

     */

    @Parameters({"browser"})

  //  @Parameters ({"browser", "internetExplorer"})
    @Test

    public void BNM002_DataCreationRegistrationOfASoleProprietorshipBusinessNameChangeExpiry () throws InterruptedException, IOException {
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        File resourcesDirectory = new File("src/main/resources");
        String BNM002ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/BNM002ReturnABusinessNumber.txt");
        System.out.println(BNM002ReturnABusinessNumber);
//        partnerPortalLandingPage.CompletedOCNwriteToCSV("BNM002_DataCreationRegistrationOfASoleProprietorshipBusinessNameChangeExpiry");
        partnerPortalLandingPage.selectSearchRegistry();
        PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).setSoleProprietorshipBusinessExpier(BNM002ReturnABusinessNumber);
        HelperMethods.writeToCSV("BNM002_DataCreationRegistrationOfASoleProprietorshipBusinessNameChangeExpiry", BNM002ReturnABusinessNumber);
    }

   /*
        NOTE: There is no option to reset Expiry Date of this functionality; needs to clarify with the Functional testing team
     */

    @Parameters({"browser"})

    //  @Parameters ({"browser", "internetExplorer"})
    @Test

    public void BNM011_DataCreationRegistrationOfAOntarioLimitedLiabilityPartnershipBusinessNameChangeExpiry() throws InterruptedException, IOException {
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        File resourcesDirectory = new File("src/main/resources");
        String BNM011ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/BNM011ReturnABusinessNumber.txt");
        System.out.println(BNM011ReturnABusinessNumber);
        partnerPortalLandingPage.CompletedOCNwriteToCSV("BNM011_DataCreationRegistrationOfAOntarioLimitedLiabilityPartnershipBusinessNameChangeExpiry");
        partnerPortalLandingPage.selectSearchRegistry();

        PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).setOntarioLimitedLiabilityPartnershiBusinessExpier(BNM011ReturnABusinessNumber);
//        HelperMethods.writeToCSV("BNM011_DataCreationRegistrationOfAOntarioLimitedLiabilityPartnershipBusinessNameChangeExpiry", BNM011ReturnABusinessNumber);
    }

    /*
        Reset Expiry Date of the "BNM017" test case functionality
     */

    @Parameters({"browser"})

    //  @Parameters ({"browser", "internetExplorer"})
    @Test

    public void BNM017_DataCreationRegistrationOfAPartnershipBusinessNameChangeExpiry () throws InterruptedException, IOException {

//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        File resourcesDirectory = new File("src/main/resources");
        String BNM017ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/BNM017ReturnABusinessNumber.txt");
        System.out.println(BNM017ReturnABusinessNumber);
//        partnerPortalLandingPage.CompletedOCNwriteToCSV("BNM017_DataCreationRegistrationOfAPartnershipBusinessNameChangeExpiry");
        partnerPortalLandingPage.selectSearchRegistry();

        PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).setPartnershipshipBusinessExpier(BNM017ReturnABusinessNumber);
        HelperMethods.writeToCSV("BNM017_DataCreationRegistrationOfAPartnershipBusinessNameChangeExpiry", BNM017ReturnABusinessNumber);
    }

        /*
        Reset Expiry Date of the "BNM017" test case functionality
     */

    @Parameters({"browser"})

    //  @Parameters ({"browser", "internetExplorer"})
    @Test

    public void LLCM002_RenewARegistrationOfABusinessNameForALimitedLiabilityCompanyNameExpiry () throws InterruptedException, IOException {

//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        File resourcesDirectory = new File("src/main/resources");
        String LLCM002ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/LLCM002ReturnABusinessNumber.txt");
        System.out.println(LLCM002ReturnABusinessNumber);
//        partnerPortalLandingPage.CompletedOCNwriteToCSV("LLCM002_RenewARegistrationOfABusinessNameForALimitedLiabilityCompanyNameExpiry");
        partnerPortalLandingPage.selectSearchRegistry();

        PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).ExtraProvincialLimitedLiabilityCompanyName(LLCM002ReturnABusinessNumber);
        HelperMethods.writeToCSV("LLCM002_RenewARegistrationOfABusinessNameForALimitedLiabilityCompanyNameExpiry", LLCM002ReturnABusinessNumber);
    }

    @Parameters({"browser"})

    //  @Parameters ({"browser", "internetExplorer"})
    @Test
    public void PSM017_RenewARegistrationOfAOntarioLimitedPartnershipDeclarationExpiry () throws InterruptedException, IOException {

//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        File resourcesDirectory = new File("src/main/resources");
        String PSM017ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/PSM017ReturnABusinessNumber.txt");
        System.out.println(PSM017ReturnABusinessNumber);
//        partnerPortalLandingPage.CompletedOCNwriteToCSV("PSM017_RenewARegistrationOfAOntarioLimitedPartnershipDeclarationExpiry");
        partnerPortalLandingPage.selectSearchRegistry();

        PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).ExtraProvincialLimitedLiabilityCompanyName(PSM017ReturnABusinessNumber);
        System.out.println(PSM017ReturnABusinessNumber);
        HelperMethods.writeToCSV("PSM017_RenewARegistrationOfAOntarioLimitedPartnershipDeclarationExpiry", PSM017ReturnABusinessNumber);
    }

    @Parameters({"browser"})

    //  @Parameters ({"browser", "internetExplorer"})
    @Test
    public void PSM018_RenewARegistrationOfAOntarioLimitedPartnershipDeclarationExpiry () throws InterruptedException, IOException {

//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        File resourcesDirectory = new File("src/main/resources");
        String PSM018ReturnABusinessNumber = HelperMethods.readFromTextFile(resourcesDirectory +"/PSM018ReturnABusinessNumber.txt");
        System.out.println(PSM018ReturnABusinessNumber);
//        partnerPortalLandingPage.CompletedOCNwriteToCSV("PSM018_RenewARegistrationOfAOntarioLimitedPartnershipDeclarationExpiry");
        partnerPortalLandingPage.selectSearchRegistry();

        PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver).ExtraProvincialLimitedLiabilityCompanyName(PSM018ReturnABusinessNumber);
        System.out.println(PSM018ReturnABusinessNumber);
        HelperMethods.writeToCSV("PSM018_RenewARegistrationOfAOntarioLimitedPartnershipDeclarationExpiry", PSM018ReturnABusinessNumber);
        Thread.sleep(200);
    }


}

