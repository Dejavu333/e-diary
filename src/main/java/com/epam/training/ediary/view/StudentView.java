package com.epam.training.ediary.view;

import java.util.List;

import com.epam.training.ediary.domain.Course;
import com.epam.training.ediary.domain.Grade;
import com.epam.training.ediary.domain.Student;

public interface StudentView {
    /*--functions to be implemented--*/
    void printWelcomeMessage(Student p_student);

    void printCourses(List<Course> p_courses);

    Course selectCourse(List<Course> p_courses);

    void printGrades(List<Grade> p_grades);

    boolean isFinished();
}
