package pause;

import constants.Constants;
import helpScreen.HelpScreen;
import main.Main;
import main.controllers.GameController;
import main.controllers.SaveLoadController;
import menu.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PausePanel extends JPanel implements ActionListener {

    protected static JButton resumeButton;
    protected static JButton saveButton;
    protected static JButton helpButton;
    protected static JButton exitButton;

    protected static JLabel titleLabel;

    protected static int panelWidth = Constants.WINDOW_WIDTH;
    protected static int panelHeight = Constants.WINDOW_HEIGHT;

    protected static int distanceBetweenButtons = 20;
    protected static int buttonHeight = 60;
    protected static int buttonWidth = 200;
    
    protected static boolean pauseHelpPressed = false;
    
    static JFrame frame;

    protected static Image backgroundImage = new ImageIcon("assets/pauseBackground.jpeg").getImage();

    static GameController panel;

    public PausePanel(JFrame f, GameController panel) {
        this.addMouseListener(null);

        this.setPreferredSize(new Dimension(panelWidth, panelHeight));

        this.frame = f;
        this.panel = panel;

        setLayout(null);

        setButtons();
        setLabels();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, panelWidth, panelHeight, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    protected void setLabels() {
        titleLabel = new JLabel("ESCAPE FROM KOÇ");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("GeoSlab703 Md BT", Font.PLAIN, 30));
        titleLabel.setBounds((panelWidth - 2 * buttonWidth) / 2,
                (panelHeight - buttonHeight) / 2 - 2 * buttonHeight - 15, 2 * buttonWidth, buttonHeight);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);

        add(titleLabel);
    }

    protected void setButtons() {
        resumeButton = new JButton("RESUME");
        resumeButton.setFont(new Font("Pixeloid Sans", Font.PLAIN, 15));
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resumeButtonAction();
            }
        });
        resumeButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 - buttonHeight,
                buttonWidth, buttonHeight);

        saveButton = new JButton("SAVE GAME");
        saveButton.setFont(new Font("Pixeloid Sans", Font.PLAIN, 15));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButtonAction();
            }
        });
        saveButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2, buttonWidth,
                buttonHeight);

        helpButton = new JButton("HELP");
        helpButton.setFont(new Font("Pixeloid Sans", Font.PLAIN, 15));
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	helpButtonAction();
            }
        });
        helpButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 + buttonHeight,
                buttonWidth, buttonHeight);

        exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Pixeloid Sans", Font.PLAIN, 15));
		exitButton.setBackground(new Color(255, 102, 102));
		exitButton.setForeground(Color.white);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButtonAction();
            }
        });
        exitButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 + buttonHeight * 2,
                buttonWidth, buttonHeight);

        this.add(resumeButton);
        this.add(saveButton);
        this.add(helpButton);
        this.add(exitButton);
    }

    protected void helpButtonAction() {
        HelpScreen helpPanel = new HelpScreen(frame, panel);
        frame.add(helpPanel);
        frame.pack();
        frame.setVisible(true);
        frame.remove(this);
        pauseHelpPressed = true;
    } 
    
    
    protected void saveButtonAction() {
        //SaveLoadController.saveGameToFile(panel);
        SaveLoadController saveLoadController = new SaveLoadController(Main.isFile);
        saveLoadController.save(panel, panel.username);
    }

    protected void resumeButtonAction() {
        panel.paused = false;
        frame.add(panel);
        panel.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        frame.remove(this);
        frame.repaint();
    }

    protected void exitButtonAction() {

        MenuPanel menuPanel = new MenuPanel(frame);

        frame.add(menuPanel);
        menuPanel.setBounds(0, 0, panelWidth, panelHeight);

        frame.remove(this);

    }
    
    public static boolean getHelpPressed() {
    	return pauseHelpPressed;
    }
    public static void setHelpPressed() {
    	pauseHelpPressed = false;
    }
}