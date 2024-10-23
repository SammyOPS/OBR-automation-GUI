package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.SOIncorporateOntarioBusinessCorporationPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class CR_4796_ActiveOntarioCorporationWithBusinessNam_FileArticlesOfContinuance extends SOAdminSetup {

    /*

         1	NFPCM010-File Articles of Continuance for entities that exist in OBR	File authorization to continue out of Ontario. 	Admin	Enitity exists in OBR	Active Ontario Corporation  with active business name	"- Navigation: Services > Search the Registry
        - Click on Advanced
        -Select Register = Corporation, Business Type = Type mentioned in column F,  Status = Stated in column F
        - Select One of the entities
        - Click on Least Recent
        -Note OCN # in column H"
        2					View Corporation	"-Click on Business Name page and ensure the entity has active business names
        -Note the BIN # of active business names(s) in column H
        - Enter official email address as your work email address, if applicable
        -Take a screenshot of active business names
        - Make Changes > File Authorization to Continue Out

        Note: If you don't find entities with active business names after reasonable effort, please contact UAT Coordinator for OCNs with active business names"
        3					Contact Page	"-Select ""Person with paper form
        - Enter all mandatory information
        -- Enter your work email address in the email address field to get all emails and outputs to your work email
        -Click on ""Continue"""
        4					Other Details	-Enter all mandatory and optionally non-mandatory data on this OBR page
        5						"Click the confirmation checkbox
        Click on Submit
        Select payment method ""Cash"" if applicable
        Click on ""Continue"" if applicable
        Click on ""Finalize Transaction"" if applicable"
        6					Dashboard, if required	"Click on the Dashboard
        Find the entity just registered in the dashboard"
        7					Dashboard, if required	"As MOF Continue Out Team member:
        'Click on the ""Do It Now"" link
        Click on ""Approve/Approve form""
        Click on ""Approve/Approve form"", if applicable

        'As MGCS Review Team member:
        'Click on the ""Do It Now"" link
        Click on ""Approve/Approve form""
        Click on ""Approve/Approve form"", if applicable

        Note: If ""Do It Now"" link is not displayed, contact UAT Coordinator"
        8					Emails & Outputs	Check your inbox for output documents


        Reference:

                https://ontariogov.sharepoint.com/:x:/r/sites/GSIC/onbismod/Project%20Workstreams/Business%20Services%20Unit/UAT/05.%20February%202023%20Release/7-UAT%20Test%20Cases/Amber/19.%20ONBBAT%204796-Inconsistent%20biz%20name%20status%20after%20Continue%20Out-Retest.xlsx?d=wc8ff5ae7e7bb42859210bf59e5c53b1b&csf=1&web=1&e=0fFhvf

    */
    @Test
    public void CR_4796_ActiveOntarioCorporationWithBusinessNam_FileArticlesOfContinuance() throws InterruptedException, AWTException {
        // TC 1
//        pkiProfileSingnInPage.loginUsingEPFCredentials();
//        mgcsAdminLandingPage.selectRegistryAsAssignOCN();
        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: CR_4796_ActiveOntarioCorporationWithBusinessNam_FileArticlesOfContinuance-> ");


        partnerSoleProprietorshipRegistrationPage.selectRegistryAsIncorporateOntarioBusinessCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAsNumberAndSaveIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();

//        partnerPortalLandingPage.searchByEntity(partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal());

        String oCN = partnerPortalLandingPage.getCompletedOntarioCorporationNumber();
        System.out.println("Incorporate an Ontario Not-for-Profit Corporationn Number (OCN) number is: " + oCN);
        Reporter.log("Incorporate an Ontario Not-for-Profit Corporation Corporation Number (OCN) number is: " + oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation(oCN);

        partnerPortalLandingPage.selectRegisterABusinessName();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
       soIncorporateOntarioBusinessCorporationPage.completeRegisterBusinessNameForNotForProfitCorporation();
//        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();

        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchByEntity(oCN);
//        soIncorporateOntarioBusinessCorporationPage.fileArticlesOfDissolutionOption();
        partnerPortalLandingPage.fileArticlesOfAuthorizationContinueOutOfBusiness();
//        partnerPortalLandingPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
//        partnerPortalLandingPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeFileArticlesOfContinuance();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        soIncorporateOntarioBusinessCorporationPage.reviewDashboardAndApproveFromWorkQueueEP(oCN);
        soIncorporateOntarioBusinessCorporationPage.reviewDashboardAndApproveFromWorkQueueEP(oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchByEntity(oCN);
        partnerPortalLandingPage.instrumentOfContinuance();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationInstrumentOfContinuanceAndSave();
        partnerPortalLandingPage.instrumentOfContinuanceAuthorization();


        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.verifyFileArticlesOfContinuance());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.verifyFileArticlesOfContinuanceBusinessName());
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);

    }
}
