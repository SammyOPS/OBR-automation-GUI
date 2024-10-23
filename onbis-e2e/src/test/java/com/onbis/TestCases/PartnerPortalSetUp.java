package com.onbis.TestCases;

import com.onbis.Helper.EmailUtils;
import com.onbis.Pages.*;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class PartnerPortalSetUp extends BaseTestPartnerPortal {
    PartnerPortalLoginPage partnerPortalLoginPage;
    PartnerTermsAndConditionsPage partnerTermsAndConditionsPage;
    PartnerPortalLandingPage portalLandingPage;
    ContactInformationPage contactInformationPage;
    PartnerSoleProprietorshipRegistrationPage partnerSoleProprietorshipRegistrationPage;
    SOIncorporateOntarioBusinessCorporationPage soIncorporateOntarioBusinessCorporationPage;
    PartnerSearchRegistryPage partnerSearchRegistryPage;
    ViewCorporationPage viewCorporationPage;
    PartnerPortalLandingPage partnerPortalLandingPage;

    @BeforeMethod(alwaysRun = true)
    void partnerPortalSetUp() throws IOException {
        partnerPortalLoginPage = new PartnerPortalLoginPage(driver);
        partnerTermsAndConditionsPage = new PartnerTermsAndConditionsPage(driver);
        portalLandingPage = new PartnerPortalLandingPage(driver);
        contactInformationPage = new ContactInformationPage(driver);
        partnerSoleProprietorshipRegistrationPage = new PartnerSoleProprietorshipRegistrationPage(driver);
        soIncorporateOntarioBusinessCorporationPage = new SOIncorporateOntarioBusinessCorporationPage(driver);
        partnerSearchRegistryPage = new PartnerSearchRegistryPage(driver);
        viewCorporationPage = new ViewCorporationPage(driver);
        partnerPortalLandingPage = new PartnerPortalLandingPage(driver);
    }

}
