package com.epam.training.ediary.view;

import java.io.Console;
import java.util.List;

import com.epam.training.ediary.domain.Course;
import com.epam.training.ediary.domain.Grade;
import com.epam.training.ediary.domain.Student;

public class ConsoleStudentView implements StudentView {
    /*--properties--*/

    /*--constructors--*/
    public void ConsoleStudentView() {}
    
    /*--methods--*/
    @Override
    public void printWelcomeMessage(Student p_student) {
        System.out.println("_______________________");
        System.out.println(
        "Welcome Student: " + p_student.getName() + 
        "\nYour Class: " + p_student.getSchoolClass().getName());
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
    public void printGrades(List<Grade> p_grades) {
        System.out.println("_______________________");
        System.out.print("Grades: ");
        System.out.print(p_grades.get(0).getValue());
        for (Grade g: p_grades.subList(1, p_grades.size())) {
            System.out.print(", " + g.getValue());
        }
    }

    @Override
    public boolean isFinished() {
        System.out.println("\n_______________________");
        System.out.println("Are You Finished? (y/n): ");
        Console c = System.console();
        String answer = c.readLine().toLowerCase();
        boolean a = false;
        if(answer.equals("y") || answer.equals("yes")) {
            a=true;
        }
        else if(answer.equals("n") || answer .equals("no")) {
            a=false;
        }
        return a;
    }
}
