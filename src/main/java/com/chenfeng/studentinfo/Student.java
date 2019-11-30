package com.chenfeng.studentinfo;


public class Student {
    private String name;
    private int credits;
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

    static final String IN_STATE = "CO";
    private String state = "";

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

    boolean isInState() {
        return state.toUpperCase().equals(Student.IN_STATE);
    }

}
