package main.models.Alien;

import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Blind extends Alien{

    public int counter = 0;
    public Blind(int x, int y, int height, int width, String alien_type, Room currentRoom){
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        this.current_room = currentRoom;
        try {
            this.image = ImageIO.read(new File("assets/alien4.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.collidable = true;
        int hitBoxIndex = width/6;
        int hitBoxSize = width - (2 * hitBoxIndex);
        this.collisionArea = new Rectangle(hitBoxIndex,hitBoxIndex,hitBoxSize,hitBoxSize);
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
            System.out.println("inside2");
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

}
