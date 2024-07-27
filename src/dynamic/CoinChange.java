package dynamic;

import java.util.Arrays;

public class CoinChange {
    int numberCoin;

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChangeByDynamic(coins, amount));
        System.out.println(coinChange.coingChangeDP(coins, amount));
    }

    public int coinChangeByDynamic(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangeByGreedy(int[] coins, int amount) {
        numberCoin = 0;

        sortingCoin(coins);
        int currentCoin = coins.length - 1;
        while (currentCoin >= 0) {
            System.out.println("currentCoin = " + currentCoin);
            numberCoin = countFewestCoins(currentCoin, coins, amount);
            if (numberCoin == -1)
                currentCoin--;
            else
                return numberCoin;
        }
        return numberCoin;
    }

    private int countFewestCoins(int currentCoin, int[] coins, int amount) {
        numberCoin = numberCoin + amount / coins[currentCoin];
        int redunantAmount = amount % coins[currentCoin];
        if (amount == 0 && numberCoin == 0)
            return 0;
        if (currentCoin == 0 && redunantAmount > 0)
            return -1;
        if (currentCoin == 0 && redunantAmount == 0)
            return numberCoin;

        return countFewestCoins(currentCoin - 1, coins, redunantAmount);
    }

    private void sortingCoin(int[] coins) {
        int n = coins.length;

        for (int i = 1; i < n; i++) {
            int key = coins[i];
            int j = i - 1;

            while (j >= 0 && coins[j] > key) {
                coins[j + 1] = coins[j];
                j--;
            }

            coins[j + 1] = key;
        }
    }

    private int coingChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
                dp[i] = min;
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
