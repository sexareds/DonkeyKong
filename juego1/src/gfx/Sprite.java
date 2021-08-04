package gfx;

public final class Sprite {
    //side del sprite
    private final int side;
    //Coordenadas  
    private int x;
    private int y;
    //Colores
    public int[] pixels;  //representa el sprite
    private SpriteSheet sheet;

    //Coleccion de sprites de Mario
    public static final Sprite MARIO_00 = new Sprite(32, 0, 0, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_01 = new Sprite(32, 0, 1, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_02 = new Sprite(32, 0, 2, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_03 = new Sprite(32, 0, 3, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_00_REVERSE = new Sprite(32, 0, 0, 1, SpriteSheet.MARIO);
    public static final Sprite MARIO_01_REVERSE = new Sprite(32, 0, 1, 1, SpriteSheet.MARIO);
    public static final Sprite MARIO_02_REVERSE = new Sprite(32, 0, 2, 1, SpriteSheet.MARIO);
    public static final Sprite MARIO_03_REVERSE = new Sprite(32, 0, 3, 1, SpriteSheet.MARIO);

    public static final Sprite MARIO_10 = new Sprite(32, 1, 0, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_11 = new Sprite(32, 1, 1, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_10_REVERSE = new Sprite(32, 1, 0, 1, SpriteSheet.MARIO);
    public static final Sprite MARIO_11_REVERSE = new Sprite(32, 1, 1, 1, SpriteSheet.MARIO);

    public static final Sprite MARIO_20 = new Sprite(32, 2, 0, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_21 = new Sprite(32, 2, 1, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_22 = new Sprite(32, 2, 2, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_23 = new Sprite(32, 2, 3, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_24 = new Sprite(32, 2, 4, 0, SpriteSheet.MARIO);

    public static final Sprite MARIO_30 = new Sprite(32, 3, 0, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_31 = new Sprite(32, 3, 1, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_32 = new Sprite(32, 3, 1, 0, SpriteSheet.MARIO);
    public static final Sprite MARIO_30_REVERSE = new Sprite(32, 3, 0, 1, SpriteSheet.MARIO);
    public static final Sprite MARIO_31_REVERSE = new Sprite(32, 3, 1, 1, SpriteSheet.MARIO);
    //Fin


    //Coleccion de sprites del nivel 1
    public static final Sprite BLACK = new Sprite(32, 0);

    public static final Sprite VIGA_00 = new Sprite(32, 0, 0, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_01 = new Sprite(32, 0, 1, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_02 = new Sprite(32, 0, 2, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_03 = new Sprite(32, 0, 3, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_04 = new Sprite(32, 0, 4, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_05 = new Sprite(32, 0, 5, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_01_REVERSE = new Sprite(32, 0, 1, 1, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_03_REVERSE = new Sprite(32, 0, 3, 1, SpriteSheet.LEVEL_1);

    public static final Sprite VIGA_10 = new Sprite(32, 1, 0, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_12 = new Sprite(32, 1, 2, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_10_REVERSE = new Sprite(32, 1, 0, 1, SpriteSheet.LEVEL_1);

    public static final Sprite VIGA_20 = new Sprite(32, 2, 0, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_21 = new Sprite(32, 2, 1, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_22 = new Sprite(32, 2, 2, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_20_REVERSE = new Sprite(32, 2, 0, 1, SpriteSheet.LEVEL_1);

    public static final Sprite VIGA_30 = new Sprite(32, 3, 0, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_31 = new Sprite(32, 3, 1, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_32 = new Sprite(32, 3, 2, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_33 = new Sprite(32, 3, 3, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_30_REVERSE = new Sprite(32, 3, 0, 1, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_31_REVERSE = new Sprite(32, 3, 1, 1, SpriteSheet.LEVEL_1);

    public static final Sprite VIGA_40 = new Sprite(32, 4, 0, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_42 = new Sprite(32, 4, 2, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_40_REVERSE = new Sprite(32, 4, 0, 1, SpriteSheet.LEVEL_1);

    public static final Sprite VIGA_50 = new Sprite(32, 5, 0, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_51 = new Sprite(32, 6, 1, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_52 = new Sprite(32, 5, 2, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_52_REVERSE = new Sprite(32, 5, 2, 1, SpriteSheet.LEVEL_1);

    public static final Sprite VIGA_60 = new Sprite(32, 6, 0, 0, SpriteSheet.LEVEL_1);
    public static final Sprite VIGA_60_REVERSE = new Sprite(32, 6, 0, 1, SpriteSheet.LEVEL_1);

    public static final Sprite DOUBLE_STAIRS = new Sprite(32, 7, 0, 0, SpriteSheet.LEVEL_1);
    //fin de la coleccion
 
    public Sprite(final int side, final int column, final int row, final int type, final SpriteSheet sheet) {
        this.side = side; 
        this.pixels = new int[side * side];
        this.x = column * side;
        this.y = row * side;
        this.sheet = sheet; 
        loadSprite(type);
    } 

    public int getSide() {
        return side;
    }

    public Sprite(final int side, final int color) {
        this.side = side;
        pixels = new int[side * side];

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    private void loadSprite(int type) {
        if (type == 0) {
            normal();
        } else {
            rotarX();
        }
    }

    private void normal() {
        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                pixels[x + y * side] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.getWidth()];
            }
        }
    }

    private void rotarX() {
        int[] temp = initPixels();
        int i = 0;

        for (int y = 0; y < side; y++) {
            for (int x = side - 1; x >= 0; x--) {
                pixels[i++] = temp[x + y * side];
            }
        }
    }

    private int[] initPixels() {
        int[] temp = new int[side * side];

        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                temp[x + y * side] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.getWidth()];
            }
        }
        return temp;
    }
}
