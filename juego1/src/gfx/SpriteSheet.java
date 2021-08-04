package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
    private final int width;
    private final int height;
    public final int[] pixels;
    //Coleccion de hojas de sprites
    public static SpriteSheet MARIO = new SpriteSheet("/mario.png", 320, 320);
    public static SpriteSheet LEVEL_1 = new SpriteSheet("/plataforma.png", 320, 320);
    //fin de la coleccion
    
    public SpriteSheet(final String PATH, final int width, final int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        BufferedImage image;
        try {
            image = ImageIO.read(SpriteSheet.class.getResource(PATH));
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
