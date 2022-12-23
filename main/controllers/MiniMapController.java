package main.controllers;

import constants.Constants;
import main.models.Building;
import main.models.Character;
import main.models.GameObject;

import javax.swing.*;
import java.awt.*;

public class MiniMapController extends JPanel{

    Frame f;
    int panelWidth = Constants.WINDOW_WIDTH/2;
    int panelHeight = Constants.WINDOW_HEIGHT/2;

    int screenWidth = Constants.WINDOW_WIDTH;
    int screenHeight = Constants.WINDOW_HEIGHT;

    boolean opened = false;

    public boolean showHint = false;
    int mapDivider = Constants.miniMapDivider;


    GameController gameController;

    Character character;
    public MiniMapController(GameController gameController) {
        this.addMouseListener(null);

        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.white);

        this.setVisible(true);

        this.gameController = gameController;
        character = gameController.character;

        setLayout(null);

    }

    public void keyEventOperation(){
        if(opened){
            opened = false;
        } else {
            opened = true;
        }
    }

    private void drawMiniCharacter(Graphics g, int roomX, int roomY){
        g.setColor(Color.red);
        int width = Constants.WINDOW_WIDTH / mapDivider;
        int height = Constants.WINDOW_HEIGHT / mapDivider;
        int initialX = (Constants.WINDOW_WIDTH - 3*width)/2;
        int initialY = (Constants.WINDOW_HEIGHT - 3*height)/2;
        g.fillOval(initialX + width*roomX + character.locationX/mapDivider ,
                initialY + height*roomY + character.locationY/mapDivider,
                Constants.tileSize/mapDivider, Constants.tileSize/mapDivider);
    }


    public void drawMiniMap(Graphics g, Building currentBuilding, int roomX, int roomY) {
        if(opened) {
            super.paintComponent(g);

            int frameWidth = panelWidth + 6;
            int frameHeight = panelHeight + 6;
            g.setColor(Color.white);
            g.fillRect((screenWidth-frameWidth) / 2, (screenHeight-frameHeight) / 2, frameWidth, frameHeight);

            g.setColor(Color.darkGray);
            g.fillRect((screenWidth-panelWidth) / 2, (screenHeight-panelHeight) / 2, panelWidth, panelHeight);

            drawMiniCharacter(g, roomX, roomY);

            g.setColor(getBackground());
            currentBuilding.drawMiniMap(g);
            drawHint(g);
            //g.dispose();
        }

    }

    public void drawHint(Graphics g){
        if(showHint){

            g.setColor(Color.orange);
            int width = Constants.WINDOW_WIDTH / mapDivider;
            int height = Constants.WINDOW_HEIGHT / mapDivider;
            int initialX = (Constants.WINDOW_WIDTH - 3*width)/2;
            int initialY = (Constants.WINDOW_HEIGHT - 3*height)/2;
            int size = Constants.tileSize/mapDivider*4;
            int drawRectX = initialX + width*gameController.currentBuilding.roomX +
                    gameController.currentBuilding.furnitureWithKey.locationX/mapDivider - size*3/8;
            int drawRectY = initialY + height*gameController.currentBuilding.roomY +
                    gameController.currentBuilding.furnitureWithKey.locationY/mapDivider - size*3/8;
            g.drawRect( drawRectX, drawRectY, size, size);



        }
    }






}
