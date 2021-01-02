package builders;

import enums.directions.Directions;
import mapcomponents.Player;
import roomcomponents.FlashLight;
import roomcomponents.nullobjects.NullFlashlight;

public class PlayerBuilder {
  private Directions direction = Directions.NORTH;
  private int money = 0;
  private FlashLight flashlight = new NullFlashlight();

  public PlayerBuilder setDirection(Directions direction) {
    this.direction = direction;
    return this;
  }

  public PlayerBuilder setMoney(int money) {
    this.money = money;
    return this;
  }

  public PlayerBuilder setFlashlight(FlashLight flashlight) {
    this.flashlight = flashlight;
    return this;
  }

  public Player build() {
    return new Player(this.direction, this.money, this.flashlight);
  }

  @Override
  public String toString() {
    return "PlayerBuilder";
  }
}
