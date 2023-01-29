package My_Learning.maths;

import java.util.Arrays;

public class CoinChangeLeetcode322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int[][] dp;

	public int coinChange(int[] coins, int amount) {
		dp = new int[coins.length][amount + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int ans = fun(coins.length - 1, coins, amount);
		return ans >= (int) Math.pow(10, 9) ? -1 : ans;
		// if(ans >= (int)Math.pow(10,9)) return -1;
	}

	public int fun(int index, int[] coins, int target) {

		// Base condition
		if (index == 0) {
			if (target % coins[0] == 0) {
				return target / coins[0];
			} else {
				return (int) Math.pow(10, 9);
			}
		}

		if (dp[index][target] != -1)
			return dp[index][target];

		int notTaken = 0 + fun(index - 1, coins, target);

		int taken = (int) Math.pow(10, 9);
		if (coins[index] <= target) {
			taken = 1 + fun(index, coins, target - coins[index]); // multiple instance are allowed
		}

		return dp[index][target] = Math.min(taken, notTaken);
	}

}
