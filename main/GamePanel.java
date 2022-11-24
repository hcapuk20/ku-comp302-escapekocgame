package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // keep this for now
    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(768, 576));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null){
            // main game loop
            // needs to update and display
            update();

            repaint(); // this actually calls paintComponent

        }

    }

    public void update(){

    }

    public void paintComponent(Graphics g) {

    }
}
