package com.epam.training.ediary.service;

import java.util.List;

import com.epam.training.ediary.domain.Course;
import com.epam.training.ediary.domain.Grade;
import com.epam.training.ediary.domain.Student;

public interface StudentService {
    /*--functions to be implemented--*/
    public List<Course> findCoursesByStudent(Student student);
    
    public List<Grade> findGradesByStudentAndCourse(Student student, Course course);
}
