package main.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import constants.Constants;
import main.models.PowerUp.PowerUp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
@JsonIgnoreProperties({"collisionArea","image","up1","up2","down1","down2","left1","left2","right1","right2","up1p","up2p","down1p","down2p","left1p","left2p","right1p","right2p","fullHeart","emptyHeart", "timeIcon"})
public class Character extends GameObject{
    private static Character instance = null;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public BufferedImage up1p,up2p,down1p,down2p,left1p,left2p,right1p,right2p;
    public BufferedImage fullHeart,emptyHeart, timeIcon;
    public boolean moving;
    public boolean hasKey;
    public int life;
    public int maxLife = 5;
    public boolean vulnerable = true;

    public boolean bottleUsed = false;

    public ArrayList<PowerUp> bag;
    private Character(){
        try {
            this.fullHeart = ImageIO.read(new File("assets/heart.png"));
            this.emptyHeart = ImageIO.read(new File("assets/heart-empty.png"));
            this.timeIcon = ImageIO.read(new File("assets/timer_new.png"));
            this.up1 = ImageIO.read(new File("assets/character_move/boy_up_1.png"));
            this.up2 = ImageIO.read(new File("assets/character_move/boy_up_2.png"));
            this.down1 = ImageIO.read(new File("assets/character_move/boy_down_1.png"));
            this.down2 = ImageIO.read(new File("assets/character_move/boy_down_2.png"));
            this.left1 = ImageIO.read(new File("assets/character_move/boy_left_1.png"));
            this.left2 = ImageIO.read(new File("assets/character_move/boy_left_2.png"));
            this.right1 = ImageIO.read(new File("assets/character_move/boy_right_1.png"));
            this.right2 = ImageIO.read(new File("assets/character_move/boy_right_2.png"));
            this.up1p = ImageIO.read(new File("assets/character_move_protected/boy_up_1.png"));
            this.up2p = ImageIO.read(new File("assets/character_move_protected/boy_up_2.png"));
            this.down1p = ImageIO.read(new File("assets/character_move_protected/boy_down_1.png"));
            this.down2p = ImageIO.read(new File("assets/character_move_protected/boy_down_2.png"));
            this.left1p = ImageIO.read(new File("assets/character_move_protected/boy_left_1.png"));
            this.left2p = ImageIO.read(new File("assets/character_move_protected/boy_left_2.png"));
            this.right1p = ImageIO.read(new File("assets/character_move_protected/boy_right_1.png"));
            this.right2p = ImageIO.read(new File("assets/character_move_protected/boy_right_2.png"));

        }
        catch (Exception e) {
            System.out.println(e);
        }
        this.image = down1;

    }

    public void initialize() {
        this.life = 3;
        this.locationX = 150;
        this.locationY = 150;
        this.bag = new ArrayList<>();
        this.direction = "down";
        this.moving = false;
        this.image = down1;
        this.hasKey = false;
    }

    private Character(int x, int y, int height, int width, int speed){
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        this.speed = speed;

        try {
            this.fullHeart = ImageIO.read(new File("assets/heart.png"));
            this.emptyHeart = ImageIO.read(new File("assets/heart-empty.png"));
            this.timeIcon = ImageIO.read(new File("assets/timer_new.png"));
            this.up1 = ImageIO.read(new File("assets/character_move/boy_up_1.png"));
            this.up2 = ImageIO.read(new File("assets/character_move/boy_up_2.png"));
            this.down1 = ImageIO.read(new File("assets/character_move/boy_down_1.png"));
            this.down2 = ImageIO.read(new File("assets/character_move/boy_down_2.png"));
            this.left1 = ImageIO.read(new File("assets/character_move/boy_left_1.png"));
            this.left2 = ImageIO.read(new File("assets/character_move/boy_left_2.png"));
            this.right1 = ImageIO.read(new File("assets/character_move/boy_right_1.png"));
            this.right2 = ImageIO.read(new File("assets/character_move/boy_right_2.png"));
            this.up1p = ImageIO.read(new File("assets/character_move_protected/boy_up_1.png"));
            this.up2p = ImageIO.read(new File("assets/character_move_protected/boy_up_2.png"));
            this.down1p = ImageIO.read(new File("assets/character_move_protected/boy_down_1.png"));
            this.down2p = ImageIO.read(new File("assets/character_move_protected/boy_down_2.png"));
            this.left1p = ImageIO.read(new File("assets/character_move_protected/boy_left_1.png"));
            this.left2p = ImageIO.read(new File("assets/character_move_protected/boy_left_2.png"));
            this.right1p = ImageIO.read(new File("assets/character_move_protected/boy_right_1.png"));
            this.right2p = ImageIO.read(new File("assets/character_move_protected/boy_right_2.png"));


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

    }
    public static Character getInstance() {
        if (instance == null) {
            instance = new Character(150,150, Constants.tileSize,Constants.tileSize,6);
        }
        return instance;
    }
    public void printBag(){
        for (GameObject gameObject: bag){
            System.out.println(gameObject);
        }
    }

    public void increaseLife(){
        if(life < maxLife){
            life++;
        }
    }
    public void decreaseLife(){
        if(life > 0){
            life--;
        }
    }
}
