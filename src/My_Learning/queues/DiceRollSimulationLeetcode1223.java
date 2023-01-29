package My_Learning.queues;

public class DiceRollSimulationLeetcode1223 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static final int MOD = 1000000007;

	public int dieSimulator(int n, int[] rollMax) {
		if (n == 0)
			return 0;
		int[][][] dp = new int[n + 1][7][16];
		// initialization
		for (int i = 1; i <= 6; ++i) {
			if (rollMax[i - 1] > 0) {
				dp[1][i][1] = 1;
			}
		}
		for (int x = 2; x <= n; ++x) {
			for (int i = 1; i <= 6; ++i) {
				// if continue to add tail i, make sure consective num of i would less than or
				// equal to rollMax[i-1]
				for (int k = 1; k < rollMax[i - 1]; ++k) {
					dp[x][i][k + 1] = (dp[x][i][k + 1] + dp[x - 1][i][k]) % MOD;
				}
				// if add new tail j that differs from i, so we should jump out i
				for (int j = 1; j <= 6; ++j) {
					if (j == i)
						continue;
					for (int k = 1; k <= rollMax[i - 1]; ++k) {
						dp[x][j][1] = (dp[x][j][1] + dp[x - 1][i][k]) % MOD;
					}
				}
			}
		}
		int num = 0;
		for (int i = 1; i <= 6; ++i) {
			for (int k = 1; k <= 15; ++k) {
				num = (num + dp[n][i][k]) % MOD;
			}
		}
		return num;
	}

}
