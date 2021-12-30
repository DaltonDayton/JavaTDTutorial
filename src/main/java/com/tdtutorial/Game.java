package com.tdtutorial;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * @Summary The primary Game class
 */
public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;
    private transient BufferedImage img;

    private static final double FPS_SET = 120.0;
    private static final double UPS_SET = 60.0;

    /**
     * @Summary Constructor
     */
    public Game() {
        importImg();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // null should open in the center

        gameScreen = new GameScreen(img);
        add(gameScreen); // Add a JPanel to the JFrame
        pack(); // Let's the windowmanager set the size for us. Values given in the JPanel
        setVisible(true); // Must be at the end to display correctly
    }

    /**
     * @Summary Imports the sprite sheet
     */
    private void importImg() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("spriteatlas.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Summary Starts the game on its own thread
     */
    private void start() {
        Thread gameThread;
        gameThread = new Thread(this) {
        };

        gameThread.start();
    }

    /**
     * @brief Main
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    /**
     * @Summary Ensures the program runs at the same game speed regardless of setup
     */
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while (true) {
            now = System.nanoTime();

            // Render - repaint() as soon as time in timePerFrame has passed
            if (now - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }

            // Update - update as soon as time in timePerUpdate has passed
            if (now - lastUpdate >= timePerUpdate) {
                lastUpdate = now;
                updates++;
            }

            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
}
