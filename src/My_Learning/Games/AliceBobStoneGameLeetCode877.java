package My_Learning.Games;

public class AliceBobStoneGameLeetCode877 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean stoneGame2(int[] piles) {
		return true;
	}

	public boolean stoneGame(int[] p) {
		int n = p.length;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++)
			dp[i][i] = p[i];
		for (int d = 1; d < n; d++)
			for (int i = 0; i < n - d; i++)
				dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
		return dp[0][n - 1] > 0;

	}

}
