package org.student.GradingSystem;

/**
 * The Grading class represents a student's scores for tests, projects, and exams.
 * It includes validation to ensure scores are within acceptable ranges.
 */

public class Grading {

    private int testScore;
    private int projectScore;
    private int examScore;

    // Getters
    public int getTotalScore() {
        return testScore + projectScore + examScore;
    }

    /**
     * Constructor to initialize a Grading object with the specified scores.
     * Validates that the inputted scores are within acceptable ranges.
     *
     * @param testScore    The test score (0-30).
     * @param projectScore The project score (0-20).
     * @param examScore    The exam score (0-50).
     * @throws IllegalArgumentException if any score is out of range.
     */
    public Grading(int testScore, int projectScore, int examScore) {
        if (testScore < 0 || testScore > 30 || projectScore < 0 || projectScore > 20 || examScore < 0 || examScore > 50) {
            throw new IllegalArgumentException("Invalid scores. Test: 0-30, Project: 0-20, Exam: 0-50.");
        }
        this.testScore = testScore;
        this.projectScore = projectScore;
        this.examScore = examScore;
    }


}
