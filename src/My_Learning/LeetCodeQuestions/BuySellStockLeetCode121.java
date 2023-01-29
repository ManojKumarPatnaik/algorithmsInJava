package My_Learning.LeetCodeQuestions;

public class BuySellStockLeetCode121 {

	/*
	 * This version include one pair transaction of buy and sell
	 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
	 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
	 * and selling on day 1 is not allowed because you must buy before you sell.
	 * Example 2:
	 * 
	 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no
	 * transactions are done and the max profit = 0.
	 * 
	 */

	// Leetocde daily solution
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = { 7, 1, 5, 3, 6, 4 };

		int finalProfit = maxProfit(prices);
		System.out.println(finalProfit);

	}

	private static int maxProfit(int[] prices) {

		int n = prices.length;
		int finalProfit = 0;
		for (int i = 0; i < n - 1; i++) {
			int currentProfit = 0;
			int currentPrice = prices[i];
			for (int j = i + 1; j < n; j++) {
				int tempProfit = prices[j] - currentPrice;

				currentProfit = max(currentProfit, tempProfit);

			}
			finalProfit = max(currentProfit, finalProfit);

		}
		return finalProfit;
	}

	private static int max(int currentProfit, int tempProfit) {

		return currentProfit > tempProfit ? currentProfit : tempProfit;
	}

	public int maxProfit1(int[] prices) {
		int ans = 0;
		if (prices.length == 0) {
			return ans;
		}
		int bought = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > bought) {
				if (ans < (prices[i] - bought)) {
					ans = prices[i] - bought;
				}
			} else {
				bought = prices[i];
			}
		}
		return ans;
	}

	public int maxProfit2(int[] prices) {
		if (prices.length == 0)
			return 0;
		
		int smallest = prices[0];
		int maxofall = 0;
		
		for (int i = 0; i < prices.length; i++) {
			
			if (prices[i] < smallest)
				smallest = prices[i];
			int profit = prices[i] - smallest;
			maxofall = Math.max(profit, maxofall);
		}
		return maxofall;
	}

}
