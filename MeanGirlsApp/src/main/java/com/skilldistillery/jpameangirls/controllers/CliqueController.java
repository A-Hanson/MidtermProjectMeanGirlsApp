package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jpameangirls.dao.CommentDAO;
import com.skilldistillery.jpameangirls.dao.CommentVoteDAO;

@Controller
public class CliqueController {


	@Autowired
	private CommentDAO commentDao;

	@Autowired
	private CommentVoteDAO cvDao;

	@RequestMapping(path = "cafeteriaforum.do")
	public String index(Model model, String studentId) {
		int sId = Integer.parseInt(studentId);
		model.addAttribute("studentFetch", cvDao.studentTotalScore(sId));
		model.addAttribute("cafeteriaComments", commentDao.findCommentsInTheLast24HoursFromCliqueWithId(1));
		return "cafeteria"; // if using a ViewResolver.
	}
	
	@RequestMapping(path="plasticsform.do", method=RequestMethod.GET)
	public String loadPlastics(Model model) {
		model.addAttribute("plasticsComments", commentDao.findCommentsByCliqueId(2));
		return "plastics";
	}



}
