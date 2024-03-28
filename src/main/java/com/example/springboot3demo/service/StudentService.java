package com.example.springboot3demo.service;

import com.example.springboot3demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    List<Student> findAll();
    Optional<Student>findById(int id);
    Student update(Student student);
    void deleteById(int id);


}
