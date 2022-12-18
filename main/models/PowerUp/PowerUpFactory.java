package main.models.PowerUp;

import constants.Constants;

import java.util.Random;

public class PowerUpFactory {

    public PowerUp createPowerUp(int randomType, int randomXTile, int randomYTile){
        PowerUp powerUp = null;
        if (randomType == 0){
            powerUp = new ExtraLife(randomXTile* Constants.tileSize,randomYTile* Constants.tileSize,Constants.tileSize,Constants.tileSize);
        } else if (randomType == 1) {
            powerUp = new ExtraTime(randomXTile* Constants.tileSize,randomYTile* Constants.tileSize,Constants.tileSize,Constants.tileSize);
        } else if (randomType == 2) {
            powerUp = new Hint(randomXTile* Constants.tileSize,randomYTile* Constants.tileSize,Constants.tileSize,Constants.tileSize);
        } else if (randomType == 3) {
            powerUp = new ProtectionVest(randomXTile* Constants.tileSize,randomYTile* Constants.tileSize,Constants.tileSize,Constants.tileSize);
        } else if (randomType == 4) {
            powerUp = new PlasticBottle(randomXTile* Constants.tileSize,randomYTile* Constants.tileSize,Constants.tileSize,Constants.tileSize);
        }
        return powerUp;
    }


}
