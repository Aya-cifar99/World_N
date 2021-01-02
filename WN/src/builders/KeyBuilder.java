package builders;

import roomcomponents.Key;

public class KeyBuilder {

  private String name;
  private int price;
  private String relatedLock="Null";

  public KeyBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public KeyBuilder setPrice(int price) {
    this.price = price;
    return this;
  }

  public KeyBuilder setNullLock(String relatedLock) {
    this.relatedLock = relatedLock;
    return this;
  }

  public Key build() {
    if (name == null || relatedLock == null)
      throw new IllegalArgumentException();

    return new Key(this.name, this.price, this.relatedLock);
  }

  @Override
  public String toString() {
    return "KeyBuilder";
  }
}
