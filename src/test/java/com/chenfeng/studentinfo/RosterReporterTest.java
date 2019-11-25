package com.chenfeng.studentinfo;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.testng.Assert.*;

@Test
public class RosterReporterTest {

    public Date createDate(int year, int month, int date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, date);
        return calendar.getTime();
    }

    public void testRosterReport() {
        CourseSession session = new CourseSession("ENGL", "101", createDate(2003, 1, 6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReporter(session).getReport();
        Assert.assertEquals(
                RosterReporter.ROSTER_REPORT_HEADER +
                        "A" + RosterReporter.NEWLINE +
                        "B" + RosterReporter.NEWLINE +
                        RosterReporter.ROSTER_REPORT_FOOTER + "2" +
                        RosterReporter.NEWLINE
                , rosterReport);
    }
}