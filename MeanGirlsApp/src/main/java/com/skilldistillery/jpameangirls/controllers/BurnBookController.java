package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.jpameangirls.dao.StudentDAO;

@Controller
public class BurnBookController {

	@Autowired
	private StudentDAO sDAO;
	
	@RequestMapping(path="addBurnComment.do", method = RequestMethod.POST)
	public ModelAndView addBurnComment(String userIdString) {

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("students", sDAO.findAll());
		mv.addObject("addBurnCommentStudentID", userIdString);
		
		mv.setViewName("burnBook");
		return mv;
	}
}
