/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-07
 * Modified: 2024-07-05
 * Description: Lab assignment 3
 */

package Assignment03;

public class Address {
    private int streetNumber;
    private String streetName;
    private String streetType;
    private String streetOrientation;
    private String city;
    private String province;

    public Address() {}

    public Address(int streetNumber, String streetName, String streetType, String streetOrientation, String city, String province) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.streetType = streetType;
        this.streetOrientation = streetOrientation;
        this.city = city;
        this.province = province;
    }

    public int getStreetNumber() {
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

    public void setStreetNumber(int streetNumber) {
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
