package io.zipcoder;

import java.util.Arrays;

import java.util.HashMap;

public class Classroom {

    Student[] students;

    public Classroom() {
        students = new Student[30];
    }

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScores() {
        double sum = 0.0;
        for(Student s: students) {
            sum += s.getAverageExamScore();
        }
        return sum/students.length;
    }

    public void addStudent(Student student) {
        for(int i=0; i<students.length; i++) {
            if(students[i]==null) {
                students[i] = student;
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        int nullIdx = 0;
        for(int i=0; i<students.length; i++) {
            if(students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                students[i] = null;
                nullIdx = i; // set variable to the index containing student to remove
                break;
            }
        }
        for(int i=nullIdx; i<students.length-1; i++) {
            students[i] = students[i+1];
            students[students.length-1] = students[nullIdx];
        }
    }

    public Student[] getStudentsByScore() {
        Student[] descendingScores = Arrays.copyOf(students, students.length);
        for(int i=0; i<descendingScores.length-1; i++) {
            if(descendingScores[i].getAverageExamScore() < descendingScores[i+1].getAverageExamScore()) {
                Student temp = descendingScores[i];
                descendingScores[i] = descendingScores[i+1];
                descendingScores[i+1] = temp;
            }
        }
        return descendingScores;
    }

    public HashMap<Student, Character> getGradeBook() {
        HashMap<Student, Character> gradeBook = new HashMap<>();
        Student[] rankStudents = getStudentsByScore();
        for(int i=0; i< rankStudents.length; i++) {
            if(((i+1)/rankStudents.length)*100 <= 10) {
                gradeBook.put(students[i], 'A');
            } else if(((i+1)/rankStudents.length)*100 <= 29) {
                gradeBook.put(students[i], 'B');
            } else if(((i+1)/rankStudents.length)*100 <= 50) {
                gradeBook.put(students[i], 'C');
            } else if(((i+1)/rankStudents.length)*100 <= 89) {
                gradeBook.put(students[i], 'D');
            } else {
                gradeBook.put(students[i], 'F');
            }
        }
        return gradeBook;
    }


}
