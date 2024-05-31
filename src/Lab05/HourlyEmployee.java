/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-09
 * Modified: 2024-05-31
 * Description: Lab assignment 5
 */

package Lab05;
 // HourlyEmployee class that extends Employee
public class HourlyEmployee extends Employee{
    // instance variables
    private double wage;
    private double hours;

    public HourlyEmployee(String first, String last, String ssn, double hourlyWage, double hoursWorked){
        // call superclass constructor
        super(first, last, ssn);
        setWage(hourlyWage);
        setHours(hoursWorked);
    }

    public void setWage(double hourlyWage){
        // if hourly wage is negative, set it to 0.0
        wage = hourlyWage < 0.0 ? 0.0 : hourlyWage;
    }

    public double getWage(){
        return wage;
    }

    public void setHours(double hoursWorked){
        // if hours worked is negative or greater than 168, set it to 0.0
        hours = (hoursWorked >= 0 && hoursWorked <= 168) ? hoursWorked : 0.0;
    }

    public double getHours(){
        return hours;
    }

    public String toString(){
        // return String representation of HourlyEmployee object
        return String.format("hourly employee: %s\n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours());
    }

    // calculate earnings; implement interface Payable method that was
    public double getPaymentAmount(){
        // if hours worked is less than or equal to 40, return wage * hours
        if(hours <= 40){
            return getWage() * getHours();
        }else{
            // 40 hours at regular wage, then the rest at 1.5 times the wage
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
        }
    }
}
