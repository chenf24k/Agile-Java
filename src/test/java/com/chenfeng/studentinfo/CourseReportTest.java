package com.chenfeng.studentinfo;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

import static com.chenfeng.studentinfo.RosterReporter.NEWLINE;

@Test
public class CourseReportTest {
    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create("ENGL", "101", date));
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL", "410", date));
        report.add(CourseSession.create("CZEC", "220", date));
        report.add(CourseSession.create("ITAL", "330", date));

        Assert.assertEquals(
                report.text(),
                "CZEC 200" + NEWLINE +
                        "CZEC 220" + NEWLINE +
                        "ENGL 101" + NEWLINE +
                        "ITAL 330" + NEWLINE +
                        "ITAL 410" + NEWLINE
        );
    }
}
