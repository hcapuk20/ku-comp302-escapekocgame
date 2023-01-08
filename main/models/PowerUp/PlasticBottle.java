package main.models.PowerUp;

import constants.Constants;
import main.controllers.GameController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class PlasticBottle extends PowerUp {
    public PlasticBottle(){

    }

    public PlasticBottle(int locationX, int locationY, int width, int height){
        super(locationX, locationY, width, height);
        try {
            this.image = ImageIO.read(new File("assets/powerUps/plastic-bottle.png"));
        }
        catch (Exception e){
        }
    }


    public void doEffect(GameController gameController, Graphics g, String bottleDirection) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.image,locationX,locationY,width,height,null);
        if (bottleDirection.equals("up")){
            locationY -= 5;
        } else if (bottleDirection.equals("left")){
            locationX -= 5;
        } else if (bottleDirection.equals("right")){
            locationX += 5;
        } else {
            locationY += 5;
        }
        if (locationX <= Constants.tileSize || locationX > Constants.WINDOW_WIDTH - Constants.tileSize || locationY <= Constants.tileSize || locationY > Constants.WINDOW_HEIGHT-Constants.tileSize){
            gameController.powerUpController.bottleUsed = false;
        }
    }
}
