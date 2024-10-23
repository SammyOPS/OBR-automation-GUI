package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class TC11_BNR002_RegisterABusinessNameForACorporation_Continues extends SOAdminSetup {

    /*
   TC11_BNR002_RegisterABusinessNameForACorporation_Continues
     */
    @Test
    public void TC11_BNR002_RegisterABusinessNameForACorporation_Continues() throws InterruptedException, IOException {
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        partnerPortalLandingPage.selectSearchRegistry();
//        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation("4O0EMQN407 INC. (1000002455)");
        File resourcesDirectory = new File("src/main/resources");
        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation(HelperMethods.readFromTextFile(resourcesDirectory +"/ontarioBusinessCorporationIsRegistered.txt"));
        soIncorporateOntarioBusinessCorporationPage.registerABusinessName();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveregisterABusinessNames();
        soIncorporateOntarioBusinessCorporationPage.completeRegisterABusinessNameForACorporation();
        partnerPortalLandingPage.GeneralDetailsOCNwriteToCSV("TC11_BNR002_RegisterABusinessNameForACorporation_Continues");
        partnerPortalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.ontarioBusinessCorporationIsRegisteredContinues());
    }
}
