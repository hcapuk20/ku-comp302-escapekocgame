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
import saveLoad.ISaveLoadAdaptor;
import saveLoad.SaveLoadDBAdaptor;
import saveLoad.SaveLoadFileAdaptor;

public class SaveLoadController {

    ISaveLoadAdaptor saveLoadAdaptor;
    public SaveLoadController(boolean isFile){
        if (isFile){
            saveLoadAdaptor = new SaveLoadFileAdaptor();
        }
        else {
            saveLoadAdaptor = new SaveLoadDBAdaptor();
        }
    }

    public void save(GameController gameController, String username){
        saveLoadAdaptor.saveGame(gameController,username);
    }
    public void load(JPanel panel,JFrame frame,String username){
        saveLoadAdaptor.loadGame(panel,frame,username);
    }

}
