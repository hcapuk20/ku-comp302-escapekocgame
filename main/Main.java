package main;

import javax.swing.JFrame;

import menu.MenuPanel;

public class Main {

	public static void main(String[] args) {
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
