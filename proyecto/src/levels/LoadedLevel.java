package levels;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import levels.tile.Tile;

public class LoadedLevel extends Level {
    private int[] pixels;

    /**
     * Constructor de LoadedLevel
     * @param path
     */
    public LoadedLevel(String path) {
        super(path);
    }
    
    /**
     * Metodo heredado
     * 
     * Recibe una ruta que contiene el mapeado del nivel y guarda 
     * la informacion que este contiene
     */
    protected void loadLevel(final String PATH) {
        try {
            BufferedImage image = ImageIO.read(LoadedLevel.class.getResource(PATH));
            width = image.getWidth();
            height = image.getHeight();
            pixelTiles = new Tile[width * height];
            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda en pixelTiles cada uno de los tiles que conformaran
     * el nivel
     */
    protected void generateLevel() {
        for (int i = 0; i < pixels.length; i++) {
            switch (pixels[i]) {
                case 0xff000000: 
                    pixelTiles[i] = Tile.BLACK;
                    continue;
                case 0xffff0000:
                    pixelTiles[i] = Tile.VIGA_00;
                    continue;
                case 0xff267f00:
                    pixelTiles[i] = Tile.VIGA_01;
                    continue;
                case 0xff4800f:
                    pixelTiles[i] = Tile.VIGA_02;
                    continue;
                case 0xff007f7f:
                    pixelTiles[i] = Tile.VIGA_03;
                    continue;
                case 0xff4800ff:
                    pixelTiles[i] = Tile.VIGA_02;
                    continue;
                case 0xff7f3f3f:
                    pixelTiles[i] = Tile.VIGA_05;
                    continue;
                case 0xff00ff21:
                    pixelTiles[i] = Tile.VIGA_01_REVERSE;
                    continue;
                case 0xff0094ff:
                    pixelTiles[i] = Tile.VIGA_03_REVERSE;
                    continue;
                
                case 0xffff6a00:
                    pixelTiles[i] = Tile.VIGA_10;
                    continue;
                case 0xffff006e:
                    pixelTiles[i] = Tile.VIGA_12;
                    continue;
                case 0xff7f3300:
                    pixelTiles[i] = Tile.VIGA_10_REVERSE;
                    continue;                   

                case 0xffffd800:
                    pixelTiles[i] = Tile.VIGA_20;
                    continue;
                case 0xff007f0e:
                    pixelTiles[i] = Tile.VIGA_21;
                    continue;
                case 0xff7fff8e:
                    pixelTiles[i] = Tile.VIGA_22;
                    continue;
                case 0xff00137f:
                    pixelTiles[i] = Tile.VIGA_20_REVERSE;
                    continue;   

                case 0xff57007f:
                    pixelTiles[i] = Tile.VIGA_30;
                    continue;
                case 0xff7f6a00:
                    pixelTiles[i] = Tile.VIGA_31;
                    continue;
                case 0xffff00dc:
                    pixelTiles[i] = Tile.VIGA_32;
                    continue;
                case 0xffff7f7f:
                    pixelTiles[i] = Tile.VIGA_33;
                    continue;
                case 0xff7f0000:
                    pixelTiles[i] = Tile.VIGA_30_REVERSE;
                    continue;
                case 0xffb6ff00:
                    pixelTiles[i] = Tile.VIGA_31_REVERSE;
                    continue;

                case 0xff5B7F00: 
                    pixelTiles[i] = Tile.VIGA_40;
                    continue;
                case 0xff00ff90:
                    pixelTiles[i] = Tile.VIGA_42;
                    continue;
                case 0xff4cff00: 
                    pixelTiles[i] = Tile.VIGA_40_REVERSE;
                    continue;
                
                case 0xff7f006e:
                    pixelTiles[i] = Tile.VIGA_51;
                    continue;
                case 0xff007f46:
                    pixelTiles[i] = Tile.VIGA_52;
                    continue;
                case 0xff00FFFF:
                    pixelTiles[i] = Tile.VIGA_52_REVERSE;
                    continue;
                    

                case 0xff0026ff:
                    pixelTiles[i] = Tile.VIGA_60;
                    continue;
                case 0xff004a7f:
                    pixelTiles[i] = Tile.VIGA_60_REVERSE;
                    continue;

                case 0xffb200ff:
                    pixelTiles[i] = Tile.DOUBLE_STAIRS;
                    continue;
                default:
                    pixelTiles[i] = Tile.BLACK;
                    continue;
            }
        }
    }
}
