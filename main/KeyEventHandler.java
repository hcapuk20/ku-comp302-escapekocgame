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
        } else if (key == KeyEvent.VK_Z) {
            //ProtectionVest pvest = new ProtectionVest(0,0,0,0);
            var mapper = new ObjectMapper();
            try {
                var json = mapper.writeValueAsString(gameController.character);
                //System.out.println(json);
                var json2 = mapper.writeValueAsString(BuildingsDataSource.buildings);
                //System.out.println(json2);
                var json3 = mapper.writeValueAsString(gameController.currentBuilding);
                //System.out.println(json3);
                var json4 = mapper.writeValueAsString(gameController.currentRoom);
                //System.out.println(json4);
                var json5 = mapper.writeValueAsString(Alien.aliens);
                //System.out.println(json5);
                var json6 = mapper.writeValueAsString(gameController.timeController.time);
                //System.out.println(json6);
                var json7 = mapper.writeValueAsString(gameController.currentBuildingCount);
                //System.out.println(json7);
                var json8 = mapper.writeValueAsString(gameController.roomCountX);
                //System.out.println(json8);
                var json9 = mapper.writeValueAsString(gameController.roomCountY);
                //System.out.println(json9);
                JSONObject jsonpObject = new JSONObject();
                jsonpObject.put("character",json);
                jsonpObject.put("buildings",json2);
                //jsonpObject.put("currentBuilding",json3);
                //jsonpObject.put("currentRoom",json4);
                jsonpObject.put("aliens",json5);
                jsonpObject.put("time",json6);
                jsonpObject.put("currentBuildingCount",json7);
                jsonpObject.put("roomCountX",json8);
                jsonpObject.put("roomCountY",json9);

                File saveGameFile = new File("savedGame.json");
                FileWriter myWriter = new FileWriter("savedGame.json");
                myWriter.write(jsonpObject.toJSONString());
                myWriter.close();


            } catch (JsonProcessingException es) {
                es.printStackTrace();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (key == KeyEvent.VK_L) {
            try {
                // create object mapper instance
                ObjectMapper mapper = new ObjectMapper();

                // convert JSON file to map
                Map<?, ?> map = mapper.readValue(Paths.get("savedGame.json").toFile(), Map.class);
                // print map entries
                Character loadChar = null;
                Room loadCurrentRoom;
                Building loadCurrentBuilding;
                BuildingsDataSource.createBuildingDataSource();
                Alien[] loadAliens;
                int loadTime = 0;
                int loadCurrentBuildingCount = 0;
                int loadRoomX = 0;
                int loadRoomY = 0;

                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    //System.out.println(entry.getKey() + "=" + entry.getValue());
                    System.out.println(entry.getKey());
                    if (entry.getKey().equals("character")){
                        loadChar = mapper.readValue((String) entry.getValue(),Character.class);
                    }
                    else if (entry.getKey().equals("buildings")){
                        BuildingsDataSource.buildings = mapper.readValue((String) entry.getValue(),Building[].class);
                    }
                    else if (entry.getKey().equals("currentBuilding")){
                        loadCurrentBuilding = mapper.readValue((String) entry.getValue(),Building.class);
                    }
                    else if (entry.getKey().equals("currentRoom")){
                        loadCurrentRoom = mapper.readValue((String) entry.getValue(),Room.class);
                    }
                    else if (entry.getKey().equals("aliens")){
                        loadAliens = mapper.readValue((String) entry.getValue(),Alien[].class);
                        Alien.aliens = loadAliens;
                    }
                    else if (entry.getKey().equals("time")){
                        loadTime = mapper.readValue((String) entry.getValue(),Integer.class);

                    }
                    else if (entry.getKey().equals("currentBuildingCount")){
                        loadCurrentBuildingCount = mapper.readValue((String) entry.getValue(),Integer.class);
                        System.out.println("currentBuildingCount:"+ loadCurrentBuildingCount);
                    }
                    else if (entry.getKey().equals("roomCountX")){
                        loadRoomX = mapper.readValue((String) entry.getValue(),Integer.class);
                    }
                    else if (entry.getKey().equals("roomCountY")){
                        loadRoomY = mapper.readValue((String) entry.getValue(),Integer.class);
                        System.out.println("Y1:"+loadRoomY);
                    }
                    System.out.println("Y2"+loadRoomY);
                }
                gameController = new GameController(gameController.frame,loadChar,loadTime,loadCurrentBuildingCount,loadRoomX,loadRoomY);


            } catch (Exception ex) {
                ex.printStackTrace();
            }

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
                    gameController.displayedMessage = "You used Protection Vest!";
                    Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gameController.displayedMessage = "";
                        }
                    }, 1000);
                    break;
                }
            }
        } else if (key == KeyEvent.VK_B){
            for (PowerUp powerUp: character.bag){
                if (powerUp instanceof PlasticBottle){
                    PlasticBottle bottle = (PlasticBottle) powerUp;
                    character.bag.remove(powerUp);
                    character.bottleUsed = true;
                    gameController.displayedMessage = "You used Plastic Bottle!";
                    Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gameController.displayedMessage = "";
                        }
                    }, 1000);
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
