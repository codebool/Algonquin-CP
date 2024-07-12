/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-21
 * Modified: 2024-07-12
 * Description: Lab assignment 09
 */

package Lab09;

import java.util.ArrayList;

public class PersonComparatorDemo {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<Person>(10);
        persons.add(new Person("Bill", "Gate", "123 Main St, Ottawa, ON K2K 3L4", "123455789", "A123421289012345", "ON"));
        persons.add(new Person("John", "Doe", "123 Main Street, Ottawa, ON K2K 3L4", "123456789", "A123456789012345", "ON"));
        persons.add(new Person("Jane", "Doe", "124 Main Street, Ottawa, ON K2K 3L5", "987654321", "B123456789012345", "ON"));
        persons.add(new Person("Alice", "Doe", "125 Main Street, Montreal, ON K2K 3L6", "111222333", "C123456789012345", "QC"));
        persons.add(new Person("Bob", "Smith", "126 Main Street, Quebec City, ON K2K 3L7", "444555666", "D123456789012345", "QC"));
        persons.add(new Person("Charlie", "Brown", "127 Main Street, Vancouver, ON K2K 3L8", "777888999", "E123456789012345", "BC"));
        persons.add(new Person("David", "Wilson", "128 Main Street, Penticton, ON K2K 3L9", "333444555", "F123456789012345", "BC"));
        persons.add(new Person("Eva", "Johnson", "129 Main Street, Brooks, ON K2K 3L0", "666777888", "G123456789012345", "AB"));
        persons.add(new Person("Frank", "Williams", "130 Main Street, Edmonton, ON K2K 3L1", "222333444", "H123456789012345", "AB"));
        persons.add(new Person("Grace", "Martinez", "131 Main Street, Winnipeg, ON K2K 3L2", "555666777", "I123456789012345", "MB"));

        for(Person p : persons) {
            System.out.println(p.getFirstName() + " " + p.getLastName() + " " + p.getAddress() + " " + p.getSin() + " " + p.getDriversLicense() + " " + p.getDriversLicenseProvince());
        }
    }
}
