package com.epam.training.ediary.domain;

import java.time.LocalDate;

public class Grade {
    /*--properties--*/
    Integer value;
    LocalDate date;
    Course course;
    Student student;

    /*--constructors--*/
    public Grade() {
    }

    /*--methods--*/
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer p_value) {
        this.value = p_value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate p_date) {
        this.date = p_date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course p_course) {
        this.course = p_course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student p_student) {
        this.student = p_student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade that = (Grade) o;
        return this.value.equals(that.value) && this.date.equals(that.date)
        && this.course.equals(that.course) && this.student.equals(that.student);
    }
}
