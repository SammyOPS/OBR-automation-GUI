package com.onbis.TestCases;

import com.onbis.Helper.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Listeners(ListenersTestNG.class)
public class PartnerRegisterABusinessTests extends PartnerPortalSetUp {

    /*
    13. Register a Business Name for a Sole Proprietorship
     */
    @Test
    public void whenUserCompletesSoleProprietorshipForBusiness_UserSeeBusinessNameForSoleProprietorshipRegistered() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectSoleProprietorshipOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeOwnerAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

    /*
    12. Register an Extra-Provincial Limited Liability Company Name
     */
    @Test
    public void whenUserCompletesExtraProvincialLimitedLiabilityRegistration_UserSeesEPLLRegistered() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectEPLLService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSaveExtraProvincial();

        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraProvincialIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

    /*
    15. Register Business Name for General Partnership
     */
    @Test
    public void whenUserCompletesGeneralPartnershipRegistration_UserSeesGeneralPartnershipRegistered() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectGeneralPartnerShipRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

    /*
    11. Register a Business Name for a Corporation
     */
    @Parameters({"browser"})
    @Test
    public void whenUserCompletesBusinessCorporationRegistration_UserSeesBusinessCorporationRegistered(String browser) throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectOntarioBusinessCorporationRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeCorporationNameAndSave(browser));
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.ontarioBusinessCorporationIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

    /*
    14. Register Business Name for Limited Partnership
     */
    @Test
    public void whenUserCompletesDeclarationOfExtraProvincialLimitedPartnershipRegistration_UserSeesPartnershipFiledForEPLP() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectEPLLPRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completePowerOfAttorneyAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedPartnershipIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

    /*
    16. Amend a Registration of a Business Name for a General Partnership
     */
    @Parameters({"browser"})
    @Test
    public void whenUserCompleteAmendBusinessNameRegistrationForGP_UserSeesBusinessNameUpdated(String browser) throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectGeneralPartnerShipRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectRegisterBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.updateCorporationNameAndSave(browser));
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();

        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectAmendOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeConsent();
        partnerSoleProprietorshipRegistrationPage.selectPartners();
        partnerSoleProprietorshipRegistrationPage.changePrincipalPlaceOfBusinessAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSave();
        partnerSoleProprietorshipRegistrationPage.selectAmendBusinessSubmitButton();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.generalPartnershipNameIsUpdated());
    }

    /*
    18. Amend an Extra-Provincial Limited Liability Company Name
     */
    @Parameters({"browser"})
    @Test
    public void whenUserCompleteAmendExtraProvincialLimitedLiabilityCompany_UserSeesCompanyNameUpdated(String browser) throws IOException, InterruptedException, MessagingException, GeneralSecurityException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectEPLLService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSaveExtraProvincial();

        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.selectSearchRegistry();

        partnerSoleProprietorshipRegistrationPage.extraProvincialIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectAmendOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSavePopUp();
        partnerSoleProprietorshipRegistrationPage.changePrincipalPlaceOfBusinessAndSave();
        partnerSoleProprietorshipRegistrationPage.completeConsent();
        partnerSoleProprietorshipRegistrationPage.contactName();
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSubmit();
        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedLiabilityIsUpdated());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }

    /*
    19. Register and Amend a Sole Proprietorship
     */
    @Test
    public void whenUserCompletesAmendSoleProprietorshipForCorporation_UserSeeSoleProprietorshipUpdated() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectSoleProprietorshipOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completeOwnerAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.selectSearchRegistry();

        partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectAmendOption();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.updateEmail();
        partnerSoleProprietorshipRegistrationPage.selectAuthorizationAndSubmit();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.soleProprietorshipIsUpdated());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }

    /*
    25. Cancel a Registration of a Firm Name for a General Partnership
     */
    @Parameters({"browser"})
    @Test
    public void whenUserCompleteCancelBusinessNameRegistrationForGP_UserSeesBusinessNameCancelled(String browser) throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectGeneralPartnerShipRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectRegisterBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.updateCorporationNameAndSave(browser));
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();

        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered();
        portalLandingPage.selectSearchResult();

        portalLandingPage.selectCancelBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.completeConsent();
        partnerSoleProprietorshipRegistrationPage.selectCancelConfirmationCheckBox();
        partnerSoleProprietorshipRegistrationPage.selectPartnersMultiple();
        partnerSoleProprietorshipRegistrationPage.selectCancelBusinessSubmitButton();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.generalPartnershipNameIsCancelled());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }

    /*
    17. Cancel Business Name Registration for Corporation
     */
    @Parameters({"browser"})
    @Test
    public void whenUserCancelsBusinessNameRegistrationForCorporation_RegistrationCancelledSuccessfully(String browser) throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectOntarioBusinessCorporationRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeCorporationNameAndSave(browser));
        soIncorporateOntarioBusinessCorporationPage.completeGeneralDetailsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeDirectorsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeSharesProvisionsAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeIncorporatorsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.ontarioBusinessCorporationIsRegistered();

        portalLandingPage.selectSearchResult();
        portalLandingPage.selectRegisterBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.updateBusinessName(browser));
        partnerSoleProprietorshipRegistrationPage.selectPrimaryActivity();
        partnerSoleProprietorshipRegistrationPage.selectSaveAndContinue();
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();

        portalLandingPage.selectSearchRegistry();
        partnerSoleProprietorshipRegistrationPage.ontarioBusinessCorporationIsRegistered();
        portalLandingPage.selectSearchResult();
        portalLandingPage.selectCancelBusinessName();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.cancelAuthorizationAndSubmit();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.businessNameRegistrationIsCancelled());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }

    /*
    20. File a Declaration of an Ontario Limited Partnership
     */
    @Test
    public void whenUserCompletesDeclarationOfOntarioLimitedPartnershipRegistration_UserSeesOLPRegistered() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectFileDecelerationOfOntarioLimitedPartnershipService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();

        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressFileADeceleration();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit();
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.ontarioLimitedPartnershipIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
    }

    /*
    23. Register a Firm Name for an Ontario Limited Liability Partnership
     */
    @Test
    public void whenUserCompletesRegisteringFirmNameForOntarioLimitedLiabilityPartnership_UserSeesFirmNameRegistered() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectRegisterFirmNameForOntarioLimitedLiabilityService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();

        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSaveLLP());
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.selectPartnersMultiple();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.ontarioLimitedLiabilityPartnershipIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

    /*
    24. Register a Firm Name for an Extra-Provincial Limited Liability Partnership
     */
    @Test
    public void whenUserCompletesRegisteringFirmNameForExtraProvincialLimitedLiabilityPartnership_UserSeesFirmNameRegistered() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectRegisterFirmNameForExtraProvincialLimitedLiabilityService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();

        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSaveExtraProvincial());
        partnerSoleProprietorshipRegistrationPage.completeAddressSameAsAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.selectPartnersMultiple();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedLiabilityIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

    /*
    21. File a Declaration of an Extra-Provincial Limited Partnership
     */
    @Test
    public void whenUserCompletesDeclarationOfExtraProvincialLimitedPartnershipRegistration_UserSeesEXLPFiled() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectFileDecelerationOfExtraProvincialLimitedPartnershipService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();

        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completePowerOfAttorneyAndSave();
//        partnerSoleProprietorshipRegistrationPage.completeAddressFileADeceleration();
        soIncorporateOntarioBusinessCorporationPage.completeReviewAndAuthorizeAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.extraProvincialLimitedPartnershipIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }

    /*
  22	Register a Firm Name for a General Partnership
   */
    @Test
    public void whenUserCompletesRegistersFirmNameForGeneralPartnership_userSeesFirmNameForGeneralPartnershipRegistered() throws IOException, InterruptedException {
        partnerPortalLoginPage.loginUsingPartnerPortalCredentials();
        portalLandingPage.selectGeneralPartnerShipRegistrationService();
        partnerTermsAndConditionsPage.acceptTermsAndConditions();
        contactInformationPage.completeContactInformationAndSave();
        partnerSoleProprietorshipRegistrationPage.setBusinessNameSoleProprietorship(partnerSoleProprietorshipRegistrationPage.completeBusinessNameRegistrationAndSave());
        partnerSoleProprietorshipRegistrationPage.completeAddressAndSave();
        partnerSoleProprietorshipRegistrationPage.completePartnersAndSave();
        partnerSoleProprietorshipRegistrationPage.completeAuthorizationForGeneralPartnershipAndSave();
        partnerSoleProprietorshipRegistrationPage.completeReviewAndSubmit();
        soIncorporateOntarioBusinessCorporationPage.setTransactionNumber(soIncorporateOntarioBusinessCorporationPage.completeFeePaymentDebit());
        portalLandingPage.selectSearchRegistry();

        Assert.assertTrue(partnerSoleProprietorshipRegistrationPage.generalPartnershipIsRegistered());
        Assert.assertTrue(genericUtilsPage.emailSubjectAndContentIsDisplayed());
        Assert.assertTrue(soIncorporateOntarioBusinessCorporationPage.emailContentIsDisplayed());
    }
}