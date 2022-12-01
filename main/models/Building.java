package main.models;

import constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Building {

    public Room[][] rooms = new Room[3][3];
    String name;
    public Building(String name) {
        this.name = name;
    }


    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for(int index1 = 0; index1<3; index1++) {
            for (int index2 = 0; index2 < 3; index2++) {
                if(rooms[index1][index2] != null) {
                    rooms[index1][index2].drawSmall(g, index1, index2);
                    drawNameLabel(g);
                }
            }
        }
    }


    private void drawNameLabel(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Segoe Script", Font.BOLD, 20));
        g.drawString(name, 20, 40);
    }


}
