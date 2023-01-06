package main;

import constants.Constants;
import main.controllers.GameController;
import main.models.Door;
import main.models.Furniture;
import main.models.GameObject;
import main.models.PowerUp.ExtraLife;
import main.models.PowerUp.ExtraTime;
import main.models.PowerUp.PowerUp;

import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class ItemInteractionHandler implements MouseListener {
    GameController gameController;
    public ItemInteractionHandler(GameController gameController){
        this.gameController = gameController;
    }
    public boolean checkInteraction(int mouseX, int mouseY, int type){

        // right now this just handles furniture interaction, other interactions will be handled later...
        GameObject[][] tileMap = gameController.currentRoom.tileMap;
        int tileSize = Constants.tileSize;
        int tileX = mouseX/tileSize;
        int tileY = mouseY/tileSize;

        if (tileMap[tileX][tileY] == null){
            System.out.println("No object");
            return false;
        } else if (tileMap[tileX][tileY].interactable){
            GameObject object = tileMap[tileX][tileY];
            if (object instanceof Furniture){
                if (type == 1){ // left click
                    int playerTileX = gameController.character.locationX / tileSize;
                    int playerTileY = gameController.character.locationY / tileSize;

                    if (Math.abs(playerTileX - tileX)> 2 || Math.abs(playerTileY - tileY)> 2){
                        gameController.displayedMessage = "You are not close enough";
                        Timer t = new Timer();
                        t.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                gameController.displayedMessage = "";
                            }
                        }, 1000);
                        return false;
                    }
                    System.out.println("you have clicked on furniture");
                    Furniture fur = (Furniture) tileMap[tileX][tileY];
                    if (fur.hasKey){
                        System.out.println("Key Found...");
                        gameController.character.hasKey = true;
                        BufferedImage initialImage = fur.image;
                        try {
                            fur.image = ImageIO.read(new File("assets/key.png"));
                        } catch (Exception e){
                            System.out.println(e);
                        }
                        Timer t = new Timer();
                        t.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                fur.image = initialImage;
                            }
                        }, 1000);

                        fur.hasKey = false;
                    } else {
                        gameController.displayedMessage = "Key not found";
                        Timer t = new Timer();
                        t.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                gameController.displayedMessage = "";
                            }
                        }, 1000);
                    }
                }
            } else if (object instanceof PowerUp){
                if (type == 3){
                    // right click
                    if (object instanceof ExtraLife){
                        gameController.character.increaseLife();
                        gameController.displayedMessage = "Health increased!";
                    }
                    else if (object instanceof ExtraTime){
                    	gameController.timeController.increaseTime();
                        gameController.displayedMessage = "Remaining time increased!";
                    }
                    else{
                        gameController.displayedMessage = "Picked up PowerUp!";
                        gameController.character.bag.add((PowerUp) object);
                    }
                    Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gameController.displayedMessage = "";
                        }
                    }, 1000);
                    gameController.currentRoom.tileMap[tileX][tileY] = null;
                } else {
                    return false;
                }
            }
            else if (object instanceof Door){
                int playerTileX = gameController.character.locationX / tileSize;
                int playerTileY = gameController.character.locationY / tileSize;

                if (Math.abs(playerTileX - tileX)> 2 || Math.abs(playerTileY - tileY)> 2){
                    gameController.displayedMessage = "You are not close enough";
                    Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gameController.displayedMessage = "";
                        }
                    }, 1000);
                    return false;
                }
                else {
                    if (gameController.character.hasKey){
                        gameController.character.hasKey = false;
                        gameController.changeBuilding();
                    }
                }
            }

        }
        return false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        int type = e.getButton();
        checkInteraction(mouseX,mouseY,type);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
