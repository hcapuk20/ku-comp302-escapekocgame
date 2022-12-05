package main.controllers;

import constants.Constants;
import main.models.Furniture;
import main.models.GameObject;
import main.models.Wall;

import java.awt.*;

public class MapController {
    public GameObject[][] tileMap;
    GameController gameController;

    public MapController(GameController gameController){
        this.gameController = gameController;
        int tileCountHorizontal = Constants.WINDOW_WIDTH/Constants.tileSize; //
        int tileCountVertical = Constants.WINDOW_HEIGHT/Constants.tileSize; // 32 x 18
        this.tileMap = new GameObject[tileCountVertical][tileCountHorizontal];
    }
    public void initializeWalls(){
        int tileSize = Constants.tileSize;
        int tileCountHorizontal = Constants.WINDOW_WIDTH/tileSize; // 16
        int tileCountVertical = Constants.WINDOW_HEIGHT/tileSize; // 12
        for (int i = 0; i < tileCountVertical; i++){
            for (int j = 0; j < tileCountHorizontal; j++){
                if (i == 0){
                    tileMap[i][j] = new Wall(j*tileSize,0,tileSize,tileSize);
                } else if (i == tileCountVertical-1){
                    tileMap[i][j] = new Wall(j*tileSize,Constants.WINDOW_HEIGHT-tileSize,tileSize,tileSize);
                } else if (j == 0){
                    tileMap[i][j] = new Wall(0,i*tileSize,tileSize,tileSize);
                } else if (j == tileCountHorizontal - 1){
                    tileMap[i][j] = new Wall(Constants.WINDOW_WIDTH-tileSize,i*tileSize,tileSize,tileSize);
                }
            }
        }
        tileMap[3][5] = new Furniture(3*tileSize,5*tileSize,tileSize,tileSize,1);
        tileMap[12][3] = new Furniture(12*tileSize,3*tileSize,tileSize,tileSize,1);
        tileMap[7][9] = new Furniture(7*tileSize,9*tileSize,tileSize,tileSize,1);
        System.out.println(" "+3*tileSize+" "+5*tileSize);
        printMapGrid();
    }
    public void printMapGrid(){
        System.out.println(tileMap.length);
        System.out.println(tileMap[0].length);
        for (int i = 0; i < tileMap.length; i ++){
            for (int j = 0; j < tileMap[0].length; j++){
                if (tileMap[i][j] != null ){
                    if (tileMap[i][j].interactable){
                        System.out.print("2 ");
                    } else {
                        System.out.print("1 ");
                    }
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
