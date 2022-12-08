package main;

import main.controllers.GameController;
import main.models.Character;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler implements KeyListener {
    final private Character character;
    private GameController gameController;
    public KeyEventHandler(GameController gameController, Character character){
        this.character = character;
        this.gameController = gameController;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            character.direction = "right";
            character.moving = true;
        }
        else if (key == KeyEvent.VK_LEFT) {
            character.direction = "left";
            character.moving = true;
        }
        else if (key == KeyEvent.VK_UP) {
            character.direction = "up";
            character.moving = true;
        }
        else if (key == KeyEvent.VK_DOWN) {
            character.direction = "down";
            character.moving = true;
        }
        else if(key == KeyEvent.VK_ESCAPE){
            System.out.println("pressed escape.");
            gameController.paused = !gameController.paused;
            gameController.stop();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            character.moving = false;
        }
        else if(key == KeyEvent.VK_LEFT){
            character.moving = false;
        }
        else if(key == KeyEvent.VK_UP){
            character.moving = false;
        }
        else if(key == KeyEvent.VK_DOWN){
            character.moving = false;
        }
    }
}
