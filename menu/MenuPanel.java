package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;
import main.GamePanel;

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

			}
		});
		infoButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2, buttonWidth,
				buttonHeight);

		exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		exitButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 + buttonHeight,
				buttonWidth, buttonHeight);

		this.add(playButton);
		this.add(infoButton);
		this.add(exitButton);
	}

	protected void playButtonAction() {

		GamePanel gamePanel = new GamePanel();

		frame.add(gamePanel);
		gamePanel.setBounds(0, 0, panelWidth, panelHeight);

		gamePanel.startGame();

		frame.remove(this);

	}

}
