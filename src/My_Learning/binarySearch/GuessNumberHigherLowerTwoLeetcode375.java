package My_Learning.binarySearch;

public class GuessNumberHigherLowerTwoLeetcode375 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getMoneyAmount(int n) {
		if (n == 1) {
			return 0;
		}
		int[][] dp = new int[n + 1][n + 1];
		for (int jminusi = 1; jminusi < n; jminusi++) {
			for (int i = 0; i + jminusi <= n; i++) {
				int j = i + jminusi;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					dp[i][j] = Math.min(dp[i][j],
							k + Math.max(k - 1 >= i ? dp[i][k - 1] : 0, j >= k + 1 ? dp[k + 1][j] : 0));
				}
			}
		}
		return dp[1][n];
	}
}
