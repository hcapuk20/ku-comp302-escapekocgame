package main.controllers;

import constants.Constants;
import main.models.GameObject;
import main.models.PowerUp.ExtraLife;
import main.models.PowerUp.PowerUp;
import main.models.Room;

import java.util.Random;

public class PowerUpController {

    PowerUp[] powerUps;
    Random random;
    Room currentRoom;
    public PowerUpController(Room room){

        this.currentRoom = room;

        this.random = new Random();
    }


    public void spawnPowerUp(){
        GameObject[][] tileMap = currentRoom.tileMap;
        int randomXTile = random.nextInt(tileMap.length);

        int randomYTile = random.nextInt(tileMap[0].length);

        while (tileMap[randomXTile][randomYTile] != null){
            randomXTile = random.nextInt(tileMap.length);
            randomYTile = random.nextInt(tileMap[0].length);
        }

        tileMap[randomXTile][randomYTile] = new ExtraLife(randomXTile* Constants.tileSize,randomYTile* Constants.tileSize,Constants.tileSize,Constants.tileSize);

    }

    public void deSpawnPowerUp(PowerUp powerUp){

    }

}
