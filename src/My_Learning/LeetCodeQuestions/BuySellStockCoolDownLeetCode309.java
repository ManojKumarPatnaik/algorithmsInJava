package My_Learning.LeetCodeQuestions;

public class BuySellStockCoolDownLeetCode309 {
	/*
	 * This version include any number of pair transaction of buy and sell with a gap = cool down value
	 * 
	 * Example 1:
	 * 
	 * Input: prices = [7,1,5,3,6,4] Output: 7 Explanation: Buy on day 2 (price = 1)
	 * and sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price =
	 * 3) and sell on day 5 (price = 6), profit = 6-3 = 3. Total profit is 4 + 3 =
	 * 7. Example 2:
	 * 
	 * Input: prices = [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1)
	 * and sell on day 5 (price = 5), profit = 5-1 = 4. Total profit is 4. Example
	 * 3:
	 * 
	 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: There is no way to make a
	 * positive profit, so we never buy the stock to achieve the maximum profit of
	 * 0.
	 */
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = { 7, 1, 5, 3, 6, 4 };

		int finalProfit = maxProfit(prices);
		System.out.println(finalProfit);

	}
	
	private static int maxProfit(int[] prices) {

		if (prices.length == 0 || prices.length == 1)
			return 0;

		int netProfit = 0;
		int coolDown = 1;
		for (int i = 1; i < prices.length; i = i + coolDown) {

			// selling and cooling down for one day
			if (prices[i] > prices[i - 1]) {
				netProfit += (prices[i] - prices[i - 1]);
				coolDown += 1;
			}

			// not selling
			coolDown = 1;
		}
		return netProfit;
	}


	private static int maxProfit2(int[] prices) {

	int sold=Integer.MIN_VALUE,held=Integer.MIN_VALUE,reset=0;
    
    for(int i:prices){
        int presold=sold;
        sold=held+i;
        held=Math.max(held,reset-i);
        reset=Math.max(reset,presold);
    }
    
    
    
 
    return Math.max(sold,reset);
	}
	
	
}
	
