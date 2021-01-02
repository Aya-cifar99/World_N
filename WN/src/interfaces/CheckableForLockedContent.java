package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface CheckableForLockedContent {
    public HashMap<Boolean, ArrayList<Containable>> check();

}
