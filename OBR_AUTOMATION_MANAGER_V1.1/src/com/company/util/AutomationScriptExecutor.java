package com.company.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AutomationScriptExecutor {

    public static void runAutomationScripts() {
        try {
            // Update this path to your actual IntelliJ installation path
            String ideaPath = "\"C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2021.3.3\\bin\\idea.bat\"";
            String projectPath = "C:\\workspace\\onbis-e2e";

            // Command to run the tests in IntelliJ
            String command = ideaPath + " " + projectPath;

            // Debugging information
            System.out.println("Running command: " + command);

            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
