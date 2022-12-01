package main.controllers;

import constants.Constants;
import main.models.GameObject;
import main.models.Room;
import main.models.Wall;

import java.awt.*;

public class RoomController {

    Room room;
    GameController gameController;


    int tileCountHorizontal = 768/ Constants.tileSize;
    int tileCountVertical = 576/Constants.tileSize;

    int tileSize = Constants.tileSize;
    int up,down,right,left;

    public RoomController(GameController gameController, int up, int down, int right, int left){
        this.gameController = gameController;
        room = new Room(new GameObject[tileCountHorizontal][tileCountVertical]);
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        initializeWallsUpDown(up, down);
        initializeWallsLeftRight(left, right);
    }
    public void initializeWallsUpDown(int door1, int door2){
        int middle = tileCountHorizontal/2;
        for (int i = 0; i < tileCountHorizontal; i++){
            if(door1 == 1 && door2 == 1){
                if(i < middle + 2 && i > middle - 2){
                    continue;
                }
            } else if (door1 == 1){
                Wall wallDown = new Wall(i*tileSize, Constants.WINDOW_HEIGHT-tileSize,tileSize,tileSize);
                room.tileMap[i][tileCountVertical-1] = wallDown;
                continue;
            } else if (door2 == 1){
                Wall wallUp = new Wall(i*tileSize,0,tileSize,tileSize);
                room.tileMap[i][0] = wallUp;
                continue;
            }
            Wall wallUp = new Wall(i*tileSize,0,tileSize,tileSize);
            Wall wallDown = new Wall(i*tileSize, Constants.WINDOW_HEIGHT-tileSize,tileSize,tileSize);
            room.tileMap[i][0] = wallUp;
            room.tileMap[i][tileCountVertical-1] = wallDown;
        }
    }

    public void initializeWallsLeftRight(int door1, int door2){
        int middle = tileCountVertical/2;
        for (int i = 0; i < tileCountVertical; i++){
            if(door1 == 1 && door2 == 1){
                if(i < middle + 2 && i > middle - 2){
                    continue;
                }
            } else if (door1 == 1){
                Wall wallRight = new Wall(Constants.WINDOW_WIDTH-tileSize, i*tileSize,tileSize,tileSize);
                room.tileMap[tileCountHorizontal-1][i] = wallRight;
                continue;
            } else if (door2 == 1){
                Wall wallLeft = new Wall(0,i*tileSize,tileSize,tileSize);
                room.tileMap[0][i] = wallLeft;
                continue;
            }
            Wall wallLeft = new Wall(0,i*tileSize,tileSize,tileSize);
            Wall wallRight = new Wall(Constants.WINDOW_WIDTH-tileSize, i*tileSize,tileSize,tileSize);
            room.tileMap[0][i] = wallLeft;
            room.tileMap[tileCountHorizontal-1][i] = wallRight;
        }
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for (GameObject[] gameObjectArray : room.tileMap){
            for(GameObject gameObject: gameObjectArray){
                if (gameObject != null){
                    g2.drawImage(gameObject.image,gameObject.locationX,gameObject.locationY,gameObject.width,gameObject.height,null);
                }
            }
        }
    }

}
