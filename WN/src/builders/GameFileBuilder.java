package builders;

import engine.Engine;

import java.io.*;

public class GameFileBuilder implements Serializable {
  public GameFileBuilder() {}

  public static void serializeGameInFile(Engine engine, String filePath) {
    try {
      FileOutputStream fileOut = new FileOutputStream(filePath);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(engine);
      out.close();
      fileOut.close();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  public static void saveGameFile(Engine engine) {
    File file = new File("").getAbsoluteFile();
    GameFileBuilder.serializeGameInFile(engine, file + "/src/files/BuildInGames/" + engine.getGameName() + ".ser");
  }

  public static Engine getGameFromFile(String filePath) {
    Engine gameFromFile = null;
    try {
      FileInputStream fileIn = new FileInputStream(filePath);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      gameFromFile = (Engine) in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException i) {
      i.printStackTrace();
    } catch (ClassNotFoundException c) {
      c.printStackTrace();
    }
    return gameFromFile;
  }

  public static Engine getSavedGame(String fileName) {
    File file = new File("").getAbsoluteFile();
    return GameFileBuilder.getGameFromFile(file + "/src/files/BuildInGames/" + fileName + ".ser");
  }

  public static void saveGameInfo(Engine engine) {
    File file = new File("").getAbsoluteFile();
    GameFileBuilder.serializeGameInFile(
            engine, file + "/src/files/TemporaryGames/" + engine.getGameName() + ".ser");
  }

  public static Engine loadGameInfo(String fileName) {
    File file = new File("").getAbsoluteFile();
    return GameFileBuilder.getGameFromFile(file + "/src/files/TemporaryGames/" + fileName + ".ser");
  }

  @Override
  public String toString() {
    return "GameFileBuilder";
  }
}
