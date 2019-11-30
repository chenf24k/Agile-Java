package com.chenfeng.studentinfo;


import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class StudentTest {
    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        final Student firstStudent = new Student(firstStudentName);
        Assert.assertEquals(firstStudentName, firstStudent.getName());
    }

    public void testBadStatic() {
        Student studentA = new Student("a");
        Assert.assertEquals(studentA.getName(), "a");
        Student studentB = new Student("b");
        Assert.assertEquals(studentB.getName(), "b");
        Assert.assertEquals(studentA.getName(), "a");
    }

    public void testFullTime() {
        Student student = new Student("a");
        Assert.assertFalse(student.isFullTime());
    }

    public void testCredits() {
        Student student = new Student("a");
        Assert.assertEquals(student.getCredits(), 0);
        student.addCredits(3);
        Assert.assertEquals(3, student.getCredits());
        student.addCredits(4);
        Assert.assertEquals(7, student.getCredits());
    }

    public void testStudentStatus() {
        Student student = new Student("a");
        Assert.assertEquals(student.getCredits(), 0);
        Assert.assertFalse(student.isFullTime());

        student.addCredits(3);
        Assert.assertEquals(student.getCredits(), 3);
        Assert.assertFalse(student.isFullTime());

        student.addCredits(4);
        Assert.assertEquals(student.getCredits(), 7);
        Assert.assertFalse(student.isFullTime());

        student.addCredits(5);
        Assert.assertEquals(student.getCredits(), Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        Assert.assertTrue(student.isFullTime());
    }
}
