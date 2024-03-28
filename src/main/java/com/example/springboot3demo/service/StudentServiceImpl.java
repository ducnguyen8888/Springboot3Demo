package com.example.springboot3demo.service;

import com.example.springboot3demo.dao.StudentDAO;
import com.example.springboot3demo.entity.Student;
import com.example.springboot3demo.jpa.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {



    //private StudentDAO studentDAO;
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll(){
        List<Student>studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public Optional<Student> findById(int id){
        Optional<Student> student = studentRepository.findById(id);
        return student;
    }


    @Transactional
    @Override
    public Student update(Student student){
        return studentRepository.save(student);
    }


    @Transactional
    @Override
    public void deleteById(int id){
        studentRepository.deleteById(id);
    }
}
