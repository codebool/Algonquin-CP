/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-21
 * Modified: 2024-07-12
 * Description: Lab assignment 09
 */

package Lab09;

import java.util.Comparator;

public class SinComparator implements Comparator<Person> {
    @Override
    // Compare the SIN of two persons and return the result
    public int compare(Person p1, Person p2) {
        return p1.getSin().compareTo(p2.getSin());
    }
}
