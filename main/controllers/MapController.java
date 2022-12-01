package main.controllers;

import main.models.Wall;

import java.awt.*;

public class MapController {
    Wall one;

    public MapController(){
        one = new Wall(0,0,50,50);
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        one.draw(g2);
    }
}
