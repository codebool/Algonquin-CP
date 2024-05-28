/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-28
 * Modified: 2024-05-28
 * Description: Lab assignment
 */

package Week04_Inclass;

public class BasePlusCommisionEmployee extends CommisionEmployee {
    private double baseSalary; // base salary per week

    // constructor
    public BasePlusCommisionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }

        this.baseSalary = baseSalary;
    }

    // Setters
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }

        this.baseSalary = baseSalary;
    }

    // Getters
    public double getBaseSalary() {
        return baseSalary;
    }

    // Calculate earnings
    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }

    // Return String representation of BasePlusCommisionEmployee object
    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f",
                "base-salaried", super.toString(), "base salary", getBaseSalary());
    }
}
