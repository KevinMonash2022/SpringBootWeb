package com.kevin.curd.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    // Define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstrname;

    @Column(name = "last_name")
    private String lastrname;

    @Column(name = "email")
    private String email;


    // Define constructors

    public Student(String firstrname, String lastrname, String email) {
        this.firstrname = firstrname;
        this.lastrname = lastrname;
        this.email = email;
    }

    // Define getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstrname() {
        return firstrname;
    }

    public void setFirstrname(String firstrname) {
        this.firstrname = firstrname;
    }

    public String getLastrname() {
        return lastrname;
    }

    public void setLastrname(String lastrname) {
        this.lastrname = lastrname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // Define toString() method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstrname='" + firstrname + '\'' +
                ", lastrname='" + lastrname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
