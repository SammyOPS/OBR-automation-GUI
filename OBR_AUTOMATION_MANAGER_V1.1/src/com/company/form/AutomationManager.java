package com.company.form;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class AutomationManager {

    private JTextField emailField;
    private JTextField reportEmailField;
    private JCheckBox reportEmailCheckbox;
    private JPanel regressionOptionsPanel;
    private JCheckBox adminCheckbox;
    private JCheckBox partnerPortalCheckbox;
    private JCheckBox soabCheckbox;
    private JCheckBox crCheckbox;
    private JComboBox<String> suiteComboBox;
    private JComboBox<String> environmentComboBox;
    private JPanel userPanel;
    private JTextField browseUserField;
    private JButton searchButton;
    private JRadioButton psisQa3;
    private JRadioButton browseUsers;

    public void display() {
        // Create the main frame
        JFrame frame = new JFrame("OBR Test Automation Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);  // Set the size of the window

        // Set icon
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("com/company/resources/images/SAM-logo-larger.ico"));
        frame.setIconImage(img.getImage());

        // layout manager
        frame.setLayout(new BorderLayout());

        // Add a banner
        JPanel bannerPanel = new JPanel();
        bannerPanel.setBackground(Color.BLACK);
        bannerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel bannerLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("com/company/resources/images/ontario-logo.png")));
        bannerPanel.add(bannerLabel);
        frame.add(bannerPanel, BorderLayout.NORTH);

        // Create the main form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add title
        JLabel titleLabel = new JLabel("OBR TEST AUTOMATION MANAGER");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(titleLabel, gbc);

        // machine and user information
        String userName = System.getProperty("user.name");
        String osName = System.getProperty("os.name");
            //This ideally is used to display the current user and machine number inwhich the automation is being run at

        // Add machine label
        JLabel machineLabel = new JLabel("Automation running on machine: " + userName + " (" + osName + ")");
        JPanel machinePanel = new JPanel();
        machinePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        machinePanel.add(machineLabel);
        machinePanel.add(createOnlineDot());
        gbc.gridy = 1;
        formPanel.add(machinePanel, gbc);

        // User selection (larger section)
        userPanel = createTitledPanel("CHOOSE YOUR USER");
        psisQa3 = new JRadioButton("psis_qa3");
        psisQa3.setFont(new Font("Arial", Font.PLAIN, 14));
        psisQa3.setSelected(true);
        browseUsers = new JRadioButton("Browse Users");
        browseUsers.setFont(new Font("Arial", Font.PLAIN, 14));

        ButtonGroup userGroup = new ButtonGroup();
        userGroup.add(psisQa3);
        userGroup.add(browseUsers);

        userPanel.add(psisQa3);
        userPanel.add(browseUsers);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        formPanel.add(userPanel, gbc);

        browseUserField = new JTextField(15);
        searchButton = new JButton("Search");
        searchButton.setBackground(Color.GREEN);
        browseUserField.setVisible(false);
        searchButton.setVisible(false);

        userPanel.add(browseUserField);
        userPanel.add(searchButton);

        // Email Input (smaller sections)
        JPanel emailPanel = createTitledPanel("CHOOSE THE SYSTEM EMAIL");
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField = new JTextField("onbistestautomation@gmail.com", 15);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        gbc.gridy = 3;
        formPanel.add(emailPanel, gbc);

        // Environment Selection (smaller sections)
        JPanel environmentPanel = createTitledPanel("CHOOSE THE ENVIRONMENT");
        environmentComboBox = new JComboBox<>(new String[]{"--Select Environment--", "Stage 2", "Stage 1", "UAT2", "UAT1"});
        environmentComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        environmentPanel.add(environmentComboBox);
        gbc.gridy = 4;
        formPanel.add(environmentPanel, gbc);

        // Suite Selection (smaller sections)
        JPanel suitePanel = createTitledPanel("CHOOSE THE SUITE");
        suiteComboBox = new JComboBox<>(new String[]{"--Select Suite--", "Sanity", "Regression"});
        suiteComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        suiteComboBox.addActionListener(e -> updateSuiteOptions());
        suitePanel.add(suiteComboBox);

        // Additional Suite Options
        regressionOptionsPanel = new JPanel();
        regressionOptionsPanel.setLayout(new BoxLayout(regressionOptionsPanel, BoxLayout.Y_AXIS));
        adminCheckbox = new JCheckBox("Admin");
        adminCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        partnerPortalCheckbox = new JCheckBox("Partner Portal");
        partnerPortalCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        soabCheckbox = new JCheckBox("SOAB");
        soabCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        crCheckbox = new JCheckBox("CR's");
        crCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));

        regressionOptionsPanel.add(adminCheckbox);
        regressionOptionsPanel.add(partnerPortalCheckbox);
        regressionOptionsPanel.add(soabCheckbox);
        regressionOptionsPanel.add(crCheckbox);

        suitePanel.add(regressionOptionsPanel);
        regressionOptionsPanel.setVisible(false); // Hide initially
        gbc.gridy = 5;
        formPanel.add(suitePanel, gbc);

        // Advanced Options (smaller sections)
        JPanel advancedPanel = createTitledPanel("ADVANCED OPTIONS");
        advancedPanel.setLayout(new GridBagLayout());
        GridBagConstraints advancedGbc = new GridBagConstraints();
        advancedGbc.anchor = GridBagConstraints.WEST;
        advancedGbc.insets = new Insets(5, 0, 5, 0);

        advancedGbc.gridx = 0;
        advancedGbc.gridy = 0;
        JLabel screenshotsLabel = new JLabel("Do you want screenshots?");
        screenshotsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        advancedPanel.add(screenshotsLabel, advancedGbc);

        advancedGbc.gridx = 1;
        JComboBox<String> screenshotsComboBox = new JComboBox<>(new String[]{"Partial screenshots (Only failed tests)", "No"});
        screenshotsComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        advancedPanel.add(screenshotsComboBox, advancedGbc);

        advancedGbc.gridx = 0;
        advancedGbc.gridy = 1;
        reportEmailCheckbox = new JCheckBox("Request report by email");
        reportEmailCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        reportEmailCheckbox.addActionListener(e -> reportEmailField.setEnabled(reportEmailCheckbox.isSelected()));
        advancedPanel.add(reportEmailCheckbox, advancedGbc);

        advancedGbc.gridx = 1;
        reportEmailField = new JTextField(15);
        reportEmailField.setFont(new Font("Arial", Font.PLAIN, 14));
        reportEmailField.setEnabled(false);
        advancedPanel.add(reportEmailField, advancedGbc);

        advancedGbc.gridx = 0;
        advancedGbc.gridy = 2;
        JPanel headlessPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JCheckBox headlessCheckbox = new JCheckBox("Headless");
        headlessCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel infoLabel = new JLabel("(?)");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        infoLabel.setToolTipText("<html><p style='width: 200px;'>Headless is a faster way of running automation. The automation process will happen in the backend instead of being displayed graphically by the browser.</p></html>");
        headlessPanel.add(headlessCheckbox);
        headlessPanel.add(infoLabel);
        advancedPanel.add(headlessPanel, advancedGbc);

        gbc.gridy = 6;
        formPanel.add(advancedPanel, gbc);

        // Submit Button
        JButton submitButton = new JButton("Go!");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(e -> {
            if (validateForm()) {
                String selectedSuite = (String) suiteComboBox.getSelectedItem();
                String selectedTestGroup = getSelectedTestGroup();

                if (selectedTestGroup.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please select a test group.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // Run the Main class from the onbis-e2e JAR
                    runTestAutomation(selectedSuite, selectedTestGroup);
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error running the automation scripts: " + ex.getMessage());
                }
            }
        });

        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        // Add form panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Customize scroll speed
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(14);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);

        // Add Action Listeners
        addActionListeners(psisQa3, browseUsers);
    }

    private void addActionListeners(JRadioButton psisQa3, JRadioButton browseUsers) {
        psisQa3.addActionListener(e -> {
            browseUserField.setVisible(false);
            searchButton.setVisible(false);
            emailField.setText("onbistestautomation@gmail.com");
        });
        browseUsers.addActionListener(e -> {
            browseUserField.setVisible(true);
            searchButton.setVisible(true);
        });
    }

    private void updateSuiteOptions() {
        String selectedSuite = (String) suiteComboBox.getSelectedItem();
        if ("Sanity".equals(selectedSuite)) {
            partnerPortalCheckbox.setVisible(true);
            soabCheckbox.setVisible(true);
            adminCheckbox.setVisible(true);
            crCheckbox.setVisible(false);
            regressionOptionsPanel.setVisible(true);
        } else if ("Regression".equals(selectedSuite)) {
            partnerPortalCheckbox.setVisible(true);
            soabCheckbox.setVisible(true);
            adminCheckbox.setVisible(true);
            crCheckbox.setVisible(true);
            regressionOptionsPanel.setVisible(true);
        } else {
            regressionOptionsPanel.setVisible(false);
        }
    }

    private boolean validateForm() {
        StringBuilder errorMessage = new StringBuilder();

        // Validate user selection
        if (!isUserSelected()) {
            errorMessage.append("Please select a user.\n");
        }

        // Validate email format
        if (!isValidEmail(emailField.getText())) {
            errorMessage.append("Please enter a valid email address.\n");
        }

        // Validate environment selection
        if (environmentComboBox.getSelectedItem() == null || environmentComboBox.getSelectedItem().toString().equals("--Select Environment--")) {
            errorMessage.append("Please select an environment.\n");
        }

        // Validate suite selection and checkboxes
        String selectedSuite = (String) suiteComboBox.getSelectedItem();
        if (selectedSuite == null || selectedSuite.equals("--Select Suite--")) {
            errorMessage.append("Please select a suite.\n");
        } else if (!isAnyCheckboxSelected()) {
            errorMessage.append("Please select at least one option for the " + selectedSuite + " suite.\n");
        }

        // Validate report email if checkbox is selected
        if (reportEmailCheckbox.isSelected() && !isValidEmail(reportEmailField.getText())) {
            errorMessage.append("Please enter a valid report email address.\n");
        }

        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(null, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isUserSelected() {
        return psisQa3.isSelected() || browseUsers.isSelected();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    private boolean isAnyCheckboxSelected() {
        return adminCheckbox.isSelected() || partnerPortalCheckbox.isSelected() || soabCheckbox.isSelected() || crCheckbox.isSelected();
    }

    private String getSelectedTestGroup() {
        if (partnerPortalCheckbox.isSelected()) {
            return "partnerportal";
        } else if (soabCheckbox.isSelected()) {
            return "soab";
        } else if (adminCheckbox.isSelected()) {
            return "admin";
        } else if (crCheckbox.isSelected()) {
            return "cr";
        }
        return "";
    }

    private void runTestAutomation(String suite, String group) throws IOException, InterruptedException {
        String jarPath = "C:\\workspace\\onbis-e2e\\out\\artifacts\\onbis_e2e_jar\\onbis-e2e.jar";
        String[] command = {"java", "-jar", jarPath, suite.toLowerCase(), group.toLowerCase()};

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true); // Redirect error stream to output stream
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print the output of the script to the console
            }
        }

        int exitCode = process.waitFor(); // Wait for the process to finish
        System.out.println("Process exited with code: " + exitCode);

        if (exitCode != 0) {
            throw new RuntimeException("Test automation failed with exit code " + exitCode);
        }
    }


    private JPanel createTitledPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    private JLabel createOnlineDot() {
        JLabel onlineDot = new JLabel();
        onlineDot.setOpaque(true);
        onlineDot.setBackground(Color.GREEN);
        onlineDot.setPreferredSize(new Dimension(10, 10));
        return onlineDot;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AutomationManager().display());
    }
}
