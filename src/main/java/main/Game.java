package main;

import javax.swing.JFrame;
import inputs.KeyboardListener;
import inputs.MyMouseListener;

/**
 * @Summary The primary Game class
 */
public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;

    private static final double FPS_SET = 120.0;
    private static final double UPS_SET = 60.0;

    private transient MyMouseListener myMouseListener;
    private transient KeyboardListener keyboardListener;

    /**
     * @Summary Constructor
     */
    public Game() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // null should open in the center

        gameScreen = new GameScreen(this);
        add(gameScreen); // Add a JPanel to the JFrame
        pack(); // Let's the windowmanager set the size for us. Values given in the JPanel
        setVisible(true); // Must be at the end to display correctly
    }

    /**
     * @Summary Initialize Inputs (Mouse/Keyboard)
     */
    private void initInputs() {
        myMouseListener = new MyMouseListener();
        keyboardListener = new KeyboardListener();

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);

        requestFocus(); // get focus on this particular component (Jframe)
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
        game.initInputs();
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
