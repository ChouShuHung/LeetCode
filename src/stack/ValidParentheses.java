package stack;

import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(isValidMostEffective("{}"));
  }

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>(); // create an empty stack
    for (char c : s.toCharArray()) { // loop through each character in the string
      if (c == '(')
        stack.push(')'); // if the character is an opening parenthesis // push the corresponding
                         // closing parenthesis onto the stack
      else if (c == '{')
        stack.push('}'); // if the character is an opening brace // push the corresponding closing
                         // brace onto the stack
      else if (c == '[')
        stack.push(']'); // if the character is an opening bracket // push the corresponding closing
                         // bracket onto the stack
      else if (stack.isEmpty() || stack.pop() != c)
        return false; // does not match the closing bracket, the string is not valid, so return
                      // false // if the stack is empty (i.e., there is no matching opening bracket)
                      // or the top of the stack // if the character is a closing bracket
    }
    // if the stack is empty, all opening brackets have been matched with their corresponding
    // closing brackets,
    // so the string is valid, otherwise, there are unmatched opening brackets, so return false
    return stack.isEmpty();
  }

  public static boolean isValidWithouStack(String s) {
    while (true) {
      if (s.contains("()")) {
        s = s.replace("()", "");
      } else if (s.contains("{}")) {
        s = s.replace("{}", "");
      } else if (s.contains("[]")) {
        s = s.replace("[]", "");
      } else {
        // If the string becomes empty, it indicates all brackets are matched.
        return s.isEmpty();
      }
    }
  }

  public static boolean isValidMostEffective(String s) {
    char[] openParenthese = new char[s.length()];
    int index = -1;
    for (char c : s.toCharArray()) {
      if (c == '{' || c == '(' || c == '[') {
        index++;
        openParenthese[index] = c;
      } else {
        if (index > -1
            && (c == '}' && openParenthese[index] == '{' || c == ')' && openParenthese[index] == '('
                || c == ']' && openParenthese[index] == '[')) {
          index--;
        } else {
          return false;
        }
      }
    }

    return index == -1;
  }
}
