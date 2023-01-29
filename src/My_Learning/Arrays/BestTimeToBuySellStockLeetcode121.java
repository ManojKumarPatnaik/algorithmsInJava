package My_Learning.Arrays;

public class BestTimeToBuySellStockLeetcode121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
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
