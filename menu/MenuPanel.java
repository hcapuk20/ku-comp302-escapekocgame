package menu;

import constants.Constants;
import main.controllers.BuildingModeController;
import main.controllers.GameController;
import main.models.BuildingsDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {

	protected static JButton playButton;
	protected static JButton infoButton;
	protected static JButton exitButton;

	protected static JLabel titleLabel;

	protected static int panelWidth = Constants.WINDOW_WIDTH;
	protected static int panelHeight = Constants.WINDOW_HEIGHT;

	protected static int distanceBetweenButtons = 20;
	protected static int buttonHeight = 60;
	protected static int buttonWidth = 200;

	protected static Image backgroundImage = new ImageIcon("assets/menuBackground.jpeg").getImage();

	BuildingsDataSource buildingsDataSource = new BuildingsDataSource();
	JFrame frame;

	public MenuPanel(JFrame f) {
		this.addMouseListener(null);

		this.setPreferredSize(new Dimension(panelWidth, panelHeight));

		this.frame = f;

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
		titleLabel = new JLabel("Escape From Koç");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		titleLabel.setBounds((panelWidth - 2 * buttonWidth) / 2,
				(panelHeight - buttonHeight) / 2 - 2 * buttonHeight - 15, 2 * buttonWidth, buttonHeight);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setVerticalAlignment(JLabel.CENTER);

		add(titleLabel);
	}

	protected void setButtons() {
		playButton = new JButton("PLAY");
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playButtonAction();
			}
		});
		playButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 - buttonHeight,
				buttonWidth, buttonHeight);

		infoButton = new JButton("INFO");
		infoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infoButtonAction();
			}
		});
		infoButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2, buttonWidth,
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

		this.add(playButton);
		this.add(infoButton);
		this.add(exitButton);
	}

	protected void playButtonAction() {

		BuildingModeController buildingModeController = new BuildingModeController(frame);

		frame.add(buildingModeController);
		buildingModeController.setBounds(0, 0, panelWidth, panelHeight);

		buildingModeController.startGame();

		frame.remove(this);
	}

	protected void infoButtonAction() {



	}

	protected void exitButtonAction() {

		System.exit(0);

	}

}
