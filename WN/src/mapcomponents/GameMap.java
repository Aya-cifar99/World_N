package mapcomponents;

import interfaces.Containable;

import java.io.Serializable;
import java.util.ArrayList;

public class GameMap implements Serializable {

  private mapcomponents.Room startRoom;
  private mapcomponents.Room endRoom;
  private ArrayList<Containable> itemsList;

  private GameMap(mapcomponents.Room startRoom, mapcomponents.Room endRoom, ArrayList<Containable> itemsList) {
    this.startRoom = startRoom;
    this.endRoom = endRoom;
    this.itemsList = itemsList;
  }

  public static GameMap create(mapcomponents.Room startRoom, mapcomponents.Room endRoom, ArrayList<Containable> itemsList) {
    return new GameMap(startRoom, endRoom, itemsList);
  }

  public mapcomponents.Room getStartRoom() {
    return startRoom;
  }

  public mapcomponents.Room getEndRoom() {
    return endRoom;
  }

  public ArrayList<Containable> getItemsList() {
    return itemsList;
  }

  @Override
  public String toString() {
    return "GameMap";
  }
}
