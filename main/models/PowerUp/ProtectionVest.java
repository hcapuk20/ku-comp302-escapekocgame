package main.models.PowerUp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import main.controllers.GameController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
@JsonIgnoreProperties({"image"})
public class ProtectionVest extends PowerUp{

    public ProtectionVest(){

    }
    public ProtectionVest(int locationX, int locationY, int width, int height){
        super(locationX, locationY, width, height);
        try {
            this.image = ImageIO.read(new File("assets/powerUps/protection-vest.png"));
        }
        catch (Exception e){
        }
    }


    public void doEffect(GameController gameController) {
        gameController.character.vulnerable = false;
        // end of effect
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                gameController.character.vulnerable = true;
            }
        }, 20000);
    }

}
