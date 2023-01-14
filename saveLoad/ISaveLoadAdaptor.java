package saveLoad;

import main.controllers.GameController;

import javax.swing.*;

public interface ISaveLoadAdaptor {
    void loadGame(JPanel panel, JFrame jframe, String userName);
    void saveGame(GameController gameController, String userName);

}
