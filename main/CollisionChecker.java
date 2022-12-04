package main;

import main.controllers.MapController;
import main.models.GameObject;

public class CollisionChecker {
    MapController mapController;

    public CollisionChecker(MapController mapController){
        this.mapController = mapController;
    }

    public boolean checkCollision(GameObject object){
        // coordinates of the objects hit-box (collisionArea)
        int collisionLeftX = object.locationX + object.collisionArea.x;
        int collisionRightX = object.locationX + object.collisionArea.x + object.collisionArea.width;
        int collisionTopY = object.locationY + object.collisionArea.y;
        int collisionBottomY = object.locationY + object.collisionArea.y + object.collisionArea.height;

        int collisionLeftTile = collisionLeftX / 48;
        int collisionRightTile = collisionRightX / 48;
        int collisionTopTile = collisionTopY / 48;
        int collisionBottomTile = collisionBottomY / 48;

        if (object.direction.equals("up")){
            // target movement location
            collisionTopTile = (collisionTopY - object.speed) / 48;
            if (mapController.tileMap[collisionTopTile][collisionLeftTile] == null||
                    mapController.tileMap[collisionTopTile][collisionRightTile] == null
            ){
                return false;
            }
            if (mapController.tileMap[collisionTopTile][collisionLeftTile].collidable||
                mapController.tileMap[collisionTopTile][collisionRightTile].collidable
            ){
                return true;
            }
            return false;
        } else if (object.direction.equals("down")){
            collisionBottomTile = (collisionBottomY + object.speed) / 48;
            if (mapController.tileMap[collisionBottomTile][collisionLeftTile] == null ||
                    mapController.tileMap[collisionBottomTile][collisionRightTile] == null
            ){
                return false;
            }
            if (mapController.tileMap[collisionBottomTile][collisionLeftTile].collidable ||
                mapController.tileMap[collisionBottomTile][collisionRightTile].collidable
            ){
                return true;
            }
            return false;
        } else if (object.direction.equals("left")){
            collisionLeftTile = (collisionLeftX - object.speed) / 48;
            if (mapController.tileMap[collisionTopTile][collisionLeftTile] == null ||
                    mapController.tileMap[collisionBottomTile][collisionLeftTile] == null
            ) {
                return false;
            }
            if (mapController.tileMap[collisionTopTile][collisionLeftTile].collidable||
                mapController.tileMap[collisionBottomTile][collisionLeftTile].collidable
            ) {
                return true;
            }
            return false;
        } else { // object.direction.equals("right")
            collisionRightTile = (collisionRightX + object.speed) / 48;
            if (mapController.tileMap[collisionTopTile][collisionRightTile] == null ||
                    mapController.tileMap[collisionBottomTile][collisionRightTile] == null
            ) {
                return false;
            }
            if (mapController.tileMap[collisionTopTile][collisionRightTile].collidable ||
                mapController.tileMap[collisionBottomTile][collisionRightTile].collidable
            ) {
                return true;
            }
            return false;
        }
    }
}
