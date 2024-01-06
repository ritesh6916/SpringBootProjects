package com.rit.boot.data;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.rit.boot.entity.Employee;

@Component
public class EmployeeData {

	private static ArrayList<Employee> empList = new ArrayList<>();
	
	static {
		
		empList.add(new Employee(6916,"Ritesh","riteshsingh0500@gmail.com","8002208399","Cognizant","Java Dev","IT"));
		empList.add(new Employee(1111,"Shyam","riteshsingh0500@gmail.com","8002208399","Cognizant","Java Dev","IT"));
		empList.add(new Employee(2222,"Mohan","riteshsingh0500@gmail.com","8002208399","Cognizant","Java Dev","IT"));
		empList.add(new Employee(3333,"Sohan","riteshsingh0500@gmail.com","8002208399","Cognizant","Java Dev","IT"));
	}
	
	void add(Employee e) {
		empList.add(e);
	}
	
	
}
