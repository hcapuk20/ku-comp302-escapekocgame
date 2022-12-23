package main.controllers;

import constants.Constants;
import main.CollisionChecker;
import main.models.Alien.Alien;
import main.models.Alien.Blind;
import main.models.Alien.Shooter;
import main.models.Alien.TimeWasting;
import main.models.Character;
import main.models.GameObject;

import java.awt.*;
import java.util.Random;

import static constants.Constants.WINDOW_HEIGHT;
import static constants.Constants.WINDOW_WIDTH;

public class AlienController implements Runnable {

    Thread alienThread;
    public int counter;
    public int animationCount;
    CollisionChecker collisionChecker;

    Character player;
    GameController gameController;
    Random rand = new Random();

    String[] alienTypes = {"shooter", "time-wasting", "blind"};

    public AlienController(CollisionChecker collisionChecker, GameController gameController, Character player) {


        this.collisionChecker = collisionChecker;
        this.gameController = gameController;
        this.counter = 0;
        this.animationCount = 1;
        this.player = player;
    }

    public void move(Alien alien) {
        if (alien.moving && alien.direction.equals("up")) {
            if (!collisionChecker.checkCollision(alien)) {

                if(alien.locationY < 44){

                }
                else{
                    alien.locationY -= alien.speed;
                }
                //System.out.println(alien.locationY);
            }
        } else if (alien.moving && alien.direction.equals("down")) {
            if (!collisionChecker.checkCollision(alien)) {

                if(alien.locationY > WINDOW_HEIGHT-44 ){

                }
                else{
                    alien.locationY += alien.speed;
                }
                //System.out.println(alien.locationY);
            }
        } else if (alien.moving && alien.direction.equals("left")) {
            if (!collisionChecker.checkCollision(alien)) {

                if(alien.locationX < 44){

                }
                else{
                    alien.locationX -= alien.speed;
                };
            }
        } else if (alien.moving && alien.direction.equals("right")) {
            if (!collisionChecker.checkCollision(alien)) {

                if(alien.locationX > WINDOW_WIDTH-44 ){

                }
                else{
                    alien.locationX += alien.speed;
                }
            }
        }
        //System.out.println(alien.locationY);
        /*if (alien.locationX < 0) {
            alien.locationX = 0;
            //gameController.roomCountX -= 1;
            //mapController.roomsX-=1;
            //mapController.initializeRoom();
        } else if (alien.locationX > WINDOW_WIDTH) {
            alien.locationX = WINDOW_WIDTH;
            //gameController.roomCountX += 1;
            //mapController.roomsX+=1;
        } else if (alien.locationY < 40) {
            alien.locationY = 50;
            //gameController.roomCountY -= 1;
            //mapController.roomsY-=1;
        } else if (alien.locationY > WINDOW_HEIGHT-40) {
            alien.locationY = WINDOW_HEIGHT-40;
            //gameController.roomCountY += 1;
            //mapController.roomsY+=1;
        }*/
        /*counter++;
        if (counter > 15) {
            if (animationCount == 1) animationCount = 2;
            else animationCount = 1;
            counter = 0;
        }*/
    }


    public void spawnAlien() {
        Alien tempAlien;
        GameObject[][] tileMap = gameController.currentRoom.tileMap;
        int randomXTile = rand.nextInt(tileMap.length);

        int randomYTile = rand.nextInt(tileMap[0].length);

        while (tileMap[randomXTile][randomYTile] != null){
            randomXTile = rand.nextInt(tileMap.length);
            randomYTile = rand.nextInt(tileMap[0].length);
        }
        int randomType = 2;
                //rand.nextInt(alienTypes.length);
        if(alienTypes[randomType].equals("shooter")){
            tempAlien = new Shooter(randomXTile * Constants.tileSize, randomYTile * Constants.tileSize, Constants.tileSize, Constants.tileSize, alienTypes[randomType],gameController.currentRoom);
        }
        else if (alienTypes[randomType].equals("time-wasting")) {
            tempAlien = new TimeWasting(randomXTile * Constants.tileSize, randomYTile * Constants.tileSize, Constants.tileSize, Constants.tileSize, alienTypes[randomType],gameController.currentRoom);
        }
        else {
            tempAlien = new Blind(randomXTile * Constants.tileSize, randomYTile * Constants.tileSize, Constants.tileSize, Constants.tileSize, alienTypes[randomType],gameController.currentRoom);

        }
        //add other powerUps here.

        //tileMap[randomXTile][randomYTile] = alien;
        for(int i = 0; i<Alien.aliens.length; i++){
            if (Alien.aliens[i] == null){

                Alien.aliens[i] = tempAlien;
                break;
            }

        }


        //gameController.alien[0] = new Alien(rand.nextInt(WINDOW_WIDTH), rand.nextInt(WINDOW_HEIGHT), Constants.tileSize, Constants.tileSize, alienTypes[rand.nextInt(2)]);

    }

    public void draw(Graphics g, Alien alien){
        Graphics2D g2 = (Graphics2D) g;
        /*if(alien.moving){
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
        }*/
        g2.drawImage(alien.image, alien.locationX, alien.locationY,alien.width,alien.height,null);

    }

    @Override
    public void run() {
        double delta = 0;
        double spawnAlienDelta = 0;


        long lastRunTime = System.nanoTime();
        long currentRunTime;
        int number = 0;
        while(alienThread != null){
            if (false){ //change here to paused.
                continue;
            }
            // main game loop
            currentRunTime = System.nanoTime();
            delta += (currentRunTime - lastRunTime) / (double) (1000000000/60);
            spawnAlienDelta += (currentRunTime - lastRunTime) / (double) (1000000000/60);

            lastRunTime = currentRunTime;

            if (delta > 1){
                update();// this calls paintComponent
                delta--;
            }


            if (spawnAlienDelta > 600){

                this.spawnAlien();
                spawnAlienDelta -= 600;
            }



        }
    }
    public void update(){
        //Alien move will come here.
        for(Alien alien: Alien.aliens){
            if (alien != null && alien.alien_type.equals("shooter")){
                ((Shooter) alien).specialPower(player, gameController.currentRoom);
            }
            else if(alien != null && alien.alien_type.equals("time-wasting")){
                ((TimeWasting)alien).specialPower(player);
            }
            else if (alien != null && alien.alien_type.equals("blind")){
                if(player.locationX+player.width > alien.locationX && player.locationX-player.width < alien.locationX && player.locationY+player.height > alien.locationY && player.locationY-player.height < alien.locationY){
                    player.life -= 1;
                }

                ((Blind)alien).setDirection();
                move(alien);
                if(player.locationX+player.width > alien.locationX && player.locationX-player.width < alien.locationX && player.locationY+player.height > alien.locationY && player.locationY-player.height < alien.locationY){
                    player.life -= 1;

                }
            }
        }
    }
    public void paint(Graphics g) {
        for(int i = 0; i<Alien.aliens.length; i++){
            if(Alien.aliens[i] != null && Alien.aliens[i].current_room == gameController.currentRoom) {
                this.draw(g, Alien.aliens[i]);
            }
        }
    }
}


