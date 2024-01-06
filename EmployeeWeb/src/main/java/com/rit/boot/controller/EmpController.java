package com.rit.boot.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/employee")
	public ArrayList<Employee> getEmployees() {
		logger.debug("Get request for All employee");
		return empData.getAllEmployee();
		
		//To Call it: http://localhost:8080/MyApp/employee
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		logger.debug("Get request for " + id );
		return empData.getEmployeeById(id);
		
		//To call using path variable ex: "http://localhost:8080/MyApp/employee/6916"
	}
	
	
	/*
	 * @PostMapping("/employee") public void addNewEmployee(@ModelAttribute Employee
	 * employee) { System.out.println(employee); }
	 */
}
