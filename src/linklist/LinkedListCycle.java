package linklist;

public class LinkedListCycle {

  public static void main(String[] args) {
    // Create nodes for the linked list
    ListNode head = new ListNode(3);
    ListNode node2 = new ListNode(2);
    // ListNode node3 = new ListNode(0);
    // ListNode node4 = new ListNode(-4);

    // Connect the nodes to form a linked list
    head.next = node2;
    // node2.next = node3;
    // node3.next = node4;

    // Create a cycle by connecting the last node to the second node
    // node4.next = node2;
    System.out.println(Boolean.valueOf(hasCycle(head)));
  }

  public static boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next != null ? fast.next.next : null;
    }
    return false;
  }
}
