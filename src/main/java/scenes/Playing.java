package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class Playing extends GameScene implements SceneMethods {

    /**
     * @Summary Takes the game class and sends it to GameScene to be stored.
     * @param game The game class
     */
    public Playing(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, 640, 640);
    }

}
