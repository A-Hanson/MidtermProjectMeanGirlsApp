package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Comment;
import com.skilldistillery.jpameangirls.entities.Student;

@Transactional
@Service
public class CommentDAOImpl implements CommentDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Comment findById(int commentId) {
		
		return em.find(Comment.class, commentId);
	}

	@Override
	public List<Comment> findAll() {
		
		return em.createQuery("select c from Comment c", Comment.class).getResultList();
	}

	@Override
	public Comment create(Comment comment) {
		
		em.persist(comment);
		return comment;
	}

	@Override
	public Comment update(int id, Comment comment) {
		
		Comment c = em.find(Comment.class, id);
		
		c.setContent(comment.getContent());
		c.setStudent(comment.getStudent());
		c.setCreatedDate(comment.getCreatedDate());
		c.setLastEdited(comment.getLastEdited());
		c.setEnabled(comment.getEnabled());
		c.setFlagged(comment.getFlagged());
		c.setClique(comment.getClique());
		
		return c;
	}

	@Override
	public boolean deletePermanently(int id) {
		
		Comment managedComment = em.find(Comment.class, id);
		em.remove(managedComment);
		return !em.contains(managedComment);
	}
}
