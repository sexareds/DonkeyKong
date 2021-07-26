package levels.tile;

import gfx.Sprite;
import gfx.Screen;

public abstract class Tile {
    public int x;
    public int y;
    public Sprite sprite;
    public static final int SIDE = 32;

    //Coleccion de cuadros
    public static final Tile BLACK = new BlackTile(Sprite.BLACK);
    public static final Tile PRUEBA = new Prueba(Sprite.PRUEBA);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
        int powerLength = (int)(Math.log(sprite.getSide()) / Math.log(2));
        screen.renderTile(x << powerLength, y << powerLength, this); 
    }

    public boolean isSolid() {
        return false;
    }
}
