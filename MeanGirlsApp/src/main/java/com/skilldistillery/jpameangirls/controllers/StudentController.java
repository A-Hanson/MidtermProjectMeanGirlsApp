package com.skilldistillery.jpameangirls.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.jpameangirls.dao.CommentVoteDAO;
import com.skilldistillery.jpameangirls.dao.StudentDAO;
import com.skilldistillery.jpameangirls.dao.UserDAOJpaImpl;
import com.skilldistillery.jpameangirls.entities.Student;
import com.skilldistillery.jpameangirls.entities.User;

@Controller
public class StudentController {

	@Autowired
	private StudentDAO studentDao;

	@Autowired
	private UserDAOJpaImpl userDao;

	@Autowired
	private CommentVoteDAO cvDao;

	@RequestMapping(path = { "dashboard.do" }, method = RequestMethod.GET)
	public ModelAndView loadDashboard(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			if (user.getRole().equals("user")) {
				int userId = user.getId();
				List<Student> students = userDao.findAllStudentsForUser(userId);
				for (Student student : students) {
					student.setTotalFetch(cvDao.studentTotalScore(student.getId()));
				}
				session.setAttribute("userStudents", students);

			}
		}
		return mv; // (ViewResolver in use)
	}

	@RequestMapping(path = { "dashboard.do" }, params = "studentId", method = RequestMethod.GET)
	public ModelAndView loadDashboardWithStudent(HttpSession session, String studentId) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(studentId);
		Student student = studentDao.findById(id);
		session.setAttribute("student", student);
		session.setAttribute("studentCliques", studentDao.findAllCliquesForAStudent(id));
		session.setAttribute("studentBadges", studentDao.findAllBadgesForAStudent(id));
		mv.addObject("totalFetch", cvDao.studentTotalScore(id));
		mv.addObject("student", student);
		mv.setViewName("dashboard");
		return mv; // (ViewResolver in use)
	}

	@RequestMapping(path = { "submitNewStudent.do" }, method = RequestMethod.POST)
	public ModelAndView submitNewStudent(HttpSession session, Student newStudent, String birthday, String userIdString) {
		int userId = Integer.parseInt(userIdString);
		User user = userDao.findUserById(userId);
		newStudent.setUser(user);
		System.out.println(birthday);
		LocalDate birthdayDate = LocalDate.parse(birthday);
		newStudent.setBirthdayDate(birthdayDate);
		studentDao.create(newStudent);
		ModelAndView mv = new ModelAndView();
		session.setAttribute("student", newStudent);
		mv.addObject("student", newStudent);
		mv.setViewName("dashboard");
		return mv; // (ViewResolver in use)
	}
	
	@RequestMapping(path = { "changeStudent.do" }, method = RequestMethod.GET)
	public ModelAndView changeStudent(HttpSession session) {
		ModelAndView mv = new ModelAndView();
	    Student student = null;
		mv.addObject("student", student);
//		session.setAttribute("student", student);
		mv.setViewName("dashboard");
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			if (user.getRole().equals("user")) {
				student = null;
				session.setAttribute("student", student);
			}
		}
		return mv; // (ViewResolver in use)
	}
	
}
