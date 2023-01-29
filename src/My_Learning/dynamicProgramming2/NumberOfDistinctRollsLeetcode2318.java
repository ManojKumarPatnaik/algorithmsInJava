package My_Learning.dynamicProgramming2;

public class NumberOfDistinctRollsLeetcode2318 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[][] arr = { {}, { 2, 3, 4, 5, 6 }, { 1, 3, 5 }, { 1, 2, 4, 5 }, { 1, 3, 5 }, { 1, 2, 3, 4, 6 },
			{ 1, 5 } };

	int[][][] dp = new int[10001][7][7];

	int mod = 1000000007;

	public int distinctSequences(int n) {
		if (n == 1)
			return 6;

		int ans = 0;
		for (int i = 1; i <= 6; i++) {
			ans = add(ans, memo(2, n, i, 0));
		}

		return ans;
	}

	public int memo(int roll, int n, int curr, int prev) {
		if (roll > n)
			return 1;

		if (dp[roll][curr][prev] != 0)
			return dp[roll][curr][prev];

		int ans = 0;
		for (int i = 0; i < arr[curr].length; i++) {
			if (arr[curr][i] == prev)
				continue;
			ans = add(ans, memo(roll + 1, n, arr[curr][i], curr));
		}

		return dp[roll][curr][prev] = ans;
	}

	public int add(int a, int b) {
		return ((a % mod) + (b % mod)) % mod;
	}
}
