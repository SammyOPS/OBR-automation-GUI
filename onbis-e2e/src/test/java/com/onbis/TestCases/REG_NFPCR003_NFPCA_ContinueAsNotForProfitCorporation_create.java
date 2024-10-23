package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class REG_NFPCR003_NFPCA_ContinueAsNotForProfitCorporation_create extends SOAdminSetup {


    /*

        Precondition Description:
            NFPCMO11-PRE-0L
            The user must be logged in to ONBIS. Users include:
            External User with Authority (e.g Joe Public, Lawyer)
            Admin User (e.g. ServiceOntario Registry staff]
         Steps to reproduce:
           NFPCR003-Continue as a Not-For-Profit Corporation (create)
                1)	Login into ONBIS Admin Portal
                2)	Select Register Services=>Corporations=>File Articles of Continuance under the Not-for-Profit Corporations Act, 2010
                3)	Provide Corporation Name to determine if the corporation if the corporation exists in our record, click Search
                4)	Select check box to confirm that the corporation has never been assigned an Ontario Corporation Number, click Proceed
                5)	On Contact Information screen add First Name (mandatory), Middle Name (Optional) with value, Last Name (mandatory), Email address (mandatory),
                Upload NFPCA-Article of Continuance, click Continue
                6)	On Jurisdiction form add all required information, click Save and Continue
                7)	On Name form select if Corporation will have Number name, Requested Day of Continuance, Primary Activity, office email. Click Save and Continue
                8)	On Address form add Registered Office address. Click Save and Continue
                9)	On Directors form specify Number of Directors => Fixed Number of Directors
                Add info for 3 Directors, click Save and Continue
                10)	 Add all required information on Purposes and Provisions form
                Select No for Is the corporation a charity or does it intend to operate as a charity?
                Select Save and Continue
                11)	On Required Statements form select all check boxes and specify Authorization Day, click Save and Continue
                12)	Review information on ‘Review and Authorization’ form, select check box for Authorization
                13)	Generate PDF
                14)	Click Submit
                15)	On Payment screen select Method of Payment, click Continue
                16)	Finalize transaction
                17)	The transaction has status ‘Review’ and required Approval
                18)	Get to Work Queue page, search for the entity
                19)	Click ‘Do It Now’
                20)	Approve Form
                21) After form approval the transaction completed

      */
    @Parameters({"browser"})
    @Test //(invocationCount = 3)
    public void REG_NFPCR003_NFPCA_ContinueAsNotForProfitCorporation_create() throws InterruptedException, AWTException, IOException {

        mgcsAdminLandingPage.launchAdminPortal();
        Reporter.log("-------: REG_NFPCR003_NFPCA_ContinueAsNotForProfitCorporation_create-> ");
        soAdminOntarioBusinessRegistryDashboardPage.selectFileArticlesOfContinuanceUnderTheNotForProfitCorporationsAct();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationarticlesOfContinuanceNFPCAAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameFileArticlesOfContinuanceUnderNotForProfitCorporationsAct();
        soIncorporateOntarioBusinessCorporationPage.addThreeDirectorsAndSave();
//        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSaveLLP());
//        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
//        soIncorporateOntarioBusinessCorporationPage.completeThreeDirectorsSave();
        soIncorporateOntarioBusinessCorporationPage.purposesAndProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.requiredStatements();
        soIncorporateOntarioBusinessCorporationPage.reviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        soAdminOntarioBusinessRegistryDashboardPage.proceedButton();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationarticlesOfContinuanceNFPCAAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameFileArticlesOfContinuanceUnderNotForProfitCorporationsAct();
        soIncorporateOntarioBusinessCorporationPage.addThreeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.purposesAndProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.requiredStatements();
        soIncorporateOntarioBusinessCorporationPage.reviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        soAdminOntarioBusinessRegistryDashboardPage.proceedButton();
        Thread.sleep(3000);
        String oCN = partnerPortalLandingPage.getCompletedOntarioCorporationNumber();
        System.out.println("Incorporate an Ontario Not-for-Profit Corporationn Number (OCN) number is: " + oCN);
        Reporter.log("Incorporate an Ontario Not-for-Profit Corporation Corporation Number (OCN) number is: " + oCN);
        partnerPortalLandingPage.searchByEntity(partnerPortalLandingPage.getCompletedCorporationNumberAdminPortal());
        soIncorporateOntarioBusinessCorporationPage.fileArticlesOfArrangement();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationFinalPlanOfArrangementAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeFinalPlanOfArrangementNotforProfitCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        soIncorporateOntarioBusinessCorporationPage.reviewDashboardAndApproveFromWorkQueueEP(oCN);
        partnerPortalLandingPage.selectSearchRegistry();
        Thread.sleep(2000);
        partnerPortalLandingPage.searchByEntity(oCN);
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.reviveAnNFPCA_ARTICLES_OF_ARRANGEMENT());

    }
}
