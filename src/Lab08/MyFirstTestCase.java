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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MyFirstTestCase {
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

	@Disabled
	@Test
	public void testGetFirstName() {
		Assertions.assertTrue(emp1.getFirstName().equals("John") &&
				emp2.getFirstName().equals("Sarah"));
	}

	@Test
	public void testSetFirstName() {
		emp1.setFirstName("Adam");
		emp2.setFirstName("Jane");
		Assertions.assertTrue(emp1.getFirstName().equals("Adam") &&
				emp2.getFirstName().equals("Jane"));
	}

}
