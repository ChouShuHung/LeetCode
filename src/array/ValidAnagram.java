package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

  public static void main(String[] args) {
    String s = "anagram", t = "nagaram";
    System.out.println(isAnagram(s, t));
    System.out.println(isAnagramByHashTable(s, t));
    System.out.println(isAnagramByArray(s, t));
  }

  public static boolean isAnagram(String s, String t) {
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    Arrays.sort(sChars);
    Arrays.sort(tChars);

    return sChars == tChars;
    // return Arrays.equals(sChars, tChars);
  }

  public static boolean isAnagramByHashTable(String s, String t) {
    Map<Character, Integer> count = new HashMap<>();

    // Count the frequency of characters in string s
    for (char x : s.toCharArray()) {
      count.put(x, count.getOrDefault(x, 0) + 1);
    }

    // Decrement the frequency of characters in string t
    for (char x : t.toCharArray()) {
      count.put(x, count.getOrDefault(x, 0) - 1);
    }

    // Check if any character has non-zero frequency
    for (int val : count.values()) {
      if (val != 0) {
        return false;
      }
    }

    return true;
  }

  public static boolean isAnagramByArray(String s, String t) {
    int[] count = new int[26];

    // Count the frequency of characters in string s
    for (char x : s.toCharArray()) {
      count[x - 'a']++;
    }

    // Decrement the frequency of characters in string t
    for (char x : t.toCharArray()) {
      count[x - 'a']--;
    }

    // Check if any character has non-zero frequency
    for (int val : count) {
      if (val != 0) {
        return false;
      }
    }

    return true;
  }
}
