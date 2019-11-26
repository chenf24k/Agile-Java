package com.chenfeng.studentinfo;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.testng.Assert.*;

@Test
public class RosterReporterTest {
    public void testRosterReport() {
        CourseSession session = new CourseSession("ENGL", "101", new DateUtil().createDate(2003, 1, 6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReporter(session).getReport();
        // System.out.println(rosterReport);
        Assert.assertEquals(
                RosterReporter.ROSTER_REPORT_HEADER +
                        "A" + RosterReporter.NEWLINE +
                        "B" + RosterReporter.NEWLINE +
                        RosterReporter.ROSTER_REPORT_FOOTER + "2" +
                        RosterReporter.NEWLINE
                , rosterReport);
    }
}