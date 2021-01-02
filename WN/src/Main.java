import engine.Engine;
import engine.SingletonEngine;

public class Main {

    public static void main(String[] args) {
        Engine demoGame = SingletonEngine.getControls();
        demoGame.start();
}
}
