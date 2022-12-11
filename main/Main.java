package main;

import menu.MenuPanel;

import javax.swing.*;

public class Main {

	public void startMainMenu() {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Escape Koc");

		MenuPanel menuPanel = new MenuPanel(window);
		window.add(menuPanel);
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}
}
