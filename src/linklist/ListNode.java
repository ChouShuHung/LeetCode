package linklist;

import java.util.List;

public class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static String toNextString(ListNode node) {
    if (node == null) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(node.val);

    ListNode current = node.next;
    while (current != null) {
      sb.append(", ");
      sb.append(current.val);
      current = current.next;
    }

    return sb.toString();
  }

  public static ListNode createListNode(List<Integer> values) {
    if (values == null) {
      throw new IllegalArgumentException("values cannot be null");
    }
    ListNode head = null;
    ListNode current = null;
    int next = 0;
    while (next < values.size()) {
      if (head == null) {
        head = new ListNode(values.get(next++));
        current = head;
      } else {
        current.next = new ListNode(values.get(next++));
        current = current.next;
      }
    }
    return head;
  }
}
