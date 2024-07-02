/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-14
 * Modified: 2024-06-14
 * Description: Lab assignment
 */

package Lab07;

public class A {

    int x;
    public A(int y) {
        int x = y;
    }

    public void aMethod() {
        System.out.println(x);
    }

    public static void main(String[] args) {
        A a = new A(4);
        a.aMethod();
    }
}
