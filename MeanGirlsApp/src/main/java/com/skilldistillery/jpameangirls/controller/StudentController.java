package com.skilldistillery.jpameangirls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping(path= {"/","home.do"}, method = RequestMethod.GET)
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView();
		  
		mv.setViewName("index");
		return mv; // (ViewResolver in use)
	}
	
}
