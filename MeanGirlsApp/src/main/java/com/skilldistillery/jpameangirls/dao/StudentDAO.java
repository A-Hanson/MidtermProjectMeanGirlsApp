package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import com.skilldistillery.jpameangirls.entities.Student;

public interface StudentDAO {
	
	Student findById(int studentId);
	
	List<Student> findAll();
	
	Student create(Student student);
	
	Student update(int id, Student student);
	
	boolean deletePermanently(int id);
}
