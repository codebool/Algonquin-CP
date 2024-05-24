package Week03_Inclass.part02_advanced;

/**
 * The RaceGame class simulates a race between a car and a bicycle in a straight line.
 * The race is based on their random top speed and acceleration.
 */
public class RaceGame {
    public static void main(String[] args) {
        // Create a car and a bicycle
        Car car = new Car("Toyota", 2020, "Red");
        Bicycle bicycle = new Bicycle("Giant", "Mountain", 21);

        // Race parameters
        int raceDistance = 1000; // Race distance in meters

        System.out.println("Starting the race!");
        System.out.println(car);
        System.out.println(bicycle);

        // Simulate the race
        while (car.getDistanceCovered() < raceDistance && bicycle.getDistanceCovered() < raceDistance) {
            car.raceForOneSecond();
            bicycle.raceForOneSecond();

            // Display the progress
            System.out.println("Car distance: " + car.getDistanceCovered() + " m");
            System.out.println("Bicycle distance: " + bicycle.getDistanceCovered() + " m");

            // Pause for a second to simulate real-time racing (optional)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Determine the winner
        if (car.getDistanceCovered() >= raceDistance && bicycle.getDistanceCovered() >= raceDistance) {
            System.out.println("It's a tie!");
        } else if (car.getDistanceCovered() >= raceDistance) {
            System.out.println("The car wins!");
        } else {
            System.out.println("The bicycle wins!");
        }

        // Display the final states
        System.out.println("Race finished!");
        System.out.println(car);
        System.out.println(bicycle);
    }
}
