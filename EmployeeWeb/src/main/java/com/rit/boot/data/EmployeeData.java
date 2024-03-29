package com.rit.boot.data;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rit.boot.entity.Employee;

@Component
public class EmployeeData {

	private static ArrayList<Employee> empList = new ArrayList<>();

	Logger logger = LoggerFactory.getLogger(EmployeeData.class);

	static {

		empList.add(
				new Employee(6916, "Ritesh", "riteshsingh0500@gmail.com", "8002208399", "Cognizant", "Java Dev", "IT"));
		empList.add(new Employee(1111, "Shyam", "shaym@gmail.com", "8002208399", "Calsof", "Security", "IT"));
		empList.add(new Employee(2222, "Mohan", "mohan@gmail.com", "8937483739", "Wipro", "Support", "IT"));
		empList.add(new Employee(3333, "Sohan", "sohan@gmail.com", "3339383943", "nowhere", "Java Dev", "IT"));
	}

	public void addEmployee(Employee e) {
		empList.add(e);
	}

	public ArrayList<Employee> getAllEmployee() {

		return empList;
	}

	public Employee getEmployeeById(int id) {

		for (Employee e : empList) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	public void deleteEmployee(int id) {
		int indexOf = 0;
		for (Employee e : empList) {
			if (e.getId() == id) {
				indexOf = empList.indexOf(e);
			}
		}
		if (indexOf != 0) {
			empList.remove(indexOf);
		} else {
			try {
				throw new NullPointerException();
			} catch (NullPointerException e) {
				logger.debug("The data is not present for ID: " + id);
			}
		}
	}

	public void updateEmployee(Employee emp) {
		deleteEmployee(emp.getId());
		addEmployee(emp);
	}
}