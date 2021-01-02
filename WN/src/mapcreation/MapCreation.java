package mapcreation;


import builders.*;
import enums.directions.Directions;
import mapcomponents.GameMap;
import mapcomponents.Room;
import interfaces.Containable;
import roomcomponents.*;

import java.io.Serializable;
import java.util.ArrayList;

public class MapCreation implements Serializable {

    private RoomBuilder roomBuilder = new RoomBuilder();
    private DoorBuilder doorBuilder = new DoorBuilder();
    private ChestBuilder chestBuilder = new ChestBuilder();
    private KeyBuilder keyBuilder = new KeyBuilder();
    private GameMap demoMap = null;
    private ArrayList<Containable> itemsInMap = new ArrayList<>();

    public MapCreation() {}

    private void demoMapBuild() {
        itemsInMap = new ArrayList<>();
        int flashLightPrice = 50;

        Room skyRoom = roomBuilder.setDark(false).setHasLights(true).build();
        Seller sellerInSkyRoom = new Seller();

        FlashLight flashInSkyRoom = FlashLight.valueOf(flashLightPrice);
        sellerInSkyRoom.addItem(flashInSkyRoom);
        this.itemsInMap.add(flashInSkyRoom);

        Key skyKey = this.keyBuilder.setName("Sky").setPrice(50).build();
        Door skyDoor = this.doorBuilder.setName("Sky").setOpen(false).setRequestedKey(skyKey).build();
        skyKey.setRelatedLock(skyDoor.getName());
        this.itemsInMap.add(skyKey);
        Painting paintingSkyRoom  = Painting.valueOf(skyKey);
        skyRoom.getWallInDirection(Directions.EAST).setWallContent(paintingSkyRoom);
        skyRoom.getWallInDirection(Directions.WEST).setWallContent(sellerInSkyRoom);

        Room cheeryRoom = roomBuilder.setDark(true).setHasLights(true).build();
        Key cheeryKey = this.keyBuilder.setName("Cheery").setPrice(300).build();
        Door cheeryDoor = this.doorBuilder.setName("Cheery").setOpen(false).setRequestedKey(cheeryKey).build();
        this.itemsInMap.add(cheeryKey);
        cheeryKey.setRelatedLock(cheeryDoor.getName());

        Key tightKey = this.keyBuilder.setName("Tight").setPrice(75).build();
        Door tightDoor = this.doorBuilder.setName("Tight").setOpen(false).setRequestedKey(tightKey).build();
        this.itemsInMap.add(tightKey);
        tightKey.setRelatedLock(tightDoor.getName());

        Key sweetKey = this.keyBuilder.setName("Sweet").setPrice(50).build();
        Door sweetDoor = this.doorBuilder.setName("Sweet").setOpen(true).setRequestedKey(sweetKey).build();
        this.itemsInMap.add(sweetKey);
        sweetKey.setRelatedLock(sweetDoor.getName());

        Room endRoom = roomBuilder.build();

        Room sweetRoom = roomBuilder.setHasLights(false).setDark(true).build();
        Room tightRoom = roomBuilder.setHasLights(true).setDark(true).build();

        Seller sweetSeller = new Seller();
        sweetSeller.addItem(cheeryKey);

        sweetSeller.addItem(FlashLight.valueOf(flashLightPrice));
        Mirror sweetMirror = Mirror.valueOf(tightKey);
        sweetRoom.getWallInDirection(Directions.NORTH).setWallContent(sweetSeller);
        sweetRoom.getWallInDirection(Directions.EAST).setWallContent(sweetMirror);

        Key tightChestKey = keyBuilder.setName("Tight Chest Key").setPrice(60).build();
        Chest tightChest = chestBuilder.setChestName("Tight Chest").setOpen(false).setRequiredKey(tightChestKey).build();
        tightChestKey.setRelatedLock(tightChest.getChestName());
        this.itemsInMap.add(tightChestKey);
        Painting tightPainting = Painting.valueOf(tightChestKey);
        tightChest.addItemToChest(new Gold(500));
        tightRoom.getWallInDirection(Directions.NORTH).setWallContent(tightPainting);
        tightRoom.getWallInDirection(Directions.SOUTH).setWallContent(tightChest);

        skyRoom.addDoorToRoom(skyDoor,cheeryRoom,Directions.NORTH);
        cheeryRoom.addDoorToRoom(cheeryDoor,endRoom,Directions.WEST);
        cheeryRoom.addDoorToRoom(sweetDoor,sweetRoom,Directions.NORTH);
        cheeryRoom.addDoorToRoom(tightDoor,tightRoom,Directions.EAST);

        this.demoMap= GameMap.create(skyRoom,endRoom,this.itemsInMap);
    }
    public GameMap getDemoMap() {
        demoMapBuild();
        return this.demoMap;
    }

    @Override
    public String toString() {
        return "MapCreation";
    }
}

