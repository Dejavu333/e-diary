package com.epam.training.ediary;

import com.epam.training.ediary.persistence.*;

import java.util.ArrayList;

import com.epam.training.ediary.domain.*;
import com.epam.training.ediary.view.*;
import com.epam.training.ediary.service.*;

class App {

    public static void main(String[] args) {

        /*--login--*/
        ConsoleUserView userView = new ConsoleUserView();

        try {
            Credentials credentials = userView.readCredentials();
            
            DefaultDataStore defaultDataStore = new DefaultDataStore(System.getProperty("user.dir") + "/input");
            defaultDataStore.init();
            DefaultUserService defaultUserService = new DefaultUserService(defaultDataStore);
            User user = defaultUserService.authenticate(credentials);

            /*--student--*/
            if (user instanceof Student) {
                ConsoleStudentView consoleStudentView = new ConsoleStudentView();
                DefaultStudentService defaultStudentService = new DefaultStudentService(defaultDataStore);

                Student student = (Student) user;

                consoleStudentView.printWelcomeMessage(student);
                ArrayList<Course> courses = defaultStudentService.findCoursesByStudent(student);
                consoleStudentView.printCourses(courses);

                do {
                    Course course = consoleStudentView.selectCourse(courses);
                    ArrayList<Grade> grades = defaultStudentService.findGradesByStudentAndCourse(student, course);
                    try {
                        consoleStudentView.printGrades(grades);
                    }
                    catch(Exception e) {
                        System.out.println("none");
                    }
                } while (consoleStudentView.isFinished() == false);
            }
            /*--teacher--*/
            else if (user instanceof Teacher) {
                ConsoleTeacherView consoleTeacherView = new ConsoleTeacherView();
                DefaultTeacherService defaultTeacherService = new DefaultTeacherService(defaultDataStore);
                Teacher teacher = (Teacher) user;

                consoleTeacherView.printWelcomeMessage(teacher);
                ArrayList<Course> courses = defaultTeacherService.findCoursesByTeacher(teacher);
                consoleTeacherView.printCourses(courses);

                Course course = consoleTeacherView.selectCourse(courses);
                ArrayList<Student> students = defaultTeacherService.getStudentsFromCourse(course);
                consoleTeacherView.printStudents(students);
                Student student = consoleTeacherView.selectStudent(students);
                int gradeValue = consoleTeacherView.readGradeValue();

                Grade grade = defaultTeacherService.createGrade(student, course, gradeValue);
                consoleTeacherView.printGrade(grade);
                defaultDataStore.saveGrade(grade);

            }
        } catch (AuthenticationException ae) {
            userView.printInvalidCredentials();
        }
    }
}
