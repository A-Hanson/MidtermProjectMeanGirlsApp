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

	@RequestMapping(path = "upVote.do", method = RequestMethod.POST)
	public ModelAndView upVote(String studentId, String commentId, Boolean vote, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Integer intSId = Integer.parseInt(studentId);
		Student student = studentDao.findById(intSId);
		Integer intCId = Integer.parseInt(commentId);
		Comment comment = commentDao.findById(intCId);
		cvDao.create(student, comment, vote);
		mv.setViewName("redirect:cafeteriaforum.do");
		return mv;
	}

	@RequestMapping(path = "downVote.do", method = RequestMethod.POST)
	public ModelAndView downVote(String studentId, String commentId, Boolean vote, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Integer intSId = Integer.parseInt(studentId);
		Student student = studentDao.findById(intSId);
		Integer intCId = Integer.parseInt(commentId);
		Comment comment = commentDao.findById(intCId);
		cvDao.create(student, comment, vote);
		mv.setViewName("redirect:cafeteriaforum.do");
		return mv;
	}
	
	@RequestMapping(path="deleteComment.do", method = RequestMethod.POST)
	public String deleteCafeteriaComment(String commentId, RedirectAttributes redir, Model model) {

		int cId = Integer.parseInt(commentId);
		commentDao.softDelete(cId);
		model.addAttribute("cafeteriaComments", commentDao.findCommentsInTheLast24HoursFromCliqueWithId(1));
		return "redirect:cafeteriaforum.do";
	}
	
	@RequestMapping(path="updateComment.do", method = RequestMethod.GET)
	public String goToUpdatePage(String commentId, Model model) {
		int id = Integer.parseInt(commentId);
		model.addAttribute("comment", commentDao.findById(id));
		return "updateComment";
	}
	
	
	@RequestMapping(path="updateComment.do", method = RequestMethod.POST)
	public String updateCafteriaComment(String id, Comment comment, RedirectAttributes redir) {
		int commentId = Integer.parseInt(id);
		commentDao.update(commentId, comment);
		return "redirect:cafeteriaforum.do";
	}
	
	
}