package com.skilldistillery.jpameangirls.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.jpameangirls.dao.BurnBookCommentDAO;
import com.skilldistillery.jpameangirls.dao.StudentDAO;
import com.skilldistillery.jpameangirls.entities.BurnBookComment;
import com.skilldistillery.jpameangirls.entities.Comment;

@Controller
public class BurnBookController {

	@Autowired
	private StudentDAO sDAO;
	
	@Autowired
	private BurnBookCommentDAO bbcDAO;
	
	@RequestMapping(path="addBurnComment.do", method = RequestMethod.GET)
	public ModelAndView addBurnComment(String userIdString) {

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("students", sDAO.findAll());
		mv.addObject("addBurnCommentStudentID", userIdString);
		
		mv.setViewName("burnBook");
		return mv;
	}
		
	@RequestMapping(path="SubmitBurnComment.do", method = RequestMethod.POST)
	public String submitBurnComment(String postingStudentIdString, String subjectStudentIdString, String content, RedirectAttributes redir) {

		
		BurnBookComment b = new BurnBookComment();
		
		b.setAuthorId( sDAO.findById(Integer.parseInt(postingStudentIdString)));
		b.setContent(content);
		b.setCreatedDate(LocalDateTime.now());
		b.setEnabled(true);
		b.setFlagged(false);
		b.setStudentId(sDAO.findById(Integer.parseInt(subjectStudentIdString)));
		
		bbcDAO.create(b);
		
		return "redirect:goToBurnBook.do";
	}
	
//	@RequestMapping(path="updateComment.do", method = RequestMethod.POST)
//	public String updateCafteriaComment(String id, Comment comment, RedirectAttributes redir) {
//		int commentId = Integer.parseInt(id);
//		commentDao.update(commentId, comment);
//		return "redirect:cafeteriaforum.do";
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
