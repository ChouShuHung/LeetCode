package dynamic;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        String odd = "babad";
        String even = "abbd";
        System.out.println(longestPalindrome(odd));
        System.out.println(longestPalindrome(even));
        System.out.println(longestPalindromeDP(odd));
        System.out.println(longestPalindromeDP(even));
    }

    public static String longestPalindromeDP(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String odd = palindorme(s, i, i);
            String even = palindorme(s, i, i + 1);
            String curr = odd.length() > even.length() ? odd : even;
            if (curr.length() > longest.length())
                longest = curr;
        }
        return longest;
    }



    private static String palindorme(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
