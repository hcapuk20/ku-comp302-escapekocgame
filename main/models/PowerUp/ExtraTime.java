package main.models.PowerUp;

import javax.imageio.ImageIO;
import java.io.File;

public class ExtraTime extends PowerUp{

    public ExtraTime(int locationX, int locationY, int width, int height){
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.width = width;
        this.collidable = false;
        this.interactable = true;
        try {
            this.image = ImageIO.read(new File("assets/powerUps/extra-time.png"));
        }
        catch (Exception e){
        }
    }

    public void doEffect(Character character) {

    }
}
