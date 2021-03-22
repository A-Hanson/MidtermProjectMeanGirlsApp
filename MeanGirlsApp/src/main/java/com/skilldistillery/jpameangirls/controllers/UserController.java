package com.skilldistillery.jpameangirls.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView register(String email, String password, String username, String firstName, String lastName, Integer birthdayDay, Integer birthdayMonth, Integer birthdayYear, String gender) { 
		ModelAndView mv = new ModelAndView();

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
		mv.setViewName("chooseCharacter.jsp");
		return mv;
	}
	
}
