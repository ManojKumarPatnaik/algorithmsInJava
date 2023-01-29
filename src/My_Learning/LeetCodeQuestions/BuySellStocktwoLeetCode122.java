package My_Learning.LeetCodeQuestions;

public class BuySellStocktwoLeetCode122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int netProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				netProfit += (prices[i] - prices[i - 1]);
		}
		return netProfit;
	}

}
