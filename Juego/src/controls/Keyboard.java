package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Keyboard implements KeyListener {
    private final static int keysAvailable = 120;
    private final boolean[] keys = new boolean[keysAvailable];
    //Controles
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;

    public void tick() {
        this.up = keys[KeyEvent.VK_W];
        this.down = keys[KeyEvent.VK_S];
        this.left = keys[KeyEvent.VK_A];
        this.right = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
}
