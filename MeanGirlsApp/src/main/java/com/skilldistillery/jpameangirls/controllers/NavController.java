package com.skilldistillery.jpameangirls.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpameangirls.dao.CliqueDAO;
import com.skilldistillery.jpameangirls.dao.CommentDAO;
import com.skilldistillery.jpameangirls.dao.CommentVoteDAO;
import com.skilldistillery.jpameangirls.dao.StudentDAO;
import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Comment;

@Controller
public class NavController {

	@Autowired
	private CommentDAO commentDao;
	
	@Autowired
	private StudentDAO sDAO;
	
	@Autowired
	private CliqueDAO cliqueDao;
	
	@Autowired
	private CommentVoteDAO cvDao;

	@RequestMapping(path = "goToRegisterPage.do")
	public String goToRegisterPage() {
		return "register";
	}

	@RequestMapping(path = "goToCafeteria.do")
	public ModelAndView goToCafeteria() {
		ModelAndView mv = new ModelAndView();
		Clique cafeteria = cliqueDao.findById(1);
		List<Comment> comments = commentDao.findCommentsInTheLast24HoursFromCliqueWithId(1);
		for (Comment comment : comments) {
			comment.setTotalFetch(cvDao.commentTotalScore(comment.getId()));
		}
		mv.addObject("clique", cafeteria);
		mv.addObject("cafeteriaComments", comments);
		mv.setViewName("cafeteria");
		return mv;
	}

	@RequestMapping(path = "goToBurnBook.do")
	public ModelAndView goToBurnBook(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("students", sDAO.findAll());
		mv.addObject("addBurnCommentStudentID", -1);
		
		mv.setViewName("burnBook");
		return mv;
	}

}
