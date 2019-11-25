package com.chenfeng.entity;

import org.junit.Assert;
import org.junit.Test;


public class StudentTest {
    @Test
    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        final Student firstStudent = new Student(firstStudentName);
        Assert.assertEquals(firstStudentName, firstStudent.getName());
    }
}
