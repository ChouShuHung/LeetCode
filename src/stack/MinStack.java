package stack;

import java.util.Stack;

public class MinStack {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    // return -3
    minStack.pop();
    System.out.println(minStack.top());
    // return 0
    System.out.println(minStack.getMin());
    // return -2

    // minStack.push(-1);
    // System.out.println(minStack.top());
  }

  private Stack<Integer> stack;
  private Stack<Integer> minStack;
  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    minStack.push(minStack.isEmpty() ? val : Math.min(minStack.peek(), val));
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
