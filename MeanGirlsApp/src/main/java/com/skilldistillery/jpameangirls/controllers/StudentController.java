package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpameangirls.dao.StudentDAO;
import com.skilldistillery.jpameangirls.entities.Student;

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
	
	@RequestMapping(path= {"createStudent.do"}, method = RequestMethod.GET)
	public ModelAndView createStudent() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("student", new Student());
		mv.setViewName("createStudent");
		return mv; // (ViewResolver in use)
	}
}