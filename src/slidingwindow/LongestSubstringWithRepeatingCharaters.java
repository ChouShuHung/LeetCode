package slidingwindow;

import java.util.Arrays;

public class LongestSubstringWithRepeatingCharaters {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcdddd"));
  }

  /*
 * This solution uses an integer array charIndex to store the indices of characters.
 * We eliminate the need for an unordered map by utilizing the array.
 * The maxLength, left, and right pointers are still present.
 * We iterate through the string using the right pointer.
 * We check if the current character has occurred within the current substring by comparing its index in charIndex with left.
 * If the character has occurred, we move the left pointer to the next position after the last occurrence of the character.
 * We update the index of the current character in charIndex.
 * At each step, we update the maxLength by calculating the length of the current substring.
 * We continue the iteration until reaching the end of the string.
 * Finally, we return the maxLength as the length of the longest substring without repeating characters.
 */
  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;
    int[] charIndex = new int[128];
    Arrays.fill(charIndex, -1);
    int left = 0;

    for (int right = 0; right < n; right++) {
      if (charIndex[s.charAt(right)] >= left) {
        left = charIndex[s.charAt(right)] + 1;
      }
      charIndex[s.charAt(right)] = right;
      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }
}
