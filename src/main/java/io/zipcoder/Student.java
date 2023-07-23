package io.zipcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exam Scores:\n");
        for(int i=0; i<examScores.size(); i++) {
            sb.append(String.format("\tExam %d -> %.2f\n", i + 1, examScores.get(i)));
        }
        return sb.toString();
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        for(double exam: examScores) {
            sum += exam;
        }
        return sum/examScores.size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Student Name: %s %s\n", firstName, lastName));
        sb.append(String.format("> Average Score: %.2f\n", getAverageExamScore()));
        sb.append("> ");
        sb.append(getExamScores());
        return sb.toString();
    }
}
