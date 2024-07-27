package slidingwindow;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
    System.out.println(minWindow("a", "a"));
  }

  public static String minWindow(String s, String t) {
    if (
      s == null ||
      t == null ||
      s.isEmpty() ||
      t.isEmpty() ||
      t.length() > s.length()
    ) return "";

    int[] map = new int[128];
    int count = t.length();
    int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

    for (char c : t.toCharArray()) {
      map[c]++;
    }

    char[] charS = s.toCharArray();

    while (end < charS.length) {
      if (map[charS[end++]]-- > 0) {
        count--;
      }
      while (count == 0) {
        if (end - start < minLen) {
          startIndex = start;
          minLen = end - start;
        }
        if (map[charS[start++]]++ == 0) {
          count++;
        }
      }
    }

    return minLen == Integer.MAX_VALUE
      ? new String()
      : new String(charS, startIndex, minLen);
  }
}
