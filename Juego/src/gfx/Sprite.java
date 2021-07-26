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
    //Coleccion de sprites
    public static final Sprite BLACK = new Sprite(32, 0);
    public static final Sprite PRUEBA = new Sprite(32, 0, 0, SpriteSheet.PRUEBA);
    //fin de la coleccion
 
    public Sprite(final int side, final int column, final int row, final SpriteSheet sheet) {
        this.side = side; 
        this.pixels = new int[side * side];
        this.x = column * side;
        this.y = row * side;
        this.sheet = sheet; 

        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                pixels[x + y * side] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.getWidth()];
            }
        }
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
}
