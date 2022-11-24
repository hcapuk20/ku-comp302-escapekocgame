package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler implements KeyListener {
    public boolean upPressed,downPressed,leftPressed,rightPressed;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(key == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(key == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(key == KeyEvent.VK_DOWN){
            downPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(key == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(key == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(key == KeyEvent.VK_DOWN){
            downPressed = false;
        }
    }
}
