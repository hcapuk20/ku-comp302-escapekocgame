package main.models;

import javax.imageio.ImageIO;
import java.io.File;

public class Furniture extends GameObject{


    public boolean hasKey;

    public Furniture(int locationX, int locationY, int width, int height, int type){
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.width = width;
        this.collidable = false;
        this.interactable = true;
        try {
            this.image = ImageIO.read(new File("assets/furnitures/chest.png"));
        }
        catch (Exception e){

        }
    }
}
