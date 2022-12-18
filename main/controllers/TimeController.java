package main.controllers;

import static constants.Constants.WINDOW_WIDTH;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.Timer;

import main.models.Building;

public class TimeController {

	JLabel counterLabel;
	Timer timer;	
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");
	GameController gameController;
	
	int time, minute, second;
	int Xdistance = 1050;
	
	public TimeController(GameController gameController) {
		this.gameController = gameController;
		this.time = gameController.currentBuilding.getTotalFurnitures() * 5;
		this.minute = (int) (time / 60);
		this.second = (int) time - 60*((int) time / 60);
		
		counterLabel = new JLabel();
		counterLabel.setBounds(WINDOW_WIDTH-(Xdistance+148), 7, 120, 30);
		counterLabel.setForeground(Color.white);	
		
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/PixeloidSans-nR3g1.ttf")));
		} catch (IOException|FontFormatException e) {
		     e.printStackTrace();
		}
		
		counterLabel.setFont(new Font("Pixeloid Sans", Font.PLAIN, 24));
		gameController.add(counterLabel);
		
		counterLabel.setText(String.format("%s:%s", dFormat.format(minute), dFormat.format(second)));
		timeCounter();
		timer.start();						
	}
    
	public void timeCounter() {
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				counterLabel.setText(ddMinute + ":" + ddSecond);
								
				if(second == -1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					counterLabel.setText(ddMinute + ":" + ddSecond);
					
				}
				if(minute == 0 && second == 0) {
					timer.stop();
				}
			}
		});		
	}
	
	public void increaseTime() {
		time = 60*minute + second + 5;
		second = (int) time - 60*((int) time / 60);
		minute = (int) (time / 60);
		ddSecond = dFormat.format(second);
		ddMinute = dFormat.format(minute);
		counterLabel.setText(ddMinute + ":" + ddSecond);
	}
	public void setTime(int time) {
		this.time = time;
	}
}