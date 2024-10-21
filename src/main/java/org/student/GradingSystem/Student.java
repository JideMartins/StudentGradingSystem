package org.student.GradingSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
	// declare fields
	private String studentName;
	private String studentId;
	private List<Grade> studentGrades; // object of class Grade
	private List<Course> enrolledCourses;

	// initialize with constructor
	public Student(String studentName, String studentId) {
		this.studentName = studentName;
		this.studentId = studentId;
		this.studentGrades = new ArrayList<>();
		this.enrolledCourses = new ArrayList<>();
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<Grade> getStudentGrades() {
		return studentGrades;
	}

	public void addGrade(Grade grade) {
		studentGrades.add(grade);
	}

	public double calculateAverage() {
		double total = 0; // default value
		for (Grade grade : studentGrades) {
			total += grade.getGradeScore();
		}
		return total / studentGrades.size();
	}

	// Method to enroll the student in a course
	public void enrollCourse(Course course) {
		if (!enrolledCourses.contains(course)) {
			enrolledCourses.add(course);
			System.out.println(studentName + " has been enrolled in " + course.getCourseName());
		} else {
			System.out.println(studentName + " is already enrolled in " + course.getCourseName());
		}
	}

	// Method to get the student's enrolled courses
	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	@Override
	public String toString() {
		return "Student{" + "Name='" + studentName + '\'' + ", ID='" + studentId + '\'' + ", Grade=" + studentGrades
				+ '}';
	}
}
