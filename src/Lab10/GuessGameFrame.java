/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-08-04
 * Modified: 2024-07-31
 * Description: Lab assignment 10
 */

package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// GuessGameFrame class
public class GuessGameFrame extends JFrame {
    private static Random generator = new Random();
    private int number;
    private int guessCount;
    private int lastDistance;
    private JTextField guessInputJTextField;
    private JLabel prompt1JLabel;
    private JLabel prompt2JLabel;
    private JLabel messageJLabel;
    private JButton newGameJButton;
    private Color background;

    public GuessGameFrame() {
        // call the JFrame constructor and pass the title of the window
        super("Guessing Game");

        newGameJButton = new JButton("New Game"); // create New Game button
        guessCount = 0;
        background = Color.LIGHT_GRAY;
        prompt1JLabel = new JLabel("I have a number between 1 and 1000.");
        prompt2JLabel = new JLabel("Can you guess my number? Enter your Guess:");

        guessInputJTextField = new JTextField(5); // 5 columns wide
        guessInputJTextField.addActionListener(new GuessHandler());
        messageJLabel = new JLabel("Guess result appears here.");

        newGameJButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        /* Write code that resets the application to an appropriate state
                        to start a new game. Reset the background color to light gray,
                        set the JTextFields to their initial text, call method
                        theGame and repaint the GuessGame JFrame */
                        background = Color.LIGHT_GRAY;
                        guessInputJTextField.setText("");
                        guessCount = 0;
                        messageJLabel.setText("Guess result appears here.");
                        theGame();
                    }
                }
        );
        /* Write code that will set the layout of the container to a Flowlayout,
        then add all the GUI components to the container */
        setLayout(new FlowLayout());
        this.add(prompt1JLabel);
        this.add(prompt2JLabel);
        this.add(guessInputJTextField);
        this.add(messageJLabel);
        this.add(newGameJButton);

        theGame();
    }

    public void theGame() {
        number = generator.nextInt(1000) + 1; // random number between 1 and 1000
        System.out.print(number);
    }

    public void paint(Graphics g) {
        super.paint(g);
        getContentPane().setBackground(background);
    }

    public void react(int guess) {
        guessCount++;
        /* Write code that sets instance variable currentDistance to 1000. This
        variable’s value will be used to determine if the background color
        should be set to red or blue to indicate that the last guess was getting
        closer to or further from the actual number. */
        int currentDistance = 1000;
        if (guessCount == 1) {
            int lastDistance = Math.abs(guess - number);
            if (guess > number) {
                messageJLabel.setText("Too High. Try a lower number.");
            } else if (guess < number) {
                messageJLabel.setText("Too Low. Try a higher number.");
            } else {
                messageJLabel.setText("Correct!");
            }
        } else {
            currentDistance = Math.abs(guess - number);
            if (guess > number) {
                messageJLabel.setText("Too High. Try a lower number.");
                background = (currentDistance <= lastDistance) ? Color.RED : Color.BLUE;
                lastDistance = currentDistance;
            } else if (guess < number) {
                messageJLabel.setText("Too Low. Try a higher number.");
                background = (currentDistance <= lastDistance) ? Color.RED : Color.BLUE;
                lastDistance = currentDistance;
            } else {
                messageJLabel.setText("Correct!");
                background = Color.LIGHT_GRAY;
            }
            paint(getGraphics());
        }
    }

    // inner class for event handling
    class GuessHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int guess = Integer.parseInt(guessInputJTextField.getText());
            react(guess);
        }
    }
}



