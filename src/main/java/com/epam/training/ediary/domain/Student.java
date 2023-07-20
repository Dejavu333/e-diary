package com.epam.training.ediary.domain;

import java.util.Objects;

public class Student extends User {
    /*--properties--*/
    // inherited+
    SchoolClass schoolClass;

    /*--constructors--*/
    public Student() {
    }

    /*--methods--*/
    // inherited+
    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(schoolClass, student.schoolClass);
    }
}
