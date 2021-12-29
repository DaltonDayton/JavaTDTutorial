package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GameScreen extends JPanel {

    private Random random;
    private transient BufferedImage img;

    private transient ArrayList<BufferedImage> sprites = new ArrayList<>();

    public GameScreen(BufferedImage img) {
        this.img = img;

        loadSprites();

        random = new Random();
    }

    private void loadSprites() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }

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

    private int getRndInt(int x) {
        return random.nextInt(x);
    }
}
