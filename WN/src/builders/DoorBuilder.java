package builders;

import roomcomponents.Door;
import roomcomponents.Key;

public class DoorBuilder {

  private String name;
  private Key requestedKey ;
  private boolean isOpen = true;

  public DoorBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public DoorBuilder setRequestedKey(Key requestedKey) {
    this.requestedKey = requestedKey;
    return this;
  }

  public DoorBuilder setOpen(boolean open) {
    this.isOpen = open;
    return this;
  }

  public Door build() {
    if ((this.requestedKey.getDescription() == "Null") || this.name == null)
      throw new IllegalArgumentException();

    return new Door(this.name, this.isOpen, this.requestedKey);
  }


  @Override
  public String toString() {
    return "DoorBuilder";
  }
}
