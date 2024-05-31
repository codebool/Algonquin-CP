/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-09
 * Modified: 2024-05-31
 * Description: Lab assignment 5
 */

package Lab05;

// CommissionEmployee class that extends Employee
public class CommissionEmployee extends Employee{
    // instance variables
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String first, String last, String ssn, double sales, double rate){
        // call superclass constructor
        super(first, last, ssn);
        setGrossSales(sales);
        setCommissionRate(rate);
    }

    public void setGrossSales(double sales){
        grossSales = sales < 0.0 ? 0.0 : sales;
    }

    public double getGrossSales(){
        return grossSales;
    }

    public void setCommissionRate(double rate){
        commissionRate = (rate > 0.0 && rate < 1.0) ? rate : 0.0;
    }

    public double getCommissionRate(){
        return commissionRate;
    }

    // calculate earnings; implement interface Payable method that was
    public double getPaymentAmount(){
        return getCommissionRate() * getGrossSales();
    }

    public String toString(){
        return String.format("%s: %s\n%s: $%,.2f; %s: %.2f", "commission employee", super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
    }
}
