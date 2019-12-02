package com.chenfeng.studentinfo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.chenfeng.studentinfo.ReportConstant.NEWLINE;

public class CourseReport {
    private List<CourseSession> sessions
            = new ArrayList<>();

    public void add(CourseSession session) {
        sessions.add(session);
    }

    public String text() {
//        Collections.sort(sessions);
        StringBuilder builder = new StringBuilder();
        for (CourseSession session : sessions) {
            builder.append(
                    session.getDepartment() + " " +
                            session.getNumber() + NEWLINE
            );
        }
        return builder.toString();
    }
}
