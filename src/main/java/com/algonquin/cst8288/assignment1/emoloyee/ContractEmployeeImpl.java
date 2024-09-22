/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment 1
 */

package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Calendar;
import java.util.Date;

public class ContractEmployeeImpl implements ContractEmployeeService {
    @Override
    // Calculate the total compensation of a contract employee
    public double calculateTotalCompensation(Employee employee) {
        return getSalary(employee);
    }

    @Override
    // Get the salary of a contract employee
    public double getSalary(Employee employee) {
        return employee.getSalary();
    }

    @Override
    // Get the renewal date of a contract employee
    public Date renewalDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        // Set the renewal date to the next year
        return calendar.getTime();
    }
}
