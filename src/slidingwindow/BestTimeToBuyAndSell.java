package slidingwindow;

public class BestTimeToBuyAndSell {

  public static void main(String[] args) {
    int[] prices = { 7, 1, 5, 3, 6, 4 };
    System.out.println(maxProfit(prices));

    System.out.println(maxProfit(new int[] { 3, 2, 6, 5, 0, 3 }));
  }

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int left = 0;
    int right = 1;
    while (right < prices.length) {
      if (prices[left] < prices[right]) {
        maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
      } else {
        left = right;
      }
      right++;
    }
    return maxProfit;
  }
}
