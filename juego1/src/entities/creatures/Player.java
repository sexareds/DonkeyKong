package entities.creatures;

import controls.Keyboard;
import gfx.Screen;
import gfx.Sprite;
import levels.Level;

public class Player extends Creature {
    private Keyboard keyboard;
    private int animation;
    
    public Player(Level level, Keyboard keyboard, Sprite sprite) {
        this.level = level;
        this.keyboard = keyboard;
        this.sprite = sprite;
    }

    public Player(Level level, Keyboard keyboard, Sprite sprite, int x, int y) {
        this(level, keyboard, sprite);
        this.x = x;
        this.y = y;
    }

    public void tick() {
        int dx = 0, dy = 0;

        if (animation < 32767) {
            animation++;
        } else {
            animation = 0; 
        }

        if (keyboard.up) {
            dy--;
        }
        if (keyboard.down) {
            dy++;
        }
        if (keyboard.left) {
            dx--;
        }
        if (keyboard.right) {
            dx++;
        }
        if (keyboard.exit) {
            System.exit(0);
        }

        if (dx != 0 || dy != 0) {
            move(dx, dy);
            isMoving = true;
        } else {
            isMoving = false;
        }

        if (direction == 'n' || direction == 's') {
            sprite = Sprite.MARIO_20;
            if (isMoving) {
                int r = animation % 20;
                if (r > 10) {
                    sprite = Sprite.MARIO_20;
                } else {
                    sprite = Sprite.MARIO_21;
                }
            }
        }
        if (direction == 'w') {
            sprite = Sprite.MARIO_00;
            if (isMoving) {
                int r = animation % 40;
                if (r > 10 && r <= 20) {
                    sprite = Sprite.MARIO_01;
                } else if (r > 30) {
                    sprite = Sprite.MARIO_02;
                } else {
                    sprite = Sprite.MARIO_03;
                }
            }
        }
        if (direction == 'e') {
            sprite = Sprite.MARIO_00_REVERSE;
            if (isMoving) {
                int r = animation % 40;
                if (r > 10 && r <= 20) {
                    sprite = Sprite.MARIO_01_REVERSE;
                } else if (r > 30) {
                    sprite = Sprite.MARIO_02_REVERSE;
                } else {
                    sprite = Sprite.MARIO_03_REVERSE;
                }
            }
        }
    }

    public void render(Screen screen) {
        screen.renderPlayer(x, y, this);
    }
}
