package MISC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utility Class
 **/

public class Utils {
  /**
   * Reads the file and returns it as a string
   * @param path file path
   * @return content of the file or exits program if file could not be opened
   **/
  public static String loadFilesAsString (String path) {
    StringBuilder builder = new StringBuilder();

    try {
      BufferedReader br = new BufferedReader(new FileReader(path));
      String line;

      while ((line = br.readLine()) != null){
        builder.append(line + "\n");
      }
      br.close();
    } catch (IOException e){
      e.printStackTrace();
    }

    return builder.toString();
  }

  /**
   * Attempts to convert a string to number or returns error
   * @param number string number to parse to integer
   * @return integer if it was successfully parsed
   **/
  public static int parseInt (String number) {
    try {
      return Integer.parseInt(number);
    } catch (NumberFormatException e){
      e.printStackTrace();
      return 0;
    }
  }
}
