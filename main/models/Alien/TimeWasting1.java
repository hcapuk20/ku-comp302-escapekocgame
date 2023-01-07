package main.models.Alien;

import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Time;

public class TimeWasting1 extends TimeWasting implements TimeWastingInterface{

    public TimeWasting1(){
        super();
    }


    public TimeWasting1(int x, int y, int height, int width, String alien_type, Room currentRoom) {
        super(x, y, height, width, alien_type, currentRoom);
    }


    @Override
    public void specialPower(Alien alien) {


        //eren
        System.out.println("<30");






    }
}
