package Week04_Inlab.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JPanel implements ActionListener {
    private Timer timer;
    private Player player;
    private List<Alien> aliens;
    private List<Shot> shots;
    private final int DELAY = 10;
    private boolean inGame;
    private boolean gameOver;
    private boolean stageCompleted;
    private int score;
    private int stage;
    private int alienSpeed;
    private final Random random = new Random();

    public Game() {
        initGame();
    }

    private void initGame() {
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(false);

        player = new Player(400, 550);
        aliens = new ArrayList<>();
        shots = new ArrayList<>();
        inGame = true;
        gameOver = false;
        stageCompleted = false;
        score = 0;
        stage = 1;
        alienSpeed = 1;

        initAliens();

        addKeyListener(new TAdapter());

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initAliens() {
        for (int i = 0; i < 5 + stage; i++) { // Increase the number of aliens with each stage
            for (int j = 0; j < 3 + stage / 2; j++) { // Increase the rows of aliens with each stage
                Alien alien = new Alien(50 + i * 60, 50 + j * 40);
                alien.setVisible(true);
                aliens.add(alien);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (inGame) {
            drawObjects(g);
            drawScore(g);
            drawStage(g);
        } else if (gameOver) {
            drawGameOver(g);
        } else if (stageCompleted) {
            drawStageCompleted(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {
        if (player.isVisible()) {
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }

        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }

        for (Shot shot : shots) {
            if (shot.isVisible()) {
                g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
            }
        }
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.BOLD, 14));
        g.drawString("Score: " + score, 10, 20);
    }

    private void drawStage(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.BOLD, 14));
        g.drawString("Stage: " + stage, 700, 20);
    }

    private void drawGameOver(Graphics g) {
        String message = "Game Over";
        String scoreMessage = "Score: " + score;
        String restartMessage = "Press R to Restart";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(message, (800 - fm.stringWidth(message)) / 2, 300);
        g.drawString(scoreMessage, (800 - fm.stringWidth(scoreMessage)) / 2, 330);
        g.drawString(restartMessage, (800 - fm.stringWidth(restartMessage)) / 2, 360);
    }

    private void drawStageCompleted(Graphics g) {
        String message = "Stage Completed";
        String continueMessage = "Press C to Continue";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(message, (800 - fm.stringWidth(message)) / 2, 300);
        g.drawString(continueMessage, (800 - fm.stringWidth(continueMessage)) / 2, 330);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            inGame();

            updatePlayer();
            updateAliens();
            updateShots();
            checkCollisions();

            if (aliens.stream().noneMatch(Alien::isVisible)) {
                inGame = false;
                stageCompleted = true;
            }

            repaint();
        }
    }

    private void inGame() {
        if (!player.isVisible() || aliens.stream().anyMatch(a -> a.getY() > 550)) {
            inGame = false;
            gameOver = true;
        }
    }

    private void updatePlayer() {
        player.move();
    }

    private void updateAliens() {
        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                alien.move();
                if (stage > 1) {
                    Shot shot = alien.shoot();
                    if (shot != null) {
                        shots.add(shot);
                    }
                }
            }
        }
    }

    private void updateShots() {
        List<Shot> toRemove = new ArrayList<>();
        for (Shot shot : shots) {
            if (shot.isVisible()) {
                shot.move();
            } else {
                toRemove.add(shot);
            }
        }
        shots.removeAll(toRemove);
    }

    private void checkCollisions() {
        Rectangle playerRect = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());

        for (Shot shot : shots) {
            Rectangle shotRect = new Rectangle(shot.getX(), shot.getY(), shot.getWidth(), shot.getHeight());

            if (shot.isAlienShot() && shotRect.intersects(playerRect)) {
                player.setVisible(false);
                shot.setVisible(false);
                inGame = false;
                gameOver = true;
            }

            for (Alien alien : aliens) {
                Rectangle alienRect = new Rectangle(alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight());

                if (!shot.isAlienShot() && shotRect.intersects(alienRect) && alien.isVisible() && shot.isVisible()) {
                    shot.setVisible(false);
                    alien.setVisible(false);
                    score += 10;
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (!inGame && gameOver && e.getKeyCode() == KeyEvent.VK_R) {
                restartGame();
            } else if (!inGame && stageCompleted && e.getKeyCode() == KeyEvent.VK_C) {
                nextStage();
            } else if (inGame) {
                player.keyPressed(e);

                int key = e.getKeyCode();
                if (key == KeyEvent.VK_SPACE) {
                    shots.add(player.shoot());
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (inGame) {
                player.keyReleased(e);
            }
        }
    }

    private void restartGame() {
        player = new Player(400, 550);
        aliens.clear();
        shots.clear();
        inGame = true;
        gameOver = false;
        stageCompleted = false;
        score = 0;
        stage = 1;
        alienSpeed = 1;
        initAliens();
        timer.start();
    }

    private void nextStage() {
        player = new Player(400, 550);
        aliens.clear();
        shots.clear();
        inGame = true;
        stageCompleted = false;
        stage++;
        alienSpeed++;
        initAliens();
        timer.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Space Invaders");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Game());
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
