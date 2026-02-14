import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

  /** 
   * 2D array with the player data
   */
  private String[][] players;

  /**
   * Make sure players is initalized.
   */
  public SceneOne(String[][] players) {
    this.players = players;
  }

  /**
   * Draws the entire scene out
   */
  public void drawScene() {

    ImageFilter logo = new ImageFilter("dodgers.jpg");
    ImageFilter ohtaniShift = new ImageFilter("ohtani.jpg");
    ImageFilter freemanBlur = new ImageFilter("freeman.jpg");
    ImageFilter kimNegative = new ImageFilter("kim.jpg");
    ImageFilter smithSharpen = new ImageFilter("smith.jpg");

    drawImage(logo, 0, 0, 400, 400, 0);
    pause(1);
    logo.colorShift(50);
    drawImage(logo, 0, 0, 400, 400, 0);

    setTextHeight(30);
    drawText("Dodger Hitters", 60, 40);
    pause(1);

    clear("blue");
    setTextHeight(20);
    setTextColor("Blue");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    // Draw hitters images
    drawImage(ohtaniShift, 0, 0, 200, 200, 0);
    pause(1);
    ohtaniShift.saturate(1);
    drawImage(ohtaniShift, 0, 0, 200, 200, 0);
    drawPlayerName(players[0][0], 20, 20);
    playSound("Baseball-hit-wooden-bat-914.wav");
    pause(1);

    drawImage(freemanBlur, 200, 200, 200, 200, 0);
    pause(1);
    freemanBlur.motionBlur(10, "horizontal");
    drawImage(freemanBlur, 200, 200, 200, 200, 0);
    drawPlayerName(players[0][1], 220, 230);
    playSound("Baseball-hit-wooden-bat-914.wav");
    pause(1);

    setTextColor("Black");
    drawImage(kimNegative, 200, 0, 200, 200, 0);
    pause(1);
    kimNegative.makeNegative();
    drawImage(kimNegative, 200, 0, 200, 200, 0);
    drawPlayerName(players[0][2], 220, 30);
    playSound("Baseball-hit-wooden-bat-914.wav");
    pause(1);

    setTextColor("Blue");
    drawImage(smithSharpen, 0, 200, 200, 200, 0);
    pause(1);
    smithSharpen.sharpen();
    drawImage(smithSharpen, 0, 200, 200, 200, 0);
    drawPlayerName(players[0][3], 20, 230);
    playSound("Baseball-hit-wooden-bat-914.wav");

    pause(1);

    int totalHitters = countHitters();

    setTextColor("Black");
    drawText("Total Hitters: " + totalHitters, 80, 370);

    if (totalHitters >= 4) {
      drawText("Strong Offensive Lineup!", 40, 395);
    }

    pause(2);
  }

  /**
   * Counts the hitters
   */
  public int countHitters() {
    int count = 0;

    for (int col = 0; col < players[0].length; col++) {
      if (players[0][col] != null) {
        count++;
      }
    }

    return count;
  }

  /**
   * Draws the player names
   */
  public void drawPlayerName(String name, int x, int y) {
    if (name != null) {
      drawText(name, x, y);
    }
  }
}
