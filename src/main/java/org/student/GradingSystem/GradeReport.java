package org.student.GradingSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GradeReport {

	// Method to generate report for a single student
	public void generateStudentReport(Student student) {
		System.out.println("Generating report for student: " + student.getStudentName());
		System.out.println("Grades:");
		for (Grade grade : student.getStudentGrades()) {
			System.out.println(grade.getCourse().getCourseName() + ": " + grade.getGradeScore());
		}
	}

	// Method to export student performance to a text file
	public void exportStudentReportToFile(Student student, String fileName) {
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write("Report for Student: " + student.getStudentName() + "\n");
			writer.write("Student ID: " + student.getStudentId() + "\n");
			writer.write("Grades:\n");
			for (Grade grade : student.getStudentGrades()) {
				writer.write(grade.getCourse().getCourseName() + ": " + grade.getGradeScore() + "\n");
			}
			System.out.println("Report exported successfully to " + fileName);
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	// Method to generate course report for all students in a course
	public void generateCourseReport(StudentGradingSystem system, String courseCode) {
		Course course = system.searchCourseByCode(courseCode);
		if (course != null) {
			System.out.println("Report for Course: " + course.getCourseName());
			for (Student student : system.getStudents()) {
				for (Grade grade : student.getStudentGrades()) {
					if (grade.getCourse().equals(course)) {
						System.out.println(student.getStudentName() + ": " + grade.getGradeScore());
					}
				}
			}
		} else {
			System.out.println("Course not found!");
		}
	}
}
