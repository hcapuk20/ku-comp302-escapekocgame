package main.controllers;

import constants.Constants;
import main.CollisionChecker;
import main.ItemInteractionHandler;
import main.KeyEventHandler;
import main.models.*;
import main.models.Character;

import javax.swing.*;
import java.awt.*;

public class GameController extends JPanel implements Runnable{

    Thread gameThread;
    public Character character;
    CharacterController characterController;
    KeyEventHandler keyListener;
    CollisionChecker collisionChecker;
    MapController mapController;

    RoomCreator roomCreator;


    BuildingsDataSource buildingsDataSource = new BuildingsDataSource();

    ItemInteractionHandler itemInteractionHandler;

    Building currentBuilding = BuildingsDataSource.buildings[5];
    int roomCountX = 1;
    int roomCountY = 1;
    public Room currentRoom = currentBuilding.rooms[roomCountX][roomCountY];

    public GameController(){
        this.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        character = new Character(150,150,Constants.tileSize,Constants.tileSize,6);
        keyListener = new KeyEventHandler(character);
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        this.mapController = new MapController(this);
        this.collisionChecker = new CollisionChecker(currentRoom);
        this.characterController = new CharacterController(character, collisionChecker,this);
        this.itemInteractionHandler = new ItemInteractionHandler(this);
        this.addMouseListener(itemInteractionHandler);
        currentRoom.tileMap[12][12] = new Furniture(12*Constants.tileSize,12*Constants.tileSize,Constants.tileSize,Constants.tileSize,1);

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
        currentRoom = currentBuilding.rooms[roomCountX][roomCountY];
    }

    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        characterController.draw(g);
        //mapController.draw(g);
        currentRoom.draw(g);
        //g.dispose();
    }
}
