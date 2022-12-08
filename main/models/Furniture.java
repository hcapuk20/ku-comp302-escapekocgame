package main.models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Furniture extends GameObject{


    static String[] imageNames = new String[] {"assets/furnitures/bed.png", "assets/furnitures/cabinet.png",
            "assets/furnitures/chest.png", "assets/furnitures/nightstand.png", "assets/furnitures/table.png"};
    public boolean hasKey;

    public Furniture(int locationX, int locationY, int width, int height, int type){
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.width = width;
        this.collidable = false;
        this.interactable = true;
        this.hasKey = false;
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
