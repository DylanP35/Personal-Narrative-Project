import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  
  /** Constructor */
  public ImageFilter(String fileName) {
    super(fileName);
  }

  // Add filter methods here...
  // The colorShift filter method
    public void colorShift(int value) {
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length; row++){
      for (int col = 0; col < pixels[0].length; col++){
        Pixel p = pixels[row][col];
 
        
        int red = p.getRed();
        int green = p.getGreen();
        int blue = p.getBlue();

        
        int newRed = red + value;
        int newGreen = green + value;
        int newBlue = blue + value;

        if (newRed > 255) {
          newRed = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
      }
        if (newGreen > 255){ 
          newGreen = 255;
        }

        p.setRed(newRed);
        p.setGreen(newGreen);
        p.setBlue(newBlue);
      }
    }

    }
  // The saturate filter method
  public void saturate(int factor) {
        Pixel[][] pixels = getImagePixels();

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                Pixel p = pixels[row][col];

                int r = p.getRed();
                int g = p.getGreen();
                int b = p.getBlue();

                int average = (r + g + b) / 3;
                int adjustedGrayscale = average + (average - 255) * factor;

                int newRed = 2 * adjustedGrayscale - r;
                int newGreen = 2 * adjustedGrayscale - g;
                int newBlue = 2 * adjustedGrayscale - b;

                if (newRed > 255) newRed = 255;
                if (newGreen > 255) newGreen = 255;
                if (newBlue > 255) newBlue = 255;

                if (newRed < 0) newRed = 0;
                if (newGreen < 0) newGreen = 0;
                if (newBlue < 0) newBlue = 0;

                p.setRed(newRed);
                p.setGreen(newGreen);
                p.setBlue(newBlue);
            }
        }
    }
  // The motionBlur image filter method
    public void motionBlur(int length, String direction) {
        Pixel[][] pixels = getImagePixels();
        int height = pixels.length;
        int width = pixels[0].length;
        
        Pixel[][] originalPixels = new Pixel[height][width];
        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++){
                originalPixels[row][col] = pixels[row][col];
            }
        }

        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++){
                int totalRed = 0;
                int totalGreen = 0;
                int totalBlue = 0;
                int count = 0;
                
                for (int i = 0; i < length; i++) {
                    int currentRow = row;
                    int currentCol = col;
                    
                    if (direction.equals("horizontal")) {
                        currentCol = col + i;
                    } else if (direction.equals("vertical")) {
                        currentRow = row + i;
                    } else if (direction.equals("diagonal")) {
                        currentRow = row + i;
                        currentCol = col + i;
                    }
                    
                    if (currentRow < height && currentCol < width) {
                        totalRed += originalPixels[currentRow][currentCol].getRed();
                        totalGreen += originalPixels[currentRow][currentCol].getGreen();
                        totalBlue += originalPixels[currentRow][currentCol].getBlue();
                        count++;
                    }
                }
                
                if (count > 0) {
                    pixels[row][col].setRed(totalRed / count);
                    pixels[row][col].setGreen(totalGreen / count);
                    pixels[row][col].setBlue(totalBlue / count);
                }
            }
        }
    }
  // The makeNegative image filter method
     public void makeNegative() {
        Pixel[][] pixels = getImagePixels();
        
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                Pixel p = pixels[row][col];
                
                int newRed = 255 - p.getRed();
                int newGreen = 255 - p.getGreen();
                int newBlue = 255 - p.getBlue();
                
                p.setRed(newRed);
                p.setGreen(newGreen);
                p.setBlue(newBlue);
            }
        }
    }
  // The sharpen image filter method
    public void sharpen() {
  Pixel[][] pixels = getImagePixels();
  Pixel[][] original = getPixelsFromImage();

  for (int row = 1; row < pixels.length - 1; row++) {
    for (int col = 1; col < pixels[0].length - 1; col++) {

      Pixel current = original[row][col];
      Pixel topLeft = original[row - 1][col - 1];

      int redDiff = current.getRed() - topLeft.getRed();
      int greenDiff = current.getGreen() - topLeft.getGreen();
      int blueDiff = current.getBlue() - topLeft.getBlue();

      int avgDiff = (redDiff + greenDiff + blueDiff) / 3;

      int newRed = pixels[row][col].getRed() + avgDiff;
      int newGreen = pixels[row][col].getGreen() + avgDiff;
      int newBlue = pixels[row][col].getBlue() + avgDiff;

      if (newRed > 255) newRed = 255;
      if (newGreen > 255) newGreen = 255;
      if (newBlue > 255) newBlue = 255;

      pixels[row][col].setRed(newRed);
      pixels[row][col].setGreen(newGreen);
      pixels[row][col].setBlue(newBlue);
    }
  }
}
}