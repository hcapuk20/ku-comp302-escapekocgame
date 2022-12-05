package main.models;

import main.controllers.RoomCreator;

public class BuildingsDataSource {

    public static Building[] buildings = new Building[6];

    RoomCreator roomCreator = new RoomCreator();

    Building building1, building2, building3, building4, building5, building6;

    public BuildingsDataSource(){

        building1 = new Building("Student Center", 5);
        building1.rooms[1][0] = roomCreator.createRoom(0,1,0,0);
        building1.rooms[1][1] = roomCreator.createRoom(1,1,0,0);
        building1.rooms[1][2] = roomCreator.createRoom(1,0,0,0);
        buildings[0] = building1;

        building2 = new Building("CASE Building", 7);
        building2.rooms[1][0] = roomCreator.createRoom(0,1,0,1);
        building2.rooms[1][1] = roomCreator.createRoom(1,0,1,0);
        building2.rooms[0][0] = roomCreator.createRoom(0,0,1,0);
        building2.rooms[2][1] = roomCreator.createRoom(0,0,0,1);
        buildings[1] = building2;

        building3 = new Building("SOS Building", 10);
        building3.rooms[1][0] = roomCreator.createRoom(0,1,0,0);
        building3.rooms[0][1] = roomCreator.createRoom(0,0,1,0);
        building3.rooms[1][1] = roomCreator.createRoom(1,1,0,1);
        building3.rooms[1][2] = roomCreator.createRoom(1,0,1,0);
        building3.rooms[2][2] = roomCreator.createRoom(0,0,0,1);
        buildings[2] = building3;

        building4 = new Building("SCI Building", 14);
        building4.rooms[0][0] = roomCreator.createRoom(0,0,1,0);
        building4.rooms[1][0] = roomCreator.createRoom(0,1,1,1);
        building4.rooms[2][0] = roomCreator.createRoom(0,0,0,1);
        building4.rooms[1][1] = roomCreator.createRoom(1,1,0,0);
        building4.rooms[1][2] = roomCreator.createRoom(1,0,0,0);
        buildings[3] = building4;

        building5 = new Building("ENG Building", 19);
        building5.rooms[0][0] = roomCreator.createRoom(0,0,1,0);
        building5.rooms[1][0] = roomCreator.createRoom(0,1,0,1);
        building5.rooms[1][1] = roomCreator.createRoom(1,1,1,0);
        building5.rooms[2][1] = roomCreator.createRoom(0,1,0,1);
        building5.rooms[1][2] = roomCreator.createRoom(1,0,1,0);
        building5.rooms[2][2] = roomCreator.createRoom(1,0,0,1);
        buildings[4] = building5;

        building6 = new Building("SNA Building", 25);
        building6.rooms[0][0] = roomCreator.createRoom(0,1,1,0);
        building6.rooms[1][0] = roomCreator.createRoom(0,1,1,1);
        building6.rooms[2][0] = roomCreator.createRoom(0,1,0,1);
        building6.rooms[0][1] = roomCreator.createRoom(1,0,1,0);
        building6.rooms[1][1] = roomCreator.createRoom(1,1,1,1);
        building6.rooms[2][1] = roomCreator.createRoom(1,0,0,1);
        building6.rooms[1][2] = roomCreator.createRoom(1,0,0,0);
        buildings[5] = building6;

    }

}
