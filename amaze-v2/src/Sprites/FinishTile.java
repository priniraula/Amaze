package Sprites;

/**
 * Finish tile class which extends of the abstract class Tile
 * Basically sets the tile for the end point
 */
public class FinishTile extends Tile {

  /**
   * Constructor finish tile which utilizes the Tile constructor to assign finish value
   * @param id value for the tile
   */
  public FinishTile (int id){
    super(Assets.finish, id);
  }

  /**
   * Determines if the given object is not walk-able
   * @return always false
   */
  public boolean isSolid(){
    return false;
  }
}
