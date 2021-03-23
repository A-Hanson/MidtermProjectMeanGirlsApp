package com.skilldistillery.jpameangirls.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(path= {"dashboard.do"}, method = RequestMethod.GET)
	public ModelAndView loadDashboard(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		if (session.getAttribute("user") != null) {
			int userId = ((User) session.getAttribute("user")).getId();
			List<Student> students = userDao.findAllStudentsForUser(userId);
			session.setAttribute("userStudents", students);
		}
		return mv; // (ViewResolver in use)
	}
	
	@RequestMapping(path= {"dashboard.do"}, params="studentId", method = RequestMethod.GET)
	public ModelAndView loadDashboardWithStudent(HttpSession session, String studentId) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(studentId);
		Student student = studentDao.findById(id);
		session.setAttribute("student", student);
		mv.addObject("student", student);
		mv.setViewName("dashboard");
		return mv; // (ViewResolver in use)
	}
	
	
	
	@RequestMapping(path={"submitNewStudent.do"}, method = RequestMethod.POST)
	public ModelAndView submitNewStudent(Student newStudent, String birthday, String userIdString) {
		int userId = Integer.parseInt(userIdString);
		User user = userDao.findUserById(userId);
		newStudent.setUser(user);
		System.out.println("**************************************************************");
		System.out.println(birthday);
		LocalDate birthdayDate = LocalDate.parse(birthday);
		newStudent.setBirthdayDate(birthdayDate);
		studentDao.create(newStudent);
		ModelAndView mv = new ModelAndView();
		mv.addObject("student", newStudent);
		mv.setViewName("dashboard");
		return mv; // (ViewResolver in use)
	}
}
