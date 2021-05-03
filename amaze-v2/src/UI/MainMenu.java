package UI;

import Maze.MazeGen;
import Render.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main menu class:
 * This class generates the main window for the game. This also contains the
 * modes menu as well
 */

public class MainMenu extends JFrame implements ActionListener {
  private JFrame main_menu_frame;
  private JFrame modes_menu_frame;

  private JPanel main_menu_panel;

  private JLabel main_menu_title;
  private JLabel main_menu_version_number;
  private JLabel main_menu_creator_label;
  private JLabel main_menu_message_1;

  private JButton main_menu_play_button;
  private JButton main_menu_instructions_button;
  private JButton main_menu_exit_button;

  private JPanel modes_menu_jpanel;

  private JButton modes_menu_easy_mode_button;
  private JButton modes_menu_medium_mode_button;
  private JButton modes_menu_hard_mode_button;

  private final double AMAZE_VERSION = 2.0;

  public void launchMainMenu (){
    // Main menu JFrame drawings

    final String MAIN_MENU_STRING = "WELCOME TO AMAZE! Version: " + AMAZE_VERSION;
    final int MAIN_MENU_SQUARE_DIMENSIONS = 600;

    main_menu_frame = new JFrame(MAIN_MENU_STRING);
    main_menu_frame.setSize(MAIN_MENU_SQUARE_DIMENSIONS, MAIN_MENU_SQUARE_DIMENSIONS);
    main_menu_frame.setBackground(Color.WHITE);
    main_menu_frame.setLocationRelativeTo(null);
    main_menu_frame.setResizable(false);
    main_menu_frame.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);

    // Main menu JPanel drawings
    main_menu_panel = new JPanel();
    main_menu_panel.setBackground(Color.WHITE);
    main_menu_panel.setPreferredSize(new Dimension(MAIN_MENU_SQUARE_DIMENSIONS, MAIN_MENU_SQUARE_DIMENSIONS));
    main_menu_panel.setLayout(null);

    // Main menu title properties and updates

    final String TITLE_MESSAGE = "Welcime to Amaze!";

    main_menu_title = new JLabel(TITLE_MESSAGE);
    main_menu_title.setSize(500, 150);
    main_menu_title.setLocation(100, 100);
    main_menu_title.setForeground(Color.BLACK);
    main_menu_title.setFont(new Font("Arial", Font.BOLD, 45));
    main_menu_title.setVisible(true);

    // Main menu version properties and updates

    main_menu_version_number = new JLabel("Version: " + AMAZE_VERSION);
    main_menu_version_number.setSize(200, 100);
    main_menu_version_number.setForeground(Color.BLACK);
    main_menu_version_number.setLocation(250, 180);
    main_menu_version_number.setFont(new Font("Arial", Font.PLAIN, 20));
    main_menu_version_number.setVisible(true);

    // Main menu message 1 properties and updates

    main_menu_message_1 = new JLabel("A Game developed by: ");
    main_menu_message_1.setSize(400, 100);
    main_menu_message_1.setForeground(Color.BLACK);
    main_menu_message_1.setLocation(50, 475);
    main_menu_message_1.setFont(new Font("Arial", Font.ITALIC, 15));

    // Main menu author creator properties and updates

    final String author_1 = "Dennis Rapopport";
    final String author_2 = "Prithul Niraula";

    main_menu_creator_label = new JLabel(author_1 + " and " + author_2);
    main_menu_creator_label.setSize(400, 100);
    main_menu_creator_label.setForeground(Color.BLACK);
    main_menu_creator_label.setLocation(125, 495);
    main_menu_creator_label.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));

    // Main menu play button properties and updates

    main_menu_play_button = new JButton("Start Game");
    main_menu_play_button.setSize(200, 50);
    main_menu_play_button.setForeground(Color.BLACK);
    main_menu_play_button.setLocation(200, 250);
    main_menu_play_button.setContentAreaFilled(false);
    main_menu_play_button.setBorderPainted(false);
    main_menu_play_button.setFont(new Font("Arial", Font.BOLD, 15));
    main_menu_play_button.addActionListener(this);

    // Main menu instructions button properties and updates

    main_menu_instructions_button = new JButton("Game Instructions");
    main_menu_instructions_button.setSize(300, 50);
    main_menu_instructions_button.setForeground(Color.BLACK);
    main_menu_instructions_button.setLocation(150, 280);
    main_menu_instructions_button.setContentAreaFilled(false);
    main_menu_instructions_button.setBorderPainted(false);
    main_menu_instructions_button.setFont(new Font("Arial", Font.BOLD, 15));
    main_menu_instructions_button.addActionListener(this);

    // Main menu exit button properties and updates

    main_menu_exit_button = new JButton("Exit Game");
    main_menu_exit_button.setSize(300, 50);
    main_menu_exit_button.setForeground(Color.BLACK);
    main_menu_exit_button.setLocation(150, 310);
    main_menu_exit_button.setContentAreaFilled(false);
    main_menu_exit_button.setBorderPainted(false);
    main_menu_exit_button.setFont(new Font("Arial", Font.BOLD, 15));
    main_menu_exit_button.addActionListener(this);

    // adding all the frame components to the panel and packing it

    main_menu_panel.add(main_menu_title);
    main_menu_panel.add(main_menu_version_number);
    main_menu_panel.add(main_menu_message_1);
    main_menu_panel.add(main_menu_creator_label);
    main_menu_panel.add(main_menu_play_button);
    main_menu_panel.add(main_menu_instructions_button);
    main_menu_panel.add(main_menu_exit_button);

    main_menu_frame.add(main_menu_panel);
    main_menu_frame.pack();

    main_menu_frame.setVisible(true);
  }

  /**
   * Creates a new JLabel for the modes frame
   * @param title title of the Jlabel
   * @param yPos vertical position to place the label
   */
  public void createModesJLabel (final String title, final int yPos) {
    JLabel label = new JLabel(title);
    label.setSize(250, 50);
    label.setLocation(200, yPos);
    label.setForeground(Color.BLACK);
    label.setFont(new Font("Arial", Font.PLAIN, 15));
    modes_menu_jpanel.add(label);
    label.setVisible(true);
  }

  /**
   * Create a new general JLabel
   * @param string title of the JLabel
   * @param down vertical position of the JLabel
   * @param panel JPanel to attach the jlabel to
   * @param increment If increment is 0, then it must be bold, otherwise no
   */
  public void createJLabel (final String string, final int down, JPanel panel, final int increment) {
    JLabel label = new JLabel();
    if (increment == 0) {
      label.setForeground(Color.BLACK);
      label.setText(string);
      label.setSize(500, 50);
      label.setLocation(150, down);
      label.setFont(new Font("Arial", Font.ITALIC, 22));
      label.setVisible(true);
      panel.add(label);
    }
    else {
      label.setForeground(Color.BLACK);
      label.setText(string);
      label.setSize(500, 15);
      label.setLocation(15, 40 + down);
      label.setVisible(true);
      panel.add(label);
    }
  }

  /**
   * Create a new general JButtons
   * @param title the title of the JButton
   * @param yPos the vertical position of the jlabel
   * @param panel JPanel to attach the jlabel to
   * @return returns the JButton created
   */
  public JButton createJButtons (String title, int yPos, JPanel panel){
    JButton button = new JButton(title);
    button.setSize(150, 50);
    button.setForeground(Color.BLACK);
    button.setLocation(10, yPos);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
    button.setFont(new Font("Arial", Font.BOLD, 15));
    button.setVisible(true);
    panel.add(button);

    return button;
  }

  /**
   * Initialize and create the modes menu UI
   */
  private void createModesMenu (){

    // Creating the modes menu frame and properties

    modes_menu_frame  = new JFrame("Amaze -> Select the game modes!");
    modes_menu_frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
    modes_menu_frame.setSize(400, 100);
    modes_menu_frame.setBackground(Color.WHITE);
    modes_menu_frame.setLocationRelativeTo(null);
    modes_menu_frame.setResizable(false);

    // Create modes menu Jpanel

    modes_menu_jpanel = new JPanel();
    modes_menu_jpanel.setLayout(null);
    modes_menu_jpanel.setBackground(Color.WHITE);
    modes_menu_jpanel.setPreferredSize(new Dimension(400, 400));
    modes_menu_jpanel.setVisible(false);

    modes_menu_easy_mode_button = createJButtons("Easy Mode", 30, modes_menu_jpanel);
    modes_menu_medium_mode_button = createJButtons("Medium Mode", 60, modes_menu_jpanel);
    modes_menu_hard_mode_button = createJButtons("Hard Mode", 90, modes_menu_jpanel);

    // Actions Listener for Modes Menu
    modes_menu_easy_mode_button.addActionListener(this);
    modes_menu_medium_mode_button.addActionListener(this);
    modes_menu_hard_mode_button.addActionListener(this);

    // Adding Labels
    createModesJLabel(":Dimensions are small", 30);
    createModesJLabel(":Dimensions are medium", 60);
    createModesJLabel(":Dimensions are large", 90);

    modes_menu_jpanel.setVisible(true);
    modes_menu_frame.add(modes_menu_jpanel);
    modes_menu_frame.pack();

    modes_menu_jpanel.setVisible(true);
    modes_menu_frame.setVisible(true);
  }

  /**
   * Initialize and create the instructions UI
   */
  private void createInstructionsMenu (){
    final String [] INSTRUCTIONS = {
      "Welcome to AMAZE!",
      "-> You will be spawned in at a map.",
      "-> Your goal is to reach the end of the map. Find the endpoint",
      "-> Failure to do so will result in your loss",
      "-> Use W A S D to move your player. Reach the end point. ",
      "-> Good luck!"
    };

    // Creating a new Instructions modes and properties

    JFrame instructions_frame = new JFrame("Instructions Window");
    instructions_frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
    instructions_frame.setSize(400, 100);
    instructions_frame.setBackground(Color.WHITE);
    instructions_frame.setLocationRelativeTo(null);
    instructions_frame.setVisible(true);
    instructions_frame.setResizable(false);

    // Creating a new Instructions modes and properties

    JPanel instructions_panel = new JPanel(null);
    instructions_panel.setBackground(Color.WHITE);
    instructions_panel.setPreferredSize(new Dimension(500, 200));
    instructions_panel.setLayout(null);

    for (int increment_num = 0; increment_num < INSTRUCTIONS.length; increment_num++){
      createJLabel(INSTRUCTIONS[increment_num], increment_num * 15, instructions_panel, increment_num);
    }

    // Load Instructions label / button
    instructions_frame.add(instructions_panel);
    instructions_frame.pack();
  }

  /**
   * Creating an action event in order to listen for button clicks
   * @param e Action event which listens to the moust click
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == main_menu_play_button){
      // Create a new modes frame to show all the play modes available

      createModesMenu();
    }
    else if (e.getSource() == main_menu_instructions_button){
      // Create a new instructions window to show the user the instructions to play the game

      createInstructionsMenu();
    }
    else if (e.getSource() == main_menu_exit_button){
      // Exit the game

      System.exit(0);
    }
    else if (e.getSource() == modes_menu_easy_mode_button){
      // Start a game for easy mode

      modes_menu_frame.setState(Frame.ICONIFIED);

      Game game = new Game("Game", 800, 800);
      MazeGen.run(20);
      game.start();
    }
    else if (e.getSource() == modes_menu_medium_mode_button){
      // Start a game for medium mode

      modes_menu_frame.setState(Frame.ICONIFIED);

      Game game = new Game("Game", 800, 800);
      MazeGen.run(50);
      game.start();
    }
    else if (e.getSource() == modes_menu_hard_mode_button){
      // Start a game for hard mode

      modes_menu_frame.setState(Frame.ICONIFIED);

      Game game = new Game("Game", 800, 800);
      MazeGen.run(100);
      game.start();
    }
    else {
      return;
    }
  }
}