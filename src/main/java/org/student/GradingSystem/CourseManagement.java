package org.student.GradingSystem;

import java.util.List;

public class CourseManagement {
	// to enroll students in a course
	public void enrollStudent(StudentGradingSystem system, Student student, Course course) {
		system.addStudent(student);
		System.out.println(student.getStudentName() + "has now been enrolled in: " + course.getCourseName());
	}

	// remove student from course
	public void removeStudent(StudentGradingSystem system, String studentId, String courseCode) {
		Student student = system.searchStudentsById(studentId);
		if (student != null) {
			Course course = system.searchCourseByCode(courseCode);
			if (course != null) {
				List<Grade> grades = student.getStudentGrades();
				grades.removeIf(grade -> grade.getCourse().getCourseCode().equals(courseCode));
				System.out.println(
						"Student " + student.getStudentName() + " removed from course " + course.getCourseName());
			} else {
				System.out.println("Course not found!");
			}
		} else {
			System.out.println("Student not found!");
		}
	}
}
