package Sprites;

import java.awt.image.BufferedImage;

/**
 * Main spritesheet class which opens and crops the sprites
 */
public class Assets {
  private static final int WIDTH = 64, HEIGHT = 64;

  public static BufferedImage wall, path, player, finish;

  private static final String IMAGE_FILE_PATH = "/../../../../MISC/sheet.png";

  /**
   * Constructor for the class. Attempts to open the sprite sheets then crops them
   */
  public static void init(){
    SpriteSheet sheet =  new SpriteSheet(ImageLoader.loadImage(IMAGE_FILE_PATH));
    wall = sheet.crop(0, 0, WIDTH, HEIGHT);
    path = sheet.crop( WIDTH, 0, WIDTH, HEIGHT);
    player = sheet.crop (WIDTH * 2, 0, WIDTH, HEIGHT);
    finish = sheet.crop (WIDTH * 3, 0, WIDTH, HEIGHT);
  }
}
