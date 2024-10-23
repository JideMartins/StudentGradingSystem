package org.student.GradingSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
	// declare fields
	private String studentName;
	private String studentID;
	private Grading grading; // object of class Grade

	// initialize with constructor
	public Student(String studentName, String studentID) {
		this.studentName = studentName;
		this.studentID = studentID;
		this.grading = new Grading();
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentID() {
		return studentID;
	}

	public Grading getGrading() {
		return grading;
	}

	/*
	 * public void addGrade(Grade grade) { studentGrades.add(grade); }
	 */

	// Display student's grade report
    public void displayReport() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Test Score: " + grading.getTestScore());
        System.out.println("Exam Score: " + grading.getExamScore());
        System.out.println("Project Score: " + grading.getProjectScore());
        System.out.println("Total Score: " + grading.getTotalScore());
    }
}

