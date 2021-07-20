package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

import controls.Keyboard;
import gfx.Screen;

public class Game extends Canvas implements Runnable {
    //referencia al mismo programa
    private static final long serialVersionUID = 1L;
    //Dimensiones de ventana
    private static final int WIDTH = 700;
    private static final int HEIGHT = WIDTH / 16 * 9;
    private static final String NAME = "Donko";
    private static int ups = 0;
    private static int fps = 0;
    private static int x = 0;
    private static int y = 0; 

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
    
    private static BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private static int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData(); 

    //Icono
    private static final ImageIcon icon = new ImageIcon(Game.class.getResource("/Donko.png"));

    //Constructor
    private Game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        screen = new Screen(WIDTH, HEIGHT);

        keyboard = new Keyboard();
        addKeyListener(keyboard);

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
        if (keyboard.up) {
            y += 2;
        }
        if (keyboard.down) {
            y -= 2;
        }
        if (keyboard.left) {
            x += 2;
        }
        if (keyboard.right) {
            x -= 2;
        }
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
        screen.renderer(x, y);
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
        Graphics g = strategy.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);  //dibuja la imagen
        g.setColor(Color.WHITE);
        g.fillRect(WIDTH / 2, HEIGHT / 2, 54, 54);
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
                frame.setTitle(NAME + " || UPS: " + ups + " || FPS: " + fps);
                ups = fps = 0;
                counter = System.nanoTime();
            }
        }
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
