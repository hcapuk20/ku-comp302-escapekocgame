package main.models;

import constants.Constants;

import java.awt.*;
import java.util.ArrayList;

public class Room {

    public GameObject[][] tileMap;

    public Room( GameObject[][] tileMap){
        this.tileMap = tileMap;
    }

    int tileSize = Constants.tileSize;

    int tileCountHorizontal = Constants.WINDOW_WIDTH/ Constants.tileSize;
    int tileCountVertical = Constants.WINDOW_HEIGHT/Constants.tileSize;

    int divider = Constants.buildingModeDivider;
    int mapDivider = Constants.miniMapDivider;
    public ArrayList<Furniture> furnitures = new ArrayList<Furniture>();


    public void addDoor(int direction){
        if(direction == 1 || direction == 3){ //up and down
            int middle = tileCountHorizontal/2;

            for (int i = 0; i < tileCountHorizontal; i++){
                if(i >= middle - 2 && i <= middle + 2){
                    if(direction == 1){
                        Door doorUp = new Door(i*tileSize,0,tileSize,tileSize);
                        tileMap[i][0] = doorUp;
                    } else {
                        Door doorDown = new Door(i*tileSize, Constants.WINDOW_HEIGHT-tileSize,tileSize,tileSize);
                        tileMap[i][tileCountVertical-1] = doorDown;
                    }
                }
            }
        } else { //right and left
            int middle = tileCountVertical/2;

            for (int i = 0; i < tileCountVertical; i++){
                if(i >= middle - 2 && i <= middle + 2){
                    if(direction == 2){
                        Door doorRight = new Door(Constants.WINDOW_WIDTH-tileSize, i*tileSize,tileSize,tileSize);
                        tileMap[tileCountHorizontal-1][i] = doorRight;
                    } else {
                        Door doorLeft = new Door(0,i*tileSize,tileSize,tileSize);
                        tileMap[0][i] = doorLeft;
                    }

                }
            }
        }

    }

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

    public void drawMiniMap(Graphics g, int index1, int index2){
        int width = Constants.WINDOW_WIDTH / mapDivider;
        int height = Constants.WINDOW_HEIGHT / mapDivider;
        int initialX = (Constants.WINDOW_WIDTH - 3*width)/2;
        int initialY = (Constants.WINDOW_HEIGHT - 3*height)/2;
        Graphics2D g2 = (Graphics2D) g;
        for (GameObject[] gameObjectArray : tileMap){
            for(GameObject gameObject: gameObjectArray){
                if (gameObject != null){
                    g2.drawImage(gameObject.image,
                            initialX + width*index1 + gameObject.locationX/mapDivider ,
                            initialY + height*(index2) + gameObject.locationY/mapDivider,
                            gameObject.width / mapDivider,
                            gameObject.height / mapDivider,null);
                }
            }
        }
    }




}
