package org.student.GradingSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentInfoHandler {
	private StudentGradingSystem gradingSystem;

	public StudentInfoHandler(StudentGradingSystem gradingSystem) {
		this.gradingSystem = gradingSystem;
	}

	// Method to read students from a CSV file and add them to a specified course
	public void bulkAddStudentsToCourse(String csvFilePath, Course course) {
		String line;
		String csvSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
			while ((line = br.readLine()) != null) {
				String[] studentData = line.split(csvSplitBy);

				if (studentData.length < 2) {
					System.out.println("Invalid data in CSV: " + line);
					continue; // Skip invalid lines
				}

				// Extract student information from the CSV file
				String studentName = studentData[0];
				String studentId = studentData[1];

				// Create new student and add to system
				Student student = new Student(studentName, studentId);
				gradingSystem.addStudent(student);
				// Assign student to the course
				student.enrollCourse(course);
				System.out.println("Added student: " + studentName + " to course: " + course.getCourseName());
			}
		} catch (IOException e) {
			System.out.println("Error reading CSV file: " + e.getMessage());
		}
	}
}
