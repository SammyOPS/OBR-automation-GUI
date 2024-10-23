package com.onbis;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Uncomment for real execution and comment out the line below if running from IDE with arguments
        // args = new String[]{"regression", "partnerportal"};

        if (args.length == 2) {
            String testType = args[0];
            String testGroup = args[1];

            switch (testType.toLowerCase()) {
                case "sanity":
                    runSanityTests(testGroup);
                    break;
                case "regression":
                    runRegressionTests(testGroup);
                    break;
                default:
                    System.out.println("Invalid test type. Please use 'sanity' or 'regression'.");
            }
        } else {
            System.out.println("Please provide both a test type ('sanity' or 'regression') and a test group.");
        }
    }

    private static void runSanityTests(String testGroup) {
        List<XmlClass> testClasses = new ArrayList<>();
        switch (testGroup.toLowerCase()) {
            case "partnerportal":
                testClasses.add(new XmlClass("com.onbis.TestCases.TC13_BNR001_RegisterASoleProprietorshipName"));
                break;
            case "soab":
                testClasses.add(new XmlClass("com.onbis.TestCases.TC01_BCAR001_TestCasesForIncorporationNumber"));
                break;
            case "admin":
                testClasses.add(new XmlClass("com.onbis.TestCases.TC03_OCR001_AssignAnOCN"));
                break;
            default:
                System.out.println("Invalid sanity test group.");
                return;
        }

        runTestNGSuite(testClasses);
    }

    private static void runRegressionTests(String testGroup) {
        List<XmlClass> testClasses = new ArrayList<>();
        switch (testGroup.toLowerCase()) {
            case "partnerportal":
                testClasses.add(new XmlClass("com.onbis.TestCases.BNM013_AmendRegistrationOfABusinessNameForALimitedPartnership"));
                break;
            case "soab":
                testClasses.add(new XmlClass("com.onbis.TestCases.BCAM002_FileArticlesOfAmendmentOntarioBusinessCorporation"));
                break;
            case "admin":
                testClasses.add(new XmlClass("com.onbis.TestCases.REG_BCAM008_FileFinalPlanForArrangement"));
                break;
            case "cr":
                testClasses.add(new XmlClass("com.onbis.TestCases.CR_4260_4279_4277_4574_4592_4628_SoleProp_TC1_3"));
                break;
            default:
                System.out.println("Invalid regression test group.");
                return;
        }

        runTestNGSuite(testClasses);
    }

    private static void runTestNGSuite(List<XmlClass> testClasses) {
        if (testClasses.isEmpty()) {
            System.out.println("No test classes found for execution.");
            return;
        }

        // Create a new suite
        XmlSuite suite = new XmlSuite();
        suite.setName("Onbis E2E Suite");

        // Create a new test and add the classes to it
        XmlTest test = new XmlTest(suite);
        test.setName("Onbis E2E Test");
        test.setXmlClasses(testClasses);

        // Create TestNG instance and run the suite
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);

        // Set verbose level for logging test execution
        testNG.setVerbose(2); // Optional: Increase verbosity to track execution
        testNG.setDefaultSuiteName("Onbis Default Suite");
        testNG.setDefaultTestName("Onbis Default Test");

        System.out.println("Starting TestNG execution with the following tests: ");
        for (XmlClass xmlClass : testClasses) {
            System.out.println(" - " + xmlClass.getName());
        }

        // Run the suite
        testNG.run();
    }
}
