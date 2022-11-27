package main;

import main.controllers.PlayerController;
import main.models.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // keep this for now
    Thread gameThread;
    Player player;
    PlayerController playerController;
    KeyEventHandler keyListener;

    public GamePanel(){
        this.setPreferredSize(new Dimension(768, 576));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        player = new Player(100,100,100,100,10);
        keyListener = new KeyEventHandler(player);
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        this.playerController = new PlayerController(player);
    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double delta = 0;
        long lastRunTime = System.nanoTime();
        long currentRunTime;

        while(gameThread != null){
            // main game loop
            currentRunTime = System.nanoTime();
            delta += (currentRunTime - lastRunTime) / (double) (1000000000/60);

            lastRunTime = currentRunTime;

            if (delta > 1){
                update();
                repaint(); // this actually calls paintComponent
                delta--;
            }
        }

    }

    public void update(){
        playerController.move();
    }

    public void paintComponent(Graphics g) {
        g.setColor(getBackground());

        playerController.draw(g);
        //g.dispose();
    }
}
