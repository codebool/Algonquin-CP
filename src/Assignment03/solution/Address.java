/**
 * The Address class encapsulates details of a physical address.
 * It includes fields such as street number, street name, street type, orientation, city name, and province.
 * Each field has private access and corresponding getters and setters.
 */
public class Address {
    private String streetNumber;  // Stores the street number
    private String streetName;    // Stores the street name
    private String streetType;    // Stores the street type (e.g., Blvd, St)
    private String streetOrientation; // Stores the street orientation (e.g., North, South)
    private String cityName;      // Stores the city name
    private String province;      // Stores the province in two-letter format

    // Getters and Setters

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getStreetOrientation() {
        return streetOrientation;
    }

    public void setStreetOrientation(String streetOrientation) {
        this.streetOrientation = streetOrientation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}