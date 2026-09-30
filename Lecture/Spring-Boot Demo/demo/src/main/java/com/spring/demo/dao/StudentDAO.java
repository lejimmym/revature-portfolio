//Technically a repository not a dao??
//Ethan wants us to be aware that it may still be called a DAO
//Prickly terminology


package com.spring.demo.dao;

import java.util.List;

import com.spring.demo.domain.Student;

public interface StudentDAO {
    Student insert(Student student);
    List<Student> findAll();
    Student findById(int id);
}
