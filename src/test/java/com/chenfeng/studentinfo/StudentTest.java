package com.chenfeng.studentinfo;


import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class StudentTest {
    private static final double GRADE_TOLERANCE = 0.05;

    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        final Student firstStudent = new Student(firstStudentName);
        Assert.assertEquals(firstStudentName, firstStudent.getName());
    }

    public void testBadStatic() {
        Student studentA = new Student("a");
        Assert.assertEquals(studentA.getName(), "a");
        Student studentB = new Student("b");
        Assert.assertEquals(studentB.getName(), "b");
        Assert.assertEquals(studentA.getName(), "a");
    }

    public void testFullTime() {
        Student student = new Student("a");
        Assert.assertFalse(student.isFullTime());
    }

    public void testCredits() {
        Student student = new Student("a");
        Assert.assertEquals(student.getCredits(), 0);
        student.addCredits(3);
        Assert.assertEquals(3, student.getCredits());
        student.addCredits(4);
        Assert.assertEquals(7, student.getCredits());
    }

    public void testStudentStatus() {
        Student student = new Student("a");
        Assert.assertEquals(student.getCredits(), 0);
        Assert.assertFalse(student.isFullTime());

        student.addCredits(3);
        Assert.assertEquals(student.getCredits(), 3);
        Assert.assertFalse(student.isFullTime());

        student.addCredits(4);
        Assert.assertEquals(student.getCredits(), 7);
        Assert.assertFalse(student.isFullTime());

        student.addCredits(5);
        Assert.assertEquals(student.getCredits(), Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        Assert.assertTrue(student.isFullTime());
    }

    public void testInState() {
        Student student = new Student("a");
        Assert.assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        Assert.assertTrue(student.isInState());
        student.setState("MD");
        Assert.assertFalse(student.isInState());
    }

    public void testCalculateGpa() {
        // 在比较浮点数时，需要提供第是三个参数来表示允许的误差
        Student student = new Student("a");
        assertGpa(student, 0.0);
        student.addGrade(Student.Grade.A);
        assertGpa(student, 4.0);
        student.addGrade(Student.Grade.B);
        assertGpa(student, 3.5);
        student.addGrade(Student.Grade.C);
        assertGpa(student, 3.0);
        student.addGrade(Student.Grade.D);
        assertGpa(student, 2.5);
        student.addGrade(Student.Grade.F);
        assertGpa(student, 2.0);
    }

    private void assertGpa(Student student, double expectedGpa) {
        Assert.assertEquals(student.getGpa(), expectedGpa, GRADE_TOLERANCE);
    }

    public void testCalculateHonorsStudentGpa() {
        assertGpa(createHonorsStudent(), 0.0);
        assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
        assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
        assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
        assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
        assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
    }

    private Student createHonorsStudent(Student.Grade grade) {
        Student student = createHonorsStudent();
        student.addGrade(grade);
        return student;
    }

    private Student createHonorsStudent() {
        Student student = new Student("a");
        student.setHonors();
        return student;
    }
}
