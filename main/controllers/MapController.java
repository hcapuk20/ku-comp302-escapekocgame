package main.controllers;

import main.models.GameObject;
import main.models.Wall;

import java.awt.*;

public class MapController {
    GameObject[][] tileMap;
    GameController gameController;

    public MapController(GameController gameController){
        this.gameController = gameController;
        int tileCountHorizontal = 768/gameController.tileSize;
        int tileCountVertical = 576/gameController.tileSize;
        this.tileMap = new GameObject[tileCountHorizontal][tileCountVertical];
    }
    public void initializeWalls(){
        int tileCountHorizontal = 768/gameController.tileSize;
        int tileSize = gameController.tileSize;
        for (int i = 0; i < tileCountHorizontal; i++){
            Wall wall = new Wall(i*tileSize,0,tileSize,tileSize);
            tileMap[i][0] = wall;
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
}
