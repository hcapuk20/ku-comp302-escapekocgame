package main.models.Alien;

import main.models.PowerUp.PowerUp;
import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Blind extends Alien{
    public Blind(){
        try {
            this.image = ImageIO.read(new File("assets/alien4.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int counter = 0;
    public Blind(int x, int y, int height, int width, String alien_type,int roomX,int roomY){
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        this.roomX=roomX;
        this.roomY=roomY;
        try {
            this.image = ImageIO.read(new File("assets/alien4.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.collidable = true;
        int hitBoxIndex = width/6;
        int hitBoxSize = width - (2 * hitBoxIndex);
        this.alien_type = alien_type;
        this.moving = true;
        this.direction = "down";
        this.speed = 4;


    }
    public void setDirection(){
        Random random = new Random();
        int a = random.nextInt(100)+1;
        counter++;
        if(counter > 75){

            if(a <= 25) {
                this.direction = "up";


            }
            else if(a > 25 && a <= 50) {
                this.direction = "down";


            }
            else if(a > 50 && a <= 75) {
                this.direction = "right";

            }
            else if(a > 75 && a <= 100) {
                this.direction = "left";

            }
            counter = 0; }



    }
    public void setDirection(int x, int y, PowerUp bottle){
        if(this.locationX > x+40){
            this.direction = "left";
        } else if (this.locationX < x-40) {
            this.direction = "right";
        } else if (this.locationY > y+40) {
            this.direction = "up";
        } else if (this.locationY < y-40) {
            this.direction = "down";
        }
        else {
            bottle = null;
        }

    }
}
