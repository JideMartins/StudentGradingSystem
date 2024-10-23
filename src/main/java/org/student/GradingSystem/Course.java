package org.student.GradingSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {
	private String courseName;
	private String courseCode;
	private List<Student> students;
	

	public Course(String courseCode, String courseName) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.students = new ArrayList<>();
	}


	public String getCourseName() {
		return courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}
	
	public List<Student> getStudents() {
        return students;
    }
	
	public void addStudent(Student student) {
        students.add(student);
    }
	
	public void displayStudents() {
        System.out.println("Students in course: " + courseName);
        for (Student student : students) {
            System.out.println(student.getStudentID() + " - " + student.getStudentName());
        }
    }
	
	// Method to add grades for students
    public void addGrades(Scanner scanner) {
        for (Student student : students) {
            System.out.println("Enter grades for student: " + student.getStudentName());

            int testScore = promptForValidScore(scanner, "Test Score (0-30):", 0, 30);
            student.getGrading().setTestScore(testScore);

            int examScore = promptForValidScore(scanner, "Exam Score (0-50):", 0, 50);
            student.getGrading().setExamScore(examScore);

            int projectScore = promptForValidScore(scanner, "Project Score (0-20):", 0, 20);
            student.getGrading().setProjectScore(projectScore);
        }
    }

    private int promptForValidScore(Scanner scanner, String prompt, int min, int max) {
        int score;
        do {
            System.out.print(prompt);
            score = scanner.nextInt();
            if (score < min || score > max) {
                System.out.println("Invalid input. Score must be between " + min + " and " + max);
            }
        } while (score < min || score > max);
        return score;
    }

    // Method to search for a student by name or ID
    public void searchStudent(Scanner scanner) {
        System.out.println("Search by (1) Student Name or (2) Student ID?");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (searchChoice == 1) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            for (Student student : students) {
                if (student.getStudentName().equalsIgnoreCase(studentName)) {
                    student.displayReport();
                    return;
                }
            }
            System.out.println("Student not found.");
        } else if (searchChoice == 2) {
            System.out.print("Enter student ID: ");
            String studentID = scanner.nextLine();
            for (Student student : students) {
                if (student.getStudentID().equalsIgnoreCase(studentID)) {
                    student.displayReport();
                    return;
                }
            }
            System.out.println("Student not found.");
        } else {
            System.out.println("Invalid option.");
        }
    }

    // Method to display a report of all students in the course
    public void displayCourseReport(Scanner scan) {
        System.out.println("\nReport for Course: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("===============================================");
        for (Student student : students) {
            student.displayReport();
            System.out.println("-----------------------------------------------");
        }
        // Ask the user whether they want to export the report
        System.out.println("Do you want to export this report? (yes/no)");
        String exportChoice = scan.nextLine();

        if (exportChoice.equalsIgnoreCase("yes")) {
            System.out.println("Choose export format (1) .txt or (2) .csv:");
            int formatChoice = scan.nextInt();
            scan.nextLine();  // Consume newline

            System.out.print("Enter file name (without extension): ");
            String fileName = scan.nextLine();

            if (formatChoice == 1) {
                exportReportToFile(fileName + ".txt");
            } else if (formatChoice == 2) {
                exportReportToCSV(fileName + ".csv");
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    // Export course report to a CSV file
    public void exportReportToCSV(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Student Name,Student ID,Test Score,Exam Score,Project Score,Total Score");
            for (Student student : students) {
                writer.println(
                        student.getStudentName() + "," +
                                student.getStudentID() + "," +
                                student.getGrading().getTestScore() + "," +
                                student.getGrading().getExamScore() + "," +
                                student.getGrading().getProjectScore() + "," +
                                student.getGrading().getTotalScore()
                );
            }
            System.out.println("Report exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting report: " + e.getMessage());
        }
    }

    // Export course report to file
    public void exportReportToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Report for Course: " + courseName);
            writer.println("Course Code: " + courseCode);
            writer.println("===============================================");
            for (Student student : students) {
                writer.println("Student Name: " + student.getStudentName());
                writer.println("Student ID: " + student.getStudentID());
                writer.println("Test Score: " + student.getGrading().getTestScore());
                writer.println("Exam Score: " + student.getGrading().getExamScore());
                writer.println("Project Score: " + student.getGrading().getProjectScore());
                writer.println("Total Score: " + student.getGrading().getTotalScore());
                writer.println("-----------------------------------------------");
            }
            System.out.println("Report exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting report: " + e.getMessage());
        }
    }

	/*
	 * @Override public String toString() { return "Course{" + "Course Name='" +
	 * courseName + '\'' + ", Course Instructor='" + courseInstructor + '\'' +
	 * ", Course Code='" + courseCode + '\'' + '}'; }
	 */
}
