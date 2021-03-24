package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpameangirls.entities.Student;
import com.skilldistillery.jpameangirls.entities.User;

@Service
@Transactional
public class UserDAOJpaImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User createUser(User user) {
		em.persist(user);
		em.flush();
		return user;
	}

	@Override
	public User findUserById(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	public List<User> findAllUsers() {
		
		String query ="SELECT u FROM User u";
		return em.createQuery(query,User.class).getResultList();
	}

	@Override
	public User findUserByUsername(String username) {
		List<User> users = findAllUsers();
		User u = null;
		
		for (User user : users) {
			if(user.getUsername().equals(username)) {
				u = user;
			}
		}
		
		return u;
	}

	@Override
	public User findUserByEmail(String email) {
		String query = "SELECT u FROM User u WHERE email = :email";
		return em.createQuery(query, User.class).setParameter("email", email).getResultList().get(0);
	}
	

	@Override
	public List<Student> findAllStudentsForUser(int userId) {
		String query = "SELECT u FROM User u JOIN FETCH u.students WHERE u.id=:uId";
		User user = em.createQuery(query, User.class).setParameter("uId", userId).getResultList().get(0);
		List<Student> students = user.getStudents();
		return students;
	}

	@Override
	public User updateUser(int id, User user) {
		
		User managedUser = em.find(User.class, id);

		managedUser.setEmail(user.getEmail());
		managedUser.setPassword(user.getPassword());
		managedUser.setUsername(user.getUsername());
		managedUser.setFirstName(user.getFirstName());
		managedUser.setLastName(user.getLastName());
		if(user.getEnabled() == null) {	
			managedUser.setEnabled(true);
		} else {
			managedUser.setEnabled(user.getEnabled());
		}
		if(user.getRole() == null) {
			managedUser.setRole("user");
		} else {
			managedUser.setRole(user.getRole());
		}
		
		managedUser.setBirthdayDate(user.getBirthdayDate());
		managedUser.setGender(user.getGender());

		return managedUser;
	}

	@Override
	public boolean deleteUser(int id) {
		User u = em.find(User.class, id);

		if (u != null) {
			em.remove(u);
		}

		boolean userWasDeleted = !em.contains(u);

		return userWasDeleted;
	}

	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
		User u = null;
		
		List<User> users = findAllUsers();
	  
		for (User user : users) {
			
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				u = user;
				break;
			}
			
		}
	    return u;
	}

	@Override
	public boolean isValidUser(User u) {
		List<User> users = findAllUsers();
		
		
		for (User user : users) {
			
			if (user.getPassword().equals(u.getPassword())){
				return true;
			}
			
		}
		
		return false;
	}
	
	@Override
	public boolean isEmailUnique(String email) {
		
		String query= "SELECT User from User WHERE email = :email";
		User user = em.createQuery(query, User.class).setParameter("email", email).getResultList().get(0);
		
		if(user == null) {
			return true;
		}
		
	  return false;
	}

	@Override
	public boolean isUsernameUnique(String username) {
		String query= "SELECT User from User WHERE username = :username";
		User user = em.createQuery(query, User.class).setParameter("username", username).getResultList().get(0);
		
		if(user == null) {
			return true;
		}
		
		
		return false;
	}

}