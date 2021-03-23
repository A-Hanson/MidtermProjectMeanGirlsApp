package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.jpameangirls.dao.UserDAO;

@Controller
public class CommentController {

	@Autowired
	private UserDAO userDao;
}
