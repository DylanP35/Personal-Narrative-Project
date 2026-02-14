import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create any 2D arrays & variables to be passed as parameters to constructor

    String[][] players = {
      {"Shotime", "World Series", "Comet","Captain America", null},
      {"Yoshi", "Giant", "Trumpets","Lumberjack", null},
    };
    // Instantiate Scene subclass objects
    SceneOne scene1 = new SceneOne(players);
    SceneTwo scene2 = new SceneTwo(players);
    
    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scene1, scene2);
    
  }
}