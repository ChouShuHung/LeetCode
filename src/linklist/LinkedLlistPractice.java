package linklist;

import java.util.Arrays;

public class LinkedLlistPractice {

  public static void main(String[] args) {
    ListNode node1 = ListNode.createListNode(Arrays.asList(1, 4, 5));
    ListNode node2 = ListNode.createListNode(Arrays.asList(1, 3, 4));
    System.out.println(ListNode.toNextString(mergeLinkedList(node1, node2)));
  }

  private static ListNode mergeLinkedList(ListNode node1, ListNode node2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (node1 != null && node2 != null) {
      if (node1.val < node2.val) {
        curr.next = node1;
        node1 = node1.next;
      } else {
        curr.next = node2;
        node2 = node2.next;
      }
      curr = curr.next;
    }
    curr.next = node1 != null ? node1 : node2;
    return dummy.next;
  }
}
