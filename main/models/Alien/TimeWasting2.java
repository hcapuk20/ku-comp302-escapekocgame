package main.models.Alien;

import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TimeWasting2  extends TimeWasting implements TimeWastingInterface {
    public TimeWasting2(){
        super();
    }

    public TimeWasting2(int x, int y, int height, int width, String alien_type, int roomX,int roomY, int currentBuilding) {
        super(x, y, height, width, alien_type, roomX,roomY,currentBuilding);

    }

    @Override
    public void specialPower(Alien alien) {
        System.out.println("30 70");


        }
}
