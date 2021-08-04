package gfx;

import entities.creatures.Player;
import levels.tile.Tile;

public final class Screen {
    private final int width;
    private final int height;
    public final int[] pixels;

    private int deltaX;
    private int deltaY;

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

    public void setDelta(final int deltaX, final int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderTile(int dx, int dy, Tile tile) {
        dx -= deltaX;
        dy -= deltaY;

        for (int y = 0; y < tile.sprite.getSide(); y++) {
            int posY = y + dy;
            for (int x = 0; x < tile.sprite.getSide(); x++) {
                int posX = x + dx;
                if (posX < -tile.sprite.getSide() || posX >= width || posY < 0 || posY >= height) {
                    break;
                }
                posX = (posX < 0)? 0 : posX;
                pixels[posX + posY * width] = tile.sprite.pixels[x + y * tile.sprite.getSide()];
            }
        }
    }

    public void renderPlayer(int dx, int dy, Player player) {
        dx -= deltaX;
        dy -= deltaY;

        for (int y = 0; y < player.getSprite().getSide(); y++) {
            int posY = y + dy;
            for (int x = 0; x < player.getSprite().getSide(); x++) {
                int posX = x + dx;
                if (posX < -player.getSprite().getSide() || posX >= width || posY < 0 || posY >= height) {
                    break;
                }
                posX = (posX < 0)? 0 : posX;
                int colorPixel = player.getSprite().pixels[x + y * player.getSprite().getSide()];
                if (colorPixel != 0xffff006e) {
                    pixels[posX + posY * width] = colorPixel;   
                }
                
            }
        }
    }
}
