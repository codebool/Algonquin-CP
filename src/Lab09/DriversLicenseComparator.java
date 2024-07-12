/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-21
 * Modified: 2024-07-12
 * Description: Lab assignment 09
 */

package Lab09;

import java.util.Comparator;

public class DriversLicenseComparator implements Comparator<Person> {
    @Override
    // Compare the Drivers License of two persons and return the result
    public int compare(Person p1, Person p2) {
        int result = p1.getDriversLicenseProvince().compareTo(p2.getDriversLicenseProvince());
        // If the Drivers License Provinces are the same, compare the Drivers License
        if (result == 0) {
            result = p1.getDriversLicense().compareTo(p2.getDriversLicense());
        }
        return result;
    }
}
