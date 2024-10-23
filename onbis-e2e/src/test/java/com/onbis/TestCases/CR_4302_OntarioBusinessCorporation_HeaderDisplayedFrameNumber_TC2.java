package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.HelperMethods;
import com.onbis.Helper.ListenersTestNG;
import com.onbis.Pages.PartnerPortalLandingPage;
import com.onbis.Pages.PartnerSoleProprietorshipRegistrationPage;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class CR_4302_OntarioBusinessCorporation_HeaderDisplayedFrameNumber_TC2 extends PartnerPortalSetUp {

    /*
        2	CAV001 - View Corporation	Microfiche Roll Number and Microfiche Starting Frame Number is displayed only to internal admin users while using view service	PartnerAdmin	Microfiche Roll exists for ON Corp selected	Corp	"- Log into the Partner portal
            -Enter OCN#  entered in column H
            - Navigation: Services > Search the Registry
            -Click on Advanced
            - Select the exact match checkbox
            -Click on Search
            -Click on Filings tab
            - Archive Document Package is one of the options under Filing Name column
            -Take a screenshot and save it in the word template"	"566079

            ""LA BEAUTE FRANCAISE INC. THE FRENCH BEAUTY INC."""	Header is correctly displayed with no Microfiche Roll Number and Microfiche Frame number in the heading

     */
    @Test
    public void CR_4302_OntarioBusinessCorporation_HeaderDisplayedFrameNumber_TC2() throws IOException, InterruptedException {
        Reporter.log("-------: CR_4302_OntarioBusinessCorporation_HeaderDisplayedFrameNumber_TC2-> ");
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();

        partnerSoleProprietorshipRegistrationPage.selectRegistryAsIncorporateOntarioBusinessCorporation();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();

        soIncorporateOntarioBusinessCorporationPage.completeCorporationNameAsNumberAndSaveIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmitIncorporation();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentCashIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        String results = partnerPortalLandingPage.searchByEntity(partnerPortalLandingPage.getCompletedCorporationNumber());
        String bName = Config.ONTARIO_BUSINESS_CORPORATION_NAME;
        System.out.println(results);
        if (results.contains("No results"))
        {
            results = partnerPortalLandingPage.searchByEntity(bName);
            System.out.println(results);
            String FrameNumber = HelperMethods.getNumberFromString(results,"\\d+") ;
            System.out.println(FrameNumber);
        }
        String FrameNumber = HelperMethods.getNumberFromString(results,"\\d+") ;
        partnerSoleProprietorshipRegistrationPage.verifyOntarioBusinessCorporation_HeaderDisplayedFrameNumber(FrameNumber);
        System.out.println("Ontario Business Incorporation Business number is: " + FrameNumber);
        File resourcesDirectory = new File("src/main/resources");
        HelperMethods.writeToTextFile(resourcesDirectory +"/"+System.getenv("ENV")+"_CR_4302_OntarioBusinessIncorporation.txt",FrameNumber);


    }
}