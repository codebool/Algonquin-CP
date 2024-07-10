package Lab08;

import org.junit.*;

public class TestMyAnnotations {

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }

    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
    }

    @Test
    public void testMethod1() {
        System.out.println("@Test - testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("@Test - testMethod2");
    }

}