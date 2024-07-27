package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

  public static void main(String[] args) {
    String[] tokens = { "4", "13", "5", "/", "+" };
    System.out.println(evalRPN(tokens));
  }

  public static int evalRPN(String[] tokens) {
    Stack<Integer> digits = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      int result =
        switch (tokens[i]) {
          case "+" -> digits.pop() + digits.pop();
          case "-" -> {
            int post = digits.pop();
            yield digits.pop() - post;
          }
          case "*" -> digits.pop() * digits.pop();
          case "/" -> {
            int post = digits.pop();
            yield digits.pop() / post;
          }
          default -> Integer.parseInt(tokens[i]);
        };
      digits.push(result);
    }
    return digits.peek();
  }

  public static int evalRPN1(String[] tokens) {
    Stack<Integer> digits = new Stack<>();
    Stack<String> operations = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      if (Character.isDigit(tokens[i].toCharArray()[0])) {
        digits.push(Integer.parseInt(tokens[i]));
      } else {
        operations.push(tokens[i]);
      }
    }
    return calculate1(digits, operations);
  }

  private static int calculate1(
    Stack<Integer> digits,
    Stack<String> operations
  ) {
    if (digits.size() == 1) return digits.pop();
    String operation = operations.pop();
    return switch (operation) {
      case "+" -> digits.pop() + calculate1(digits, operations);
      case "-" -> digits.pop() - calculate1(digits, operations);
      case "*" -> digits.pop() - calculate1(digits, operations);
      case "/" -> digits.pop() / calculate1(digits, operations);
      default -> throw new RuntimeException();
    };
  }
}
