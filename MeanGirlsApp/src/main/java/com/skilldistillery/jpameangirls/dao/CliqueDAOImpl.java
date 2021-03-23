package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Student;

@Transactional
@Service
public class CliqueDAOImpl implements CliqueDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Clique findById(int id) {
		
		return em.find(Clique.class, id);
	}

	@Override
	public List<Clique> getAll() {
		
		return em.createQuery("select c from Clique c", Clique.class).getResultList();
	}

	@Override
	public List<Clique> findByStudent(Student student) {
		
		if(student != null) {

			String query = "SELECT c FROM Clique c WHERE :student MEMBER OF c.students";
	
			return em.createQuery(query, Clique.class)
			      .setParameter("student", student)
			      .getResultList();
		}
		
		return null;
	}

	@Override
	public Clique create(Clique clique) {
		
		em.persist(clique);
		return clique;
	}

	@Override
	public Clique update(Clique clique) {
		
		Clique c = em.find(Clique.class, clique.getId());
		
		c.setName(clique.getName());
		c.setImageUrl(clique.getImageUrl());
		c.setDescription(clique.getDescription());
		c.setStudents(clique.getStudents());
		c.setStudents(clique.getStudents());
		c.setComments(clique.getComments());
		
		return c;
	}

	@Override
	public Clique deletePermanently(Clique clique) {
		
		em.remove(clique);
		return clique;
	}

	@Override
	public Clique deleteByIdPermanently(Integer id) {
		
		Clique toDelete = em.find(Clique.class, id);
		em.remove(toDelete);
		return toDelete;
	}

}
