package com.skilldistillery.jpameangirls.dao;

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

}
