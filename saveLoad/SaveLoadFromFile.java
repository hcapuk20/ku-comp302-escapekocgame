package saveLoad;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Constants;
import main.Main;
import main.controllers.GameController;
import main.models.*;
import main.models.Alien.Alien;
import main.models.Character;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class SaveLoadFromFile  {

    public static void loadGameFromFile(JFrame jframe, JPanel panel){
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            String fileName = "savedFiles/" + Main.username + ".json";
            // convert JSON file to map
            Map<?, ?> map = null;
            try {
                map = mapper.readValue(Paths.get(fileName).toFile(), Map.class);
            } catch (Exception e) {
                return;
            }
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

    public static void saveGameToFile(GameController gameController){
        var mapper = new ObjectMapper();
        try {
            var json = mapper.writeValueAsString(gameController.character);
            var json2 = mapper.writeValueAsString(BuildingsDataSource.buildings);
            var json3 = mapper.writeValueAsString(Alien.aliens);
            var json4 = mapper.writeValueAsString(gameController.timeController.time);
            var json5 = mapper.writeValueAsString(gameController.currentBuildingCount);
            var json6 = mapper.writeValueAsString(gameController.roomCountX);
            var json7 = mapper.writeValueAsString(gameController.roomCountY);

            JSONObject jsonpObject = new JSONObject();
            jsonpObject.put("character",json);
            jsonpObject.put("buildings",json2);
            jsonpObject.put("aliens",json3);
            jsonpObject.put("time",json4);
            jsonpObject.put("currentBuildingCount",json5);
            jsonpObject.put("roomCountX",json6);
            jsonpObject.put("roomCountY",json7);

            String fileName = "savedFiles/" + gameController.username + ".json";

            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(jsonpObject.toJSONString());
            myWriter.close();


        } catch (JsonProcessingException es) {
            es.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
