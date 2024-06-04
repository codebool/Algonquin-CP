package Week05_Inclass.slotmachine;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Reel extends JPanel {
    private static final Symbol[] SYMBOLS = {
            new Cherry(),
            new Lemon(),
            new Orange()
    };
    private Symbol symbol;
    private Random random;

    public Reel() {
        random = new Random();
        spin();
        setPreferredSize(new Dimension(66, 66));
    }

    public void spin() {
        symbol = SYMBOLS[random.nextInt(SYMBOLS.length)];
        repaint();
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (symbol != null) {
            g.drawImage(symbol.getImage(), 0, 0, this);
        }
    }
}
