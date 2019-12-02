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
    private static final int CREDTIS = 3;

    @BeforeClass
    public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createCourseSession();
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
        Assert.assertEquals(student1.getCredits(), CREDTIS);
        Assert.assertEquals(session.getNumberOfStudents(), 1);
        Assert.assertEquals(student1, session.get(0));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        Assert.assertEquals(student2.getCredits(), CREDTIS);
        Assert.assertEquals(session.getNumberOfStudents(), 2);
        Assert.assertEquals(student1, session.get(0));
        Assert.assertEquals(student2, session.get(1));
    }

    public void testCourseDates() {
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        Assert.assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    public void testCount() {
        CourseSession.resetCount();
        createCourseSession();
        Assert.assertEquals(CourseSession.getCount(), 1);
        createCourseSession();
        Assert.assertEquals(CourseSession.getCount(), 2);
    }

    public void testComparable() {
        final Date date = new Date();
        CourseSession sessionA = CourseSession.create("CMSC", "101", date);
        CourseSession sessionB = CourseSession.create("ENGL", "101", date);
        Assert.assertTrue(sessionA.compareTo(sessionB) < 0);
        Assert.assertTrue(sessionB.compareTo(sessionA) > 0);

        CourseSession sessionC = CourseSession.create("CMSC", "101", date);
        Assert.assertEquals(sessionA.compareTo(sessionC), 0);

        CourseSession sessionD = CourseSession.create("CMSC", "210", date);
        Assert.assertTrue(sessionC.compareTo(sessionD) < 0);
        Assert.assertTrue(sessionD.compareTo(sessionC) > 0);
    }

    private CourseSession createCourseSession() {
        CourseSession session = CourseSession.create("ENGL", "101", startDate);
        session.setNumberOfCredits(CourseSessionTest.CREDTIS);
        return session;
    }
}
