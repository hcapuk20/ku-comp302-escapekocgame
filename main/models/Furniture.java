package main.models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Furniture extends GameObject{


    public Furniture(int locationX, int locationY, int width, int height, String imagePath){
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.width = width;
        try {
            this.image = ImageIO.read(new File(imagePath));
        }
        catch (Exception e){
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image,locationX,locationY,width,height,null);
    }
}
