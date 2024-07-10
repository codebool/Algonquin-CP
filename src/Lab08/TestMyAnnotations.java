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
import org.junit.jupiter.api.Test;

public class TestMyAnnotations {

    @BeforeAll
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeAll - runOnceBeforeClass");
    }

    @AfterAll
    public static void runOnceAfterClass() {
        System.out.println("@AfterAll - runOnceAfterClass");
    }

    @BeforeEach
    public void runBeforeTestMethod() {
        System.out.println("@BeforeEach - runBeforeTestMethod");
    }

    @AfterEach
    public void runAfterTestMethod() {
        System.out.println("@AfterEach - runAfterTestMethod");
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
