package main.models.PowerUp;

import main.controllers.GameController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class PlasticBottle extends PowerUp {

    public PlasticBottle(int locationX, int locationY, int width, int height){
        super(locationX, locationY, width, height);
        try {
            this.image = ImageIO.read(new File("assets/powerUps/plastic-bottle.png"));
        }
        catch (Exception e){
        }
    }

    @Override
    public void doEffect(GameController gameController, Graphics g) {

    }
}
