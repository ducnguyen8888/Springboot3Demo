package com.example.springboot3demo.dao;

import com.example.springboot3demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentDAO {

    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findAllByLastName(String lastName);
    Student  update(Student student);
    void deleteById(int id);

}
