package main.controllers;

import constants.Constants;
import main.models.BuildingsDataSource;
import main.models.Furniture;
import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FurniturePlacementController {

    int selectedIndex = -1;
    int tileSize = Constants.tileSize;
    int screenWidth = Constants.WINDOW_WIDTH;
    int screenHeight = Constants.WINDOW_HEIGHT;
    int furnitureCount = 5;
    int selectedOvalX = -tileSize;
    int selectedOvalY = -tileSize;

    int divider = Constants.buildingModeDivider;

    int imageSize = screenWidth/(divider*5);

    int selectedOvalLength = imageSize / 4;

    Image randomizeImage = new ImageIcon("assets/question_mark.png").getImage();
    Furniture[] furnitures = new Furniture[furnitureCount];
    BuildingMode buildingMode;
    FurniturePlacementController(BuildingMode buildingMode){
        this.buildingMode = buildingMode;

        for(int i = 0; i<5; i++){
            furnitures[i] = new Furniture(screenWidth*7/8 - imageSize/2,(imageSize*5/4)*i + imageSize/4,
                    imageSize, imageSize, i);
        }

    }

    private void paintRandomButton(Graphics g){
        g.drawImage(randomizeImage, screenWidth*7/8 - imageSize/2,
                (imageSize*5/4)*Furniture.getTotalFurnitures() + imageSize/4,
                imageSize, imageSize, buildingMode);
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

    public void clickRandomButton(Rectangle mouse){
        Rectangle obj = new Rectangle(screenWidth*7/8 - imageSize/2,(imageSize*5/4)*Furniture.getTotalFurnitures() + imageSize/4,
                imageSize, imageSize);
        if (mouse.intersects(obj)) {
            addRandomFurnitures(buildingMode.getCurrentBuilding());
        }
    }

    public void draw(Graphics2D g2){
        for(int i = 0; i<furnitureCount; i++)
        {
            furnitures[i].draw(g2);
            g2.fillOval(selectedOvalX,selectedOvalY- selectedOvalLength/2,selectedOvalLength,selectedOvalLength);
        }
        paintRandomButton(g2);
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

    public void addRandomFurnitures(int currentBuilding){
        int existingRooms[] = new int[9];
        int totalRoom = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(BuildingsDataSource.buildings[currentBuilding].rooms[i][j] != null){
                    existingRooms[totalRoom++] = 3*i+j;
                }
            }
        }

        Random rand = new Random();
        int furnitureCount =  BuildingsDataSource.buildings[currentBuilding].getMinFurniture();
        furnitureCount += rand.nextInt(15);

        int totalTileHorizontal = screenWidth/tileSize;
        int totalTileVertical = screenHeight/tileSize;

        for(int a = 0; a<furnitureCount; a++){
            int roomIndex = rand.nextInt(totalRoom);
            int tileX = 1 + rand.nextInt(totalTileHorizontal-2);
            int tileY = 1 + rand.nextInt(totalTileVertical - 2);
            int furnitureID = rand.nextInt(Furniture.getTotalFurnitures());
            int turn = 0;
            while(turn < 40){
                if(BuildingsDataSource.buildings[currentBuilding].rooms[existingRooms[roomIndex]/3][existingRooms[roomIndex]%3].tileMap[tileX][tileY]
                        == null){
                    Furniture furniture = new Furniture(tileX*tileSize, tileSize*tileY, tileSize, tileSize, furnitureID);
                    BuildingsDataSource.buildings[currentBuilding].rooms[existingRooms[roomIndex]/3][existingRooms[roomIndex]%3].tileMap[tileX][tileY]
                            = furniture;
                    BuildingsDataSource.buildings[currentBuilding].rooms[existingRooms[roomIndex]/3][existingRooms[roomIndex]%3].furnitures.add(furniture);
                    turn = 50;
                    break;
                } else {
                    roomIndex = rand.nextInt(totalRoom);
                    tileX = 1 + rand.nextInt(totalTileHorizontal-2);
                    tileY = 1 + rand.nextInt(totalTileVertical - 2);
                    turn++;
                }
            }
        }

    }


    public void addKey(int currentBuilding){
        int totalFurnitures = BuildingsDataSource.buildings[currentBuilding].getTotalFurnitures();
        Random rand = new Random();
        int furnitureIndex = rand.nextInt(totalFurnitures);
        boolean added = false;

        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                if(BuildingsDataSource.buildings[currentBuilding].rooms[i][a] != null){
                    int roomTotalFurnitures = BuildingsDataSource.buildings[currentBuilding].rooms[i][a].furnitures.size();
                    if(roomTotalFurnitures > furnitureIndex){
                        BuildingsDataSource.buildings[currentBuilding].rooms[i][a].furnitures.get(furnitureIndex).hasKey = true;
                        added = true;
                        break;
                    }
                    furnitureIndex -= roomTotalFurnitures;
                }
            }
            if(added == true){
                break;
            }
        }
    }

}
