package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Display class specifically used to display the frame and panels for the actual game
 */
public class Display {
  public static JFrame game_frame;
  private Canvas game_canvas;

  private String game_title;
  private int canvas_width, canvas_height;

  /**
   * Initializes the game frame
   * @param title the title of the JFrame
   * @param width the width of the frame
   * @param height the height of the frame
   */
  public Display (String title, int width, int height){

    this.game_title = title;
    this.canvas_width = width;
    this.canvas_height = height;

    createDisplay();
  }

  /**
   * initializes the main frame aspect of the game
   */
  private void createDisplay(){
    //Initializing frame

    game_frame = new JFrame(game_title);
    game_frame.setSize(canvas_width, canvas_height);
    game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game_frame.setResizable(false);
    game_frame.setLocationRelativeTo(null);
    game_frame.setVisible(true);

    //Initializing canvas

    game_canvas = new Canvas();
    game_canvas.setPreferredSize(new Dimension(canvas_width, canvas_height));
    game_canvas.setMaximumSize(new Dimension(canvas_width, canvas_height));
    game_canvas.setMinimumSize(new Dimension(canvas_width, canvas_height));
    game_canvas.setFocusable(false);

    game_frame.add(game_canvas);
    game_frame.pack();
  }

  /**
   * Getter method for the canvas
   * @return game canvas which consists of the label components
   */
  public Canvas getCanvas() {
    return game_canvas;
  }

  /**
   * Getter method for the frame
   * @return frame which holds the entire components
   */
  public JFrame getFrame(){
    return game_frame;
  }
}
