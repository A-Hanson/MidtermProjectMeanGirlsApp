package com.skilldistillery.jpameangirls.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class NavController {
	@RequestMapping(path="goToRegisterPage.do")
	public String goToRegisterPage() {
		return "register";
	}
}
