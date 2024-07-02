/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-27
 * Modified: 2024-06-27
 * Description: Lab assignment
 */

package JavaCore.testBoolean;

interface Animal {
    public void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();  // 输出 "Bark"
    }
}

