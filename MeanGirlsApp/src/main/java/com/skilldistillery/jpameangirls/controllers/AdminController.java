package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.jpameangirls.dao.UserDAO;
import com.skilldistillery.jpameangirls.entities.User;

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
		mv.addObject("users", userDao.findAllUsers());
		mv.setViewName("allUsers");
		return mv;
	}

	@RequestMapping(path = "getUser.do", params = "id")
	public ModelAndView getUserById(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("idNum", id);
		mv.addObject("userLookUp", userDao.findUserById(id));
		mv.setViewName("singleUser");
		return mv;
	}

	@RequestMapping(path = "getUser.do", params = "username", method = RequestMethod.GET)
	public ModelAndView findUserByUsername(String username) {
		ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
		mv.addObject("userLookUp", userDao.findUserByUsername(username));
		mv.setViewName("singleUser");

		return mv;
	}
	
	@RequestMapping(path="updateUser.do", method = RequestMethod.GET)
	public String goToUpdatePage(int id, Model model) {
		model.addAttribute("userLookUp", userDao.findUserById(id));
		return "updateUser";
	}
	
	
	@RequestMapping(path="updateUser.do", method = RequestMethod.POST)
	public String updateUserPage(int id, User user, RedirectAttributes redir, Model model) {
		User u = null;
		 u = userDao.updateUser(id, user);
		 redir.addAttribute("id", u.getId());
		return "redirect:getUser.do";
	}
	
	@RequestMapping(path="deleteUser.do", method = RequestMethod.POST)
	public String deleteUser(int id, RedirectAttributes redir, Model model) {

		userDao.softDelete(id);
		model.addAttribute("deletedUser", id);
		return "redirect:getUser.do";
	}
	
	@RequestMapping(path = "deletePermanently.do", params = "id", method = RequestMethod.GET)
	public ModelAndView deleteUserPermanently(int id) {

		User user = null;
		user = userDao.findUserById(id);
		userDao.deleteUserPermanently(id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("allUsers");
		mv.addObject("deletedUser", user);

		return mv;
	}
	
}
