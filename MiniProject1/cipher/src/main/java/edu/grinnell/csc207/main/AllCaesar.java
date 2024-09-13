package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * All Caesar Class. by: Sal Karki.
 */
public class AllCaesar {
  /**
   * Main Class.
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters.");
    } else {
      String str = args[1];
      if (str.isEmpty()) {
        if (args[0].equals("encode") || args[0].equals("decode")) {
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: \n", ch);
          } // for
        } else {
          System.err.println("Error: Invalid Option: \"" + args[0]
              + "\". Valid options are \"encode\" or \"decode\".");
        } // if
      } else if (!str.matches("[a-z]+")) {
        System.err.println("Error: String contains characters other than lowercase letters.");
      } else {
        if (args[0].equals("encode")) {
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
          } // if
        } else if (args[0].equals("decode")) {
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
          } // for
        } else {
          System.err.println("Error: Invalid Option: \"" + args[0]
              + "\". Valid options are \"encode\" or \"decode\".");
        } // if
      } // if
      pen.close();
    } // if
  } // main
} // All Cypher
