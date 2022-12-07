package main;

import constants.Constants;
import main.controllers.GameController;
import main.models.Furniture;
import main.models.GameObject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemInteractionHandler implements MouseListener {
    GameController gameController;
    public ItemInteractionHandler(GameController gameController){
        this.gameController = gameController;
    }
    public boolean checkInteraction(int mouseX, int mouseY){

        // right now this just handles furniture interaction, other interactions will be handled later...
        GameObject[][] tileMap = gameController.currentRoom.tileMap;
        int tileSize = Constants.tileSize;
        int tileX = mouseX/tileSize;
        int tileY = mouseY/tileSize;

        if (tileMap[tileX][tileY] == null){
            System.out.println("No object");
            return false;
        } else if (tileMap[tileX][tileY].interactable){
            int playerTileX = gameController.character.locationX / tileSize;
            int playerTileY = gameController.character.locationY / tileSize;

            if (Math.abs(playerTileX - tileX)> 2 || Math.abs(playerTileY - tileY)> 2){
                System.out.println("You are not close enough");
                return false;
            }
            System.out.println("you have clicked on furniture");
            Furniture fur = (Furniture) tileMap[tileX][tileY];
            if (fur.hasKey){
                System.out.println("Key Found...");
                fur.hasKey = false;
            } else {
                System.out.println("Key Not Found...");
            }
        }
        return false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        checkInteraction(mouseX,mouseY);
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
