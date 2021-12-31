package scenes;

import main.Game;

/**
 * @Summary Super class for all game scenes.
 */
public class GameScene {
    private Game game;

    /**
     * @Summary Constructor
     * @param game The game class
     */
    public GameScene(Game game) {
        this.game = game;
    }

    /**
     * @Summary If we add child classes to the child classes and they need to get to
     *          the game class
     * @return
     */
    public Game getGame() {
        return game;
    }
}
