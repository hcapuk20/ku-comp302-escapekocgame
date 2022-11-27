package main.controllers;

import main.models.Player;

import java.awt.*;

public class PlayerController {
    Player player;
    public int counter;
    public int animationCount;

    public PlayerController(Player player){
        this.player = player;
        this.counter = 0;
        this.animationCount = 1;
    }
    public void move(){
        player.locationX += player.stepX;
        player.locationY += player.stepY;
        counter++;
        if(counter > 15){
            if(animationCount == 1) animationCount = 2;
            else animationCount = 1;
            counter = 0;
        }
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(player.moving){
            if(player.direction.equals("up") ){
                if (animationCount == 1) player.image = player.up1;
                else player.image = player.up2;
            }
            else if (player.direction.equals("down")){
                if (animationCount == 1) player.image = player.down1;
                else player.image = player.down2;
            }
            else if (player.direction.equals("left")) {
                if (animationCount == 1) player.image = player.left1;
                else player.image = player.left2;
            }
            else {
                if (animationCount == 1) player.image = player.right1;
                else player.image = player.right2;
            }
        }
        g2.drawImage(player.image,player.locationX,player.locationY,50,50,null);
    }
}
