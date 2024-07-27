package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

  public static void main(String[] args) {
    int[] nums = { 1, 2 };
    System.out.println(Arrays.toString(topKFrequent(nums, 2)));
  }

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    List<Integer>[] bucket = new List[nums.length + 1];

    for (Integer key : map.keySet()) {
      if (bucket[map.get(key)] == null) {
        bucket[map.get(key)] = new ArrayList<>();
      }
      bucket[map.get(key)].add(key);
    }

    int[] topKElements = new int[k];
    int pos = 0;
    for (int i = bucket.length - 1; i > 0; i--) {
      if (bucket[i] != null) {
        for (int j = 0; j < bucket[i].size() && pos < k; j++) {
          topKElements[pos] = bucket[i].get(j);
          pos++;
        }
      }
    }
    return topKElements;
  }

  public static int[] topKFrequentQueue(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>(
        (a, b) -> map.get(b) - map.get(a));
    queue.addAll(map.keySet());

    int[] topKElements = new int[k];
    for (int i = 0; i < k; i++) {
      topKElements[i] = queue.poll();
    }
    return topKElements;
  }
}
