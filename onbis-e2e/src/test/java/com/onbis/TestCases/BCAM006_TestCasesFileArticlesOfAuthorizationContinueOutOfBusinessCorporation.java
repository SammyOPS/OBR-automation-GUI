package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class BCAM006_TestCasesFileArticlesOfAuthorizationContinueOutOfBusinessCorporation extends SOAccountSetUp {

    /*
026	ONBIS\System Integration Testing\BCA\BCAM006 – Authorization to Continue Out


    1	Select "Apply for Authorization to Continue out of the BCA Form Heading" from the menu
    2	Accept Terms and Conditions
    3	Ensure contact info pre-populated correctly
    4	Click on "Next Step" button
    5	Ensure the Amalgamation date is correct
    6	Select "The corporation is applying to continue under the laws of a jurisdiction outside Canada, and this application is accompanied by a legal opinion to the effect that the laws of the other jurisdiction meet the requirements set out in subsection 181(9) of the Act." for "Please select the option that applies:"
    7	Select "Cuba" for "Select the jurisdiction where the corporation is applying to continue"
    8	Click on "Upload" button to upload a PDF file for "Legal Opinion", the size of file is 6MB


     */
    @Test
    public void BCAM006_TestCasesFileArticlesOfAuthorizationContinueOutOfBusinessCorporation() throws InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();

        paymentConfirmationPage.paymentConfirmationElementsAreDisplayed();
//        soAccountLandingPage.selectServiceOntarioBusinessRegistry();
        soIncorporateOntarioBusinessCorporationPage.GeneralDetailsOCNwriteToCSV( ("BCAM006_TestCasesFileArticlesOfAuthorizationContinueOutOfBusinessCorporation"));
        viewCorporationPage.fileArticlesOfAuthorizationContinueOutOfBusiness();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completefileArticlesOfAuthorizationContinueOutOfBusiness();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        Assert.assertTrue(viewCorporationPage.businessCorporationFileArticlesOfContinueOutOfBusiness());
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
    }

}