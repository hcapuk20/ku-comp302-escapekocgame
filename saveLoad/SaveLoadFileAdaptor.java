package saveLoad;

import main.controllers.GameController;

import javax.swing.*;

public class SaveLoadFileAdaptor implements  ISaveLoadAdaptor{
    @Override
    public void loadGame(JPanel panel, JFrame jframe, String userName) {
        SaveLoadFromFile.loadGameFromFile(jframe,panel);
    }

    @Override
    public void saveGame(GameController gameController, String userName) {
        SaveLoadFromFile.saveGameToFile(gameController);
    }
}
