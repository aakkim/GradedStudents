package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testConstructor() {
        //Given
        String firstName = "first";
        String lastName = "last";
        Double[] examScores = {100.0, 98.0, 85.0};

        //When
        Student student = new Student(firstName, lastName, examScores);

        //Then
        Assert.assertEquals(firstName, student.getFirstName());
        Assert.assertEquals(lastName, student.getLastName());
        Assert.assertEquals(3, student.getNumberOfExamsTaken());
    }

    @Test
    public void testSetName() {
        //Given
        String firstName = "first";
        String lastName = "last";
        Double[] examScores = {100.0, 98.0, 85.0};

        //When
        Student student = new Student(firstName, lastName, examScores);
        student.setFirstName("Bob");
        student.setLastName("Belcher");

        //Then
        Assert.assertEquals("Bob", student.getFirstName());
        Assert.assertEquals("Belcher", student.getLastName());
    }

    @Test
    public void testAddExam() {
        //Given
        String firstName = "first";
        String lastName = "last";
        Double[] examScores = {100.0, 98.0, 85.0};

        //When
        Student student = new Student(firstName, lastName, examScores);
        student.addExamScore(99.0);

        //Then
        Assert.assertEquals(4, student.getNumberOfExamsTaken());
    }

    @Test
    public void testSetExam() {
        //Given
        String firstName = "first";
        String lastName = "last";
        Double[] examScores = {65.0, 100.0, 98.0, 85.0};

        //When
        Student student = new Student(firstName, lastName, examScores);
        student.setExamScore(1, 80.0);

        //Then
        Assert.assertEquals(90.8, student.getAverageExamScore(), .2f);
    }
}