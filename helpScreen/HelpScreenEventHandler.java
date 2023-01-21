package helpScreen;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.Font;

import main.controllers.GameController;
import menu.MenuPanel;
import pause.PausePanel;

public class HelpScreenEventHandler {
	
	public void backButtonPressed(JFrame frame, GameController panel, HelpScreen helpScreen) {
		if (PausePanel.getHelpPressed()) {
    		PausePanel pausePanel = new PausePanel(frame, panel);
    		frame.add(pausePanel);
    		PausePanel.setHelpPressed();
    	} else {
    		MenuPanel menuPanel = new MenuPanel(frame);
    		frame.add(menuPanel);
    	}    	
    	frame.pack();
    	frame.setVisible(true);
    	frame.remove(helpScreen);
	}
	
	public void backButtonEntered(JLabel backButton) {
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backButton.setToolTipText("Click here to go back to the game or main menu.");
	}
	
	public void characterIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is your character! You control them by pressing the arrow keys on the keyboard, and they move around. Their only hope lies within your skills, so try your best to escape!</center></b></HTML>");
    }                                     

    public void characterIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void keyIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is a key, which you can find one of in each building to escape the bulidings of the school, and then the school itself! It can be tricky to find, since one of the aliens likes to mess with it.</center></b></HTML>");
    }                                     

    public void keyIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void bagIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is your bag! This is one of the three slots you have as inventory, in which you can store the collectible power-ups. You can also stack them, where the counts will be displayed next to the slots. Use your power-ups wisely!</center></b></HTML>");
    }                                     

    public void bagIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void furnitureIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>These are the furnitures scattered throughout the buildings, and they contain the keys you need to find to escape (which you can find by left clicking)! One of these furnitures in your current building will have the key, so good luck finding it!</center></b></HTML>");
    }                                     

    public void furnitureIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void wallIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>These are the walls that form the school buildings. Don't try to go through them to escape, as they won't be allowing that!</center></b></HTML>");
    }                                     

    public void wallIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void doorIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void doorIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is part of the doors that you need to escape from after finding the key (right click to open the doors). You can't speak to the door to convince it to let you through, so make sure to find the key and get close enough to unlock it!</center></b></HTML>");
    }                                     

    public void hintIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is the hint power-up (press H to use it). It will tell you if the key is located in the current room you're in. If the key is found, then the furniture containing the key will be clearly highlighted, so mind your surroundings!</center></b></HTML>");
    }                                     

    public void hintIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void extraTimeIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is the extra time power-up. It will add 5 more seconds to your remaining time. You will need these, as the time can run out quickly if you are unlucky. Be sure to collect them!</center></b></HTML>");
    }                                     

    public void extraTimeIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void extraLifeIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is the extra life power-up. You will get one more life if you collect it. Try to get them whenever you see them, because the aliens surrounding you won't be forgiving!</center></b></HTML>");
    }                                     

    public void extraLifeIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void protectionVestIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is the protection vest power-up (use it with P). You will get a shield of defense for the shooter alien, so you won't take damage if you get near one. It doesn't last forever, though, so be wary of your surroundings while you bask in the glory of your armor.</center></b></HTML>");
    }                                     

    public void protectionVestIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void plasticBottleIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is the plastic bottle power-up. You can use it to distract a blind alien by pressing \"B\" on your keyboard, and then throw it based on this key configuration: (\"A\": west, \"D\": east, \"W\": north, \"X\": south). Make sure to watch out where you throw it!</center></b></HTML>");
    }                                     

    public void plasticBottleIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void shootingAlienIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is a shooting alien. It will shoot bullets within a certain range, so try not to get too close to it as you will lose a life in doing so. Be careful!");
    }                                     

    public void shootingAlienIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void blindAlienIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setText("<HTML><b><center>This is a blind alien. It will randomly roam around in the room that it spawns, and it will kill you instantly if you come in contact with it. So mind where you are going; even a glorious armor won't be saving you!</center></b></HTML>");
    }                                     

    public void blindAlienIconExited(JLabel infoTextDisplayer) {                                     
        infoTextDisplayer.setText("");
    }                                    

    public void timeWastingAlienIconEntered(JLabel infoTextDisplayer) {                                      
        infoTextDisplayer.setFont(new Font("Pixeloid Sans", 1, 11));
    	infoTextDisplayer.setText("<HTML><b><center>This is a time-wasting alien. It will try changing the location of the key based on your remaining time. If you have more than 70% of your time remaining, then it is every 5 seconds. If it is between the 30%-70% range, then this guy becomes confused and disappears without doing anything. Things get fierce if it is less than 30%, as it will change the key location every 3 seconds. So try not to lose too much time!</center></b></HTML>");
    }                                     

    public void timeWastingAlienIconExited(JLabel infoTextDisplayer) {                                     
    	infoTextDisplayer.setFont(new Font("Pixeloid Sans", 1, 14));
    	infoTextDisplayer.setText("");
    }          
    
    public void howToPlayEntered(JLabel howToPlay, HowToPlayInfo htpi) {
    	howToPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
		htpi.setVisible(true);
    }
    
    public void howToPlayExited(HowToPlayInfo htpi) {
    	htpi.dispose();
    }
	
}
