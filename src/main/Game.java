package main;

import javax.swing.JFrame;

public class Game extends JFrame {

    private GameScreen gameScreen;

    // Constructor
    public Game() {
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // null opens in the center
        gameScreen = new GameScreen();
        add(gameScreen); // Add a JPanel to the JFrame
    }

    public static void main(String[] args) {
        System.out.println("Start of my TD Tutorial. Hello there.");

        Game game = new Game();
    }
}
