package builders;

import interfaces.Containable;
import roomcomponents.Chest;
import roomcomponents.Key;
import java.util.ArrayList;

public class ChestBuilder {

  private String chestName;
  private boolean isOpen = false;
  private Key requiredKey ;
  private ArrayList<Containable> content = new ArrayList<>();

  public ChestBuilder setChestName(String name) {
    this.chestName = name;
    return this;
  }

  public ChestBuilder setOpen(boolean open) {
    isOpen = open;
    return this;
  }

  public ChestBuilder setRequiredKey(Key requiredKey) {
    this.requiredKey = requiredKey;
    return this;
  }


  public Chest build() {
    if ((this.requiredKey.getDescription() == "Null") || this.chestName == null)
      throw new IllegalArgumentException();
    return new Chest(this.chestName,this.isOpen, this.requiredKey, this.content);
  }

  @Override
  public String toString() {
    return "ChestBuilder";
  }
}
