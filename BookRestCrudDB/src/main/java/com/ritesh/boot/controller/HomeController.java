package com.ritesh.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	// Seperate Home Controller
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homeController() {
		return 	
				""" 
				the concept used in this project is as follows: 
					
					1. Spring Boot
					2. REST End-point
					3. JPA 
					4. Logging
					5. Maven
				
				""";
	}
}
