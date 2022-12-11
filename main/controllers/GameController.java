package main.controllers;

import constants.Constants;
import main.CollisionChecker;
import main.ItemInteractionHandler;
import main.KeyEventHandler;
import main.models.*;
import main.models.Character;
import pause.PausePanel;

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
    public boolean paused = false;

    //BuildingsDataSource buildingsDataSource;

    ItemInteractionHandler itemInteractionHandler;

    Building currentBuilding;
    int roomCountX = 1;
    int roomCountY = 1;
    public Room currentRoom;
    public JFrame frame;
    public Alien[] aliens = new Alien[25];
    AlienController alienController;

    public GameController(JFrame f){
        this.frame =f;
        this.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        character = new Character(150,150,Constants.tileSize,Constants.tileSize,6);
        keyListener = new KeyEventHandler(this,character);
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        //buildingsDataSource = new BuildingsDataSource();
        currentBuilding = BuildingsDataSource.buildings[3];
        currentRoom = currentBuilding.rooms[roomCountX][roomCountY];
        //this.mapController = new MapController(this);
        this.collisionChecker = new CollisionChecker(currentRoom);
        this.characterController = new CharacterController(character, collisionChecker,this);
        this.itemInteractionHandler = new ItemInteractionHandler(this);
        this.addMouseListener(itemInteractionHandler);
        //currentRoom.tileMap[12][12] = new Furniture(12*Constants.tileSize,12*Constants.tileSize,Constants.tileSize,Constants.tileSize,1);
        this.alienController = new AlienController(collisionChecker, this);
    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double delta = 0;
        double spawnAlienDelta = 0;
        long lastRunTime = System.nanoTime();
        long currentRunTime;

        while(gameThread != null){
            if (paused){
                continue;
            }
            // main game loop
            currentRunTime = System.nanoTime();
            delta += (currentRunTime - lastRunTime) / (double) (1000000000/60);
            spawnAlienDelta += (currentRunTime - lastRunTime) / (double) (1000000000/60);
            lastRunTime = currentRunTime;

            if (delta > 1){
                update();
                repaint(); // this calls paintComponent
                delta--;
            }
            if (spawnAlienDelta > 600){
                alienController.spawnAlien(aliens);
                spawnAlienDelta -= 600;
            }

        }
    }
    public void stop() {
        pauseMenu();
        System.out.println("stop");
    }
    public void update(){
        characterController.move();
        currentRoom = currentBuilding.rooms[roomCountX][roomCountY];
        collisionChecker.mapController = currentRoom;
    }
    protected void pauseMenu() {

        PausePanel pausePanel = new PausePanel(frame, this);

        frame.add(pausePanel);
        pausePanel.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        frame.remove(this);
        frame.repaint();

    }


    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        characterController.draw(g);
        //for(int i = 0; i<aliens.length; i++){
           // if(aliens[i] != null) {
              //  alienController.draw(g, aliens[i]);
           // }
       // }
        //mapController.draw(g);
        currentRoom.draw(g);
        //g.dispose();

    }
}
