package linklist;

import java.util.Arrays;

public class RemoveNthNodeFromEndOfList {

  public static void main(String[] args) {
    ListNode head = ListNode.createListNode(Arrays.asList(1,2,3,4,5));
    System.out.println(ListNode.toNextString(removeNthFromEnd(head, 2)));
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    // move right pointer by the offset n of the list
    ListNode right = head;
    while (n > 0) {
      right = right.next;
      n--;
    }
    ListNode left = dummy;
    // move left/right pointer
    while (right != null) {
      right = right.next;
      left = left.next;
    }
    left.next = left.next.next;
    return dummy.next;
  }
}
