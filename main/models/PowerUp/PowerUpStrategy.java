package main.models.PowerUp;

import main.controllers.GameController;

import java.awt.*;

public interface PowerUpStrategy {
    public void doEffect(GameController gameController, Graphics g);
}
