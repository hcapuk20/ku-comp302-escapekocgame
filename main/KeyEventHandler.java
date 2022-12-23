package main;

import main.controllers.GameController;
import main.models.Character;
import main.models.PowerUp.Hint;
import main.models.PowerUp.PlasticBottle;
import main.models.PowerUp.PowerUp;
import main.models.PowerUp.ProtectionVest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class KeyEventHandler implements KeyListener {
    final private Character character;
    private GameController gameController;

    public KeyEventHandler(GameController gameController, Character character){
        this.character = character;
        this.gameController = gameController;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
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
            System.out.println("pressed escape.");
            gameController.paused = !gameController.paused;
            gameController.stop();
        } else if (key == KeyEvent.VK_M) {
            gameController.miniMapController.keyEventOperation();

        } else if (key == KeyEvent.VK_H){
            for (PowerUp powerUp: character.bag){
                if (powerUp instanceof Hint){
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
                    ProtectionVest pvest = (ProtectionVest) powerUp;
                    pvest.doEffect(gameController);
                    character.bag.remove(powerUp);
                    break;
                }
            }
        } else if (key == KeyEvent.VK_B){
            for (PowerUp powerUp: character.bag){
                if (powerUp instanceof PlasticBottle){
                    PlasticBottle bottle = (PlasticBottle) powerUp;
                    character.bag.remove(powerUp);
                    character.bottleUsed = true;
                    break;
                }
            }
        } else if (key == KeyEvent.VK_W && character.bottleUsed){
            gameController.powerUpController.bottleUsed = true;
            gameController.powerUpController.bottleDirection = "up";
            character.bottleUsed = false;
        } else if (key == KeyEvent.VK_A && character.bottleUsed){
            gameController.powerUpController.bottleUsed = true;
            gameController.powerUpController.bottleDirection = "left";
            character.bottleUsed = false;
        } else if (key == KeyEvent.VK_D && character.bottleUsed){
            gameController.powerUpController.bottleUsed = true;
            gameController.powerUpController.bottleDirection = "right";
            character.bottleUsed = false;
        } else if (key == KeyEvent.VK_X && character.bottleUsed){
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

    }
}
