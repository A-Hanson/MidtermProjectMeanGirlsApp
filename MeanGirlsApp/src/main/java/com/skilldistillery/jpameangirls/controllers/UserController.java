package com.skilldistillery.jpameangirls.controllers;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpameangirls.dao.UserDAO;
import com.skilldistillery.jpameangirls.entities.User;
@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;

//////// CREATE
	@RequestMapping(path = "register.do", method = RequestMethod.GET)
	public String goToRegistration() {
		return "register";
	}
	
	@RequestMapping(path = "register.do", method = RequestMethod.POST)
	public ModelAndView register(@Valid String email, String password, String username, String firstName, String lastName, Integer birthdayDay, Integer birthdayMonth, Integer birthdayYear, String gender , Errors errors) { 
		ModelAndView mv = new ModelAndView();

		if(errors.hasErrors()) {
			mv.setViewName("registrer");
		    return mv;
		  }
		
		  if(!userDao.isEmailUnique(email)) {
		    errors.rejectValue("email", "error.email", "Email already in use");
		    mv.setViewName("registrer");
		    return mv;
		  } 
		  
		  if(!userDao.isUsernameUnique(username)) {
			  errors.rejectValue("username", "error.username", "Username already in use");
			  mv.setViewName("registrer");
			  return mv;
		  } 
		  
		  
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEnabled(true);
		user.setRole("user"); // WARNING: hard-coded as "user"
		user.setCreatedDate(LocalDateTime.now());
		user.setBirthdayDate(LocalDateTime.of(birthdayYear, birthdayMonth, birthdayDay, 0, 1)); // WARNING: hardcoding birthday time as 12:01 a.m.
		user.setGender(gender);
		
		
		
		userDao.createUser(user);
		mv.addObject("user", user);
		mv.setViewName("createStudent");
		return mv;
	}
	
}
