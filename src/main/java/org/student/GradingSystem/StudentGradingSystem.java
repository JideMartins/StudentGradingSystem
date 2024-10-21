package org.student.GradingSystem;

import java.util.ArrayList;
import java.util.Collections;
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
		initializeCourses();
	}
//    public StudentGradingSystem(List<Student> students, List<Course> courses) {
//        this.students = students;
//        this.courses = courses;
//    }

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

	// Initialize hard-coded courses
	private void initializeCourses() {
		courses.add(new Course("Mathematics", "Ms. Lola Rey", "MATH101"));
		courses.add(new Course("Physics", "Dr. Jide", "PHYS101"));
		courses.add(new Course("Chemistry", "Prof. Ayo", "CHEM101"));
		courses.add(new Course("Biology", "Ms. Ayomide", "BIOL101"));
		courses.add(new Course("History", "Dr. Hussein", "HIST101"));
		courses.add(new Course("English", "Dr. Shakespeare", "ENG101"));
		courses.add(new Course("Computer Science", "Dr. Bell", "CS101"));
		courses.add(new Course("Web Development", "Mrs. Smith", "WEB101"));
		courses.add(new Course("Art", "Mr. Picasso", "ART101"));
		courses.add(new Course("Physical Education", "Mr. Niel Armstrong", "PE101"));
	}

	// Method to get the list of courses (as immutable)
	public List<Course> getCourses() {
		return Collections.unmodifiableList(courses);
	}

	// Get all students
	public List<Student> getStudents() {
		return students;
	}

	// Search student by ID for assigning and viewing grades
	public Student searchStudentsById(String studentId) {
		for (Student student : students) {
			if (student.getStudentId().equals(studentId)) {
				return student;
			}
		}
		return null; // return null when there is no student found.
	}

	/**
	 * Search courses with course code
	 * 
	 * @param courseCode eg "MATH101"
	 * @return Course object if found or null if not found
	 */
	public Course searchCourseByCode(String courseCode) {
		for (Course course : courses) {
			if (course.getCourseCode().equals(courseCode)) {
				return course;
			}
		}
		return null;
	}

}
