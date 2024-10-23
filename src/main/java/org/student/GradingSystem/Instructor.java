package org.student.GradingSystem;

import java.util.List;

public class Instructor {
	private String instructorID;
	private String name;
	private List<Course> courses; // Courses instructor teaches

	// Constructor
	public Instructor(String instructorID, String name, List<Course> courses) {
		this.instructorID = instructorID;
		this.name = name;
		this.courses = courses;
	}

	public String getInstructorID() {
		return instructorID;
	}

	public String getName() {
		return name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	// Display courses
	public void displayCourses() {
		System.out.println("Courses handled by " + this.name + ":");
		for (Course course : courses) {
			System.out.println(course.getCourseCode() + " - " + course.getCourseName());
		}
	}

}
