package com.skilldistillery.jpameangirls.controllers;

import java.time.LocalDate;

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
	
//	@RequestMapping(path= {"createStudent.do"}, method = RequestMethod.GET)
//	public ModelAndView createStudent() {
//		
//		ModelAndView mv = new ModelAndView();
////		Student student = new Student();
////		student.setUser();
////		mv.addObject("student", student);
//		mv.setViewName("createStudent");
//		return mv; // (ViewResolver in use)
//	}
	
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
