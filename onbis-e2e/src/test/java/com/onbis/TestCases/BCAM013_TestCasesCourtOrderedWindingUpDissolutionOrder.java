package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class BCAM013_TestCasesCourtOrderedWindingUpDissolutionOrder extends SOAccountSetUp {

    /*
        006	ONBIS\System Integration Testing\BCA\BCAM013bd– Court-ordered Winding Up – Dissolution Order
        ONBIS_SIT_SO PORTAL_BCA_BCAM013d_Output_11006
        "Test that user (Public Portal) is able to initiate the court-ordered winding up of an active Ontario Business Corporation (A)
        as per the requirements for Notice Concerning Winding Up under the Business Corporations Act (BCA).


        "Test that user (Public Portal) is able to dissolve an Ontario Business Corporation (A) as per the requirements for Articles of Dissolution under the Business Corporations Act (BCA).

        BCA corporation:
        Corp Name: English and French equivalent
        Legal Element: Inc. / Inc.

        Preconditions
        • The user must be logged in to ONBIS.
        • The user has selected the corporation that is an active Ontario Business Corporation (A)
        • The user has authority to maintain the corporation."


        1	Select "Court-ordered Winding Up – Dissolution Order" from the menu
        2	Accept Terms and Conditions
        3	Ensure contact info pre-populated correctly
        4	Click on "Next Step" button
        5	Select current date for "Dissolution Date"
        6	Click on "Upload" button to upload a copy of the Court Order
        7	Click on "Generate PDF" button
        8	Select checkbox for "Authorization'
        9	Click on "Submit" button


     */
    @Test
    public void BCAM013_TestCasesCourtOrderedWindingUpDissolutionOrder() throws InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();

        paymentConfirmationPage.paymentConfirmationElementsAreDisplayed();
//        soAccountLandingPage.selectServiceOntarioBusinessRegistry();
        soIncorporateOntarioBusinessCorporationPage.GeneralDetailsOCNwriteToCSV( ("BCAM013_TestCasesCourtOrderedWindingUpDissolutionOrder"));
        viewCorporationPage.courtOrderedWindingUpDissolutionOrder();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCourtOrderedWindingUpDissolutionOrder();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();

        Assert.assertTrue(viewCorporationPage.businessCorporationCourtOrderedWindingUpDissolutionOrder());
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
    }

}