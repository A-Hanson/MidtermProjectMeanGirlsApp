package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Comment;
import com.skilldistillery.jpameangirls.entities.Student;

public interface CommentDAO {

	Comment findById(int commentId);
	List<Comment> findCommentsByCliqueId(int cliqueId);
	List<Comment> findAll();
	List<Comment> findAllEnabled();
	List<Comment> findAllEnabledAndFlagged();
	List<Comment> findCommentsInTheLast24HoursFromCliqueWithId(int id);
	Comment create(Comment comment);
	Comment create(Comment comment, Student student, Clique clique);
	Comment update(int id, Comment comment);
	Comment softDelete(int id);
	boolean deletePermanently(int id);
	public List<Comment> findCommentsByUsername(String username);
}
