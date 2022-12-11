package main.controllers;

import constants.Constants;
import main.CollisionChecker;
import main.models.Alien;
import main.models.GameObject;

import java.awt.*;
import java.util.Random;

import static constants.Constants.WINDOW_HEIGHT;
import static constants.Constants.WINDOW_WIDTH;

public class AlienController {

    public int counter;
    public int animationCount;
    CollisionChecker collisionChecker;
    GameController gameController;
    Random rand = new Random();

    String[] alienTypes = {"blind", "shooter", "time-wasting"};

    public AlienController(CollisionChecker collisionChecker, GameController gameController) {


        this.collisionChecker = collisionChecker;
        this.gameController = gameController;
        this.counter = 0;
        this.animationCount = 1;
    }

    public void move(Alien alien) {
        if (alien.moving && alien.direction.equals("up")) {
            if (!collisionChecker.checkCollision(alien)) {
                alien.locationY -= alien.speed;
            }
        } else if (alien.moving && alien.direction.equals("down")) {
            if (!collisionChecker.checkCollision(alien)) {
                alien.locationY += alien.speed;
            }
        } else if (alien.moving && alien.direction.equals("left")) {
            if (!collisionChecker.checkCollision(alien)) {
                alien.locationX -= alien.speed;
            }
        } else if (alien.moving && alien.direction.equals("right")) {
            if (!collisionChecker.checkCollision(alien)) {
                alien.locationX += alien.speed;
            }
        }
        //System.out.println(alien.locationY);
        if (alien.locationX < 0) {
            alien.locationX = WINDOW_WIDTH - 50;
            gameController.roomCountX -= 1;
            //mapController.roomsX-=1;
            //mapController.initializeRoom();
        } else if (alien.locationX > WINDOW_WIDTH) {
            alien.locationX = 50;
            gameController.roomCountX += 1;
            //mapController.roomsX+=1;
        } else if (alien.locationY < 0) {
            alien.locationY = WINDOW_HEIGHT - 50;
            gameController.roomCountY -= 1;
            //mapController.roomsY-=1;
        } else if (alien.locationY > WINDOW_HEIGHT) {
            alien.locationY = 50;
            gameController.roomCountY += 1;
            //mapController.roomsY+=1;
        }
        counter++;
        if (counter > 15) {
            if (animationCount == 1) animationCount = 2;
            else animationCount = 1;
            counter = 0;
        }
    }


    public void spawnAlien(Alien[] aliens) {
        GameObject[][] tileMap = gameController.currentRoom.tileMap;
        int randomXTile = rand.nextInt(tileMap.length);

        int randomYTile = rand.nextInt(tileMap[0].length);

        while (tileMap[randomXTile][randomYTile] != null){
            randomXTile = rand.nextInt(tileMap.length);
            randomYTile = rand.nextInt(tileMap[0].length);
        }
        int randomType = rand.nextInt(alienTypes.length-1);

            Alien alien = new Alien(randomXTile* Constants.tileSize,randomYTile* Constants.tileSize, Constants.tileSize, Constants.tileSize, alienTypes[randomType]);

        //add other powerUps here.

        tileMap[randomXTile][randomYTile] = alien;
        for(int i = 0; i<aliens.length; i++){
            if (aliens[i] == null){
                aliens[i] = alien;
                break;
            }
        }

        //gameController.alien[0] = new Alien(rand.nextInt(WINDOW_WIDTH), rand.nextInt(WINDOW_HEIGHT), Constants.tileSize, Constants.tileSize, alienTypes[rand.nextInt(2)]);

    }

    public void draw(Graphics g, Alien alien){
        Graphics2D g2 = (Graphics2D) g;
        if(alien.moving){
            if(alien.direction.equals("up") ){
                if (animationCount == 1) alien.image = alien.up1;
                else alien.image = alien.up2;
            }
            else if (alien.direction.equals("down")){
                if (animationCount == 1) alien.image = alien.down1;
                else alien.image = alien.down2;
            }
            else if (alien.direction.equals("left")) {
                if (animationCount == 1) alien.image = alien.left1;
                else alien.image = alien.left2;
            }
            else {
                if (animationCount == 1) alien.image = alien.right1;
                else alien.image = alien.right2;
            }
        }
        g2.drawImage(alien.image, alien.locationX, alien.locationY,alien.width,alien.height,null);
    }
}
