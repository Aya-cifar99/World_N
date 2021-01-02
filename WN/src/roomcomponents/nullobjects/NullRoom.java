package roomcomponents.nullobjects;
import mapcomponents.Room;

import java.io.Serializable;

public class NullRoom extends Room implements Facade,Serializable {
    public NullRoom() {
        super(true,false);
    }
    public static String className(){
        return "Null";
    }

    @Override
    public String getClassName() {
        return "Null";
    }

    @Override
    public String toString() {
        return "Null";
    }
}
