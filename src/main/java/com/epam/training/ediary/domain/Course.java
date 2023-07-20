package com.epam.training.ediary.domain;

import java.util.Objects;

public class Course {
    /*--properties--*/
    Subject subject;
    Teacher teacher;
    SchoolClass schoolClass;

    /*--constructors--*/
    public Course() {
    }

    /*--methods--*/
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject p_subject) {
        this.subject = p_subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher p_teacher) {
        this.teacher = p_teacher;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass p_schoolClass) {
        this.schoolClass = p_schoolClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return subject == course.subject && Objects.equals(teacher, course.teacher) && Objects.equals(schoolClass, course.schoolClass);
    }
}
