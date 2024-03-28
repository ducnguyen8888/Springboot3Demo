package com.example.springboot3demo.rest;

import com.example.springboot3demo.dao.StudentDAO;
import com.example.springboot3demo.entity.Student;
import com.example.springboot3demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private StudentService studentService;


    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")

    public List<Student> getStudents() {

        List<Student> studentList = studentService.findAll();
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
       Optional<Student> result = null;
        Student student = null;
        if ( studentId > 0 ) {
             result = studentService.findById(studentId);

            if ( result.isPresent() ) {
                student = result.get();
            } else {
                throw  new StudentNotFoundException("Student id: " + studentId + "not found");
            }
        } else {
            throw new StudentNotFoundException("Student id is not valid - " + studentId);
        }

        return student;
    }

    // Add an exception handler using @ExceptionHandler

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        student.setId(0);
        studentService.update(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId){
       studentService.deleteById(studentId);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        Student dbStudent = studentService.update(student);
        if (dbStudent == null ) {
            throw new RuntimeException("Student id : " + student.getId() + " not found.");
        }
        return dbStudent ;
    }





}
