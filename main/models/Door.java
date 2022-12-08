package main.models;

import javax.imageio.ImageIO;
import java.io.File;

public class Door extends GameObject{

    public Door(int locationX, int locationY, int width, int height){
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.width = width;
        this.collidable = true;
        try {
            this.image = ImageIO.read(new File("assets/open_door.png"));
        }
        catch (Exception e){
        }
    }
}
