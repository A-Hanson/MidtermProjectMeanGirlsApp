package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpameangirls.dao.UserDAO;

@Controller
public class AdminController {

	@Autowired
	private UserDAO userDao;
	
	
	@RequestMapping(path= { "manageUsers.do"})
	public String manageUser() {
		return "manageUsers";
	}
	
	@RequestMapping(path = "getUser.do")
	public ModelAndView getAllUsers() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("games", userDao.findAllUsers());
		mv.setViewName("allUsers");
		return mv;
	}

	@RequestMapping(path = "getUser.do", params = "id")
	public ModelAndView getUserById(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("idNum", id);
		mv.addObject("user", userDao.findUserById(id));
		mv.setViewName("singleUser");
		return mv;
	}

	@RequestMapping(path = "getUser.do", params = "username", method = RequestMethod.GET)
	public ModelAndView findUserByUsername(String username) {
		ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
		mv.addObject("user", userDao.findUserByUsername(username));
		mv.setViewName("allGames");

		return mv;
	}
		

	
}
