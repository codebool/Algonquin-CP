package com.algonquin.cst8288.assignment1.controller;


import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.emoloyee.PermanentEmployeeImpl;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.persistence.PersistenceService;
import com.algonquin.cst8288.assignment1.persistence.TextFormatter;

import java.io.IOException;

/**
 * 
 * Main class to execute the application
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		// Instantiate two Employee objects
		Employee permanentEmployee = new Employee();
		permanentEmployee.setName("John Deer");
		permanentEmployee.setEmail("john.deer@example.com");
		permanentEmployee.setSalary(70000);
		permanentEmployee.setNumberOfServiceYear(6);

		Employee contractEmployee = new Employee();
		contractEmployee.setName("Bill Guess");
		contractEmployee.setEmail("bill.guess@example.com");
		contractEmployee.setSalary(120000);
		contractEmployee.setNumberOfServiceYear(4);

		// Use PermanentEmployeeImpl to calculate and populate required data
		PermanentEmployeeImpl permanentEmployeeService = new PermanentEmployeeImpl();
		permanentEmployee.setTotalCompensation(permanentEmployeeService.calculateTotalCompensation(permanentEmployee));

		// Use ContractEmployeeImpl to calculate and populate required data
		// Assuming ContractEmployeeImpl is similar to PermanentEmployeeImpl
		// ContractEmployeeImpl contractEmployeeService = new ContractEmployeeImpl();
		// contractEmployee.setTotalCompensation(contractEmployeeService.calculateTotalCompensation(contractEmployee));

		// Utilize EmployeeController to save both objects in JSON and Text formats
		EmployeeController controller = new EmployeeController();

		// Save in JSON format
		PersistenceService jsonSaver = new PersistenceService(new JSONFormatter());
		jsonSaver.save(permanentEmployee, "json_employee_data.txt");
		jsonSaver.save(contractEmployee, "json_employee_data.txt");

		// Save in Text format
		PersistenceService textSaver = new PersistenceService(new TextFormatter());
		textSaver.save(permanentEmployee, "text_employee_data.txt");
		textSaver.save(contractEmployee, "text_employee_data.txt");

		// Output the data to the console in JSON format
		System.out.println("JSON Format:");
		System.out.println(new JSONFormatter().format(permanentEmployee));
		System.out.println(new JSONFormatter().format(contractEmployee));

		// Output the data to the console in Text format
		System.out.println("Text Format:");
		System.out.println(new TextFormatter().format(permanentEmployee));
		System.out.println(new TextFormatter().format(contractEmployee));
	}
}
