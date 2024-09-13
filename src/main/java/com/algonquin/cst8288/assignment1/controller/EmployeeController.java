package com.algonquin.cst8288.assignment1.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.persistence.PersistenceService;

public class EmployeeController {

	public String processEmployee(Employee employee) throws IOException {
		EmployeeProcessor processor = new EmployeeProcessor();
		processor.process(employee);
		
		EmployeeValidator validator = new EmployeeValidator();
		if (!validator.isValid(employee)) {
			return "FALIED";
		}

		PersistenceService saver = new PersistenceService(new JSONFormatter());
		saver.save(employee, "employee_data.txt");

		return "SUCCESS";
	}

	private class EmployeeProcessor {
		public void process(Employee employee) {
			// Process data
		}
	}

	private class EmployeeValidator {
		private boolean isValid(Employee employee) {
			if (!isPresent(employee.getName())) {
				return false;
			}
			employee.setName(employee.getName().trim());

			if (!isValidAlphaNumeric(employee.getName())) {
				return false;
			}
			if (employee.getEmail() == null || employee.getEmail().trim().length() == 0) {
				return false;
			}
			employee.setEmail(employee.getEmail().trim());
			if (!isValidEmail(employee.getEmail())) {
				return false;
			}

			if (!isNoSalary(employee.getSalary())) {
				return false;
			}

			if (!isNoCompensation(employee.getTotalCompensation())) {
				return false;
			}

			if (!isNoServiceYear(employee.getNumberOfServiceYear())) {
				return false;
			}

			return true;
		}

		private boolean isPresent(String value) {
			return value != null && value.trim().length() > 0;
		}

		private boolean isValidAlphaNumeric(String value) {
			Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
			Matcher matcher = pattern.matcher(value);
			return !matcher.find();
		}

		private boolean isValidEmail(String value) {
			Pattern pattern = Pattern
					.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher = pattern.matcher(value);
			return matcher.find();
		}

		private boolean isNoSalary(double salary) {
			return salary <= 0 ? false : true ;
		}

		private boolean isNoCompensation(double compensation) {
			return compensation <= 0 ? false : true ;
		}

		private boolean isNoServiceYear(int serviceYear) {
			return serviceYear <= 0 ? false : true ;
		}
	}
}