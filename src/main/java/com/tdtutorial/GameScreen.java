package com.tdtutorial;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * @Summary GameScreen handles drawing to the window.
 */
public class GameScreen extends JPanel {

    private Random random;
    private transient BufferedImage img;

    private Dimension size;

    private transient ArrayList<BufferedImage> sprites = new ArrayList<>();

    /**
     * @Summary Constructor
     * @param img The image containing the sprites.
     */
    public GameScreen(BufferedImage img) {
        this.img = img;

        setPanelSize();

        loadSprites();

        random = new Random();
    }

    private void setPanelSize() {
        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    /**
     * @Summary Loads the sprites from the imported image into an ArrayList
     */
    private void loadSprites() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }

    /**
     * @Summary Draws a grid to the window using the sprites as squares
     */
    @Override
    public void paintComponent(Graphics g) {
        // calling superclass JPanel to do all of the graphic calc and drawing
        super.paintComponent(g);

        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                g.drawImage(sprites.get(getRndInt(100)), x * 32, y * 32, null);
            }
        }
    }

    /**
     * @Summary Generates a random int
     * @param x The upper limit
     * @return A randomly generated int
     */
    private int getRndInt(int x) {
        return random.nextInt(x);
    }
}
