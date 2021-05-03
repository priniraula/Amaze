package Render;

import java.awt.*;

import Maze.Maze;
import Maze.MazeGen;
import MISC.Handler;
import Sprites.Tile;

/**
 * Class which handles the game settings
 */
public class GameState extends State{
  private PlayerEntity player;
  private Maze maze;

  public GameState(Handler handler){
    super(handler);
    final String FILE_PATH = "../../MISC/maze.txt";

    maze = new Maze(handler, FILE_PATH);
    handler.setMaze(maze);

    player = new PlayerEntity (
      handler, 
      MazeGen.startX * Tile.TILEWIDTH, 
      MazeGen.startY * Tile.TILEWIDTH, 
      PlayerEntity.DEFAULT_PLAYER_WIDTH, 
      PlayerEntity.DEFAULT_PLAYER_HEIGHT
    );
  }

  public void tick(){
    maze.tick();
    player.tick();
  }

  public void render(Graphics g){
    maze.render(g);
    player.render(g);
  }
}
