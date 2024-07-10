/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-14
 * Modified: 2024-07-10
 * Description: Lab assignment 08
 */

package Lab08;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ AllTests.class, MyFirstTestCase.class, TestManagement.class, TestMyAnnotations.class })
public class AllTests2 {
}

