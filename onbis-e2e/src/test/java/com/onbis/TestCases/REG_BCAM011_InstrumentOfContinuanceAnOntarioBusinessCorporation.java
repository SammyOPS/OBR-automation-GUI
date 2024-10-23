package com.onbis.TestCases;

import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(ListenersTestNG.class)
public class REG_BCAM011_InstrumentOfContinuanceAnOntarioBusinessCorporation extends SOAdminSetup {

    /*


                Precondition Condition:

                Preconditions
                Precondition Description Ref
                BCAM011-PRE-01
                The user must be logged in to ONBIS. Users include: • ServiceOntario Account Portal user (Joe Public) • Partner Portal User (Lawyer) • Admin Portal User (ServiceOntario Registry staff)
                BCAM011-PRE-02
                The user has selected the active corporation that is one of the following entity types: • Ontario Business Corporation (A)
                BCAM011-PRE-03
                • The user must have authority over the Corporation • An Application for Authorization to Continue out of BCA has been submitted within the past 6 months, otherwise menu option will not be available.
                3.3 Service Information

            Steps for pre-condition data:
              Instrument of Continuance

                1)	Login into ONBIS Admin Portal
                2)	Create Ontario Corporation
                3)	Select "File Application for Authorization Articles of Continuance" from the menu
                4)	Enter email, confirm email, click <Continue>
                5)	Enter mandatory info into the Contact Information form
                6)	Click Continue
                7)	Select first option under the options that applies
                8)	Select the jurisdiction where the corporation is applying to continue
                9)	Select the boxes for what corporation confirms…
                10)	Select the option under Offering Security
                11)	Generate PDF
                12)	Select Authorization
                13)	Click Submit
                14)	Select Payment Method on Fee Payment screen
                15)	Click Continue
                16)	Finalize transaction
                Application sent for approval
                17)	Go to Work Queue and Approve transaction

    */
    @Test // (invocationCount = 3)
    public void REG_BCAM011_InstrumentOfContinuanceAnOntarioBusinessCorporation() throws InterruptedException, AWTException {

        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: REG_BCAM011_InstrumentOfContinuanceAnOntarioBusinessCorporation-> ");


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

        String oCN = partnerPortalLandingPage.getCompletedOntarioCorporationNumber();
        System.out.println("Corporationn Number (OCN) number is: " + oCN);
        Reporter.log("Ontario Corporation Number (OCN) number is: " + oCN);
        HelperMethods.writeToCSV("REG_BCAM011_InstrumentOfContinuanceAnOntarioBusinessCorporation", oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        partnerPortalLandingPage.searchCorporationAndSelectResultByOntarioCorporation(oCN);


        partnerPortalLandingPage.fileArticlesOfAuthorizationContinueOutOfBusiness();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationRegisterBusinessNameAndSave();
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
  //      Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.verifyFileArticlesOfContinuanceBusinessName());


    }
}
