package com.skilldistillery.jpameangirls.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	
	@RequestMapping(path = {"logout.do"})
	  public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		session.removeAttribute("user");
		mv.setViewName("index");
	    return mv;
	  }
	
	
}
