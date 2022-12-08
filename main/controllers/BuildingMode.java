package main.controllers;

import constants.Constants;
import main.models.BuildingsDataSource;
import main.models.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BuildingMode extends JPanel implements Runnable, MouseListener {

    final int tileSize = Constants.tileSize; // keep this for now
    Thread buildingModeThread;
    CharacterController characterController;
    MapController mapController;
    RoomCreator roomCreator;

    BuildingsDataSource buildingsDataSource = new BuildingsDataSource();

    FurniturePlacementController furniturePlacementController = new FurniturePlacementController(this);

    int currentBuilding = 0;
    Image nextImage = new ImageIcon("assets/arrow.png").getImage();

    int imageSize = Constants.WINDOW_WIDTH/(Constants.buildingModeDivider*4);

    boolean notEnoughFurnitures = false;
    Room room;
    JFrame frame;
    public BuildingMode(JFrame f){
        this.setPreferredSize(new Dimension(768, 576));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        //this.characterController = new CharacterController(character);
        //mapController.initializeWalls();
        this.addMouseListener(this);
        this.frame = f;

        this.roomCreator = new RoomCreator();
        this.room = roomCreator.createRoom(1, 1, 1, 1);


    }

    public void startGame(){
        buildingModeThread = new Thread(this);
        buildingModeThread.start();
    }

    @Override
    public void run() {
        double delta = 0;
        long lastRunTime = System.nanoTime();
        long currentRunTime;

        while(buildingModeThread != null){
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

    }

    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        if(BuildingsDataSource.buildings[currentBuilding] != null) {
            BuildingsDataSource.buildings[currentBuilding].draw(g);
        }
        paintNextPageButton(g);
        furniturePlacementController.draw((Graphics2D) g);
        //g.dispose();
    }

    private void paintNextPageButton(Graphics g){

        g.drawImage(nextImage, Constants.WINDOW_WIDTH*7/8 - imageSize/2,
                Constants.WINDOW_HEIGHT*7/8 - imageSize,
                imageSize, imageSize, this);
        if(notEnoughFurnitures){
            BuildingsDataSource.buildings[currentBuilding].drawMinCountLabel(g);
        }
    }

    private void checkCollisions(Rectangle mouse){

        Rectangle next = new Rectangle(Constants.WINDOW_WIDTH*7/8 - imageSize/2,
                Constants.WINDOW_HEIGHT*7/8 - imageSize, imageSize, imageSize);
        if (mouse.intersects(next)) {
            if(BuildingsDataSource.buildings[currentBuilding].enoughFurnituresPlaced()) {
                furniturePlacementController.addKey(currentBuilding);

                if (currentBuilding < 5) {
                    currentBuilding += 1;
                    notEnoughFurnitures = false;
                    repaint();
                } else {
                    startRunningMode();
                }
            } else {
                notEnoughFurnitures = true;
            }
        }
    }

    public int getCurrentBuilding(){
        return currentBuilding;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        Rectangle mouse = new Rectangle(mouseX, mouseY, 1, 1);
        checkCollisions(mouse);
        furniturePlacementController.selectFurniture(mouse);
        furniturePlacementController.addFurnitureToRoom(mouse, currentBuilding);
        furniturePlacementController.clickRandomButton(mouse);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    protected void startRunningMode() {

        GameController gameController = new GameController(frame);

        frame.add(gameController);
        gameController.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        gameController.startGame();

        frame.remove(this);

    }
}


