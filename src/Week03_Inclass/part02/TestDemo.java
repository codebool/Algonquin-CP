package Week03_Inclass.part02;

/**
 * The TestDemo class demonstrates the creation and manipulation of Car and Bicycle objects.
 * It uses the constructors defined in the Car and Bicycle classes to show constructor chaining.
 */
public class TestDemo {
    public static void main(String[] args) {
        // Creating Car objects using different constructors
        Car defaultCar = new Car();
        Car modelYearCar = new Car("Toyota", 2020);
        Car fullCar = new Car("Honda", 2021, "Red");

        // Displaying Car objects
        System.out.println("Default Car: " + defaultCar);
        System.out.println("Model and Year Car: " + modelYearCar);
        System.out.println("Full Car: " + fullCar);

        // Creating Bicycle objects using different constructors
        Bicycle defaultBicycle = new Bicycle();
        Bicycle brandTypeBicycle = new Bicycle("Giant", "Mountain");
        Bicycle fullBicycle = new Bicycle("Trek", "Road", 21);

        // Displaying Bicycle objects
        System.out.println("Default Bicycle: " + defaultBicycle);
        System.out.println("Brand and Type Bicycle: " + brandTypeBicycle);
        System.out.println("Full Bicycle: " + fullBicycle);
    }
}
