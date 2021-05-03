//Main Menu Class

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    // Declaration Section
    private Graphics graph;
    private Canvas canvas;
    private JFrame frame, modes;
    private JPanel panel;
    private JLabel title, version, message1, creators;
    private JButton play, instructions, exit;
    private JButton easyMode, mediumMode, hardMode;

    private JPanel newJpanel = new JPanel();

    // Main Menu
    public MainMenu(){
        //Main Menu Properties
        frame = new JFrame("Welcome to Amaze: A Maze Game");
        frame.setSize(600,600);
        frame.setBackground(Color.darkGray);
        frame.setLocationRelativeTo(null);
        frame.setVisible( true );
        frame.setResizable(false);
        frame.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );

        panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setLayout(null);


        String titleMessage = "Welcome to AMAZE!";
        title = new JLabel();
        title.setText(titleMessage);
        title.setSize(500, 150);
        title.setLocation(100, 100);
        title.setVisible(true);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial", Font.BOLD, 45));

        version = new JLabel("Version: 0.1");
        version.setSize(200, 100);
        version.setForeground(Color.white);
        version.setLocation(250, 180);
        version.setFont(new Font("Arial", Font.PLAIN, 20));

        message1 = new JLabel("A Game developed by:");
        message1.setSize(400, 100);
        message1.setForeground(Color.white);
        message1.setLocation(50, 475);
        message1.setFont(new Font("Arial", Font.ITALIC, 15));

        creators = new JLabel("Dennis Rapopport  Prithul Niraula");
        creators.setSize(400, 100);
        creators.setForeground(Color.white);
        creators.setLocation(125, 495);
        creators.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));

        play = new JButton("Start Game");
        play.setSize(200, 50);
        play.setForeground(Color.BLACK);
        play.setLocation(200, 250);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setFont(new Font("Arial", Font.BOLD, 15));
        play.addActionListener(this);

        instructions = new JButton("Game Instructions");
        instructions.setSize(300, 50);
        instructions.setForeground(Color.BLACK);
        instructions.setLocation(150, 280);
        instructions.setContentAreaFilled(false);
        instructions.setBorderPainted(false);
        instructions.setFont(new Font("Arial", Font.BOLD, 15));
        instructions.addActionListener(this);

        exit = new JButton("Exit Game");
        exit.setSize(300, 50);
        exit.setForeground(Color.BLACK);
        exit.setLocation(150, 310);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setFont(new Font("Arial", Font.BOLD, 15));
        exit.addActionListener(this);

        // Loading the Widgets into Menu
        panel.add(title);
        panel.add(version);
        panel.add(message1);
        panel.add(creators);
        panel.add(play);
        panel.add(instructions);
        panel.add(exit);
        frame.add(panel);
        frame.pack();

        // Modes Menu Panel
        newJpanel.setBackground(Color.darkGray);
        newJpanel.setPreferredSize(new Dimension(400, 200));
        newJpanel.setLayout(null);
        newJpanel.setVisible(false);

        // Modes Menu modes
        easyMode = createJButtons("Easy Mode", 30, newJpanel);
        mediumMode = createJButtons("Medium Mode", 60, newJpanel);
        hardMode = createJButtons("Hard Mode", 90, newJpanel);

        // Actions Listener for Modes Menu
        easyMode.addActionListener(this);
        mediumMode.addActionListener(this);
        hardMode.addActionListener(this);
    }

    // Create a JLabel
    public void createJLabel (String string, int down, JPanel panel, int increment) {
        JLabel label = new JLabel();
        if (increment == 0) {
            label.setForeground(Color.WHITE);
            label.setText(string);
            label.setSize(500, 15);
            label.setLocation(150, down);
            label.setFont(new Font("Arial", Font.ITALIC, 22));
            label.setVisible(true);

            panel.add(label);
        }
        else {
            label.setForeground(Color.WHITE);
            label.setText(string);
            label.setSize(500, 15);
            label.setLocation(0, 20 + down);
            label.setVisible(true);
            panel.add(label);
        }
    }

    // JButtons Procedure Section
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

    //@Override
    public void createJLabel (String title, int yPos, JPanel panel) {
        JLabel label = new JLabel(title);
        label.setSize(250, 50);
        label.setLocation(200, yPos);
        label.setVisible(true);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label);
    }

    // Action Event Processing Section

    @Override
    public void actionPerformed(ActionEvent e) {
        // Play Button is pressed
        if (e.getSource() == play){
            // New Jframe
            modes = new JFrame ("Select GameMode");
            modes.setDefaultCloseOperation(HIDE_ON_CLOSE);
            modes.setSize(400, 100);
            modes.setBackground(Color.WHITE);
            modes.setLocationRelativeTo(null);
            modes.setVisible( true );
            modes.setResizable(false);

            // Adding Labels
            createJLabel(":Dimensions are small", 30, newJpanel);
            createJLabel(":Dimensions are medium", 60, newJpanel);
            createJLabel(":Dimensions are large", 90, newJpanel);

            newJpanel.setVisible(true);
            modes.add(newJpanel);
            modes.pack();

            //System.out.println("Init Game");
        }
        else if (e.getSource() == instructions){
            // Instructions Properties
            //System.out.println("Loading Instructions");
            String[] instructions = {
                    "Welcome to AMAZE!",
                    "You will be spawned in at a map.",
                    "Your goal is to reach the end of the map. Find the endpoint",
                    "Failure to do so will result in your loss",
                    "Use W A S D to move your player. Reach the end point. ",
                    "Good luck!"
            };

            JFrame newFrame = new JFrame("Instructions Window");
            newFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
            newFrame.setSize(400, 100);
            newFrame.setBackground(Color.WHITE);
            newFrame.setLocationRelativeTo(null);
            newFrame.setVisible( true );
            newFrame.setResizable(false);

            JPanel newJpanel = new JPanel();

            newJpanel = new JPanel();
            newJpanel.setBackground(Color.darkGray);
            newJpanel.setPreferredSize(new Dimension(500, 200));
            newJpanel.setLayout(null);

            for (int incrementNumber = 0; incrementNumber < instructions.length; incrementNumber++){
                createJLabel(instructions[incrementNumber], incrementNumber * 15, newJpanel, incrementNumber);
            }

            // Load Instructions label / button
            newFrame.add(newJpanel);
            newFrame.pack();
        }
        else if (e.getSource() == exit){
            //System.out.println("Exit Game");
            System.exit(0);
        }
        /* Modes Action Even */
        else if (e.getSource() == easyMode){
            //System.out.println("Easy Mode");
            modes.setState(Frame.ICONIFIED);

            Game game = new Game("Game", 800, 800);
            MazeGen.run(20);
            game.start();
        }
        else if (e.getSource() == mediumMode){
            //System.out.println("Medium Mode");
            modes.setState(Frame.ICONIFIED);

            Game game = new Game("Game", 800, 800);
            MazeGen.run(50);
            game.start();
        }
        else if (e.getSource() == hardMode){
            //System.out.println("Hard Mode");
            modes.setState(Frame.ICONIFIED);

            Game game = new Game("Game", 800, 800);
            MazeGen.run(100);
            game.start();
        }
        else {
            return;
        }
    }
}
