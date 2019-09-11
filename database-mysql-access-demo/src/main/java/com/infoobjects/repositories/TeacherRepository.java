package com.infoobjects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.infoobjects.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

	
}
