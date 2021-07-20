package gfx;

import map.tile.Tile;

public final class Screen {
    private final int width;
    private final int height;
    public final int[] pixels;
    //temporal
    private final static int SIDE_SPRITE = 54;
    private final static int MASK_SPRITE = SIDE_SPRITE - 1;

    public Screen(final int width, final int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderer(final int dx, final int dy) {
        for (int y = 0; y < height; y++) {
            int posY = y + dy;
            if (posY < 0 || posY >= height) continue;
            for (int x = 0; x < width; x++) {
                int posX = x + dx;
                if (posX < 0 || posX >= width) continue;
                //redibujado temporal
                pixels[posX + posY * width] = Sprite.PRUEBA.pixels[(x & MASK_SPRITE) + (y & MASK_SPRITE) * SIDE_SPRITE]; 
            }
        }
    }

    public void renderTile(int dx, int dy, Tile tile) {
        for (int y = 0; y < tile.sprite.getSide(); y++) {
            int posY = y + dy;
            for (int x = 0; x < tile.sprite.getSide(); x++) {
                int posX = x + dx;
                if (posX < 0 || posX > width || posY < 0 || posY > height) {
                    break;
                }
                pixels[posX + posY * width] = tile.sprite.pixels[x + y * tile.sprite.getSide()];
            }
        }
    }
}
