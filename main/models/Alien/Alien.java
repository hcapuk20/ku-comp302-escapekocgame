package main.models.Alien;

import main.models.GameObject;
import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Alien extends GameObject {
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public boolean moving;
    public String alien_type;
    public Room current_room;

    public static int timeWaste1Count = 0;
    public static int timeWaste2Count = 0;
    public static int timeWaste3count = 0;

    public static Alien[] aliens = new Alien[100];

    public Alien() {
        /*this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        try {
            this.up1 = ImageIO.read(new File("assets/alien1.png"));
            this.up2 = ImageIO.read(new File("assets/alien1.png"));
            this.down1 = ImageIO.read(new File("assets/alien1.png"));
            this.down2 = ImageIO.read(new File("assets/alien1.png"));
            this.left1 = ImageIO.read(new File("assets/alien1.png"));
            this.left2 = ImageIO.read(new File("assets/alien1.png"));
            this.right1 = ImageIO.read(new File("assets/alien1.png"));
            this.right2 = ImageIO.read(new File("assets/alien1.png"));
        }
        catch (Exception e) {
            //System.out.println(e);
        }
        this.direction = "down";
        this.moving = false;
        try {
            this.image = ImageIO.read(new File("assets/alien1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.collidable = true;
        int hitBoxIndex = width/6;
        int hitBoxSize = width - (2 * hitBoxIndex);
        this.collisionArea = new Rectangle(hitBoxIndex,hitBoxIndex,hitBoxSize,hitBoxSize);
        this.alien_type = alien_type;*/


    }

}

