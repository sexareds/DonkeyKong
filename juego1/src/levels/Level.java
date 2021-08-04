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

    public int getWidth() {
        return width;
    }

    public Tile getCatalogueOfTiles(int position) {
        return catalogueOfTiles[position];
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
                //getTile(x, y).render(x, y, screen);
                if (x < 0 || y < 0 || x >= width || y >= height) {
                    Tile.BLACK.render(x, y, screen);
                    continue;
                }
                catalogueOfTiles[x + y * width].render(x, y, screen);
            }
        }
    }

    /*public Tile getTile(final int x, final int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.BLACK; 
        }
        switch (tiles[x + y * width]) {
            case 0: return Tile.VIGA_00;
            case 1: return Tile.VIGA_01;
            case 2: return Tile.VIGA_02;
            case 3: return Tile.VIGA_03;
            case 4: return Tile.VIGA_04;
            case 5: return Tile.VIGA_05;
            case 6: return Tile.VIGA_10;
            case 7: return Tile.VIGA_12;
            case 8: return Tile.VIGA_20;
            case 9: return Tile.VIGA_21;
            case 10: return Tile.VIGA_22;
            case 11: return Tile.VIGA_30;
            case 12: return Tile.VIGA_31;
            case 13: return Tile.VIGA_32;
            case 14: return Tile.VIGA_33;
            case 15: return Tile.VIGA_40;
            case 16: return Tile.VIGA_42;
            case 17: return Tile.VIGA_50;
            case 18: return Tile.VIGA_52;
            case 19: return Tile.VIGA_60;
            case 20: return Tile.VIGA_61;
            case 21: return Tile.DOUBLE_STAIRS;
            default: return Tile.BLACK;
        }
    }*/
}
