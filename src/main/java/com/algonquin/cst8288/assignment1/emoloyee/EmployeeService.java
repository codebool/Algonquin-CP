package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Date;

/**
 * 
 * EmployeeService interface
 * 
 */

public interface EmployeeService {
	double BONUS_PERCENTAGE = 0.025;
	double PENSION_PERCENTAGE = 0.01;
	double calculateTotalCompensation(Employee employee);
	double getSalary(Employee employee);
}

interface PermanentEmployeeService extends EmployeeService {
	double pensionContribution(Employee employee);
	double calculateBonus(Employee employee);
}

interface ContractEmployeeService extends EmployeeService {
	Date renewalDate();
}
