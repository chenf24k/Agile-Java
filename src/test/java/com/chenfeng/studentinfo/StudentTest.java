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
}
