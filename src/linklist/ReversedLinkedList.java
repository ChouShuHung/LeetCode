package linklist;

import java.util.Arrays;

public class ReversedLinkedList {

  public static void main(String[] args) {
    ListNode head = ListNode.createListNode(Arrays.asList(1, 2, 3, 4, 5));
    ListNode reversedNote = reverseList(head);
    System.out.println(ListNode.toNextString(reversedNote));
  }

  private static ListNode reverseListRecursive(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode reversedNode = reverseList(head.next); // 5,4,3,2,1
    head.next.next = head;
    head.next = null;
    return reversedNode;
  }

  private static ListNode reverseList(ListNode head) {
    ListNode newNode = null;
    while (head.next != null) {
      ListNode nextListNode = head.next;
      head.next = newNode;
      newNode = head;
      head = nextListNode;
    }
    return newNode;
  }
}
