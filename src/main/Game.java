package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.imageio.ImageIO;

public class Game extends JFrame {

    private GameScreen gameScreen;

    private BufferedImage img;

    // Constructor
    public Game() {

        importImg();

        setSize(700, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // null opens in the center

        gameScreen = new GameScreen(img);
        add(gameScreen); // Add a JPanel to the JFrame
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/res/spriteatlas.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}
