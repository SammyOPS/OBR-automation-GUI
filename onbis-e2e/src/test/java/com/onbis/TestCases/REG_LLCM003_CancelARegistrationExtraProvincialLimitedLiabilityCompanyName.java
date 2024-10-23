package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerPortalLandingPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class REG_LLCM003_CancelARegistrationExtraProvincialLimitedLiabilityCompanyName extends SOAdminSetup {

    /*

Preconditions Description:

        LLCM003-PRE-01
        The user must be logged in to ORRIS. Users include:
            • ServiceOntario Account Portal user (Joe Public)
            • Partner Portal User (Lawyer)
            • Admin Portal User (ServiceOntario Registry staff)
        LLCM003-PRE-02
             The user has selected the 'Active - Registered' Extra-Provincial Limited Liability Company Name
        LLCM003-PRE-03
              The user has authority to maintain the Extra-Provincial Limited Liability Company Name. Authority is resolved as follows: ServiceOntario Account Portal users and Partner Portal Users have authority over the entity. Admin Portal User has the appropriate permission to maintain the entity.

    Cancel a Registration of an Extra Provincial Limited Liability Company Name
         Steps to reproduce:
            1)	Login into ONBIS Admin Portal
            2)	Register Extra-Provincial Limited Liability Company Name
            3)	Open the registry, select Make Changes, select Cancel
            4)	On Contact Information screen add First Name (mandatory), Middle Name (Optional)  with value, Last Name (mandatory), Email address (mandatory),
            Upload Cancellation of an Extra-Provincial Limited Liability Company Name, Click Continue
            5)	On Cancel a Registration of an Extra-Provincial Limited Liability Company Name page select check box for Cancellation Confirmation, select General Manager/Representative, Type Individual, Add Full Name, add US address for services
            6)	Generate PDF, select check box for confirmation the accuracy of information
            7)	Click Submit

     */
    @Parameters({"browser"})
    @Test //(invocationCount = 3)
    public void REG_LLCM003_CancelARegistrationExtraProvincialLimitedLiabilityCompanyName(String browser) throws IOException, InterruptedException, AWTException {

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
        soIncorporateOntarioBusinessCorporationPage.writeOCNToCSVFromGeneralDetails("REG_LLCM003_CancelARegistrationExtraProvincialLimitedLiabilityCompanyName");
        partnerPortalLandingPage.selectCancelBusinessName();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationExtraProvincialLimitedLiabilityCompanyNameAndSave();

        partnerSoleProprietorshipRegistrationPage.cancellationConfirmationExtraProvincialLimitedLiabilityCompanyName();
        partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedLiabilityCompanyIsCanceled();


    }
}
