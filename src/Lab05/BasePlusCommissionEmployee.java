/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-09
 * Modified: 2024-05-31
 * Description: Lab assignment 5
 */

package Lab05;

// BasePlusCommissionEmployee class that extends CommissionEmployee
public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;

    public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double salary){
        // call superclass constructor
        super(first, last, ssn, sales, rate);
        setBaseSalary(salary);
    }

    public void setBaseSalary(double salary){
        baseSalary = (salary < 0.0) ? 0.0 : salary;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    // calculate earnings; implement interface Payable method that was
    public double getPaymentAmount(){
        return getBaseSalary() + super.getPaymentAmount();
    }

    public String toString(){
        return String.format("%s: %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
    }
}
