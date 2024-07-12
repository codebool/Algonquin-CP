/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-21
 * Modified: 2024-07-12
 * Description: Lab assignment 09
 */

package Lab09;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    // Compare the last name of two persons and return the result
    public int compare(Person p1, Person p2) {
        int result = p1.getLastName().compareTo(p2.getLastName());
        // If the last names are the same, compare the first names
        if (result == 0) {
            result = p1.getFirstName().compareTo(p2.getFirstName());
        }
        return result;
    }
}
