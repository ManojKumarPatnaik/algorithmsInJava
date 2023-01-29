package My_Learning.Arrays3;

public class StoneGameIVLeetcode1510 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean winnerSquareGame(int n) {
		boolean[] dp = new boolean[n + 1];
		for (int i = 1; i <= n; ++i) {
			for (int k = 1; k * k <= i; ++k) {
				if (!dp[i - k * k]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

}
