package entities;

import levels.Level;

public abstract class Entity {
    protected int x;
    protected int y;

    private boolean isDead = false;

    protected Level level;

    public void setX(int dx) {
        this.x += dx;
    }

    public int getX() {
        return x;
    }

    public void setY(int dy) {
        this.y += dy;
    }

    public int getY() {
        return y;
    }

    public void setIsDead() {
        isDead = true;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void tick() {
    }

    public void render() {
    }
}
