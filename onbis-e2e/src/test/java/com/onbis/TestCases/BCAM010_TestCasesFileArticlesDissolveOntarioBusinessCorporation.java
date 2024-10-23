package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class
BCAM010_TestCasesFileArticlesDissolveOntarioBusinessCorporation extends SOAccountSetUp {

    /*
        021	ONBIS\System Integration Testing\BCA\BCAM010 – Dissolve an Ontario Business Corporation


        "Test that user (Public Portal) is able to dissolve an Ontario Business Corporation (A) as per the requirements for Articles of Dissolution under the Business Corporations Act (BCA).

        BCA corporation:
        Corp Name: English and French equivalent
        Legal Element: Inc. / Inc.

        Preconditions
        • The user must be logged in to ONBIS.
        • The user has selected the corporation that is an active Ontario Business Corporation (A)
        • The user has authority to maintain the corporation."


        1	Select "Dissolve an Ontario Business Corporation" from the menu
        2	Accept Terms and Conditions
        3	Ensure contact info pre-populated correctly
        4	Click on "Next Step" button
        5	Select option "The corporation has not commenced business, has not issued shares, and all of the incorporators (or their personal representatives) have authorized the dissolution." for "Select the statement that applies to the corporation:"
        6	Select checkbox "There are no proceedings pending in any court against the corporation."
        7	Select checkbox "The dissolution has been duly authorized under clause 237(c) of the Business Corporations Act."
        8	Select checkbox "The corporation has no debts, obligations or liabilities."
        9	Selection option "Distributed its remaining property to the persons entitled to it." for "After satisfying the interest of creditors, in all its debts, obligations and liabilities, if any, the corporation has:"
        10	Select checkbox "If it was at any time a registered owner of land in Ontario, that it is no longer a registered owner of land in Ontario."
        11	Select option "A specific date up to 30 days from the current date, based on MOF review." for "Select the Requested Date for Dissolution:"
        12	Select the current date for "Requested Date for Dissolution"
        13	Click on "Generate PDF" download a file
        14	Select checkbox for "Authorization"
        15	Click on "Submit" button

     */
    @Test
    public void BCAM010_TestCasesFileArticlesDissolveOntarioBusinessCorporation() throws InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();

//        paymentConfirmationPage.paymentConfirmationElementsAreDisplayed();
        soAccountLandingPage.selectServiceOntarioBusinessRegistry();

        viewCorporationPage.fileArticlesOfDissolveOfIncorporation();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeFileArticlesDissolveCorporation();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        soIncorporateOntarioBusinessCorporationPage.confirmSentForReview();
        soIncorporateOntarioBusinessCorporationPage.SOAccountHomepageOCNwriteToCSV ("BCAM010_TestCasesFileArticlesDissolveOntarioBusinessCorporation");
        Assert.assertTrue(viewCorporationPage.businessCorporationFileArticlesOfDissolution());
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
    }

}