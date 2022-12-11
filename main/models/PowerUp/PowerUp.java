package main.models.PowerUp;

import main.models.GameObject;

import javax.imageio.ImageIO;
import java.io.File;

public abstract class PowerUp extends GameObject implements PowerUpStrategy {


    public PowerUp(int locationX, int locationY, int width, int height){
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.width = width;
        this.collidable = false;
        this.interactable = true;
    }

}
