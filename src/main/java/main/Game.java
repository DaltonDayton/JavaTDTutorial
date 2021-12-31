package main;

import javax.swing.JFrame;

import inputs.KeyboardListener;
import inputs.MyMouseListener;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;

/**
 * @Summary The primary Game class
 */
public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;

    private static final double FPS_SET = 120.0;
    private static final double UPS_SET = 60.0;

    // Classes
    private transient Render render;
    private transient Menu menu;
    private transient Playing playing;
    private transient Settings settings;

    /**
     * @Summary Constructor
     */
    public Game() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // null should open in the center

        initClasses();

        add(gameScreen); // Add a JPanel to the JFrame
        pack(); // Let's the windowmanager set the size for us. Values given in the JPanel

        setVisible(true); // Must be at the end to display correctly
    }

    private void initClasses() {
        render = new Render(this);
        gameScreen = new GameScreen(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }

    /**
     * @Summary Initialize Inputs (Mouse/Keyboard)
     */
    private void initInputs() {
        MyMouseListener myMouseListener;
        KeyboardListener keyboardListener;

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

    // Getters and Setters
    public Render getRender() {
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Settings getSettings() {
        return settings;
    }
}
