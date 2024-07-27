package heap;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  public static void main(String[] args) {
    int[][] points = new int[][] { { 1, 3 }, { -2, 2 } };
    int[][] result = kClosest(points, 1);
    for (int[] point : result) {
      for (int p : point) {
        System.out.println(p);
      }
    }
  }

  public static int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) ->
      Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1])
    );
    for (int[] point : points) {
      heap.add(point);
      if (heap.size() > k) heap.remove();
    }
    int[][] closest = new int[k][2];
    for (int i = 0; i < k; i++) {
      int[] tmp = heap.poll();
      closest[i][0] = tmp[0];
      closest[i][1] = tmp[1];
    }
    return closest;
  }
}
