package Week04_Inlab.game;

public class Shot extends Sprite {
    private final int BOARD_HEIGHT = 600;
    private final int SHOT_SPEED = 4;
    private boolean isAlienShot;

    public Shot(int x, int y, boolean isAlienShot) {
        super(x, y);
        this.isAlienShot = isAlienShot;
        initShot();
    }

    private void initShot() {
        loadImage("src/Week04_Inlab/images/shot.png", 5, 10); // Scaled image size
    }

    @Override
    public void move() {
        if (isAlienShot) {
            y += SHOT_SPEED;
        } else {
            y -= SHOT_SPEED;
        }
        if (y < 0 || y > BOARD_HEIGHT) {
            visible = false;
        }
    }

    public boolean isAlienShot() {
        return isAlienShot;
    }
}
