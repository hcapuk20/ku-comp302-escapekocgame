package main.models;

import main.models.PowerUp.PowerUp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Character extends GameObject{
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public boolean moving;
    public boolean hasKey;
    public int life;

    public ArrayList<PowerUp> bag;

    public Character(int x, int y, int height, int width, int speed){
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        this.speed = speed;
        try {
            this.up1 = ImageIO.read(new File("assets/character_move/boy_up_1.png"));
            this.up2 = ImageIO.read(new File("assets/character_move/boy_up_2.png"));
            this.down1 = ImageIO.read(new File("assets/character_move/boy_down_1.png"));
            this.down2 = ImageIO.read(new File("assets/character_move/boy_down_2.png"));
            this.left1 = ImageIO.read(new File("assets/character_move/boy_left_1.png"));
            this.left2 = ImageIO.read(new File("assets/character_move/boy_left_2.png"));
            this.right1 = ImageIO.read(new File("assets/character_move/boy_right_1.png"));
            this.right2 = ImageIO.read(new File("assets/character_move/boy_right_2.png"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        this.life = 3;
        this.bag = new ArrayList<PowerUp>();
        this.direction = "down";
        this.moving = false;
        this.image = down1;
        this.collidable = true;
        this.hasKey = false;
        int hitBoxIndex = width/6;
        int hitBoxSize = width - (2 * hitBoxIndex);
        this.collisionArea = new Rectangle(hitBoxIndex,hitBoxIndex,hitBoxSize,hitBoxSize);
    }
    public void printBag(){
        for (GameObject gameObject: bag){
            System.out.println(gameObject);
        }
    }
}
