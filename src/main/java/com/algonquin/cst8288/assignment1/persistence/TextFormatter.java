/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment 1
 */

package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;

import java.io.IOException;
import java.util.StringJoiner;

// TextFormatter class to format the employee object
public class TextFormatter implements Formatter {
    @Override
    public String format(Employee employee) throws IOException {
        if (employee == null) {
            throw new IOException("Employee object is null");
        }

        // Use StringJoiner to join the formatted employee object
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("name=" + employee.getName());
        joiner.add("email=" + employee.getEmail());
        joiner.add("address=" + employee.getAddress());
        joiner.add("salary=" + employee.getSalary());
        joiner.add("numberOfServiceYear=" + employee.getNumberOfServiceYear());
        joiner.add("bonus=" + employee.getBonus());
        joiner.add("totalCompensation=" + employee.getTotalCompensation());
        joiner.add("renewalDate=" + employee.getRenewalDate());

        return joiner.toString();
    }
}
