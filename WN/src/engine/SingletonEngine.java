package engine;

import builders.PlayerBuilder;
import mapcomponents.GameMap;
import mapcreation.MapCreation;

public class SingletonEngine {

    private static Engine demoGame;
    private SingletonEngine() {
    }

    public static Engine getControls() {
        if (demoGame == null) {
            GameMap gameMap = new MapCreation().getDemoMap();
            demoGame = Engine.create("newGame", gameMap, new PlayerBuilder().build(), 600000);
        }
        return demoGame;
    }


}
