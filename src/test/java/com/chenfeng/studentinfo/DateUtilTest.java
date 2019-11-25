package com.chenfeng.studentinfo;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.testng.Assert.*;

@Test
public class DateUtilTest {
    public void testCreateDate() {
        Date date = new DateUtil().createDate(2000, 1, 1);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

    }
}