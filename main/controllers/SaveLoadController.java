package main.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Constants;
import main.models.*;
import main.models.Alien.Alien;
import main.models.Character;

import javax.swing.*;
import java.nio.file.Paths;
import java.util.Map;

public class SaveLoadController {

    public static void loadGameFromFile(JFrame jframe, JPanel panel){
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
                }
                else if (entry.getKey().equals("roomCountX")){
                    loadRoomX = mapper.readValue((String) entry.getValue(),Integer.class);
                }
                else if (entry.getKey().equals("roomCountY")){
                    loadRoomY = mapper.readValue((String) entry.getValue(),Integer.class);
                }
            }

            for(Building building: BuildingsDataSource.buildings){
                for(Room[] rooms: building.rooms){
                    for(Room room: rooms){
                        if(room != null){
                            for(GameObject[] gameObjects: room.tileMap){
                                for(GameObject gameObject: gameObjects){
                                    if(gameObject instanceof Furniture){
                                        ((Furniture) gameObject).initializeImage();
                                    }
                                }
                            }
                        }

                    }
                }
            }

            GameController gameController = new GameController(jframe,loadChar,loadTime,loadCurrentBuildingCount,loadRoomX,loadRoomY);
            jframe.add(gameController);
            gameController.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            gameController.startGame();
            jframe.remove(panel);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
