package com.example.springboot3demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="title")
    private String title;
    @Column(name="credits")
    private int credits;

    public Course(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public Course() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
