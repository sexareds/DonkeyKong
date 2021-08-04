package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controls.Keyboard;
import entities.creatures.Player;
import gfx.Screen;
import gfx.Sprite;
import levels.Level;
import levels.LoadedLevel;

public class Game extends Canvas implements Runnable {
    //referencia al mismo programa
    private static final long serialVersionUID = 1L;
    //Dimensiones de ventana
    private static final int WIDTH = 256;
    private static final int HEIGHT = 288;
    private static final int SCALE = 1;
    private static final String NAME = "DONKO: AyPIII";
    private static String counterUPS = "";
    private static String counterFPS = "";
    private static int ups = 0;
    private static int fps = 0;

    //Esta corriendo
    private static volatile boolean running = false;
    //crear ventana
    private static JFrame frame;
    //Hilos
    private static Thread thread;
    //Teclado
    private static Keyboard keyboard;
    //Pantalla
    private static Screen screen;
    //Mapa
    private static Level level;
    //Jugador
    private static Player player;
    
    private static BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private static int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData(); 

    //Icono
    private static final ImageIcon icon = new ImageIcon(Game.class.getResource("/Donko.png"));

    //Constructor
    private Game() {
        setPreferredSize(new Dimension(WIDTH << SCALE, HEIGHT << SCALE));

        screen = new Screen(WIDTH, HEIGHT);

        keyboard = new Keyboard();
        addKeyListener(keyboard);

        level = new LoadedLevel("/nivelado1.png");
        player = new Player(level, keyboard, Sprite.MARIO_00_REVERSE, 36, 215);

        frame = new JFrame(NAME);
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Metodo para iniciar el juego
    private synchronized void start() {
        running = true;
        thread = new Thread(this, "gfx");
        thread.start();
    }

    //Metodo para detener el juego
    private synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Updates
    private void tick() {
        keyboard.tick();
        player.tick();
        ups++;
    }

    //Frames update
    private void render() {
        BufferStrategy strategy = getBufferStrategy();

        if (strategy == null) {
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        level.render(player.getX() - (screen.getWidth() - player.getSprite().getSide()) / 2, player.getY() - (screen.getWidth() - player.getSprite().getSide()) / 2, screen);
        player.render(screen);
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
        Graphics g = strategy.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);  //dibuja la imagen
        g.setColor(Color.WHITE);
        g.drawString(counterUPS, 10, 20);
        g.drawString(counterFPS, 10, 35);
        g.drawString("X: " + player.getX(), 10, 55);
        g.drawString("Y: " + player.getY(), 10, 70);
        g.dispose();   //elimina
        strategy.show();   //muestra strategy con la imagen
        fps++;
    }

    @Override
    public void run() {
        final int NS_PER_SECOND = 1000000000;
        final byte TICKS_PER_SECOND = 60;
        final double NS_PER_TICK = NS_PER_SECOND / TICKS_PER_SECOND;

        long lastTime = System.nanoTime();
        long counter = System.nanoTime();
        double lastTimer, delta = 0;

        requestFocus();
        
        while (running) {
            final long now = System.nanoTime();
            lastTimer = now - lastTime;
            lastTime = now;
            delta += lastTimer / NS_PER_TICK;

            while (delta >= 1) {
                tick();
                delta--; 
            }
            render();
            if (System.nanoTime() - counter > NS_PER_SECOND) {
                counterUPS = "UPS: " + ups;
                counterFPS = "FPS: " + fps;
                ups = fps = 0;
                counter = System.nanoTime();
            }
        }
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
