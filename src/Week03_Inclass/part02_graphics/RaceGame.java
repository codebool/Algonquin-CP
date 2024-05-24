package Week03_Inclass.part02_graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The RaceGame class simulates a race between a car and a bicycle in a straight line.
 * The race is based on their random top speed and acceleration.
 */
public class RaceGame extends JPanel implements ActionListener {
    private Car car;
    private Bicycle bicycle;
    private Timer timer;
    private static final int RACE_DISTANCE = 1000; // Race distance in pixels

    // Constructor
    public RaceGame() {
        car = new Car("Toyota", 2020, "Red");
        bicycle = new Bicycle("Giant", "Mountain", 21);
        timer = new Timer(1000, this); // Timer to update the race every second
        timer.start();
    }

    // Paint method to draw the graphics
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the car
        g.setColor(Color.RED);
        g.fillRect(50 + car.getDistanceCovered(), 100, 50, 20);

        // Draw the bicycle
        g.setColor(Color.BLUE);
        g.fillRect(50 + bicycle.getDistanceCovered(), 200, 50, 20);

        // Draw the finish line
        g.setColor(Color.BLACK);
        g.drawLine(RACE_DISTANCE, 50, RACE_DISTANCE, 300);

        // Draw labels
        g.setColor(Color.BLACK);
        g.drawString("Car: " + car.getDistanceCovered() + " m", 50, 90);
        g.drawString("Bicycle: " + bicycle.getDistanceCovered() + " m", 50, 190);
    }

    // Action performed method to update the race
    @Override
    public void actionPerformed(ActionEvent e) {
        car.raceForOneSecond();
        bicycle.raceForOneSecond();
        repaint();

        if (car.getDistanceCovered() >= RACE_DISTANCE || bicycle.getDistanceCovered() >= RACE_DISTANCE) {
            timer.stop();
            if (car.getDistanceCovered() >= RACE_DISTANCE && bicycle.getDistanceCovered() >= RACE_DISTANCE) {
                JOptionPane.showMessageDialog(this, "It's a tie!");
            } else if (car.getDistanceCovered() >= RACE_DISTANCE) {
                JOptionPane.showMessageDialog(this, "The car wins!");
            } else {
                JOptionPane.showMessageDialog(this, "The bicycle wins!");
            }
        }
    }

    // Main method to run the game
    public static void main(String[] args) {
        JFrame frame = new JFrame("Race Game");
        RaceGame raceGame = new RaceGame();
        frame.add(raceGame);
        frame.setSize(1200, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
