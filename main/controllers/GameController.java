package main.controllers;

import main.CollisionChecker;
import main.KeyEventHandler;
import main.models.Character;

import javax.swing.*;
import java.awt.*;

public class GameController extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // keep this for now
    Thread gameThread;
    Character character;
    CharacterController characterController;
    KeyEventHandler keyListener;
    CollisionChecker collisionChecker;
    MapController mapController;

    public GameController(){
        this.setPreferredSize(new Dimension(768, 576));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        character = new Character(150,150,48,48,6);
        keyListener = new KeyEventHandler(character);
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        this.mapController = new MapController(this);
        mapController.initializeWalls();
        this.collisionChecker = new CollisionChecker(mapController);
        this.characterController = new CharacterController(character, collisionChecker);

    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double delta = 0;
        long lastRunTime = System.nanoTime();
        long currentRunTime;

        while(gameThread != null){
            // main game loop
            currentRunTime = System.nanoTime();
            delta += (currentRunTime - lastRunTime) / (double) (1000000000/60);

            lastRunTime = currentRunTime;

            if (delta > 1){
                update();
                repaint(); // this calls paintComponent
                delta--;
            }
        }
    }

    public void update(){
        characterController.move();
    }

    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        characterController.draw(g);
        mapController.draw(g);
        //g.dispose();
    }
}
