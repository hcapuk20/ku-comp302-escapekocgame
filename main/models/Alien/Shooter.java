package main.models.Alien;

import constants.Constants;
import main.models.Room;
import main.models.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Shooter extends Alien{
    private int count = 0;
    public Shooter(int x, int y, int height, int width, String alien_type, Room currentRoom) {
        this.locationX = x;
        this.locationY = y;
        this.height = height;
        this.width = width;
        this.current_room = currentRoom;
        try {
            this.image = ImageIO.read(new File("assets/alien2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.collidable = true;
        int hitBoxIndex = width/6;
        int hitBoxSize = width - (2 * hitBoxIndex);
        this.collisionArea = new Rectangle(hitBoxIndex,hitBoxIndex,hitBoxSize,hitBoxSize);
        this.alien_type = alien_type;
    }
    public void specialPower(Character player, Room room){
        count++;
        if(count == 100) {

            count = 0;

            if(player.locationX < this.locationX+4 * Constants.tileSize && player.locationX > this.locationX-4 * Constants.tileSize && player.locationY < this.locationY+4 * Constants.tileSize && player.locationY > this.locationY-4 * Constants.tileSize && this.current_room == room ){
                player.life --;
                System.out.println(player.life);
                //protection vest için modify edilecek
            }}
    }

}

