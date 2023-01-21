package main.models.Alien;

import main.controllers.FurniturePlacementController;
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


    public TimeWasting1(int x, int y, int height, int width, String alien_type, Room currentRoom, int currentBuilding) {
        super(x, y, height, width, alien_type, currentRoom, currentBuilding);
    }


    @Override
    public void specialPower(Alien alien) {


        FurniturePlacementController furniturePlacementController = new FurniturePlacementController();
        furniturePlacementController.randomizeKey(currentBuilding);

        System.out.println("<30");
        System.out.println(currentBuilding);






    }
}
