package org.student.GradingSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentGradingSystem Class manages students, courses, and grades. Allows
 * adding and displaying students and courses assigns grades to students
 */
public class StudentGradingSystem {

	// Instance variables -- lists to store student and course objects
	private List<Student> students;
	private List<Course> courses;

	/**
	 * Constructors initialize StudentGradingSystem with empty lists of students and
	 * courses 2nd constructor parameterized for flexibility Especially if there is
	 * data from another source
	 */
	public StudentGradingSystem() {
		this.students = new ArrayList<>();
		this.courses = new ArrayList<>();
	}

	public StudentGradingSystem(List<Student> students, List<Course> courses) {
		this.students = students;
		this.courses = courses;
	}

	/**
	 * adds a student to the system
	 * 
	 * @param student -> student to be added
	 */
	public void addStudent(Student student) {
		students.add(student);
	}

	/**
	 * adds a course to the system
	 * 
	 * @param course -> course to be added
	 */
	public void addCourse(Course course) {
		courses.add(course);
	}

	/**
	 * Helper method to find student by ID encapsulates logic to find student by ID
	 * Code was initially duplicated in assignGrade() and displayGrades()
	 * 
	 * @param studentId
	 * @return student if found, null if not found
	 */
	private Student findStudentId(String studentId) {
		for (Student student : students) {
			if (student.getStudentId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	/**
	 * Uses findStudentId to locate the student.
	 * 
	 * @param studentId
	 * @param course
	 * @param gradeScore Adds the grade if the student is found and prints
	 *                   confirmation
	 */
	public void assignGrade(String studentId, Course course, double gradeScore) {
		Student student = findStudentId(studentId);
		if (student != null) {
			student.addGrade(new Grade(course, gradeScore));
			System.out.println("Grade added for student: " + student.getStudentName());
		} else {
			System.out.println("Student not found in database!");
		}

	}

	/**
	 * Uses findStudentId to locate the student.
	 * 
	 * @param studentId Displays the grades if the student is found.
	 */
	public void displayGrades(String studentId) {
		Student student = findStudentId(studentId);
		if (student != null) {
			System.out.println("Grades for " + student.getStudentName() + ":");
			for (Grade grade : student.getStudentGrades()) {
				System.out.println(grade);
			}
		} else {
			System.out.println("Student not found in database!");
		}
	}

	public void displayStudents() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
