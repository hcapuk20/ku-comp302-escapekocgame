package main.models.PowerUp;

import javax.imageio.ImageIO;
import java.io.File;

public class ExtraLife extends PowerUp {
    public ExtraLife(int locationX, int locationY, int width, int height){
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.width = width;
        this.collidable = false;
        this.interactable = true;
        try {
            this.image = ImageIO.read(new File("assets/powerUps/extra-life.png"));
        }
        catch (Exception e){
        }
    }

    public void doEffect(Character character) {

    }
}
