package main;

import javax.swing.JFrame;

import menu.MenuPanel;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Escape Koc");

		GamePanel gamePanel = new GamePanel();
		MenuPanel menuPanel = new MenuPanel();
		window.add(menuPanel);
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

		gamePanel.startGame();
	}
}
