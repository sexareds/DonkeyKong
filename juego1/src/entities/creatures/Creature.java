package entities.creatures;

import entities.Entity;
import gfx.Sprite;

public abstract class Creature extends Entity {
    protected Sprite sprite;
    protected char direction = 'n';
    protected boolean isMoving = false;

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void tick() {
    }

    public void render() {
    }

    public void move(int dx, int dy) {
        if (dx > 0) {
            direction = 'e';
        }
        if (dx < 0) {
            direction = 'w';
        }
        if (dy > 0) {
            direction = 's';
        }
        if (dy < 0) {
            direction = 'n';
        }

        setX(dx);
        setY(dy);

        /*if (!getIsDead()) {
            if (!isColliding(dx, 0)) {
                setX(dx);
            }
            if (!isColliding(0, dy)) {
                setY(dy);
            }
        }*/
    }

    private boolean isColliding(int dx, int dy) {
        boolean colliding = false;
        int posX = x + dx;
        int posY = y + dy;
        int leftMargin = -7;
        int rightMargin = 24;
        int topMargin = -10;
        int bottomMargin = 31;

        int leftEdge = (posX + rightMargin) / sprite.getSide();
        int rightEdge = (posX + rightMargin + leftMargin) / sprite.getSide();
        int topEdge = (posY + bottomMargin) / sprite.getSide();
        int bottomEdge = (posY + bottomMargin + topMargin) / sprite.getSide();

        if (level.getCatalogueOfTiles(leftEdge + topEdge * level.getWidth()).isSolid()) {
            colliding = true;
        }
        if (level.getCatalogueOfTiles(leftEdge + bottomEdge * level.getWidth()).isSolid()) {
            colliding = true;
        }
        if (level.getCatalogueOfTiles(rightEdge + topEdge * level.getWidth()).isSolid()) {
            colliding = true;
        }
        if (level.getCatalogueOfTiles(rightEdge + topEdge * level.getWidth()).isSolid()) {
            colliding = true;
        }
        return colliding;
    }
}
