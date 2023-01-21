package main;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import main.controllers.GameController;
import main.models.Alien.Alien;
import main.models.Building;
import main.models.BuildingsDataSource;
import main.models.Character;
import main.models.PowerUp.Hint;
import main.models.PowerUp.PlasticBottle;
import main.models.PowerUp.PowerUp;
import main.models.PowerUp.ProtectionVest;
import main.models.Room;
import org.json.simple.JSONObject;
import pause.PauseObserver;
import pause.PauseSubject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class KeyEventHandler implements KeyListener {
    final private Character character;
    private GameController gameController;
    PauseSubject pauseSubject = new PauseSubject();
    PauseObserver pauseObserver = new PauseObserver();

    public KeyEventHandler(GameController gameController, Character character){
        this.character = character;
        this.gameController = gameController;
        pauseSubject.registerObserver(pauseObserver);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) { //Hakan
            character.direction = "right";
            character.moving = true;
        }
        else if (key == KeyEvent.VK_LEFT) {
            character.direction = "left";
            character.moving = true;
        }
        else if (key == KeyEvent.VK_UP) {
            character.direction = "up";
            character.moving = true;
        }
        else if (key == KeyEvent.VK_DOWN) {
            character.direction = "down";
            character.moving = true;
        }
        else if(key == KeyEvent.VK_ESCAPE){
            gameController.paused = !gameController.paused;
            pauseSubject.setPaused(true);
            gameController.stop();
        } else if (key == KeyEvent.VK_M) {
            gameController.miniMapController.mClicked();

        } else if (key == KeyEvent.VK_H){
            for (PowerUp powerUp: character.bag){
                if (powerUp instanceof Hint && !character.hasKey){
                    gameController.powerUpController.hintUsed = true;
                    gameController.miniMapController.showHint = true;
                    Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gameController.powerUpController.hintUsed = false;
                            gameController.miniMapController.showHint = false;
                        }
                    }, 3000);
                    character.bag.remove(powerUp);
                    break;
                }
            }
        } else if (key == KeyEvent.VK_P){
            // hint powerUp
            for (PowerUp powerUp: character.bag){
                if (powerUp instanceof ProtectionVest){
                    gameController.playSound("assets/sounds/protection-vest.wav");
                    ProtectionVest pvest = (ProtectionVest) powerUp;
                    pvest.doEffect(gameController);
                    character.bag.remove(powerUp);
                    break;
                }
            }
        } else if (key == KeyEvent.VK_B){ //erim
            for (PowerUp powerUp: character.bag){
                if (powerUp instanceof PlasticBottle){
                    PlasticBottle bottle = (PlasticBottle) powerUp;
                    character.bag.remove(powerUp);
                    character.bottleUsed = true;
                    break;
                }
            }
        } else if (key == KeyEvent.VK_W && character.bottleUsed){ //erim
            gameController.playSound("assets/sounds/bottle-used.wav");
            gameController.powerUpController.bottleUsed = true;
            gameController.powerUpController.bottleDirection = "up";
            character.bottleUsed = false;
        } else if (key == KeyEvent.VK_A && character.bottleUsed){
            gameController.playSound("assets/sounds/bottle-used.wav");
            gameController.powerUpController.bottleUsed = true;
            gameController.powerUpController.bottleDirection = "left";
            character.bottleUsed = false;
        } else if (key == KeyEvent.VK_D && character.bottleUsed){
            gameController.playSound("assets/sounds/bottle-used.wav");
            gameController.powerUpController.bottleUsed = true;
            gameController.powerUpController.bottleDirection = "right";
            character.bottleUsed = false;
        } else if (key == KeyEvent.VK_X && character.bottleUsed){
            gameController.playSound("assets/sounds/bottle-used.wav");
            gameController.powerUpController.bottleUsed = true;
            gameController.powerUpController.bottleDirection = "down";
            character.bottleUsed = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            character.moving = false;
        }
        else if(key == KeyEvent.VK_LEFT){
            character.moving = false;
        }
        else if(key == KeyEvent.VK_UP){
            character.moving = false;
        }
        else if(key == KeyEvent.VK_DOWN){
            character.moving = false;
        }
        else if(key == KeyEvent.VK_M){
            gameController.miniMapController.mReleased();
        }


    }
}
