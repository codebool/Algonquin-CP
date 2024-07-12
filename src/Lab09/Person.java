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
    private String getDriversLicenseProvince;

    public Person(String firstName, String lastName, String address, String sin, String driversLicense, String getDriversLicenseProvince) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sin = sin;
        this.driversLicense = driversLicense;
        this.getDriversLicenseProvince = getDriversLicenseProvince;
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

    public String getGetDriversLicenseProvince() {
        return getDriversLicenseProvince;
    }

    public void setGetDriversLicenseProvince(String getDriversLicenseProvince) {
        this.getDriversLicenseProvince = getDriversLicenseProvince;
    }
}
