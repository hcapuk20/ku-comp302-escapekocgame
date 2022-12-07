package main.models;

import constants.Constants;

import java.awt.*;
import java.util.ArrayList;

public class Room {

    public GameObject[][] tileMap;

    public Room( GameObject[][] tileMap){
        this.tileMap = tileMap;
    }

    int divider = Constants.buildingModeDivider;

    int tileSize = Constants.tileSize;
    int objSize = tileSize/divider;

    public ArrayList<Furniture> furnitures = new ArrayList<Furniture>();

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for (GameObject[] gameObjectArray : tileMap){
            for(GameObject gameObject: gameObjectArray){
                if (gameObject != null){
                    g2.drawImage(gameObject.image,gameObject.locationX,gameObject.locationY,gameObject.width,gameObject.height,null);
                }
            }
        }
    }

    public void drawSmall(Graphics g, int index1, int index2){
        int width = Constants.WINDOW_WIDTH / divider;
        int height = Constants.WINDOW_HEIGHT / divider;
        Graphics2D g2 = (Graphics2D) g;
        for (GameObject[] gameObjectArray : tileMap){
            for(GameObject gameObject: gameObjectArray){
                if (gameObject != null){
                    g2.drawImage(gameObject.image,
                            width*index1 + gameObject.locationX/divider ,
                            height/2 + height*(index2) + gameObject.locationY/divider,
                            gameObject.width / divider,
                            gameObject.height / divider,null);
                }
            }
        }
    }


}
