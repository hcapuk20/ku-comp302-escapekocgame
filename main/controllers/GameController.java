package main.controllers;

import constants.Constants;
import main.CollisionChecker;
import main.ItemInteractionHandler;
import main.KeyEventHandler;
import main.models.*;
import main.models.Alien.Alien;
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

    ItemInteractionHandler itemInteractionHandler;
    public int currentBuildingCount = 0;
    public Building currentBuilding;
    int roomCountX = 1;
    int roomCountY = 1;
    public Room currentRoom;
    public JFrame frame;

    PowerUpController powerUpController;

    //public Alien[] aliens = new Alien[100];
    AlienController alienController;

    BagController bagController;

    int score = 0;


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
        currentBuilding = BuildingsDataSource.buildings[currentBuildingCount];
        currentRoom = currentBuilding.rooms[roomCountX][roomCountY];
        //this.mapController = new MapController(this);
        this.collisionChecker = new CollisionChecker(currentRoom);
        this.characterController = new CharacterController(character, collisionChecker,this);
        this.itemInteractionHandler = new ItemInteractionHandler(this);
        this.addMouseListener(itemInteractionHandler);
        //currentRoom.tileMap[12][12] = new Furniture(12*Constants.tileSize,12*Constants.tileSize,Constants.tileSize,Constants.tileSize,1);

        this.powerUpController = new PowerUpController(this);
        powerUpController.spawnPowerUp();


        this.alienController = new AlienController(collisionChecker, this, character);
        this.bagController = new BagController(this);

    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
        alienController.alienThread = new Thread(alienController);
        alienController.alienThread.start();

    }

    @Override
    public void run() {
        double delta = 0;

        double spawnPowerUpDelta = 0;
        double deSpawnPowerUpDelta = 0;

        double spawnAlienDelta = 0;

        long lastRunTime = System.nanoTime();
        long currentRunTime;
        int number = 0;
        while(gameThread != null){
            if (paused){
                continue;
            }
            // main game loop
            currentRunTime = System.nanoTime();
            delta += (currentRunTime - lastRunTime) / (double) (1000000000/60);

            spawnPowerUpDelta += (currentRunTime - lastRunTime) / (double) (1000000000/60);
            deSpawnPowerUpDelta += (currentRunTime - lastRunTime) / (double) (1000000000/60);
            spawnAlienDelta += (currentRunTime - lastRunTime) / (double) (1000000000/60);

            lastRunTime = currentRunTime;

            if (delta > 1){
                update();
                repaint(); // this calls paintComponent
                delta--;
            }


            if (spawnPowerUpDelta > 360){
                number++;
                if(number%2==0){
                    powerUpController.spawnPowerUp();
                }
                else {
                    powerUpController.deSpawnPowerUp();
                }
                spawnPowerUpDelta-=360;
                if (number == 10){
                    number = 0;
                }
            }
            /*
            if (spawnAlienDelta > 600){

                alienController.spawnAlien();
                spawnAlienDelta -= 600;
            }

             */


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
    public void changeBuilding(){
        System.out.println("Changing Building..");
        Alien.aliens = new Alien[100];

        if (currentBuildingCount < 5){
            currentBuildingCount +=1;
            currentBuilding = BuildingsDataSource.buildings[currentBuildingCount];
            roomCountX = 1;
            roomCountY = 1;
            currentRoom = currentBuilding.rooms[roomCountX][roomCountY];
            character.locationX = 150;
            character.locationY = 150;
        } else {
            endGame();
        }
    }

    public void endGame(){

        EndGameController endGameController = new EndGameController(frame, score);

        frame.add(endGameController);
        endGameController.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        frame.remove(this);
    }


    public void paintComponent(Graphics g) {

        g.setColor(getBackground());
        characterController.draw(g);
        alienController.paint(g);
        //mapController.draw(g);
        currentRoom.draw(g);

        characterController.drawLife(g);

        bagController.draw(g);

        //g.dispose();

    }
}
