package main.controllers;

import constants.Constants;
import main.models.Furniture;
import main.models.PowerUp.*;
import main.models.PowerUp.PowerUp;

import javax.swing.*;
import java.awt.*;

public class BagController {

    int screenWidth = Constants.WINDOW_WIDTH;
    int screenHeight = Constants.WINDOW_HEIGHT;
    int tileSize = Constants.tileSize;

    GameController gameController;
    int imageSize = tileSize*8/10;

    public BagController(GameController gameController){
        this.gameController = gameController;
    }


    void drawFrames(Graphics g){
        Image frameImage = new ImageIcon("assets/bagFrame.png").getImage();

        for(int i = 0; i<3; i++) {
            g.drawImage(frameImage, screenWidth / 4 + i*tileSize, (tileSize - imageSize) / 2,
                    imageSize, imageSize, gameController);
        }

    }

    void drawPowerUps(Graphics g){
        boolean[] contain = new boolean[3];
        for(PowerUp p: gameController.character.bag){
            if(p instanceof Hint){
                contain[0] = true;
            } else if(p instanceof PlasticBottle){
                contain[1] = true;
            } else if(p instanceof ProtectionVest){
                contain[2] = true;
            }
        }

        int powerUpSize = tileSize*7/10;

        Image hintImage = new ImageIcon("assets/powerUps/hint.png").getImage();
        Image bottleImage = new ImageIcon("assets/powerUps/plastic-bottle.png").getImage();
        Image vestImage = new ImageIcon("assets/powerUps/protection-vest.png").getImage();
        Image[] images = {hintImage, bottleImage, vestImage};

        for(int i = 0; i<3; i++) {
            if(contain[i]){
                g.drawImage(images[i], screenWidth / 4 + i*tileSize + (imageSize-powerUpSize)/2, (tileSize - powerUpSize) / 2,
                        powerUpSize, powerUpSize, gameController);
            }
        }

    }



    void draw(Graphics g){

        drawFrames(g);
        drawPowerUps(g);

    }



}
