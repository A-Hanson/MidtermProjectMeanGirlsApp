package com.skilldistillery.jpameangirls.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jpameangirls.dao.CliqueDAO;
import com.skilldistillery.jpameangirls.dao.CommentDAO;
import com.skilldistillery.jpameangirls.dao.CommentVoteDAO;
import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Comment;

@Controller
public class CliqueController {

	@Autowired
	private CliqueDAO cliqueDao;
	
	@Autowired
	private CommentDAO commentDao;

	@Autowired
	private CommentVoteDAO cvDao;

	@RequestMapping(path = "cafeteriaforum.do")
	public String index(Model model) {
		Clique cafeteria = cliqueDao.findById(1);
		List<Comment> comments = commentDao.findCommentsInTheLast24HoursFromCliqueWithId(1);
		for (Comment comment : comments) {
			comment.setTotalFetch(cvDao.commentTotalScore(comment.getId()));
		}
		model.addAttribute("clique", cafeteria);
		model.addAttribute("cafeteriaComments", comments);
		return "cafeteria"; // if using a ViewResolver.
	}
	
	@RequestMapping(path="plasticsform.do", method=RequestMethod.GET)
	public String loadPlastics(Model model, String studentId) {
		int sId = Integer.parseInt(studentId);
		Clique plastics = cliqueDao.findById(2);
		List<Comment> comments = commentDao.findCommentsByCliqueId(2);
		for (Comment comment : comments) {
			comment.setTotalFetch(cvDao.commentTotalScore(comment.getId()));
		}
		model.addAttribute("clique", plastics);
		model.addAttribute("studentFetch", cvDao.studentTotalScore(sId));
		model.addAttribute("plasticsComments", comments);
		return "plastics";
	}
	
	@RequestMapping(path="addClique.do", method=RequestMethod.POST)
	public String addClique() {
//		FIXME
		return "";
	}



}
