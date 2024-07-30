import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.io.*;
import org.json.*;

public class SnakeGame extends JPanel implements ActionListener {
    private final int GRID_SIZE = 30; // Size of each cell in the grid
    private final int WINDOW_SIZE = 850; // Total size of the game window
    private Timer timer; // Timer to control the game's refresh rate
    private List<Point> snake; // List of points representing the snake
    private Point food; // Point representing the food location
    private int direction; // Current direction of the snake's movement
    private boolean gameOver; // Flag to check if the game is over
    private boolean paused; // Flag to check if the game is paused
    private boolean showHighScores; // Flag to check if high scores should be displayed
    private int score; // Current score of the game
    private int scrollYPosition; // Y-coordinate for scrolling high scores
    private Map<String, Integer> highScores = new TreeMap<>(Collections.reverseOrder()); // High scores map, sorted in reverse order
    private Timer highScoreTimer; // Timer for scrolling high scores

    // Constructor to set up the game panel
    public SnakeGame() {
        setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE)); // Set the preferred size of the game panel
        setBackground(Color.BLACK); // Set the background color of the game panel
        setFocusable(true); // Make sure the panel can receive focus
        timer = new Timer(100, this); // Initialize the game timer with a delay of 100ms
        addKeyListener(new KeyAdapter() { // Add key listener to detect arrow key presses
            @Override
            public void keyPressed(KeyEvent e) {
                if (!paused) { // Only allow direction change if the game is not paused
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) direction = KeyEvent.VK_LEFT;
                    if (key == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) direction = KeyEvent.VK_RIGHT;
                    if (key == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) direction = KeyEvent.VK_UP;
                    if (key == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP) direction = KeyEvent.VK_DOWN;
                }
            }
        });
        initGame(); // Initialize the game
    }

    // Method to initialize or reset the game
    private void initGame() {
        snake = new ArrayList<>(); // Create a new list for the snake
        snake.add(new Point(GRID_SIZE / 2, GRID_SIZE / 2)); // Add the starting point of the snake to the center of the grid
        direction = KeyEvent.VK_RIGHT; // Set the initial direction of the snake to the right
        spawnFood(); // Spawn the initial food
        gameOver = false; // Set gameOver flag to false
        paused = false; // Unpause the game
        showHighScores = false; // Do not show high scores initially
        score = 0; // Reset the score
        loadHighScores(); // Load high scores from a file
        timer.start(); // Start the game timer
        if (highScoreTimer != null) {
            highScoreTimer.stop(); // Stop the high scores timer if it exists
        }
    }

    // Override the paintComponent method to draw the game or high scores
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (showHighScores) {
            displayHighScores(g); // Draw rolling high scores if flag is set
        } else {
            if (!gameOver) {
                drawObjects(g); // Draw the game objects if the game is not over
            } else {
                displayGameOver(g); // Display game over message
            }
        }
    }

    // Method to handle when the timer fires an action event (i.e., game updates)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver && !paused) {
            move(); // Move the snake if the game is not over nor paused
        }
        repaint(); // Refresh the screen
    }

    // Method to move the snake in the currently set direction
    private void move() {
        if (!paused) {
            Point head = new Point(snake.get(0)); // Get the current head of the snake
            switch (direction) { // Update the head position based on direction
                case KeyEvent.VK_LEFT -> head.x -= 1;
                case KeyEvent.VK_RIGHT -> head.x += 1;
                case KeyEvent.VK_UP -> head.y -= 1;
                case KeyEvent.VK_DOWN -> head.y += 1;
            }
            // Wrap around the screen if the snake crosses the boundary
            head = new Point((head.x + GRID_SIZE) % GRID_SIZE, (head.y + GRID_SIZE) % GRID_SIZE);

            if (head.equals(food)) { // Check if snake has collided with the food
                snake.add(0, head); // Add the new head to the snake, growing it
                score++; // Increment the score
                spawnFood(); // Spawn new food
            } else {
                snake.add(0, head); // Add new head to the snake
                snake.remove(snake.size() - 1); // Remove the last segment of the snake
            }

            for (int i = 1; i < snake.size(); i++) { // Check for collisions with itself
                if (head.equals(snake.get(i))) {
                    gameOver = true; // End the game if snake runs into itself
                    timer.stop(); // Stop the game timer
                    saveHighScores(); // Save the high scores
                    break;
                }
            }
        }
    }

    // Method to draw the snake and food
    private void drawObjects(Graphics g) {
        g.setColor(Color.RED); // Set color for food
        g.fillRect(food.x * GRID_SIZE, food.y * GRID_SIZE, GRID_SIZE, GRID_SIZE); // Draw the food
        g.setColor(Color.GREEN); // Set color for snake
        for (Point p : snake) { // Draw each segment of the snake
            g.fillRect(p.x * GRID_SIZE, p.y * GRID_SIZE, GRID_SIZE, GRID_SIZE);
        }
    }

    // Method to display the game over message
    private void displayGameOver(Graphics g) {
        String msg = "Game Over";
        Font font = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metrics = getFontMetrics(font);
        g.setColor(Color.RED); // Set color for game over message
        g.setFont(font); // Set font
        g.drawString(msg, (WINDOW_SIZE - metrics.stringWidth(msg)) / 2, WINDOW_SIZE / 2); // Draw message centered
    }

    // Method to display rolling high scores
    private void displayHighScores(Graphics g) {
        String msg = "High Scores";
        Font font = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metrics = getFontMetrics(font);
        g.setColor(Color.WHITE); // Set color for high scores
        g.setFont(font); // Set font
        g.drawString(msg, (WINDOW_SIZE - metrics.stringWidth(msg)) / 2, 50); // Draw high scores title

        int y = scrollYPosition; // Set the starting Y position for the rolling effect
        for (Map.Entry<String, Integer> entry : highScores.entrySet()) { // Draw each high score entry
            g.drawString(entry.getKey() + ": " + entry.getValue(), WINDOW_SIZE / 4, y);
            y += 30; // Increment Y position for the next entry
        }
    }

    // Method to scroll the high scores down the screen
    private void scrollHighScores() {
        scrollYPosition -= 2; // Update Y position to create rolling effect
        if (scrollYPosition + highScores.size() * 30 < 0) { // Reset position if all scores have rolled off
            scrollYPosition = WINDOW_SIZE;
        }
        repaint(); // Refresh the screen to redraw the high scores at new position
    }

    // Method to spawn food at a random position that is not occupied by the snake
    private void spawnFood() {
        do {
            int x = (int) (Math.random() * GRID_SIZE);
            int y = (int) (Math.random() * GRID_SIZE);
            food = new Point(x, y);
        } while (snake.contains(food)); // Ensure food is not spawned on the snake
    }

    // Method to load high scores from a JSON file
    private void loadHighScores() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("highscores.json")));
            JSONObject jsonObject = new JSONObject(content);
            for (String key : jsonObject.keySet()) {
                highScores.put(key, jsonObject.getInt(key)); // Populate high scores map
            }
        } catch (IOException | JSONException ex) {
            System.out.println("Could not load high scores.");
        }
    }

    // Method to save high scores to a JSON file
    private void saveHighScores() {
        try {
            String name = JOptionPane.showInputDialog(this, "Game Over! Enter your name:");
            if (name != null && !name.trim().isEmpty()) {
                highScores.put(name, score); // Add new high score
                JSONObject jsonObject = new JSONObject(highScores);
                try (FileWriter file = new FileWriter("highscores.json")) {
                    file.write(jsonObject.toString()); // Save to file
                }
            }
        } catch (IOException ex) {
            System.out.println("Could not save high scores.");
        }
    }

    // Method to start a new game
    public void startNewGame() {
        showHighScores = false; // Ensure high scores are not displayed
        if (highScoreTimer != null) {
            highScoreTimer.stop(); // Stop the high scores timer if it exists
        }
        initGame();
    }

    // Method to restart the current game
    public void restartGame() {
        if (gameOver) {
            initGame(); // Start a new game if the previous one was over
        } else {
            direction = KeyEvent.VK_RIGHT; // Reset direction
            populateSnake();
            spawnFood();
            gameOver = false; // Reset game over flag
            paused = false; // Unpause the game
            score = 0; // Reset the score
            timer.restart(); // Restart the game timer
        }
    }

    // Method to pause or resume the game
    public void pauseGame() {
        paused = !paused; // Toggle the paused state
    }

    // Method to show rolling high scores
    public void showHighScores() {
        paused = true; // Pause the game
        showHighScores = true; // Set flag to show high scores
        scrollYPosition = WINDOW_SIZE; // Set initial scroll position
        if (highScoreTimer != null) {
            highScoreTimer.stop(); // Stop any existing high score timer
        }
        highScoreTimer = new Timer(30, e -> scrollHighScores()); // Create a new timer for rolling effect
        highScoreTimer.start(); // Start the high scores timer
    }

    // Method to reset the snake to its starting position
    private void populateSnake() {
        snake.clear(); // Clear the current snake
        snake.add(new Point(GRID_SIZE / 2, GRID_SIZE / 2)); // Add the starting point of the snake
    }

    // Main method to start the game
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame gamePanel = new SnakeGame(); // Create the game panel

        JMenuBar menuBar = new JMenuBar(); // Create the menu bar
        JMenu gameMenu = new JMenu("Game"); // Create the game menu

        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        JMenuItem restartMenuItem = new JMenuItem("Restart");
        JMenuItem pauseMenuItem = new JMenuItem("Pause/Resume");
        JMenuItem highScoresMenuItem = new JMenuItem("High Scores");

        // Add action listeners to menu items
        newGameMenuItem.addActionListener(e -> gamePanel.startNewGame());
        restartMenuItem.addActionListener(e -> gamePanel.restartGame());
        pauseMenuItem.addActionListener(e -> gamePanel.pauseGame());
        highScoresMenuItem.addActionListener(e -> gamePanel.showHighScores());

        // Add menu items to the game menu
        gameMenu.add(newGameMenuItem);
        gameMenu.add(restartMenuItem);
        gameMenu.add(pauseMenuItem);
        gameMenu.add(highScoresMenuItem);

        // Add the game menu to the menu bar
        menuBar.add(gameMenu);
        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Add the game panel to the frame
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
        frame.pack(); // Pack the frame to fit the preferred size of the panel
        frame.setVisible(true); // Make the frame visible
    }
}