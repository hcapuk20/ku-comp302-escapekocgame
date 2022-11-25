package main.models;

import java.awt.image.BufferedImage;

public class GameObject {

    // game object is the parent class for visible objects in the running mode,
    // such as the player, aliens, furniture, power-ups etc.
    public int locationX;
    public int locationY;
    public int width;
    public int height;
    BufferedImage image;

}
