import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class FractalZoom extends JPanel implements MouseWheelListener, MouseListener, MouseMotionListener {
    private double zoomFactor = 200; // Initial zoom factor
    private double panX = 0; // Initial X offset for panning
    private double panY = 0; // Initial Y offset for panning
    private int maxIterations = 300; // Maximum number of iterations for Mandelbrot calculation
    private Point mousePoint; // Position of the mouse for centered zoom

    // Constructor to set up the panel
    public FractalZoom() {
        setPreferredSize(new Dimension(800, 800)); // Set preferred size for the fractal window
        setBackground(Color.BLACK); // Set background color to black
        addMouseWheelListener(this); // Add mouse wheel listener for zooming
        addMouseListener(this); // Add mouse listener for panning
        addMouseMotionListener(this); // Add mouse motion listener for mouse movement
    }

    // Overrides the paintComponent method to draw the fractal
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Use Graphics2D for better rendering

        // Create an off-screen image to draw the fractal
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                // Map pixel coordinates to the fractal coordinate system
                double zx = (x - getWidth() / 2.0) / zoomFactor + panX;
                double zy = (y - getHeight() / 2.0) / zoomFactor + panY;

                // Mandelbrot iteration calculation
                float i = mandelbrot(zx, zy);

                // Determine the color for the current pixel
                Color color = Color.getHSBColor(i / maxIterations, 1, i > 0 ? 1 : 0);
                image.setRGB(x, y, color.getRGB());
            }
        }

        // Draw the off-screen image onto the panel
        g2d.drawImage(image, 0, 0, null);
    }

    // Calculates the number of iterations for Mandelbrot set
    private float mandelbrot(double zx, double zy) {
        float iter = 0;
        double cX = zx;
        double cY = zy;
        while (zx * zx + zy * zy < 4 && iter < maxIterations) {
            double tmp = zx * zx - zy * zy + cX;
            zy = 2.0 * zx * zy + cY;
            zx = tmp;
            iter++;
        }
        return iter;
    }

    // Handles zooming with the mouse wheel
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        double scale = (e.getWheelRotation() < 0) ? 1.1 : 0.9; // Determine whether to zoom in or out

        // Calculate new panX and panY to keep the zoom centered on the mouse pointer
        panX = (panX - (e.getX() - getWidth() / 2.0) / zoomFactor) * scale + (e.getX() - getWidth() / 2.0) / (zoomFactor * scale);
        panY = (panY - (e.getY() - getHeight() / 2.0) / zoomFactor) * scale + (e.getY() - getHeight() / 2.0) / (zoomFactor * scale);

        zoomFactor *= scale; // Update the zoom factor
        repaint(); // Repaint the fractal with the new zoom factor
    }

    // Adjust the panning (offset) based on mouse click and drag position
    @Override
    public void mouseClicked(MouseEvent e) {
        // Adjust the panX and panY based on mouse click position
        panX += (e.getX() - getWidth() / 2.0) / zoomFactor;
        panY += (e.getY() - getHeight() / 2.0) / zoomFactor;
        repaint(); // Repaint the fractal with the new panning
    }

    // Handle mouse press for panning
    @Override
    public void mousePressed(MouseEvent e) {
        mousePoint = e.getPoint(); // Store the initial mouse point
    }

    // Handle mouse drag for panning
    @Override
    public void mouseDragged(MouseEvent e) {
        // Calculate the difference in movement and update panX and panY
        double deltaX = (e.getX() - mousePoint.getX()) / zoomFactor;
        double deltaY = (e.getY() - mousePoint.getY()) / zoomFactor;
        panX -= deltaX;
        panY -= deltaY;
        mousePoint = e.getPoint(); // Update the current mouse point
        repaint(); // Repaint the fractal with the new pan offsets
    }

    // Main method to set up the frame and add the fractal panel
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot Fractal Zoom");
        FractalZoom fractalPanel = new FractalZoom();
        frame.add(fractalPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {} // Unused but required by MouseListener
    @Override
    public void mouseEntered(MouseEvent e) {} // Unused but required by MouseListener
    @Override
    public void mouseExited(MouseEvent e) {} // Unused but required by MouseListener
    @Override
    public void mouseMoved(MouseEvent e) {} // Unused but required by MouseMotionListener
}