//Game state

import java.awt.*;

public class GameState extends State {

    private playerEntity player;
    private Maze maze;

    public GameState(Handler handler){
        super(handler);
        maze = new Maze(handler, "maze.txt");
        handler.setMaze(maze);
        player = new playerEntity(handler,MazeGen.startX*Tile.TILEWIDTH, MazeGen.startY*Tile.TILEWIDTH, playerEntity.DEFAULT_PLAYER_WIDTH, playerEntity.DEFAULT_PLAYER_HEIGHT);


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
