package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

  public static void main(String[] args) {
    int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
    System.out.println(findKthLargest(nums, 2));
  }

  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(
      Collections.reverseOrder()
    );
    for (int num : nums) {
      heap.add(num);
      if (heap.size() > k) heap.poll();
    }
    for (int i = 1; i <= k; i++) {
      int kthLargest = heap.poll();
      if (i == k) return kthLargest;
    }
    return 0;
  }
}
