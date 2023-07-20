package com.epam.training.ediary.service;

import java.util.ArrayList;

import com.epam.training.ediary.domain.Student;
import com.epam.training.ediary.persistence.DataStore;
import com.epam.training.ediary.domain.Course;
import com.epam.training.ediary.domain.Grade;

public class DefaultStudentService implements StudentService {
    /*--properties--*/
    DataStore dataStore;

    /*--constructors--*/
    public DefaultStudentService(DataStore p_dataStore) {
        this.dataStore = p_dataStore;
    }

    /*--methods--*/
    @Override
    public ArrayList<Course> findCoursesByStudent(Student p_student) {
        ArrayList<Course> l = new ArrayList<>();
        for (Course c : this.dataStore.getCourses()) {
            if (p_student.getSchoolClass().getName().equals(c.getSchoolClass().getName())) {
                l.add(c);
            }
        }
        return l;
    }

    @Override
    public ArrayList<Grade> findGradesByStudentAndCourse(Student p_student, Course p_course) {
        if (p_course.getSchoolClass().equals(p_student.getSchoolClass())==false)
        {
            throw new IllegalArgumentException();
        }
        ArrayList<Grade> l = new ArrayList<>();
        for (Grade g : this.dataStore.getGrades()) {
            if (g.getCourse().equals(p_course) && g.getStudent().equals(p_student))
                l.add(g);
        }
        return l;
    }
}
