package linklist;

import java.util.Arrays;

public class ReorderList {

  public static void main(String[] args) {
    ListNode head = ListNode.createListNode(Arrays.asList(1, 2, 3, 4, 5));
    reorderList(head);
    System.out.println(ListNode.toNextString(head));
  }

  public static void reorderList(ListNode head) {
    //Find middle of list using a slow and fast pointer approach
    //also create the first half of list
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    //Reverse the second half of the list using a tmp variable
    ListNode second = slow.next;
    ListNode prev = slow.next = null;
    while (second != null) {
      ListNode tmp = second.next;
      second.next = prev;
      prev = second;
      second = tmp;
    }

    //Re-assign the pointers to match the pattern
    ListNode first = head;
    second = prev;
    while (second != null) {
      ListNode tmp1 = first.next; // 2,3,4
      ListNode tmp2 = second.next; // 4
      first.next = second; //5
      second.next = tmp1; // 2, 3
      first = tmp1;
      second = tmp2;
    }
  }
}
