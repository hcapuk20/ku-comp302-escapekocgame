package main.controllers;

import constants.Constants;
import main.CollisionChecker;
import main.KeyEventHandler;
import main.models.Building;
import main.models.BuildingsDataSource;
import main.models.Character;
import pause.PausePanel;
import main.models.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameController extends JPanel implements Runnable{

    Thread gameThread;
    Character character;
    CharacterController characterController;
    KeyEventHandler keyListener;
    CollisionChecker collisionChecker;
    MapController mapController;

    RoomCreator roomCreator;
    public boolean exit = false;
    JFrame frame;


    BuildingsDataSource buildingsDataSource = new BuildingsDataSource();

    Building currentBuilding = BuildingsDataSource.buildings[5];
    int roomCountX = 1;
    int roomCountY = 1;
    Room currentRoom = currentBuilding.rooms[roomCountX][roomCountY];

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
            if(exit){ continue; }

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
    public void stop() {
        changeExit();
        pauseMenu();
    }
    public void update(){
        characterController.move();
        currentRoom = currentBuilding.rooms[roomCountX][roomCountY];
    }

    protected void pauseMenu() {

        PausePanel pausePanel = new PausePanel(frame, this);

        frame.add(pausePanel);
        pausePanel.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        frame.remove(this);
        frame.repaint();

    }

    public void changeExit(){
        if(exit){
            exit = false;
        } else {
            exit = true;
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        characterController.draw(g);
        //mapController.draw(g);
        currentRoom.draw(g);
        //g.dispose();
    }





    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}
