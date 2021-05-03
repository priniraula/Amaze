//Game class

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String title;

    public boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States

    private State gameState;

    //Input

    private KeyManager keyManager;

    //Camera

    private GameCamera gameCamera;

    //Handler

    private Handler handler;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init(){
        display = new Display(title, width, height);
        Assets.init();

        gameCamera = new GameCamera(this, 0,0);
        handler = new Handler(this);

        display.getFrame().addKeyListener(keyManager);
        gameState = new GameState(handler);
        State.setState(gameState);
    }

    private void tick(){

        keyManager.tick();

        if(State.getState() != null)
            State.getState().tick();

    }

    private void render(){

        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0,0, width, height);
        //Start

        if(State.getState() != null)
            State.getState().render(g);


        //Finish
        bs.show();
        g.dispose();

    }

    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    //Getters and Setters

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
