package com.chenfeng.studentinfo;

import java.util.*;

public class CourseSession implements Comparable<CourseSession> {
    private String department;
    private String number;
    private List<Student> students = new ArrayList<Student>();
    private Date startDate;
    private static int count;
    private int numberOfCredits;

    /**
     * 返回当前课程学生的数量
     *
     * @return students.size()
     */
    public int getNumberOfStudents() {
        return students.size();
    }

    /**
     * 当前课程添加学生
     *
     * @param student 传入学生对象
     */
    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    /**
     * 根据index索引返回学生对象
     *
     * @param index 学生集合的索引
     * @return students.get(index)
     */
    public Student get(int index) {
        return students.get(index);
    }

    /**
     * 通过用户输入的开始时间，计算出结束时间
     *
     * @return endDate
     */
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = 16 * 7 - 3;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Date getStartDate() {
        return startDate;
    }

    /**
     * CourseSession类计数方法
     */
    public static void incrementCount() {
        ++count;
    }

    public static int getCount() {
        return count;
    }

    public static void resetCount() {
        count = 0;
    }

    /**
     * 工厂方法，用于生产CourseSession对象
     *
     * @param department 学科
     * @param number     课程编号
     * @param startDate  开始时间
     * @return CourseSession对象
     */
    public static CourseSession create(String department, String number, Date startDate) {
        CourseSession.incrementCount();
        return new CourseSession(department, number, startDate);
    }

    private CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public String getDepartment() {
        return department;
    }


    public String getNumber() {
        return number;
    }


    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    /**
     * @param that
     * @return 0: 两个对象相同，
     * 负数: 参数在后
     * 正数: 参数在前
     * <p>
     * 先比较学科名，相同时比较编号ß
     */
    @Override
    public int compareTo(CourseSession that) {
        int compare = this.getDepartment().compareTo(that.getDepartment());
        if (compare == 0)
            compare = this.getNumber().compareTo(that.getNumber());
        return compare;
    }
}
