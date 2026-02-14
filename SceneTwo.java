import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  /** 
   * 2D array with players
   */
  private String[][] players;

  /**
   * Initalizes the players
   */
  public SceneTwo(String[][] players) {
    this.players = players;
  }

  /**
   * Draws the entire scene for the pitchers
   */
  public void drawScene() {

    ImageFilter pitcher = new ImageFilter("pitching.jpg");
    ImageFilter yamamotoShift = new ImageFilter("yamagoat.jpg");
    ImageFilter glasnowBlur = new ImageFilter("glasnow.jpg");
    ImageFilter diazNegative = new ImageFilter("diaz.jpg");
    ImageFilter kleinSharpen = new ImageFilter("klein.jpg");

    drawImage(pitcher, 0, 0, 400, 400, 0);
    pause(1);
    pitcher.colorShift(25);
    drawImage(pitcher, 0, 0, 400, 400, 0);

    setTextHeight(30);
    drawText("Dodger Pitchers", 60, 40);
    pause(1);

    clear("blue");
    setTextHeight(20);
    setTextColor("Blue");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    // Draw pitchers images and filters them
    drawImage(yamamotoShift, 0, 0, 200, 200, 0);
    pause(1);
    yamamotoShift.saturate(1);
    drawImage(yamamotoShift, 0, 0, 200, 200, 0);
    drawPlayerName(players[1][0], 20, 20);
    pause(1);

    drawImage(glasnowBlur, 200, 200, 200, 200, 0);
    pause(1);
    glasnowBlur.motionBlur(10, "horizontal");
    drawImage(glasnowBlur, 200, 200, 200, 200, 0);
    drawPlayerName(players[1][1], 220, 230);
    pause(1);

    drawImage(diazNegative, 200, 0, 200, 200, 0);
    pause(1);
    diazNegative.makeNegative();
    drawImage(diazNegative, 200, 0, 200, 200, 0);
    drawPlayerName(players[1][2], 220, 30);
    pause(1);

    drawImage(kleinSharpen, 0, 200, 200, 200, 0);
    pause(1);
    kleinSharpen.sharpen();
    drawImage(kleinSharpen, 0, 200, 200, 200, 0);
    drawPlayerName(players[1][3], 20, 230);

    pause(1);


    int totalPitchers = countPitchers();
    setTextColor("White");
    drawText("Total Pitchers: " + totalPitchers, 80, 370);

    if (totalPitchers >= 4) {
      drawText("Strong Defensive Rotation!", 40, 395);
    }

    pause(2);
  }

  /**
   * Counts the pitchers
   */
  public int countPitchers() {
    int count = 0;

    for (int col = 0; col < players[1].length; col++) {
      if (players[1][col] != null) {
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
