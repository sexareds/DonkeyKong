package gfx;

public final class Sprite {
    //side del sprite
    private final int side;
    //Coordenadas  
    private int x;
    private int y;
    //Colores
    public int[] pixels;
    private final SpriteSheet sheet;
    //Coleccion de hojas de sprites
    public static final Sprite PRUEBA = new Sprite(54, 0, 0, SpriteSheet.level);
    //fin de la coleccion

    public Sprite(final int side, final int column, final int row, final SpriteSheet sheet) {
        this.side = side;
        this.pixels = new int[side * side];
        this.x = column * side;
        this.y = row * side;
        this.sheet = sheet;

        for (int y = 0; y < this.side; y++) {
            for (int x = 0; x < this.side; x++) {
                pixels[x + y * side] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.getWIDTH()];
            }
        }
    }

    public int getSide() {
        return side;
    }
}
