package main.models.Alien;

import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TimeWasting3 extends TimeWasting implements TimeWastingInterface {

    public TimeWasting3(){
        super();
    }
    int count = 0;
    public TimeWasting3(int x, int y, int height, int width, String alien_type, int roomX,int roomY) {
        super(x, y, height, width, alien_type, roomX,roomY);
    }

    @Override
    public void specialPower(Alien alien) {

        //eren
        System.out.println(">70");

        }

    }

