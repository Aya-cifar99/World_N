package roomcomponents.nullobjects;
import interfaces.Wallable;

import java.io.Serializable;

public class Plain implements Facade,Wallable, Serializable {
    @Override
    public String look() {
        return "Plain";
    }

    @Override
    public String getClassName() {
        return "Null";
    }

    @Override
    public String toString() {
        return "Plain";
    }
}
