package main.models.Alien;

import main.controllers.FurniturePlacementController;
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
    public TimeWasting3(int x, int y, int height, int width, String alien_type, int roomX,int roomY, int currentBuilding) {
        super(x, y, height, width, alien_type, roomX,roomY,currentBuilding);

    }

    @Override
    public void specialPower(Alien alien) {

        FurniturePlacementController furniturePlacementController = new FurniturePlacementController();
        furniturePlacementController.randomizeKey(currentBuilding);

        System.out.println(">70");
        System.out.println(currentBuilding);

        }

    }

