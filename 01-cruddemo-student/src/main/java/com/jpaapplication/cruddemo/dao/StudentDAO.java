package com.jpaapplication.cruddemo.dao;

import com.jpaapplication.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    //Create data
    void save(Student theStudent);

    //retrive data
    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(int id);

    int deleteAll();
}
