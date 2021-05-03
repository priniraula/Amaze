package Sprites;

import java.awt.image.BufferedImage;

/**
 * Sprite sheet class which basically just return the cropped image
 */
public class SpriteSheet {

  protected BufferedImage sprite_sheet;

  /**
   * Constructor for the class
   * @param sprite_sheet gets the sheet to crop
   */
  public SpriteSheet (BufferedImage sprite_sheet){
    this.sprite_sheet = sprite_sheet;
  }

  /**
   * Crops the sheet based on the specifications
   * @param x the starting x position of the crop
   * @param y the starting y position of the crop
   * @param width the horizontal distance to crop upto
   * @param height the vertical distance to crop upto
   * @return
   */
  public BufferedImage crop(int x, int y, int width, int height) {
    return sprite_sheet.getSubimage(x, y, width, height);
  }
}
