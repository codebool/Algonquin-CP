/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-21
 * Modified: 2024-07-12
 * Description: Lab assignment 09
 */

package Lab09;

public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String sin;
    private String driversLicense;
    private String driversLicenseProvince;

    public Person(String firstName, String lastName, String address, String sin, String driversLicense, String driversLicenseProvince) {
        if (!sin.matches("\\d{9}")) {
            throw new IllegalArgumentException("SIN must be 9 digits.");
        }
        if (!driversLicense.matches("[A-Z]\\d{15}")) {
            throw new IllegalArgumentException("Drivers License must be one upper case character followed by 15 digits.");
        }
        if (!driversLicenseProvince.matches("[A-Z]{2}")) {
            throw new IllegalArgumentException("Drivers License Province must be two uppercase letters.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sin = sin;
        this.driversLicense = driversLicense;
        this.driversLicenseProvince = driversLicenseProvince;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public String getDriversLicenseProvince() {
        return driversLicenseProvince;
    }

    public void setDriversLicenseProvince(String driversLicenseProvince) {
        this.driversLicenseProvince = driversLicenseProvince;
    }
}
