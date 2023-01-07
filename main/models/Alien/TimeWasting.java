package main.models.Alien;

import main.controllers.GameController;
import main.models.Character;
import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TimeWasting extends Alien {

    public TimeWasting(){
        try {
            this.image = ImageIO.read(new File("assets/alien1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public TimeWasting(int x, int y, int height, int width, String alien_type, Room currentRoom) {
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
        this.collisionArea = new Rectangle(hitBoxIndex,hitBoxIndex,hitBoxSize,hitBoxSize);
        this.alien_type = alien_type;
    }


}
