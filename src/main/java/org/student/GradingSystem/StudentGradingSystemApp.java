package org.student.GradingSystem;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class StudentGradingSystemApp extends Application {

    private Tab gradeManagementTab;
    private Tab courseReportTab;

    @Override
    public void start(Stage primaryStage) {
        // Main TabPane to hold different tabs
        TabPane tabPane = new TabPane();

        // Login tab
        LoginScreen loginScreen = new LoginScreen(this);
        Tab loginTab = new Tab("Login", loginScreen.getView());
        loginTab.setClosable(false);

        // Grade management tab
        gradeManagementTab = new Tab("Grade Management", new GradeManagementScreen().getView());
        gradeManagementTab.setClosable(false);
        gradeManagementTab.setDisable(true); // Disable until login

        // Course report tab
        courseReportTab = new Tab("Course Report", new CourseReportScreen().getView());
        courseReportTab.setClosable(false);
        courseReportTab.setDisable(true); // Disable until login

        // Add tabs to the TabPane
        tabPane.getTabs().addAll(loginTab, gradeManagementTab, courseReportTab);

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setTitle("Student Grading System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to enable the tabs after login
    public void enableTabsAfterLogin() {
        gradeManagementTab.setDisable(false);
        courseReportTab.setDisable(false);
    }

    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
}

