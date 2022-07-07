package edu.pdx.cs410J.TaceAndJihui;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Kata {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println("Missing command line arguments");
      return;
    }
    String result = compute(args[0]);
    System.out.println(result);
  }

  public static String compute(String s) {
    int value = Integer.parseInt(s);
    String returnStr = "";
    if (value % 3 == 0) {
      returnStr += "Foo";
    }
    if (value % 5 == 0) {
      returnStr += "Bar";
    }
    if (value % 7 == 0) {
      returnStr += "Qix";
    }
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '3') {
        returnStr += "Foo";
      } else if (s.charAt(i) == '5') {
        returnStr += "Bar";
      } else if (s.charAt(i) == '7') {
        returnStr += "Qix";
      } else if (s.charAt(i) == '0') {
        returnStr += "*";
      }
    }
    if (returnStr.equals("") || returnStr.matches("[\\*]+")) {
      returnStr = s;
      returnStr = returnStr.replace('0', '*');
    }
    return returnStr;
  }
}
