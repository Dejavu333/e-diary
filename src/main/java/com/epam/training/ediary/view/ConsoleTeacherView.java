package com.epam.training.ediary.view;

import java.io.Console;
import java.util.List;
import java.util.NoSuchElementException;

import com.epam.training.ediary.domain.Course;
import com.epam.training.ediary.domain.Grade;
import com.epam.training.ediary.domain.Student;
import com.epam.training.ediary.domain.Teacher;

public class ConsoleTeacherView implements TeacherView {
    /*--properties--*/

    /*--constructors--*/
    public ConsoleTeacherView() {
    }

    /*--methods--*/
    @Override
    public void printWelcomeMessage(Teacher p_teacher) {
        System.out.println("_______________________");
        System.out.println(
            "Login Name: " + p_teacher.getCredentials().getLoginName() + "\n" +
            "Password: " + p_teacher.getCredentials().getPassword() + "\n" +
            "Welcome Teacher: " + p_teacher.getName());
    }

    @Override
    public void printCourses(List<Course> p_courses) {
        System.out.println("_______________________");
        System.out.println("Your Courses:");
        int no = 1;
        for (Course c : p_courses) {
  
            System.out.println(no + ". SUBJECT: " + c.getSubject() + ", School Class: " + c.getSchoolClass().getName());
            no=no+1;
        }
    }

    @Override
    public void printStudents(List<Student> p_students) {
        System.out.println("_______________________");
        System.out.println("Your Students:");
        int no = 1;
        for (Student s : p_students) {
            
            System.out.println(no + ". Student Name: " + s.getName());
            no=no+1;
        }
    }

    @Override
    public Course selectCourse(List<Course> p_courses) {
        System.out.println("Choose A Course (1-"+p_courses.size()+")");
        Console c = System.console();
        Integer courseNo = Integer.parseInt(c.readLine());
        if(courseNo<1 || courseNo>p_courses.size())
        {
        }
        return p_courses.get(courseNo-1);
    }

    @Override
    public Student selectStudent(List<Student> p_students) {
        System.out.println("Choose A Student (1-"+p_students.size()+")");
        Console c = System.console();
        Integer studentNo = Integer.parseInt(c.readLine());
        if(studentNo<1 || studentNo>p_students.size())
        {
        }
        return p_students.get(studentNo-1);
    }

    @Override
    public Integer readGradeValue() {
        System.out.println("Enter a grade (1-5)");
        Console c = System.console();
        Integer gradeValue = Integer.parseInt(c.readLine());
        return gradeValue;
    }

    @Override
    public void printGrade(Grade p_grade) {
        System.out.println(
            "Grade: " + p_grade.getValue() +      
            "\nStudent: Name: " + p_grade.getStudent().getName() +   
            "\nDate: " + p_grade.getDate()
        );
    }
}
