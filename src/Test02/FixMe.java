/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-08-09
 * Modified: 2024-08-09
 * Description: Test 02
 */

package Test02;

import java.util.Scanner.*;

public class FixMe {
    String [] ageRange = new String[];

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter age: ");
            int age = input.nextInt();
            System.out.println("The age range for age " + age + " is: " + getAgeRange(age));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (NotAdultAgeRangeException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }

    public String[] getAgeRange(int age) throws NullPointerException, NotAdultAgeRangeException {
        String ageRange;

        if (age >= 10 & age < 18) {
            ageRange[0] = "Teenage";
            throw new NotAdultAgeRangeException("Not an adult age range");
        } else if (age >= 20 & age < 30) {
            ageRange[1] = "Twenties";
            return ageRange;
        } else if (age >= 30 & age < 40) {
            ageRange[2] = "Thirties";
            return ageRange;
        } else {
            return ageRange;
        }
    }

    private class NotAdultAgeRangeException extends Exception {
        private static final long serialVersionUID = 1L;

        String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}  // end of class FixMe

