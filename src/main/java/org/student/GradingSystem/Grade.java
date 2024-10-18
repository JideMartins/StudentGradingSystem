package org.student.GradingSystem;

/**
 * Grade class Encapsulates the course details and the score
 */
public class Grade {
	// declare fields
	private Course course; // Store course associated with grade
	private double gradeScore;

	/**
	 * Initialize the course and score variables when the Grade object is created
	 * 
	 * @param course     Assign the provided course to the instance variable
	 * @param gradeScore Assign the provided score to the instance variable
	 */
	public Grade(Course course, double gradeScore) {
		this.course = course;
		this.gradeScore = gradeScore;
	}

	// Retrieve course and grade score

	/**
	 * Access Course object details (name, instructor, code)
	 * 
	 * @return Course object
	 */
	public Course getCourse() {
		return course;
	}

	public double getGradeScore() {
		return gradeScore;
	}

	@Override
	public String toString() {
		return "Grade{" + "Course Name=" + course.getCourseName() + ", Grade score=" + gradeScore + '}';
	}
}
