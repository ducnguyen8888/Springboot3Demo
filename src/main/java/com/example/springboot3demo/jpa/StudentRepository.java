package com.example.springboot3demo.jpa;

import com.example.springboot3demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student,Integer> {
}
