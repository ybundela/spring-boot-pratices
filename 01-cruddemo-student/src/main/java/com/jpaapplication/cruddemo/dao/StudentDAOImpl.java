package com.jpaapplication.cruddemo.dao;

import com.jpaapplication.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define the field for entity manager
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //Get the all the data from table
        //here entityManager.createQuery having entity name after FROM as its JPQL which worked in entity name
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student ",Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //Get the data from table using lastname
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student where lastName=:theData",Student.class);
        typedQuery.setParameter("theData", lastName);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRowDeleted = entityManager.createQuery("DELETE FROM Student ").executeUpdate();
        return numOfRowDeleted;
    }
}
