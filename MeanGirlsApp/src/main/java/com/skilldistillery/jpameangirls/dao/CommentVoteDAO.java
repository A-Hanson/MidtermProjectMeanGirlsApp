package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import com.skilldistillery.jpameangirls.entities.Comment;
import com.skilldistillery.jpameangirls.entities.CommentVote;
import com.skilldistillery.jpameangirls.entities.Student;

public interface CommentVoteDAO {

//	CREATE
	CommentVote create(CommentVote commentVote);
	CommentVote create(Student student, Comment comment, Boolean vote);
	
//	UPDATE
	CommentVote update(int id, CommentVote commentVote);
	
//	DELETE
	boolean delete(int id);
	
//	Aggregate Information
	int commentTotalScore(int commentId);

	int commentUpVoteTotal(int commentId);
	
	int commentDownVoteTotal(int commentId);
	
	int studentTotalScore(int studentId);
	
	int studentUpVoteTotal(int studentId);
	
	int studentDownVoteTotal(int studentId);
	
	List<Student> studentsWhoUpvoted(int commentId);
	
	List<Comment> commentsStudentUpVoted(int studentId);
}
