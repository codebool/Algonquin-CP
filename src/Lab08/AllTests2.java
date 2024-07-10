package Lab08;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllTests.class, MyFristTestCase.class, TestManagement.class,
		TestMyAnnotations.class })
public class AllTests2 {

}
