package saveLoad;

import main.controllers.GameController;

import javax.swing.*;

public class SaveLoadDBAdaptor implements ISaveLoadAdaptor {
    @Override
    public void loadGame(JPanel panel, JFrame jframe, String userName) {
        saveLoadFromDB.loadFromDB(panel,jframe,userName);
    }

    @Override
    public void saveGame(GameController gameController, String userName) {
        saveLoadFromDB.saveGameToDB(gameController,userName);
    }
}
