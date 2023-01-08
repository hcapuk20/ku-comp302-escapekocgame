package main.models.PowerUp;

import main.controllers.GameController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class ExtraLife extends PowerUp {
    public ExtraLife(){

    }
    public ExtraLife(int locationX, int locationY, int width, int height){
        super(locationX, locationY, width, height);
        try {
            this.image = ImageIO.read(new File("assets/powerUps/extra-life.png"));
        }
        catch (Exception e){
        }
    }


    public void doEffect(GameController gameController, Graphics g) {
        
    }

}
