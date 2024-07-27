package linklist;

import java.util.Arrays;

public class MergeKSortedLinkedList {

  public static void main(String[] args) {
    ListNode node1 = ListNode.createListNode(Arrays.asList(1, 4, 5));
    ListNode node2 = ListNode.createListNode(Arrays.asList(1, 3, 4));
    ListNode node3 = ListNode.createListNode(Arrays.asList(2, 6));
    ListNode node4 = ListNode.createListNode(Arrays.asList(12));
    ListNode node5 = ListNode.createListNode(Arrays.asList(13));
    ListNode[] listNodes = { node1, node2, node3, node4 ,node5 };
    System.out.println(ListNode.toNextString(mergeKLists(listNodes)));
  }

  //  Solution using Iterative Merge Sort
  //  Time Complexity:         O(n*log(k))
  //  Extra Space Complexity:  O(1)
  public static ListNode mergeKLists(ListNode[] lists) {
    int size = lists.length;
    int interval = 1;
    // The outer while loop controls the size of each group.
    // It starts with an interval of 1 (i.e., each list is treated as a single group)
    // and doubles it in each iteration until the interval is equal to k.
    // interval is the gropup, first time is 1, second is 2 listNodes, third time is 4
    while (interval < size) {
      for (int i = 0; i < size - interval; i += 2 * interval) {
        lists[i] = merge(lists[i], lists[i + interval]);
      }

      interval *= 2;
    }

    // int i = 1;
    // while (i < lists.length) {
    //   lists[0] = merge(lists[0], lists[i++]);
    // }
    return size > 0 ? lists[0] : null;
  }

  private static ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    curr.next = l1 != null ? l1 : l2;

    return dummy.next;
  }
}
