package main;

import menu.MenuPanel;

import javax.swing.*;

public class Main {

	public static String username;
	public static String password;
	public static boolean isFile = false;
	
	public void startMainMenu(String username, String password) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Main.username = username;
		Main.password = password;

		window.setResizable(false);
		window.setTitle("Escape Koc");

		MenuPanel menuPanel = new MenuPanel(window);
		window.add(menuPanel);
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}
}
