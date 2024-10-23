package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.awt.*;
import java.io.IOException;

@Listeners(ListenersTestNG.class)
public class TC28_BCAR003_TestCasesForAmalgamation extends SOAccountSetUp {

    /*
    28. Articles of Amalgamation: "BCAR003 - test cases for Amalgamation"
     */
    @Test
    public void TC28_BCAR003_TestCasesForAmalgamation() throws
            InterruptedException, IOException, AWTException {
        osbAccountCatalogPage.selectRegistrationTypeAsIncorporateAnOntarioBusinessCorporation();
        oneKeyLogin.loginUsingOneKeyCredentials();
        soAccountLandingPage.selectAddProfile();
        soAccountLandingPage.completeProfileDetailsAndSave();
        Thread.sleep(2000);
        soIncorporateOntarioBusinessCorporationPage.acceptTermsAndConditions();
        soIncorporateOntarioBusinessCorporationPage.completeContactInformationAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeCorporationWithNumberAndSave();

        paymentConfirmationPage.paymentConfirmationElementsAreDisplayed();
//        soAccountLandingPage.selectServiceOntarioBusinessRegistry();

        viewCorporationPage.selectFileArticleOfAmalgamation();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        fileArticlesOfAmalgamationPage.completeAmalgamatingCorporationsAndSave();
        fileArticlesOfAmalgamationPage.completeMethodOfAmalgamationAndSave();
        fileArticlesOfAmalgamationPage.updateMethodOfAmalgamationAndSave();
//        fileArticlesOfAmalgamationPage.completeCorporationNameAndSave(); // Changed to completeFileArticlesOfAmalgamationCorporationNameAndSave function
        fileArticlesOfAmalgamationPage.completeFileArticlesOfAmalgamationCorporationNameAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
 //       driver.navigate().to(driver.getCurrentUrl());
        partnerSoleProprietorshipRegistrationPage.completeAddressFileADeceleration(); // Changed to completeAddressFileArticlesOfAmalgamationAddressSaveAndContinue function
//        partnerSoleProprietorshipRegistrationPage.completeAddressFileArticlesOfAmalgamationAddressSaveAndContinue();
//        driver.navigate().to(driver.getCurrentUrl());
        soIncorporateOntarioBusinessCorporationPage.directorsSaveAndContinue();// completeDirectorsAndSave();
//        driver.navigate().to(driver.getCurrentUrl());
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());

        Assert.assertTrue(viewCorporationPage.corporationFileStatusUpdatedToAmalgamated());
//        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
//        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

}