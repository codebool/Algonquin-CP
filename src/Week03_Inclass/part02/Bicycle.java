package Week03_Inclass.part02;

/**
 * The Bicycle class represents a bicycle with attributes like brand, type, and gear count.
 * It demonstrates constructor overloading and chaining using the 'this' keyword.
 */
public class Bicycle {
    private String brand;
    private String type;
    private int gears;

    /**
     * Default constructor that initializes the bicycle with default values.
     */
    public Bicycle() {
        this("Unknown", "Unknown", 1);
    }

    /**
     * Constructor that initializes the bicycle with a brand and type.
     * The gears are set to a default value.
     *
     * @param brand The brand of the bicycle.
     * @param type The type of the bicycle.
     */
    public Bicycle(String brand, String type) {
        this(brand, type, 1);
    }

    /**
     * Constructor that initializes the bicycle with all attributes.
     *
     * @param brand The brand of the bicycle.
     * @param type The type of the bicycle.
     * @param gears The number of gears.
     */
    public Bicycle(String brand, String type, int gears) {
        this.brand = brand;
        this.type = type;
        this.gears = gears;
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getGears() {
        return gears;
    }

    // Setter methods
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public String toString() {
        return "Bicycle [brand=" + brand + ", type=" + type + ", gears=" + gears + "]";
    }
}
