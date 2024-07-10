/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-14
 * Modified: 2024-07-10
 * Description: Lab assignment 08
 */

package Lab08;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestManagement {
	private static Employee emp1;
	private static Employee emp2;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		// setup first employee
		emp1 = new Employee("John", "Doe", 15, "Male", 70000);

		// setup second employee
		emp2 = new Employee("Sarah", "Smith", 5, "Female", 75000);
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testPayEquity() {
		Assertions.assertNotEquals(emp2.getSalary(), emp1.getSalary(), "Pay Equity needed ...");

		if (emp2.getSalary() > emp1.getSalary()) {
			if (emp1.getGender().equalsIgnoreCase("F"))
				if (emp2.getGender().equalsIgnoreCase("M")) {
					Management.payEquity(emp2, emp1);
					Assertions.assertEquals(emp2.getSalary(), emp1.getSalary(), 0, "Pay Equity imposed ...");
				}
		}
	}

	@Test
	public void testPromotion() {
		Assertions.assertNotEquals(7, emp1.getYearsOfService());
		Assertions.assertEquals(70000, emp1.getSalary(), 0, "Salary before promotion: ");
		Management.promotion(emp1);
		Assertions.assertEquals(77000.0, emp1.getSalary(), 1, "Salary after promotion: ");
	}

}

