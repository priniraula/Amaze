package Sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Image loader class which basically tries to open the image file specified in path
 */
public class ImageLoader {

  /**
   * Static class which tries to open the image specified in path
   * @param path String of the path location
   * @return returns the image if it was able to open it correctly; else throws error
   */
  public static BufferedImage loadImage(String path) {
    try {
      return ImageIO.read(ImageLoader.class.getResource(path));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    return null;
  }
}
