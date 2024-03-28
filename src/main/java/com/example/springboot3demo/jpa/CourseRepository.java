package com.example.springboot3demo.jpa;

import com.example.springboot3demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
