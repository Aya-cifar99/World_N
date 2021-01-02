package mapcomponents;

import interfaces.Wallable;
import roomcomponents.nullobjects.Plain;

import java.io.Serializable;
import java.util.Objects;

public class Wall implements Serializable {
  private Wallable wallContent;

  public Wall() {
    this.wallContent = new Plain();
  }

  public void setWallContent(Wallable content) {
    Objects.requireNonNull(content);
    this.wallContent = content;
  }

  public Wallable getWallContent() {
    return this.wallContent;
  }

  @Override
  public String toString() {
    return "Wall";
  }
}
