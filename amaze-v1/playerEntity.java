//Player Entity Class

import java.awt.*;
import java.awt.event.WindowEvent;

public  class playerEntity {

    //Initializing variables

    public static final float DEFAULT_SPEED = 6.0f;
    public static final int DEFAULT_PLAYER_WIDTH = 64,
            DEFAULT_PLAYER_HEIGHT = 64;


    private float x, y;
    private float xMove, yMove;
    private int width, height;
    protected Rectangle bounds;
    private Handler handler;

    protected float speed;


    public playerEntity(Handler handler, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.handler = handler;
        this.width = width;
        this.height = height;
        speed = DEFAULT_SPEED;

        bounds= new Rectangle(0, 0, width, height);

        bounds.x = 16;
        bounds.y = 16;
        bounds.width = 32;
        bounds.height = 32;
    }


    public void tick(){
        getInput();
        move();

        if(finish()) {
            Display.frame.setVisible(false);
            Display.frame.dispose();
            Display.frame.dispatchEvent(new WindowEvent(Display.frame, WindowEvent.WINDOW_DEACTIVATED));
            handler.getGame().running = false;

        }
        handler.getGameCamera().centerOnEntity(this);
    }

    //Input

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up)
            yMove = -speed;

        if (handler.getKeyManager().down)
            yMove = speed;

        if (handler.getKeyManager().left)
            xMove = -speed;

        if (handler.getKeyManager().right)
            xMove = speed;

    }

    //Movement

    public void move(){
        moveX();
        moveY();
    }

    //Checking if maze is completed

    public boolean finish () {
        int finalX, finalY;
        finalX = MazeGen.finishX * Tile.TILEWIDTH;
        finalY = MazeGen.finishY * Tile.TILEWIDTH;

        if (x > finalX && x < (finalX + Tile.TILEWIDTH) && y > finalY && x < (finalY + Tile.TILEWIDTH))
            return true;
        return false;
    }

    //Movement and collision detection

    public void moveX(){
        if(xMove > 0){//Moving right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
                x += xMove;
            }
        }else if(xMove < 0){//Moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
                x += xMove;
            }
        }
    }

    public void moveY(){
        if(yMove < 0){//Up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
                y += yMove;
            }
        }else if(yMove > 0){//Down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
                y += yMove;
            }
        }
    }

    //Collision

    protected boolean collisionWithTile(int x, int y){
        return Maze.getTile(x, y).isSolid();
    }

    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }


    //Getters and setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
