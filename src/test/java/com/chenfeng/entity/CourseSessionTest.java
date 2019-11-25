package com.chenfeng.entity;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

@Test
public class CourseSessionTest {
    private CourseSession session;

    @BeforeClass
    public void setUp() {
        session = new CourseSession("ENGL", "101");
    }

    public void testCreate() {
        Assert.assertEquals("ENGL", session.getDepartment());
        Assert.assertEquals("101", session.getNumber());
        Assert.assertEquals(0, session.getNumberOfStudents());
    }

    public void testEnrollStudents() {
        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        Assert.assertEquals(1, session.getNumberOfStudents());
        Assert.assertEquals(student1, session.get(0));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        Assert.assertEquals(2, session.getNumberOfStudents());
        Assert.assertEquals(student1, session.get(0));
        Assert.assertEquals(student2, session.get(1));
    }

    public void testCourseDates() {
        int year = 103;
        int month = 0;
        int date = 6;
        Date startDate = new Date(year, month, date);
        CourseSession session = new CourseSession("ABCD", "200", startDate);
        year = 103;
        date = 3;
        Date sixteenWeeksOut = new Date(year, month, date);
        Assert.assertEquals(sixteenWeeksOut, session.getEndDate());
    }
}
