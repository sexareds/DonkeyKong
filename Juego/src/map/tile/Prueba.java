package map.tile;

import gfx.Sprite;
import gfx.Screen;

public class Prueba extends Tile {
    public Prueba(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x, y, this);
    }
} 
