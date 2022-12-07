package main.controllers;

import constants.Constants;
import main.models.BuildingsDataSource;
import main.models.Furniture;
import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import java.awt.*;

public class FurniturePlacementController {

    int selectedIndex = -1;
    int tileSize = Constants.tileSize;
    int screenWidth = Constants.WINDOW_WIDTH;
    int screenHeight = Constants.WINDOW_HEIGHT;
    int furnitureCount = 5;
    int selectedOvalX = -tileSize;
    int selectedOvalY = -tileSize;

    int divider = Constants.buildingModeDivider;

    int imageSize = screenWidth/(divider*4);

    int selectedOvalLength = imageSize / 4;

    Furniture[] furnitures = new Furniture[furnitureCount];
    FurniturePlacementController(){

        for(int i = 0; i<5; i++){
            furnitures[i] = new Furniture(screenWidth*7/8 - imageSize/2,(imageSize*5/4)*i + imageSize/4,
                    imageSize, imageSize, i);
        }

    }

    public void selectFurniture(Rectangle mouse){
        for(int i = 0; i<5; i++){
            Rectangle obj = new Rectangle(screenWidth*7/8 - imageSize/2,(imageSize*5/4)*i + imageSize/4,
                    imageSize, imageSize);
            if (mouse.intersects(obj)) {
                selectedOvalX = screenWidth*7/8 + imageSize/2 + 20;
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

    public void addFurnitureToRoom(Rectangle mouse, int currentBuilding){
        if(selectedIndex != -1){
            int width = screenWidth / divider;
            int height = screenHeight / divider;
            int mouseX = (int)mouse.getX();
            int mouseY = (int)mouse.getY();

            for(int x = 0; x<3; x++){
                for(int y = 0; y<3; y++){
                    if(mouseX < width*(x+1) && mouseX > width*x && mouseY < (height/2 + height*(y+1)) && mouseY > (height/2 + height*y)){
                        int tileX = (mouseX - width * x) * divider;
                        int tileY = (mouseY - height / 2 - height * y) * divider;
                        int tileMapLocX = tileX / tileSize * tileSize;
                        int tileMapLocY = tileY / tileSize * tileSize;
                        //divided ant multiplied to eliminate the error caused by doubles
                        if(tileMapLocX>tileSize && tileMapLocX<screenWidth-tileSize && tileMapLocY>tileSize && tileMapLocY<screenHeight-tileSize) {
                            Furniture furniture = new Furniture(tileMapLocX, tileMapLocY, tileSize, tileSize, selectedIndex);
                            if (BuildingsDataSource.buildings[currentBuilding].rooms[x][y] != null) {
                                if(BuildingsDataSource.buildings[currentBuilding].rooms[x][y].tileMap[tileX / tileSize][tileY / tileSize] == null) {
                                    BuildingsDataSource.buildings[currentBuilding].rooms[x][y].tileMap[tileX / tileSize][tileY / tileSize] = furniture;
                                    BuildingsDataSource.buildings[currentBuilding].rooms[x][y].furnitures.add(furniture);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
