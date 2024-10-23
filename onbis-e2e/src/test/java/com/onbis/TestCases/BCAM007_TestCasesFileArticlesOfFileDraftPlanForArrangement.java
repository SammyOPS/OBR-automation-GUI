package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class BCAM007_TestCasesFileArticlesOfFileDraftPlanForArrangement extends SOAccountSetUp {

    /*
006	ONBIS\System Integration Testing\BCA\BCAM007 – File Draft Plan for Arrangement


"Test that user (Public Portal) is able to file a request to review a draft Plan of Arrangement for an active Ontario Business Corporation (entity type A) as per the requirements under the Business Corporations Act.

BCA corporation:
Corp Name: English and French equivalent
Legal Element: Incorporated / Incorporée

Preconditions
• The user must be logged in to ONBIS.
• The user has selected the corporation that is an active Ontario Business Corporation (A)
• The user has authority to maintain the corporation."

1	Select "File Draft Plan for Arrangement" from the menu
2	Accept Terms and Conditions
3	Ensure contact info pre-populated correctly
4	Click on "Next Step" button
5	Enter text for "Summary of Changes"
6	Click on "Upload" button to upload a PDF file for Draft Plan of Arrangement
7	Click on "Upload" button to upload a PDF file for Draft Court Order
8	Click on "Submit" button

     */
    @Test
    public void BCAM007_TestCasesFileArticlesOfFileDraftPlanForArrangement() throws InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();

        paymentConfirmationPage.paymentConfirmationElementsAreDisplayed();
//        soAccountLandingPage.selectServiceOntarioBusinessRegistry();
        soIncorporateOntarioBusinessCorporationPage.GeneralDetailsOCNwriteToCSV( ("BCAM007_TestCasesFileArticlesOfFileDraftPlanForArrangement"));
        viewCorporationPage.FileArticlesOfFileDraftPlanForArrangement();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeFileArticlesOfFileDraftPlanForArrangement();
//        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();

        Assert.assertTrue(viewCorporationPage.DraftPlanForArrangement());
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
    }

}