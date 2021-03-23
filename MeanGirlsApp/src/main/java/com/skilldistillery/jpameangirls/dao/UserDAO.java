package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import com.skilldistillery.jpameangirls.entities.Student;
import com.skilldistillery.jpameangirls.entities.User;

public interface UserDAO {
	
//////// CREATE
	public User createUser(User user);
		
//////// READ
	public User findUserById(int userId);
	public List<User> findAllUsers();
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public List<Student> findAllStudentsForUser(int userId);
	
//////// UPDATE
	public User updateUser(int id, User user);

//////// DELETE
	public boolean deleteUser(int id);
	
	public User getUserByUserNameAndPassword(String username, String password);
	public boolean isValidUser(User u) ;
}