package main.controllers;

import constants.Constants;
import main.CollisionChecker;
import main.models.Alien.*;
import main.models.Character;
import main.models.GameObject;

import java.awt.*;
import java.util.Random;

import static constants.Constants.*;

public class AlienController implements Runnable {

    Thread alienThread;
    public int counter;
    public int animationCount;
    CollisionChecker collisionChecker;

    Character player;
    GameController gameController;
    Random rand = new Random();
    static int flag1 = 0;
    static int flag2 = 0;
    static int flag3 = 0;

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

                if(alien.locationY > 44){
                    alien.locationY -= alien.speed;
                }
                else{

                }
                //System.out.println(alien.locationY);
            }
        } else if (alien.moving && alien.direction.equals("down")) {
            if (!collisionChecker.checkCollision(alien)) {

                if(alien.locationY < WINDOW_HEIGHT-(44 + alien.height)){
                    alien.locationY += alien.speed;
                }
                else{

                }
                //System.out.println(alien.locationY);
            }
        } else if (alien.moving && alien.direction.equals("left")) {
            if (!collisionChecker.checkCollision(alien)) {

                if(alien.locationX > 44){
                    alien.locationX -= alien.speed;
                }
                else{

                };
            }
        } else if (alien.moving && alien.direction.equals("right")) {
            if (!collisionChecker.checkCollision(alien)) {

                if(alien.locationX < WINDOW_WIDTH-( 44 + alien.width ) ){
                    alien.locationX += alien.speed;
                }
                else{

                }
            }
        }
    }


    public void spawnAlien() {
        Alien tempAlien;
        GameObject[][] tileMap = gameController.currentRoom.tileMap;
        System.out.println("alien spawnlanıyor");
        int randomXTile = rand.nextInt(tileMap.length);

        int randomYTile = rand.nextInt(tileMap[0].length);

        while (tileMap[randomXTile][randomYTile] != null || (gameController.character.locationX / tileSize == randomXTile && gameController.character.locationY / tileSize == randomYTile) || randomYTile * tileSize < 44 || randomYTile * tileSize > WINDOW_HEIGHT-(44 + tileSize) || randomXTile * tileSize < 44 || randomXTile * tileSize > WINDOW_WIDTH-( 44 + tileSize )){
            randomXTile = rand.nextInt(tileMap.length);
            randomYTile = rand.nextInt(tileMap[0].length);
        }
        int randomType =rand.nextInt(alienTypes.length);
        if(alienTypes[randomType].equals("shooter")){
            tempAlien = new Shooter(randomXTile * Constants.tileSize, randomYTile * Constants.tileSize, Constants.tileSize, Constants.tileSize, alienTypes[randomType],gameController.roomCountX,gameController.roomCountY);
        }
        else if (alienTypes[randomType].equals("time-wasting")) {

            tempAlien = new TimeWasting(randomXTile * Constants.tileSize, randomYTile * Constants.tileSize, Constants.tileSize, Constants.tileSize, alienTypes[randomType],gameController.roomCountX,gameController.roomCountY,gameController.currentBuildingCount);

        }
        else {

            tempAlien = new Blind(randomXTile * Constants.tileSize, randomYTile * Constants.tileSize, Constants.tileSize, Constants.tileSize, alienTypes[randomType],gameController.roomCountX,gameController.roomCountY);

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

        g2.drawImage(alien.image, alien.locationX, alien.locationY,alien.width,alien.height,null);
        if(alien.alien_type.equals("shooter")){
            g2.setColor(Color.magenta);
            g2.drawRect(alien.locationX-4*tileSize+alien.width/2, alien.locationY-4*tileSize+alien.height/2, 8*tileSize, 8*tileSize );
        }


    }

    @Override
    public void run() {
        double delta = 0;
        double spawnAlienDelta = 0;


        long lastRunTime = System.nanoTime();
        long currentRunTime;
        int number = 0;
        while(alienThread != null){
            if (gameController.paused){
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


            if (spawnAlienDelta > 600){//600

                this.spawnAlien();
                spawnAlienDelta -= 600;
            }



        }
    }
    public void update(){
        //Alien move will come here.
        if(flag3 == 1){Alien.timeWaste3count ++;}
        if(flag1 == 1){Alien.timeWaste1Count ++;}
        if(flag2 == 1){Alien.timeWaste2Count ++; }
        if(Alien.timeWaste2Count > 180){ Alien.timeWaste2Count = -1;}
        if(Alien.timeWaste1Count > 60){ Alien.timeWaste1Count = -1;}
        if(Alien.timeWaste3count > 180){ Alien.timeWaste3count = -1;}

        for(Alien alien: Alien.aliens){
            if (alien != null && alien.alien_type.equals("shooter")){
                boolean alive = ((Shooter) alien).specialPower(player, gameController.roomCountX,gameController.roomCountY);
                if(!alive){
                    gameController.endGame();
                }
            }
            else if(alien != null && alien.alien_type.equals("time-wasting")){
                double time = gameController.timeController.second + gameController.timeController.minute*60;
                double max_time = gameController.currentBuilding.getTotalFurnitures() * 5;
                double remaining_percentage = time/max_time;

                if (remaining_percentage < 0.3) {


                    TimeWasting1 tempAlien1 = new TimeWasting1(alien.locationX, alien.locationY, alien.height, alien.width, alien.alien_type, gameController.roomCountX,gameController.roomCountY,gameController.currentBuildingCount);


                    if (flag1 == 0) {tempAlien1.specialPower(alien); flag1 = 1;}
                    else if(Alien.timeWaste1Count == -1){

                        for(int i = 0; i <Alien.aliens.length; i++ ){
                            if(Alien.aliens[i] == alien){
                                Alien.aliens[i] = null;
                                flag1 = 0;
                                break;

                            }

                        }
                    }



                } else if (remaining_percentage > 0.7) {


                    TimeWasting3 tempAlien2 = new TimeWasting3(alien.locationX, alien.locationY, alien.height, alien.width, alien.alien_type, gameController.roomCountX,gameController.roomCountY, gameController.currentBuildingCount);
                    if (flag2 == 0){

                        flag2 = 1;
                    }
                    else if (Alien.timeWaste2Count == -1){
                        tempAlien2.specialPower(alien);
                        Alien.timeWaste2Count = 0;
                    }


                } else {

                    if(flag3 == 0){

                        TimeWasting2 tempAlien3 = new TimeWasting2(alien.locationX, alien.locationY, alien.height, alien.width, alien.alien_type, gameController.roomCountX,gameController.roomCountY,gameController.currentBuildingCount);
                        tempAlien3.specialPower(alien);
                        flag3 = 1;
                    }
                    else if (Alien.timeWaste3count == -1){
                        for(int i = 0; i <Alien.aliens.length; i++ ){
                            if(Alien.aliens[i] == alien){
                                Alien.aliens[i] = null;
                                flag1 = 0;
                                break;

                            }

                        }

                    }

                }


            }
            else if (alien != null && alien.alien_type.equals("blind")){
                if(player.locationX+player.width > alien.locationX && player.locationX-player.width < alien.locationX && player.locationY+player.height > alien.locationY && player.locationY-player.height < alien.locationY && alien.roomX == gameController.roomCountX && alien.roomY == gameController.roomCountY){
                    player.life = 0;
                    gameController.endGame();
                }
                if(gameController.powerUpController.getBottle() != null){
                    ((Blind)alien).setDirection(gameController.powerUpController.getBottle().locationX, gameController.powerUpController.getBottle().locationY, gameController.powerUpController.getBottle());
                }
                else {
                    ((Blind) alien).setDirection();
                }
                move(alien);
                if(player.locationX+player.width > alien.locationX && player.locationX-player.width < alien.locationX && player.locationY+player.height > alien.locationY && player.locationY-player.height < alien.locationY && alien.roomX == gameController.roomCountX && alien.roomY == gameController.roomCountY){
                    player.life = 0;
                    gameController.endGame();

                }
            }
        }
    }
    public void paint(Graphics g) {
        for(int i = 0; i<Alien.aliens.length; i++){
            if(Alien.aliens[i] != null && Alien.aliens[i].roomX == gameController.roomCountX && Alien.aliens[i].roomY == gameController.roomCountY) {
                this.draw(g, Alien.aliens[i]);
            }
        }
    }
}


