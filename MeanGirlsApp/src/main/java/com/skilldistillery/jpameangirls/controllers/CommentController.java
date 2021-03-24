package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.jpameangirls.dao.CommentDAO;
import com.skilldistillery.jpameangirls.entities.Comment;

@Controller
public class CommentController {

	@Autowired
	private CommentDAO commentDao;
	
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
