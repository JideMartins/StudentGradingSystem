package org.student.GradingSystem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentGradingSystem system = new StudentGradingSystem();
		Scanner scanner = new Scanner(System.in);

		Student student1 = new Student("Biola Lawal", "OB00124");
		Student student2 = new Student("Doe Smith", "OB00224");
		Student student3 = new Student("Lara Lu", "OB00324");
		Student student4 = new Student("Diaz Anderson", "OB00424");

		Course course1 = new Course("Programming Fundamentals", "Dr. Martins", "CPP101");
		Course course2 = new Course("Engineering Mechanics", "Ms. Lauren", "EGN106");
		Course course3 = new Course("Physics", "Prof. Akin", "PHS102");
		Course course4 = new Course("Data Structures", "Dr. Martins", "CPP103");

		system.addStudent(student1);
		system.addStudent(student2);
		system.addStudent(student3);
		system.addStudent(student4);

		system.addCourse(course1);
		system.addCourse(course2);
		system.addCourse(course3);
		system.addCourse(course4);

		// Assign grades
		system.assignGrade("OB00124", course1, 80.6);
		system.assignGrade("OB00124", course2, 70.5);
		system.assignGrade("OB00224", course3, 90);
		system.assignGrade("OB00424", course4, 95.6);

		// Display student grades
		system.displayStudents();
		system.displayGrades("OB00124");
	}

}
