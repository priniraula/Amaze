package Sprites;

/**
 * Wall tile class which extends of the abstract class Tile
 * Basically sets the wall frames
 */
public class WallTile extends Tile {

  /**
   * Constructor wall tile which utilizes the Tile constructor to assign wall value
   * @param id
   */
  public WallTile (int id){
    super(Assets.wall, id);
  }

  /**
   * Determines if the given object is wall or not
   * @return always true
   */
  public boolean isSolid(){
    return true;
  }
}
