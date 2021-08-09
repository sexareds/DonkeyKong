package entities.creatures;

import controls.Keyboard;
import gfx.Screen;
import gfx.Sprite;
import levels.Level;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Creature {
    private Keyboard keyboard;
    private int animation;
    
    /**
     * Constructor de Player
     * @param level
     * @param keyboard
     * @param sprite
     */
    public Player(Level level, Keyboard keyboard, Sprite sprite) {
        this.level = level;
        this.keyboard = keyboard;
        this.sprite = sprite;
    }

    /**
     * Constructor de player para una posicion especificada
     * @param level
     * @param keyboard
     * @param sprite
     * @param x
     * @param y
     */
    public Player(Level level, Keyboard keyboard, Sprite sprite, int x, int y) {
        this(level, keyboard, sprite);
        this.x = x;
        this.y = y;
    }

    /**
     * Metodo heredado.
     * 
     * Se encarga de los movimientos y animaciones
     */
    public void tick() {
        int dx = 0;
        int dy = 0;

        if (animation < Integer.MAX_VALUE) {
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

    /**
     * Metodo que renderiza al jugador para mostrarlo en pantalla
     * @param screen
     * @param g2d
     */
    public void render(Screen screen, Graphics2D g2d) {
        screen.renderPlayer(x, y, this, g2d);
    }

	public void paint(Graphics2D g) {
        g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
