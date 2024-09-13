package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * Cipher Class. by: Sal Karki.
 */
public class Cipher {
/**
 * 4 parameters expected.
 */
  private static final int EXPECTED_NUM_PARAMS = 4;

  /**
   * Main Class.
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != EXPECTED_NUM_PARAMS) {
      System.err.println("Error: Expected 4 parameters, received " + args.length);
      return;
    } // if
    String action = "";
    String cipher = "";
    String input = "";
    String key = "";

    for (String arg : args) {
      if (arg.equals("-encode") || arg.equals("-decode")) {
        action = arg;
      } else if (arg.equals("-caesar") || arg.equals("-vigenere")) {
        cipher = arg;
      } else if (arg.matches("[a-z]+")) {
        if (input.equals("")) {
          input = arg;
        } else {
          key = arg;
        } // if
      } else {
        System.err.println("Error: Invalid argument: " + arg);
        return;
      } // if
    } // for


    if (action.equals("")) {
      System.err
          .println("Error: No valid action specified. Legal values are '-encode' and '-decode'");
      return;
    } // if
    if (cipher.equals("")) {
      System.err
          .println("Error: No valid cipher specified. Legal values are '-caesar' and '-vigenere'");
      return;
    } // if
    if (input.equals("") || !input.matches("[a-z]+")) {
      System.err.println("Error: Strings must be only lowercase letters");
      return;
    } // if
    if (key.equals("") || !key.matches("[a-z]+")) {
      System.err.println("Error: Empty keys are not permitted");
      return;
    } // if


    if (cipher.equals("-caesar") && key.length() != 1) {
      System.err.println("Error: Caesar ciphers require a one-character key");
      return;
    } // if


    String result = null;
    if (cipher.equals("-caesar")) {
      char caesarKey = key.charAt(0);
      if (action.equals("-encode")) {
        result = CipherUtils.caesarEncrypt(input, caesarKey);
      } else if (action.equals("-decode")) {
        result = CipherUtils.caesarDecrypt(input, caesarKey);
      } // if
    } else if (cipher.equals("-vigenere")) {
      if (action.equals("-encode")) {
        result = CipherUtils.vigenereEncrypt(input, key);
      } else if (action.equals("-decode")) {
        result = CipherUtils.vigenereDecrypt(input, key);
      } // if
    } // if

    if (result != null) {
      pen.println(result);
    } // if

    pen.close();
  } // main
} // Cipher
