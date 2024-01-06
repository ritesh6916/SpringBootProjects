package com.rit.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	Logger logger = LoggerFactory.getLogger(EmpController.class); 
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String HomeController() {
		logger.debug("Home controller is being called ");
		return "home";
	}
}
