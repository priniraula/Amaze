//Tile Class
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile {

    //Initializing tiles

    public static Tile[] tiles = new Tile[256];
    public static Tile pathTile = new PathTile(0);
    public static Tile wallTile = new WallTile(1);
    public static Tile finishTile = new FinishTile(2);

    //Class

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
