/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-28
 * Modified: 2024-07-20
 * Description: Lab assignment 4
 */

package Assignment04;

public class Address {
    private String streetNumber;
    private String streetName;
    private String streetType;
    private String streetOrientation;
    private String city;
    private String province;

    public Address() {}

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    public String getStreetOrientation() {
        return streetOrientation;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public void setStreetOrientation(String streetOrientation) {
        this.streetOrientation = streetOrientation;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
