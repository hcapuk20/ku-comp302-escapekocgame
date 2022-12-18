package main.models.PowerUp;

import constants.Constants;
import main.controllers.GameController;
import main.models.Building;
import main.models.Furniture;
import main.models.Room;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Hint extends  PowerUp{

    public Hint(int locationX, int locationY, int width, int height){
        super(locationX, locationY, width, height);
        try {
            this.image = ImageIO.read(new File("assets/powerUps/hint.png"));
        }
        catch (Exception e){
        }
    }


    public void doEffect(GameController gameController, Graphics g) {
        int hasKeyX, hasKeyY;
        boolean cont = true;
        Building currentBuilding = gameController.currentBuilding;
        for (Room[] rooms : currentBuilding.rooms){
            if (rooms == null){
                continue;
            }
            for (Room room: rooms){
                if (room == null){
                    continue;
                }
                for (Furniture furniture: room.furnitures){
                    if (furniture.hasKey){
                        hasKeyX = furniture.locationX;
                        hasKeyY = furniture.locationY;

                        if (room == gameController.currentRoom){
                            drawHint(g,hasKeyX,hasKeyY);
                        }
                        else {
                            drawMessage(g,gameController);
                        }
                        cont = false;
                        break;
                    }
                }
                if (!cont){
                    break;
                }
            }
            if (!cont){
                break;
            }
        }
    }
    public void drawHint(Graphics g, int hasKeyX, int hasKeyY){
        int tileSize = Constants.tileSize;
        int xMiddle = hasKeyX+(tileSize/2);
        int yMiddle = hasKeyY+(tileSize/2);

        int drawX = (xMiddle - (2 *tileSize));
        int drawY = (yMiddle - (2 *tileSize));


        g.setColor(Color.ORANGE);
        g.drawRect(drawX,drawY,tileSize*4,tileSize*4);
    }
    public void drawMessage(Graphics g,GameController gameController){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        int drawLocX = gameController.character.locationX -Constants.tileSize;
        int drawLocY = gameController.character.locationY -Constants.tileSize/2;
        g2.drawString("Key is not in this room",drawLocX,drawLocY);
    }

}
