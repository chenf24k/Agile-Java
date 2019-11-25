package com.chenfeng.entity;

import java.util.*;

public class CourseSession {
    private String department;
    private String number;
    private List<Student> students = new ArrayList<Student>();
    private Date startDate;

    /**
     * 返回当前课程学生的数量
     *
     * @return
     */
    public int getNumberOfStudents() {
        return students.size();
    }

    /**
     * 当前课程添加学生
     *
     * @param student
     */
    public void enroll(Student student) {
        students.add(student);
    }

    /**
     * 根据index索引返回学生对象
     *
     * @param index
     * @return
     */
    public Student get(int index) {
        return students.get(index);
    }

    /**
     * 通过用户输入的开始时间，计算出结束时间
     *
     * @return
     */
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = 16 * 7 - 3;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        Date endDate = calendar.getTime();
        return endDate;
    }

    public CourseSession(String department, String number) {
        this.department = department;
        this.number = number;
    }

    public CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
