package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpameangirls.dao.CommentDAO;

@Controller
public class NavController {

	@Autowired
	private CommentDAO commentDao;

	@RequestMapping(path = "goToRegisterPage.do")
	public String goToRegisterPage() {
		return "register";
	}

	@RequestMapping(path = "goToCafeteria.do")
	public ModelAndView goToCafeteria() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cafeteriaComments", commentDao.findAll());
		mv.setViewName("cafeteria");
		return mv;
	}

	@RequestMapping(path = "goToBurnBook.do")
	public String goToBurnBook() {
		return "burnBook";
	}

}
