package com.rit.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rit.boot.entity.Employee;

@RestController
public class EmpController {
	
	@Autowired
	Employee employee;
	
	
	Logger logger = LoggerFactory.getLogger(EmpController.class); 
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String HomeController() {
		logger.debug("Home controller is being called ");
		logger.info("Home info called");
		return "home";
	}
	
	@RequestMapping(path = "/employee", method=RequestMethod.POST)
	public void addNewEmployee(@ModelAttribute Employee employee) {
		System.out.println(employee);
	}
	
	public Employee getEmployees() {
		
		return employee;
	}
}
