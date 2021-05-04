package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
  private final int AMAZE_VERSION = 3;
  private JFrame menuFrame;
  private JFrame modeFrame;

  private JButton playButton;
  private JButton instructionsButton;
  private JButton exitButton;

  public MainMenu () {
    drawMenu();
  }

  private void drawMenu () {
    final int MENU_FRAME_SIZE = 800;
    final String DEV_RAPOPPORT = "Dennis Rapopport";
    final String DEV_NIRAULA = "Prithul Niraua";

    final int titleFontSize = 50;
    final int buttonFontSize = 30;

    menuFrame = new JFrame ("Amaze - Version 3");
    menuFrame.setSize(MENU_FRAME_SIZE, MENU_FRAME_SIZE);
    menuFrame.setBackground(Color.WHITE);
    menuFrame.setLocationRelativeTo(null);
    menuFrame.setResizable(false);
    menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    GridBagConstraints gbc = new GridBagConstraints();

    JPanel menuPanel = new JPanel();
    menuPanel.setBackground(Color.WHITE);
    menuPanel.setPreferredSize(new Dimension(MENU_FRAME_SIZE, MENU_FRAME_SIZE));
    menuPanel.setLayout(new GridBagLayout ());

    JLabel menuTitle = new JLabel("Welcome to Amaze: Version " + AMAZE_VERSION);
    menuTitle.setSize(500, 150);
    menuTitle.setLocation(100, 100); // need to change this to layout way
    menuTitle.setForeground(Color.BLACK);
    menuTitle.setFont(new Font("Arial", Font.BOLD, titleFontSize));
    menuTitle.setVisible(true);

    JLabel devBy = new JLabel("A game developed by: " );
    devBy.setSize(400, 100);
    devBy.setForeground(Color.BLACK);
    devBy.setFont(new Font("Arial", Font.BOLD, 15));
    devBy.setLocation(200, 200); // need to change this to layout way
    devBy.setVisible(true);

    JLabel devs = new JLabel(DEV_RAPOPPORT + " and " + DEV_NIRAULA);
    devs.setSize(400, 100);
    devs.setForeground(Color.BLACK);
    devs.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
    devs.setLocation(300, 300); // NEED TO CHANGE THIS AGAIN;
    devs.setVisible(true);

    playButton = new JButton("Start Game");
    playButton.setSize(200, 50);
    playButton.setForeground(Color.BLACK);
    playButton.setContentAreaFilled(false);
    playButton.setBorderPainted(false);
    playButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
    playButton.addActionListener(this);
    playButton.setLocation(400, 400); // CHANGE

    instructionsButton = new JButton("Game Instructions");
    instructionsButton.setSize(200, 50);
    instructionsButton.setForeground(Color.BLACK);
    instructionsButton.setContentAreaFilled(false);
    instructionsButton.setBorderPainted(false);
    instructionsButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
    instructionsButton.addActionListener(this);
    instructionsButton.setLocation(400, 500); // CHANGE

    exitButton = new JButton("Exit Game");
    exitButton.setSize(200, 50);
    exitButton.setForeground(Color.BLACK);
    exitButton.setContentAreaFilled(false);
    exitButton.setBorderPainted(false);
    exitButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
    exitButton.addActionListener(this);
    exitButton.setLocation(400, 600); // CHANGE

    gbc.gridx = 0; gbc.gridy = 0;
    gbc.gridwidth = 4; gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NORTH;
    gbc.insets = new Insets(10, 5, 105, 5);
    menuPanel.add(menuTitle, gbc);

    gbc.gridx = 2; gbc.gridy = 2;
    gbc.gridwidth = 4; gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(10, 5, 10, 5);
    menuPanel.add(playButton, gbc);
    
    gbc.gridx = 2; gbc.gridy = 3;
    menuPanel.add(instructionsButton, gbc);
    
    gbc.gridx = 2; gbc.gridy = 4;
    menuPanel.add(exitButton, gbc);

    gbc.gridx = 2; gbc.gridy = 5;
    menuPanel.add(devs, gbc);

    gbc.gridx = 2; gbc.gridy = 6;
    gbc.gridwidth = 2; gbc.gridheight = 1;
    menuPanel.add(devBy, gbc);
    


    menuFrame.add(menuPanel);
    menuFrame.pack();
    menuFrame.setVisible(true);
  }

  private void drawInstructionsMenu () {
  }


  /**
   * @param e ActionEvent used to determine which button was pressed
   * @time unspecified
   */
  @Override
  public void actionPerformed (ActionEvent e) {
    if (e.getSource() == playButton) {
      System.out.println("Beginning game");
    }
    else if (e.getSource() == instructionsButton) {
      System.out.println("Instructions game");
      drawInstructionsMenu();
    }
    else if (e.getSource() == exitButton) {
      System.out.println("Leaving game: ");
      System.exit(0);
    }
  }
}
