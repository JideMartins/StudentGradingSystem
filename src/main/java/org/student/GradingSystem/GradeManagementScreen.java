package org.student.GradingSystem;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class GradeManagementScreen {
    private VBox view;
    private StudentGradingSystemData data = StudentGradingSystemData.getInstance();  // Singleton to store grades

    public GradeManagementScreen() {
        view = new VBox(10);

        // Dropdown to select course
        Label courseLabel = new Label("Select Course:");
        ComboBox<String> courseDropdown = new ComboBox<>();
        courseDropdown.getItems().addAll("CS101 - Introduction to Programming", "CS102 - Data Structures", "MATH101 - Calculus I");

        // Dropdown to select student
        Label studentLabel = new Label("Select Student:");
        ComboBox<String> studentDropdown = new ComboBox<>();

        courseDropdown.setOnAction(event -> {
            String selectedCourse = courseDropdown.getValue();
            studentDropdown.getItems().clear();
            if (selectedCourse.contains("CS101")) {
                studentDropdown.getItems().addAll("Alice", "Bob");
            } else if (selectedCourse.contains("CS102")) {
                studentDropdown.getItems().addAll("Charlie");
            } else if (selectedCourse.contains("MATH101")) {
                studentDropdown.getItems().addAll("Diana", "Edward");
            }
        });

        // Input fields for grades
        Label testLabel = new Label("Test Score (0-30):");
        TextField testField = new TextField();
        Label projectLabel = new Label("Project Score (0-20):");
        TextField projectField = new TextField();
        Label examLabel = new Label("Exam Score (0-100):");
        TextField examField = new TextField();

        // Automatically calculate total score
        Label totalLabel = new Label("Total Score:");
        Label totalScore = new Label();

        testField.textProperty().addListener((observable, oldValue, newValue) -> updateTotal(testField, projectField, examField, totalScore));
        projectField.textProperty().addListener((observable, oldValue, newValue) -> updateTotal(testField, projectField, examField, totalScore));
        examField.textProperty().addListener((observable, oldValue, newValue) -> updateTotal(testField, projectField, examField, totalScore));

        // Button to add grades
        Button addGradeButton = new Button("Add Grade");
        addGradeButton.setOnAction(event -> {
            String course = courseDropdown.getValue();
            String student = studentDropdown.getValue();
            int test = Integer.parseInt(testField.getText());
            int project = Integer.parseInt(projectField.getText());
            int exam = Integer.parseInt(examField.getText());
            int total = test + project + exam;

            // Add to the system data
            data.addGrade(new StudentReport(student, student, test, project, exam));
            totalScore.setText(String.valueOf(total));
        });

        view.getChildren().addAll(courseLabel, courseDropdown, studentLabel, studentDropdown, testLabel, testField,
                projectLabel, projectField, examLabel, examField, totalLabel, totalScore, addGradeButton);
    }

    private void updateTotal(TextField testField, TextField projectField, TextField examField, Label totalLabel) {
        try {
            int test = Integer.parseInt(testField.getText());
            int project = Integer.parseInt(projectField.getText());
            int exam = Integer.parseInt(examField.getText());
            int total = test + project + exam;
            totalLabel.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            totalLabel.setText("Invalid input.");
        }
    }

    public VBox getView() {
        return view;
    }
}

