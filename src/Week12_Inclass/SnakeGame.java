/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-30
 * Modified: 2024-07-30
 * Description: Lab assignment
 */

package Week12_Inclass;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import org.json.*;

public class SnakeGame extends JPanel implements ActionListener {
    private final int GRID_SIZE = 20;
    private final int WINDOW_SIZE = 400;
    private Timer timer;
    private List<Point> snake;
    private Point food;
    private int direction;
    private boolean gameOver;
    private boolean paused;
    private boolean showHighScores;
    private int score;
    private int scrollYPosition;
    private Map<String, Integer> highScores = new TreeMap<>(Collections.reverseOrder());
    private Timer highScoreTimer;

    public SnakeGame() {
        setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        timer = new Timer(100, this);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(!paused) {
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) {
                        direction = KeyEvent.VK_LEFT;
                    }
                    if (key == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) {
                        direction = KeyEvent.VK_RIGHT;
                    }
                    if (key == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) {
                        direction = KeyEvent.VK_UP;
                    }
                    if (key == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP) {
                        direction = KeyEvent.VK_DOWN;
                    }
                }
            }
        });

        initGame();
    }

    private void initGame() {
        snake = new ArrayList<>();
        snake.add(new Point(GRID_SIZE / 2, GRID_SIZE / 2));
        direction = KeyEvent.VK_RIGHT;
        spawnFood();
        gameOver = false;
        paused = false;
        showHighScores = false;
        score = 0;
        loadHighScores();
        timer.start();
        if (highScoreTimer != null) {
            highScoreTimer.stop();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (showHighScores) {
            displayHighScores(g);
        } else {
            if (!gameOver) {
                drawObjects(g);
            } else {
                displayGameOver(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver && !paused) {
            move();
        }
        repaint();
    }

    private void move() {
        if (!paused) {
            Point head = new Point(snake.get(0));
            switch (direction) {
                case KeyEvent.VK_LEFT -> head.x--;
                case KeyEvent.VK_RIGHT -> head.x++;
                case KeyEvent.VK_UP -> head.y--;
                case KeyEvent.VK_DOWN -> head.y++;
            }
            head = new Point((head.x + GRID_SIZE) % GRID_SIZE, (head.y + GRID_SIZE) % GRID_SIZE);

            if (head.equals(food)) {
                snake.add(0, head);
                spawnFood();
                score++;
            } else {
                snake.add(0, head);
                snake.remove(snake.size() - 1);
            }

            // Check if the snake has collided with itself
            for (int i = 1; i < snake.size(); i++) {
                if (head.equals(snake.get(i))) {
                    gameOver = true;
                    timer.stop();
                    saveHighScore();
                    break;
                }
            }
        }
    }

    private void drawObjects(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(food.x * GRID_SIZE, food.y * GRID_SIZE, GRID_SIZE, GRID_SIZE);
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x * GRID_SIZE, p.y * GRID_SIZE, GRID_SIZE, GRID_SIZE);
        }
    }

    private void displayGameOver(Graphics g) {
        String msg = "Game Over";
        Font font = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metrics = getFontMetrics(font);
        g.setColor(Color.RED);
        g.setFont(font);
        g.drawString(msg, (WINDOW_SIZE - metrics.stringWidth(msg)) / 2, WINDOW_SIZE / 2);
    }

    private void displayHighScores(Graphics g) {
        String msg = "High Scores";
        Font font = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metrics = getFontMetrics(font);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(msg, (WINDOW_SIZE - metrics.stringWidth(msg)) / 2, 50);
        int y = scrollYPosition;
        for (Map.Entry<String, Integer> entry : highScores.entrySet()) {
            g.drawString(entry.getKey() + ": " + entry.getValue(), WINDOW_SIZE / 4, y);
            y += 30; // Increase the y position for the next high score
        }
    }

    // Spawn food at a random location that is not occupied by the snake
    private void scrollHighScores() {
        scrollYPosition -= 2; // Scroll the high scores up by 2 pixels
        if (scrollYPosition + highScores.size() * 30 < 0) {
            scrollYPosition = WINDOW_SIZE;
        }
        repaint(); // Repaint the panel to show the updated high scores
    }

    private void spawnFood() {
        Random rand = new Random();
        do {
            int x = (int) (Math.random() * GRID_SIZE);
            int y = (int) (Math.random() * GRID_SIZE);
            food = new Point(x, y);
        } while (snake.contains(food));
    }

    private void loadHighScores() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("highscores.json")));
            JSONObject jsonObject = new JSONObject(content);
            for (String key : jsonObject.keySet()) {
                highScores.put(key, jsonObject.getInt(key));
            }
        } catch (IOException | JSONException ex) {
            System.out.println("Could not load high scores.");
        }
    }

    private void saveHighScore() {
        try {
            String name = JOptionPane.showInputDialog(this, "Game Over! Enter your name:");
            if (name != null && !name.trim().isEmpty()) {
                highScores.put(name, score);
                JSONObject jsonObject = new JSONObject(highScores);
                try (FileWriter file = new FileWriter("highscores.json")) {
                    file.write(jsonObject.toString());
                }
            }
        } catch (IOException ex) {
            System.out.println("Could not save high scores.");
        }
    }

    public void startNewGame() {
        showHighScores = false;
        if(highScoreTimer != null) {
            highScoreTimer.stop();
        }
        initGame();
    }

    public void restartGame() {
        if (gameOver) {
            initGame();
        } else {
            direction = KeyEvent.VK_RIGHT;
            popuateSnake();
            spawnFood();
            gameOver = false;
            paused = false;
            score = 0;
            timer.start();
        }
    }

    public void pauseGame() {
        paused = !paused;
    }

    public void showHighScores() {
        paused = true;
        showHighScores = true;
        scrollYPosition = WINDOW_SIZE;
        if (highScoreTimer != null) {
            highScoreTimer.stop();
        }
        highScoreTimer = new Timer(30, e -> scrollHighScores());
        highScoreTimer.start();
    }

    private void popuateSnake() {
        snake.clear();
        snake.add(new Point(GRID_SIZE / 2, GRID_SIZE / 2));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame gamePanel = new SnakeGame();

        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");

        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        JMenuItem restartMenuItem = new JMenuItem("Restart");
        JMenuItem pauseMenuItem = new JMenuItem("Pause/Resume");
        JMenuItem highScoreMenuItem = new JMenuItem("High Scores");

        newGameMenuItem.addActionListener(e -> gamePanel.startNewGame());
        restartMenuItem.addActionListener(e -> gamePanel.restartGame());
        pauseMenuItem.addActionListener(e -> gamePanel.pauseGame());
        highScoreMenuItem.addActionListener(e -> gamePanel.showHighScores());

        gameMenu.add(newGameMenuItem);
        gameMenu.add(restartMenuItem);
        gameMenu.add(pauseMenuItem);
        gameMenu.add(highScoreMenuItem);

        menuBar.add(gameMenu);
        frame.setJMenuBar(menuBar);

        frame.add(gamePanel);
        frame.pack(); // Resize the frame to fit the panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
