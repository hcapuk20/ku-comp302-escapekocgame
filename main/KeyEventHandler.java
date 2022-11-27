package main;

import main.models.Character;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler implements KeyListener {
    final private Character character;
    public KeyEventHandler(Character character){
        this.character = character;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            character.stepX = character.speed;
            character.direction = "right";
            character.moving = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            character.stepX = -character.speed;
            character.direction = "left";
            character.moving = true;
        }
        if (key == KeyEvent.VK_UP) {
            character.stepY = -character.speed;
            character.direction = "up";
            character.moving = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            character.stepY = character.speed;
            character.direction = "down";
            character.moving = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            character.stepX = 0;
            character.moving = false;
        }
        if(key == KeyEvent.VK_LEFT){
            character.stepX = 0;
            character.moving = false;
        }
        if(key == KeyEvent.VK_UP){
            character.stepY = 0;
            character.moving = false;
        }
        if(key == KeyEvent.VK_DOWN){
            character.stepY = 0;
            character.moving = false;
        }
    }
}
