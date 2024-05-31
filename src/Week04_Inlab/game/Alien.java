package Week04_Inlab.game;

import java.util.Random;

public class Alien extends Sprite {
    private int dx;
    private static final Random random = new Random();

    public Alien(int x, int y) {
        super(x, y);
        initAlien();
    }

    private void initAlien() {
        loadImage("src/Week04_Inlab/images/alien.png", 40, 30); // Scaled image size
        dx = 1;
    }

    @Override
    public void move() {
        x += dx;

        if (x < 0) {
            dx = 1;
            y += height; // Move down when changing direction
        }

        if (x > 800 - width) { // Assuming the screen width is 800
            dx = -1;
            y += height; // Move down when changing direction
        }
    }

    public Shot shoot() {
        if (random.nextInt(100) < 5) { // 5% chance to shoot
            return new Shot(x + width / 2 - 2, y + height, true);
        }
        return null;
    }
}
