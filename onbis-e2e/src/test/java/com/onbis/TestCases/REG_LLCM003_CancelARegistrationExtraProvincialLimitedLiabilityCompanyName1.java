package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class REG_LLCM003_CancelARegistrationExtraProvincialLimitedLiabilityCompanyName1 extends SOAdminSetup {

    /*
        precondition Ref:
            CIA015-PRE-	The user must be 10 gged in to ONEilS. Users include
            Serviceontario Account Portal user (Joe Public)
            Pertn:r Portel user
            Admin Portal User (ServiceOntario Registry staff)
            CIA015.PRE.	A Serviceontsrio Account Portal user must not hue entity authority over any other registered entities (i.e their profile cannot Se linked via an Authority Role. 	the
            Exec utive Authority Role. to another corporation. partnership. sole proprietorship. or LLC registered). Refer to Company Key & Authority Catalog for additi Onal details on Entity Authority

        Initial Return for an Extra-Provincial Corp
        Steps to reproduce:
            1)	Login into ONBIS Admin Portal
            2)	File Application for Extra-Provincial Licence for a Foreign Corporation
            3)	File an Initial Return for an Extra-Provincial Corporation
            4)	Select Make Changes, File Initial Return
            5)	Enter Contact Information, click Continue
            6)	On General Details form select <Ceased Activity in Ontario Date>, Save and Continue
            7)	On Address page change Principal Place of Business, Save and Continue
            8)	Select NO for Has the corporation appointed a chief officer or manager in Ontario, Save and Continue
            9)	Navigate through Agent and Service form, Save and Continue
            10)	Add the Name of the Director, select Authorization box, Save and Continue
            11)	<Review and Authorization> form populated with Generate PDF, and Authorization check box
            // **** NOTE & Warning: Script can NOT click on the 'Generate PDF' button which will freeze screen and framework will crash
            12)	Review the screen, click on "Generate PDF" button to download a file
            13)	Select the checkbox for "Authorization", Click Submit

     */
    @Parameters({"browser"})
    @Test // (invocationCount = 3)
    public void REG_LLCM003_CancelARegistrationExtraProvincialLimitedLiabilityCompanyName1(String browser) throws IOException, InterruptedException, AWTException {
        Reporter.log("-------: REG_LLCM003_CancelARegistrationExtraProvincialLimitedLiabilityCompanyName -> ");
        mgcsAdminLandingPage.launchAdminPortal();
        soAdminOntarioBusinessRegistryDashboardPage.selectRegisterExtraProvincialLimitedLiabilityCompany();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterExtraProvincialLimitedLiabilityCompanyAndSave();

        String businessName = partnerSoleProprietorshipRegistrationPage.completeExtraProvincialLimitedLiabilityCompanyBusinessNameRegistrationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeCRAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeAuthorizationExtraProvincialLimitedLiabilityCompany();
        soIncorporateOntarioBusinessCorporationPage.reviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        partnerPortalLandingPage.selectSearchRegistry();
        soIncorporateOntarioBusinessCorporationPage.searchCorporationByName(businessName);
        partnerPortalLandingPage.selectCancelBusinessName();
        HelperMethods.getLatestWindowFocused(driver);
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSaveFileInitialReturnExtraProvincial();
        soIncorporateOntarioBusinessCorporationPage.selectCertification();
        soIncorporateOntarioBusinessCorporationPage.completeCertificationInitialReturnAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completegeneratePDFReviewAndAuthorizeAndSubmitCorporation();

        partnerPortalLandingPage.selectFilingsSubMenuOption();

        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.initialReturnIsCreated());
    }
}
