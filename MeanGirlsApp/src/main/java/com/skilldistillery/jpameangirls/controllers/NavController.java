package com.skilldistillery.jpameangirls.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavController {
	@RequestMapping(path="goToRegisterPage.do")
	public String goToRegisterPage() {
		return "register";
	}

	@RequestMapping(path="goToCafeteria.do")
	public String goToCafeteria() {
		return "cafeteria";
	}
	
	@RequestMapping(path="goToBurnBook.do")
	public String goToBurnBook() {
		return "burnBook";
	}
	
}
