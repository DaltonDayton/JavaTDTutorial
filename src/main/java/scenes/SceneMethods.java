package scenes;

import java.awt.Graphics;

/**
 * @Summary An interface to ensure methods needed in all scenes are implemented.
 *          Will show an error in classes implementing this if they're missing
 *          any of the methods here.
 */
public interface SceneMethods {
    public void render(Graphics g);
}
