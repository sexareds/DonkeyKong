package levels.tile;

import gfx.Sprite;
import gfx.Screen;

public class Tile {
    public int x;
    public int y;
    private boolean solid = false;
    public Sprite sprite;
    public static final int SIDE = 32;

    //Coleccion de cuadros
    public static final Tile BLACK = new Tile(Sprite.BLACK, true);

    public static final Tile VIGA_00 = new Tile(Sprite.VIGA_00);
    public static final Tile VIGA_01 = new Tile(Sprite.VIGA_01);
    public static final Tile VIGA_02 = new Tile(Sprite.VIGA_02);
    public static final Tile VIGA_03 = new Tile(Sprite.VIGA_03);
    public static final Tile VIGA_04 = new Tile(Sprite.VIGA_04);
    public static final Tile VIGA_05 = new Tile(Sprite.VIGA_05);
    public static final Tile VIGA_01_REVERSE = new Tile(Sprite.VIGA_01_REVERSE);
    public static final Tile VIGA_03_REVERSE = new Tile(Sprite.VIGA_03_REVERSE);

    public static final Tile VIGA_10 = new Tile(Sprite.VIGA_10, true);
    public static final Tile VIGA_12 = new Tile(Sprite.VIGA_12, true);
    public static final Tile VIGA_10_REVERSE = new Tile(Sprite.VIGA_10_REVERSE, true);

    public static final Tile VIGA_20 = new Tile(Sprite.VIGA_20, true);
    public static final Tile VIGA_21 = new Tile(Sprite.VIGA_21, true);
    public static final Tile VIGA_22 = new Tile(Sprite.VIGA_22, true);
    public static final Tile VIGA_20_REVERSE = new Tile(Sprite.VIGA_20_REVERSE, true);

    public static final Tile VIGA_30 = new Tile(Sprite.VIGA_30, true);
    public static final Tile VIGA_31 = new Tile(Sprite.VIGA_31, true);
    public static final Tile VIGA_32 = new Tile(Sprite.VIGA_32, true);
    public static final Tile VIGA_33 = new Tile(Sprite.VIGA_33, true);
    public static final Tile VIGA_30_REVERSE = new Tile(Sprite.VIGA_30_REVERSE, true);
    public static final Tile VIGA_31_REVERSE = new Tile(Sprite.VIGA_31_REVERSE, true);

    public static final Tile VIGA_40 = new Tile(Sprite.VIGA_40, true);
    public static final Tile VIGA_42 = new Tile(Sprite.VIGA_42, true);
    public static final Tile VIGA_40_REVERSE = new Tile(Sprite.VIGA_40_REVERSE, true);

    public static final Tile VIGA_51 = new Tile(Sprite.VIGA_51, true);
    public static final Tile VIGA_52 = new Tile(Sprite.VIGA_52, true);
    public static final Tile VIGA_52_REVERSE = new Tile(Sprite.VIGA_52_REVERSE, true);

    public static final Tile VIGA_60 = new Tile(Sprite.VIGA_60, true);
    public static final Tile VIGA_60_REVERSE= new Tile(Sprite.VIGA_60_REVERSE, true);

    public static final Tile DOUBLE_STAIRS = new Tile(Sprite.DOUBLE_STAIRS);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public Tile(Sprite sprite, boolean solid) {
        this.sprite = sprite;
        this.solid = solid;
    }

    public void render(int x, int y, Screen screen) {
        int powerLength = (int)(Math.log(sprite.getSide()) / Math.log(2));
        screen.renderTile(x << powerLength, y << powerLength, this); 
    }

    public boolean isSolid() {

        return solid;
    }
}
