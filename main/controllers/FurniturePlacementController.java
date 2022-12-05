package main.controllers;

import constants.Constants;
import main.models.Furniture;
import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import java.awt.*;

public class FurniturePlacementController {

    String[] imageNames = new String[] {"assets/furnitures/bed.png", "assets/furnitures/cabinet.png",
                                "assets/furnitures/chest.png", "assets/furnitures/nightstand.png", "assets/furnitures/table.png"};

    int selectedIndex = -1;
    int tileSize = Constants.tileSize;
    int screenWidth = Constants.WINDOW_WIDTH;
    int screenHeight = Constants.WINDOW_HEIGHT;
    int furnitureCount = 5;

    int selectedOvalLength = tileSize / 3;
    int selectedOvalX = -tileSize;
    int selectedOvalY = -tileSize;

    Furniture[] furnitures = new Furniture[furnitureCount];
    FurniturePlacementController(){
        int imageSize = tileSize*5/4;

        for(int i = 0; i<5; i++){
            furnitures[i] = new Furniture(screenWidth*7/8 - imageSize/2,(imageSize*5/4)*i + imageSize/4,
                    imageSize, imageSize, imageNames[i]);
        }

    }

    public void selectFurniture(Rectangle mouse){
        int imageSize = tileSize*5/4;
        for(int i = 0; i<5; i++){
            Rectangle obj = new Rectangle(screenWidth*7/8 - imageSize/2,(imageSize*5/4)*i + imageSize/4,
                    imageSize, imageSize);
            if (mouse.intersects(obj)) {
                selectedOvalX = screenWidth - tileSize;
                selectedOvalY = (int)obj.getY() + imageSize/2;
                selectedIndex = i;
                break;
            }
        }
    }


    public void draw(Graphics2D g2){
        for(int i = 0; i<furnitureCount; i++)
        {
            furnitures[i].draw(g2);
            g2.fillOval(selectedOvalX,selectedOvalY- selectedOvalLength/2,selectedOvalLength,selectedOvalLength);
        }
    }

}
