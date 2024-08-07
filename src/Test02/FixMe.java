/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-08-09
 * Modified: 2024-08-09
 * Description: Test 02
 */

package Test02;

import java.util.Scanner;

public class FixMe {
    String[] ageRange = new String[3];

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(System.in);
            System.out.print("Enter age: ");
            int age = input.nextInt();
            FixMe fixMe = new FixMe();
            System.out.println("The age range for age " + age + " is: " + fixMe.getAgeRange(age));
        } catch (NotAdultAgeRangeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }

    public String getAgeRange(int age) throws NotAdultAgeRangeException {
        if (age >= 10 & age < 18) {
            ageRange[0] = "Teenage";
            throw new NotAdultAgeRangeException("Not an adult age range");
        } else if (age >= 20 & age < 30) {
            ageRange[1] = "Twenties";
            return ageRange[1];
        } else if (age >= 30 & age < 40) {
            ageRange[2] = "Thirties";
            return ageRange[2];
        } else {
            return null;
        }
    }

    private static class NotAdultAgeRangeException extends Exception {
        private static final long serialVersionUID = 1L;

        String msg;

        public NotAdultAgeRangeException(String message) {
            super();
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}  // end of class FixMe


