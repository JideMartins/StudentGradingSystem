package org.student.GradingSystem;

import java.util.List;

public class Instructor {
	private String instructorName;
	private List<Course> instructorCourses; // Courses instructor teaches

	/**
	 * Constructor
	 *
	 * @param instructorName
	 * @param instructorCourses
	 */
	public Instructor(String instructorName, List<Course> instructorCourses) {
		this.instructorName = instructorName;
		this.instructorCourses = instructorCourses;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public List<Course> getInstructorCourses() {
		return instructorCourses;
	}

	public void addStudentToCourse(StudentGradingSystem system, String studentId, Course course, double gradeScore) {
		system.assignGrade(studentId, course, gradeScore);
	}

	public void viewStudents(StudentGradingSystem system, String courseCode) {
		Course course = system.searchCourseByCode(courseCode);

		if (course != null) {
			System.out.println("Student in " + course.getCourseName() + ":");
			for (Student student : system.getStudents()) {
				for (Grade grade : student.getStudentGrades()) {
					if (grade.getCourse().equals(course)) {
						System.out.println(student.getStudentName() + " — Grade: " + grade.getGradeScore());
					}
				}
			}
		} else {
			System.out.println("Course not found!");
		}
	}

}
