package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public static void main(String[] args) {
    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
    groupAnagrams(strs).stream().forEach(System.out::println);
    System.out.println();
    groupAnagramsByASCII(strs).stream().forEach(System.out::println);
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String word : strs) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedString = new String(chars);

      if (!map.containsKey(sortedString)) {
        map.put(sortedString, new ArrayList<>());
      }
      map.get(sortedString).add(word);
    }
    return new ArrayList<>(map.values());
  }

  public static List<List<String>> groupAnagramsByASCII(String[] strs) {
    Map<ArrayKey, List<String>> map = new HashMap<>();
    for (String word : strs) {
      int[] count = new int[26];
      for (char character : word.toCharArray()) {
        count[character - 'a']++;
      }
      ArrayKey arrayKey = new ArrayKey(count);
      if (!map.containsKey(arrayKey)) {
        map.put(arrayKey, new ArrayList<>());
      }
      map.get(arrayKey).add(word);
    }

    return new ArrayList<>(map.values());
  }

  static class ArrayKey {

    private int[] array;

    public ArrayKey(int[] array) {
      this.array = array;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || o.getClass() != getClass()) return false;
      ArrayKey other = (ArrayKey) o;
      return Arrays.equals(array, other.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
  }
}
