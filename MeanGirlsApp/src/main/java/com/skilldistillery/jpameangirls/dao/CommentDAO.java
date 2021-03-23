package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import com.skilldistillery.jpameangirls.entities.Comment;
import com.skilldistillery.jpameangirls.entities.Student;

public interface CommentDAO {

	Comment findById(int commentId);
	List<Comment> findCommentsByCliqueId(int cliqueId);
	List<Comment> findAll();
	Comment create(Comment comment);
	Comment update(int id, Comment comment);
	boolean deletePermanently(int id);
}
