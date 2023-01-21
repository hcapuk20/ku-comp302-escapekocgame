package main.controllers;

import constants.Constants;
import main.models.Furniture;
import main.models.PowerUp.*;
import main.models.PowerUp.PowerUp;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BagController {

    int screenWidth = Constants.WINDOW_WIDTH;
    int screenHeight = Constants.WINDOW_HEIGHT;
    int tileSize = Constants.tileSize;

    GameController gameController;
    int imageSize = tileSize*8/10;
    int numberBackgroundSize = tileSize*6/10;

    public BagController(GameController gameController){
    	this.gameController = gameController;  
    }
    
    

    void drawFrames(Graphics g){
        Image frameImage = new ImageIcon("assets/bagFrame.png").getImage();
        g.setColor(Color.black);

        g.drawImage(frameImage, screenWidth / 4 - (tileSize+numberBackgroundSize), (tileSize - imageSize) / 2,
                imageSize, imageSize, gameController); //frame for the key

        for(int i = 0; i<3; i++) {
            g.fillRect(screenWidth / 4 + i*(tileSize+numberBackgroundSize) - numberBackgroundSize, (tileSize - numberBackgroundSize) / 2,
                    numberBackgroundSize, numberBackgroundSize);
            g.drawImage(frameImage, screenWidth / 4 + i*(tileSize+numberBackgroundSize), (tileSize - imageSize) / 2,
                    imageSize, imageSize, gameController);
        }

    }

    void drawPowerUps(Graphics g){
        int[] contain = new int[3];
        for(PowerUp p: gameController.character.bag){
            if(p instanceof Hint){
                contain[0] ++;
            } else if(p instanceof PlasticBottle){
                contain[1] ++;
            } else if(p instanceof ProtectionVest){
                contain[2] ++;
            }
        }

        int powerUpSize = tileSize*7/10;

        Image hintImage = new ImageIcon("assets/powerUps/hint.png").getImage();
        Image bottleImage = new ImageIcon("assets/powerUps/plastic-bottle.png").getImage();
        Image vestImage = new ImageIcon("assets/powerUps/protection-vest.png").getImage();
        Image[] images = {hintImage, bottleImage, vestImage};


        int numberSize = tileSize/2;

        if(gameController.character.hasKey){
            Image keyImage = new ImageIcon("assets/key.png").getImage();
            g.drawImage(keyImage, screenWidth / 4 - (tileSize+numberBackgroundSize) + (imageSize-powerUpSize)/2, (tileSize - powerUpSize) / 2,
                    powerUpSize, powerUpSize, gameController);
        }

        for(int i = 0; i<3; i++) {

            g.setFont(new Font("Pixeloid Sans", Font.PLAIN, 16));
            g.setColor(Color.white);

            g.drawString(contain[i] + "",
                    screenWidth / 4 + i*(tileSize+numberBackgroundSize) - numberBackgroundSize + 6,
                    (tileSize+numberBackgroundSize/2)/2+1);

            g.drawImage(images[i], screenWidth / 4 + i*(tileSize+numberBackgroundSize) + (imageSize-powerUpSize)/2, (tileSize - powerUpSize) / 2,
                    powerUpSize, powerUpSize, gameController);

        }

    }



    void draw(Graphics g){

        drawFrames(g);
        drawPowerUps(g);

    }



}
