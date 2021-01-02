package roomcomponents.nullobjects;

import roomcomponents.Door;

import java.io.Serializable;

public class NullDoor extends Door implements Facade,Serializable {
    public NullDoor() {
        super("Null",false ,new roomcomponents.nullobjects.NullKey() );
    }
    public static String className(){
        return "Null";
    }

    @Override
    public String toString() { return "Null";}

    @Override
    public String getClassName() {
        return "Null";
    }
}
