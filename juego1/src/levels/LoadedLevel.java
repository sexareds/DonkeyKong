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
    
    protected void loadLevel(final String PATH) {
        try {
            BufferedImage image = ImageIO.read(LoadedLevel.class.getResource(PATH));
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
                case 0xff000000: 
                    catalogueOfTiles[i] = Tile.BLACK;
                    continue;
                case 0xffff0000:
                    catalogueOfTiles[i] = Tile.VIGA_00;
                    continue;
                case 0xff267f00:
                    catalogueOfTiles[i] = Tile.VIGA_01;
                    continue;
                case 0xff4800f:
                    catalogueOfTiles[i] = Tile.VIGA_02;
                    continue;
                case 0xff007f7f:
                    catalogueOfTiles[i] = Tile.VIGA_03;
                    continue;
                case 0xff4800ff:
                    catalogueOfTiles[i] = Tile.VIGA_02;
                    continue;
                case 0xff7f3f3f:
                    catalogueOfTiles[i] = Tile.VIGA_05;
                    continue;
                case 0xff00ff21:
                    catalogueOfTiles[i] = Tile.VIGA_01_REVERSE;
                    continue;
                case 0xff0094ff:
                    catalogueOfTiles[i] = Tile.VIGA_03_REVERSE;
                    continue;
                
                case 0xffff6a00:
                    catalogueOfTiles[i] = Tile.VIGA_10;
                    continue;
                case 0xffff006e:
                    catalogueOfTiles[i] = Tile.VIGA_12;
                    continue;
                case 0xff7f3300:
                    catalogueOfTiles[i] = Tile.VIGA_10_REVERSE;
                    continue;                   

                case 0xffffd800:
                    catalogueOfTiles[i] = Tile.VIGA_20;
                    continue;
                case 0xff007f0e:
                    catalogueOfTiles[i] = Tile.VIGA_21;
                    continue;
                case 0xff7fff8e:
                    catalogueOfTiles[i] = Tile.VIGA_22;
                    continue;
                case 0xff00137f:
                    catalogueOfTiles[i] = Tile.VIGA_20_REVERSE;
                    continue;   

                case 0xff57007f:
                    catalogueOfTiles[i] = Tile.VIGA_30;
                    continue;
                case 0xff7f6a00:
                    catalogueOfTiles[i] = Tile.VIGA_31;
                    continue;
                case 0xffff00dc:
                    catalogueOfTiles[i] = Tile.VIGA_32;
                    continue;
                case 0xffff7f7f:
                    catalogueOfTiles[i] = Tile.VIGA_33;
                    continue;
                case 0xff7f0000:
                    catalogueOfTiles[i] = Tile.VIGA_30_REVERSE;
                    continue;
                case 0xffb6ff00:
                    catalogueOfTiles[i] = Tile.VIGA_31_REVERSE;
                    continue;

                case 0xff5B7F00: 
                    catalogueOfTiles[i] = Tile.VIGA_40;
                    continue;
                case 0xff00ff90:
                    catalogueOfTiles[i] = Tile.VIGA_42;
                    continue;
                case 0xff4cff00: 
                    catalogueOfTiles[i] = Tile.VIGA_40_REVERSE;
                    continue;
                
                case 0xff7f006e:
                    catalogueOfTiles[i] = Tile.VIGA_51;
                    continue;
                case 0xff007f46:
                    catalogueOfTiles[i] = Tile.VIGA_52;
                    continue;
                case 0xff00FFFF:
                    catalogueOfTiles[i] = Tile.VIGA_52_REVERSE;
                    continue;
                    

                case 0xff0026ff:
                    catalogueOfTiles[i] = Tile.VIGA_60;
                    continue;
                case 0xff004a7f:
                    catalogueOfTiles[i] = Tile.VIGA_60_REVERSE;
                    continue;

                case 0xffb200ff:
                    catalogueOfTiles[i] = Tile.DOUBLE_STAIRS;
                    continue;
                default:
                    catalogueOfTiles[i] = Tile.BLACK;
                    continue;
            }
        }
    }
}
