package com.onbis.TestCases;

import com.onbis.Helper.Config;
import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.onbis.Helper.EmailUtils.emailransactionNumberTIsDisplayed;

@Listeners(ListenersTestNG.class)
public class BCAM002_TestCasesFileArticlesOfAmendmenOntarioBusinessCorporation extends SOAccountSetUp {

    /*
112-ONBIS\System Integration Testing\BCA\BCAM002 – Amend an Ontario Business Corporation

Test that user (Public Portal) is able to file an Amendment for an active Ontario business corporation as per the requirements under the Business Corporations Act
1	Select "Amend an Ontario Business Corporation" from the menu
2	Accept Terms and Conditions
3	Ensure contact info pre-populated correctly
4	Click on "Next Step" button
5	Ensure corporation Name is populated correctly
6	Click on "Number of Directors" tab
7	Ensure the current number of directors is correct.
8	Click on  "Shares & Provisions" tab
9	Enter text for "Description of Classes of Shares"
10	Enter text for "Rights, Privileges, Restrictions and Conditions"
11	"Enter text for ""Restrictions on Share Transfers """
12	Enter text for "Restrictions on Business or Powers"
13	Enter text for "Other Provisions, if any"
14	Click on "Authorization" tab
15	Select checkbox for "Shareholder/Directors Authorization and Effective Date"
16	Select 1 day lesser than the current date for "The resolution authorizing the amendment was approved by the shareholders/directors (as applicable) of the corporation on (may not be a future date):"
17	Select 2 days greater than the current date for "Requested Date for Amendment"
18	Click on "Generate PDF" button
19	Click on "Submit" button

     */
    @Test
    public void BCAM002_TestCasesFileArticlesOfAmendmenOntarioBusinessCorporation() throws InterruptedException, IOException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();

        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();

        paymentConfirmationPage.paymentConfirmationElementsAreDisplayed();
//        soAccountLandingPage.selectServiceOntarioBusinessRegistry();

        viewCorporationPage.fileArticlesOfAmendmentOfIncorporation();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completefileArticlesOfAmendmentOfIncorporation();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        soIncorporateOntarioBusinessCorporationPage.GeneralDetailsOCNwriteToCSV ("BCAM002_TestCasesFileArticlesOfAmendmenOntarioBusinessCorporation");
        Assert.assertTrue(viewCorporationPage.businessCorporationFileArticlesOfAmendment());
        emailransactionNumberTIsDisplayed (Config.MAILINATOR_API_KEY, Config.MAILINATOR_EMAIL_ADDRESS);
    }

}