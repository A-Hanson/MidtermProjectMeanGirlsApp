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
import com.skilldistillery.jpameangirls.dao.StudentDAO;
import com.skilldistillery.jpameangirls.dao.UserDAO;
import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Comment;
import com.skilldistillery.jpameangirls.entities.Student;

@Controller
public class CliqueController {

	@Autowired
	private CliqueDAO cliqueDao;

	@Autowired
	private CommentDAO commentDao;

	@Autowired
	private UserDAO userDao;

	@Autowired
	private StudentDAO studentDao;

	@RequestMapping(path = "cafeteriaforum.do")
	public String index(Model model) {

		model.addAttribute("cafeteriaComments", commentDao.findAll());
		return "cafeteria"; // if using a ViewResolver.
	}

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

}
