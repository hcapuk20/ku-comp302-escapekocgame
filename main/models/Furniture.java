package main.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
@JsonIgnoreProperties({"image","collisionArea"})
public class Furniture extends GameObject{



    static String[] imageNames = new String[] {"assets/furnitures/computer.png", "assets/furnitures/bookshelf.png",
            "assets/furnitures/chair2.png", "assets/furnitures/nightstand.png", "assets/furnitures/table.png"};
    public boolean hasKey;
    public int type;
    public Furniture(){

    }

    public Furniture(int locationX, int locationY, int width, int height, int type){
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.width = width;
        this.collidable = false;
        this.interactable = true;
        this.hasKey = false;
        this.type = type;
        try {
            this.image = ImageIO.read(new File(imageNames[type]));
        }
        catch (Exception e){

        }
    }

    public void initializeImage(){
        try {
            this.image = ImageIO.read(new File(imageNames[type]));
        }
        catch (Exception e){

        }
    }

    public static int getTotalFurnitures(){
        return imageNames.length;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image,locationX,locationY,width,height,null);
    }
}
