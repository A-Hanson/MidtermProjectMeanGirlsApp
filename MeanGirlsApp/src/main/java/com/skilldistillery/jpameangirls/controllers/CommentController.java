package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.jpameangirls.dao.CliqueDAO;
import com.skilldistillery.jpameangirls.dao.CommentDAO;
import com.skilldistillery.jpameangirls.dao.CommentVoteDAO;
import com.skilldistillery.jpameangirls.dao.StudentDAO;
import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Comment;
import com.skilldistillery.jpameangirls.entities.Student;

@Controller
public class CommentController {

	@Autowired
	private CliqueDAO cliqueDao;

	@Autowired
	private CommentDAO commentDao;


	@Autowired
	private StudentDAO studentDao;

	@Autowired
	private CommentVoteDAO cvDao;
	
	@RequestMapping(path = "addCafeteriaComment.do", method = RequestMethod.POST)
	public ModelAndView addCafeteriaComment(Comment comment, String studentId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Integer integerId = Integer.parseInt(studentId);

		Student student = studentDao.findById(integerId);
		Clique cafeteria = cliqueDao.findById(1);

		commentDao.create(comment, student, cafeteria);
		redir.addFlashAttribute("cafeteriaComment", comment);
		mv.setViewName("redirect:cafeteriaforum.do");
		return mv;
	}
	
	@RequestMapping(path = "addPlasticsComment.do", method = RequestMethod.POST)
	public ModelAndView addPlasticsComment(Comment comment, String studentId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Integer integerId = Integer.parseInt(studentId);
		
		Student student = studentDao.findById(integerId);
		Clique plastics = cliqueDao.findById(2);
		
		commentDao.create(comment, student, plastics);
		redir.addFlashAttribute("plasticsComment", comment);
		mv.setViewName("redirect:plasticsforum.do");
		return mv;
	}

	@RequestMapping(path = "vote.do", method = RequestMethod.POST)
	public ModelAndView upVote(String studentId, String commentId, String cliqueId, Boolean vote, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		int sId = Integer.parseInt(studentId);
		Student student = studentDao.findById(sId);
		int cId = Integer.parseInt(commentId);
		Comment comment = commentDao.findById(cId);
		cvDao.create(student, comment, vote);
		int clId = Integer.parseInt(cliqueId);
		switch (clId) {
			case 1:
				mv.setViewName("redirect:cafeteriaforum.do");
				break;
			case 2:
				mv.setViewName("redirect:plasticsforum.do");
				break;
				
		}
		return mv;
	}

//	@RequestMapping(path = "downVote.do", method = RequestMethod.POST)
//	public ModelAndView downVote(String studentId, String commentId, String cliqueId, Boolean vote, RedirectAttributes redir) {
//		ModelAndView mv = new ModelAndView();
//		int intSId = Integer.parseInt(studentId);
//		Student student = studentDao.findById(intSId);
//		int intCId = Integer.parseInt(commentId);
//		Comment comment = commentDao.findById(intCId);
//		cvDao.create(student, comment, vote);
//		
//		
//		mv.setViewName("redirect:cafeteriaforum.do");
//		return mv;
//	}
	
	@RequestMapping(path="deleteComment.do", method = RequestMethod.POST)
	public String deleteCafeteriaComment(String commentId, String cliqueId, RedirectAttributes redir, Model model) {
		int cId = Integer.parseInt(commentId);
		commentDao.softDelete(cId);
		String page = "";
		int clId = Integer.parseInt(cliqueId);
		switch (clId) {
			case 1:
				page = "redirect:cafeteriaforum.do";
				model.addAttribute("cafeteriaComments", commentDao.findCommentsInTheLast24HoursFromCliqueWithId(1));
				break;
			case 2:
				page = "redirect:plasticsforum.do";
				model.addAttribute("plasticsComments", commentDao.findCommentsByCliqueId(2));
				break;
				
		}
		return page;
	}
	
	@RequestMapping(path="updateComment.do", method = RequestMethod.GET)
	public String goToUpdatePage(String commentId, Model model) {
		int id = Integer.parseInt(commentId);
		model.addAttribute("comment", commentDao.findById(id));
		return "updateComment";
	}
	
	
	@RequestMapping(path="updateComment.do", method = RequestMethod.POST)
	public String updateCafteriaComment(String id, String cliqueId, Comment comment, RedirectAttributes redir) {
		int commentId = Integer.parseInt(id);
		commentDao.update(commentId, comment);
		String page = "";
		int clId = Integer.parseInt(cliqueId);
		switch (clId) {
			case 1:
				page = "redirect:cafeteriaforum.do";
				break;
			case 2:
				page = "redirect:plasticsforum.do";
				break;
		}
		return page;
	}
	
	
}