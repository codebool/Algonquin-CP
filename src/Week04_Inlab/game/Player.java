package Week04_Inlab.game;

import java.awt.event.KeyEvent;

public class Player extends Sprite {
    private int dx;

    public Player(int x, int y) {
        super(x, y);
        initPlayer();
    }

    private void initPlayer() {
        loadImage("src/Week04_Inlab/images/player.png", 50, 30); // Scaled image size
    }

    @Override
    public void move() {
        x += dx;
        if (x < 0) {
            x = 0;
        }
        if (x > 800 - width) { // Assuming the screen width is 800
            x = 800 - width;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public Shot shoot() {
        return new Shot(x + width / 2 - 2, y, false);
    }
}
