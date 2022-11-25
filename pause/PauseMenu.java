package pause;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.Constants;
import main.GamePanel;



public class PauseMenu extends JPanel implements ActionListener {
	
	boolean paused = false;
	

	protected static JLabel titleLabel;

	protected static int panelWidth = Constants.WINDOW_WIDTH;
	protected static int panelHeight = Constants.WINDOW_HEIGHT;

	protected static int distanceBetweenButtons = 20;
	protected static int buttonHeight = 60;
	protected static int buttonWidth = 200;
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		JPanel panel = new JPanel();
		window.getContentPane().setBackground(Color.BLUE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setTitle("Escape Koc");
		window.setVisible(true);
		window.setSize(panelWidth, panelHeight);
		
		window.add(panel);
		panel.setLayout(null);
		JLabel label = new JLabel("Paused");
		label.setForeground(Color.WHITE);
		label.setBounds((panelWidth - 2 * buttonWidth) / 2,
				(panelHeight - buttonHeight) / 2 - 2 * buttonHeight - 15, 2 * buttonWidth, buttonHeight);
		label.setFont(new Font("Serif", Font.PLAIN, 30));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 + buttonHeight,
				buttonWidth, buttonHeight);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SETTINGS");
		btnNewButton_1.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2, buttonWidth,
				buttonHeight);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("RESUME");
		btnNewButton_2.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 - buttonHeight,
				buttonWidth, buttonHeight);
		
		panel.add(btnNewButton_2);
	
		panel.setBackground(Color.BLACK);
		panel.add(label);
		window.add(panel);
		
		
		
	
	

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
		
		
	}
