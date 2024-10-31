package com.onbis.TestSuites;

import org.testng.TestNG;
import com.onbis.TestCases.BNM013_AmendRegistrationOfABusinessNameForALimitedPartnership;
import com.onbis.TestCases.BNM016_Cancel_ARegistrationOfABusinessNameForAPartnership;
import com.onbis.TestCases.BNM003_CancelARegistrationOfABusinessNameForASoleProprietorship;
import com.onbis.TestCases.BNM010_AmendABusinessNameRegistrationForACorporation;
import com.onbis.TestCases.PSM007_AmendARegistrationOfAFirmNameForAGeneralPartnership;
import com.onbis.TestCases.PSM005_CancelAnOntarioLimitedPartnershipDeclaration;

import com.onbis.TestCases.REG_BCAM008_FileFinalPlanForArrangement;
import com.onbis.TestCases.REG_CIA002_AnnualReturnForAOntarioBusinessCorporation;
import com.onbis.TestCases.REG_CIA015_InitialReturnForAnExtraProvincialCorp;
import com.onbis.TestCases.REG_CIA016_NoticeOfChangeForAnExtraProvincialCorp;
import com.onbis.TestCases.REG_BCAM012_ReviveAnOntarioBusinessCorporation;
import com.onbis.TestCases.REG_BCAM011_InstrumentOfContinuanceAnOntarioBusinessCorporation;
import com.onbis.TestCases.REG_CIA006_NoticeOfChangeForEPForeignCorpWithShare;
import com.onbis.TestCases.REG_EPCM008_ApplicationToTerminateALicenceForExtraProvincialForeignCorporation;
import com.onbis.TestCases.REG_EPCM007_ApplicationForAmendmentToLicenceForAForeignCorporation;
import com.onbis.TestCases.REG_LLCM003_CancelARegistrationExtraProvincialLimitedLiabilityCompanyName;
import com.onbis.TestCases.REG_NFPCM002_NFPCA_FileArticleOfAmendment;
import com.onbis.TestCases.REG_NFPCM006_NFPCA_AuthorizationToContinueOut;
import com.onbis.TestCases.REG_NFPCM010_NFPCA_FileArticlesOfDissolution;
import com.onbis.TestCases.REG_NFPCM012_NFPCA_WindingUpNotForProfitCorporation;
import com.onbis.TestCases.REG_NFPCM011_NFPCA_ReviveNotForProfitCorporation;
import com.onbis.TestCases.REG_NFPCM007_NFPCA_FileDraftPlanOfArrangement;
import com.onbis.TestCases.REG_NFPCM008_NFPCA_FileFinalPlanOfArrangement;

import com.onbis.TestCases.BCAM002_TestCasesFileArticlesOfAmendmenOntarioBusinessCorporation;
import com.onbis.TestCases.BCAM010_TestCasesFileArticlesDissolveOntarioBusinessCorporation;
import com.onbis.TestCases.BCAM006_TestCasesFileArticlesOfAuthorizationContinueOutOfBusinessCorporation;
import com.onbis.TestCases.BCAM007_TestCasesFileArticlesOfFileDraftPlanForArrangement;
import com.onbis.TestCases.BCAM013_TestCasesCourtOrderedWindingUpDissolutionOrder;

import com.onbis.TestCases.BNM002_RenewARegistrationOfABusinessNameForASoleProprietorship;
import com.onbis.TestCases.BNM011_RenewARegistrationOfABusinessNameForAOntarioLimitedLiabilityPartnership;
import com.onbis.TestCases.BNM017_RenewRegistrationOfABusinessNameForAPartnership;
import com.onbis.TestCases.LLCM002_RenewARegistrationOfABusinessNameForALimitedLiabilityCompanyName;
import com.onbis.TestCases.PSM017_RenewAAOntarioLimitedPartnershipDeclaration;
import com.onbis.TestCases.PSM018_RenewARegistration_OfAFirmNameForAGeneralPartnership;

import com.onbis.TestCases.CR_4260_4279_4277_4574_4592_4628_SoleProp_TC1_3;
import com.onbis.TestCases.CR_4260_4279_4277_4574_4592_4628_GeneralPartnership_TC1;
import com.onbis.TestCases.CR_4260_4279_4277_4574_4592_4628_GeneralPartnership_TC2;
import com.onbis.TestCases.CR_4260_4279_4277_4574_4592_4628_GeneralPartnershipInternationalAddress_TC3_TC4_TC5;
import com.onbis.TestCases.CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC1;
import com.onbis.TestCases.CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC2_TC3_TC4_TC5;
import com.onbis.TestCases.CR_4260_4279_4277_4574_4592_4628_ExtraProvincialLicenceForAForeignCorporation_TC2_TC3_TC4;
import com.onbis.TestCases.CR_4295_GeneralPartnership_BusinessNames_BusinessLink_TC6;
import com.onbis.TestCases.CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfGeneralManager_TC1;
import com.onbis.TestCases.CR_4254_AnnualReturnOption_ExtraProvincialLicenceForAForeignCorporation_TC3;
import com.onbis.TestCases.CR_4258_EPForeignWithShare_EntityNameJurisdictionNonEditable_TC2;
import com.onbis.TestCases.CR_4302_OntarioBusinessCorporation_HeaderDisplayedFrameNumber_TC2;
import com.onbis.TestCases.CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfAttorneyOntario_TC2;
import com.onbis.TestCases.CR_4280_OntarioBusinessIncorporation_RequestCertificate_CourtOrderedWindingUp_TC1;
import com.onbis.TestCases.CR_4349_ExtraProvincialLicence_CorporationdAsAgentFor_TC1_TC2;
import com.onbis.TestCases.CR_4437_EPFCWithShare_FileArticlesOfContinuanceUnderBCA_RequestedPastDateForContinuance_TC1;
import com.onbis.TestCases.CR_4751_ActiveNFPCA_WithActiveBusinessName_FileArticlesOfDissolution;
import com.onbis.TestCases.CR_4796_ActiveOntarioCorporationWithBusinessNam_FileArticlesOfContinuance;
// Import other relevant test classes

public class RegressionTests {

    public static void runPartnerPortalTests() {
        // Create an instance of TestNG
        TestNG testng = new TestNG();

        // classes to be executed
        testng.setTestClasses(new Class[]{
                BNM013_AmendRegistrationOfABusinessNameForALimitedPartnership.class,
                BNM016_Cancel_ARegistrationOfABusinessNameForAPartnership.class,
                BNM003_CancelARegistrationOfABusinessNameForASoleProprietorship.class,
                BNM010_AmendABusinessNameRegistrationForACorporation.class,
                PSM007_AmendARegistrationOfAFirmNameForAGeneralPartnership.class,
                PSM005_CancelAnOntarioLimitedPartnershipDeclaration.class,
        });

        //Run instance of the test
        testng.run();
    }

    public static void runAdminTests() {
        // Create an instance of TestNG
        TestNG testng = new TestNG();

        // Add the test classes to be executed
        testng.setTestClasses(new Class[]{
                REG_BCAM008_FileFinalPlanForArrangement.class,
                REG_CIA002_AnnualReturnForAOntarioBusinessCorporation.class,
                REG_CIA015_InitialReturnForAnExtraProvincialCorp.class,
                REG_CIA016_NoticeOfChangeForAnExtraProvincialCorp.class,
                REG_BCAM012_ReviveAnOntarioBusinessCorporation.class,
                REG_BCAM011_InstrumentOfContinuanceAnOntarioBusinessCorporation.class,
                REG_CIA006_NoticeOfChangeForEPForeignCorpWithShare.class,
                REG_EPCM008_ApplicationToTerminateALicenceForExtraProvincialForeignCorporation.class,
                REG_EPCM007_ApplicationForAmendmentToLicenceForAForeignCorporation.class,
                REG_LLCM003_CancelARegistrationExtraProvincialLimitedLiabilityCompanyName.class,
                REG_NFPCM002_NFPCA_FileArticleOfAmendment.class,
                REG_NFPCM006_NFPCA_AuthorizationToContinueOut.class,
                REG_NFPCM010_NFPCA_FileArticlesOfDissolution.class,
                REG_NFPCM012_NFPCA_WindingUpNotForProfitCorporation.class,
                REG_NFPCM011_NFPCA_ReviveNotForProfitCorporation.class,
                REG_NFPCM007_NFPCA_FileDraftPlanOfArrangement.class,
                REG_NFPCM008_NFPCA_FileFinalPlanOfArrangement.class,
        });

        // Run the tests
        testng.run();
    }

    public static void runSOABTests() {
        // Create an instance of TestNG
        TestNG testng = new TestNG();

        // Add the test classes to be executed
        testng.setTestClasses(new Class[]{
                BCAM002_TestCasesFileArticlesOfAmendmenOntarioBusinessCorporation.class,
                BCAM010_TestCasesFileArticlesDissolveOntarioBusinessCorporation.class,
                BCAM006_TestCasesFileArticlesOfAuthorizationContinueOutOfBusinessCorporation.class,
                BCAM007_TestCasesFileArticlesOfFileDraftPlanForArrangement.class,
                BCAM013_TestCasesCourtOrderedWindingUpDissolutionOrder.class,
        });

        // Run the tests
        testng.run();
    }

    public static void runPartnerPortalDataCreationTests() {
        // pending
    }

    public static void runPartnerPortalRenewalTests() {
        // Create an instance of TestNG
        TestNG testng = new TestNG();

        // Add the test classes to be executed
        testng.setTestClasses(new Class[]{
                BNM002_RenewARegistrationOfABusinessNameForASoleProprietorship.class,
                BNM011_RenewARegistrationOfABusinessNameForAOntarioLimitedLiabilityPartnership.class,
                BNM017_RenewRegistrationOfABusinessNameForAPartnership.class,
                LLCM002_RenewARegistrationOfABusinessNameForALimitedLiabilityCompanyName.class,
                PSM017_RenewAAOntarioLimitedPartnershipDeclaration.class,
                PSM018_RenewARegistration_OfAFirmNameForAGeneralPartnership.class,
        });

        // Run the tests
        testng.run();
    }

    public static void runCRRegressionTests() {
        // Create an instance of TestNG
        TestNG testng = new TestNG();

        // Add the test classes to be executed
        testng.setTestClasses(new Class[]{
                CR_4260_4279_4277_4574_4592_4628_SoleProp_TC1_3.class,
                CR_4260_4279_4277_4574_4592_4628_GeneralPartnership_TC1.class,
                CR_4260_4279_4277_4574_4592_4628_GeneralPartnership_TC2.class,
                CR_4260_4279_4277_4574_4592_4628_GeneralPartnershipInternationalAddress_TC3_TC4_TC5.class,
                CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC1.class,
                CR_4260_4279_4277_4574_4592_4628_CondoCorporationsAssignAnOCN_TC2_TC3_TC4_TC5.class,
                CR_4260_4279_4277_4574_4592_4628_ExtraProvincialLicenceForAForeignCorporation_TC2_TC3_TC4.class,
                CR_4295_GeneralPartnership_BusinessNames_BusinessLink_TC6.class,
                CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfGeneralManager_TC1.class,
                CR_4254_AnnualReturnOption_ExtraProvincialLicenceForAForeignCorporation_TC3.class,
                CR_4258_EPForeignWithShare_EntityNameJurisdictionNonEditable_TC2.class,
                CR_4302_OntarioBusinessCorporation_HeaderDisplayedFrameNumber_TC2.class,
                CR_4348_RegisterExtraProvincialLimitedLiabilityCompany_AddressOfAttorneyOntario_TC2.class,
                CR_4280_OntarioBusinessIncorporation_RequestCertificate_CourtOrderedWindingUp_TC1.class,
                CR_4349_ExtraProvincialLicence_CorporationdAsAgentFor_TC1_TC2.class,
                CR_4437_EPFCWithShare_FileArticlesOfContinuanceUnderBCA_RequestedPastDateForContinuance_TC1.class,
                CR_4751_ActiveNFPCA_WithActiveBusinessName_FileArticlesOfDissolution.class,
                CR_4796_ActiveOntarioCorporationWithBusinessNam_FileArticlesOfContinuance.class,
        });

        // Run the tests
        testng.run();
    }
}
