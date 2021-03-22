package com.skilldistillery.jpameangirls.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpameangirls.dao.UserDAO;
import com.skilldistillery.jpameangirls.entities.User;

@Controller
public class LoginController {

	@Autowired
	private UserDAO userDao;
	
//	@RequestMapping(path="login.do")
//	public String loginPage() {
//		return "login";
//	}
	
	@RequestMapping(path = {"login.do"})
	  public ModelAndView login(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		if(session.getAttribute("loggedInUser") != null) {
			mv.setViewName("redirect:index.do");
			return mv;		}
		mv.addObject("user", new User());
		mv.setViewName("login");
	    return mv;
	  }
	
//	@RequestMapping(path = {"login.do"}, method=RequestMethod.POST)
//	public ModelAndView loginPost(User user, HttpSession session) {
//		
//		ModelAndView mv = new ModelAndView();
//		if(session.getAttribute("loggedInUser") != null) {
//			mv.setViewName("redirect:index.do");
//			return mv;
//		}
//		
////		User u = userDao.getUserByUserNameAndPassword(user.getUserName(), user.getPassword());
//		
//		if(u != null) {
//			session.setAttribute("loggedInUser", u);
//			mv.setViewName("redirect:account.do");
//
//			return mv;
//		}
//		
//		mv.setViewName("login");
//		return mv;
//	}
	
}
