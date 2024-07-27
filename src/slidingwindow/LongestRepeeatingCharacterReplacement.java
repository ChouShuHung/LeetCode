package slidingwindow;

public class LongestRepeeatingCharacterReplacement {

  public static void main(String[] args) {
    System.out.println(characterReplacementMoreEfficient("AABABBA", 1));
  }

  public static int characterReplacement(String s, int k) {
    int left = 0;
    int maxCount = 0;
    int[] charCount = new int[26];
    int res = 0;

    for (int right = 0; right < s.length(); right++) {
      // Counting the number of each character in the string s
      charCount[s.charAt(right) - 'A']++;

      // Checking the character with max number of occurrence
      maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);
      // Now we check if our current window is valid or not
      if (right - left + 1 - maxCount > k) {
        // this means the no. of replacements is more than
        // allowed (k)
        // Decrementing the count of the character which was
        // at l because it is no longer in the window
        charCount[s.charAt(left) - 'A']--;
        left++;
      }

      // The max our window can be
      res = Math.max(res, right - left + 1);
    }

    return res;
  }

  public static int characterReplacementMoreEfficient(String s, int k) {
    int left = 0;
    int maxCount = 0;
    int[] charCount = new int[26];

    for (int right = 0; right < s.length(); right++) {
        charCount[s.charAt(right) - 'A']++;

        maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

        while (right - left + 1 - maxCount > k) {
            charCount[s.charAt(left) - 'A']--;
            left++;
        }
    }
    return s.length()-left;
  }
}
