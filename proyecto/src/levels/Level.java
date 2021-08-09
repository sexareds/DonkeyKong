package levels;

import gfx.Screen;
import levels.tile.Tile;
import java.awt.Graphics2D;

public abstract class Level {
    protected int width;
    protected int height;
    public Tile[] pixelTiles;

    /**
     * Constructor del nivel 
     * @param path
     */
    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }

    /**
     * getter de ancho (width)
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter para un tile en una posicion especificada del arreglo
     * @param position
     * @return pixelTiles[position]
     */
    public Tile getPixelTiles(int position) {
        return pixelTiles[position];
    }

    protected void loadLevel(String path) {
    }
 
    protected void generateLevel() {
    }

    public void tick() {
    }

    /**
     * Recorre el arreglo de Tiles y lo renderiza
     * @param dx
     * @param dy
     * @param screen
     * @param g
     */
    public void render(final int dx, final int dy, final Screen screen, Graphics2D g) {
        screen.setDelta(dx, dy);
        int n = dy >> 5;
        int s = (dy + screen.getHeight() + Tile.SIDE) >> 5;
        int w = dx >> 5; 
        int e = (dx + screen.getWidth() + Tile.SIDE) >> 5;

        for (int y = n; y < s; y++) {
            for (int x = w; x < e; x++) {
                if (x < 0 || y < 0 || x >= width || y >= height) {
                    continue;
                }
                pixelTiles[x + y * width].render(x, y, screen, g);
            }
        }
    }
}
