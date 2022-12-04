package main.controllers;

import constants.Constants;
import main.CollisionChecker;
import main.KeyEventHandler;
import main.models.Character;

import javax.swing.*;
import java.awt.*;

public class GameController extends JPanel implements Runnable{

    Thread gameThread;
    Character character;
    CharacterController characterController;
    KeyEventHandler keyListener;
    CollisionChecker collisionChecker;
    MapController mapController;

    RoomCreator roomCreator;

    public GameController(){
        this.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        character = new Character(150,150,Constants.tileSize,Constants.tileSize,6);
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
