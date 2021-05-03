import UI.MainMenu;

/**
 * @author wxhly
 * @version 2.0
 * Main changes in this newer version includes some updates on the colour of
 * guis as well as some updates in how the maze is generated.
 * Most class are now packaged in order to be more organized.
 * Also looking to fix the maze generator error.
 */

public class main {
  public static void main(String[] args) {
    MainMenu mainMenu = new MainMenu();
    mainMenu.launchMainMenu();
  }
}
