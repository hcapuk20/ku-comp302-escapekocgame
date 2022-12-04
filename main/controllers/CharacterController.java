package main.controllers;

import main.CollisionChecker;
import main.models.Character;

import java.awt.*;

public class CharacterController {
    Character character;
    public int counter;
    public int animationCount;
    CollisionChecker collisionChecker;
    public CharacterController(Character character, CollisionChecker collisionChecker){
        this.character = character;
        this.counter = 0;
        this.animationCount = 1;
        this.collisionChecker = collisionChecker;
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
        g2.drawImage(character.image, character.locationX, character.locationY,48,48,null);
    }
}
