package com.skilldistillery.jpameangirls.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.skilldistillery.jpameangirls.entities.User;

@Controller
public class CliqueController {

	@Autowired
	private CliqueDAO cliqueDao;
	
	@Autowired
	private CommentDAO commentDao;

	@Autowired
	private CommentVoteDAO cvDao;
	
	@Autowired
	private StudentDAO studentDao;
	

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
	public ModelAndView loadPlastics(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		Clique plastics = cliqueDao.findById(2);
		if (user.getRole().equals("user")) {
			Student student = (Student) session.getAttribute("student");
			student.setTotalFetch(cvDao.studentTotalScore(student.getId()));
			session.setAttribute("student", student);
			
			boolean partOfClique = cliqueDao.isStudentPartOfClique(student, plastics);
			mv.addObject("partOfClique", partOfClique);
		}

		List<Comment> comments = commentDao.findCommentsByCliqueId(2);
		for (Comment comment : comments) {
			comment.setTotalFetch(cvDao.commentTotalScore(comment.getId()));
		}
		mv.addObject("clique", plastics);
		mv.addObject("plasticsComments", comments);
		mv.setViewName("plastics");
		return mv;
	}
	
	@RequestMapping(path="addStudentToClique.do", method=RequestMethod.POST)
	public String addClique(String cliqueId, HttpSession session, RedirectAttributes redir) {
		Student student = (Student) session.getAttribute("student");
		int id = Integer.parseInt(cliqueId);
		Clique clique = cliqueDao.findById(id);
		cliqueDao.addStudentToClique(student, clique);
		studentDao.addBadgeToStudent(student, 3); // HARDCODED AT THE MOMENT JUST FOR THE PLASTICS
		return "redirect:plasticsform.do";
	}



}
