package main.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


@JsonIgnoreProperties({"totalFurnitures"})
public class Building {

    public Room[][] rooms = new Room[3][3];
    public String name;

    public Furniture furnitureWithKey;
    public int roomX, roomY;

    int minFurniture;
    public Building(){

    }
    public Building(String name, int minFurniture) {
        setFont();
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

    public void drawMiniMap(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for(int index1 = 0; index1<3; index1++) {
            for (int index2 = 0; index2 < 3; index2++) {
                if(rooms[index1][index2] != null) {
                    rooms[index1][index2].drawMiniMap(g, index1, index2);
                }
            }
        }
    }


    private void drawNameLabel(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("GeoSlab703 Md BT", Font.BOLD, 20));
        g.drawString(name, 20, 40);
    }

    public void drawMinCountLabel(Graphics g){
        String txt = "You must place " + minFurniture + " furnitures before you continue!";
        g.setColor(Color.white);
        g.setFont(new Font("Pixeloid Sans", Font.PLAIN, 18));
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
    
    private void setFont() {
    	try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/PixeloidSans-nR3g1.ttf")));
		} catch (IOException|FontFormatException e) {
		     e.printStackTrace();
		}
    }

}
