package org.student.GradingSystem;

/**
 * Grade class
 * Encapsulates the course details and the score
 */
public class Grading {
    //declare fields
    private int testScore; //Store course associated with grade
    private int projectScore;
    private int examScore;


    public int getTestScore() {
        return testScore;
    }
    

    public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

    public int getProjectScore() {
        return projectScore;
    }
    
    public void setProjectScore(int projectScore) {
        this.projectScore = projectScore;
    }

	public double getExamScore() {
        return examScore;
    }
	
	public void setExamScore(int examScore) {
        this.examScore = examScore;
    }
	
	public int getTotalScore() {
        return testScore + projectScore + examScore;
    }


	/*
	 * @Override public String toString() { return "Grade{" + "Course Name=" +
	 * course.getCourseName() + ", Grade score=" + gradeScore + '}'; }
	 */

}

