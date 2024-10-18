package org.student.GradingSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    //declare fields
    private String studentName;
    private String studentId;
    private List<Grade> studentGrades; //object of class Grade

    // initialize with constructor
    public Student(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentGrades = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Grade> getStudentGrades() {
        return studentGrades;
    }

    public void addGrade(Grade grade){
        studentGrades.add(grade);
    }

    public double calculateAverage(){
        double total = 0; //default value
        for(Grade grade: studentGrades){
            total += grade.getGradeScore();
        }
        return total/studentGrades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + studentName + '\'' +
                ", ID='" + studentId + '\'' +
                ", Grade=" + studentGrades +
                '}';
    }
}

