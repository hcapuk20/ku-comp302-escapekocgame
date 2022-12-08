package main.models;

import constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Building {

    public Room[][] rooms = new Room[3][3];
    String name;

    int minFurniture;
    public Building(String name, int minFurniture) {
        this.name = name;
        this.minFurniture = minFurniture;
    }

    public int getMinFurniture() {
        return minFurniture;
    }

    public int getTotalFurnitures(){
        int total = 0;
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                if(rooms[i][a] != null){
                    total += rooms[i][a].furnitures.size();
                }
            }
        }
        return total;
    }

    public boolean enoughFurnituresPlaced(){
        if(getTotalFurnitures() >= minFurniture){
            return true;
        }
        return false;
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

    public void drawMinCountLabel(Graphics g){
        String txt = "You must place " + minFurniture + " furnitures before you continue";
        g.setColor(Color.white);
        g.setFont(new Font("Segoe Script", Font.ITALIC, 15));
        g.drawString(txt, 20, Constants.WINDOW_HEIGHT-40);
    }


    public void printFurnitures(){
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                if(rooms[i][a] != null){
                    for(int j = 0; j <rooms[i][a].furnitures.size(); j++){
                        System.out.println(rooms[i][a].furnitures.get(j).hasKey);
                    }
                }
            }

        }
    }

}
