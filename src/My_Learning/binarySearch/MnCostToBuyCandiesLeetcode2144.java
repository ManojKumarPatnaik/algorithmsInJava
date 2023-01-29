package My_Learning.binarySearch;

import java.util.Arrays;

public class MnCostToBuyCandiesLeetcode2144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumCost(int[] cost) {
		Arrays.sort(cost);
		int totalcost = 0;
		for (int i = cost.length - 1; i > 0; i -= 3) {
			totalcost += cost[i] + cost[i - 1];
		}
		if (cost.length % 3 == 1)
			totalcost += cost[0];
		return totalcost;
	}
}
