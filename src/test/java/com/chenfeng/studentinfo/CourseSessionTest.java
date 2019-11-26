package com.chenfeng.studentinfo;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Test
public class CourseSessionTest {
    private CourseSession session;
    private Date startDate;

    @BeforeClass
    public void setUp() {
        startDate = new DateUtil().createDate(2003, 1, 6);
        session = new CourseSession("ENGL", "101", startDate);
    }

    public void testCreate() {
        Assert.assertEquals(session.getDepartment(), "ENGL");
        Assert.assertEquals(session.getNumber(), "101");
        Assert.assertEquals(session.getNumberOfStudents(), 0);
        Assert.assertEquals(session.getStartDate(), startDate);
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
        Date sixteenWeeksOut = new DateUtil().createDate(2003, 4, 25);
        Assert.assertEquals(sixteenWeeksOut, session.getEndDate());
    }
}
