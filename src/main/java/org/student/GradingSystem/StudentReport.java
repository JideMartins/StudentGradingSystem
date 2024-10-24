package org.student.GradingSystem;

public class StudentReport {
    private String studentID;
    private String studentName;
    private int testScore;
    private int projectScore;
    private int examScore;
    private int totalScore;

    public StudentReport(String studentID, String studentName, int testScore, int projectScore, int examScore) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.testScore = testScore;
        this.projectScore = projectScore;
        this.examScore = examScore;
        this.totalScore = testScore + projectScore + examScore;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getTestScore() {
        return testScore;
    }

    public int getProjectScore() {
        return projectScore;
    }

    public int getExamScore() {
        return examScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
}


