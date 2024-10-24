package org.student.GradingSystem;


import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class CourseReportScreen {
    private VBox view;
    private StudentGradingSystemData data = StudentGradingSystemData.getInstance();

    public CourseReportScreen() {
        view = new VBox(10);

        Label courseLabel = new Label("Select Course:");
        ComboBox<String> courseDropdown = new ComboBox<>();
        courseDropdown.getItems().addAll("CS101 - Introduction to Programming", "CS102 - Data Structures", "MATH101 - Calculus I");

        TableView<StudentReport> table = new TableView<>();
        table.setEditable(false);

        TableColumn<StudentReport, String> idColumn = new TableColumn<>("Student ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("studentID"));

        TableColumn<StudentReport, String> nameColumn = new TableColumn<>("Student Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));

        TableColumn<StudentReport, Integer> testColumn = new TableColumn<>("Test Score");
        testColumn.setCellValueFactory(new PropertyValueFactory<>("testScore"));

        TableColumn<StudentReport, Integer> projectColumn = new TableColumn<>("Project Score");
        projectColumn.setCellValueFactory(new PropertyValueFactory<>("projectScore"));

        TableColumn<StudentReport, Integer> examColumn = new TableColumn<>("Exam Score");
        examColumn.setCellValueFactory(new PropertyValueFactory<>("examScore"));

        TableColumn<StudentReport, Integer> totalColumn = new TableColumn<>("Total Score");
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalScore"));

        table.getColumns().addAll(idColumn, nameColumn, testColumn, projectColumn, examColumn, totalColumn);

        courseDropdown.setOnAction(event -> {
            String selectedCourse = courseDropdown.getValue();
            List<StudentReport> reportData = data.getReportsForCourse(selectedCourse);
            table.getItems().clear();
            table.getItems().addAll(reportData);
        });

        Button exportButton = new Button("Export Report");
        exportButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(view.getScene().getWindow());
            if (file != null) {
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.println("Student ID,Student Name,Test Score,Project Score,Exam Score,Total Score");
                    for (StudentReport report : table.getItems()) {
                        writer.println(report.getStudentID() + "," + report.getStudentName() + ","
                                + report.getTestScore() + "," + report.getProjectScore() + ","
                                + report.getExamScore() + "," + report.getTotalScore());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        view.getChildren().addAll(courseLabel, courseDropdown, table, exportButton);
    }

    public VBox getView() {
        return view;
    }
}

