package com.chenfeng.studentinfo;


import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int credits;
    private List<Grade> grades = new ArrayList<>();
    private boolean isHonors = false;
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

    static final String IN_STATE = "CO";
    private String state = "";

    enum Grade {A, B, C, D, F}

    public Student(final String name) {
        this.name = name;
        credits = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回学生是否为全职学生,学分大于12分时为全职学生
     *
     * @return boolean
     */
    public boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    int getCredits() {
        return credits;
    }

    void addCredits(int credits) {
        this.credits += credits;
    }

    void setState(String state) {
        this.state = state;
    }

    /**
     * 判断学生是否是本州的学生
     *
     * @return boolean
     */
    boolean isInState() {
        return state.toUpperCase().equals(Student.IN_STATE);
    }

    /**
     * 将成绩添加到grades
     *
     * @param grade
     */
    void addGrade(Grade grade) {
        grades.add(grade);
    }

    /**
     * 输出学生的平均成绩
     *
     * @return double
     */
    double getGpa() {
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;
        for (Grade grade : grades) {
            total += gradePointsFor(grade);
        }
        return total / grades.size();
    }

    public void setHonors() {
        isHonors = true;
    }


    /**
     * 如何是荣誉学生，会比一般的多+1分
     *
     * @param grade 成绩
     * @return int
     */
    int gradePointsFor(Grade grade) {
        int points = basicGradePointsFor(grade);
        if (isHonors)
            if (points > 0)
                points += 1;
        return points;
    }

    /**
     * 根据字母返回一个双精度的数值（成绩）
     *
     * @param grade 成绩
     * @return int
     */
    private int basicGradePointsFor(Grade grade) {
        if (grade == Grade.A) return 4;
        if (grade == Grade.B) return 3;
        if (grade == Grade.C) return 2;
        if (grade == Grade.D) return 1;
        return 0;
    }
}
