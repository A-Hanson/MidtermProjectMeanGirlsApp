package com.skilldistillery.jpameangirls.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpameangirls.entities.Student;

@Transactional
@Service
public class StudentDAOImpl implements StudentDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Student findById(int studentId) {
		return em.find(Student.class, studentId);
	}
	@Override
	public List<Student> findAll() {
		String query="SELECT s FROM Student s";
		return em.createQuery(query, Student.class).getResultList();
	}
	@Override
	public Student create(Student student) {
		student.setCreatedDate(LocalDateTime.now());
		em.persist(student);
		em.flush();
		return student;
	}
	@Override
	public Student update(int id, Student student) {
		Student managedStudent = em.find(Student.class, id);
		managedStudent.setFirstName(student.getFirstName());
		managedStudent.setLastName(student.getLastName());
		managedStudent.setGender(student.getGender());
		managedStudent.setGradeLevel(student.getGradeLevel());
		managedStudent.setBirthdayDate(student.getBirthdayDate());
		managedStudent.setImageUrl(student.getImageUrl());
		return student;
	}

	@Override
	public boolean deletePermanently(int id) {
		Student managedStudent = em.find(Student.class, id);
		em.remove(managedStudent);
		boolean wasDeleted = ! em.contains(managedStudent);
		return wasDeleted;
	}
	

}
