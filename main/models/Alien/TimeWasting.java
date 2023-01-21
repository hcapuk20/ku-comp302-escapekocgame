package main.models.Alien;

import main.controllers.GameController;
import main.models.Character;
import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TimeWasting extends Alien {

    int currentBuilding;

    public TimeWasting(){
        try {
            this.image = ImageIO.read(new File("assets/alien1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public TimeWasting(int x, int y, int height, int width, String alien_type, Room currentRoom, int currentBuilding) {
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        this.current_room = currentRoom;
        try {
            this.image = ImageIO.read(new File("assets/alien1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.collidable = true;
        int hitBoxIndex = width/6;
        int hitBoxSize = width - (2 * hitBoxIndex);
        this.alien_type = alien_type;
        this.currentBuilding = currentBuilding;
    }


}
