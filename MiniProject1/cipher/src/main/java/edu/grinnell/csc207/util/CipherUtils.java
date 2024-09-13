package edu.grinnell.csc207.util;

/**
 * CipherUtils Class. by: Sal Karki.
 */
public class CipherUtils {

/**
 * LENGTH_ALPHA - length of letters in alphabet.
 */
  private static final int LENGTH_ALPHA = 26;

/**
 * letter2int.
 * converts a letter to an integer.
 * @param letter
 * @return int
 */
  private static int letter2int(char letter) {
    return (int) letter - 'a';
  } // letter2int
/**
 * int2letter.
 * converts an integer to a letter.
 * @param i
 * @return char
 */
  private static char int2letter(int i) {
    return (char) (i + 'a');
  } // int2letter

/**
 * caesarEncrypt.
 * encrypts a string 'str' with a caesar cypher key 'letter'.
 * @param str
 * @param letter
 * @return String
 */
  public static String caesarEncrypt(String str, char letter) {
    int length = str.length();

    char[] encrypt = new char[length];
    int encryptChar;

    for (int i = 0; i < length; i++) {
      encryptChar = (letter2int(str.charAt(i)) + letter2int(letter)) % LENGTH_ALPHA;
      encrypt[i] = int2letter(encryptChar);
    } // for

    return new String(encrypt);
  } // caesarEncrypt

/**
 * caesarDecrypt.
 * decrypts a string 'str' with a caesar cypher key 'letter'.
 * @param str
 * @param letter
 * @return String
 */
  public static String caesarDecrypt(String str, char letter) {
    int length = str.length();

    char[] decrypt = new char[length];
    int decryptChar;

    for (int i = 0; i < length; i++) {
      decryptChar = (letter2int(str.charAt(i)) - letter2int(letter)) % LENGTH_ALPHA;
      if (decryptChar < 0) {
        decryptChar += LENGTH_ALPHA;
      } // if
      decrypt[i] = int2letter(decryptChar);
    } // if

    return new String(decrypt);
  } // caesarDecrypt

/**
 * extendKey.
 * extends a key to repeat the length of string 'str'.
 * @param str
 * @param key
 * @return String
 */
  public static String extendKey(String str, String key) {
    String extendKey = "";
    for (int i = 0; i < str.length(); i++) {
      extendKey += key.charAt(i % key.length());
    } // if
    return extendKey;
  } // extendKey

/**
 * vigenereEncrypt.
 * encrypts a string 'str' with a vigenere cypher key 'key'.
 * @param str
 * @param key
 * @return String
 */
  public static String vigenereEncrypt(String str, String key) {
    int length = str.length();

    String newKey = extendKey(str, key);

    char[] encrypt = new char[length];
    int encryptChar;

    for (int i = 0; i < length; i++) {
      encryptChar = (letter2int(str.charAt(i)) + letter2int(newKey.charAt(i))) % LENGTH_ALPHA;
      encrypt[i] = int2letter(encryptChar);
    } // if

    return new String(encrypt);
  } // vigenereEncrypt

/**
 * vigenereDecrypt.
 * decrypts a string 'str' with a caesar cypher key 'letter'.
 * @param str
 * @param key
 * @return String
 */
  public static String vigenereDecrypt(String str, String key) {

    int length = str.length();
    String newKey = extendKey(str, key);

    char[] decrypt = new char[length];
    int decryptChar;

    for (int i = 0; i < length; i++) {
      decryptChar = (letter2int(str.charAt(i)) - letter2int(newKey.charAt(i))) % LENGTH_ALPHA;
      if (decryptChar < 0) {
        decryptChar += LENGTH_ALPHA;
      } // if
      decrypt[i] = int2letter(decryptChar);
    } // for

    return new String(decrypt);
  } // vigenereDecrypt
} // CipherUtils
