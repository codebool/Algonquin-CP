package Week05_Inclass.slotmachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SlotMachine extends JFrame {
    private Reel reel1;
    private Reel reel2;
    private Reel reel3;
    private JLabel statusLabel;
    private JButton spinButton;
    private int credits;
    private int numOfJackpots;

    public SlotMachine() {
        initUI();
    }

    private void initUI() {
        setTitle("Slot Machine Game");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        reel1 = new Reel();
        reel2 = new Reel();
        reel3 = new Reel();

        panel.add(reel1);
        panel.add(reel2);
        panel.add(reel3);

        statusLabel = new JLabel("Welcome! Press Spin to play.", SwingConstants.CENTER);
        panel.add(statusLabel);

        spinButton = new JButton("Spin");
        spinButton.addActionListener(new SpinButtonListener());
        panel.add(spinButton);

        credits = 10;
        updateStatus();

        add(panel);
    }

    private void updateStatus() {
        statusLabel.setText("Credits: " + credits);
    }

    private class SpinButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (credits <= 0) {
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                JLabel label = new JLabel("Out of credits! Game over.");
                JLabel label2 = new JLabel("Win: " + numOfJackpots);
                panel.add(label);
                panel.add(label2);

                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                for (int i = 0; i < numOfJackpots; i++) {
                    ImageIcon icon = new ImageIcon(new WinnerStar().getImage());
                    Image scaledImage = icon.getImage().getScaledInstance(14, 14, Image.SCALE_SMOOTH);
                    JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
                    panel.add(imageLabel);
                }

                JOptionPane.showMessageDialog(null, panel);
                //JOptionPane.showMessageDialog(null, "Out of credits! Game over.\n Jackpots: " + numOfJackpots);
                System.exit(0);
            }

            reel1.spin();
            reel2.spin();
            reel3.spin();

            credits--;

            if (reel1.getSymbol() == reel2.getSymbol() && reel2.getSymbol() == reel3.getSymbol()) {
                credits += 5;
                numOfJackpots++;
                statusLabel.setText("Jackpot! You win 5 credits.");
            } else {
                updateStatus();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SlotMachine ex = new SlotMachine();
            ex.setVisible(true);
        });
    }
}
