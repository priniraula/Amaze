package Render;

import MISC.Handler;

import java.awt.*;

/**
 * Abstract class State
 * Most consists of just getters and setters
 */
public abstract class State {
  protected Handler handler;
  public static State currentState = null;

  public static void setState(State state){
    currentState = state;
  }

  public static State getState(){
    return currentState;
  }


  public State (Handler handler) {
    this.handler = handler;
  }

  public abstract void tick();
  public abstract void render(Graphics g);
}
