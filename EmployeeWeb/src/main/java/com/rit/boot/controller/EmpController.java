package com.rit.boot.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public String HomeController() {
		logger.debug("info called");
		return "home";
	}

	@GetMapping("/employee")
	public ArrayList<Employee> getEmployees() {
		logger.debug("Get request for All employee");
		return empData.getAllEmployee();

		// To Call it: http://localhost:8080/MyApp/employee
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		logger.debug("Get request for " + id);
		return empData.getEmployeeById(id);

		// To call using path variable ex: "http://localhost:8080/MyApp/employee/6916"
	}

	@PostMapping(path = "/employee")
	public void addEmployee(@ModelAttribute Employee employee)
	// public void addEmployee(@RequestBody Employee employee) -> We can also user
	// @RequestBody to accept data
	{
		logger.debug("request to add employee with ID: " + employee.getId() + " name: " + employee.getName());
		empData.addEmployee(employee);

		// we can make a POST request giving the details in Postman-> Body form-data
		// (key-value pair)
	}

	@DeleteMapping(path = "/employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		logger.debug("Delete request for ID: " + id);
		empData.deleteEmployee(id);

		// Delete request form POSTMAN ex: "http://localhost:8080/MyApp/employee/6916"
	}

	@PutMapping("/employee")
	public void updateEmployeeBiId(@RequestBody Employee employee) {
		if (employee != null) {
			empData.updateEmployee(employee);
		}

		// we can make a PUT request giving the details in Postman-> Body RAW (JSON)
	}
}