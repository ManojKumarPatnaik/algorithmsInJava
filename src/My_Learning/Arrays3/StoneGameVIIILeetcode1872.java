package My_Learning.Arrays3;

public class StoneGameVIIILeetcode1872 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int stoneGameVIII(int[] stones) {
		// find the sum first
		int[] sum = new int[stones.length];
		sum[0] = stones[0];
		for (int i = 1; i < stones.length; i++) {
			sum[i] = sum[i - 1] + stones[i];
		}
		// apply dp
		int[] dp = new int[stones.length];
		dp[stones.length - 1] = sum[stones.length - 1];
		for (int i = stones.length - 2; i >= 0; i--) {
			dp[i] = Math.max(sum[i] - dp[i + 1], dp[i + 1]);
		}
		// alice cannot take only one stone, so it has to be starting from dp[1], not
		// dp[0].
		return dp[1];
	}

}
