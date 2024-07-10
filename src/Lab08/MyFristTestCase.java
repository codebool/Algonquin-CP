package Lab08;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyFristTestCase {
	private static Employee emp1;
	private static Employee emp2;

	@Before
	public void setUpBeforeClass() throws Exception {
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

	@Ignore
	@Test
	public void testGetFirstName() {
		Assert.assertTrue(emp1.getFirstName().equals("John") && 
				emp2.getFirstName().equals("Sarah"));
	}
	

	@Test
	public void testSetFirstName() {
		emp1.setFirstName("Adam");
		emp2.setFirstName("Jane");
		Assert.assertTrue(emp1.getFirstName().equals("Adam") && 
				emp2.getFirstName().equals("Jane"));
	}

}
