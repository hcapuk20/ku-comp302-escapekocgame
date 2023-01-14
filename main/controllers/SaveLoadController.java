package main.controllers;

import static com.mongodb.client.model.Filters.eq;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import constants.Constants;
import main.Main;
import main.models.*;
import main.models.Alien.Alien;
import main.models.Character;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import org.bson.Document;

public class SaveLoadController {

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

    public static void saveGameToDB(GameController gameController, String userName){
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

            try {
                ConnectionString connectionString = new ConnectionString("mongodb+srv://erim:deneme123@escapekoc.5csekqp.mongodb.net/?retryWrites=true&w=majority");
                MongoClientSettings settings = MongoClientSettings.builder()
                        .applyConnectionString(connectionString)
                        .build();
                MongoClient mongoClient = MongoClients.create(settings);

                MongoDatabase database = mongoClient.getDatabase("escapeKocTest");
                //database.createCollection("escapeKocTestCollection");

                System.out.println("Collection created successfully");

                MongoCollection<Document> collection = database.getCollection("escapeKocTestCollection");
                System.out.println("Collection got successfully");

                Document doc = collection.find(eq("user", userName)).first();
                if (doc == null){
                    System.out.println("No data found, new data will be inserted");
                    Document document = new Document("user",userName).append("gamedata",jsonpObject);
                    collection.insertOne(document);
                    System.out.println("Document inserted successfully");
                } else {
                    // update
                    collection.updateOne(Filters.eq("user", userName), Updates.set("gamedata", jsonpObject));;
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        } catch (JsonProcessingException es) {
            es.printStackTrace();
        }
    }

    public static void loadFromDB(JPanel panel, JFrame jframe, String userName){
        try {
            ConnectionString connectionString = new ConnectionString("mongodb+srv://erim:deneme123@escapekoc.5csekqp.mongodb.net/?retryWrites=true&w=majority");
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .build();
            MongoClient mongoClient = MongoClients.create(settings);

            MongoDatabase database = mongoClient.getDatabase("escapeKocTest");
            //database.createCollection("escapeKocTestCollection");

            System.out.println("Collection created successfully");

            MongoCollection<Document> collection = database.getCollection("escapeKocTestCollection");
            System.out.println("Collection got successfully");

            Document doc = collection.find(eq("user", userName)).first();
            if (doc == null){
                return;
            } else {
                ObjectMapper mapper = new ObjectMapper();
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
                Map<?, ?> map = null;
                try {
                    map = mapper.readValue(doc.get("gamedata", Document.class).toJson(), Map.class);
                } catch (Exception e) {
                    return;
                }
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
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
