package main;

import constants.Constants;
import main.models.GameObject;
import main.models.Room;

import static constants.Constants.WINDOW_HEIGHT;
import static constants.Constants.WINDOW_WIDTH;

public class CollisionChecker {
    Room mapController;

    public CollisionChecker(Room mapController){
        this.mapController = mapController;
    }

    public boolean checkCollision(GameObject object){
        // coordinates of the objects hit-box (collisionArea)
        int collisionLeftX = object.locationX + object.collisionArea.x;
        int collisionRightX = object.locationX + object.collisionArea.x + object.collisionArea.width;
        int collisionTopY = object.locationY + object.collisionArea.y;
        int collisionBottomY = object.locationY + object.collisionArea.y + object.collisionArea.height;
        int tileSize = Constants.tileSize;
        int collisionLeftTile = collisionLeftX / tileSize;
        int collisionRightTile = collisionRightX / tileSize;
        int collisionTopTile = collisionTopY / tileSize;
        int collisionBottomTile = collisionBottomY / tileSize;

        if (object.direction.equals("up")){
            // target movement location
            collisionTopTile = (collisionTopY - object.speed) / tileSize;
            if (mapController.tileMap[collisionLeftTile][collisionTopTile] == null||
                    mapController.tileMap[collisionRightTile][collisionTopTile] == null
            ){
                return false;
            }
            if (mapController.tileMap[collisionLeftTile][collisionTopTile].collidable||
                mapController.tileMap[collisionRightTile][collisionTopTile].collidable
            ){
                return true;
            }
            return false;
        } else if (object.direction.equals("down")){
            System.out.println(collisionLeftTile);
            System.out.println(collisionBottomTile);
            collisionBottomTile = (collisionBottomY + object.speed) / tileSize;
            if (collisionBottomTile >= (WINDOW_HEIGHT / tileSize)){
                return false;
            }
            if (mapController.tileMap[collisionLeftTile][collisionBottomTile] == null ||
                    mapController.tileMap[collisionRightTile][collisionBottomTile] == null
            ){
                return false;
            }
            if (mapController.tileMap[collisionLeftTile][collisionBottomTile].collidable ||
                mapController.tileMap[collisionRightTile][collisionBottomTile].collidable
            ){
                return true;
            }
            return false;
        } else if (object.direction.equals("left")){
            collisionLeftTile = (collisionLeftX - object.speed) / tileSize;
            if (mapController.tileMap[collisionLeftTile][collisionTopTile] == null ||
                    mapController.tileMap[collisionLeftTile][collisionBottomTile] == null
            ) {
                return false;
            }
            if (mapController.tileMap[collisionLeftTile][collisionTopTile].collidable||
                mapController.tileMap[collisionLeftTile][collisionBottomTile].collidable
            ) {
                return true;
            }
            return false;
        } else { // object.direction.equals("right")
            collisionRightTile = (collisionRightX + object.speed) / tileSize;
            if (collisionRightTile >= (WINDOW_WIDTH / tileSize)){
                return false;
            }
            if (mapController.tileMap[collisionRightTile][collisionTopTile] == null ||
                    mapController.tileMap[collisionRightTile][collisionBottomTile] == null
            ) {
                return false;
            }
            if (mapController.tileMap[collisionRightTile][collisionTopTile].collidable ||
                mapController.tileMap[collisionRightTile][collisionBottomTile].collidable
            ) {
                return true;
            }
            return false;
        }
    }
}
