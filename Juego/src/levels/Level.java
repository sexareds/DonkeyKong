package levels;

import gfx.Screen;
import levels.tile.Tile;

public abstract class Level {
    protected int width;
    protected int height;
    protected int[] tiles;
    protected Tile[] catalogueOfTiles;

    //Nivel aleatorio
    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    //Nivel cargado desde una ruta
    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }

    protected void loadLevel(String path) {
    }
 
    protected void generateLevel() {
    }

    public void tick() {
    }

    public void render(final int dx, final int dy, final Screen screen) {
        screen.setDelta(dx, dy);
        int n = dy >> 5;
        int s = (dy + screen.getHeight() + Tile.SIDE) >> 5;
        int w = dx >> 5; 
        int e = (dx + screen.getWidth() + Tile.SIDE) >> 5;

        for (int y = n; y < s; y++) {
            for (int x = w; x < e; x++) {
                getTile(x, y).render(x, y, screen);
                /*if (x < 0 || y < 0 || x >= width || y >= height) {
                    Tile.BLACK.render(x, y, screen);
                    continue;
                }
                catalogueOfTiles[x + y * width].render(x, y, screen);*/
            }
        }
    }

    public Tile getTile(final int x, final int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.BLACK; 
        }
        switch (tiles[x + y * width]) {
            case 0: return Tile.BLACK;
            case 1: return Tile.PRUEBA;

            default: return Tile.BLACK;
        }
    }
}
