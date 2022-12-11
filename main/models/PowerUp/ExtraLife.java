package main.models.PowerUp;

import javax.imageio.ImageIO;
import java.io.File;

public class ExtraLife extends PowerUp {
    public ExtraLife(int locationX, int locationY, int width, int height){
        super(locationX, locationY, width, height);
        try {
            this.image = ImageIO.read(new File("assets/powerUps/extra-life.png"));
        }
        catch (Exception e){
        }
    }

    @Override
    public void doEffect(Character character) {

    }
}
