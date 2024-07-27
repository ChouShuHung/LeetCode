package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

  public static void main(String[] args) {
    System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
  }

  public static int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(
      Collections.reverseOrder()
    );
    for (int stone : stones) {
      heap.offer(stone);
    }
    while (heap.size() > 1) {
      int x = heap.poll();
      int y = heap.poll();
      if (x != y) {
        heap.offer(x - y);
      }
    }
    return heap.size() == 1 ? heap.peek() : 0;
  }
}
