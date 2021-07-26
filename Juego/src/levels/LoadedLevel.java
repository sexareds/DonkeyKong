package levels;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import levels.tile.Tile;

public class LoadedLevel extends Level {
    private int[] pixels;

    public LoadedLevel(String path) {
        super(path);
    }
    
    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(LoadedLevel.class.getResource(""));
            width = image.getWidth();
            height = image.getHeight();
            catalogueOfTiles = new Tile[width * height];
            pixels = new int[width * height];

            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void generateLevel() {
        for (int i = 0; i < pixels.length; i++) {
            switch (pixels[i]) {
                // TODO llenar con los sprites en la spritesheet
                case 0: 

                    break;
            
                default:
                    catalogueOfTiles[i] = Tile.BLACK;
                    break;
            }
        }
    }
}
