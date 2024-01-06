package com.rit.boot.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rit.boot.data.EmployeeData;
import com.rit.boot.entity.Employee;

@RestController
public class EmpController {

	@Autowired
	Employee employee;

	@Autowired
	EmployeeData empData;

	Logger logger = LoggerFactory.getLogger(EmpController.class);

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String HomeController() {
		logger.debug("Home controller is being called ");
		logger.info("Home info called");
		return "home";
	}

	@GetMapping("/employees")
	public ArrayList<Employee> getEmployees() {
		logger.debug("All employee Details Provided");
		return empData.getAllEmployee();
	}

	/*
	 * @GetMapping("/employee/{id}") public Employee getEmployee(@PathVariable("id")
	 * int id) { return empData.getEmployee(id); }
	 */

	/*
	 * @PostMapping("/employee") public void addNewEmployee(@ModelAttribute Employee
	 * employee) { System.out.println(employee); }
	 */
}
