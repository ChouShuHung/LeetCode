package heap;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

  public static void main(String[] args) {
    KthLargest obj = new KthLargest(3, new int[] { 4, 5, 8, 2 });
    System.out.println(obj.add(3));
    System.out.println(obj.add(5));
    System.out.println(obj.add(10));
    System.out.println(obj.add(9));
  }
}

class KthLargest {

  private int k;
  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (int num : nums) {
      add(num);
    }
  }

  public int add(int val) {
    minHeap.offer(val);
    if (minHeap.size() > k) {
      minHeap.poll();
    }
    return minHeap.peek();
  }
}
