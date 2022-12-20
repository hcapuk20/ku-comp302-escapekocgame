package main.controllers;

import constants.Constants;
import main.models.GameObject;
import main.models.PowerUp.Hint;
import main.models.PowerUp.PowerUp;
import main.models.PowerUp.PowerUpFactory;
import main.models.Room;

import java.awt.*;
import java.util.Random;

public class PowerUpController {

    PowerUp powerUp;
    Room powerUpRoom;
    Random random;
    GameController gameController;

    public boolean hintUsed = false;
    public int hintX;
    public int hintY;
    private Hint hint = new Hint(0,0,0,0);

    public  int powerUpTypeCount = 5;

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
        PowerUpFactory powerUpFactory = new PowerUpFactory();
        powerUp = powerUpFactory.createPowerUp(randomType, randomXTile, randomYTile);
        powerUpRoom = gameController.currentRoom;
        //add other powerUps here.

        tileMap[randomXTile][randomYTile] = powerUp;

    }

    public void deSpawnPowerUp(){
        if (powerUp != null){
            int powerUpTileXLoc = powerUp.locationX / Constants.tileSize;
            int powerUpTileYLoc = powerUp.locationY / Constants.tileSize;
            powerUpRoom.tileMap[powerUpTileXLoc][powerUpTileYLoc] = null;
            powerUp = null;
        }
    }

    public void drawPowerUpEffect(Graphics g){
        if (hintUsed){
            //g.setColor(Color.ORANGE);
            hint.doEffect(gameController,g);
        }

    }

}
