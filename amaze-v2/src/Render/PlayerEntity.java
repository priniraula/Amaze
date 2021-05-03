package Render;

import java.awt.*;
import java.awt.event.WindowEvent;

import MISC.Handler;
import Maze.Maze;
import Maze.MazeGen;
import UI.Display;
import Sprites.Tile;
import Sprites.Assets;

/**
 * Player Entity class consisting of render movements
 */
public class PlayerEntity {
  public static final float DEFAULT_SPEED = 6.0f;
  public static final int DEFAULT_PLAYER_WIDTH = 64;
  public static final int DEFAULT_PLAYER_HEIGHT = 64;

  private float x, y;
  private float xMove, yMove;
  private int width, height;
  protected Rectangle bounds;
  private Handler handler;

  protected float speed;

  /**
   * Constructor for the player entitiy class
   * @param handler
   * @param x
   * @param y
   * @param width
   * @param height
   */
  public PlayerEntity (Handler handler, float x, float y, int width, int height) {
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
      Display.game_frame.setVisible(false);
      Display.game_frame.dispose();
      Display.game_frame.dispatchEvent(new WindowEvent(Display.game_frame, WindowEvent.WINDOW_DEACTIVATED));
      handler.getGame().running = false;

    }

    handler.getGameCamera().centerOnEntity(this);
  }

  private void getInput(){
    xMove = 0;
    yMove = 0;

    if (handler.getKeyManager().up) {
      yMove = -speed;
    }
    if (handler.getKeyManager().down) {
      yMove = speed;
    }
    if (handler.getKeyManager().left) {
      xMove = -speed;
    }
    if (handler.getKeyManager().right) {
      xMove = speed;
    }
  }

  public void move(){
    moveX();
    moveY();
  }

  public boolean finish () {
    int finalX, finalY;
    finalX = MazeGen.finishX * Tile.TILEWIDTH;
    finalY = MazeGen.finishY * Tile.TILEWIDTH;

    if (x > finalX && x < (finalX + Tile.TILEWIDTH) && y > finalY && x < (finalY + Tile.TILEWIDTH)) {
      return true;
    }
    return false;
  }

  /**
   * Moving left and right 
   */
  public void moveX(){
    // Moving right
    if(xMove > 0){
      int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

      if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
        !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
        x += xMove;
      }
    }
    // Moving left
    else if(xMove < 0){
      int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

      if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
        !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
        x += xMove;
      }
    }
  }

  /**
   * Moving up and down 
   */
   public void moveY(){
    // Moving Up
    if(yMove < 0){
      int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

      if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
        !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
        y += yMove;
      }
    }
    // Moving Down;
    else if(yMove > 0){
      int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

      if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
        !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
        y += yMove;
      }
    }
  }

  protected boolean collisionWithTile(int x, int y){
    return Maze.getTile(x, y).isSolid();
  }

  public void render(Graphics g) {
    g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()),
      (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
  }

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