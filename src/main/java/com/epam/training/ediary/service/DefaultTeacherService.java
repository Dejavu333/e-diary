package com.epam.training.ediary.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.epam.training.ediary.domain.Student;
import com.epam.training.ediary.domain.Teacher;
import com.epam.training.ediary.persistence.DataStore;
import com.epam.training.ediary.domain.Course;
import com.epam.training.ediary.domain.Grade;

public class DefaultTeacherService implements TeacherService {
    /*--properties--*/
    DataStore dataStore;

    /*--constructors--*/
    public DefaultTeacherService(DataStore p_dataStore) {
        this.dataStore = p_dataStore;
    }

    /*--methods--*/
    @Override
    public ArrayList<Course> findCoursesByTeacher(Teacher p_teacher) {
        ArrayList<Course> l = new ArrayList<>();
        for (Course c : this.dataStore.getCourses()) {
            if (p_teacher.equals(c.getTeacher())) {
                l.add(c);
            }
        }
        return l;
    }

    @Override
    public ArrayList<Student> getStudentsFromCourse(Course p_course) {
        ArrayList<Student> l = new ArrayList<>();
        for (Student s : this.dataStore.getStudents()) {
            if (p_course.getSchoolClass().getName().equals(s.getSchoolClass().getName())) {
                l.add(s);
            }
        }
        return l;
    }

    @Override
    public Grade createGrade(Student p_student, Course p_course, Integer p_value) {
        if (p_course.getSchoolClass().equals(p_student.getSchoolClass())==false)
        {
            throw new IllegalArgumentException();
        }
        LocalDate date = LocalDate.now();
        Grade grade = new Grade();
        grade.setStudent(p_student);
        grade.setCourse(p_course);
        grade.setValue(p_value);
        grade.setDate(date);
        return grade;
    }
}
