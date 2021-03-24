package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpameangirls.dao.CommentDAO;
import com.skilldistillery.jpameangirls.dao.StudentDAO;

@Controller
public class NavController {

	@Autowired
	private CommentDAO commentDao;
	
	@Autowired
	private StudentDAO sDAO;

	@RequestMapping(path = "goToRegisterPage.do")
	public String goToRegisterPage() {
		return "register";
	}

	@RequestMapping(path = "goToCafeteria.do")
	public ModelAndView goToCafeteria() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cafeteriaComments", commentDao.findCommentsByCliqueId(1));
		mv.setViewName("cafeteria");
		return mv;
	}

	@RequestMapping(path = "goToBurnBook.do")
	public ModelAndView goToBurnBook() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("students", sDAO.findAll());
		
		mv.setViewName("burnBook");
		return mv;
	}

}
