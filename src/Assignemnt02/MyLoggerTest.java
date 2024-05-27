/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-02
 * Modified: 2024-05-27
 * Description: Assignment 02
 */

package Assignemnt02;

public class MyLoggerTest {
	public static void main(String[] args) {
		// Initialize MyLogger class appropriately (one line of code)
		// Use System.setOut method to set your output stream appropriately (one line of code)
		
		int x = 15;
		System.out.println(x);
		boolean b = true;
		System.out.println(b);
		char c = 'c';
		System.out.println(c);
		char [] s = {'a', 'b', 'c', 'd', 'e'};
		System.out.println(s);
		double d = 34.5;
		System.out.println(d);
		float f = 45.4f;
		System.out.println(f);
		long l = 12345678;
		System.out.println(l);
		Object obj = new Object();
		System.out.println(obj);
		System.out.println("My Name is Michel");
		// ...
		
		/*
		 * I need to be able to call any of the print/println methods that are invoked through System.out. 
		 * The list is:
		 *  void 	print/println(boolean b)
			void 	print/println(char c)
			void 	print/println(char[] s)
			void 	print/println(double d)
			void 	print/println(float f)
			void 	print/println(int i)
			void 	print/println(long l)
			void 	print/println(Object obj)
			void 	print/println(String s)

		 * and I would expect for any of the print/println methods listed above, the output be as follows:
		 * <Date/time including milliseconds and timezone> : <printing a/n parameter type> : <desired output to display>
		 * Example as output for the code above:
		 * Sun, July 1, 2018 at 17:04:02:003 EDT: printing a float: 45.4
		 * Sun, July 1, 2018 at 17:04:02:003 EDT: printing a String: My Name is Michel
		 * 
		 * I should be able to test your code by calling print or println methods using System.out.
		 */

		MyLogger myLogger = new MyLogger();
		myLogger.print(x);
		myLogger.print(b);
		myLogger.print(c);
		myLogger.print(s);
		myLogger.print(d);
		myLogger.print(f);
		myLogger.print(l);
		myLogger.print(myLogger);
		myLogger.print("My Name is Bo Qu");
	}
}
