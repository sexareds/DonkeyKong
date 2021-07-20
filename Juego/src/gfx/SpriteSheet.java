package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
    private final int WIDTH;
    private final int HEIGHT;
    public final int[] pixels;
    //Coleccion de hojas de sprites
    public static SpriteSheet level = new SpriteSheet("/Donko.png", 54, 54);
    //fin de la coleccion
    
    public SpriteSheet(final String PATH, final int WIDTH, final int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        pixels = new int[WIDTH * HEIGHT];
        BufferedImage image = null;
        try {
            image = ImageIO.read(SpriteSheet.class.getResource(PATH));
            image.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
