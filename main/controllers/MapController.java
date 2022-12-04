package main.controllers;

import main.models.GameObject;
import main.models.Wall;

import java.awt.*;

public class MapController {
    public GameObject[][] tileMap;
    GameController gameController;

    public MapController(GameController gameController){
        this.gameController = gameController;
        int tileCountHorizontal = 768/gameController.tileSize; // 16
        int tileCountVertical = 576/gameController.tileSize; // 12
        this.tileMap = new GameObject[tileCountVertical][tileCountHorizontal];
    }
    public void initializeWalls(){
        int tileSize = gameController.tileSize;
        int tileCountHorizontal = 768/tileSize; // 16
        int tileCountVertical = 576/tileSize; // 12
        for (int i = 0; i < tileCountVertical; i++){
            for (int j = 0; j < tileCountHorizontal; j++){
                if (i == 0){
                    tileMap[i][j] = new Wall(j*tileSize,0,tileSize,tileSize);
                } else if (i == tileCountVertical-1){
                    tileMap[i][j] = new Wall(j*tileSize,576-tileSize,tileSize,tileSize);
                } else if (j == 0){
                    tileMap[i][j] = new Wall(0,i*tileSize,tileSize,tileSize);
                } else if (j == tileCountHorizontal - 1){
                    tileMap[i][j] = new Wall(768-tileSize,i*tileSize,tileSize,tileSize);
                }
            }
            /*
            Wall wall = new Wall(i*tileSize,0,tileSize,tileSize);
            Wall wall2 = new Wall(i*tileSize,576-tileSize,tileSize,tileSize);
            tileMap[0][i] = wall;
            tileMap[tileCountVertical-1][i] = wall2;
            if (i == 0 || i == tileCountHorizontal-1){
                for (int j = 1; j < tileCountVertical; j++){
                    Wall wall3 = new Wall(0,j*tileSize, tileSize, tileSize);
                    Wall wall4 = new Wall(768-tileSize,j*tileSize,tileSize,tileSize);
                    tileMap[j][0] = wall3;
                    tileMap[j][tileCountHorizontal-1] = wall4;
                }
            }

             */
        }
        printMapGrid();
    }
    public void printMapGrid(){
        System.out.println(tileMap.length);
        System.out.println(tileMap[0].length);
        for (int i = 0; i < tileMap.length; i ++){
            for (int j = 0; j < tileMap[0].length; j++){
                if (tileMap[i][j] != null ){
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
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
