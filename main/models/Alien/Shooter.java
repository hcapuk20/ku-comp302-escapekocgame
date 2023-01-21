package main.models.Alien;

import constants.Constants;
import main.models.Room;
import main.models.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Shooter extends Alien{
    public Shooter(){
        try {
            this.image = ImageIO.read(new File("assets/alien2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private int count = 0;
    public Shooter(int x, int y, int height, int width, String alien_type, int roomX, int roomY) {
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        this.roomX=roomX;
        this.roomY=roomY;
        try {
            this.image = ImageIO.read(new File("assets/alien2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.collidable = true;
        int hitBoxIndex = width/6;
        int hitBoxSize = width - (2 * hitBoxIndex);
        this.alien_type = alien_type;
    }
    public boolean specialPower(Character player, int roomX, int roomY){
        count++;
        if(count == 100) {

            count = 0;

            if(player.locationX < this.locationX+4 * Constants.tileSize && player.locationX > this.locationX-4 * Constants.tileSize && player.locationY < this.locationY+4 * Constants.tileSize && player.locationY > this.locationY-4 * Constants.tileSize && this.roomX == roomX && this.roomY == roomY ){
               // checks if the player in the range of shooter alien.
                if (player.vulnerable){
                    player.life --;
                }

                if (player.life == 0){return false;}
                else {
                    return true;
                }


            }
    }
        return true;

}}

