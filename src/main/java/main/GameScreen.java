package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @Summary GameScreen handles drawing to the window.
 */
public class GameScreen extends JPanel {

    private Game game;
    private Dimension size;

    /**
     * @Summary Constructor
     * @param game asdf
     */
    public GameScreen(Game game) {
        this.game = game;

        setPanelSize();
    }

    private void setPanelSize() {
        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    /**
     * @Summary Draws a grid to the window using the sprites as squares
     */
    @Override
    public void paintComponent(Graphics g) {
        // calling superclass JPanel to do all of the graphic calc and drawing
        super.paintComponent(g);

        game.getRender().render(g);
    }
}
