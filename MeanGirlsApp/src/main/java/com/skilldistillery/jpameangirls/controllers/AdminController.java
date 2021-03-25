package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.jpameangirls.dao.BurnBookCommentDAO;
import com.skilldistillery.jpameangirls.dao.CliqueDAO;
import com.skilldistillery.jpameangirls.dao.CommentDAO;
import com.skilldistillery.jpameangirls.dao.UserDAO;
import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.User;

@Controller
public class AdminController {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private CommentDAO commentDao;
	
	@Autowired
	private BurnBookCommentDAO burnCommentDao;
	@Autowired
	
	private CliqueDAO cliqueDao;
	
	
	@RequestMapping(path= { "manageUsers.do"})
	public String manageUser() {
		return "manageUsers";
	}
	
	@RequestMapping(path = "getUser.do")
	public ModelAndView getAllUsers() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("users", userDao.findAllUsers());
		mv.setViewName("allUsers");
		return mv;
	}

	@RequestMapping(path = "getUser.do", params = "id")
	public ModelAndView getUserById(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("idNum", id);
		mv.addObject("userLookUp", userDao.findUserById(id));
		mv.setViewName("singleUser");
		return mv;
	}

	@RequestMapping(path = "getUser.do", params = "username", method = RequestMethod.GET)
	public ModelAndView findUserByUsername(String username) {
		ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
		mv.addObject("userLookUp", userDao.findUserByUsername(username));
		mv.setViewName("singleUser");

		return mv;
	}
	
	@RequestMapping(path="updateUser.do", method = RequestMethod.GET)
	public String goToUpdatePage(int id, Model model) {
		model.addAttribute("userLookUp", userDao.findUserById(id));
		return "updateUser";
	}
	
	
	@RequestMapping(path="updateUser.do", method = RequestMethod.POST)
	public String updateUserPage(int id, User user, RedirectAttributes redir, Model model) {
		User u = null;
		 u = userDao.updateUser(id, user);
		 redir.addAttribute("id", u.getId());
		return "redirect:getUser.do";
	}
	
	@RequestMapping(path="deleteUser.do", method = RequestMethod.POST)
	public String deleteUser(int id, RedirectAttributes redir, Model model) {

		userDao.softDelete(id);
		model.addAttribute("deletedUser", id);
		return "redirect:getUser.do";
	}
	
	@RequestMapping(path = "deletePermanently.do", params = "id", method = RequestMethod.GET)
	public ModelAndView deleteUserPermanently(int id) {

		User user = null;
		user = userDao.findUserById(id);
		userDao.deleteUserPermanently(id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("allUsers");
		mv.addObject("deletedUser", user);

		return mv;
	}
	
	@RequestMapping(path= { "manageComments.do"})
	public String manageComments() {
		return "manageComments";
	}
	
	@RequestMapping(path = "getComment.do")
	public ModelAndView getAllComments() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", commentDao.findAll());
		mv.setViewName("commentsList");
		return mv;
	}
	
	@RequestMapping(path = "getBurnComments.do")
	public ModelAndView getBurnComments() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("burnBookComments", burnCommentDao.getAll());
		mv.setViewName("burnBookCommentsList");
		return mv;
	}
	
	@RequestMapping(path="deleteCommentAdmin.do", method = RequestMethod.POST)
	public String deleteAllComment(String commentId, RedirectAttributes redir) {

		int cId = Integer.parseInt(commentId);
		commentDao.softDelete(cId);
		return "redirect:getComment.do";
	}
	
	@RequestMapping(path="deleteCommentBook.do", method = RequestMethod.POST)
	public String deleteBookComment(int id, RedirectAttributes redir) {
		
		burnCommentDao.softDelete(id);
		
		return "redirect:getBurnComments.do";
	}
	
	@RequestMapping(path="deleteCliqueComment.do", method = RequestMethod.POST)
	public String deleteCliqueComment(String commentId,int cliqueId, RedirectAttributes redir) {
		
		int cId = Integer.parseInt(commentId);
		commentDao.softDelete(cId);
		redir.addAttribute("id", cliqueId);
		return "redirect:getCliqueComments.do";
	}
	
	
	@RequestMapping(path = "getCliqueComments.do")
	public ModelAndView getClickComments(String id, String cliqueId) {
		ModelAndView mv = new ModelAndView();
		int cId = Integer.parseInt(id);
		Clique c = cliqueDao.findById(cId);
		mv.addObject("clique", c);
		mv.addObject("cliqueComments", commentDao.findCommentsByCliqueId(cId));
		mv.setViewName("cliqueCommentsList");
		return mv;
	}
	
	
	@RequestMapping(path = "getCommentByUser.do")
	public ModelAndView getCommentsByUser(String username) {
		ModelAndView mv = new ModelAndView();
		User u = userDao.findUserByUsername(username);
		mv.addObject("u", u);
		mv.addObject("comments", commentDao.findCommentsByUsername(username));
		mv.setViewName("commentsByUserList");
		return mv;
	}
	
	@RequestMapping(path="deleteUserComment.do", method = RequestMethod.POST)
	public String deleteUserComment(String commentId,String username, RedirectAttributes redir) {
		
		int cId = Integer.parseInt(commentId);
		commentDao.softDelete(cId);
		redir.addAttribute("username", username);
		return "redirect:getCommentByUser.do";
	}
	
	@RequestMapping(path = "getFlaggedComments.do")
	public ModelAndView getFlaggedComments() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", burnCommentDao.getAllEnabledAndFlagged());
		mv.setViewName("flaggedCommentsList");
		return mv;
	}
	
	@RequestMapping(path="deleteFlaggedComments.do", method = RequestMethod.POST)
	public String deleteFlagged(String commentId, RedirectAttributes redir) {
		
		int cId = Integer.parseInt(commentId);
		burnCommentDao.softDelete(cId);
		return "redirect:getFlaggedComments.do";
	}
}

