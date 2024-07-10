/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-14
 * Modified: 2024-07-10
 * Description: Lab assignment 08
 */

package Lab08;

public class Employee {
	private String firstName;
	private String lastName;
	private int yearsOfService;
	private String gender;
	private double salary;
	
	public Employee(String firstName, String lastName, int yearsOfService, String gender, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsOfService = yearsOfService;
		this.gender = gender;
		this.salary = salary;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getYearsOfService() {
		return yearsOfService;
	}
	public void setYearsOfService(int years) {
		this.yearsOfService = years;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
