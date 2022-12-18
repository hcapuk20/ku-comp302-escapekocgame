package main.models.PowerUp;

import javax.imageio.ImageIO;
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
    public void doEffect(Character character) {

    }


}
