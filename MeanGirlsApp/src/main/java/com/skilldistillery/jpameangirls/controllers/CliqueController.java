package com.skilldistillery.jpameangirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.jpameangirls.dao.CliqueDAO;

@Controller
public class CliqueController {

	@Autowired
	private CliqueDAO cliqueDao;
	
	
}
