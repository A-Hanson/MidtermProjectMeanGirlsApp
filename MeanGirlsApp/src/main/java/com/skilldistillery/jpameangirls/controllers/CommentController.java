package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.jpameangirls.dao.CommentDAO;
import com.skilldistillery.jpameangirls.dao.UserDAO;

@Controller
public class CommentController {

	@Autowired
	private CommentDAO commentDao;
	
	@RequestMapping(path="deleteComment.do", method = RequestMethod.POST)
	public String deleteCafeteriaComment(String commentId, RedirectAttributes redir) {

		int cId = Integer.parseInt(commentId);
		commentDao.softDelete(cId);
		return "redirect:cafeteriaforum.do";
	}
}
