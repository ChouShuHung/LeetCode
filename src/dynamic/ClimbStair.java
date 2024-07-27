package dynamic;

import java.util.Map;

public class ClimbStair {

    public static void main(String[] args) {

        System.out.println(climbStairs(4));
        System.out.println(climbTabulation(5));
    }

    private static int climbStairs(int n) {
        return climbTabulation(n);
    }

    private static int climbRecursive(int n) {
        if (n == 0 || n == 1)
            return 1;

        return climbRecursive(n - 1) + climbRecursive(n - 2);
    }

    private static int climbMemoRecursive(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1)
            return 1;
        if (!memo.containsKey(n)) {
            memo.put(n, climbMemoRecursive(n - 1, memo) + climbMemoRecursive(n - 2, memo));
        }

        return memo.get(n);
    }

    private static int climbTabulation(int n) {
        // DP - bottom up
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.println(STR."dp[\{i}]=\{dp[i]}");
        }
        return dp[n];
    }

    private static int climbSpaceOptimization(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
