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
        BufferedImage up1p,up2p,down1p,down2p,left1p,left2p,right1p,right2p;
        BufferedImage oldUp1,oldUp2,oldDown1,oldDown2,oldLeft1,oldLeft2,oldRight1,oldRight2;
        oldUp1 = gameController.character.up1;
        oldUp2 = gameController.character.up1;
        oldDown1 = gameController.character.up1;
        oldDown2 = gameController.character.up1;
        oldLeft1 = gameController.character.up1;
        oldLeft2 = gameController.character.up1;
        oldRight1 = gameController.character.up1;
        oldRight2 = gameController.character.up1;
        gameController.character.vulnerable = false;
        try {
            up1p = ImageIO.read(new File("assets/character_move_protected/boy_up_1.png"));
            up2p = ImageIO.read(new File("assets/character_move_protected/boy_up_2.png"));
            down1p = ImageIO.read(new File("assets/character_move_protected/boy_down_1.png"));
            down2p = ImageIO.read(new File("assets/character_move_protected/boy_down_2.png"));
            left1p = ImageIO.read(new File("assets/character_move_protected/boy_left_1.png"));
            left2p = ImageIO.read(new File("assets/character_move_protected/boy_left_2.png"));
            right1p = ImageIO.read(new File("assets/character_move_protected/boy_right_1.png"));
            right2p = ImageIO.read(new File("assets/character_move_protected/boy_right_2.png"));

            // updating characters images
            gameController.character.up1 = up1p;
            gameController.character.up2 = up2p;
            gameController.character.down1 = down1p;
            gameController.character.down2 = down2p;
            gameController.character.left1 = left1p;
            gameController.character.left2 = left2p;
            gameController.character.right1 = right1p;
            gameController.character.right2 = right2p;

        } catch (Exception e){
            System.out.println(e);
        }

        // end of effect
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                // return to old images
                gameController.character.up1 = oldUp1;
                gameController.character.up2 = oldUp2;
                gameController.character.down1 = oldDown1;
                gameController.character.down2 = oldDown2;
                gameController.character.left1 = oldLeft1;
                gameController.character.left2 = oldLeft2;
                gameController.character.right1 = oldRight1;
                gameController.character.right2 = oldRight2;
                gameController.character.vulnerable = true;
            }
        }, 20000);
    }

}
