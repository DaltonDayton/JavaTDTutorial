package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameScreen extends JPanel {
    public GameScreen() {
        // Constructor
    }

    public void paintComponent(Graphics g) {
        // calling superclass JPanel to do all of the graphic calc and drawing
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillRect(50, 50, 100, 100);
    }
}
