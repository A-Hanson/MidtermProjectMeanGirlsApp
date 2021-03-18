package com.skilldistillery.jpameangirls.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpameangirls.entities.User;

@Service
@Transactional
public class UserDAOJpaImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findById(int userId) {
		return em.find(User.class, userId);
	}

}
