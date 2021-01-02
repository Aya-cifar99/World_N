package roomcomponents.nullobjects;

import roomcomponents.Key;

import java.io.Serializable;

public class NullKey extends Key implements Facade,Serializable {
    public NullKey() {
        super("Null",0,"Null");
    }

    public static String description(){
        return "Null";
    }
    @Override
    public String getDescription() {
        return "Null";
    }

    @Override
    public String toString() {
        return "Null";
    }

    @Override
    public String getClassName() {
        return "Null";
    }
}
