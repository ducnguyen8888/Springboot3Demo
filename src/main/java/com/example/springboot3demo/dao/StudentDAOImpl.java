package com.example.springboot3demo.dao;

import com.example.springboot3demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //Define field for entity manager
    private EntityManager entityManager;

    //Inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }



    @Override
    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(){
        // create query
        TypedQuery<Student>studentsQuery = entityManager.createQuery("FROM Student order by enrollmentDate desc ", Student.class);
        return studentsQuery.getResultList();
    }

    @Override
    public List<Student> findAllByLastName(String lastName){
        TypedQuery<Student>studentsQuery = entityManager.createQuery("FROM Student where lastName =: input", Student.class);
        studentsQuery.setParameter("input", lastName );
        return studentsQuery.getResultList();
    }

    @Override
    public Student update(Student student){
        Student studentDb = entityManager.merge(student);
        return studentDb;
    }

    @Override
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null ){
            entityManager.remove(student);
        }
    }
}
