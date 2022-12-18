package main.controllers;

import constants.Constants;
import main.models.BuildingsDataSource;
import menu.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameController extends JPanel implements ActionListener{

    protected static JButton menuButton;
    protected static JButton restartButton;
    protected static JButton exitButton;

    protected static JLabel titleLabel;

    protected static int panelWidth = Constants.WINDOW_WIDTH;
    protected static int panelHeight = Constants.WINDOW_HEIGHT;

    protected static int distanceBetweenButtons = 20;
    protected static int buttonHeight = 60;
    protected static int buttonWidth = 200;

    protected static Image backgroundImage = new ImageIcon("assets/endBackground.jpg").getImage();

    BuildingsDataSource buildingsDataSource = new BuildingsDataSource();
    JFrame frame;

    protected int score = 0;

    public EndGameController(JFrame f, int score) {
        this.addMouseListener(null);

        this.setPreferredSize(new Dimension(panelWidth, panelHeight));

        this.frame = f;
        this.score = score;

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
        titleLabel = new JLabel("Your Score = " + score);
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        titleLabel.setBounds((panelWidth - 2 * buttonWidth) / 2,
                (panelHeight - buttonHeight) / 2 - 2 * buttonHeight - 15, 2 * buttonWidth, buttonHeight);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);

        add(titleLabel);
    }

    protected void setButtons() {
        menuButton = new JButton("MENU");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuButtonAction();
            }
        });
        menuButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 - buttonHeight,
                buttonWidth, buttonHeight);

        restartButton = new JButton("RESTART");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartButtonAction();
            }
        });
        restartButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2, buttonWidth,
                buttonHeight);

        exitButton = new JButton("EXIT");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButtonAction();
            }
        });
        exitButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 + buttonHeight,
                buttonWidth, buttonHeight);

        this.add(menuButton);
        this.add(restartButton);
        this.add(exitButton);
    }

    protected void menuButtonAction() {

        MenuPanel menuPanel = new MenuPanel(frame);

        frame.add(menuPanel);
        menuPanel.setBounds(0, 0, panelWidth, panelHeight);

        frame.remove(this);

    }

    protected void restartButtonAction() {

        BuildingsDataSource.createBuildingDataSource(); //re-initialize
        BuildingModeController buildingModeController = new BuildingModeController(frame);

        frame.add(buildingModeController);
        buildingModeController.setBounds(0, 0, panelWidth, panelHeight);

        buildingModeController.startGame();

        frame.remove(this);

    }

    protected void exitButtonAction() {

        System.exit(0);

    }


}