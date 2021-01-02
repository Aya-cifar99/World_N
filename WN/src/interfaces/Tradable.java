package interfaces;

import java.util.List;

public interface Tradable extends Buyable, interfaces.Sellable {
  public List<interfaces.Containable> getItems();
}
