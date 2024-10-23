package com.onbis.TestSuites;

import org.testng.TestNG;
import com.onbis.TestCases.TC13_BNR001_RegisterASoleProprietorshipName;
import com.onbis.TestCases.TC12_LLCR001_RegisterAnExtraProvincialLimitedLiabilityCompanyName;
import com.onbis.TestCases.TC15_BNR003_RegisterABusinessNameForAGeneralPartnership;
import com.onbis.TestCases.TC11_BNR002_RegisterABusinessNameForACorporation;
import com.onbis.TestCases.TC11_BNR002_RegisterABusinessNameForACorporation_Continues;
import com.onbis.TestCases.TC14_BNR004_RegisterABusinessNameForALimitedPartnership;
import com.onbis.TestCases.TC16_BNM007_AmendARegistrationOfABusinessNameForAGeneralPartnership;
import com.onbis.TestCases.TC18_LLCM001_AmendARegistrationOfAnExtraProvincialLimitedLiabilityCompanyName;
import com.onbis.TestCases.TC19_BNM001_AmendARegistrationOfABusinessNameForASoleProprietorship;
import com.onbis.TestCases.TC25_PSM009_CancelARegistrationOfAFirmNameForAGeneralPartnership;
import com.onbis.TestCases.TC17_BNM012_CancelABusinessNameRegistrationForACorporation;
import com.onbis.TestCases.TC20_PSM001_FileADeclarationOfChangeOfAnOntarioLimitedPartnership;
import com.onbis.TestCases.TC23_PSR004_RegisterAFirmNameForAnOntarioLimitedLiabilityPartnership;
import com.onbis.TestCases.TC24_PSR005_RegisterAFirmNameForAnExtraProvincialLimitedLiabilityPartnership;
import com.onbis.TestCases.TC21_PSR002_FileADeclarationOfAnExtraProvincialLimitedPartnership;
import com.onbis.TestCases.TC22_PSR003_RegisterAFirmNameForAGeneralPartnership;

import com.onbis.TestCases.TC01_BCAR001_TestCasesAddProfileForIncorportatNumber;
import com.onbis.TestCases.TC02_BCAR001_TestCasesForIncorportateName;
import com.onbis.TestCases.TC04_BCAR005_TestCasesForContinuanceCreate;
import com.onbis.TestCases.TC05_NFPCR001_IncorporateANotForProfitCorporation;
import com.onbis.TestCases.TC06_EPCR001_ApplicationForEPLicenceForeignCorpWithShare;
import com.onbis.TestCases.TC26_BCAM004_TestCasesRestateArticlesOfIncorporation;
import com.onbis.TestCases.TC27_BCAM009_TestCasesFileArticlesOfReorganization;
import com.onbis.TestCases.TC28_BCAR003_TestCasesForAmalgamation;

import com.onbis.TestCases.TC03_OCR001_AssignAnOCN;
import com.onbis.TestCases.TC09_10_CIA001_CIA003_InitialReturnForONCorp_NoticeOfChangeForAnOntarioCorporation;
import com.onbis.TestCases.TC06_07_08_CIA004_CIA005_InitialReturnForForeignCor_AnnualReturnForeignCorpWithShare;
// Import other relevant test classes

public class SanityTests {

    public static void runPartnerPortalTests() {
        // Create an instance of TestNG
        TestNG testng = new TestNG();

        // Add the test classes to be executed
        testng.setTestClasses(new Class[]{
                TC13_BNR001_RegisterASoleProprietorshipName.class,
                TC12_LLCR001_RegisterAnExtraProvincialLimitedLiabilityCompanyName.class,
                TC15_BNR003_RegisterABusinessNameForAGeneralPartnership.class,
                TC11_BNR002_RegisterABusinessNameForACorporation.class,
                TC11_BNR002_RegisterABusinessNameForACorporation_Continues.class,
                TC14_BNR004_RegisterABusinessNameForALimitedPartnership.class,
                TC16_BNM007_AmendARegistrationOfABusinessNameForAGeneralPartnership.class,
                TC18_LLCM001_AmendARegistrationOfAnExtraProvincialLimitedLiabilityCompanyName.class,
                TC19_BNM001_AmendARegistrationOfABusinessNameForASoleProprietorship.class,
                TC25_PSM009_CancelARegistrationOfAFirmNameForAGeneralPartnership.class,
                TC17_BNM012_CancelABusinessNameRegistrationForACorporation.class,
                TC20_PSM001_FileADeclarationOfChangeOfAnOntarioLimitedPartnership.class,
                TC23_PSR004_RegisterAFirmNameForAnOntarioLimitedLiabilityPartnership.class,
                TC24_PSR005_RegisterAFirmNameForAnExtraProvincialLimitedLiabilityPartnership.class,
                TC21_PSR002_FileADeclarationOfAnExtraProvincialLimitedPartnership.class,
                TC22_PSR003_RegisterAFirmNameForAGeneralPartnership.class,
        });

        // Run the tests
        testng.run();
    }

    public static void runSOABTests() {
        // Create an instance of TestNG
        TestNG testng = new TestNG();

        // Add the test classes to be executed
        testng.setTestClasses(new Class[]{
                TC01_BCAR001_TestCasesAddProfileForIncorportatNumber.class,
                TC02_BCAR001_TestCasesForIncorportateName.class,
                TC04_BCAR005_TestCasesForContinuanceCreate.class,
                TC05_NFPCR001_IncorporateANotForProfitCorporation.class,
                TC06_EPCR001_ApplicationForEPLicenceForeignCorpWithShare.class,
                TC26_BCAM004_TestCasesRestateArticlesOfIncorporation.class,
                TC27_BCAM009_TestCasesFileArticlesOfReorganization.class,
                TC28_BCAR003_TestCasesForAmalgamation.class,
        });

        // Run the tests
        testng.run();
    }

    public static void runAdminTests() {
        // Create an instance of TestNG
        TestNG testng = new TestNG();

        // Add the test classes to be executed
        testng.setTestClasses(new Class[]{
                TC03_OCR001_AssignAnOCN.class,
                TC09_10_CIA001_CIA003_InitialReturnForONCorp_NoticeOfChangeForAnOntarioCorporation.class,
                TC06_07_08_CIA004_CIA005_InitialReturnForForeignCor_AnnualReturnForeignCorpWithShare.class,
        });

        // Run the tests
        testng.run();
    }
}
