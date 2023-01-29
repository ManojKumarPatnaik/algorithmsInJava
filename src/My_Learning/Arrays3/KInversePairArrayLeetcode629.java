package My_Learning.Arrays3;

public class KInversePairArrayLeetcode629 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kInversePairs(int n, int k) {
		int mod = 1000000007;
		if (k > n * (n - 1) / 2 || k < 0)
			return 0;
		if (k == 0 || k == n * (n - 1) / 2)
			return 1;
		long[][] dp = new long[n + 1][k + 1];
		dp[2][0] = 1;
		dp[2][1] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= Math.min(k, i * (i - 1) / 2); j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				if (j >= i)
					dp[i][j] -= dp[i - 1][j - i];
				dp[i][j] = (dp[i][j] + mod) % mod;
			}
		}
		return (int) dp[n][k];
	}

}
