package main.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import constants.Constants;
import main.CollisionChecker;
import main.ItemInteractionHandler;
import main.KeyEventHandler;
import main.Main;
import main.models.*;
import main.models.Alien.Alien;
import main.models.Character;
import pause.PauseObserver;
import pause.PausePanel;
import pause.PauseSubject;

import javax.sound.sampled.*;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.SQLOutput;
import java.util.Timer;
import java.util.TimerTask;
@JsonIgnoreProperties({"frame"})
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
    public int roomCountX = 1;
    public int roomCountY = 1;
    public Room currentRoom;
    public JFrame frame;
    public  String displayedMessage = "";

    public PowerUpController powerUpController;

    //public Alien[] aliens = new Alien[100];
    public AlienController alienController;
    PauseSubject pauseSubject;
    PauseObserver pauseObserver;


    BagController bagController;

    public MiniMapController miniMapController;
    public TimeController timeController;
    int score = 0;

    public String username = Main.username;
    public String password = Main.password;

    public GameController(JFrame f, Character loadChar,int loadTime,int loadBuildingCount,int loadRoomX,int loadRoomY){
        this.frame =f;
        this.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setBackground(new Color(254, 229, 204));
        this.setDoubleBuffered(true);
        character = loadChar;
        keyListener = new KeyEventHandler(this,character);
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        //buildingsDataSource = new BuildingsDataSource();
        currentBuilding = BuildingsDataSource.buildings[loadBuildingCount];
        System.out.println(loadRoomX);
        System.out.println(loadRoomY);
        currentRoom = currentBuilding.rooms[loadRoomX][loadRoomY];
        roomCountX = loadRoomX;
        roomCountY = loadRoomY;
        currentBuildingCount = loadBuildingCount;

        //this.mapController = new MapController(this);
        this.collisionChecker = new CollisionChecker(currentRoom);
        this.characterController = new CharacterController(character, collisionChecker,this);
        this.itemInteractionHandler = new ItemInteractionHandler(this);
        this.addMouseListener(itemInteractionHandler);
        //currentRoom.tileMap[12][12] = new Furniture(12*Constants.tileSize,12*Constants.tileSize,Constants.tileSize,Constants.tileSize,1);

        this.powerUpController = new PowerUpController(this);
        powerUpController.spawnPowerUp();


        this.miniMapController = new MiniMapController(this);



        this.alienController = new AlienController(collisionChecker, this, character);
        for (Alien a : Alien.aliens){
            if (a != null){
                System.out.println(a);
            }

        }

        this.bagController = new BagController(this);
        this.timeController = new TimeController(this, loadTime);
        this.setLayout(null);
    }


    public GameController(JFrame f){
        this.frame =f;
        this.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setBackground(new Color(254, 229, 204));
        this.setDoubleBuffered(true);
        character = Character.getInstance();
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

        this.miniMapController = new MiniMapController(this);
        


        this.alienController = new AlienController(collisionChecker, this, character);

        this.bagController = new BagController(this);
        this.timeController = new TimeController(this, currentBuilding.getTotalFurnitures() * 5);
        this.setLayout(null);
        this.pauseSubject = new PauseSubject();
        this.pauseObserver = new PauseObserver();
        pauseSubject.registerObserver(pauseObserver);
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
        Alien.aliens = new Alien[100];
        score += 1;

        if (currentBuildingCount < 5){
            currentBuildingCount +=1;
            currentBuilding = BuildingsDataSource.buildings[currentBuildingCount];
            roomCountX = 1;
            roomCountY = 1;
            currentRoom = currentBuilding.rooms[roomCountX][roomCountY];
            character.locationX = 150;
            character.locationY = 150;
            timeController.counterLabel.setVisible(false);
            timeController.activeTimer = false;
            timeController = new TimeController(this, currentBuilding.getTotalFurnitures() * 5);
        } else {
            endGame();
        }
        
    }

    public void endGame(){

        this.paused = true;
        pauseSubject.setPaused(true);


        EndGameController endGameController = new EndGameController(frame, score);


        frame.add(endGameController);
        endGameController.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);


        frame.remove(this);
    }

    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        g.setColor(getBackground());
        characterController.draw(g);
        alienController.paint(g);
        //mapController.draw(g);
        currentRoom.draw(g);
        drawName(g);

        characterController.drawLife(g);
        timeController.drawTime(g);

        bagController.draw(g);
        powerUpController.drawPowerUpEffect(g);

        miniMapController.drawMiniMap(g, currentBuilding, roomCountX, roomCountY);
        //g.dispose();
    }


    private void drawName(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("GeoSlab703 Md BT", Font.BOLD, 20));
        g.drawString(currentBuilding.name, Constants.tileSize, Constants.WINDOW_HEIGHT - 15);
    }
    public static void playSound(String soundFile) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

}
