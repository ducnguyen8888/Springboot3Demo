package com.example.springboot3demo;

import com.example.springboot3demo.dao.StudentDAO;
import com.example.springboot3demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
public class Springboot3DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot3DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> { findStudentById(studentDAO, 35);};
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Create new student object ...");
        Student student = new Student("Ben", "Nguyen", new Date()  );

        // Save the student object
        studentDAO.save(student);

        // Display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());


    }

    private Student findStudentById(StudentDAO studentDAO, int id) {
        System.out.println("Search student by id..." + id);
        Student student = studentDAO.findById(id);

        if (student != null) {

            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            System.out.println("Enrollment date: " + student.getEnrollmentDate());
        }

        return student;
    }

    private List<Student>findAllStudent(StudentDAO studentDAO){
        List<Student> studentList = studentDAO.findAll();
        for (Student student : studentList ) {
            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            System.out.println("Enrollment date: " + student.getEnrollmentDate());
        }

        return studentList;

    }

    private List<Student>findAllByLastName(StudentDAO studentDAO,
                                                String lastName){
        List<Student> studentList = studentDAO.findAllByLastName(lastName);
        for (Student student : studentList ) {
            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            System.out.println("Enrollment date: " + student.getEnrollmentDate());
        }

        return studentList;

    }

    private void updateStudent(StudentDAO studentDAO, int studentId) {
        Student student = findStudentById(studentDAO, studentId);

        if ( student != null ){
            student.setFirstName("John");
            studentDAO.update( student );
        }

    }

    private void deleteStudent(StudentDAO studentDAO, int studentId) {
        studentDAO.deleteById(studentId);
    }
}
