/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment 1
 */

package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Date;

/**
 * EmployeeService interface
 */

// EmployeeService interface with methods
public interface EmployeeService {
	double calculateTotalCompensation(Employee employee);
	double getSalary(Employee employee);
}

// PermanentEmployeeService interface with methods
interface PermanentEmployeeService extends EmployeeService {
	double pensionContribution(Employee employee);
	double calculateBonus(Employee employee);
}

// ContractEmployeeService interface with methods
interface ContractEmployeeService extends EmployeeService {
	Date renewalDate();
}
