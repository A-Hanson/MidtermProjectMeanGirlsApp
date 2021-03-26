package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import com.skilldistillery.jpameangirls.entities.Badge;
import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Comment;
import com.skilldistillery.jpameangirls.entities.Student;

public interface StudentDAO {
//	CREATE
	Student create(Student student);
//	READ
	Student findById(int studentId);
	
	List<Student> findAll();
	List<Clique> findAllCliquesForAStudent(int studentId);
	List<Badge> findAllBadgesForAStudent(int studentId);
	List<Comment> findAllCommentForAStudent(int studentId);
	
//	UPDATE
	Student update(int id, Student student);
	
	Student addBadgeToStudent(Student student, int badgeId);
	
//	DELETE
	boolean deletePermanently(int id);
}
