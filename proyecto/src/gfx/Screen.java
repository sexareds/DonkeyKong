package gfx;

import entities.creatures.Player;
import levels.tile.Tile;
import java.awt.Graphics2D;

public final class Screen {
    private final int width;
    private final int height;
    public final int[] pixels;

    private int deltaX;
    private int deltaY;

    /**
     * Constructor Screen
     * @param width
     * @param height
     */
    public Screen(final int width, final int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    /**
     * Getter de ancho (width)
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter de alto (height)
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter de deltaX y deltaY
     * @param deltaX
     * @param deltaY
     */
    public void setDelta(final int deltaX, final int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
    
    /**
     * Limpia la pantalla 
     */
    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    /**
     * Metodo para renderizar los tiles del escenario o nivel
     * @param dx
     * @param dy
     * @param tile
     * @param g2d
     */
    public void renderTile(int dx, int dy, Tile tile, Graphics2D g2d) {
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

    /**
     * Metodo para renderizar los tiles del jugador
     * @param dx
     * @param dy
     * @param player
     * @param g2d
     */
    public void renderPlayer(int dx, int dy, Player player, Graphics2D g2d) {
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
                g2d.draw(player.getBounds());
            }
        }
    }
}
