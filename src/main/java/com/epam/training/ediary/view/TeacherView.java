package com.epam.training.ediary.view;

import java.util.List;

import com.epam.training.ediary.domain.Course;
import com.epam.training.ediary.domain.Grade;
import com.epam.training.ediary.domain.Student;
import com.epam.training.ediary.domain.Teacher;

public interface TeacherView {
    /*--functions to be implemented--*/
    void printWelcomeMessage(Teacher p_teacher);

    void printCourses(List<Course> p_courses);

    Course selectCourse(List<Course> p_courses);

    void printStudents (List<Student> p_students);

    Student selectStudent(List<Student> p_students);

    Integer readGradeValue();
    
    void printGrade(Grade p_grade);
}
