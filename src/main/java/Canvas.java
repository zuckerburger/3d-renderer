package src.main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {
    private BufferedImage canvasImage;

    // Constructor: width and height of the canvas
    public Canvas(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    // Method to set a pixel color
    public void putPixel(int x, int y, Color color) {
        if (x >= 0 && x < canvasImage.getWidth() && y >= 0 && y < canvasImage.getHeight()) {
            canvasImage.setRGB(x, y, color.getRGB());
            repaint();
        }
    }

    // Override paintComponent to draw the BufferedImage
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvasImage, 0, 0, null);
    }

    // Main method for testing
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pixel Canvas");
        Canvas canvas = new Canvas(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

        // Example: draw some pixels
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                canvas.putPixel(100 + i, 100 + j, Color.RED);
            }
        }
    }
}
