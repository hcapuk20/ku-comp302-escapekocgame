package main.models.PowerUp;

import main.controllers.GameController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class ProtectionVest extends PowerUp{

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
