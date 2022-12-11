package main.models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Alien extends GameObject{
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public boolean moving;
    public String alien_type;

    public Alien(int x, int y, int height, int width, String alien_type) {
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        if (alien_type.equals("blind")){
            this.speed = 4;
        }
        else {
            this.speed = 0;
        }

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
        this.alien_type = alien_type;
    }

}

