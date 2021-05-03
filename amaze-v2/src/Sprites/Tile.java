package Sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Abstract class Tile which determines assigns the value for path
 */
public abstract class Tile {

  public static Tile[] tiles = new Tile[256];
  public static Tile pathTile = new PathTile(0);
  public static Tile wallTile = new WallTile(1);
  public static Tile finishTile = new FinishTile(2);

  public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

  protected BufferedImage texture;
  protected final int id;

  /**
   * Super constructor which assigns the texture value based on its id
   * @param texture texture used to draw the actual frame
   * @param id the value of the id which determines if it is path, wall, of finish tile
   */
  public Tile(BufferedImage texture, int id) {
    this.texture = texture;
    this.id = id;
    tiles[id] = this;
  }

  /**
   * The actual render section which draws the texture
   * @param g Graphics canvas which draws the components
   * @param x Start X location
   * @param y Start Y location
   */
  public void render(Graphics g, int x, int y){
    g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
  }

  /**
   * Super method which determines if component is solid of not
   * @return boolen value determining if it is solid: Changes according to classes which inherit this method
   */
  public boolean isSolid(){
    return false;
  }

  /**
   * @deprecated deprecated method. Will be removed soon
   * @return returns the id value of the given texture
   */
  public int getId(){
    return id;
  }
}
