package org.student.GradingSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class StudentGradingApp extends Application {
	private StudentGradingSystem gradingSystem = new StudentGradingSystem();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Student Grading System");

		// Create layout
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		// Course selection from a combo box
		Label courseLabel = new Label("Select Course:");
		GridPane.setConstraints(courseLabel, 0, 0);
		ComboBox<Course> courseComboBox = new ComboBox<>();
		courseComboBox.getItems().addAll(gradingSystem.getCourses()); // Populate with available courses
		GridPane.setConstraints(courseComboBox, 1, 0);

		// File Chooser for CSV Upload
		Button uploadButton = new Button("Upload CSV");
		GridPane.setConstraints(uploadButton, 1, 1);
		Label fileLabel = new Label("No file selected");
		GridPane.setConstraints(fileLabel, 1, 2);

		// Handle file selection and CSV upload
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

		uploadButton.setOnAction(e -> {
			Course selectedCourse = courseComboBox.getSelectionModel().getSelectedItem();
			if (selectedCourse != null) {
				File selectedFile = fileChooser.showOpenDialog(primaryStage);
				if (selectedFile != null) {
					fileLabel.setText(selectedFile.getName());
					StudentInfoHandler csvHandler = new StudentInfoHandler(gradingSystem);
					// Bulk add students to the selected course
					csvHandler.bulkAddStudentsToCourse(selectedFile.getAbsolutePath(), selectedCourse);
				} else {
					fileLabel.setText("File selection cancelled.");
				}
			} else {
				System.out.println("No course selected!");
			}
		});

		// Add elements to the grid
		grid.getChildren().addAll(courseLabel, courseComboBox, uploadButton, fileLabel);

		// Setup scene and display
		Scene scene = new Scene(grid, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
