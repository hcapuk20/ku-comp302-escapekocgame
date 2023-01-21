package main.models.Alien;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import main.models.GameObject;
import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Alien extends GameObject {
    //public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public boolean moving;
    public String alien_type;
    public Room current_room;
    public int roomX;
    public int roomY;

    public static int timeWaste1Count = 0;
    public static int timeWaste2Count = 0;
    public static int timeWaste3count = 0;

    public static Alien[] aliens = new Alien[100];

    public Alien() {
    }

}

