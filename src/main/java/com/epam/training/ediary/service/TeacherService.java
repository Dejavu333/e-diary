package com.epam.training.ediary.service;

import java.util.ArrayList;

import com.epam.training.ediary.domain.Course;
import com.epam.training.ediary.domain.Grade;
import com.epam.training.ediary.domain.Student;
import com.epam.training.ediary.domain.Teacher;

public interface TeacherService {
    /*--functions to be implemented--*/
    public ArrayList<Course> findCoursesByTeacher(Teacher teacher);

    public ArrayList<Student> getStudentsFromCourse(Course course);
    
    public Grade createGrade(Student student, Course course, Integer value);
}
