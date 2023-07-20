package com.epam.training.ediary.persistence;

import com.epam.training.ediary.domain.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.naming.directory.SchemaViolationException;

public class DefaultDataStore implements DataStore {
    /*--properties--*/
    ArrayList<Student> students;
    ArrayList<Teacher> teachers;
    ArrayList<Course> courses;
    ArrayList<Grade> grades;
    String baseDirPath;

    /*--constructors--*/
    public DefaultDataStore(String p_baseDirPath) {
        this.baseDirPath = p_baseDirPath;
    }

    /*--methods--*/
    @Override
    public void init() {
        try {
            // read and process students
            this.students = new ArrayList<Student>();
            String fileName = this.baseDirPath + "/student.csv";

            Stream<String> stream = Files.lines(Paths.get(fileName));

            Stream<String[]> streamOfStringArrays = stream.map(line -> line.split(","));

            List<String[]> listOfStringsArrays = streamOfStringArrays.collect(Collectors.toList());

            for (String[] arr : listOfStringsArrays) {

                Student student = new Student();
                student.setId(Long.parseLong(arr[0].trim()));
                student.setName(arr[3].trim());

                Credentials credentials = new Credentials();
                credentials.setLoginName(arr[1].trim());
                credentials.setPassword(arr[2].trim());

                SchoolClass schoolClass = new SchoolClass();
                schoolClass.setName(arr[4].trim());

                student.setCredentials(credentials);
                student.setSchoolClass(schoolClass);

                this.students.add(student);
            }
            stream.close();

            // read and process teachers
            this.teachers = new ArrayList<Teacher>();
            fileName = this.baseDirPath + "/teacher.csv";

            stream = Files.lines(Paths.get(fileName));

            streamOfStringArrays = stream.map(line -> line.split(","));

            listOfStringsArrays = streamOfStringArrays.collect(Collectors.toList());

            for (String[] arr : listOfStringsArrays) {

                Teacher teacher = new Teacher();
                teacher.setId(Long.parseLong(arr[0].trim()));
                teacher.setName(arr[3].trim());

                Credentials credentials = new Credentials();
                credentials.setLoginName(arr[1].trim());
                credentials.setPassword(arr[2].trim());

                teacher.setCredentials(credentials);

                this.teachers.add(teacher);
            }
            stream.close();

            // read and process courses
            this.courses = new ArrayList<Course>();
            fileName = this.baseDirPath + "/course.csv";

            stream = Files.lines(Paths.get(fileName));

            streamOfStringArrays = stream.map(line -> line.split(","));

            listOfStringsArrays = streamOfStringArrays.collect(Collectors.toList());

            for (String[] arr : listOfStringsArrays) {

                // teacher ID
                Teacher teacher = null;
                for (Teacher t : this.teachers) {
                    if (t.getId() == Long.parseLong(arr[2].trim())) {
                        teacher = t;
                    }
                }

                Course course = new Course();

                course.setSubject(Subject.valueOf(arr[1].trim()));
                course.setTeacher(teacher);

                SchoolClass schoolClass = new SchoolClass();
                schoolClass.setName(arr[0].trim());

                course.setSchoolClass(schoolClass);

                this.courses.add(course);
            }
            stream.close();

            // read and process grades
            this.grades = new ArrayList<Grade>();
            fileName = this.baseDirPath + "/grade.csv";

            stream = Files.lines(Paths.get(fileName));

            streamOfStringArrays = stream.map(line -> line.split(","));

            listOfStringsArrays = streamOfStringArrays.collect(Collectors.toList());

            for (String[] arr : listOfStringsArrays) {  //for every line in grade.csv
        
                SchoolClass sc = null;
                Student student = null;
                for (Student s : this.students) {
                    if (s.getId() == Long.parseLong(arr[0].trim())) {
                        student = s;
                        sc =  s.getSchoolClass();
                    }
                }

                Course course = null;
                for (Course c : this.courses) {
                    if (c.getSubject().name().equals(arr[2].trim()) &&
                        c.getSchoolClass().equals(sc)) {
                        course = c;
                    }
                }

                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
                LocalDate date = LocalDate.parse(arr[3].trim(), f);

                Grade grade = new Grade();
                grade.setValue(Integer.parseInt(arr[1].trim()));
                grade.setDate(date);
                grade.setCourse(course);
                grade.setStudent(student);

                this.grades.add(grade);
            }
            stream.close();
        } 
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> getStudents() {
        return this.students;
    }

    @Override
    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    @Override
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    @Override
    public ArrayList<Grade> getGrades() {
        return this.grades;
    }

    @Override
    public void saveGrade(Grade p_grade) {

        this.grades.add(p_grade);

        try {
            // csv
            String str = System.lineSeparator();
            str = str + Long.toString(p_grade.getStudent().getId());
            str = str + "," + Integer.toString(p_grade.getValue());
            str = str + "," + p_grade.getCourse().getSubject().name();
            str = str + "," + p_grade.getDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd."));

            Path filePath = Paths.get(this.baseDirPath + "/grade.csv");
            Files.writeString(filePath, str, StandardOpenOption.APPEND);
        } 
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
