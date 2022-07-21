package edu.pdx.cs410J.TeamAwesome;

import java.util.Objects;
import java.util.Stack;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Kata {
  /*
  An RPN calculator computes expressions written in Reverse Polish Notation.

  An RPN expression or postfix expression is one of the following:
  - a number X, in wich case the value of the expression is that of X,
  - a sequence of form E1 E2 OP where E1 and E2 are RPN expressions and OP is an arithmetic operation.

  Samples:
  20 5 /        => 20/5 = 4
  4 2 + 3 -     => (4+2)-3 = 3
  3 5 8 * 7 + * => ((5*8)+7)*3 = 141

  Add the SQRT operation:
  9 SQRT => √9 = 3

  Add the MAX operation:
  5 3 4 2 9 1 MAX   => MAX(5, 3, 4, 2, 9, 1) = 9
  4 5 MAX 1 2 MAX * => MAX(4,5) * MAX(1,2) = 10
  3 4 5 MAX 1 2 MAX * + => MAX(4,5) * MAX(1,2) + 3 = 13?
  */

  static int compute(int a, int b, String operation) {
    switch(operation) {
      case "+": // add
        return a + b;
      case "-": // subtract
        return a - b;
      case "*": // multiply
        return a * b;
      case "/": // divide
        return a / b;
    }

    return 0;
  }

  static int max(Stack<Integer> nums) {
    int result = nums.pop();

    while(!nums.empty()) {
      int n = nums.pop();
      if(n > result) {
        result = n;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    if(args.length < 1) {
      System.err.println("Missing command line arguments");
    } else if (args.length == 1) {
      System.out.println(args[0]);
    } else {
      Stack<Integer> nums = new Stack<>();
      for(String arg:args) {
        try {
          nums.push(Integer.parseInt(arg));
        } catch(NumberFormatException e) {
          // here would want pop twice the stack out and use arg

          if(Objects.equals(arg, "SQRT")) {
            nums.push((int)Math.sqrt(nums.pop()));
          } else if(Objects.equals(arg, "MAX")) {
            nums.push(max(nums));
          } else {
            int b = nums.pop();
            int a = nums.pop();

            nums.push(compute(a, b, arg));
          }
        }
      }

      System.out.println(nums.pop());
    }

    System.exit(1);
  }
}
