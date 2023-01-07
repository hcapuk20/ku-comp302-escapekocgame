package main.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.awt.*;
import java.awt.image.BufferedImage;
@JsonIgnoreProperties({"image","collisionArea"})
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public  class GameObject {
    // game object is the parent class for visible objects in the running mode,
    // such as the player, aliens, furniture, power-ups etc.

    public int locationX;
    public int locationY;
    public int width;
    public int height;
    public BufferedImage image;
    public int speed;
    public String direction;
    public boolean collidable = false;
    public boolean interactable = false;
    public Rectangle collisionArea;

    public GameObject(){

    }


}
