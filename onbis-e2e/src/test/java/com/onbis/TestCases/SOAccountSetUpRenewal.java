package com.onbis.TestCases;

import com.onbis.Pages.*;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class SOAccountSetUpRenewal extends SOAccountSetUp {

    OneKeyLogin oneKeyLogin;
    SOAccountLandingPage soAccountLandingPage;
    SOAddServicePage soAddServicePage;
    OSBAccountCatalogPage osbAccountCatalogPage;
    SOIncorporateOntarioBusinessCorporationPage soIncorporateOntarioBusinessCorporationPage;
    SOPaymentConfirmationPage paymentConfirmationPage;
    ViewCorporationPage viewCorporationPage;
    PartnerTermsAndConditionsPage partnerTermsAndConditionsPage;
    ContactInformationPage contactInformationPage;
    FileArticlesOfAmalgamationPage fileArticlesOfAmalgamationPage;
    PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage;

    @BeforeMethod(alwaysRun = true)
    void soSetUp() throws IOException {
        oneKeyLogin = new OneKeyLogin(driver);
        soAccountLandingPage = new SOAccountLandingPage(driver);
        soAddServicePage = new SOAddServicePage(driver);
        osbAccountCatalogPage = new OSBAccountCatalogPage(driver);
        soIncorporateOntarioBusinessCorporationPage = new SOIncorporateOntarioBusinessCorporationPage(driver);
        paymentConfirmationPage = new SOPaymentConfirmationPage(driver);
        viewCorporationPage = new ViewCorporationPage(driver);
        partnerTermsAndConditionsPage = new PartnerTermsAndConditionsPage(driver);
        contactInformationPage = new ContactInformationPage(driver);
        fileArticlesOfAmalgamationPage = new FileArticlesOfAmalgamationPage(driver);
        partnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver);
    }

}
