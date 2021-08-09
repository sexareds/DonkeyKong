package levels.tile;

import gfx.Sprite;
import gfx.Screen;
import java.awt.Graphics2D;

public class Tile {
    public Sprite sprite;
    public static final int SIDE = 32;

    //Coleccion de cuadros
    public static final Tile BLACK = new Tile(Sprite.BLACK);

    public static final Tile VIGA_00 = new Tile(Sprite.VIGA_00);
    public static final Tile VIGA_01 = new Tile(Sprite.VIGA_01);
    public static final Tile VIGA_02 = new Tile(Sprite.VIGA_02);
    public static final Tile VIGA_03 = new Tile(Sprite.VIGA_03);
    public static final Tile VIGA_04 = new Tile(Sprite.VIGA_04);
    public static final Tile VIGA_05 = new Tile(Sprite.VIGA_05);
    public static final Tile VIGA_01_REVERSE = new Tile(Sprite.VIGA_01_REVERSE);
    public static final Tile VIGA_03_REVERSE = new Tile(Sprite.VIGA_03_REVERSE);

    public static final Tile VIGA_10 = new Tile(Sprite.VIGA_10);
    public static final Tile VIGA_12 = new Tile(Sprite.VIGA_12);
    public static final Tile VIGA_10_REVERSE = new Tile(Sprite.VIGA_10_REVERSE);

    public static final Tile VIGA_20 = new Tile(Sprite.VIGA_20);
    public static final Tile VIGA_21 = new Tile(Sprite.VIGA_21);
    public static final Tile VIGA_22 = new Tile(Sprite.VIGA_22);
    public static final Tile VIGA_20_REVERSE = new Tile(Sprite.VIGA_20_REVERSE);

    public static final Tile VIGA_30 = new Tile(Sprite.VIGA_30);
    public static final Tile VIGA_31 = new Tile(Sprite.VIGA_31);
    public static final Tile VIGA_32 = new Tile(Sprite.VIGA_32);
    public static final Tile VIGA_33 = new Tile(Sprite.VIGA_33);
    public static final Tile VIGA_30_REVERSE = new Tile(Sprite.VIGA_30_REVERSE);
    public static final Tile VIGA_31_REVERSE = new Tile(Sprite.VIGA_31_REVERSE);

    public static final Tile VIGA_40 = new Tile(Sprite.VIGA_40);
    public static final Tile VIGA_42 = new Tile(Sprite.VIGA_42);
    public static final Tile VIGA_40_REVERSE = new Tile(Sprite.VIGA_40_REVERSE);

    public static final Tile VIGA_51 = new Tile(Sprite.VIGA_51);
    public static final Tile VIGA_52 = new Tile(Sprite.VIGA_52);
    public static final Tile VIGA_52_REVERSE = new Tile(Sprite.VIGA_52_REVERSE);

    public static final Tile VIGA_60 = new Tile(Sprite.VIGA_60);
    public static final Tile VIGA_60_REVERSE= new Tile(Sprite.VIGA_60_REVERSE);

    public static final Tile DOUBLE_STAIRS = new Tile(Sprite.DOUBLE_STAIRS);


    /**
     * Constructor de Tile
     * @param sprite
     */
    public Tile(final Sprite sprite) {
        this.sprite = sprite;
    }
    
    /**
     * Metodo para renderizar el tile
     * @param x
     * @param y
     * @param screen
     * @param g2d
     */
    public void render(int x, int y, Screen screen, Graphics2D g2d) {
        int powerLength = (int)(Math.log(sprite.getSide()) / Math.log(2));
        int x0 = x << powerLength;
        int y0 = y << powerLength;
        screen.renderTile(x0, y0, this, g2d); 
    }
}
