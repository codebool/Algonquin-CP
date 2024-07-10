package Lab08;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestManagement {
	private static Employee emp1;
	private static Employee emp2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// setup first employee
		emp1 = new Employee("John", "Doe", 15, "Male", 70000);
		
		// setup second employee
		emp2 = new Employee("Sarah", "Smith", 5, "Female", 75000);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPayEquity() {
		Assert.assertNotEquals("Pay Equity needed ...", emp2.getSalary(), emp1.getSalary(), 0);
		
		if (emp2.getSalary() > emp1.getSalary()) {
			if(emp1.getGender().equalsIgnoreCase("F"))
				if (emp2.getGender().equalsIgnoreCase("M")) {
					Management.payEquity(emp2, emp1);
					Assert.assertEquals("Pay Equity imposed ...", emp2.getSalary(), emp1.getSalary(), 0);
				}
		}
	}

	@Test
	public void testPromotion() {
		Assert.assertNotEquals(7, emp1.getYearsOfService());
		Assert.assertEquals("Salary b4 promotion: ", 70000, emp1.getSalary(), 0);
		Management.promotion(emp1);
		Assert.assertEquals("Salary after promotion: ", 77000.0, emp1.getSalary(), 1);
	}

}
