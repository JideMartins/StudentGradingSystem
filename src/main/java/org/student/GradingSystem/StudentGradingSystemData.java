package org.student.GradingSystem;


import java.util.ArrayList;
import java.util.List;

public class StudentGradingSystemData {
    private static StudentGradingSystemData instance;
    private List<StudentReport> gradeBook;

    private StudentGradingSystemData() {
        gradeBook = new ArrayList<>();
    }

    public static StudentGradingSystemData getInstance() {
        if (instance == null) {
            instance = new StudentGradingSystemData();
        }
        return instance;
    }

    public void addGrade(StudentReport report) {
        gradeBook.add(report);
    }

    public List<StudentReport> getReportsForCourse(String course) {
        return gradeBook;  // Could filter by course if needed
    }
}

