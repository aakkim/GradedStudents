package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void testConstructor() {
        //Given
        int maxNumStudents = 30;
        Student[] expected = new Student[maxNumStudents];

        //When
        Classroom classroom = new Classroom(maxNumStudents);
        Student[] actual = classroom.getStudents();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAverageExamScores() {
        //Given
        Student bob = new Student("bob", "belcher", new Double[]{87.0});
        Student linda = new Student("linda", "belcher", new Double[]{99.0});
        Classroom classroom = new Classroom(new Student[]{bob, linda});
        double expected = 93.0;
        //When
        double actual = classroom.getAverageExamScores();
        //Then
        Assert.assertEquals(expected, actual, .2f);
    }

    @Test
    public void testAddStudent() {
        //Given
        Classroom classroom = new Classroom();
        Student bob = new Student("bob", "belcher", new Double[]{87.0});
        Student[] students = new Student[30];
        students[0] = bob;
        //When
        classroom.addStudent(bob);
        //Then
        Assert.assertEquals(students, classroom.getStudents());
    }

    @Test
    public void testRemoveStudent() {
        //Given
        Classroom classroom = new Classroom();
        Student bob = new Student("bob", "belcher", new Double[]{87.0});
        Student linda = new Student("linda", "belcher", new Double[]{99.0});
        Student[] students = new Student[30];
        students[0] = bob;

        classroom.addStudent(bob);
        classroom.addStudent(linda);
        //When
        classroom.removeStudent("linda", "belcher");
        //Then
        Assert.assertEquals(students, classroom.getStudents());
    }



}
