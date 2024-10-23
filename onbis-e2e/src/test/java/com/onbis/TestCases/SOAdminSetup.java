package com.onbis.TestCases;

import com.onbis.Pages.*;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class SOAdminSetup extends BaseTestSOAdmin {
    OneKeyLogin oneKeyLogin;
    SOAccountLandingPage soAccountLandingPage;
    SOAddServicePage soAddServicePage;
    OSBAccountCatalogPage osbAccountCatalogPage;
    SOIncorporateOntarioBusinessCorporationPage soIncorporateOntarioBusinessCorporationPage;
    SOPaymentConfirmationPage paymentConfirmationPage;
    PKIProfileSingnInPage pkiProfileSingnInPage;
    MGCSAdminLandingPage mgcsAdminLandingPage;
    SOAdminOntarioBusinessRegistryDashboardPage soAdminOntarioBusinessRegistryDashboardPage;
    PartnerPortalLandingPage partnerPortalLandingPage;
    PartnerPortalLandingPage portalLandingPage;
    PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage;
    ViewCorporationPage viewCorporationPage;
    PartnerTermsAndConditionsPage partnerTermsAndConditionsPage;
    ContactInformationPage contactInformationPage;

    @BeforeMethod(alwaysRun = true)
    void soSetUp() throws IOException {
        oneKeyLogin = new OneKeyLogin(driver);
        soAccountLandingPage = new SOAccountLandingPage(driver);
        soAddServicePage = new SOAddServicePage(driver);
        osbAccountCatalogPage = new OSBAccountCatalogPage(driver);
        soIncorporateOntarioBusinessCorporationPage = new SOIncorporateOntarioBusinessCorporationPage(driver);
        paymentConfirmationPage = new SOPaymentConfirmationPage(driver);
        pkiProfileSingnInPage = new PKIProfileSingnInPage(driver);
        mgcsAdminLandingPage = new MGCSAdminLandingPage(driver);
        soAdminOntarioBusinessRegistryDashboardPage = new SOAdminOntarioBusinessRegistryDashboardPage(driver);
        partnerPortalLandingPage = new PartnerPortalLandingPage(driver);
        partnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver);
        viewCorporationPage = new ViewCorporationPage(driver);
        partnerPortalLandingPage = new PartnerPortalLandingPage(driver);
        partnerTermsAndConditionsPage = new PartnerTermsAndConditionsPage(driver);
        contactInformationPage = new ContactInformationPage(driver);
    }
}
