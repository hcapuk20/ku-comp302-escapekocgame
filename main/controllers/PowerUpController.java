package main.controllers;

import constants.Constants;
import main.models.GameObject;
import main.models.PowerUp.ExtraLife;
import main.models.PowerUp.ExtraTime;
import main.models.PowerUp.PowerUp;
import main.models.Room;

import java.util.Random;

public class PowerUpController {

    PowerUp powerUp;
    Random random;
    GameController gameController;

    public  int powerUpTypeCount = 2;

    public PowerUpController(GameController gameController){

        this.gameController = gameController;
        this.random = new Random();
    }


    public void spawnPowerUp(){
        GameObject[][] tileMap = gameController.currentRoom.tileMap;
        int randomXTile = random.nextInt(tileMap.length);

        int randomYTile = random.nextInt(tileMap[0].length);

        while (tileMap[randomXTile][randomYTile] != null){
            randomXTile = random.nextInt(tileMap.length);
            randomYTile = random.nextInt(tileMap[0].length);
        }
        int randomType = random.nextInt(powerUpTypeCount);
        if (randomType == 0){
            powerUp = new ExtraLife(randomXTile* Constants.tileSize,randomYTile* Constants.tileSize,Constants.tileSize,Constants.tileSize);
        } else if (randomType == 1) {
            powerUp = new ExtraTime(randomXTile* Constants.tileSize,randomYTile* Constants.tileSize,Constants.tileSize,Constants.tileSize);
        }
        //add other powerUps here.

        tileMap[randomXTile][randomYTile] = powerUp;

    }

    public void deSpawnPowerUp(){
        if (powerUp != null){
            int powerUpTileXLoc = powerUp.locationX / Constants.tileSize;
            int powerUpTileYLoc = powerUp.locationY / Constants.tileSize;
            gameController.currentRoom.tileMap[powerUpTileXLoc][powerUpTileYLoc] = null;
            powerUp = null;
        }
    }

}
