package main;

import main.models.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler implements KeyListener {
    final private Player player;
    public KeyEventHandler(Player player){
        this.player = player;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            player.stepX = player.speed;
        }
        if (key == KeyEvent.VK_LEFT) {
            player.stepX = -player.speed;
        }
        if (key == KeyEvent.VK_UP) {
            player.stepY = -player.speed;
        }
        if (key == KeyEvent.VK_DOWN) {
            player.stepY = player.speed;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            player.stepX = 0;
        }
        if(key == KeyEvent.VK_LEFT){
            player.stepX = 0;
        }
        if(key == KeyEvent.VK_UP){
            player.stepY = 0;
        }
        if(key == KeyEvent.VK_DOWN){
            player.stepY = 0;
        }
    }
}
