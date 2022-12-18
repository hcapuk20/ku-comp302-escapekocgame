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

    @Override
    public void doEffect(GameController gameController, Graphics g) {
        int hasKeyX, hasKeyY;
        Room hasKeyRoom;
        boolean cont = true;
        Building currentBuilding = gameController.currentBuilding;
        for (Room[] rooms : currentBuilding.rooms){
            for (Room room: rooms){
                for (Furniture furniture: room.furnitures){
                    if (furniture.hasKey){
                        hasKeyX = furniture.locationX;
                        hasKeyY = furniture.locationY;

                        hasKeyRoom = room;
                        drawHint(g,hasKeyX,hasKeyY,hasKeyRoom);
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
    public void drawHint(Graphics g, int hasKeyX, int hasKeyY, Room hasKeyRoom){
        int tileSize = Constants.tileSize;
        int xMiddle = hasKeyX+(tileSize/2);
        int yMiddle = hasKeyY+(tileSize/2);

        int drawX =(int) (xMiddle - (1.5 *tileSize));
        int drawY =(int) (yMiddle - (1.5 *tileSize));


        g.setColor(Color.ORANGE);
        g.drawRect(drawX,drawY,tileSize*4,tileSize*4);
    }

}
