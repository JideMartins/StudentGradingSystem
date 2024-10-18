package org.student.GradingSystem;

public class Course {
    private String courseName;
    private String courseInstructor;
    private String courseCode;

    public Course(String courseName, String courseInstructor, String courseCode) {
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
        this.courseCode = courseCode;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Course Name='" + courseName + '\'' +
                ", Course Instructor='" + courseInstructor + '\'' +
                ", Course Code='" + courseCode + '\'' +
                '}';
    }
}

