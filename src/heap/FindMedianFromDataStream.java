package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    // medianFinder.addNum(1); // arr = [1]
    // medianFinder.addNum(2); // arr = [1, 2]
    // medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
    // medianFinder.addNum(3); // arr[1, 2, 3]
    // medianFinder.findMedian(); // return 2.0
    medianFinder.addNum(6);
    medianFinder.findMedian();
    medianFinder.addNum(10);
    medianFinder.findMedian();
    medianFinder.addNum(2);
    medianFinder.findMedian();
    medianFinder.addNum(6);
    medianFinder.findMedian();
    medianFinder.addNum(5);
    medianFinder.findMedian();
    medianFinder.addNum(0);
    medianFinder.findMedian();
    medianFinder.addNum(6);
    medianFinder.findMedian();
    medianFinder.addNum(3);
    medianFinder.findMedian();
    medianFinder.addNum(1);
    medianFinder.findMedian();
    medianFinder.addNum(0);
    medianFinder.findMedian();
    medianFinder.addNum(0);
    medianFinder.findMedian();
  }
}

class MedianFinder {

  Queue<Integer> minheap;
  Queue<Integer> maxheap;
  boolean even;

  public MedianFinder() {
    even = true;
    maxheap = new PriorityQueue<Integer>(Collections.reverseOrder()); // Small Heap
    minheap = new PriorityQueue<Integer>(); // Large Heap
  }

  public void addNum(int num) {
    if (even) {
      minheap.add(num);
      maxheap.add(minheap.poll());
    } else {
      maxheap.add(num);
      minheap.add(maxheap.poll());
    }
    even = !even;
  }

  public double findMedian() {
    double median = 0;
    if (even) {
      median = (double) (maxheap.peek() + minheap.peek()) / 2;
    } else {
      median = maxheap.peek();
    }
    System.out.println(median);
    return median;
  }
}
