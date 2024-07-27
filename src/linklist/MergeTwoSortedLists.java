package linklist;

import java.util.Arrays;

public class MergeTwoSortedLists {

  public static void main(String[] args) {
    ListNode list1 = ListNode.createListNode(Arrays.asList(1, 2, 4));
    ListNode list2 = ListNode.createListNode(Arrays.asList(1, 3, 4));
    System.out.println(ListNode.toNextString(list1));
    System.out.println(ListNode.toNextString(list2));
    System.out.println(ListNode.toNextString(mergeTwoLists(list1, list2)));
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode headNode = new ListNode(0);
    ListNode current = headNode;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
      current = current.next;
    }

    current.next = list1 != null ? list1 : list2;

    return headNode.next;
  }
}
