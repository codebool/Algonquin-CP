/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-08-04
 * Modified: 2024-07-31
 * Description: Lab assignment 10
 */

package Lab10;

import javax.swing.JFrame;

public class GuessGame {
    public static void main(String args[]) {
        GuessGameFrame guessGameFrame = new GuessGameFrame();
        guessGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessGameFrame.setSize(300, 150); // set frame size
        guessGameFrame.setVisible(true); // display frame
    } // end main
}
