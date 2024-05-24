package Week03_Inclass.part02;

/**
 * The Car class represents a car with attributes like model, year, and color.
 * It demonstrates constructor overloading and chaining using the 'this' keyword.
 */
public class Car {
    private String model;
    private int year;
    private String color;

    /**
     * Default constructor that initializes the car with default values.
     */
    public Car() {
        this("Unknown", 0, "Unknown");
    }

    /**
     * Constructor that initializes the car with a model and year.
     * The color is set to a default value.
     *
     * @param model The model of the car.
     * @param year The year of manufacture.
     */
    public Car(String model, int year) {
        this(model, year, "Unknown");
    }

    /**
     * Constructor that initializes the car with all attributes.
     *
     * @param model The model of the car.
     * @param year The year of manufacture.
     * @param color The color of the car.
     */
    public Car(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Getter methods
    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    // Setter methods
    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", year=" + year + ", color=" + color + "]";
    }
}
