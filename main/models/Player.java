package main.models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Player extends GameObject{
    public int speed;
    public int stepX;
    public int stepY;

    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;

    public String direction;
    public int counter;
    public int animationCount;
    public boolean moving;
    public Player(int x, int y, int height, int width, int speed){
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        this.speed = speed;
        this.stepX = 0;
        this.stepY = 0;
        try {
            this.up1 = ImageIO.read(new File("assets/player_move/boy_up_1.png"));
            this.up2 = ImageIO.read(new File("assets/player_move/boy_up_2.png"));
            this.down1 = ImageIO.read(new File("assets/player_move/boy_down_1.png"));
            this.down2 = ImageIO.read(new File("assets/player_move/boy_down_2.png"));
            this.left1 = ImageIO.read(new File("assets/player_move/boy_left_1.png"));
            this.left2 = ImageIO.read(new File("assets/player_move/boy_left_2.png"));
            this.right1 = ImageIO.read(new File("assets/player_move/boy_right_1.png"));
            this.right2 = ImageIO.read(new File("assets/player_move/boy_right_2.png"));
        }
        catch (Exception e) {
            System.out.println(e);

        }
        this.direction = "down";
        this.image = down1;
        this.counter = 0;
        this.animationCount = 1;
        this.moving = false;
    }

    public void move(){
        this.locationX += stepX;
        this.locationY += stepY;
        counter++;
        if(counter > 15){
            if(animationCount == 1) animationCount = 2;
            else animationCount = 1;
            counter = 0;
        }

    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(moving){
            if(this.direction.equals("up") ){
                if (animationCount == 1) this.image = up1;
                else this.image = up2;
            }
            else if (this.direction.equals("down")){
                if (animationCount == 1) this.image = down1;
                else this.image = down2;
            }
            else if (this.direction.equals("left")) {
                if (animationCount == 1) this.image = left1;
                else this.image = left2;
            }
            else {
                if (animationCount == 1) this.image = right1;
                else this.image = right2;

            }
        }
        g2.drawImage(this.image,locationX,locationY,50,50,null);


    }





}
