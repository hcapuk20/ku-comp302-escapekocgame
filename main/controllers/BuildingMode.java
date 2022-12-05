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

    FurniturePlacementController furniturePlacementController = new FurniturePlacementController();

    int currentBuilding = 0;
    Image nextImage = new ImageIcon("assets/arrow.png").getImage();

    Room room;
    public BuildingMode(){
        this.setPreferredSize(new Dimension(768, 576));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        //this.characterController = new CharacterController(character);
        //mapController.initializeWalls();
        this.addMouseListener(this);

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
        int imageSize = tileSize*3/2;
        g.drawImage(nextImage, Constants.WINDOW_WIDTH*7/8 - imageSize/2,
                Constants.WINDOW_HEIGHT*7/8 - imageSize,
                imageSize, imageSize, this);
    }

    private void checkCollisions(Rectangle mouse){
        int imageSize = tileSize*3/2;
        Rectangle next = new Rectangle(Constants.WINDOW_WIDTH*7/8 - imageSize/2,
                Constants.WINDOW_HEIGHT*7/8 - imageSize, imageSize, imageSize);
        if (mouse.intersects(next)) {
            if(currentBuilding < 5) {
                currentBuilding += 1;
                repaint();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        Rectangle mouse = new Rectangle(mouseX, mouseY, 1, 1);
        checkCollisions(mouse);
        furniturePlacementController.selectFurniture(mouse);
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
}


