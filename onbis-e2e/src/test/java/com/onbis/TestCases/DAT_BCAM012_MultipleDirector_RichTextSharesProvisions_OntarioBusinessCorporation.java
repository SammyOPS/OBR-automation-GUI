package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class DAT_BCAM012_MultipleDirector_RichTextSharesProvisions_OntarioBusinessCorporation extends SOAdminSetup {

    /*
        \\cihs.ad.gov.on.ca\MPBSD\Groups\LEGACY\gsdptovspifs002\MGS-Shared$\SO-PMO\Active PROJECTS\Business Development\BST\BST 2016-17\BST Projects By Portfolio\Registry Projects\ONBIS\NEW ONBIS\QA\WIP-2023\Automation\Presentation_Automation Scripts
            Steps for pre-condition data:
                Precondition Condition:

                BCAM012-PRE-	The user must be logged in to ONS'S Users include External User with Authority (e A. Joe Public. Lawyer)
                Admin User (e A. ServiceOntario Registry staff)
                BCAM012-PRE-	The selected Ontario Business Corporation (A) hes Status = "Inactive"
                BCAM012-PRE-	The selected Ontario Business Corporation (A) hes one of the following Sub-statuses:
                Cancelled Sy OS.C
                Cancelled by C
                Cancelled Sy C Cancelled Sy MOF
                BCAM012-PRE-	'Inactive Date' must not Se more than 20 years agc
                BCAM012-PRE-	The user has authority to maintain the corporatiorL Authority is resolved as follows:
                External User with Authority has authority over the corporation
                Admin User has the appropriate permission to maintain the corporation

                Revive an Ontario Business Corporation

                1)	Login into ONBIS Admin Portal
                2)	Create Ontario Corporation
                3)	Get Corporation cancelled
                4)	Open Corporation with the status Inactive
                5)	Select Make Changes, File Articles of Revival
                6)	Enter Official Email, Confirm Official Email
                7)	Click Continue
                8)	Enter Contact Information, click Continue
                9)	System displays "Corporation Name" screen System displays the corporation’s name with legal element correctly., Click on "Next Step" button
                10)	On "Address" screen enter a valid postal code for "Registered Office Address"
                11)	Click on "Save and Continue" button
                12)	Select checkbox for "Required Statements"
                13)	Click on “Save and Continue” button
                14)	On Applicant screen enter required information (Applicant Name, Applicant interest in the corporation, Address)
                15)	On Review Authorization screen review information, select Authorization check box
                16)	Click Submit
                17)	Select Payment Method of Payment <CASH> on Fee Payment screen
                18)	Click Continue
                19)	Finalize Transaction

     */
    @Parameters({"browser"})
    @Test  (invocationCount = 10)
    public void DAT_BCAM012_MultipleDirector_RichTextSharesProvisions_OntarioBusinessCorporation(String browser) throws IOException, InterruptedException, AWTException {


        Reporter.log("-------: DAT_BCAM012_MultipleDirector_RichTextSharesProvisions_OntarioBusinessCorporation -> ");
        mgcsAdminLandingPage.launchAdminPortal();
        partnerSoleProprietorshipRegistrationPage.selectRegistryAsIncorporateOntarioBusinessCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAsNumberAndSaveIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.multipleDirectorsAndSave(20);//completeDirectorsAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsSampleRichTextAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        Reporter.log("Ontario Corporation Number (OCN) - " + partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal() +" has been added");
        System.out.println("Ontario Corporation Number (OCN) - " + partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal() +" has been added");


//        partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal();
//        partnerPortalLandingPage.searchByEntity(partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal());
//        partnerSoleProprietorshipRegistrationPage.ontarioBusinessIncorporationUpdateSubStatusCancelledByCB();
//        partnerSoleProprietorshipRegistrationPage.fileArticlesOfRevivalMakeChanges();
//        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeAddressAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeRequiredStatementsFileArticlesOfRevival();
//        soIncorporateOntarioBusinessCorporationPage.completeApplicantAndSave();
//        partnerSoleProprietorshipRegistrationPage.reviewAuthorizationAndSubmit();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
//
//        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.reviveAnOntarioBusinessCorporationVerification());



    }
}
