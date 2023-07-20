package com.epam.training.ediary.persistence;

import com.epam.training.ediary.domain.*;
import java.util.List;

public interface DataStore {
    /*--functions to be implemented--*/
    public void init();

    public List<Student> getStudents();

    public List<Teacher> getTeachers();

    public List<Course> getCourses();

    public List<Grade> getGrades();

    public void saveGrade(Grade grade);
}
