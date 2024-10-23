package org.student.GradingSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * StudentGradingSystem Class manages students, courses, and grades. Allows
 * adding and displaying students and courses assigns grades to students
 */
public class StudentGradingSystem {
	
	public static void main(String[] args) {
        // Existing instructor setup (hardcoded)
        Instructor james = new Instructor("IN-06-001", "James Madisson", Arrays.asList(
                new Course("CS101", "Introduction to Programming"),
                new Course("CS102", "Data Structures")
        ));

        Instructor sara = new Instructor("IN-06-002", "Sara Connor", Arrays.asList(
                new Course("MATH101", "Calculus I")
        ));

        // Adding hardcoded students to courses
        Course cs101 = james.getCourses().get(0);
        cs101.addStudent(new Student("BPTN-06-001", "Alice"));
        cs101.addStudent(new Student("BPTN-06-002", "Bob"));

        Course cs102 = james.getCourses().get(1);
        cs102.addStudent(new Student("BPTN-06-003", "Charlie"));

        Course math101 = sara.getCourses().get(0);
        math101.addStudent(new Student("BPTN-06-004", "Diana"));
        math101.addStudent(new Student("BPTN-06-005", "Edward"));

        // Instructor login simulation
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Instructor ID: ");
        String instructorID = scanner.nextLine();

        Instructor currentInstructor = null;
        if (instructorID.equals(james.getInstructorID())) {
            currentInstructor = james;
        } else if (instructorID.equals(sara.getInstructorID())) {
            currentInstructor = sara;
        } else {
            System.out.println("Invalid Instructor ID.");
            return;
        }

        // Display instructor and course information
        System.out.println("Welcome, " + currentInstructor.getName() + "!");
        currentInstructor.displayCourses();

        // Select course
        System.out.println("Select a course by entering the course code:");
        String courseCode = scanner.nextLine();

        Course selectedCourse = null;
        for (Course course : currentInstructor.getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                selectedCourse = course;
                break;
            }
        }

        if (selectedCourse == null) {
            System.out.println("Invalid course code.");
            return;
        }

        System.out.println("You selected: " + selectedCourse.getCourseName());
        selectedCourse.displayStudents();

        // Next: Add grading functionality or other features based on menu
        manageCourseMenu(scanner, selectedCourse);
    }
	
	private static void manageCourseMenu(Scanner scanner, Course selectedCourse) {
        while (true) {
            System.out.println("\nOptions for managing course:");
            System.out.println("1. Add student grades");
            System.out.println("2. Search student by name or ID");
            System.out.println("3. Display course report");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    selectedCourse.addGrades(scanner);  // Call the method from Course class
                    break;
                case 2:
                    selectedCourse.searchStudent(scanner);  // Call the method from Course class
                    break;
                case 3:
                    selectedCourse.displayCourseReport(scanner);  // Call the method from Course class
                    break;
                case 4:
                    System.out.println("Exiting course management.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
	

	/*// Instance variables -- lists to store student and course objects
	private List<Student> students;
	private List<Course> courses;

	*//**
	 * Constructors initialize StudentGradingSystem with empty lists of students and
	 * courses 2nd constructor parameterized for flexibility Especially if there is
	 * data from another source
	 *//*
	public StudentGradingSystem() {
		this.students = new ArrayList<>();
		this.courses = new ArrayList<>();
		initializeCourses();
	}
//    public StudentGradingSystem(List<Student> students, List<Course> courses) {
//        this.students = students;
//        this.courses = courses;
//    }

	*//**
	 * adds a student to the system
	 * 
	 * @param student -> student to be added
	 *//*
	public void addStudent(Student student) {
		students.add(student);
	}

	*//**
	 * adds a course to the system
	 * 
	 * @param course -> course to be added
	 *//*
	public void addCourse(Course course) {
		courses.add(course);
	}

	*//**
	 * Helper method to find student by ID encapsulates logic to find student by ID
	 * Code was initially duplicated in assignGrade() and displayGrades()
	 * 
	 * @param studentId
	 * @return student if found, null if not found
	 *//*
	private Student findStudentId(String studentId) {
		for (Student student : students) {
			if (student.getStudentId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	*//**
	 * Uses findStudentId to locate the student.
	 * 
	 * @param studentId
	 * @param course
	 * @param gradeScore Adds the grade if the student is found and prints
	 *                   confirmation
	 *//*
	public void assignGrade(String studentId, Course course, double gradeScore) {
		Student student = findStudentId(studentId);
		if (student != null) {
			student.addGrade(new Grading(course, gradeScore));
			System.out.println("Grade added for student: " + student.getStudentName());
		} else {
			System.out.println("Student not found in database!");
		}

	}

	*//**
	 * Uses findStudentId to locate the student.
	 * 
	 * @param studentId Displays the grades if the student is found.
	 *//*
	public void displayGrades(String studentId) {
		Student student = findStudentId(studentId);
		if (student != null) {
			System.out.println("Grades for " + student.getStudentName() + ":");
			for (Grading grade : student.getStudentGrades()) {
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

	*//**
	 * Search courses with course code
	 * 
	 * @param courseCode eg "MATH101"
	 * @return Course object if found or null if not found
	 *//*
	public Course searchCourseByCode(String courseCode) {
		for (Course course : courses) {
			if (course.getCourseCode().equals(courseCode)) {
				return course;
			}
		}
		return null;
	}*/


}
