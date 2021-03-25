package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpameangirls.entities.BurnBookComment;
import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Comment;

@Transactional
@Service
public class BurnBookCommentDAOImpl implements BurnBookCommentDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public BurnBookComment findById(int id) {
		
		return em.find(BurnBookComment.class, id);
	}

	@Override
	public List<BurnBookComment> getAll() {
		
		return em.createQuery("select c from BurnBookComment c", BurnBookComment.class).getResultList();
	}

	@Override
	public BurnBookComment create(BurnBookComment comment) {
		
		em.persist(comment);
		return comment;
	}

	@Override
	public BurnBookComment update(BurnBookComment comment) {
		
		BurnBookComment b = em.find(BurnBookComment.class, comment.getId());
		
		b.setBookCommentVotes(comment.getBookCommentVotes());
		b.setContent(comment.getContent());
		b.setEnabled(comment.getEnabled());
		b.setFlagged(comment.getFlagged());
		
		return b;
	}

	@Override
	public BurnBookComment deletePermanently(BurnBookComment comment) {
		
		em.remove(comment);
		return comment;
	}

	@Override
	public BurnBookComment deleteByIdPermanently(Integer id) {
		
		BurnBookComment managedComment = em.find(BurnBookComment.class, id);
		em.remove(managedComment);
		return managedComment;
	}
	
	@Override
	public List<BurnBookComment> getAllFlagged() {
		
		return em.createQuery("select c from BurnBookComment c where c.flagged = true", BurnBookComment.class).getResultList();
	}
}