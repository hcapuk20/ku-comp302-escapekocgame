package main.models;

import java.awt.*;

public class Player extends GameObject{
    public int speed;
    public int stepX;
    public int stepY;
    public Player(int x, int y, int height, int width, int speed){
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        this.speed = speed;
        this.stepX = 0;
        this.stepY = 0;
    }

    public void move(){
        this.locationX += stepX;
        this.locationY += stepY;
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.drawRect(locationX,locationY,100,100);
    }



}
