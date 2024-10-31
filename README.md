
# AUTOMATION MANAGER v1.1

## Overview

AUTOMATION MANAGER v1.1 is a Java-based GUI project designed to provide a user-friendly interface for executing automated tests in the **Onbis project**. The Onbis project is a comprehensive automation suite built with Selenium to test the OBR platform. By combining these two projects, AUTOMATION MANAGER v1.1 allows users with no coding background to run specific test cases from the Onbis project through an intuitive graphical interface.

## Project Structure

### Projects
1. **Onbis Project**: A complete automation framework for testing OBR using Selenium, structured to run all test cases via the `testNG.xml` configuration.
2. **AUTOMATION MANAGER v1.1 Project**: A GUI application serving as the primary interface for executing tests within Onbis without requiring users to understand or modify code.

### Objective
The main goal is to enable the Onbis test automation suite to be executed through AUTOMATION MANAGER v1.1, with modularized test options accessible via the GUI.

## Current Implementation

### Cross-referencing Approach
- The Onbis project is included within the GUI project as a `.jar` file.
- An `AutomationScriptExecutor` class in the GUI project attempts to call specific test suites and methods from Onbis, organized by suites (e.g., **sanity**, **regression**) and options (e.g., **Admin**, **PartnerPortal**, **SOAB**, **CR's**).

### Challenges
Due to the Onbis project structure, only the `testNG.xml` file is executed each time, which restricts control over specific test cases or suites, limiting modular execution through individual methods.

## New Approach

To address this limitation, the updated plan includes:
1. **Modularizing `testNG.xml`**: Dividing test configurations into separate methods to enable individual or grouped execution.
2. **Parameter Passing**: Allowing the GUI to pass specific parameters to the Onbis project in a structured format (such as JSON-like objects), which can then be unpacked and used to control test execution at a granular level.

## Usage Instructions

1. **Build Setup**:
   - Add the Onbis `.jar` file as a dependency within AUTOMATION MANAGER v1.1.
   - Ensure both projects are cross-referenced for smooth operation.

2. **Execution**:
   - Launch AUTOMATION MANAGER v1.1 and select the desired test suite and options.
   - The selected parameters will be passed to Onbis, initiating the appropriate test methods based on the chosen configurations.

3. **Dependencies**:
   - `Java 11` or higher.
   - `Selenium WebDriver`.
   - `TestNG`.

## Future Improvements

- **Enhanced Modularity**: Further refining the `testNG.xml` structure for greater flexibility.
- **Parameter Handling**: Implementing JSON parsing or an alternative to facilitate seamless parameter transmission from the GUI to the automation suite.

## License

This project is licensed under the MIT License.
