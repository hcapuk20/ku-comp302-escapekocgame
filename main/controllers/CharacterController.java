package main.controllers;

import main.CollisionChecker;
import main.models.Character;

import java.awt.*;

import static constants.Constants.WINDOW_HEIGHT;
import static constants.Constants.WINDOW_WIDTH;

public class CharacterController {
    Character character;
    public int counter;
    public int animationCount;
    CollisionChecker collisionChecker;
    GameController gameController;
    public CharacterController(Character character, CollisionChecker collisionChecker,GameController gameController){
        this.character = character;
        this.counter = 0;
        this.animationCount = 1;
        this.collisionChecker = collisionChecker;
        this.gameController = gameController;
    }
    public void move(){
        //System.out.printf("x: %d y: %d\n",character.locationX,character.locationY);
        if (character.moving &&  character.direction.equals("up")){
            if (!collisionChecker.checkCollision(character)){
                character.locationY -= character.speed;
            }
        } else if (character.moving && character.direction.equals("down")){
            if (!collisionChecker.checkCollision(character)){
                character.locationY += character.speed;
            }
        } else if (character.moving && character.direction.equals("left")){
            if (!collisionChecker.checkCollision(character)){
                character.locationX -= character.speed;
            }
        } else if (character.moving && character.direction.equals("right")){
            if (!collisionChecker.checkCollision(character)){
                character.locationX += character.speed;
            }
        }
        //System.out.println(character.locationY);
        if (character.locationX < 0){
            character.locationX = WINDOW_WIDTH - 50;
            gameController.roomCountX-=1;
            //mapController.roomsX-=1;
            //mapController.initializeRoom();
        }
        else if (character.locationX > WINDOW_WIDTH) {
            character.locationX = 50;
            gameController.roomCountX+=1;
            //mapController.roomsX+=1;
        }
        else if (character.locationY < 0) {
            character.locationY = WINDOW_HEIGHT - 50;
            gameController.roomCountY-=1;
            //mapController.roomsY-=1;
        }
        else if (character.locationY > WINDOW_HEIGHT) {
            character.locationY = 50;
            gameController.roomCountY+=1;
            //mapController.roomsY+=1;
        }
        counter++;
        if(counter > 15){
            if(animationCount == 1) animationCount = 2;
            else animationCount = 1;
            counter = 0;
        }
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(character.moving){
            if(character.direction.equals("up") ){
                if (animationCount == 1) character.image = character.up1;
                else character.image = character.up2;
            }
            else if (character.direction.equals("down")){
                if (animationCount == 1) character.image = character.down1;
                else character.image = character.down2;
            }
            else if (character.direction.equals("left")) {
                if (animationCount == 1) character.image = character.left1;
                else character.image = character.left2;
            }
            else {
                if (animationCount == 1) character.image = character.right1;
                else character.image = character.right2;
            }
        }
        g2.drawImage(character.image, character.locationX, character.locationY,character.width,character.height,null);
    }
    public void drawLife(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int lifeCount = character.life;
        int Xdistance = 250;
        for (int i = 0; i < lifeCount;i++){
            g2.drawImage(character.fullHeart, WINDOW_WIDTH-Xdistance,5,30,30,null);
            Xdistance-=40;
        }
        for (int i = lifeCount; i < character.maxLife;i++){
            g2.drawImage(character.emptyHeart, WINDOW_WIDTH-Xdistance,5,30,30,null);
            Xdistance-=40;
        }
    }
}
