package entities;

import levels.Level;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity {
    protected int x;
    protected int y;

    protected boolean isDead = false;
    protected boolean falling = false;
    protected boolean jumping = true;

    public static final int GRAVITY = 1;
    public static final int MAX_SPEED = 3;

    protected Level level;

    /**
     * Setter de x
     * @param dx
     */
    public void setX(int dx) {
        this.x += dx;
    }

    /**
     * Getter de x
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Setter de y
     * @param dy
     */
    public void setY(int dy) {
        this.y += dy;
    }

    /**
     * Getter de y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter de isDead
     */
    public void setIsDead() {
        isDead = true;
    }

    /**
     * Getter de isDead
     * @return isDead
     */
    public boolean getIsDead() {
        return isDead;
    }

    /**
     * Setter de falling
     * @param falling
     */
    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public void tick() {
    }

    public void render() {
    }

    // Colisiones
    public void paint(Graphics2D g2d) {
    }

    public Rectangle getBounds() {
        return null;
    }
}
