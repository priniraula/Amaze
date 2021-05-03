package Sprites;

/**
 * Class which inherits from the abstract class Tile
 */
public class PathTile extends Tile {

  /**
   * Calls the super constructor to set the path and id of the path tile
   * @param id integer value of the id. Since path is walking tile, it has value 0
   */
  public PathTile(int id){
    super (Assets.path, id);
  }
}