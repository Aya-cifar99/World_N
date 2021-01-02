package roomcomponents.nullobjects;
import roomcomponents.FlashLight;

import java.io.Serializable;

public class NullFlashlight extends FlashLight implements Facade,Serializable {
    public NullFlashlight() {
        super(0);
    }
    @Override
    public void turnOn() { }
    @Override
    public void turnOff() { }
    @Override
    public boolean switchFlashlight() { return false; }
    @Override
    public String getName() {
        return NullFlashlight.className();
    }
    @Override
    public String getDescription() {
        return getName();
    }

    public static String className(){
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
