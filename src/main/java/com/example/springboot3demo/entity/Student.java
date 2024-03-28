package com.example.springboot3demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="student")
public class Student {
    //Define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="enrollmentDate")
    private Date enrollmentDate;

    public Student(String firstName, String lastName, Date myDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = myDate;
    }

    public Student() {

    }

    //Define getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date myDate) {
        this.enrollmentDate = myDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//Define toString() method

    @Override
    public String toString(){
        return "Student"+
                "Id ="  + this.id +
                "First name = " + this.firstName +
                "Last name = " + this.lastName +
                "Enrollment date = " + this.enrollmentDate;
    }

}
