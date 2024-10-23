package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.SOAdminOntarioBusinessRegistryDashboardPage;
import com.onbis.Pages.SOIncorporateOntarioBusinessCorporationPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class TC03_OCR001_AssignAnOCN extends SOAdminSetup {

    /*
    3. Assign an OCN: "OCR001-Assign an OCN"
     */
    @Test
    public void TC03_OCR001_AssignAnOCN() throws InterruptedException {

//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
             mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectServiceAsAssignOCN();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveOCN();
        soIncorporateOntarioBusinessCorporationPage.completeAssignAnOntarioCorporationNumber();
        soIncorporateOntarioBusinessCorporationPage.CompletedOCNwriteToCSV("TC03_OCR001_AssignAnOCN");
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.OCNIsCompleted());
    }
}
