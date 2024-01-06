package com.rit.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String HomeController() {
		
		return "home";
	}
}
