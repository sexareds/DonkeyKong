package map.tile;

import gfx.Sprite;
import gfx.Screen;

public abstract class Tile {
    public int x;
    public int y;
    public Sprite sprite;
    //Coleccion de cuadros
    public static final Tile PRUEBA_TILE = new Prueba(Sprite.PRUEBA);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {}

    public boolean isSolid() {
        return false;
    }
}
