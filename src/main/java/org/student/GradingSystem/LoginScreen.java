package org.student.GradingSystem;


import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginScreen {
    private VBox view;
    private StudentGradingSystemApp mainApp;

    public LoginScreen(StudentGradingSystemApp app) {
        this.mainApp = app;
        view = new VBox(10);

        Label idLabel = new Label("Instructor ID:");
        TextField idField = new TextField();
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Button loginButton = new Button("Login");

        Label loginStatusLabel = new Label();
        loginButton.setOnAction(event -> {
            // Hardcoded login validation
            if ("IN-06-001".equals(idField.getText()) && "James Madisson".equals(nameField.getText())) {
                loginStatusLabel.setText("Login successful. Welcome, James!");
                mainApp.enableTabsAfterLogin();  // Enable the other tabs after successful login
            } else if ("IN-06-002".equals(idField.getText()) && "Sara Connor".equals(nameField.getText())) {
                loginStatusLabel.setText("Login successful. Welcome, Sara!");
                mainApp.enableTabsAfterLogin();  // Enable the other tabs after successful login
            } else {
                loginStatusLabel.setText("Invalid ID or name. Please try again.");
            }
        });

        view.getChildren().addAll(idLabel, idField, nameLabel, nameField, loginButton, loginStatusLabel);
    }

    public VBox getView() {
        return view;
    }
}

