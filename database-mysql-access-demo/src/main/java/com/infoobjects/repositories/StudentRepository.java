package com.infoobjects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.infoobjects.model.Student;

/*
 * interface JpaRepository provides us with all 
 * the methods required for CRUD operations and 
 * we need not implement those methods in particular
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
